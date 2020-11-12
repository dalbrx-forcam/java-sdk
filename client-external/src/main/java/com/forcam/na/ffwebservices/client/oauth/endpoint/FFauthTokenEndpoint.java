////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 31.03.2020.
//
// Copyright (c) 2006 - 2020 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.oauth.endpoint;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.Query;

import java.util.Map;

/**
 * Provides a method to request a oauth2 token from ffauth.
 */
public interface FFauthTokenEndpoint {

    @GET("oauth2.0/accessToken")
    Call<Token> accessToken(
        @Query("client_id")
            String clientId,
        @Query("client_secret")
            String clientSecret,
        @Query("grant_type")
            String grantType,
        @Query("scope")
            String scope);

    @FormUrlEncoded
    @POST("oauth2.0/accessToken")
    Call<ResponseBody> accessToken(
        @HeaderMap
            Map<String, String> headers,
        @FieldMap
            Map<String, String> fields);

}
