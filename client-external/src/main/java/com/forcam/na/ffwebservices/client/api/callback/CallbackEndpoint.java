////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 31.08.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.callback;

import com.forcam.na.ffwebservices.client.api.HALCollectionWSModel;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.model.IRequestAndQueryParams;
import com.forcam.na.ffwebservices.model.callback.CreateCallbackPropertiesWSModel;
import com.forcam.na.ffwebservices.model.callback.ICallbackPaths;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * An interface with methods for creating calls that can be sent to the server.
 */
public interface CallbackEndpoint {

    /**
     * Creates a call that can be sent to the server.
     *
     * @param limit  The limit.
     * @param offset The offset.
     * @return A call that can be sent to the server.
     */
    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @GET(ICallbackPaths.CALLBACKS)
    Call<HALCollectionWSModel> getCallbacks(
        @Query(IRequestAndQueryParams.LIMIT)
            int limit,
        @Query(IRequestAndQueryParams.OFFSET)
            int offset);

    /**
     * Creates a call that can be sent to the server.
     *
     * @param callbackData The callback data.
     * @return A call that can be sent to the server.
     */
    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @POST(ICallbackPaths.CALLBACKS)
    Call<HALWSModel> createCallback(
        @Body
            CreateCallbackPropertiesWSModel callbackData);

    /**
     * Creates a call that can be sent to the server.
     *
     * @param callbackId The callback ID.
     * @return A call that can be sent to the server.
     */
    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @DELETE(ICallbackPaths.CALLBACKS + "/{" + IRequestAndQueryParams.UUID + "}")
    Call<Void> deleteCallback(
        @Path(IRequestAndQueryParams.UUID) String callbackId);
}