////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 10.10.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.machinestatedetail;

import com.forcam.na.ffwebservices.client.api.AbstractOpenAPIMockTest;
import com.forcam.na.ffwebservices.client.api.config.GuiceTestRunner;
import com.forcam.na.ffwebservices.client.api.exception.ForceAPIException;
import com.forcam.na.ffwebservices.client.api.machinestatedetail.request.GetMachineStateDetailsRequest;
import com.forcam.na.ffwebservices.client.api.pagination.response.Page;
import com.forcam.na.ffwebservices.model.machinestatedetail.MachineStateDetailResponse;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.*;
import org.junit.rules.*;
import org.junit.runner.*;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Tests for the class {@link MachineStateDetailClient}.
 */
@RunWith(GuiceTestRunner.class)
public class MachineStateDetailClientTest extends AbstractOpenAPIMockTest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Helper for test exceptions and messages. */
    @Rule
    public ExpectedException mExpectedException = ExpectedException.none();

    /** The machine state detail client. */
    private IMachineStateDetailClient mMachineStateDetailClient;

    // ------------------------------------------------------------------------
    // constructor
    // ------------------------------------------------------------------------

    public MachineStateDetailClientTest() {
        mMachineStateDetailClient = mBridgeAPIComponent.machineStateDetailClient();
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    /**
     * Test for the method {@link MachineStateDetailClient#getMachineStateDetails(GetMachineStateDetailsRequest)}.
     *
     * @throws ForceAPIException    When unable to get machine state details.
     * @throws InterruptedException When unable to take the request from the server.
     * @throws IOException          When unable to read the JSON file.
     * @throws URISyntaxException   When unable to create a URI of the JSON file.
     */
    @Test
    public void getMachineStateDetails() throws ForceAPIException, InterruptedException, IOException, URISyntaxException {
        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getMachineStateDetails.json")));

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final int limit = 3;
        final int offset = 0;
        final GetMachineStateDetailsRequest request = new GetMachineStateDetailsRequest();
        request
            .setLimit(limit)
            .setOffset(offset);
        request
            .embed()
            .description(true)
            .shortDescription(true);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final Page<MachineStateDetailResponse> page = mMachineStateDetailClient.getMachineStateDetails(request);

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
                               .getResponse()
                               .getElements()
                               .isEmpty());
        Assert.assertNotNull(page
                                 .getResponse()
                                 .getElements()
                                 .get(0)
                                 .getProperties());
    }

    /**
     * Tests getting machine state details while server is down.
     *
     * @throws IOException       When unable to shutdown the server.
     * @throws ForceAPIException When unable to get machine state details.
     */
    @Test
    public void getMachineStateDetailsShutdown() throws IOException, ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final GetMachineStateDetailsRequest request = new GetMachineStateDetailsRequest();
        mMockWebServer.shutdown();
        mExpectedException.expect(ForceAPIException.class);
        mExpectedException.expectMessage("Unable to execute call using request: " + request);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mMachineStateDetailClient.getMachineStateDetails(request);
    }
}