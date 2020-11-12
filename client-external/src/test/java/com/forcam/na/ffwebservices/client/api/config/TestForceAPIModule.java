////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 24.10.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.forcam.na.ffwebservices.client.BridgeAPI;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.mockwebserver.MockWebServer;
import org.mockito.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import javax.inject.Singleton;
import java.util.concurrent.TimeUnit;

/**
 * The test Force API module.
 */
@Module
public class TestForceAPIModule {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------

    /** Logger for class. */
    private static final Logger LOGGER = LoggerFactory.getLogger(TestForceAPIModule.class);

    private static final HttpLoggingInterceptor.Logger LOGGER_FUNCTION = msg -> {
        if (BridgeAPI.LOGGER.isTraceEnabled()) {
            LOGGER.trace(msg);
        } else if (BridgeAPI.LOGGER.isDebugEnabled()) {
            LOGGER.debug(msg);
        } else if (BridgeAPI.LOGGER.isInfoEnabled()) {
            LOGGER.info(msg);
        } else {
            LOGGER.warn(msg);
        }
    };

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

    @Provides
    @Singleton
    public Retrofit retrofit(MockWebServer mockWebServer, ObjectMapper mapper) {

        final HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(LOGGER_FUNCTION);
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .readTimeout(100, TimeUnit.MILLISECONDS)
            .connectTimeout(100, TimeUnit.MILLISECONDS)
            .addInterceptor(loggingInterceptor)
            .build();

        return new Retrofit.Builder()
            .baseUrl(mockWebServer
                         .url("")
                         .toString())
            .client(okHttpClient)
            .addConverterFactory(JacksonConverterFactory.create(mapper))
            .build();
    }

    @Provides
    @Singleton
    public MockWebServer mockWebServer() {
        return new MockWebServer();
    }

    @Provides
    OkHttpClient httpClient() {
        return Mockito.mock(OkHttpClient.class);
    }
}