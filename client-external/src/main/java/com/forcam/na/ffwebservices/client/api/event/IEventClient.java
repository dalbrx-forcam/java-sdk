////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 03.09.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.event;

import com.forcam.na.ffwebservices.client.api.exception.ForceAPIException;

/**
 * Provides a method to post an event.
 */
public interface IEventClient {

    /**
     * Sends a post request to the server.
     *
     * @param request A collection of parameters.
     * @throws ForceAPIException When unable to post event.
     */
    void postEvent(PostEventRequest request) throws ForceAPIException;
}