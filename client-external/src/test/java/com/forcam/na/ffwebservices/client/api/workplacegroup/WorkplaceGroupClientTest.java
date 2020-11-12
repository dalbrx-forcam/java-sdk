////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 04.12.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.workplacegroup;

import com.forcam.na.ffwebservices.client.api.AbstractOpenAPIMockTest;
import com.forcam.na.ffwebservices.client.api.config.GuiceTestRunner;
import com.forcam.na.ffwebservices.client.api.exception.ForceAPIException;
import com.forcam.na.ffwebservices.client.api.pagination.response.Page;
import com.forcam.na.ffwebservices.client.api.workplacegroup.request.*;
import com.forcam.na.ffwebservices.client.api.workplacegroup.response.WorkplaceGroupSetupTransitionsResponse;
import com.forcam.na.ffwebservices.model.workplacegroup.WorkplaceGroupManufacturingVariantRuleResponse;
import com.forcam.na.ffwebservices.model.workplacegroup.WorkplaceGroupSetupTransitionRuleResponse;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.*;
import org.junit.rules.*;
import org.junit.runner.*;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Tests for the class {@link WorkplaceGroupClient}.
 */
@RunWith(GuiceTestRunner.class)
public class WorkplaceGroupClientTest extends AbstractOpenAPIMockTest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Helper for test exceptions and messages. */
    @Rule
    public ExpectedException mExpectedException = ExpectedException.none();

    /** The workplace group client. */
    private IWorkplaceGroupClient mWorkplaceGroupClient;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    public WorkplaceGroupClientTest() {
        mWorkplaceGroupClient = mBridgeAPIComponent.workplaceGroupClient();
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    /**
     * Test for the method {@link WorkplaceGroupClient#getSetupTransitions(GetWorkplaceGroupSetupTransitionsRequest)}.
     *
     * @throws ForceAPIException    When unable to get workplace group setup transitions.
     * @throws InterruptedException When unable to take the request from the server.
     * @throws IOException          When unable to read the JSON file.
     * @throws URISyntaxException   When unable to create a URI of the JSON file.
     */
    @Test
    public void getSetupTransitions() throws ForceAPIException, InterruptedException, IOException, URISyntaxException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getWorkplaceGroupSetupTransitions.json")));
        final int limit = 2;
        final int offset = 0;
        final GetWorkplaceGroupSetupTransitionsRequest request = new GetWorkplaceGroupSetupTransitionsRequest("workplaceGroupId");
        request
            .setLimit(limit)
            .setOffset(offset);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final WorkplaceGroupSetupTransitionsResponse response = mWorkplaceGroupClient.getSetupTransitions(request);

        final RecordedRequest recordedRequest = mMockWebServer.takeRequest();
        final String requestQuery = recordedRequest
            .getRequestUrl()
            .query();
        Assert.assertNotNull(requestQuery);
        Assert.assertTrue(requestQuery.contains("limit=" + limit));
        Assert.assertTrue(requestQuery.contains("offset=" + offset));

        Assert.assertNotNull(response);
        Assert.assertNotNull(response
                                 .getProperties()
                                 .getCreationDate());
        Assert.assertNotNull(response
                                 .getPaginationLinks()
                                 .getFirst());
        Assert.assertNotNull(response.getPagination());
        Assert.assertFalse(response
                               .getElements()
                               .isEmpty());
    }

    /**
     * Test for the method {@link WorkplaceGroupClient#getSetupTransitionRules(GetWorkplaceGroupSetupTransitionRuleCollectionRequest)}.
     *
     * @throws ForceAPIException    When unable to get workplace group setup transition rules.
     * @throws InterruptedException When unable to take the request from the server.
     * @throws IOException          When unable to read the JSON file.
     * @throws URISyntaxException   When unable to create a URI of the JSON file.
     */
    @Test
    public void getSetupTransitionRules() throws ForceAPIException, InterruptedException, IOException, URISyntaxException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getWorkplaceGroupSetupTransitionRules.json")));
        final int limit = 2;
        final int offset = 0;
        final GetWorkplaceGroupSetupTransitionRuleCollectionRequest request = new GetWorkplaceGroupSetupTransitionRuleCollectionRequest("workplaceGroupId");
        request
            .setLimit(limit)
            .setOffset(offset);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final Page<WorkplaceGroupSetupTransitionRuleResponse> response = mWorkplaceGroupClient.getSetupTransitionRules(request);

        final RecordedRequest recordedRequest = mMockWebServer.takeRequest();
        final String requestQuery = recordedRequest
            .getRequestUrl()
            .query();
        Assert.assertNotNull(requestQuery);
        Assert.assertTrue(requestQuery.contains("limit=" + limit));
        Assert.assertTrue(requestQuery.contains("offset=" + offset));

        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getResponse());
        Assert.assertNotNull(response.getPagination());
        Assert.assertNotNull(response
                                 .getResponse()
                                 .getPaginationLinks()
                                 .getSelf());
        Assert.assertFalse(response
                               .getElements()
                               .isEmpty());
    }

    /**
     * Test for the method {@link WorkplaceGroupClient#getSetupTransitionRule(GetWorkplaceGroupSetupTransitionRuleRequest)}.
     *
     * @throws ForceAPIException    When unable to get workplace group setup transition rule.
     * @throws InterruptedException When unable to take the request from the server.
     * @throws IOException          When unable to read the JSON file.
     * @throws URISyntaxException   When unable to create a URI of the JSON file.
     */
    @Test
    public void getSetupTransitionRule() throws ForceAPIException, InterruptedException, IOException, URISyntaxException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getWorkplaceGroupSetupTransitionRule.json")));
        final GetWorkplaceGroupSetupTransitionRuleRequest request = new GetWorkplaceGroupSetupTransitionRuleRequest("workplaceGroupId", "ruleId");

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final WorkplaceGroupSetupTransitionRuleResponse response = mWorkplaceGroupClient.getSetupTransitionRule(request);

        final RecordedRequest recordedRequest = mMockWebServer.takeRequest();
        final String requestPath = recordedRequest.getPath();
        Assert.assertTrue(requestPath.contains("ruleId"));

        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getSelf());
        Assert.assertNotNull(response.getProperties());
        Assert.assertNotNull(response
                                 .getProperties()
                                 .getId());
        Assert.assertNotNull(response
                                 .getProperties()
                                 .getSuccessorConditions());
        Assert.assertNotNull(response
                                 .getProperties()
                                 .getPredecessorConditions());
    }

    /**
     * Test for the method {@link WorkplaceGroupClient#getManufacturingVariantRule(GetManufacturingVariantRuleRequest)}.
     *
     * @throws ForceAPIException    When unable to get workplace group manufacturing variant rule.
     * @throws InterruptedException When unable to take the request from the server.
     * @throws IOException          When unable to read the JSON file.
     * @throws URISyntaxException   When unable to create a URI of the JSON file.
     */
    @Test
    public void getManufacturingVariantRule() throws ForceAPIException, InterruptedException, IOException, URISyntaxException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getManufacturingVariantRule.json")));
        final GetManufacturingVariantRuleRequest request = new GetManufacturingVariantRuleRequest("workplaceGroupId", "ruleId");

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final WorkplaceGroupManufacturingVariantRuleResponse response = mWorkplaceGroupClient.getManufacturingVariantRule(request);

        final RecordedRequest recordedRequest = mMockWebServer.takeRequest();
        final String requestPath = recordedRequest.getPath();
        Assert.assertTrue(requestPath.contains("ruleId"));

        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getSelf());
        Assert.assertNotNull(response.getProperties());
        Assert.assertNotNull(response
                                 .getProperties()
                                 .getId());
        Assert.assertNotNull(response
                                 .getProperties()
                                 .getConditions());
        Assert.assertNotNull(response
                                 .getProperties()
                                 .getForecastedDelays());
        Assert.assertNotNull(response
                                 .getProperties()
                                 .getForecastedDelays()
                                 .getPerformance());
        Assert.assertNotNull(response
                                 .getProperties()
                                 .getForecastedDelays()
                                 .getProcessAvailability());
    }

    /**
     * Test for the method {@link WorkplaceGroupClient#getManufacturingVariantRules(GetManufacturingVariantRuleCollectionRequest)}.
     *
     * @throws ForceAPIException    When unable to get workplace group manufacturing variant rules.
     * @throws InterruptedException When unable to take the request from the server.
     * @throws IOException          When unable to read the JSON file.
     * @throws URISyntaxException   When unable to create a URI of the JSON file.
     */
    @Test
    public void getManufacturingVariantRuleCollection() throws ForceAPIException, InterruptedException, IOException, URISyntaxException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getManufacturingVariantRuleCollection.json")));
        final int limit = 3;
        final int offset = 0;
        final GetManufacturingVariantRuleCollectionRequest request = new GetManufacturingVariantRuleCollectionRequest("workplaceGroupId");
        request
            .setLimit(limit)
            .setOffset(offset);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final Page<WorkplaceGroupManufacturingVariantRuleResponse> response = mWorkplaceGroupClient.getManufacturingVariantRules(request);

        final RecordedRequest recordedRequest = mMockWebServer.takeRequest();
        final String requestQuery = recordedRequest
            .getRequestUrl()
            .query();
        Assert.assertNotNull(requestQuery);
        Assert.assertTrue(requestQuery.contains("limit=" + limit));
        Assert.assertTrue(requestQuery.contains("offset=" + offset));

        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getPagination());
        Assert.assertNotNull(response.getResponse());
        Assert.assertFalse(response
                               .getElements()
                               .isEmpty());
        Assert.assertNotNull(response
                                 .getResponse()
                                 .getPaginationLinks());
        Assert.assertNotNull(response
                                 .getElements()
                                 .get(0)
                                 .getProperties()
                                 .getId());
        Assert.assertNotNull(response
                                 .getElements()
                                 .get(0)
                                 .getProperties()
                                 .getForecastedDelays()
                                 .getPerformance());
        Assert.assertNotNull(response
                                 .getElements()
                                 .get(0)
                                 .getProperties()
                                 .getForecastedDelays()
                                 .getProcessAvailability());
    }
}