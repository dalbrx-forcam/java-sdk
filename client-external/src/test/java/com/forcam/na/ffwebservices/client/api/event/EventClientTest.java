////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 03.09.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.event;

import com.forcam.na.ffwebservices.client.api.AbstractOpenAPIMockTest;
import com.forcam.na.ffwebservices.client.api.config.GuiceTestRunner;
import com.forcam.na.ffwebservices.client.api.exception.ForceAPIException;
import com.forcam.na.ffwebservices.model.event.EventWSModel;
import org.junit.*;
import org.junit.rules.*;
import org.junit.runner.*;

import java.io.IOException;

/**
 * Tests for the class {@link EventClient}.
 */
@RunWith(GuiceTestRunner.class)
public class EventClientTest extends AbstractOpenAPIMockTest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Helper for test exceptions and messages. */
    @Rule
    public ExpectedException mExpectedException = ExpectedException.none();

    /** The event client. */
    private IEventClient mEventClient;

    // ------------------------------------------------------------------------
    // constructor
    // ------------------------------------------------------------------------

    public EventClientTest() {
        mEventClient = mBridgeAPIComponent.eventClient();
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    /**
     * Tests posting event while server is down.
     *
     * @throws IOException       When unable to shutdown the server.
     * @throws ForceAPIException When unable to post event.
     */
    @Test
    public void postEventShutdown() throws IOException, ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final PostEventRequest request = new PostEventRequest(new EventWSModel());
        mMockWebServer.shutdown();
        mExpectedException.expect(ForceAPIException.class);
        mExpectedException.expectMessage("Unable to execute call using request: " + request);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mEventClient.postEvent(request);
    }
}