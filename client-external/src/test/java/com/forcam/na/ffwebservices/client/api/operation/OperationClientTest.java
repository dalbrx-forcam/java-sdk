////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 14.09.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.operation;

import com.forcam.na.ffwebservices.client.api.AbstractOpenAPIMockTest;
import com.forcam.na.ffwebservices.client.api.config.GuiceTestRunner;
import com.forcam.na.ffwebservices.client.api.exception.ForceAPIException;
import com.forcam.na.ffwebservices.client.api.operation.request.GetOperationComponentsRequest;
import com.forcam.na.ffwebservices.client.api.operation.request.GetOperationCurrentProductionDataRequest;
import com.forcam.na.ffwebservices.client.api.operation.request.GetOperationOperatingStateSummaryRequest;
import com.forcam.na.ffwebservices.client.api.operation.request.GetOperationProductionResourcesAndToolsRequest;
import com.forcam.na.ffwebservices.client.api.operation.request.GetOperationQuantitySummaryRequest;
import com.forcam.na.ffwebservices.client.api.operation.request.GetOperationRecordedOperatingStatesRequest;
import com.forcam.na.ffwebservices.client.api.operation.request.GetOperationRecordedOperationPhasesRequest;
import com.forcam.na.ffwebservices.client.api.operation.request.GetOperationRecordedOutputQuantitiesRequest;
import com.forcam.na.ffwebservices.client.api.operation.request.GetOperationRequest;
import com.forcam.na.ffwebservices.client.api.operation.request.GetOperationScheduledDatesRequest;
import com.forcam.na.ffwebservices.client.api.operation.request.GetOperationSpecificationRequest;
import com.forcam.na.ffwebservices.client.api.operation.request.GetOperationUserFieldsRequest;
import com.forcam.na.ffwebservices.client.api.operation.request.GetOperationsRequest;
import com.forcam.na.ffwebservices.client.api.operation.request.SearchOperationsRequest;
import com.forcam.na.ffwebservices.client.api.operation.request.SetOperationPhaseRequest;
import com.forcam.na.ffwebservices.client.api.operation.request.SetOperationQualityDetailsRequest;
import com.forcam.na.ffwebservices.client.api.operation.request.UpdateOperationRecordedOperatingStateRequest;
import com.forcam.na.ffwebservices.client.api.operation.response.OperatingQuantitySummaryCollectionPage;
import com.forcam.na.ffwebservices.client.api.operation.response.OperationComponentCollectionPage;
import com.forcam.na.ffwebservices.client.api.operation.response.OperationManufacturingVariantsResponse;
import com.forcam.na.ffwebservices.client.api.operation.response.OperationOperatingStateSummaryPage;
import com.forcam.na.ffwebservices.client.api.operation.response.OperationRecordedOperationPhasePage;
import com.forcam.na.ffwebservices.client.api.operation.response.OperationRecordedOutputQuantitiesPage;
import com.forcam.na.ffwebservices.client.api.operation.response.OperationUserFieldCollectionPage;
import com.forcam.na.ffwebservices.client.api.operation.response.RecordedOperatingStateCollectionPage;
import com.forcam.na.ffwebservices.client.api.pagination.response.Page;
import com.forcam.na.ffwebservices.model.command.operation.OperationPhaseRequestBody;
import com.forcam.na.ffwebservices.model.command.operation.OperationQualityDetailRequestBody;
import com.forcam.na.ffwebservices.model.definition.OperationPhase;
import com.forcam.na.ffwebservices.model.operation.OperationCurrentProductionDataResponse;
import com.forcam.na.ffwebservices.model.operation.OperationResponse;
import com.forcam.na.ffwebservices.model.operation.OperationScheduledDatesResponse;
import com.forcam.na.ffwebservices.model.operation.OperationSpecificationResponse;
import com.forcam.na.ffwebservices.model.operation.OperationTime;
import com.forcam.na.ffwebservices.model.operation.ProductionResourceToolResponse;
import com.forcam.na.ffwebservices.model.operation.SearchOperationsRequestBody;
import com.forcam.na.ffwebservices.model.operation.UpdateOperationRecordedOperatingStateRequestBody;
import com.forcam.na.ffwebservices.model.qualitydetail.QualityType;
import com.forcam.na.ffwebservices.model.workplace.UpdateWorkplaceRecordedOperatingStateRequestBody;
import com.forcam.na.ffwebservices.model.workplace.WorkplaceResponse;
import okhttp3.HttpUrl;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.*;
import org.junit.rules.*;
import org.junit.runner.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Tests for the class {@link OperationClient}.
 */
@RunWith(GuiceTestRunner.class)
public class OperationClientTest extends AbstractOpenAPIMockTest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Helper for test exceptions and messages. */
    @Rule
    public ExpectedException mExpectedException = ExpectedException.none();

    /** The operation client. */
    private IOperationClient mOperationClient;

    // ------------------------------------------------------------------------
    // constructor
    // ------------------------------------------------------------------------

    public OperationClientTest() {
        mOperationClient = mBridgeAPIComponent.operationClient();
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    /**
     * Test for the method {@link OperationClient#searchOperations(SearchOperationsRequest)}.
     *
     * @throws ForceAPIException    When unable to search operations.
     * @throws InterruptedException When unable to take the request from the server.
     * @throws IOException          When unable to read the JSON file.
     * @throws URISyntaxException   When unable to create a URI of the JSON file.
     */
    @Test
    public void testSearchOperations() throws ForceAPIException, InterruptedException, IOException, URISyntaxException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/searchOperations.json")));
        final int limit = 3;
        final SearchOperationsRequest request = new SearchOperationsRequest();
        request
            .getSearchOperations()
            .setTargetWorkplaceIds(Collections.singletonList("workplaceId"));
        request.setLimit(limit);
        request
            .embed()
            .erpContext(true)
            .order(true)
            .description(true);

        final Page<OperationResponse> response = mOperationClient.searchOperations(request);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        //Verify request
        final RecordedRequest recordedRequest = mMockWebServer.takeRequest();
        final String body = recordedRequest
            .getBody()
            .readUtf8();
        final SearchOperationsRequestBody requestModel = mMapper.readValue(body, SearchOperationsRequestBody.class);
        Assert.assertEquals(request.getSearchOperations(), requestModel);

        final String requestQuery = recordedRequest
            .getRequestUrl()
            .query();
        Assert.assertNotNull(requestQuery);
        Assert.assertTrue(requestQuery.contains("embed=" + request
            .embed()
            .toString()));
        Assert.assertTrue(requestQuery.contains("limit=" + limit));

        //Verify response model
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
    }

    /**
     * Test for the method {@link OperationClient#getOperation(GetOperationRequest)}.
     *
     * @throws ForceAPIException    When unable to search operations.
     * @throws InterruptedException When unable to take the request from the server.
     * @throws IOException          When unable to read the JSON file.
     * @throws URISyntaxException   When unable to create a URI of the JSON file.
     */
    @Test
    public void testGetOperation() throws ForceAPIException, InterruptedException, IOException, URISyntaxException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getOperation.json")));
        final GetOperationRequest request = new GetOperationRequest("11B75B79864F4DCDBA5C7228184B7E90");
        final OperationResponse response = mOperationClient.getOperation(request);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        //Verify request
        final RecordedRequest recordedRequest = mMockWebServer.takeRequest();
        final String requestQuery = recordedRequest
            .getRequestUrl()
            .query();
        Assert.assertNotNull(requestQuery);

        //Verify response model
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getSelf());
        Assert.assertNotNull(response.getDescription());
        Assert.assertNotNull(response
                                 .getDescription()
                                 .getLink());
        Assert.assertNotNull(response.getOrder());
        Assert.assertNotNull(response
                                 .getOrder()
                                 .getLink());
        Assert.assertNotNull(response.getErpContext());
        Assert.assertNotNull(response
                                 .getErpContext()
                                 .getLink());
        Assert.assertNotNull(response.getProperties());
        Assert.assertNotNull(response
                                 .getProperties()
                                 .getId());
    }

    /**
     * Test for the method {@link OperationClient#getScheduledDates(GetOperationScheduledDatesRequest)}.
     *
     * @throws ForceAPIException    When unable to get scheduled dates.
     * @throws InterruptedException When unable to take the request from the server.
     * @throws IOException          When unable to read the JSON file.
     * @throws URISyntaxException   When unable to create a URI of the JSON file.
     */
    @Test
    public void testGetScheduledDates() throws ForceAPIException, InterruptedException, IOException, URISyntaxException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getOperationScheduledDates.json")));
        final GetOperationScheduledDatesRequest request = new GetOperationScheduledDatesRequest("11B75B79864F4DCDBA5C7228184B7E90");
        final OperationScheduledDatesResponse response = mOperationClient.getScheduledDates(request);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        //Verify response model
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getSelf());
        Assert.assertNotNull(response.getProperties());
    }

    /**
     * Test for the method {@link OperationClient#getSpecification(GetOperationSpecificationRequest)}.
     *
     * @throws ForceAPIException    When unable to get specification.
     * @throws InterruptedException When unable to take the request from the server.
     * @throws IOException          When unable to read the JSON file.
     * @throws URISyntaxException   When unable to create a URI of the JSON file.
     */
    @Test
    public void testGetSpecification() throws ForceAPIException, InterruptedException, IOException, URISyntaxException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getOperationSpecification.json")));
        final GetOperationSpecificationRequest request = new GetOperationSpecificationRequest("11B75B79864F4DCDBA5C7228184B7E90");
        final OperationSpecificationResponse response = mOperationClient.getSpecification(request);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        //Verify request
        final RecordedRequest recordedRequest = mMockWebServer.takeRequest();
        final String requestQuery = recordedRequest
            .getRequestUrl()
            .query();
        Assert.assertNotNull(requestQuery);

        //Verify response model
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getSelf());
        Assert.assertNotNull(response.getTargetWorkplace());
        Assert.assertNotNull(response
                                 .getTargetWorkplace()
                                 .getLink());
        Assert.assertNotNull(response.getProperties());
    }

    /**
     * Test for the method {@link OperationClient#getProductionResourcesAndTools(GetOperationProductionResourcesAndToolsRequest)}.
     *
     * @throws ForceAPIException    When unable to get production resources and tools.
     * @throws InterruptedException When unable to take the request from the server.
     * @throws IOException          When unable to read the JSON file.
     * @throws URISyntaxException   When unable to create a URI of the JSON file.
     */
    @Test
    public void testGetProductionResourcesAndTools() throws ForceAPIException, InterruptedException, IOException, URISyntaxException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getOperationProductionResourcesAndTools.json")));
        final int limit = 3;
        final int offset = 0;
        final GetOperationProductionResourcesAndToolsRequest request = new GetOperationProductionResourcesAndToolsRequest("11B75B79864F4DCDBA5C7228184B7E90");
        request
            .setLimit(limit)
            .setOffset(offset);
        request
            .embed()
            .description(true);

        final Page<ProductionResourceToolResponse> response = mOperationClient.getProductionResourcesAndTools(request);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        //Verify request
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

        //Verify response model
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
    }

    /**
     * Test for the method {@link OperationClient#getRecordedOperatingStates(GetOperationRecordedOperatingStatesRequest)}.
     *
     * @throws ForceAPIException    When unable to get recorded operating states.
     * @throws InterruptedException When unable to take the request from the server.
     * @throws IOException          When unable to read the JSON file.
     * @throws URISyntaxException   When unable to create a URI of the JSON file.
     */
    @Test
    public void testGetRecordedOperatingStates() throws ForceAPIException, InterruptedException, IOException, URISyntaxException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getOperationRecordedOperatingStates.json")));
        final int limit = 3;
        final GetOperationRecordedOperatingStatesRequest request = new GetOperationRecordedOperatingStatesRequest("11B75B79864F4DCDBA5C7228184B7E90");
        request.setLimit(limit);
        request
            .embed()
            .operatingState(true);

        final RecordedOperatingStateCollectionPage page = mOperationClient.getRecordedOperatingStates(request);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        //Verify request
        final RecordedRequest recordedRequest = mMockWebServer.takeRequest();
        final String requestQuery = recordedRequest
            .getRequestUrl()
            .query();
        Assert.assertNotNull(requestQuery);
        Assert.assertTrue(requestQuery.contains("embed=" + request
            .embed()
            .toString()));
        Assert.assertTrue(requestQuery.contains("limit=" + limit));

        //Verify response model
        Assert.assertNotNull(page);
        Assert.assertFalse(page
                               .getResponse()
                               .getProperties()
                               .getElements()
                               .isEmpty());
    }



    /**
     * Test for the method {@link OperationClient#updateRecordedOperatingState(UpdateOperationRecordedOperatingStateRequest)}.
     *
     * @throws ForceAPIException    When unable to update recorded operating state.
     * @throws InterruptedException When unable to take the request from the server.
     * @throws IOException          When unable to read the JSON file.
     * @throws URISyntaxException   When unable to create a URI of the JSON file.
     */
    @Test
    public void updateRecordedOperatingState() throws ForceAPIException, InterruptedException, IOException, URISyntaxException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        mMockWebServer.enqueue(new MockResponse());
        final String operationId = "TESTID";
        final UpdateOperationRecordedOperatingStateRequest request = new UpdateOperationRecordedOperatingStateRequest(operationId);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mOperationClient.updateRecordedOperatingState(request);

        final RecordedRequest recordedRequest = mMockWebServer.takeRequest();
        final String requestUrl = recordedRequest
            .getRequestUrl()
            .toString();
        Assert.assertNotNull(requestUrl);
        Assert.assertTrue(requestUrl.contains(operationId));

        final String body = recordedRequest
            .getBody()
            .readUtf8();
        final UpdateOperationRecordedOperatingStateRequestBody requestModel = mMapper.readValue(body, UpdateOperationRecordedOperatingStateRequestBody.class);
        Assert.assertEquals(requestModel, request.getOperationRecordedOperatingState());
    }

    /**
     * Test for the method {@link OperationClient#getOperations(GetOperationsRequest)}.
     *
     * @throws ForceAPIException    When unable to get operations.
     * @throws InterruptedException When unable to take the request from the server.
     * @throws IOException          When unable to read the JSON file.
     * @throws URISyntaxException   When unable to create a URI of the JSON file.
     */
    @Test
    public void testGetOperations() throws ForceAPIException, InterruptedException, IOException, URISyntaxException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getOperations.json")));
        final int limit = 3;
        final GetOperationsRequest request = new GetOperationsRequest();
        request.setLimit(limit);
        request
            .embed()
            .erpContext(true)
            .order(true)
            .description(true)
            .alternativeWorkplaces(true);

        final Page<OperationResponse> page = mOperationClient.getOperations(request);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        //Verify request
        final RecordedRequest recordedRequest = mMockWebServer.takeRequest();
        final String requestQuery = recordedRequest
            .getRequestUrl()
            .query();
        Assert.assertNotNull(requestQuery);
        Assert.assertTrue(requestQuery.contains("embed=" + request
            .embed()
            .toString()));
        Assert.assertTrue(requestQuery.contains("limit=" + limit));

        //Verify response model
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
    }

    /**
     * Test for the method {@link OperationClient#getQuantitySummary(GetOperationQuantitySummaryRequest)}.
     *
     * @throws ForceAPIException    When unable to get quantity summary.
     * @throws InterruptedException When unable to take the request from the server.
     * @throws IOException          When unable to read the JSON file.
     * @throws URISyntaxException   When unable to create a URI of the JSON file.
     */
    @Test
    public void testGetQuantitySummary() throws ForceAPIException, InterruptedException, IOException, URISyntaxException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getOperationQuantitySummary.json")));
        final int limit = 3;
        final int offset = 0;
        final String operationId = "11B75B79864F4DCDBA5C7228184B7E90";
        final GetOperationQuantitySummaryRequest request = new GetOperationQuantitySummaryRequest(operationId);
        request
            .setLimit(limit)
            .setOffset(offset);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final OperatingQuantitySummaryCollectionPage page = mOperationClient.getQuantitySummary(request);

        //Verify request
        final RecordedRequest recordedRequest = mMockWebServer.takeRequest();
        final String requestQuery = recordedRequest
            .getRequestUrl()
            .query();
        Assert.assertNotNull(requestQuery);
        Assert.assertTrue(requestQuery.contains("limit=" + limit));
        Assert.assertTrue(requestQuery.contains("offset=" + offset));
        final String requestUrl = recordedRequest
            .getRequestUrl()
            .toString();
        Assert.assertNotNull(requestUrl);
        Assert.assertTrue(requestUrl.contains(operationId));

        //Verify response model
        Assert.assertNotNull(page);
        Assert.assertNotNull(page
                                 .getResponse()
                                 .getProperties());
    }

    /**
     * Test for the method {@link OperationClient#setQualityDetails(SetOperationQualityDetailsRequest)}.
     *
     * @throws ForceAPIException    When unable to set quality details.
     * @throws InterruptedException When unable to take the request from the server.
     * @throws IOException          When unable to read the JSON file.
     * @throws URISyntaxException   When unable to create a URI of the JSON file.
     */
    @Test
    public void testSetQualityDetails() throws ForceAPIException, InterruptedException, IOException, URISyntaxException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        mMockWebServer.enqueue(new MockResponse().setBody(""));
        final SetOperationQualityDetailsRequest request = new SetOperationQualityDetailsRequest("TESTID");

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mOperationClient.setQualityDetails(request);

        //Verify request
        final RecordedRequest recordedRequest = mMockWebServer.takeRequest();
        final String requestQuery = recordedRequest
            .getRequestUrl()
            .query();
        Assert.assertNotNull(requestQuery);

        final String body = recordedRequest
            .getBody()
            .readUtf8();
        final OperationQualityDetailRequestBody requestModel = mMapper.readValue(body, OperationQualityDetailRequestBody.class);
        Assert.assertEquals(request.getOperationQualityDetail(), requestModel);
    }

    /**
     * Test for the method {@link OperationClient#setOperationPhase(SetOperationPhaseRequest)}.
     *
     * @throws ForceAPIException    When unable to set operation phase.
     * @throws InterruptedException When unable to take the request from the server.
     * @throws IOException          When unable to read the JSON file.
     * @throws URISyntaxException   When unable to create a URI of the JSON file.
     */
    @Test
    public void testSetOperationPhase() throws ForceAPIException, InterruptedException, IOException, URISyntaxException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/setOperationPhase.json")));
        final SetOperationPhaseRequest request = new SetOperationPhaseRequest("TESTID", OperationPhase.COMPLETED);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final OperationResponse response = mOperationClient.setOperationPhase(request);

        //Verify request
        final RecordedRequest recordedRequest = mMockWebServer.takeRequest();
        final String requestQuery = recordedRequest
            .getRequestUrl()
            .query();
        Assert.assertNotNull(requestQuery);

        final String body = recordedRequest
            .getBody()
            .readUtf8();
        final OperationPhaseRequestBody requestModel = mMapper.readValue(body, OperationPhaseRequestBody.class);
        Assert.assertEquals(request.getOperationPhase(), requestModel);

        //Verify response model
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getSelf());
        Assert.assertNotNull(response.getDescription());
        Assert.assertNotNull(response
                                 .getDescription()
                                 .getLink());
        Assert.assertNotNull(response.getOrder());
        Assert.assertNotNull(response
                                 .getOrder()
                                 .getLink());
        Assert.assertNotNull(response.getErpContext());
        Assert.assertNotNull(response
                                 .getErpContext()
                                 .getLink());
        Assert.assertNotNull(response.getProperties());
        Assert.assertNotNull(response
                                 .getProperties()
                                 .getId());
    }

    /**
     * Tests searching operations while server is down.
     *
     * @throws IOException       When unable to shutdown the server.
     * @throws ForceAPIException When unable to search operations.
     */
    @Test
    public void searchOperationsShutdown() throws IOException, ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final SearchOperationsRequest request = new SearchOperationsRequest();
        mMockWebServer.shutdown();
        mExpectedException.expect(ForceAPIException.class);
        mExpectedException.expectMessage("Unable to execute call using request: " + request);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mOperationClient.searchOperations(request);
    }

    /**
     * Tests getting operation while server is down.
     *
     * @throws IOException       When unable to shutdown the server.
     * @throws ForceAPIException When unable to get operation.
     */
    @Test
    public void getOperationShutdown() throws IOException, ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final GetOperationRequest request = new GetOperationRequest("operationId");
        mMockWebServer.shutdown();
        mExpectedException.expect(ForceAPIException.class);
        mExpectedException.expectMessage("Unable to execute call using request: " + request);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mOperationClient.getOperation(request);
    }

    /**
     * Tests getting the scheduled dates of operation while server is down.
     *
     * @throws IOException       When unable to shutdown the server.
     * @throws ForceAPIException When unable to get scheduled dates.
     */
    @Test
    public void getScheduledDatesShutdown() throws IOException, ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final GetOperationScheduledDatesRequest request = new GetOperationScheduledDatesRequest("operationId");
        mMockWebServer.shutdown();
        mExpectedException.expect(ForceAPIException.class);
        mExpectedException.expectMessage("Unable to execute call using request: " + request);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mOperationClient.getScheduledDates(request);
    }

    /**
     * Tests getting the specification of operation while server is down.
     *
     * @throws IOException       When unable to shutdown the server.
     * @throws ForceAPIException When unable to get specification.
     */
    @Test
    public void getSpecificationShutdown() throws IOException, ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final GetOperationSpecificationRequest request = new GetOperationSpecificationRequest("operationId");
        mMockWebServer.shutdown();
        mExpectedException.expect(ForceAPIException.class);
        mExpectedException.expectMessage("Unable to execute call using request: " + request);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mOperationClient.getSpecification(request);
    }

    /**
     * Tests getting production resources and tools while server is down.
     *
     * @throws IOException       When unable to shutdown the server.
     * @throws ForceAPIException When unable to get production resources and tools.
     */
    @Test
    public void getProductionResourcesAndToolsShutdown() throws IOException, ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final GetOperationProductionResourcesAndToolsRequest request = new GetOperationProductionResourcesAndToolsRequest("operationId");
        mMockWebServer.shutdown();
        mExpectedException.expect(ForceAPIException.class);
        mExpectedException.expectMessage("Unable to execute call using request: " + request);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mOperationClient.getProductionResourcesAndTools(request);
    }

    /**
     * Tests getting recorded operating states while server is down.
     *
     * @throws IOException       When unable to shutdown the server.
     * @throws ForceAPIException When unable to get recorded operating states.
     */
    @Test
    public void getRecordedOperatingStatesShutdown() throws IOException, ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final GetOperationRecordedOperatingStatesRequest request = new GetOperationRecordedOperatingStatesRequest("operationId");
        mMockWebServer.shutdown();
        mExpectedException.expect(ForceAPIException.class);
        mExpectedException.expectMessage("Unable to execute call using request: " + request);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mOperationClient.getRecordedOperatingStates(request);
    }

    /**
     * Tests getting operations while server is down.
     *
     * @throws IOException       When unable to shutdown the server.
     * @throws ForceAPIException When unable to get operations.
     */
    @Test
    public void getOperationsShutdown() throws IOException, ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final GetOperationsRequest request = new GetOperationsRequest();
        mMockWebServer.shutdown();
        mExpectedException.expect(ForceAPIException.class);
        mExpectedException.expectMessage("Unable to execute call using request: " + request);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mOperationClient.getOperations(request);
    }

    /**
     * Tests getting the quantity summary of operation while server is down.
     *
     * @throws IOException       When unable to shutdown the server.
     * @throws ForceAPIException When unable to get quantity summary.
     */
    @Test
    public void getQuantitySummaryShutdown() throws IOException, ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final GetOperationQuantitySummaryRequest request = new GetOperationQuantitySummaryRequest("operationId");
        mMockWebServer.shutdown();
        mExpectedException.expect(ForceAPIException.class);
        mExpectedException.expectMessage("Unable to execute call using request: " + request);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mOperationClient.getQuantitySummary(request);
    }

    /**
     * Tests setting the quality details of operation while server is down.
     *
     * @throws IOException       When unable to shutdown the server.
     * @throws ForceAPIException When unable to set quality details.
     */
    @Test
    public void setQualityDetailsShutdown() throws IOException, ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final SetOperationQualityDetailsRequest request = new SetOperationQualityDetailsRequest("operationId");
        mMockWebServer.shutdown();
        mExpectedException.expect(ForceAPIException.class);
        mExpectedException.expectMessage("Unable to execute call using request: " + request);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mOperationClient.setQualityDetails(request);
    }

    /**
     * Tests setting the operation phase of operation while server is down.
     *
     * @throws IOException       When unable to shutdown the server.
     * @throws ForceAPIException When unable to set operation phase.
     */
    @Test
    public void setOperationPhaseShutdown() throws IOException, ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final SetOperationPhaseRequest request = new SetOperationPhaseRequest("operationId", OperationPhase.COMPLETED);
        mMockWebServer.shutdown();
        mExpectedException.expect(ForceAPIException.class);
        mExpectedException.expectMessage("Unable to execute call using request: " + request);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mOperationClient.setOperationPhase(request);
    }

    /**
     * Test for the method {@link OperationClient#getOperationUserFields(GetOperationUserFieldsRequest)}.
     *
     * @throws ForceAPIException    When unable to get operation user fields.
     * @throws InterruptedException When unable to take the request from the server.
     * @throws IOException          When unable to read the JSON file.
     * @throws URISyntaxException   When unable to create a URI of the JSON file.
     */
    @Test
    public void testGetOperationUserFields() throws ForceAPIException, InterruptedException, IOException, URISyntaxException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final int limit = 3;
        final int offset = 0;

        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getOperationUserFields.json")));
        final GetOperationUserFieldsRequest request = new GetOperationUserFieldsRequest("11B75B79864F4DCDBA5C7228184B7E90");
        request.setLimit(limit);
        request.setOffset(offset);
        request
            .embed()
            .operation(true);
        final OperationUserFieldCollectionPage page = mOperationClient.getOperationUserFields(request);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        //Verify request
        final RecordedRequest recordedRequest = mMockWebServer.takeRequest();
        final String requestQuery = recordedRequest
            .getRequestUrl()
            .query();
        Assert.assertNotNull(requestQuery);
        Assert.assertTrue(requestQuery.contains("limit=" + limit));
        Assert.assertTrue(requestQuery.contains("offset=" + offset));

        //Verify response model
        Assert.assertNotNull(page);
        Assert.assertNotNull(page
                                 .getResponse()
                                 .getPaginationLinks()
                                 .getSelf());
        Assert.assertNotNull(page
                                 .getResponse()
                                 .getProperties()
                                 .getElements());
        Assert.assertNotNull(page
                                 .getResponse()
                                 .getPagination());
        Assert.assertNotNull(page
                                 .getResponse()
                                 .getOperation()
                                 .getEmbedded());
    }

    /**
     * Test for the method {@link OperationClient#getOperationComponents(GetOperationComponentsRequest)}.
     *
     * @throws ForceAPIException    When unable to get operation components.
     * @throws InterruptedException When unable to take the request from the server.
     * @throws IOException          When unable to read the JSON file.
     * @throws URISyntaxException   When unable to create a URI of the JSON file.
     */
    @Test
    public void getOperationComponents() throws ForceAPIException, IOException, URISyntaxException, InterruptedException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getOperationComponents.json")));
        final int limit = 3;
        final int offset = 0;
        final GetOperationComponentsRequest request = new GetOperationComponentsRequest("7BA33C1435884487B1D8F53E45D84D6D");
        request
            .setLimit(limit)
            .setOffset(offset);
        request
            .embed()
            .operation(true);

        final OperationComponentCollectionPage page = mOperationClient.getOperationComponents(request);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        //Verify request
        final RecordedRequest recordedRequest = mMockWebServer.takeRequest();
        final String requestQuery = recordedRequest
            .getRequestUrl()
            .query();
        Assert.assertNotNull(requestQuery);
        Assert.assertTrue(requestQuery.contains("limit=" + limit));
        Assert.assertTrue(requestQuery.contains("offset=" + offset));

        //Verify response model
        Assert.assertNotNull(page);
        Assert.assertFalse(page
                               .getResponse()
                               .getProperties()
                               .getElements()
                               .isEmpty());
        Assert.assertNotNull(page
                                 .getResponse()
                                 .getPaginationLinks());
        Assert.assertNotNull(page
                                 .getResponse()
                                 .getOperation()
                                 .getEmbedded());
        Assert.assertNotNull(page
                                 .getResponse()
                                 .getPagination());
    }

    /**
     * Tests getting manufacturing variants of an operation.
     *
     * @throws ForceAPIException    When unable to get operation manufacturing variants.
     * @throws InterruptedException When unable to take the request from the server.
     * @throws IOException          When unable to read the JSON file.
     * @throws URISyntaxException   When unable to create a URI of the JSON file.
     */
    @Test
    public void getOperationManufacturingVariants() throws IOException, URISyntaxException, ForceAPIException, InterruptedException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getOperationManufacturingVariants.json")));
        final OperationManufacturingVariantsResponse response = mOperationClient.getOperationManufacturingVariants("operationId");

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        //Verify request
        final RecordedRequest recordedRequest = mMockWebServer.takeRequest();
        final HttpUrl url = recordedRequest.getRequestUrl();
        Assert.assertNotNull(url);
        Assert.assertTrue(url
                              .toString()
                              .contains("operationId"));

        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getSelf());
        Assert.assertNotNull(response
                                 .getProperties()
                                 .getElements());
        Assert.assertNotNull(response
                                 .getProperties()
                                 .getElements()
                                 .get(0)
                                 .getAdditionalConditions());
        Assert.assertNotNull(response
                                 .getProperties()
                                 .getElements()
                                 .get(0)
                                 .getWorkplaces());
        Assert.assertNotNull(response
                                 .getProperties()
                                 .getElements()
                                 .get(0)
                                 .getForecast()
                                 .getPerformance());
        Assert.assertNotNull(response
                                 .getProperties()
                                 .getElements()
                                 .get(0)
                                 .getForecast()
                                 .getProcessAvailability());
        Assert.assertNotNull(response
                                 .getProperties()
                                 .getElements()
                                 .get(0)
                                 .getForecast()
                                 .getQualityRate());
    }

    /**
     * Tests getting operating state summary of an operation.
     *
     * @throws ForceAPIException    When unable to get operating state summary.
     * @throws InterruptedException When unable to take the request from the server.
     * @throws IOException          When unable to read the JSON file.
     * @throws URISyntaxException   When unable to create a URI of the JSON file.
     */
    @Test
    public void getOperationOperatingStateSummary() throws IOException, URISyntaxException, ForceAPIException, InterruptedException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getOperationOperatingStateSummary.json")));
        final GetOperationOperatingStateSummaryRequest request = new GetOperationOperatingStateSummaryRequest("operationId");
        final OperationOperatingStateSummaryPage page = mOperationClient.getOperatingStateSummary(request);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        //Verify request
        final RecordedRequest recordedRequest = mMockWebServer.takeRequest();
        final HttpUrl url = recordedRequest.getRequestUrl();
        Assert.assertNotNull(url);
        Assert.assertTrue(url
                              .toString()
                              .contains("operationId"));

        Assert.assertNotNull(page);
        Assert.assertNotNull(page
                                 .getResponse()
                                 .getProperties()
                                 .getElements()
                                 .get(0));
        Assert.assertNotNull(page
                                 .getResponse()
                                 .getProperties()
                                 .getElements()
                                 .get(0)
                                 .getFrequency());
        Assert.assertNotNull(page
                                 .getResponse()
                                 .getProperties()
                                 .getElements()
                                 .get(0)
                                 .getDuration());
        Assert.assertNotNull(page
                                 .getResponse()
                                 .getProperties()
                                 .getElements()
                                 .get(0)
                                 .getOperatingState());
    }

    /**
     * Tests getting recorded operation phases of an operation.
     *
     * @throws ForceAPIException    When unable to get recorded operation phases.
     * @throws InterruptedException When unable to take the request from the server.
     * @throws IOException          When unable to read the JSON file.
     * @throws URISyntaxException   When unable to create a URI of the JSON file.
     */
    @Test
    public void getOperationRecordedOperationPhases() throws IOException, URISyntaxException, ForceAPIException, InterruptedException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getOperationRecordedOperationPhases.json")));
        final GetOperationRecordedOperationPhasesRequest request = new GetOperationRecordedOperationPhasesRequest("operationId");
        request.setLimit(1);
        final OperationRecordedOperationPhasePage page = mOperationClient.getRecordedOperationPhases(request);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        //Verify request
        final RecordedRequest recordedRequest = mMockWebServer.takeRequest();
        final HttpUrl url = recordedRequest.getRequestUrl();
        Assert.assertNotNull(url);
        Assert.assertTrue(url
                              .toString()
                              .contains("operationId"));

        Assert.assertNotNull(page);
        Assert.assertNotNull(page
                                 .getResponse()
                                 .getPaginationLinks());
        Assert.assertNotNull(page
                                 .getResponse()
                                 .getPagination());
        Assert.assertNotNull(page
                                 .getResponse()
                                 .getProperties()
                                 .getStartDate());
        Assert.assertNotNull(page
                                 .getResponse()
                                 .getProperties()
                                 .getEndDate());
        Assert.assertNotNull(page
                                 .getResponse()
                                 .getProperties()
                                 .getElements()
                                 .get(0));
        Assert.assertNotNull(page
                                 .getResponse()
                                 .getProperties()
                                 .getElements()
                                 .get(0)
                                 .getEndDate());
        Assert.assertNotNull(page
                                 .getResponse()
                                 .getProperties()
                                 .getElements()
                                 .get(0)
                                 .getOperationPhaseId());
        Assert.assertNotNull(page
                                 .getResponse()
                                 .getProperties()
                                 .getElements()
                                 .get(0)
                                 .getWorkplaceId());
    }

    /**
     * Tests getting recorded output quantities of an operation.
     *
     * @throws ForceAPIException    When unable to get recorded output quantities.
     * @throws InterruptedException When unable to take the request from the server.
     * @throws IOException          When unable to read the JSON file.
     * @throws URISyntaxException   When unable to create a URI of the JSON file.
     */
    @Test
    public void getOperationRecordedOutputQuantities() throws IOException, URISyntaxException, ForceAPIException, InterruptedException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getOperationRecordedOutputQuantities.json")));
        final GetOperationRecordedOutputQuantitiesRequest request = new GetOperationRecordedOutputQuantitiesRequest("operationId");
        request.setQualityTypeId(QualityType.REWORK);
        final OperationRecordedOutputQuantitiesPage page = mOperationClient.getRecordedOutputQuantities(request);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        //Verify request
        final RecordedRequest recordedRequest = mMockWebServer.takeRequest();
        final HttpUrl url = recordedRequest.getRequestUrl();
        Assert.assertNotNull(url);
        Assert.assertTrue(url
                              .toString()
                              .contains("operationId"));

        Assert.assertNotNull(page);
        Assert.assertNotNull(page
                                 .getResponse()
                                 .getPaginationLinks());
        Assert.assertNotNull(page
                                 .getResponse()
                                 .getPagination());
        Assert.assertNotNull(page
                                 .getResponse()
                                 .getProperties()
                                 .getElements()
                                 .get(0));
        Assert.assertNotNull(page
                                 .getResponse()
                                 .getProperties()
                                 .getElements()
                                 .get(0)
                                 .getBookingTime());
        Assert.assertNotNull(page
                                 .getResponse()
                                 .getProperties()
                                 .getElements()
                                 .get(0)
                                 .getQualityDetailId());
        Assert.assertNotNull(page
                                 .getResponse()
                                 .getProperties()
                                 .getElements()
                                 .get(0)
                                 .getQualityTypeId());
        Assert.assertNotNull(page
                                 .getResponse()
                                 .getProperties()
                                 .getElements()
                                 .get(0)
                                 .getQuantity());
    }

    /**
     * Tests requesting the alternative workplaces of an operation.
     *
     * @throws IOException          When unable to read the JSON file.
     * @throws URISyntaxException   When unable to create a URI of the JSON file.
     * @throws ForceAPIException    When unable to get the alternative workplaces.
     * @throws InterruptedException When unable to take the request from the server.
     */
    @Test
    public void getAlternativeWorkplaces() throws IOException, URISyntaxException, ForceAPIException, InterruptedException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getAlternativeWorkplaces.json")));

        final Page<WorkplaceResponse> response = mOperationClient.getAlternativeWorkplaces("operationId");

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        //Verify request
        final RecordedRequest recordedRequest = mMockWebServer.takeRequest();
        final HttpUrl url = recordedRequest.getRequestUrl();
        Assert.assertNotNull(url);
        Assert.assertTrue(url
                              .toString()
                              .contains("operationId"));

        Assert.assertNotNull(response);
        Assert.assertNull(response.getPagination());
        Assert.assertNull(response
                              .getResponse()
                              .getPaginationLinks());
        Assert.assertNotNull(response.getElements());
        Assert.assertNotNull(response
                                 .getResponse()
                                 .getEmbedded());
    }

    /**
     * Tests requesting the current production data of an operation.
     *
     * @throws IOException          When unable to read the JSON file.
     * @throws URISyntaxException   When unable to create a URI of the JSON file.
     * @throws ForceAPIException    When unable to get the current production data.
     * @throws InterruptedException When unable to take the request from the server.
     */
    @Test
    public void getCurrentProductionData() throws IOException, URISyntaxException, ForceAPIException, InterruptedException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getCurrentProductionData.json")));

        final GetOperationCurrentProductionDataRequest request = new GetOperationCurrentProductionDataRequest("operationId");
        request.setAdditionalOperationTime(Collections.singletonList("test"));
        final OperationCurrentProductionDataResponse response = mOperationClient.getCurrentProductionData(request);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        //Verify request
        final RecordedRequest recordedRequest = mMockWebServer.takeRequest();
        final HttpUrl url = recordedRequest.getRequestUrl();
        Assert.assertNotNull(url);
        Assert.assertTrue(url
                              .toString()
                              .contains("operationId"));
        ;
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getSelf());
        Assert.assertNotNull(response
                                 .getProperties()
                                 .getOperationPhaseId());
    }

    /**
     * Tests requesting the current production data of an operation.
     *
     * @throws IOException          When unable to read the JSON file.
     * @throws URISyntaxException   When unable to create a URI of the JSON file.
     * @throws ForceAPIException    When unable to get the current production data.
     * @throws InterruptedException When unable to take the request from the server.
     */
    @Test
    public void getCurrentProductionDataWithAdditionalOperationTime() throws IOException, URISyntaxException, ForceAPIException, InterruptedException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getCurrentProductionDataWithAdditionalOperationTime.json")));

        final GetOperationCurrentProductionDataRequest request = new GetOperationCurrentProductionDataRequest("operationId");
        request.setAdditionalOperationTime(Arrays.asList("test1", "test2"));
        final OperationCurrentProductionDataResponse response = mOperationClient.getCurrentProductionData(request);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        //Verify request
        final RecordedRequest recordedRequest = mMockWebServer.takeRequest();
        final HttpUrl url = recordedRequest.getRequestUrl();
        Assert.assertNotNull(url);
        Assert.assertTrue(url
                              .toString()
                              .contains("operationId"));
        ;
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getSelf());
        Assert.assertNotNull(response
                                 .getProperties()
                                 .getOperationPhaseId());
        final List<OperationTime> operationTimes = response
            .getProperties()
            .getOperationTimes();
        Assert.assertTrue(operationTimes.size() == 5);
        Assert.assertEquals(operationTimes
                                .get(3)
                                .getDuration(), 7905);
    }
}
