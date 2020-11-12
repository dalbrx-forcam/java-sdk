////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 10.01.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.masterdata;

import com.forcam.na.ffwebservices.client.api.AbstractOpenAPIMockTest;
import com.forcam.na.ffwebservices.client.api.config.GuiceTestRunner;
import com.forcam.na.ffwebservices.client.api.exception.ForceAPIException;
import com.forcam.na.ffwebservices.client.api.pagination.request.CollectionRequest;
import com.forcam.na.ffwebservices.client.api.pagination.response.Page;
import com.forcam.na.ffwebservices.client.api.qualitydetail.request.GetQualityDetailRequest;
import com.forcam.na.ffwebservices.client.api.qualitydetail.request.GetQualityDetailsRequest;
import com.forcam.na.ffwebservices.client.api.qualitytype.request.GetQualityTypeRequest;
import com.forcam.na.ffwebservices.client.api.qualitytype.request.GetQualityTypesRequest;
import com.forcam.na.ffwebservices.client.api.shifttype.request.GetShiftTypeRequest;
import com.forcam.na.ffwebservices.client.api.shifttype.request.GetShiftTypesRequest;
import com.forcam.na.ffwebservices.client.api.specificsettings.request.GetCustomerSpecificSettingCollectionRequest;
import com.forcam.na.ffwebservices.client.api.specificsettings.request.GetCustomerSpecificSettingRequest;
import com.forcam.na.ffwebservices.client.api.specificsettings.response.CustomerSpecificSettingResponse;
import com.forcam.na.ffwebservices.client.api.ticket.request.GetTicketActivityStateRequest;
import com.forcam.na.ffwebservices.client.api.ticket.request.GetTicketClassRequest;
import com.forcam.na.ffwebservices.client.api.ticket.request.GetTicketClassesRequest;
import com.forcam.na.ffwebservices.client.api.ticket.request.GetTicketStateRequest;
import com.forcam.na.ffwebservices.client.api.ticket.request.GetTicketStatesRequest;
import com.forcam.na.ffwebservices.client.statusdefinition.request.GetOperatingStateClassCollectionRequest;
import com.forcam.na.ffwebservices.client.statusdefinition.request.GetOperatingStateClassRequest;
import com.forcam.na.ffwebservices.client.statusdefinition.request.GetOperatingStateCollectionRequest;
import com.forcam.na.ffwebservices.client.statusdefinition.request.GetOperatingStateRequest;
import com.forcam.na.ffwebservices.client.statusdefinition.request.GetOperationPhaseCollectionRequest;
import com.forcam.na.ffwebservices.client.statusdefinition.request.GetOperationPhaseRequest;
import com.forcam.na.ffwebservices.client.statusdefinition.request.GetToolAssemblyOrderStateCollectionRequest;
import com.forcam.na.ffwebservices.client.statusdefinition.request.GetToolAssemblyOrderStateRequest;
import com.forcam.na.ffwebservices.client.statusdefinition.request.GetWorkplaceStateCollectionRequest;
import com.forcam.na.ffwebservices.client.statusdefinition.request.GetWorkplaceStateRequest;
import com.forcam.na.ffwebservices.model.definition.OperationPhase;
import com.forcam.na.ffwebservices.model.definition.ToolAssemblyOrderState;
import com.forcam.na.ffwebservices.model.definition.WorkplaceState;
import com.forcam.na.ffwebservices.model.qualitydetail.QualityDetailResponse;
import com.forcam.na.ffwebservices.model.qualitydetail.QualityType;
import com.forcam.na.ffwebservices.model.qualitytype.QualityTypeResponse;
import com.forcam.na.ffwebservices.model.shifttype.ShiftTypeResponse;
import com.forcam.na.ffwebservices.model.statusdefinition.OperatingStateResponse;
import com.forcam.na.ffwebservices.model.statusdefinition.StatusDefinitionResponse;
import com.forcam.na.ffwebservices.model.ticket.TicketActivityState;
import com.forcam.na.ffwebservices.model.ticket.TicketActivityStateResponse;
import com.forcam.na.ffwebservices.model.ticket.TicketClassResponse;
import com.forcam.na.ffwebservices.model.ticket.TicketState;
import com.forcam.na.ffwebservices.model.ticket.TicketStateResponse;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.*;
import org.junit.rules.*;
import org.junit.runner.*;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Tests for the class {@link MasterDataClient}.
 */
@RunWith(GuiceTestRunner.class)
public class MasterDataClientTest extends AbstractOpenAPIMockTest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Helper for test exceptions and messages. */
    @Rule
    public ExpectedException mExpectedException = ExpectedException.none();

    /** The master data client. */
    private IMasterDataClient mMasterDataClient;

    // ------------------------------------------------------------------------
    // constructor
    // ------------------------------------------------------------------------

    public MasterDataClientTest() {
        mMasterDataClient = mBridgeAPIComponent.masterDataClient();
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    /**
     * Test for the method {@link MasterDataClient#getOperatingStateClasses(GetOperatingStateClassCollectionRequest)}.
     *
     * @throws ForceAPIException    When unable to get operating state classes.
     * @throws InterruptedException When unable to take the request from the server.
     * @throws IOException          When unable to read the JSON file.
     * @throws URISyntaxException   When unable to create a URI of the JSON file.
     */
    @Test
    public void testGetOperatingStateClasses() throws ForceAPIException, InterruptedException, IOException, URISyntaxException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getOperatingStateClasses.json")));
        final int limit = 3;
        final int offset = 0;
        final GetOperatingStateClassCollectionRequest request = new GetOperatingStateClassCollectionRequest();
        request
            .setLimit(limit)
            .setOffset(offset);

        final Page<StatusDefinitionResponse> response = mMasterDataClient.getOperatingStateClasses(request);

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
     * Test for the method {@link MasterDataClient#getOperatingStateClass(GetOperatingStateClassRequest)}.
     *
     * @throws ForceAPIException    When unable to get operating state class.
     * @throws InterruptedException When unable to take the request from the server.
     * @throws IOException          When unable to read the JSON file.
     * @throws URISyntaxException   When unable to create a URI of the JSON file.
     */
    @Test
    public void testGetOperatingStateClass() throws ForceAPIException, InterruptedException, IOException, URISyntaxException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getOperatingStateClass.json")));
        final GetOperatingStateClassRequest request = new GetOperatingStateClassRequest("TESTID");
        request
            .embed()
            .description(true)
            .shortDescription(true);
        final StatusDefinitionResponse response = mMasterDataClient.getOperatingStateClass(request);

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

        //Verify response model
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getSelf());
        Assert.assertNotNull(response.getDescription());
        Assert.assertNotNull(response
                                 .getDescription()
                                 .getLink());
        Assert.assertNotNull(response.getShortDescription());
        Assert.assertNotNull(response
                                 .getShortDescription()
                                 .getLink());
        Assert.assertNotNull(response.getProperties());
        Assert.assertNotNull(response
                                 .getProperties()
                                 .getId());
    }

    /**
     * Test for the method {@link MasterDataClient#getOperatingStates(GetOperatingStateCollectionRequest)}.
     *
     * @throws ForceAPIException    When unable to get operating states.
     * @throws InterruptedException When unable to take the request from the server.
     * @throws IOException          When unable to read the JSON file.
     * @throws URISyntaxException   When unable to create a URI of the JSON file.
     */
    @Test
    public void testGetOperatingStates() throws ForceAPIException, InterruptedException, IOException, URISyntaxException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getOperatingStates.json")));
        final int limit = 3;
        final int offset = 0;
        final GetOperatingStateCollectionRequest request = new GetOperatingStateCollectionRequest();
        request
            .setLimit(limit)
            .setOffset(offset);
        request
            .embed()
            .operatingStateClass(true)
            .workplaceState(true)
            .description(true)
            .shortDescription(true);

        final Page<OperatingStateResponse> response = mMasterDataClient.getOperatingStates(request);

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
        Assert.assertFalse(response
                               .getElements()
                               .isEmpty());
    }

    /**
     * Test for the method {@link MasterDataClient#getOperatingState(GetOperatingStateRequest)}.
     *
     * @throws ForceAPIException    When unable to get operating state.
     * @throws InterruptedException When unable to take the request from the server.
     * @throws IOException          When unable to read the JSON file.
     * @throws URISyntaxException   When unable to create a URI of the JSON file.
     */
    @Test
    public void testGetOperatingState() throws ForceAPIException, InterruptedException, IOException, URISyntaxException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getOperatingState.json")));
        final GetOperatingStateRequest request = new GetOperatingStateRequest("TESTID");
        request
            .embed()
            .operatingStateClass(true)
            .workplaceState(true)
            .description(true)
            .shortDescription(true);
        final OperatingStateResponse response = mMasterDataClient.getOperatingState(request);

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

        //Verify response model
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getSelf());
        Assert.assertNotNull(response.getDescription());
        Assert.assertNotNull(response
                                 .getDescription()
                                 .getLink());
        Assert.assertNotNull(response.getShortDescription());
        Assert.assertNotNull(response
                                 .getShortDescription()
                                 .getLink());
        Assert.assertNotNull(response.getOperatingStateClass());
        Assert.assertNotNull(response.getWorkplaceState());
        Assert.assertNotNull(response
                                 .getWorkplaceState()
                                 .getLink());
        Assert.assertNotNull(response.getProperties());
        Assert.assertNotNull(response
                                 .getProperties()
                                 .getId());
    }

    /**
     * Test for the method {@link MasterDataClient#getOperationPhases(GetOperationPhaseCollectionRequest)}.
     *
     * @throws ForceAPIException    When unable to get operation phases.
     * @throws InterruptedException When unable to take the request from the server.
     * @throws IOException          When unable to read the JSON file.
     * @throws URISyntaxException   When unable to create a URI of the JSON file.
     */
    @Test
    public void testGetOperationPhases() throws ForceAPIException, InterruptedException, IOException, URISyntaxException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getOperationPhases.json")));
        final int limit = 3;
        final int offset = 0;
        final GetOperationPhaseCollectionRequest request = new GetOperationPhaseCollectionRequest();
        request
            .setLimit(limit)
            .setOffset(offset);

        final Page<StatusDefinitionResponse> page = mMasterDataClient.getOperationPhases(request);

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
     * Test for the method {@link MasterDataClient#getOperationPhase(GetOperationPhaseRequest)}.
     *
     * @throws ForceAPIException    When unable to get operation phase.
     * @throws InterruptedException When unable to take the request from the server.
     * @throws IOException          When unable to read the JSON file.
     * @throws URISyntaxException   When unable to create a URI of the JSON file.
     */
    @Test
    public void testGetOperationPhase() throws ForceAPIException, InterruptedException, IOException, URISyntaxException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getOperationPhase.json")));
        final GetOperationPhaseRequest request = new GetOperationPhaseRequest(OperationPhase.RELEASED);
        request
            .embed()
            .description(true)
            .shortDescription(true);
        final StatusDefinitionResponse response = mMasterDataClient.getOperationPhase(request);

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

        //Verify response model
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getSelf());
        Assert.assertNotNull(response.getDescription());
        Assert.assertNotNull(response
                                 .getDescription()
                                 .getLink());
        Assert.assertNotNull(response.getShortDescription());
        Assert.assertNotNull(response
                                 .getShortDescription()
                                 .getLink());
        Assert.assertNotNull(response.getProperties());
        Assert.assertNotNull(response
                                 .getProperties()
                                 .getId());
    }

    /**
     * Test for the method {@link MasterDataClient#getQualityDetails(GetQualityDetailsRequest)}.
     *
     * @throws ForceAPIException    When unable to get quality details.
     * @throws InterruptedException When unable to take the request from the server.
     * @throws IOException          When unable to read the JSON file.
     * @throws URISyntaxException   When unable to create a URI of the JSON file.
     */
    @Test
    public void testGetQualityDetails() throws ForceAPIException, InterruptedException, IOException, URISyntaxException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getQualityDetails.json")));
        final int limit = 3;
        final int offset = 0;
        final GetQualityDetailsRequest request = new GetQualityDetailsRequest();
        request
            .setLimit(limit)
            .setOffset(offset);
        request
            .embed()
            .qualityType(true)
            .description(true)
            .shortDescription(true);

        final Page<QualityDetailResponse> response = mMasterDataClient.getQualityDetails(request);

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
     * Test for the method {@link MasterDataClient#getQualityDetail(GetQualityDetailRequest)}.
     *
     * @throws ForceAPIException    When unable to get quality detail.
     * @throws InterruptedException When unable to take the request from the server.
     * @throws IOException          When unable to read the JSON file.
     * @throws URISyntaxException   When unable to create a URI of the JSON file.
     */
    @Test
    public void testGetQualityDetail() throws ForceAPIException, InterruptedException, IOException, URISyntaxException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getQualityDetail.json")));
        final GetQualityDetailRequest request = new GetQualityDetailRequest("TESTID");
        request
            .embed()
            .qualityType(true)
            .description(true)
            .shortDescription(true);
        final QualityDetailResponse response = mMasterDataClient.getQualityDetail(request);

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

        //Verify response model
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getSelf());
        Assert.assertNotNull(response.getDescription());
        Assert.assertNotNull(response
                                 .getDescription()
                                 .getLink());
        Assert.assertNotNull(response.getShortDescription());
        Assert.assertNotNull(response
                                 .getShortDescription()
                                 .getLink());
        Assert.assertNotNull(response.getQualityType());
        Assert.assertNotNull(response
                                 .getQualityType()
                                 .getLink());
        Assert.assertNotNull(response.getProperties());
        Assert.assertNotNull(response
                                 .getProperties()
                                 .getId());
    }

    /**
     * Test for the method {@link MasterDataClient#getQualityTypes(GetQualityTypesRequest)}.
     *
     * @throws ForceAPIException    When unable to get quality types.
     * @throws InterruptedException When unable to take the request from the server.
     * @throws IOException          When unable to read the JSON file.
     * @throws URISyntaxException   When unable to create a URI of the JSON file.
     */
    @Test
    public void testGetQualityTypes() throws ForceAPIException, InterruptedException, IOException, URISyntaxException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getQualityTypes.json")));
        final int limit = 3;
        final int offset = 0;
        final GetQualityTypesRequest request = new GetQualityTypesRequest();
        request
            .setLimit(limit)
            .setOffset(offset);
        request
            .embed()
            .description(true)
            .shortDescription(true);

        final Page<QualityTypeResponse> page = mMasterDataClient.getQualityTypes(request);

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
     * Test for the method {@link MasterDataClient#getQualityType(GetQualityTypeRequest)}.
     *
     * @throws ForceAPIException    When unable to get quality type.
     * @throws InterruptedException When unable to take the request from the server.
     * @throws IOException          When unable to read the JSON file.
     * @throws URISyntaxException   When unable to create a URI of the JSON file.
     */
    @Test
    public void testGetQualityType() throws ForceAPIException, InterruptedException, IOException, URISyntaxException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getQualityType.json")));
        final GetQualityTypeRequest request = new GetQualityTypeRequest(QualityType.YIELD);
        request
            .embed()
            .description(true)
            .shortDescription(true);
        final QualityTypeResponse response = mMasterDataClient.getQualityType(request);

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

        //Verify response model
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getSelf());
        Assert.assertNotNull(response.getDescription());
        Assert.assertNotNull(response
                                 .getDescription()
                                 .getLink());
        Assert.assertNotNull(response.getShortDescription());
        Assert.assertNotNull(response
                                 .getShortDescription()
                                 .getLink());
        Assert.assertNotNull(response.getProperties());
        Assert.assertNotNull(response
                                 .getProperties()
                                 .getId());
    }

    /**
     * Test for the method {@link MasterDataClient#getShiftTypes(GetShiftTypesRequest)}.
     *
     * @throws ForceAPIException    When unable to get shift types.
     * @throws InterruptedException When unable to take the request from the server.
     * @throws IOException          When unable to read the JSON file.
     * @throws URISyntaxException   When unable to create a URI of the JSON file.
     */
    @Test
    public void testGetShiftTypes() throws ForceAPIException, InterruptedException, IOException, URISyntaxException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getShiftTypes.json")));
        final int limit = 3;
        final int offset = 0;
        final GetShiftTypesRequest request = new GetShiftTypesRequest();
        request
            .setLimit(limit)
            .setOffset(offset);
        request
            .embed()
            .description(true)
            .shortDescription(true);

        final Page<ShiftTypeResponse> page = mMasterDataClient.getShiftTypes(request);

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
     * Test for the method {@link MasterDataClient#getShiftType(GetShiftTypeRequest)}.
     *
     * @throws ForceAPIException    When unable to get shift type.
     * @throws InterruptedException When unable to take the request from the server.
     * @throws IOException          When unable to read the JSON file.
     * @throws URISyntaxException   When unable to create a URI of the JSON file.
     */
    @Test
    public void testGetShiftType() throws ForceAPIException, InterruptedException, IOException, URISyntaxException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getShiftType.json")));
        final GetShiftTypeRequest request = new GetShiftTypeRequest("TESTID");
        request
            .embed()
            .description(true)
            .shortDescription(true);
        final ShiftTypeResponse response = mMasterDataClient.getShiftType(request);

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

        //Verify response model
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getSelf());
        Assert.assertNotNull(response.getDescription());
        Assert.assertNotNull(response
                                 .getDescription()
                                 .getLink());
        Assert.assertNotNull(response.getShortDescription());
        Assert.assertNotNull(response
                                 .getShortDescription()
                                 .getLink());
        Assert.assertNotNull(response.getProperties());
        Assert.assertNotNull(response
                                 .getProperties()
                                 .getId());
    }

    /**
     * Test for the method {@link MasterDataClient#getToolAssemblyOrderStates(GetToolAssemblyOrderStateCollectionRequest)}.
     *
     * @throws ForceAPIException    When unable to get tool assembly order states.
     * @throws InterruptedException When unable to take the request from the server.
     * @throws IOException          When unable to read the JSON file.
     * @throws URISyntaxException   When unable to create a URI of the JSON file.
     */
    @Test
    public void testGetToolAssemblyOrderStates() throws ForceAPIException, InterruptedException, IOException, URISyntaxException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getToolAssemblyOrderStates.json")));
        final int limit = 3;
        final int offset = 0;
        final GetToolAssemblyOrderStateCollectionRequest request = new GetToolAssemblyOrderStateCollectionRequest();
        request
            .setLimit(limit)
            .setOffset(offset);

        final Page<StatusDefinitionResponse> response = mMasterDataClient.getToolAssemblyOrderStates(request);

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
     * Test for the method {@link MasterDataClient#getToolAssemblyOrderState(GetToolAssemblyOrderStateRequest)}.
     *
     * @throws ForceAPIException    When unable to get tool assembly order state.
     * @throws InterruptedException When unable to take the request from the server.
     * @throws IOException          When unable to read the JSON file.
     * @throws URISyntaxException   When unable to create a URI of the JSON file.
     */
    @Test
    public void testGetToolAssemblyOrderState() throws ForceAPIException, InterruptedException, IOException, URISyntaxException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getToolAssemblyOrderState.json")));
        final GetToolAssemblyOrderStateRequest request = new GetToolAssemblyOrderStateRequest(ToolAssemblyOrderState.REQUESTED);
        request
            .embed()
            .description(true)
            .shortDescription(true);
        final StatusDefinitionResponse response = mMasterDataClient.getToolAssemblyOrderState(request);

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

        //Verify response model
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getSelf());
        Assert.assertNotNull(response.getDescription());
        Assert.assertNotNull(response
                                 .getDescription()
                                 .getLink());
        Assert.assertNotNull(response.getShortDescription());
        Assert.assertNotNull(response
                                 .getShortDescription()
                                 .getLink());
        Assert.assertNotNull(response.getProperties());
        Assert.assertNotNull(response
                                 .getProperties()
                                 .getId());
    }

    /**
     * Test for the method {@link MasterDataClient#getWorkplaceStates(GetWorkplaceStateCollectionRequest)}.
     *
     * @throws ForceAPIException    When unable to get workplace states.
     * @throws InterruptedException When unable to take the request from the server.
     * @throws IOException          When unable to read the JSON file.
     * @throws URISyntaxException   When unable to create a URI of the JSON file.
     */
    @Test
    public void testGetWorkplaceStates() throws ForceAPIException, InterruptedException, IOException, URISyntaxException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getWorkplaceStates.json")));
        final int limit = 3;
        final int offset = 0;
        final GetWorkplaceStateCollectionRequest request = new GetWorkplaceStateCollectionRequest();
        request
            .setLimit(limit)
            .setOffset(offset);

        final Page<StatusDefinitionResponse> page = mMasterDataClient.getWorkplaceStates(request);

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
     * Test for the method {@link MasterDataClient#getWorkplaceState(GetWorkplaceStateRequest)}.
     *
     * @throws ForceAPIException    When unable to get workplace state.
     * @throws InterruptedException When unable to take the request from the server.
     * @throws IOException          When unable to read the JSON file.
     * @throws URISyntaxException   When unable to create a URI of the JSON file.
     */
    @Test
    public void testGetWorkplaceState() throws ForceAPIException, InterruptedException, IOException, URISyntaxException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getWorkplaceState.json")));
        final GetWorkplaceStateRequest request = new GetWorkplaceStateRequest(WorkplaceState.DOWNTIME);
        request
            .embed()
            .description(true)
            .shortDescription(true);
        final StatusDefinitionResponse response = mMasterDataClient.getWorkplaceState(request);

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

        //Verify response model
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getSelf());
        Assert.assertNotNull(response.getDescription());
        Assert.assertNotNull(response
                                 .getDescription()
                                 .getLink());
        Assert.assertNotNull(response.getShortDescription());
        Assert.assertNotNull(response
                                 .getShortDescription()
                                 .getLink());
        Assert.assertNotNull(response.getProperties());
        Assert.assertNotNull(response
                                 .getProperties()
                                 .getId());
    }

    /**
     * Tests getting operating state classes while server is down.
     *
     * @throws IOException       When unable to shutdown the server.
     * @throws ForceAPIException When unable to get operating state classes.
     */
    @Test
    public void getOperatingStateClassesShutdown() throws IOException, ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final GetOperatingStateClassCollectionRequest request = new GetOperatingStateClassCollectionRequest();
        mMockWebServer.shutdown();
        mExpectedException.expect(ForceAPIException.class);
        mExpectedException.expectMessage("Unable to execute call using request: " + request);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mMasterDataClient.getOperatingStateClasses(request);
    }

    /**
     * Tests getting operating state class while server is down.
     *
     * @throws IOException       When unable to shutdown the server.
     * @throws ForceAPIException When unable to get operating state class.
     */
    @Test
    public void getOperatingStateClassShutdown() throws IOException, ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final GetOperatingStateClassRequest request = new GetOperatingStateClassRequest("operatingStateClassId");
        mMockWebServer.shutdown();
        mExpectedException.expect(ForceAPIException.class);
        mExpectedException.expectMessage("Unable to execute call using request: " + request);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mMasterDataClient.getOperatingStateClass(request);
    }

    /**
     * Tests getting operating states while server is down.
     *
     * @throws IOException       When unable to shutdown the server.
     * @throws ForceAPIException When unable to get operating states.
     */
    @Test
    public void getOperatingStatesShutdown() throws IOException, ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final GetOperatingStateCollectionRequest request = new GetOperatingStateCollectionRequest();
        mMockWebServer.shutdown();
        mExpectedException.expect(ForceAPIException.class);
        mExpectedException.expectMessage("Unable to execute call using request: " + request);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mMasterDataClient.getOperatingStates(request);
    }

    /**
     * Tests getting operating state while server is down.
     *
     * @throws IOException       When unable to shutdown the server.
     * @throws ForceAPIException When unable to get operating state.
     */
    @Test
    public void getOperatingStateShutdown() throws IOException, ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final GetOperatingStateRequest request = new GetOperatingStateRequest("operatingStateId");
        mMockWebServer.shutdown();
        mExpectedException.expect(ForceAPIException.class);
        mExpectedException.expectMessage("Unable to execute call using request: " + request);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mMasterDataClient.getOperatingState(request);
    }

    /**
     * Tests getting operation phases while server is down.
     *
     * @throws IOException       When unable to shutdown the server.
     * @throws ForceAPIException When unable to get operation phases.
     */
    @Test
    public void getOperationPhasesShutdown() throws IOException, ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final GetOperationPhaseCollectionRequest request = new GetOperationPhaseCollectionRequest();
        mMockWebServer.shutdown();
        mExpectedException.expect(ForceAPIException.class);
        mExpectedException.expectMessage("Unable to execute call using request: " + request);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mMasterDataClient.getOperationPhases(request);
    }

    /**
     * Tests getting operation phase while server is down.
     *
     * @throws IOException       When unable to shutdown the server.
     * @throws ForceAPIException When unable to get operation phase.
     */
    @Test
    public void getOperationPhaseShutdown() throws IOException, ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final GetOperationPhaseRequest request = new GetOperationPhaseRequest(OperationPhase.RELEASED);
        mMockWebServer.shutdown();
        mExpectedException.expect(ForceAPIException.class);
        mExpectedException.expectMessage("Unable to execute call using request: " + request);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mMasterDataClient.getOperationPhase(request);
    }

    /**
     * Tests getting quality details while server is down.
     *
     * @throws IOException       When unable to shutdown the server.
     * @throws ForceAPIException When unable to get quality details.
     */
    @Test
    public void getQualityDetailsShutdown() throws IOException, ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final GetQualityDetailsRequest request = new GetQualityDetailsRequest();
        mMockWebServer.shutdown();
        mExpectedException.expect(ForceAPIException.class);
        mExpectedException.expectMessage("Unable to execute call using request: " + request);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mMasterDataClient.getQualityDetails(request);
    }

    /**
     * Tests getting quality detail while server is down.
     *
     * @throws IOException       When unable to shutdown the server.
     * @throws ForceAPIException When unable to get quality detail.
     */
    @Test
    public void getQualityDetailShutdown() throws IOException, ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final GetQualityDetailRequest request = new GetQualityDetailRequest("qualityDetailId");
        mMockWebServer.shutdown();
        mExpectedException.expect(ForceAPIException.class);
        mExpectedException.expectMessage("Unable to execute call using request: " + request);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mMasterDataClient.getQualityDetail(request);
    }

    /**
     * Tests getting quality types while server is down.
     *
     * @throws IOException       When unable to shutdown the server.
     * @throws ForceAPIException When unable to get quality types.
     */
    @Test
    public void getQualityTypesShutdown() throws IOException, ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final GetQualityTypesRequest request = new GetQualityTypesRequest();
        mMockWebServer.shutdown();
        mExpectedException.expect(ForceAPIException.class);
        mExpectedException.expectMessage("Unable to execute call using request: " + request);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mMasterDataClient.getQualityTypes(request);
    }

    /**
     * Tests getting quality type while server is down.
     *
     * @throws IOException       When unable to shutdown the server.
     * @throws ForceAPIException When unable to get quality type.
     */
    @Test
    public void getQualityTypeShutdown() throws IOException, ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final GetQualityTypeRequest request = new GetQualityTypeRequest(QualityType.YIELD);
        mMockWebServer.shutdown();
        mExpectedException.expect(ForceAPIException.class);
        mExpectedException.expectMessage("Unable to execute call using request: " + request);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mMasterDataClient.getQualityType(request);
    }

    /**
     * Tests getting shift types while server is down.
     *
     * @throws IOException       When unable to shutdown the server.
     * @throws ForceAPIException When unable to get shift types.
     */
    @Test
    public void getShiftTypesShutdown() throws IOException, ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final GetShiftTypesRequest request = new GetShiftTypesRequest();
        mMockWebServer.shutdown();
        mExpectedException.expect(ForceAPIException.class);
        mExpectedException.expectMessage("Unable to execute call using request: " + request);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mMasterDataClient.getShiftTypes(request);
    }

    /**
     * Tests getting shift type while server is down.
     *
     * @throws IOException       When unable to shutdown the server.
     * @throws ForceAPIException When unable to get shift type.
     */
    @Test
    public void getShiftTypeShutdown() throws IOException, ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final GetShiftTypeRequest request = new GetShiftTypeRequest("shiftTypeId");
        mMockWebServer.shutdown();
        mExpectedException.expect(ForceAPIException.class);
        mExpectedException.expectMessage("Unable to execute call using request: " + request);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mMasterDataClient.getShiftType(request);
    }

    /**
     * Tests getting tool assembly order states while server is down.
     *
     * @throws IOException       When unable to shutdown the server.
     * @throws ForceAPIException When unable to get tool assembly order states.
     */
    @Test
    public void getToolAssemblyOrderStatesShutdown() throws IOException, ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final GetToolAssemblyOrderStateCollectionRequest request = new GetToolAssemblyOrderStateCollectionRequest();
        mMockWebServer.shutdown();
        mExpectedException.expect(ForceAPIException.class);
        mExpectedException.expectMessage("Unable to execute call using request: " + request);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mMasterDataClient.getToolAssemblyOrderStates(request);
    }

    /**
     * Tests getting tool assembly order state while server is down.
     *
     * @throws IOException       When unable to shutdown the server.
     * @throws ForceAPIException When unable to get tool assembly order state.
     */
    @Test
    public void getToolAssemblyOrderStateShutdown() throws IOException, ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final GetToolAssemblyOrderStateRequest request = new GetToolAssemblyOrderStateRequest(ToolAssemblyOrderState.REQUESTED);
        mMockWebServer.shutdown();
        mExpectedException.expect(ForceAPIException.class);
        mExpectedException.expectMessage("Unable to execute call using request: " + request);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mMasterDataClient.getToolAssemblyOrderState(request);
    }

    /**
     * Tests getting workplace states while server is down.
     *
     * @throws IOException       When unable to shutdown the server.
     * @throws ForceAPIException When unable to get workplace states.
     */
    @Test
    public void getWorkplaceStatesShutdown() throws IOException, ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final GetWorkplaceStateCollectionRequest request = new GetWorkplaceStateCollectionRequest();
        mMockWebServer.shutdown();
        mExpectedException.expect(ForceAPIException.class);
        mExpectedException.expectMessage("Unable to execute call using request: " + request);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mMasterDataClient.getWorkplaceStates(request);
    }

    /**
     * Tests getting workplace state while server is down.
     *
     * @throws IOException       When unable to shutdown the server.
     * @throws ForceAPIException When unable to get workplace state.
     */
    @Test
    public void getWorkplaceStateShutdown() throws IOException, ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final GetWorkplaceStateRequest request = new GetWorkplaceStateRequest(WorkplaceState.DOWNTIME);
        mMockWebServer.shutdown();
        mExpectedException.expect(ForceAPIException.class);
        mExpectedException.expectMessage("Unable to execute call using request: " + request);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mMasterDataClient.getWorkplaceState(request);
    }

    @Test
    public void getTicketStateShutdown() throws IOException, ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final GetTicketStateRequest request = new GetTicketStateRequest(TicketState.IN_PROGRESS);
        mMockWebServer.shutdown();
        mExpectedException.expect(ForceAPIException.class);
        mExpectedException.expectMessage("Unable to execute call using request: " + request);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mMasterDataClient.getTicketState(request);
    }

    @Test
    public void getTicketActivityStateShutdown() throws IOException, ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final GetTicketActivityStateRequest request = new GetTicketActivityStateRequest(TicketActivityState.IN_PROGRESS);
        mMockWebServer.shutdown();
        mExpectedException.expect(ForceAPIException.class);
        mExpectedException.expectMessage("Unable to execute call using request: " + request);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mMasterDataClient.getTicketActivityState(request);
    }

    @Test
    public void getTicketClassShutdown() throws IOException, ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final GetTicketClassRequest request = new GetTicketClassRequest("123");
        mMockWebServer.shutdown();
        mExpectedException.expect(ForceAPIException.class);
        mExpectedException.expectMessage("Unable to execute call using request: " + request);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mMasterDataClient.getTicketClass(request);
    }

    @Test
    public void testGetTicketState() throws ForceAPIException, InterruptedException, IOException, URISyntaxException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getTicketState.json")));
        final GetTicketStateRequest request = new GetTicketStateRequest(TicketState.REOPENED);
        request
            .embed()
            .name(true);
        final TicketStateResponse response = mMasterDataClient.getTicketState(request);

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

        //Verify response model
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getSelf());
        Assert.assertNotNull(response
                                 .getName()
                                 .getLink());
        Assert.assertNotNull(response.getProperties());
        Assert.assertNotNull(response
                                 .getProperties()
                                 .getId());
    }

    @Test
    public void testGetTicketActivityState() throws ForceAPIException, IOException, URISyntaxException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getTicketActivityState.json")));
        final GetTicketActivityStateRequest request = new GetTicketActivityStateRequest(TicketActivityState.IN_PROGRESS);
        final TicketActivityStateResponse response = mMasterDataClient.getTicketActivityState(request);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        //Verify response model
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getSelf());
        Assert.assertNotNull(response.getProperties());
        Assert.assertNotNull(response
                                 .getProperties()
                                 .getId());
    }

    @Test
    public void testGetTicketClass() throws ForceAPIException, InterruptedException, IOException, URISyntaxException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getTicketClass.json")));
        final GetTicketClassRequest request = new GetTicketClassRequest("TESTID");
        request
            .embed()
            .description(true)
            .shortDescription(true);
        final TicketClassResponse response = mMasterDataClient.getTicketClass(request);

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

        //Verify response model
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getSelf());
        Assert.assertNotNull(response.getDescription());
        Assert.assertNotNull(response
                                 .getDescription()
                                 .getLink());
        Assert.assertNotNull(response
                                 .getDescription()
                                 .getEmbedded());
        Assert.assertNotNull(response.getShortDescription());
        Assert.assertNotNull(response
                                 .getShortDescription()
                                 .getLink());
        Assert.assertNotNull(response
                                 .getShortDescription()
                                 .getEmbedded());
        Assert.assertNotNull(response.getProperties());
        Assert.assertNotNull(response
                                 .getProperties()
                                 .getId());
    }

    @Test
    public void testGetTicketStates() throws ForceAPIException, InterruptedException, IOException, URISyntaxException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getTicketStates.json")));
        final int limit = 3;
        final int offset = 0;
        final GetTicketStatesRequest request = new GetTicketStatesRequest();
        request
            .embed()
            .name(true);
        request
            .setLimit(limit)
            .setOffset(offset);

        final Page<TicketStateResponse> page = mMasterDataClient.getTicketStates(request);

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

    @Test
    public void testGetTicketActivityStates() throws ForceAPIException, InterruptedException, IOException, URISyntaxException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getTicketActivityStates.json")));
        final int limit = 3;
        final int offset = 0;
        final CollectionRequest request = new CollectionRequest();
        request
            .setLimit(limit)
            .setOffset(offset);

        final Page<TicketActivityStateResponse> page = mMasterDataClient.getTicketActivityStates(request);

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

    @Test
    public void testGetTicketClasses() throws ForceAPIException, InterruptedException, IOException, URISyntaxException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getTicketClasses.json")));
        final int limit = 3;
        final int offset = 0;
        final GetTicketClassesRequest request = new GetTicketClassesRequest();
        request
            .embed()
            .description(true)
            .shortDescription(true);
        request
            .setLimit(limit)
            .setOffset(offset);

        final Page<TicketClassResponse> page = mMasterDataClient.getTicketClasses(request);

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

    @Test
    public void testGetCustomerSpecificSetting() throws ForceAPIException, IOException, URISyntaxException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getCustomerSpecificSetting.json")));
        final GetCustomerSpecificSettingRequest request = new GetCustomerSpecificSettingRequest("TESTID");
        final CustomerSpecificSettingResponse response = mMasterDataClient.getCustomerSpecificSetting(request);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        //Verify response model
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getSelf());
        Assert.assertNotNull(response.getProperties());
        Assert.assertNotNull(response
                                 .getProperties()
                                 .getId());
        Assert.assertNotNull(response
                                 .getProperties()
                                 .getTopic());
        Assert.assertNotNull(response
                                 .getProperties()
                                 .getValue());
        Assert.assertNotNull(response
                                 .getProperties()
                                 .getDescription());
    }

    @Test
    public void testGetCustomerSpecificSettings() throws ForceAPIException, InterruptedException, IOException, URISyntaxException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getCustomerSpecificSettings.json")));
        final int limit = 3;
        final int offset = 0;
        final GetCustomerSpecificSettingCollectionRequest request = new GetCustomerSpecificSettingCollectionRequest();
        request
            .setLimit(limit)
            .setOffset(offset);

        final Page<CustomerSpecificSettingResponse> page = mMasterDataClient.getCustomerSpecificSettings(request);

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

}