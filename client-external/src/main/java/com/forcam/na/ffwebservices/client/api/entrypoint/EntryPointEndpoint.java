////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 25.01.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.entrypoint;

import com.forcam.na.ffwebservices.client.api.HALWSModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/**
 * An interface with methods for creating calls that can be sent to the server.
 */
public interface EntryPointEndpoint {

    /**
     * Creates a call that can be sent to the server.
     *
     * @return A call that can be sent to the server.
     */
    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @GET(" ")
    Call<HALWSModel> getEntryPoint();
}