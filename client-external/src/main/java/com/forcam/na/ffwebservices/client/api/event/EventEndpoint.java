////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 03.09.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.event;

import com.forcam.na.ffwebservices.model.event.EventWSModel;
import com.forcam.na.ffwebservices.model.event.IEventPaths;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * An interface with methods for creating calls that can be sent to the server.
 */
public interface EventEndpoint {

    /**
     * Creates a call that can be sent to the server.
     *
     * @param eventData The event data.
     * @return A call that can be sent to the server.
     */
    @Headers({"Content-Type: application/json"} )
    @POST(IEventPaths.EVENTS)
    Call<Void> postEvent(
        @Body
            EventWSModel eventData);
}