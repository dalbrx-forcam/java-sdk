////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 23.10.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.forcam.na.ffwebservices.client.BridgeAPI;
import com.forcam.na.ffwebservices.client.language.LocaleInterceptor;
import com.forcam.na.ffwebservices.client.oauth.ForceOAuthInterceptorAuthenticator;
import com.forcam.na.ffwebservices.client.oauth.IOAuthInterceptorAuthenticator;
import com.forcam.na.ffwebservices.client.oauth.endpoint.FFauthTokenEndpoint;
import dagger.Module;
import dagger.Provides;
import okhttp3.ConnectionPool;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import javax.inject.Singleton;
import java.util.Collection;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/**
 * The Force API module.
 */
@Module
public class ForceAPIModule {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------

    /** Logger for class. */
    private static final HttpLoggingInterceptor.Logger LOGGER_FUNCTION = BridgeAPI.LOGGER::info;

    private static final String SECRET_KEY = "HjptRVEJp6qpkG0bM1Um";

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The id of the client. */
    private final String mClientId;

    /** The secret of the client. */
    private final String mClientSecret;

    /** The base of the URL. */
    private final String mBaseUrl;

    private final String mTokenBaseUrl;

    /** The locale of the client. */
    private final Locale mLocale;

    /** The authentication service. */
    private FFauthTokenEndpoint mOAuthService;

    /** The setting whether to trust any unverified certificate */
    private boolean mTrustAnySSL;

    private boolean mEncryptedSecret;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    public ForceAPIModule(String baseUrl, Locale locale, String clientId, String clientSecret, boolean trustAnySSL, boolean encryptedSecret,
                          String tokenBaseUrl) {
        mBaseUrl = baseUrl;
        mLocale = locale;
        mClientId = clientId;
        mClientSecret = clientSecret;
        mTrustAnySSL = trustAnySSL;
        mTokenBaseUrl = tokenBaseUrl;
        mTrustAnySSL = trustAnySSL;
        mEncryptedSecret = encryptedSecret;

        mOAuthService = this.createAuthService();
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Provides
    @Singleton
    public ObjectMapper objectMapper() {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.registerModule(new JavaTimeModule());
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper;
    }


    /**
     * Returns a new initialized retrofit client.
     *
     * @param client The {@link OkHttpClient}.
     * @param mapper The {@link ObjectMapper}.
     * @return The retrofit client.
     */
    @Provides
    @Singleton
    public Retrofit retrofit(OkHttpClient client, ObjectMapper mapper) {
        return new Retrofit.Builder()
            .baseUrl(mBaseUrl + "api/v3/")
            .client(client)
            .addConverterFactory(JacksonConverterFactory.create(mapper))
            .addConverterFactory(RequestConverterFactory.create())
            .build();
    }

    @Provides
    @Singleton
    public OkHttpClient httpClient(Collection<Interceptor> interceptors) {
        final HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(LOGGER_FUNCTION);
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        final LocaleInterceptor localeInterceptor = new LocaleInterceptor(mLocale);

        final String secret;
        if (mEncryptedSecret) {
            secret = AES.decrypt(mClientSecret, SECRET_KEY);
        } else {
            secret = mClientSecret;
        }

        final IOAuthInterceptorAuthenticator authenticator = new ForceOAuthInterceptorAuthenticator(mOAuthService, mClientId, secret);

        final ConnectionPool connectionPool = new ConnectionPool(5, 10, TimeUnit.SECONDS);

        final OkHttpClient.Builder builder = new OkHttpClient.Builder()
            .connectionPool(connectionPool)
            .addInterceptor(loggingInterceptor)
            .addInterceptor(localeInterceptor)
            .addInterceptor(authenticator)
            .authenticator(authenticator)
            .readTimeout(1, TimeUnit.MINUTES);

        if (mTrustAnySSL) {
            UnsafeOkHttpClient.allowAnyCertificate(builder);
        }

        interceptors.forEach(builder::addInterceptor);

        return builder.build();
    }

    /**
     * Create an authentication service.
     *
     * @return The authentication service.
     */
    private FFauthTokenEndpoint createAuthService() {
        final HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(LOGGER_FUNCTION);
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        final ConnectionPool connectionPool = new ConnectionPool(5, 10, TimeUnit.SECONDS);

        final OkHttpClient.Builder builder = new OkHttpClient.Builder()
            .connectionPool(connectionPool)
            .addInterceptor(loggingInterceptor)
            .readTimeout(1, TimeUnit.MINUTES);
        if (mTrustAnySSL) {
            UnsafeOkHttpClient.allowAnyCertificate(builder);
        }
        final OkHttpClient loggingClient = builder.build();
        final Retrofit loggingRetrofit = new Retrofit.Builder()
            .baseUrl(mTokenBaseUrl)
            .client(loggingClient)
            .addConverterFactory(JacksonConverterFactory.create())
            .build();

        return loggingRetrofit.create(FFauthTokenEndpoint.class);
    }

}