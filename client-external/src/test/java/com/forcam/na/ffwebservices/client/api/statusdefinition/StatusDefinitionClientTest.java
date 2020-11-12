////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 27.09.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.statusdefinition;

import com.forcam.na.ffwebservices.client.api.AbstractOpenAPIMockTest;
import com.forcam.na.ffwebservices.client.api.config.GuiceTestRunner;
import com.forcam.na.ffwebservices.client.api.exception.ForceAPIException;
import com.forcam.na.ffwebservices.client.api.pagination.request.CollectionRequest;
import com.forcam.na.ffwebservices.client.api.pagination.response.Page;
import com.forcam.na.ffwebservices.client.statusdefinition.IStatusDefinitionClient;
import com.forcam.na.ffwebservices.client.statusdefinition.StatusDefinitionClient;
import com.forcam.na.ffwebservices.model.statusdefinition.StatusDefinitionResponse;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.*;
import org.junit.rules.*;
import org.junit.runner.*;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Tests for the class {@link StatusDefinitionClient}.
 */
@RunWith(GuiceTestRunner.class)
public class StatusDefinitionClientTest extends AbstractOpenAPIMockTest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Helper for test exceptions and messages. */
    @Rule
    public ExpectedException mExpectedException = ExpectedException.none();

    /** The status definition client. */
    private IStatusDefinitionClient mStatusDefinitionClient;

    // ------------------------------------------------------------------------
    // constructor
    // ------------------------------------------------------------------------

    public StatusDefinitionClientTest() {
        mStatusDefinitionClient = mBridgeAPIComponent.statusDefinitionClient();
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    /**
     * Test for the method {@link StatusDefinitionClient#getMachineStates(CollectionRequest)}.
     *
     * @throws ForceAPIException    When unable to get status definitions.
     * @throws InterruptedException When unable to take the request from the server.
     * @throws IOException          When unable to read the JSON file.
     * @throws URISyntaxException   When unable to create a URI of the JSON file.
     */
    @Test
    public void testGetMachineStates() throws ForceAPIException, InterruptedException, IOException, URISyntaxException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getMachineStates.json")));
        final int limit = 3;
        final int offset = 0;
        final CollectionRequest params = new CollectionRequest();
        params.setLimit(limit);
        params.setOffset(offset);

        final Page<StatusDefinitionResponse> response = mStatusDefinitionClient.getMachineStates(params);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final RecordedRequest recordedRequest = mMockWebServer.takeRequest();
        final String requestQuery = recordedRequest
            .getRequestUrl()
            .query();
        Assert.assertNotNull(requestQuery);
        Assert.assertTrue(requestQuery.contains("limit=" + limit));
        Assert.assertTrue(requestQuery.contains("offset=" + offset));

        Assert.assertNotNull(response);
        Assert.assertNotNull(response
                                 .getResponse()
                                 .getPaginationLinks());
        Assert.assertNotNull(response
                                 .getResponse()
                                 .getPaginationLinks()
                                 .getFirst());
        Assert.assertNotNull(response
                                 .getResponse()
                                 .getPaginationLinks()
                                 .getSelf());
        Assert.assertNotNull(response
                                 .getResponse()
                                 .getPaginationLinks()
                                 .getLast());
        Assert.assertFalse(response
                               .getElements()
                               .isEmpty());
        Assert.assertNotNull(response
                                 .getElements()
                                 .get(0)
                                 .getProperties());
    }

    /**
     * Test for the method {@link StatusDefinitionClient#getOperationProductionStates(CollectionRequest)} (CollectionRequest)}.
     *
     * @throws ForceAPIException    When unable to get status definitions.
     * @throws InterruptedException When unable to take the request from the server.
     * @throws IOException          When unable to read the JSON file.
     * @throws URISyntaxException   When unable to create a URI of the JSON file.
     */
    @Test
    public void testGetOperationProductionStates() throws ForceAPIException, InterruptedException, IOException, URISyntaxException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getOperationProductionStates.json")));
        final int limit = 3;
        final int offset = 0;
        final CollectionRequest params = new CollectionRequest();
        params.setLimit(limit);
        params.setOffset(offset);

        final Page<StatusDefinitionResponse> response = mStatusDefinitionClient.getOperationProductionStates(params);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final RecordedRequest recordedRequest = mMockWebServer.takeRequest();
        final String requestQuery = recordedRequest
            .getRequestUrl()
            .query();
        Assert.assertNotNull(requestQuery);
        Assert.assertTrue(requestQuery.contains("limit=" + limit));
        Assert.assertTrue(requestQuery.contains("offset=" + offset));

        Assert.assertNotNull(response);
        Assert.assertNotNull(response
                                 .getResponse()
                                 .getPaginationLinks());
        Assert.assertNotNull(response
                                 .getResponse()
                                 .getPaginationLinks()
                                 .getFirst());
        Assert.assertNotNull(response
                                 .getResponse()
                                 .getPaginationLinks()
                                 .getSelf());
        Assert.assertNotNull(response
                                 .getResponse()
                                 .getPaginationLinks()
                                 .getLast());
        Assert.assertFalse(response
                               .getElements()
                               .isEmpty());
        Assert.assertNotNull(response
                                 .getElements()
                                 .get(0)
                                 .getProperties());
    }

    /**
     * Test for the method {@link StatusDefinitionClient#getPersonnelStates(CollectionRequest)}.
     *
     * @throws ForceAPIException    When unable to get status definitions.
     * @throws InterruptedException When unable to take the request from the server.
     * @throws IOException          When unable to read the JSON file.
     * @throws URISyntaxException   When unable to create a URI of the JSON file.
     */
    @Test
    public void testGetPersonnelStates() throws ForceAPIException, InterruptedException, IOException, URISyntaxException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getPersonnelStates.json")));
        final int limit = 3;
        final int offset = 0;
        final CollectionRequest params = new CollectionRequest();
        params.setLimit(limit);
        params.setOffset(offset);

        final Page<StatusDefinitionResponse> page = mStatusDefinitionClient.getPersonnelStates(params);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final RecordedRequest recordedRequest = mMockWebServer.takeRequest();
        final String requestQuery = recordedRequest
            .getRequestUrl()
            .query();
        Assert.assertNotNull(requestQuery);
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
}