////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 08.11.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.machine;

import com.forcam.na.ffwebservices.client.api.AbstractOpenAPIMockTest;
import com.forcam.na.ffwebservices.client.api.config.GuiceTestRunner;
import com.forcam.na.ffwebservices.client.api.exception.ForceAPIException;
import com.forcam.na.ffwebservices.client.api.machine.request.GetMachinesRequest;
import com.forcam.na.ffwebservices.client.api.pagination.response.Page;
import com.forcam.na.ffwebservices.model.machine.MachineResponse;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.*;
import org.junit.rules.*;
import org.junit.runner.*;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Tests for the class {@link MachineClient}.
 */
@RunWith(GuiceTestRunner.class)
public class MachineClientTest extends AbstractOpenAPIMockTest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Helper for test exceptions and messages. */
    @Rule
    public ExpectedException mExpectedException = ExpectedException.none();

    /** The machine client. */
    private IMachineClient mMachineClient;

    // ------------------------------------------------------------------------
    // constructor
    // ------------------------------------------------------------------------

    public MachineClientTest() {
        mMachineClient = mBridgeAPIComponent.machineClient();
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    /**
     * Test for the method {@link MachineClient#getMachines(GetMachinesRequest)}.
     *
     * @throws ForceAPIException    When unable to get machines.
     * @throws InterruptedException When unable to take the request from the server.
     * @throws IOException          When unable to read the JSON file.
     * @throws URISyntaxException   When unable to create a URI of the JSON file.
     */
    @Test
    public void getMachines() throws ForceAPIException, InterruptedException, IOException, URISyntaxException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getMachines.json")));
        final int limit = 3;
        final int offset = 0;
        final GetMachinesRequest request = new GetMachinesRequest();
        request
            .setLimit(limit)
            .setOffset(offset);
        request
            .embed()
            .description(true)
            .erpContext(true)
            .workplace(true);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final Page<MachineResponse> page = mMachineClient.getMachines(request);

        final RecordedRequest recordedRequest = mMockWebServer.takeRequest();
        final String requestQuery = recordedRequest
            .getRequestUrl()
            .query();
        Assert.assertNotNull(requestQuery);
        Assert.assertTrue(requestQuery.contains("embed=" + request
            .embed()
            .toString()));
        Assert.assertTrue(requestQuery.contains("limit=" + limit));
        Assert.assertTrue(requestQuery.contains("offset=" + offset));

        Assert.assertNotNull(page);
        Assert.assertNotNull(page
                                 .getResponse()
                                 .getPaginationLinks());
        Assert.assertNotNull(page
                                 .getResponse()
                                 .getPaginationLinks()
                                 .getFirst());
        Assert.assertNotNull(page
                                 .getResponse()
                                 .getPaginationLinks()
                                 .getSelf());
        Assert.assertNotNull(page
                                 .getResponse()
                                 .getPaginationLinks()
                                 .getLast());
        Assert.assertFalse(page
                               .getElements()
                               .isEmpty());
        Assert.assertNotNull(page
                                 .getElements()
                                 .get(0)
                                 .getProperties());
    }

    /**
     * Tests getting machines while server is down.
     *
     * @throws IOException       When unable to shutdown the server.
     * @throws ForceAPIException When unable to get machines.
     */
    @Test
    public void getMachinesShutdown() throws IOException, ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final GetMachinesRequest request = new GetMachinesRequest();
        mMockWebServer.shutdown();
        mExpectedException.expect(ForceAPIException.class);
        mExpectedException.expectMessage("Unable to execute call using request: " + request);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mMachineClient.getMachines(request);
    }
}