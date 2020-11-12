package com.forcam.na.ffwebservices.client.oauth.endpoint;


import retrofit2.Call;
import retrofit2.http.*;

/**
 *
 * Created: 16.01.2017
 *
 * @author David Albrecht
 */
public interface OAuthService{

    /**
     * Creates a Call that will be sent to the server.
     *
     * @param authorization The authorization.
     * @param grantType The grant type.
     * @param scope The scope.
     * @return A call that will be sent to the server.
     */
    @FormUrlEncoded
    @Headers("Accept: */*")
    @POST("oauth/token")
    Call<Token> oauthToken(
        @Header("Authorization")
        String authorization,
        @Field("grant_type")
        String grantType,
        @Field("scope")
        String scope);

}
