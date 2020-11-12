////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 03.09.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.integration;

import com.forcam.na.ffwebservices.client.api.event.EventClient;
import com.forcam.na.ffwebservices.client.api.event.PostEventRequest;
import com.forcam.na.ffwebservices.client.api.exception.ForceAPIException;
import com.forcam.na.ffwebservices.model.event.EventObjectType;
import com.forcam.na.ffwebservices.model.event.EventType;
import com.forcam.na.ffwebservices.model.event.EventWSModel;
import org.junit.*;

/**
 * Integration tests for the class {@link EventClient}.
 */
public class EventClientIntegrationTest extends AbstractOpenAPIIntegrationTest {

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    /**
     * Test for the method {@link EventClient#postEvent(PostEventRequest)}.
     *
     * @throws ForceAPIException When unable to post event.
     */
    @Test
    public void testPostEvent() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final EventWSModel eventData = new EventWSModel();

        eventData.setData(null);
        eventData.setEventName("EventName");
        eventData.setEventType(EventType.COMMAND);
        eventData.setObjectId("ObjectId");
        eventData.setObjectType(EventObjectType.OPERATION);

        final PostEventRequest request = new PostEventRequest(eventData);
        mEventClient.postEvent(request);
    }
}