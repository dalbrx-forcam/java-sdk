////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 03.09.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.event;

import com.forcam.na.ffwebservices.client.api.AbstractClient;
import com.forcam.na.ffwebservices.client.api.exception.ForceAPIException;
import retrofit2.Call;

import javax.inject.Inject;

/**
 * Posts events.
 */
public class EventClient extends AbstractClient implements IEventClient {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The event endpoint. */
    private final EventEndpoint mEventEndpoint;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     *
     * @param eventEndpoint Event endpoint.
     */
    @Inject
    public EventClient(EventEndpoint eventEndpoint) {
        mEventEndpoint = eventEndpoint;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public void postEvent(PostEventRequest request) throws ForceAPIException {
        final Call<Void> call = mEventEndpoint.postEvent(request.getEventData());
        this.executeCall(request, call);
    }
}