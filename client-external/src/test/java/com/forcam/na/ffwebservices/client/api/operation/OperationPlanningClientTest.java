////////////////////////////////////////////////////////////////////////////////
//
// Created by abhishekmundewal on 01-Jun-18.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.operation;

import com.forcam.na.ffwebservices.client.api.AbstractOpenAPIMockTest;
import com.forcam.na.ffwebservices.client.api.config.GuiceTestRunner;
import com.forcam.na.ffwebservices.client.api.exception.ForceAPIException;
import com.forcam.na.ffwebservices.client.api.operation.operationplanning.request.GetOperationPlanningResultRequest;
import com.forcam.na.ffwebservices.client.api.operation.operationplanning.request.GetOperationsForecastResultsRequest;
import com.forcam.na.ffwebservices.client.api.operation.operationplanning.request.GetOperationsPlanningResultsRequest;
import com.forcam.na.ffwebservices.client.api.operation.operationplanning.request.GetPlanningScenarioRequest;
import com.forcam.na.ffwebservices.client.api.operation.operationplanning.request.GetPlanningScenariosRequest;
import com.forcam.na.ffwebservices.client.api.operation.operationplanning.IOperationPlanningClient;
import com.forcam.na.ffwebservices.client.api.operation.operationplanning.response.OperationForecastResultPage;
import com.forcam.na.ffwebservices.client.api.operation.operationplanning.response.OperationForecastResultResponse;
import com.forcam.na.ffwebservices.client.api.operation.operationplanning.OperationPlanningClient;
import com.forcam.na.ffwebservices.client.api.operation.operationplanning.response.OperationPlanningResultResponse;
import com.forcam.na.ffwebservices.client.api.operation.operationplanning.response.OperationPlanningScenarioPage;
import com.forcam.na.ffwebservices.client.api.operation.operationplanning.response.OperationsPlanningResultPage;
import com.forcam.na.ffwebservices.client.api.operation.operationplanning.request.SetOperationForecastResultRequest;
import com.forcam.na.ffwebservices.client.api.operation.operationplanning.request.SetOperationPlanningResultRequest;
import com.forcam.na.ffwebservices.client.api.operation.operationplanning.request.UpdateOperationForecastResultsRequest;
import com.forcam.na.ffwebservices.client.api.pagination.response.Page;
import com.forcam.na.ffwebservices.model.operation.OperationAssignmentWSModel;
import com.forcam.na.ffwebservices.model.operation.OperationPlanningResultBodyWSModel;
import com.forcam.na.ffwebservices.model.operation.UpdateOperationForecastRequestBody;
import com.forcam.na.ffwebservices.model.planningscenarioassignment.PlanningScenarioResponse;
import okhttp3.HttpUrl;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.*;
import org.junit.rules.*;
import org.junit.runner.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Tests for the class {@link OperationPlanningClientTest}.
 */
@RunWith(GuiceTestRunner.class)
public class OperationPlanningClientTest extends AbstractOpenAPIMockTest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Helper for test exceptions and messages. */
    @Rule
    public ExpectedException mExpectedException = ExpectedException.none();

    /** The planning scenario assignment client. */
    private IOperationPlanningClient mOperationPlanningClient;

    // ------------------------------------------------------------------------
    // constructor
    // ------------------------------------------------------------------------

    public OperationPlanningClientTest() {
        mOperationPlanningClient = mBridgeAPIComponent.planningScenarioClient();
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Test
    public void getPlanningScenarios() throws IOException, URISyntaxException, ForceAPIException, InterruptedException {
        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getPlanningScenarios.json")));
        final int limit = 2;
        final GetPlanningScenariosRequest request = new GetPlanningScenariosRequest();
        request.setLimit(limit);

        final Page<PlanningScenarioResponse> response = mOperationPlanningClient.getPlanningScenarios(request);

        final RecordedRequest recordedRequest = mMockWebServer.takeRequest();
        final String requestQuery = recordedRequest
            .getRequestUrl()
            .query();
        Assert.assertNotNull(requestQuery);
        Assert.assertTrue(requestQuery.contains("limit=" + limit));

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
     * Test for the method {@link OperationPlanningClient#getPlanningScenario(GetPlanningScenarioRequest)}.
     *
     * @throws InterruptedException When unable to take the request from the server.
     * @throws IOException          When unable to read the JSON file.
     * @throws URISyntaxException   When unable to create a URI of the JSON file.
     * @throws ForceAPIException    When unable to get planning scenario.
     */
    @Test
    public void getPlanningScenario() throws IOException, URISyntaxException, ForceAPIException, InterruptedException {
        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getPlanningScenario.json")));

        final GetPlanningScenarioRequest request = new GetPlanningScenarioRequest();
        request.setPlanningScenarioId("100");

        final OperationPlanningScenarioPage response = mOperationPlanningClient.getPlanningScenario(request);

        final RecordedRequest recordedRequest = mMockWebServer.takeRequest();
        final HttpUrl requestUrl = recordedRequest.getRequestUrl();
        Assert.assertNotNull(requestUrl);
        Assert.assertTrue(requestUrl
                              .toString()
                              .contains("100"));

        Assert.assertNotNull(response);
        Assert.assertNotNull(response
                                 .getResponse()
                                 .getProperties());
    }

    /**
     * Tests getting machines while server is down.
     *
     * @throws IOException       When unable to shutdown the server.
     * @throws ForceAPIException When unable to get machines.
     */
    @Test
    public void getPlanningScenariosShutdown() throws IOException, ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------
        final int limit = 2;
        final GetPlanningScenariosRequest request = new GetPlanningScenariosRequest();
        request.setLimit(limit);

        mMockWebServer.shutdown();
        mExpectedException.expect(ForceAPIException.class);
        mExpectedException.expectMessage("Unable to execute call using request: " + request);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mOperationPlanningClient.getPlanningScenarios(request);
    }

    /**
     * Tests getting planning result of an operation.
     *
     * @throws ForceAPIException    When unable to get operation planning result.
     * @throws InterruptedException When unable to take the request from the server.
     * @throws IOException          When unable to read the JSON file.
     * @throws URISyntaxException   When unable to create a URI of the JSON file.
     */
    @Test
    public void getOperationPlanningResult() throws IOException, URISyntaxException, ForceAPIException, InterruptedException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getOperationPlanningResult.json")));
        final GetOperationPlanningResultRequest request = new GetOperationPlanningResultRequest("550CE9EA03934C968E9B43EA67F2AEA9");
        final OperationPlanningResultResponse response = mOperationPlanningClient.getOperationPlanningResult(request);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        //Verify request
        final RecordedRequest recordedRequest = mMockWebServer.takeRequest();
        final String requestQuery = recordedRequest
            .getRequestUrl()
            .query();
        Assert.assertNotNull(requestQuery);

        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getSelf());
        Assert.assertNotNull(response
                                 .getProperties()
                                 .getEndDate());
        Assert.assertNotNull(response
                                 .getProperties()
                                 .getProcessingEndDate());
        Assert.assertNotNull(response
                                 .getProperties()
                                 .getSetupEndDate());
        Assert.assertNotNull(response
                                 .getProperties()
                                 .getProcessingStartDate());
        Assert.assertNotNull(response
                                 .getProperties()
                                 .getSetupStartDate());
        Assert.assertNotNull(response
                                 .getProperties()
                                 .getStartDate());
    }

    /**
     * Tests getting planning results of all operations.
     *
     * @throws ForceAPIException    When unable to get operations planning results.
     * @throws InterruptedException When unable to take the request from the server.
     * @throws IOException          When unable to read the JSON file.
     * @throws URISyntaxException   When unable to create a URI of the JSON file.
     */
    @Test
    public void getOperationPlanningResults() throws IOException, URISyntaxException, ForceAPIException, InterruptedException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getOperationPlanningResults.json")));
        final GetOperationsPlanningResultsRequest request = new GetOperationsPlanningResultsRequest();
        final OperationsPlanningResultPage page = mOperationPlanningClient.getOperationsPlanningResults(request);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        //Verify request
        final RecordedRequest recordedRequest = mMockWebServer.takeRequest();
        final String requestQuery = recordedRequest
            .getRequestUrl()
            .query();
        Assert.assertNotNull(requestQuery);

        Assert.assertNotNull(page);
        Assert.assertFalse(page
                               .getResponse()
                               .getElements()
                               .isEmpty());
        Assert.assertNotNull(page
                                 .getResponse()
                                 .getProperties()
                                 .getOccupancyRate());
        Assert.assertNotNull(page
                                 .getResponse()
                                 .getProperties()
                                 .getSetupReduction());
        Assert.assertNotNull(page
                                 .getResponse()
                                 .getProperties()
                                 .getSchedulingEfficiency());
        Assert.assertNotNull(page
                                 .getResponse()
                                 .getPaginationLinks());
        Assert.assertNotNull(page
                                 .getResponse()
                                 .getPagination());
    }

    /**
     * Tests saving operation planning result.
     *
     * @throws ForceAPIException    When unable to save operation planning result.
     * @throws InterruptedException When unable to take the request from the server.
     * @throws IOException          When unable to read the JSON file.
     * @throws URISyntaxException   When unable to create a URI of the JSON file.
     */
    @Test
    public void saveOperationPlanningResult() throws IOException, URISyntaxException, ForceAPIException, InterruptedException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getOperationPlanningResult.json")));
        final SetOperationPlanningResultRequest request = new SetOperationPlanningResultRequest("operationId");
        final OperationPlanningResultResponse response = mOperationPlanningClient.saveOperationPlanningResult(request);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final RecordedRequest recordedRequest = mMockWebServer.takeRequest();
        final String body = recordedRequest
            .getBody()
            .readUtf8();
        final OperationAssignmentWSModel requestModel = mMapper.readValue(body, OperationAssignmentWSModel.class);
        Assert.assertEquals(request.getPlanningResult(), requestModel);

        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getSelf());
        Assert.assertNotNull(response.getProperties());
        Assert.assertNotNull(response
                                 .getProperties()
                                 .getEndDate());
        Assert.assertNotNull(response
                                 .getProperties()
                                 .getProcessingEndDate());
        Assert.assertNotNull(response
                                 .getProperties()
                                 .getSetupEndDate());
        Assert.assertNotNull(response
                                 .getProperties()
                                 .getProcessingStartDate());
        Assert.assertNotNull(response
                                 .getProperties()
                                 .getSetupStartDate());
        Assert.assertNotNull(response
                                 .getProperties()
                                 .getStartDate());
    }

    /**
     * Tests deleting operation planning result while server is down.
     *
     * @throws IOException       When unable to shutdown the server.
     * @throws ForceAPIException When unable to delete operation planning result.
     */
    @Test
    public void deleteOperationPlanningResultShutdown() throws ForceAPIException, IOException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        mMockWebServer.shutdown();
        mExpectedException.expect(ForceAPIException.class);
        mExpectedException.expectMessage("Unable to execute call using request url: operationId");

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mOperationPlanningClient.deleteOperationPlanningResult("operationId");
    }

    /**
     * Tests deleting operation planning result while server is down.
     *
     * @throws IOException       When unable to shutdown the server.
     * @throws ForceAPIException When unable to delete operation planning result.
     */
    @Test
    public void updateOperationsPlanningResultsShutdown() throws ForceAPIException, IOException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        mMockWebServer.shutdown();
        mExpectedException.expect(ForceAPIException.class);
        mExpectedException.expectMessage("Unable to execute call using request: OperationPlanningResultBodyWSModel[assignment=<null>]");

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final OperationPlanningResultBodyWSModel bodyWSModel = new OperationPlanningResultBodyWSModel();
        mOperationPlanningClient.updateOperationsPlanningResults(bodyWSModel);
    }

    /**
     * Tests deleting operation forecast result while server is down.
     *
     * @throws IOException       When unable to shutdown the server.
     * @throws ForceAPIException When unable to delete operation forecast result.
     */
    @Test
    public void deleteOperationForecastResultShutdown() throws ForceAPIException, IOException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        mMockWebServer.shutdown();
        mExpectedException.expect(ForceAPIException.class);
        mExpectedException.expectMessage("Unable to execute call using request url: operationId");

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mOperationPlanningClient.deleteOperationForecastResult("operationId");
    }

    /**
     * Tests getting forecast result of an operation.
     *
     * @throws ForceAPIException    When unable to get operation forecast result.
     * @throws InterruptedException When unable to take the request from the server.
     * @throws IOException          When unable to read the JSON file.
     * @throws URISyntaxException   When unable to create a URI of the JSON file.
     */
    @Test
    public void getOperationForecastResult() throws IOException, URISyntaxException, ForceAPIException, InterruptedException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getOperationForecastResult.json")));
        final OperationForecastResultResponse response = mOperationPlanningClient.getOperationForecastResult("operationId");

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
                                 .getEndDate());
        Assert.assertNotNull(response
                                 .getProperties()
                                 .getProcessingEndDate());
        Assert.assertNotNull(response
                                 .getProperties()
                                 .getSetupEndDate());
        Assert.assertNotNull(response
                                 .getProperties()
                                 .getProcessingStartDate());
        Assert.assertNotNull(response
                                 .getProperties()
                                 .getSetupStartDate());
        Assert.assertNotNull(response
                                 .getProperties()
                                 .getStartDate());
        Assert.assertNotNull(response
                                 .getProperties()
                                 .getWorkplaceId());
        Assert.assertNotNull(response
                                 .getProperties()
                                 .getOperationId());
    }

    /**
     * Tests getting all operations forecast results.
     *
     * @throws ForceAPIException    When unable to get operations forecast results.
     * @throws InterruptedException When unable to take the request from the server.
     * @throws IOException          When unable to read the JSON file.
     * @throws URISyntaxException   When unable to create a URI of the JSON file.
     */
    @Test
    public void getOperationsForecastResults() throws IOException, URISyntaxException, ForceAPIException, InterruptedException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getOperationForecastResults.json")));
        final GetOperationsForecastResultsRequest request = new GetOperationsForecastResultsRequest();
        final OperationForecastResultPage page = mOperationPlanningClient.getOperationsForecastResults(request);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        //Verify request
        final RecordedRequest recordedRequest = mMockWebServer.takeRequest();
        final HttpUrl url = recordedRequest.getRequestUrl();
        Assert.assertNotNull(url);

        Assert.assertNotNull(page);
        Assert.assertNotNull(page.getResponse());
        Assert.assertNotNull(page
                                 .getResponse()
                                 .getProperties()
                                 .getEndDate());
        Assert.assertNotNull(page
                                 .getResponse()
                                 .getProperties()
                                 .getStartDate());
        Assert.assertNotNull(page
                                 .getResponse()
                                 .getProperties()
                                 .getNumberOfPlannedProductionOrders());
        Assert.assertNotNull(page
                                 .getResponse()
                                 .getProperties()
                                 .getAdherenceToDeliveryDates());
        Assert.assertNotNull(page
                                 .getResponse()
                                 .getProperties()
                                 .getMinimumLeadTimeWithSetup());
        Assert.assertNotNull(page
                                 .getResponse()
                                 .getProperties()
                                 .getOccupancyRate());
        Assert.assertNotNull(page
                                 .getResponse()
                                 .getElements()
                                 .get(0)
                                 .getProperties()
                                 .getWorkplaceId());
        Assert.assertNotNull(page
                                 .getResponse()
                                 .getElements()
                                 .get(0)
                                 .getProperties()
                                 .getProcessingStartDate());
        Assert.assertNotNull(page
                                 .getResponse()
                                 .getElements()
                                 .get(0)
                                 .getProperties()
                                 .getSetupStartDate());
    }

    /**
     * Tests saving forecast result of an operation.
     *
     * @throws ForceAPIException    When unable to save operation forecast result.
     * @throws InterruptedException When unable to take the request from the server.
     * @throws IOException          When unable to read the JSON file.
     * @throws URISyntaxException   When unable to create a URI of the JSON file.
     */
    @Test
    public void saveOperationForecastResult() throws IOException, URISyntaxException, ForceAPIException, InterruptedException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getOperationForecastResult.json")));
        final SetOperationForecastResultRequest request = new SetOperationForecastResultRequest("operationId");
        request
            .getForecastResult()
            .setStartDate(new Date());
        request
            .getForecastResult()
            .setEndDate(new Date());
        request
            .getForecastResult()
            .setSetupStartDate(new Date());
        request
            .getForecastResult()
            .setSetupEndDate(new Date());
        request
            .getForecastResult()
            .setProcessingStartDate(new Date());
        request
            .getForecastResult()
            .setProcessingEndDate(new Date());
        final OperationForecastResultResponse response = mOperationPlanningClient.saveOperationForecastResult(request);

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
                                 .getEndDate());
        Assert.assertNotNull(response
                                 .getProperties()
                                 .getProcessingEndDate());
        Assert.assertNotNull(response
                                 .getProperties()
                                 .getSetupEndDate());
        Assert.assertNotNull(response
                                 .getProperties()
                                 .getProcessingStartDate());
        Assert.assertNotNull(response
                                 .getProperties()
                                 .getSetupStartDate());
        Assert.assertNotNull(response
                                 .getProperties()
                                 .getStartDate());
    }

    /**
     * Tests updating forecast results of operations.
     *
     * @throws ForceAPIException    When unable to update operation forecast results.
     * @throws InterruptedException When unable to take the request from the server.
     */
    @Test
    public void updateOperationForecastResult() throws ForceAPIException, InterruptedException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        mMockWebServer.enqueue(new MockResponse());
        final UpdateOperationForecastResultsRequest request = new UpdateOperationForecastResultsRequest();
        final UpdateOperationForecastRequestBody body = new UpdateOperationForecastRequestBody();

        final OperationAssignmentWSModel assignmentWSModel = new OperationAssignmentWSModel();
        assignmentWSModel.setOperationId("operationId");
        assignmentWSModel.setProcessingEndDate(new Date());
        assignmentWSModel.setProcessingStartDate(new Date());
        assignmentWSModel.setSetupStartDate(new Date());
        assignmentWSModel.setSetupEndDate(new Date());
        assignmentWSModel.setStartDate(new Date());
        assignmentWSModel.setEndDate(new Date());

        final List<OperationAssignmentWSModel> assignmentWSModels = new ArrayList<>(1);
        assignmentWSModels.add(assignmentWSModel);

        body.setForecastResults(assignmentWSModels);
        request.setForecastResults(body);

        mOperationPlanningClient.updateOperationForecastResults(request);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        //Verify request
        final RecordedRequest recordedRequest = mMockWebServer.takeRequest();
        final HttpUrl url = recordedRequest.getRequestUrl();
        Assert.assertNotNull(url);
    }
}
