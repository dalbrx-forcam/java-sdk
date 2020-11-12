package com.forcam.na.ffwebservices.client.oauth;

import com.forcam.na.ffwebservices.client.oauth.endpoint.FFauthTokenEndpoint;
import com.forcam.na.ffwebservices.client.oauth.endpoint.OAuthService;
import com.forcam.na.ffwebservices.client.oauth.endpoint.Token;
import okhttp3.Credentials;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Call;

import java.io.IOException;

public class ForceOAuthInterceptorAuthenticator implements IOAuthInterceptorAuthenticator {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------

    /** LOGGER */
    private static final Logger LOGGER = LoggerFactory.getLogger(ForceOAuthInterceptorAuthenticator.class);

    /** A parameter for the authorization header. */
    private static final String HEADER_AUTHORIZATION = "Authorization";

    /** Max amount of authentication retries */
    private static final int RETRYS = 3;

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The forcam api client id */
    private String mClientId;

    /** The forcam api client secret */
    private String mSecret;

    /** The current oauth token */
    private Token mCurrentToken;

    /** The OAuthService */
    private OAuthService mOAuthService;

    private FFauthTokenEndpoint mFFauthTokenEndpoint;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance of the authenticator.
     *
     * @param oAuthService The authorization service.
     * @param clientId     The client id.
     * @param clientSecret The client secret.
     */
    public ForceOAuthInterceptorAuthenticator(OAuthService oAuthService, String clientId, String clientSecret) {
        mClientId = clientId;
        mSecret = clientSecret;
        mOAuthService = oAuthService;
    }

    public ForceOAuthInterceptorAuthenticator(FFauthTokenEndpoint ffauthTokenEndpoint, String clientId, String clientSecret) {
        mClientId = clientId;
        mSecret = clientSecret;
        mFFauthTokenEndpoint = ffauthTokenEndpoint;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public Response intercept(Chain chain) throws IOException {
        final Request request = chain.request();
        LOGGER.trace("Intercepting {}", request.url());
        final String authorizationHeader = this.getAuthorizationHeader();
        final Request authRequest = request
            .newBuilder()
            .header(HEADER_AUTHORIZATION, authorizationHeader)
            .build();
        return chain.proceed(authRequest);
    }

    @Override
    public Request authenticate(Route route, Response response) throws IOException {
        final Call<Token> tokenCall;

        if (mFFauthTokenEndpoint == null) {
            tokenCall = authenticateViaWebservices(response);
        } else {
            tokenCall = authenticateViaFFauth(response);
        }

        if (this.responseCount(response) >= RETRYS) {
            LOGGER.warn("We failed {} times. Giving up.", RETRYS);
            return null; // If we've failed 3 times, give up.
        }

        retrofit2.Response<Token> tokenResponse = tokenCall.execute();
        mCurrentToken = tokenResponse.body();

        LOGGER.debug("Received new ticket for clientId {}: {}", mClientId, mCurrentToken);

        return response
            .request()
            .newBuilder()
            .header(HEADER_AUTHORIZATION, this.getAuthorizationHeader())
            .build();
    }

    Call<Token> authenticateViaFFauth(Response response) {
        final Call<Token> tokenCall = mFFauthTokenEndpoint.accessToken(mClientId, mSecret, "client_credentials", "read write");

        LOGGER.trace("Authentication via ffauth - Using clientId {}", mClientId);

        if (tokenCall
            .request()
            .url()
            .equals(response
                        .request()
                        .url())) {
            LOGGER.warn("We already failed with these credentials: {}",
                        response
                            .request()
                            .header(HEADER_AUTHORIZATION));
            return null; // If we already failed with these credentials, don't retry.
        }

        return tokenCall;
    }

    Call<Token> authenticateViaWebservices(Response response) {
        final String credentials = Credentials.basic(mClientId, mSecret);

        LOGGER.trace("Authentication via ffwebservices - Using clientId {} -> cred: {}", mClientId, credentials);

        if (credentials.equals(response
                                   .request()
                                   .header(HEADER_AUTHORIZATION))) {
            LOGGER.warn("We already failed with these credentials: {}",
                        response
                            .request()
                            .header(HEADER_AUTHORIZATION));
            return null; // If we already failed with these credentials, don't retry.
        }

        return mOAuthService.oauthToken(credentials, "client_credentials", "read write");
    }

    /**
     * Builds the authorization header using the current token.
     *
     * @return The Authorization header.
     */
    private String getAuthorizationHeader() {
        if (mCurrentToken == null) {
            return StringUtils.EMPTY;
        }
        return mCurrentToken.getTokenType() + " " + mCurrentToken.getAccessToken();
    }

    /**
     * Checks how many times we got the same response.
     *
     * @param response The response.
     * @return How many times this response has been returned.
     */
    private int responseCount(Response response) {
        Response currentResponse = response;

        int result = 1;
        while ((currentResponse = currentResponse.priorResponse()) != null) {
            result++;
        }
        return result;
    }

}
