////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 10.01.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.integration;

import com.forcam.na.ffwebservices.client.api.exception.ForceAPIException;
import com.forcam.na.ffwebservices.client.api.masterdata.MasterDataClient;
import com.forcam.na.ffwebservices.client.api.masterdata.document.request.GetDocumentStateCollectionRequest;
import com.forcam.na.ffwebservices.client.api.masterdata.document.request.GetDocumentStateRequest;
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
import com.forcam.na.ffwebservices.model.collection.Pagination;
import com.forcam.na.ffwebservices.model.definition.OperationPhase;
import com.forcam.na.ffwebservices.model.definition.ToolAssemblyOrderState;
import com.forcam.na.ffwebservices.model.definition.WorkplaceState;
import com.forcam.na.ffwebservices.model.qualitydetail.QualityDetailResponse;
import com.forcam.na.ffwebservices.model.qualitydetail.QualityType;
import com.forcam.na.ffwebservices.model.qualitytype.QualityTypeResponse;
import com.forcam.na.ffwebservices.model.shifttype.ShiftTypeResponse;
import com.forcam.na.ffwebservices.model.statusdefinition.DocumentStatePropertiesWSModel;
import com.forcam.na.ffwebservices.model.statusdefinition.DocumentStateResponse;
import com.forcam.na.ffwebservices.model.statusdefinition.OperatingStateResponse;
import com.forcam.na.ffwebservices.model.statusdefinition.StatusDefinitionResponse;
import com.forcam.na.ffwebservices.model.ticket.TicketActivityState;
import com.forcam.na.ffwebservices.model.ticket.TicketActivityStateResponse;
import com.forcam.na.ffwebservices.model.ticket.TicketClassResponse;
import com.forcam.na.ffwebservices.model.ticket.TicketState;
import com.forcam.na.ffwebservices.model.ticket.TicketStateResponse;
import org.junit.*;

import java.util.regex.Pattern;

/**
 * Integration tests for the class {@link MasterDataClient}.
 */
public class MasterDataClientIntegrationTest extends AbstractOpenAPIIntegrationTest {

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    public MasterDataClientIntegrationTest() {
        final Pattern operatingStateClassesPattern = Pattern.compile(PREFIX_GET_PATH + "/masterData/operatingStateClasses\\?.*limit=3.*");
        mFileNames.put(operatingStateClassesPattern, "json/getOperatingStateClasses.json");

        final Pattern operatingStateClassPattern = Pattern.compile(PREFIX_GET_PATH + "/masterData/operatingStateClasses/.{32}.*");
        mFileNames.put(operatingStateClassPattern, "json/getOperatingStateClass.json");

        final Pattern operatingStatesPattern = Pattern.compile(PREFIX_GET_PATH + "/masterData/operatingStates\\?.*limit=3.*");
        mFileNames.put(operatingStatesPattern, "json/getOperatingStates.json");

        final Pattern operatingStatePattern = Pattern.compile(PREFIX_GET_PATH + "/masterData/operatingStates/.{32}.*");
        mFileNames.put(operatingStatePattern, "json/getOperatingState.json");

        final Pattern operationPhasesPattern = Pattern.compile(PREFIX_GET_PATH + "/masterData/operationPhases\\?.*limit=3.*");
        mFileNames.put(operationPhasesPattern, "json/getOperationPhases.json");

        final Pattern operationPhasePattern = Pattern.compile(PREFIX_GET_PATH + "/masterData/operationPhases/.*");
        mFileNames.put(operationPhasePattern, "json/getOperationPhase.json");

        final Pattern qualityDetailsPattern = Pattern.compile(PREFIX_GET_PATH + "/masterData/qualityDetails\\?.*limit=3.*");
        mFileNames.put(qualityDetailsPattern, "json/getQualityDetails.json");

        final Pattern qualityDetailPattern = Pattern.compile(PREFIX_GET_PATH + "/masterData/qualityDetails/.{32}.*");
        mFileNames.put(qualityDetailPattern, "json/getQualityDetail.json");

        final Pattern qualityTypesPattern = Pattern.compile(PREFIX_GET_PATH + "/masterData/qualityTypes\\?.*limit=3.*");
        mFileNames.put(qualityTypesPattern, "json/getQualityTypes.json");

        final Pattern qualityTypePattern = Pattern.compile(PREFIX_GET_PATH + "/masterData/qualityTypes/.*");
        mFileNames.put(qualityTypePattern, "json/getQualityType.json");

        final Pattern shiftTypesPattern = Pattern.compile(PREFIX_GET_PATH + "/masterData/shiftTypes\\?.*limit=3.*");
        mFileNames.put(shiftTypesPattern, "json/getShiftTypes.json");

        final Pattern shiftTypePattern = Pattern.compile(PREFIX_GET_PATH + "/masterData/shiftTypes/.{32}.*");
        mFileNames.put(shiftTypePattern, "json/getShiftType.json");

        final Pattern toolAssemblyOrderStatesPattern = Pattern.compile(PREFIX_GET_PATH + "/masterData/toolAssemblyOrderStates\\?.*limit=3.*");
        mFileNames.put(toolAssemblyOrderStatesPattern, "json/getToolAssemblyOrderStates.json");

        final Pattern toolAssemblyOrderStatePattern = Pattern.compile(PREFIX_GET_PATH + "/masterData/toolAssemblyOrderStates/.*");
        mFileNames.put(toolAssemblyOrderStatePattern, "json/getToolAssemblyOrderState.json");

        final Pattern workplaceStatesPattern = Pattern.compile(PREFIX_GET_PATH + "/masterData/workplaceStates\\?.*limit=3.*");
        mFileNames.put(workplaceStatesPattern, "json/getWorkplaceStates.json");

        final Pattern workplaceStatePattern = Pattern.compile(PREFIX_GET_PATH + "/masterData/workplaceStates/.*");
        mFileNames.put(workplaceStatePattern, "json/getWorkplaceState.json");

        final Pattern ticketStatesPattern = Pattern.compile(PREFIX_GET_PATH + "/masterData/ticketStates\\?.*limit=3.*");
        mFileNames.put(ticketStatesPattern, "json/getTicketStates.json");

        final Pattern ticketStatePattern = Pattern.compile(PREFIX_GET_PATH + "/masterData/ticketStates/.*");
        mFileNames.put(ticketStatePattern, "json/getTicketState.json");

        final Pattern ticketActivityStatesPattern = Pattern.compile(PREFIX_GET_PATH + "/masterData/ticketActivityStates\\?.*limit=3.*");
        mFileNames.put(ticketActivityStatesPattern, "json/getTicketActivityStates.json");

        final Pattern ticketActivityStatePattern = Pattern.compile(PREFIX_GET_PATH + "/masterData/ticketActivityStates/.*");
        mFileNames.put(ticketActivityStatePattern, "json/getTicketActivityState.json");

        final Pattern ticketClassesPattern = Pattern.compile(PREFIX_GET_PATH + "/masterData/ticketClasses\\?.*limit=3.*");
        mFileNames.put(ticketClassesPattern, "json/getTicketClasses.json");

        final Pattern ticketClassPattern = Pattern.compile(PREFIX_GET_PATH + "/masterData/ticketClasses/.*");
        mFileNames.put(ticketClassPattern, "json/getTicketClass.json");

        final Pattern customerSpecificSettingsPattern = Pattern.compile(PREFIX_GET_PATH + "/masterData/customerSpecificSettings\\?.*limit=3.*");
        mFileNames.put(customerSpecificSettingsPattern, "json/getCustomerSpecificSettings.json");

        final Pattern customerSpecificSettingPattern = Pattern.compile(PREFIX_GET_PATH + "/masterData/customerSpecificSettings/.*");
        mFileNames.put(customerSpecificSettingPattern, "json/getCustomerSpecificSetting.json");

        final Pattern documentStatePattern = Pattern.compile(PREFIX_GET_PATH + "/masterData/documentState/.*");
        mFileNames.put(documentStatePattern, "json/getDocumentStateSetting.json");
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    /**
     * Test for the method {@link MasterDataClient#getOperatingStateClasses(GetOperatingStateClassCollectionRequest)}.
     *
     * @throws ForceAPIException When unable to get operating state classes.
     */
    @Test
    public void testGetOperatingStateClasses() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final GetOperatingStateClassCollectionRequest request = new GetOperatingStateClassCollectionRequest();
        request.setLimit(3);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final Page<StatusDefinitionResponse> operatingStateClassCollectionResponse = mMasterDataClient.getOperatingStateClasses(request);

        Assert.assertNotNull(operatingStateClassCollectionResponse);
        Assert.assertFalse(operatingStateClassCollectionResponse
                               .getElements()
                               .isEmpty());
    }

    /**
     * Test for the method {@link MasterDataClient#getOperatingStateClasses(GetOperatingStateClassCollectionRequest)}.
     *
     * @throws ForceAPIException When unable to get operating state class.
     */
    @Test
    public void testGetOperatingStateClass() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final GetOperatingStateClassCollectionRequest operatingStateClassesRequest = new GetOperatingStateClassCollectionRequest();
        operatingStateClassesRequest.setLimit(1);
        final Page<StatusDefinitionResponse> operatingStateClassCollection = mMasterDataClient.getOperatingStateClasses(operatingStateClassesRequest);
        Assert.assertNotNull(operatingStateClassCollection);
        Assert.assertFalse(operatingStateClassCollection
                               .getElements()
                               .isEmpty());

        final StatusDefinitionResponse operatingStateClass = operatingStateClassCollection
            .getElements()
            .get(0);
        Assert.assertNotNull(operatingStateClass);
        Assert.assertNotNull(operatingStateClass.getProperties());

        final String operatingStateClassId = operatingStateClass
            .getProperties()
            .getId();

        final GetOperatingStateClassRequest operatingStateClassRequest = new GetOperatingStateClassRequest(operatingStateClassId);
        operatingStateClassRequest
            .embed()
            .description(true)
            .shortDescription(true);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final StatusDefinitionResponse operatingStateClassModel = mMasterDataClient.getOperatingStateClass(operatingStateClassRequest);

        Assert.assertNotNull(operatingStateClassModel);
        Assert.assertNotNull(operatingStateClassModel.getProperties());
        Assert.assertEquals(operatingStateClassRequest.getId(),
                            operatingStateClassModel
                                .getProperties()
                                .getId());
    }

    /**
     * Test for the method {@link MasterDataClient#getOperatingStates(GetOperatingStateCollectionRequest)}.
     *
     * @throws ForceAPIException When unable to get operating states.
     */
    @Test
    public void testGetOperatingStates() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final GetOperatingStateCollectionRequest request = new GetOperatingStateCollectionRequest();
        request.setLimit(3);
        request
            .embed()
            .operatingStateClass(true)
            .workplaceState(true)
            .description(true)
            .shortDescription(true);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final Page<OperatingStateResponse> operatingStateCollectionResponse = mMasterDataClient.getOperatingStates(request);

        Assert.assertNotNull(operatingStateCollectionResponse);
        Assert.assertFalse(operatingStateCollectionResponse
                               .getElements()
                               .isEmpty());
    }

    /**
     * Test for the method {@link MasterDataClient#getOperatingState(GetOperatingStateRequest)}.
     *
     * @throws ForceAPIException When unable to get operating state.
     */
    @Test
    public void testGetOperatingState() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final GetOperatingStateCollectionRequest operatingStatesRequest = new GetOperatingStateCollectionRequest();
        operatingStatesRequest.setLimit(1);
        final Page<OperatingStateResponse> operatingStateCollection = mMasterDataClient.getOperatingStates(operatingStatesRequest);
        Assert.assertNotNull(operatingStateCollection);
        Assert.assertFalse(operatingStateCollection
                               .getElements()
                               .isEmpty());

        final OperatingStateResponse operatingState = operatingStateCollection
            .getElements()
            .get(0);
        Assert.assertNotNull(operatingState);
        Assert.assertNotNull(operatingState.getProperties());

        final String operatingStateId = operatingState
            .getProperties()
            .getId();

        final GetOperatingStateRequest operatingStateRequest = new GetOperatingStateRequest(operatingStateId);
        operatingStateRequest
            .embed()
            .operatingStateClass(true)
            .workplaceState(true)
            .description(true)
            .shortDescription(true);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final OperatingStateResponse operatingStateModel = mMasterDataClient.getOperatingState(operatingStateRequest);

        Assert.assertNotNull(operatingStateModel);
        Assert.assertNotNull(operatingStateModel.getProperties());
        Assert.assertEquals(operatingStateRequest.getId(),
                            operatingStateModel
                                .getProperties()
                                .getId());
    }

    /**
     * Test for the method {@link MasterDataClient#getOperationPhases(GetOperationPhaseCollectionRequest)}.
     *
     * @throws ForceAPIException When unable to get operation phases.
     */
    @Test
    public void testGetOperationPhases() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final GetOperationPhaseCollectionRequest request = new GetOperationPhaseCollectionRequest();
        request.setLimit(3);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final Page<StatusDefinitionResponse> operationPhaseCollectionResponse = mMasterDataClient.getOperationPhases(request);

        Assert.assertNotNull(operationPhaseCollectionResponse);
        Assert.assertFalse(operationPhaseCollectionResponse
                               .getElements()
                               .isEmpty());
    }

    /**
     * Test for the method {@link MasterDataClient#getOperationPhase(GetOperationPhaseRequest)}.
     *
     * @throws ForceAPIException When unable to get operation phase.
     */
    @Test
    public void testGetOperationPhase() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final GetOperationPhaseCollectionRequest operationPhasesRequest = new GetOperationPhaseCollectionRequest();
        operationPhasesRequest.setLimit(1);
        final Page<StatusDefinitionResponse> operationPhaseCollection = mMasterDataClient.getOperationPhases(operationPhasesRequest);
        Assert.assertNotNull(operationPhaseCollection);
        Assert.assertFalse(operationPhaseCollection
                               .getElements()
                               .isEmpty());

        final StatusDefinitionResponse operationPhase = operationPhaseCollection
            .getElements()
            .get(0);
        Assert.assertNotNull(operationPhase);
        Assert.assertNotNull(operationPhase.getProperties());

        final String operationPhaseId = operationPhase
            .getProperties()
            .getId();

        final GetOperationPhaseRequest operationPhaseRequest = new GetOperationPhaseRequest(OperationPhase.valueOf(operationPhaseId));
        operationPhaseRequest
            .embed()
            .description(true)
            .shortDescription(true);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final StatusDefinitionResponse operationPhaseModel = mMasterDataClient.getOperationPhase(operationPhaseRequest);

        Assert.assertNotNull(operationPhaseModel);
        Assert.assertNotNull(operationPhaseModel.getProperties());
        Assert.assertEquals(operationPhaseRequest.getId(),
                            OperationPhase.valueOf(operationPhaseModel
                                                       .getProperties()
                                                       .getId()));
    }

    /**
     * Test for the method {@link MasterDataClient#getQualityDetails(GetQualityDetailsRequest)}.
     *
     * @throws ForceAPIException When unable to get quality details.
     */
    @Test
    public void testGetQualityDetails() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final GetQualityDetailsRequest request = new GetQualityDetailsRequest();
        request.setLimit(3);
        request
            .embed()
            .description(true)
            .shortDescription(true)
            .qualityType(true);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final Page<QualityDetailResponse> qualityDetailCollectionResponse = mMasterDataClient.getQualityDetails(request);

        Assert.assertNotNull(qualityDetailCollectionResponse);
        Assert.assertFalse(qualityDetailCollectionResponse
                               .getElements()
                               .isEmpty());
    }

    /**
     * Test for the method {@link MasterDataClient#getQualityDetail(GetQualityDetailRequest)}.
     *
     * @throws ForceAPIException When unable to get quality detail.
     */
    @Test
    public void testGetQualityDetail() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final GetQualityDetailsRequest qualityDetailsRequest = new GetQualityDetailsRequest();
        qualityDetailsRequest.setLimit(1);
        final Page<QualityDetailResponse> qualityDetailCollection = mMasterDataClient.getQualityDetails(qualityDetailsRequest);
        Assert.assertNotNull(qualityDetailCollection);
        Assert.assertFalse(qualityDetailCollection
                               .getElements()
                               .isEmpty());

        final QualityDetailResponse qualityDetail = qualityDetailCollection
            .getElements()
            .get(0);
        Assert.assertNotNull(qualityDetail);
        Assert.assertNotNull(qualityDetail.getProperties());

        final String qualityDetailId = qualityDetail
            .getProperties()
            .getId();

        final GetQualityDetailRequest qualityDetailRequest = new GetQualityDetailRequest(qualityDetailId);
        qualityDetailRequest
            .embed()
            .description(true)
            .shortDescription(true)
            .qualityType(true);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final QualityDetailResponse qualityDetailModel = mMasterDataClient.getQualityDetail(qualityDetailRequest);

        Assert.assertNotNull(qualityDetailModel);
        Assert.assertNotNull(qualityDetailModel.getProperties());
        Assert.assertEquals(qualityDetailRequest.getId(),
                            qualityDetailModel
                                .getProperties()
                                .getId());
    }

    /**
     * Test for the method {@link MasterDataClient#getQualityTypes(GetQualityTypesRequest)}.
     *
     * @throws ForceAPIException When unable to get quality types.
     */
    @Test
    public void testGetQualityTypes() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final GetQualityTypesRequest request = new GetQualityTypesRequest();
        request.setLimit(3);
        request
            .embed()
            .description(true)
            .shortDescription(true);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final Page<QualityTypeResponse> qualityTypeCollectionResponse = mMasterDataClient.getQualityTypes(request);

        Assert.assertNotNull(qualityTypeCollectionResponse);
        Assert.assertFalse(qualityTypeCollectionResponse
                               .getElements()
                               .isEmpty());
    }

    /**
     * Test for the method {@link MasterDataClient#getQualityType(GetQualityTypeRequest)}.
     *
     * @throws ForceAPIException When unable to get quality type.
     */
    @Test
    public void testGetQualityType() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final GetQualityTypesRequest qualityTypesRequest = new GetQualityTypesRequest();
        qualityTypesRequest.setLimit(1);
        final Page<QualityTypeResponse> qualityTypeCollection = mMasterDataClient.getQualityTypes(qualityTypesRequest);
        Assert.assertNotNull(qualityTypeCollection);
        Assert.assertFalse(qualityTypeCollection
                               .getElements()
                               .isEmpty());

        final QualityTypeResponse qualityType = qualityTypeCollection
            .getElements()
            .get(0);
        Assert.assertNotNull(qualityType);
        Assert.assertNotNull(qualityType.getProperties());

        final String qualityTypeId = qualityType
            .getProperties()
            .getId();

        final GetQualityTypeRequest qualityTypeRequest = new GetQualityTypeRequest(QualityType.valueOf(qualityTypeId));
        qualityTypeRequest
            .embed()
            .description(true)
            .shortDescription(true);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final QualityTypeResponse qualityTypeModel = mMasterDataClient.getQualityType(qualityTypeRequest);

        Assert.assertNotNull(qualityTypeModel);
        Assert.assertNotNull(qualityTypeModel.getProperties());
        Assert.assertEquals(qualityTypeRequest.getId(),
                            QualityType.valueOf(qualityTypeModel
                                                    .getProperties()
                                                    .getId()));
    }

    /**
     * Test for the method {@link MasterDataClient#getShiftTypes(GetShiftTypesRequest)}.
     *
     * @throws ForceAPIException When unable to get shift types.
     */
    @Test
    public void testGetShiftTypes() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final GetShiftTypesRequest request = new GetShiftTypesRequest();
        request.setLimit(3);
        request
            .embed()
            .description(true)
            .shortDescription(true);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final Page<ShiftTypeResponse> shiftTypeCollectionResponse = mMasterDataClient.getShiftTypes(request);

        Assert.assertNotNull(shiftTypeCollectionResponse);
        Assert.assertFalse(shiftTypeCollectionResponse
                               .getElements()
                               .isEmpty());
    }

    /**
     * Test for the method {@link MasterDataClient#getShiftType(GetShiftTypeRequest)}.
     *
     * @throws ForceAPIException When unable to get shift type.
     */
    @Test
    public void testGetShiftType() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final GetShiftTypesRequest shiftTypesRequest = new GetShiftTypesRequest();
        shiftTypesRequest.setLimit(1);
        final Page<ShiftTypeResponse> shiftTypeCollection = mMasterDataClient.getShiftTypes(shiftTypesRequest);
        Assert.assertNotNull(shiftTypeCollection);
        Assert.assertFalse(shiftTypeCollection
                               .getElements()
                               .isEmpty());

        final ShiftTypeResponse shiftType = shiftTypeCollection
            .getElements()
            .get(0);
        Assert.assertNotNull(shiftType);
        Assert.assertNotNull(shiftType.getProperties());

        final String shiftTypeId = shiftType
            .getProperties()
            .getId();

        final GetShiftTypeRequest shiftTypeRequest = new GetShiftTypeRequest(shiftTypeId);
        shiftTypeRequest
            .embed()
            .description(true)
            .shortDescription(true);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final ShiftTypeResponse shiftTypeModel = mMasterDataClient.getShiftType(shiftTypeRequest);

        Assert.assertNotNull(shiftTypeModel);
        Assert.assertNotNull(shiftTypeModel.getProperties());
        Assert.assertEquals(shiftTypeRequest.getId(),
                            shiftTypeModel
                                .getProperties()
                                .getId());
    }

    /**
     * Test for the method {@link MasterDataClient#getToolAssemblyOrderStates(GetToolAssemblyOrderStateCollectionRequest)}.
     *
     * @throws ForceAPIException When unable to get tool assembly order states.
     */
    @Test
    public void testGetToolAssemblyOrderStates() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final GetToolAssemblyOrderStateCollectionRequest request = new GetToolAssemblyOrderStateCollectionRequest();
        request.setLimit(3);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final Page<StatusDefinitionResponse> toolAssemblyOrderStateCollectionResponse = mMasterDataClient.getToolAssemblyOrderStates(request);

        Assert.assertNotNull(toolAssemblyOrderStateCollectionResponse);
        Assert.assertFalse(toolAssemblyOrderStateCollectionResponse
                               .getElements()
                               .isEmpty());
    }

    /**
     * Test for the method {@link MasterDataClient#getToolAssemblyOrderState(GetToolAssemblyOrderStateRequest)}.
     *
     * @throws ForceAPIException When unable to get tool assembly order state.
     */
    @Test
    public void testGetToolAssemblyOrderState() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final GetToolAssemblyOrderStateCollectionRequest toolAssemblyOrderStatesRequest = new GetToolAssemblyOrderStateCollectionRequest();
        toolAssemblyOrderStatesRequest.setLimit(1);
        final Page<StatusDefinitionResponse> toolAssemblyOrderStateCollection = mMasterDataClient.getToolAssemblyOrderStates(toolAssemblyOrderStatesRequest);
        Assert.assertNotNull(toolAssemblyOrderStateCollection);
        Assert.assertFalse(toolAssemblyOrderStateCollection
                               .getElements()
                               .isEmpty());

        final StatusDefinitionResponse toolAssemblyOrderState = toolAssemblyOrderStateCollection
            .getElements()
            .get(0);
        Assert.assertNotNull(toolAssemblyOrderState);
        Assert.assertNotNull(toolAssemblyOrderState.getProperties());

        final String toolAssemblyOrderStateId = toolAssemblyOrderState
            .getProperties()
            .getId();

        final GetToolAssemblyOrderStateRequest toolAssemblyOrderStateRequest = new GetToolAssemblyOrderStateRequest(ToolAssemblyOrderState.valueOf(
            toolAssemblyOrderStateId));
        toolAssemblyOrderStateRequest
            .embed()
            .description(true)
            .shortDescription(true);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final StatusDefinitionResponse toolAssemblyOrderStateModel = mMasterDataClient.getToolAssemblyOrderState(toolAssemblyOrderStateRequest);

        Assert.assertNotNull(toolAssemblyOrderStateModel);
        Assert.assertNotNull(toolAssemblyOrderStateModel.getProperties());
        Assert.assertEquals(toolAssemblyOrderStateRequest.getId(),
                            ToolAssemblyOrderState.valueOf(toolAssemblyOrderStateModel
                                                               .getProperties()
                                                               .getId()));
    }

    /**
     * Test for the method {@link MasterDataClient#getWorkplaceStates(GetWorkplaceStateCollectionRequest)}.
     *
     * @throws ForceAPIException When unable to get workplace states.
     */
    @Test
    public void testGetWorkplaceStates() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final GetWorkplaceStateCollectionRequest request = new GetWorkplaceStateCollectionRequest();
        request.setLimit(3);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final Page<StatusDefinitionResponse> workplaceStateCollectionResponse = mMasterDataClient.getWorkplaceStates(request);

        Assert.assertNotNull(workplaceStateCollectionResponse);
        Assert.assertFalse(workplaceStateCollectionResponse
                               .getElements()
                               .isEmpty());
    }

    /**
     * Test for the method {@link MasterDataClient#getWorkplaceStates(GetWorkplaceStateCollectionRequest)}.
     *
     * @throws ForceAPIException When unable to get workplace state.
     */
    @Test
    public void testGetWorkplaceState() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final GetWorkplaceStateCollectionRequest workplaceStatesRequest = new GetWorkplaceStateCollectionRequest();
        workplaceStatesRequest.setLimit(1);
        final Page<StatusDefinitionResponse> workplaceStateCollection = mMasterDataClient.getWorkplaceStates(workplaceStatesRequest);
        Assert.assertNotNull(workplaceStateCollection);
        Assert.assertFalse(workplaceStateCollection
                               .getElements()
                               .isEmpty());

        final StatusDefinitionResponse workplaceState = workplaceStateCollection
            .getElements()
            .get(0);
        Assert.assertNotNull(workplaceState);
        Assert.assertNotNull(workplaceState.getProperties());

        final String workplaceStateId = workplaceState
            .getProperties()
            .getId();

        final GetWorkplaceStateRequest workplaceStateRequest = new GetWorkplaceStateRequest(WorkplaceState.valueOf(workplaceStateId));
        workplaceStateRequest
            .embed()
            .description(true)
            .shortDescription(true);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final StatusDefinitionResponse workplaceStateModel = mMasterDataClient.getWorkplaceState(workplaceStateRequest);

        Assert.assertNotNull(workplaceStateModel);
        Assert.assertNotNull(workplaceStateModel.getProperties());
        Assert.assertEquals(workplaceStateRequest.getId(),
                            WorkplaceState.valueOf(workplaceStateModel
                                                       .getProperties()
                                                       .getId()));
    }

    /**
     * Test for the method {@link MasterDataClient#getQualityTypes(GetQualityTypesRequest)}.
     *
     * @throws ForceAPIException When unable to get quality types.
     */
    @Test
    public void testGetTicketStates() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final GetTicketStatesRequest request = new GetTicketStatesRequest();
        request.setLimit(3);
        request
            .embed()
            .name(true);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final Page<TicketStateResponse> response = mMasterDataClient.getTicketStates(request);

        Assert.assertNotNull(response);
        Assert.assertFalse(response
                               .getElements()
                               .isEmpty());
    }

    /**
     * Test for the method {@link MasterDataClient#getQualityType(GetQualityTypeRequest)}.
     *
     * @throws ForceAPIException When unable to get quality type.
     */
    @Test
    public void testGetTicketState() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final GetTicketStatesRequest collectionRequest = new GetTicketStatesRequest();
        collectionRequest.setLimit(1);
        final Page<TicketStateResponse> qualityTypeCollection = mMasterDataClient.getTicketStates(collectionRequest);
        Assert.assertNotNull(qualityTypeCollection);
        Assert.assertFalse(qualityTypeCollection
                               .getElements()
                               .isEmpty());

        final TicketStateResponse ticketState = qualityTypeCollection
            .getElements()
            .get(0);
        Assert.assertNotNull(ticketState);
        Assert.assertNotNull(ticketState.getProperties());

        final TicketState id = ticketState
            .getProperties()
            .getId();

        final GetTicketStateRequest qualityTypeRequest = new GetTicketStateRequest(id);
        qualityTypeRequest
            .embed()
            .name(true);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final TicketStateResponse ticketStateResponse = mMasterDataClient.getTicketState(qualityTypeRequest);

        Assert.assertNotNull(ticketStateResponse);
        Assert.assertNotNull(ticketStateResponse.getProperties());
        Assert.assertEquals(qualityTypeRequest.getId(),
                            ticketStateResponse
                                .getProperties()
                                .getId());
    }

    /**
     * Test for the method {@link MasterDataClient#getQualityTypes(GetQualityTypesRequest)}.
     *
     * @throws ForceAPIException When unable to get quality types.
     */
    @Test
    public void testGetTicketActivityStates() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final CollectionRequest request = new CollectionRequest();
        request.setLimit(3);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final Page<TicketActivityStateResponse> qualityTypeCollectionResponse = mMasterDataClient.getTicketActivityStates(request);

        Assert.assertNotNull(qualityTypeCollectionResponse);
        Assert.assertFalse(qualityTypeCollectionResponse
                               .getElements()
                               .isEmpty());
    }

    /**
     * Test for the method {@link MasterDataClient#getQualityType(GetQualityTypeRequest)}.
     *
     * @throws ForceAPIException When unable to get quality type.
     */
    @Test
    public void testGetTicketActivityState() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final CollectionRequest request = new CollectionRequest();
        request.setLimit(1);
        final Page<TicketActivityStateResponse> qualityTypeCollection = mMasterDataClient.getTicketActivityStates(request);
        Assert.assertNotNull(qualityTypeCollection);
        Assert.assertFalse(qualityTypeCollection
                               .getElements()
                               .isEmpty());

        final TicketActivityStateResponse response = qualityTypeCollection
            .getElements()
            .get(0);
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getProperties());

        final TicketActivityState qualityTypeId = response
            .getProperties()
            .getId();

        final GetTicketActivityStateRequest req = new GetTicketActivityStateRequest(qualityTypeId);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final TicketActivityStateResponse qualityTypeModel = mMasterDataClient.getTicketActivityState(req);

        Assert.assertNotNull(qualityTypeModel);
        Assert.assertNotNull(qualityTypeModel.getProperties());
        Assert.assertEquals(req.getId(),
                            qualityTypeModel
                                .getProperties()
                                .getId());
    }

    @Test
    public void testGetTicketClasses() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final GetTicketClassesRequest request = new GetTicketClassesRequest();
        request.setLimit(3);
        request
            .embed()
            .description(true)
            .shortDescription(true);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final Page<TicketClassResponse> response = mMasterDataClient.getTicketClasses(request);

        Assert.assertNotNull(response);
        Assert.assertFalse(response
                               .getElements()
                               .isEmpty());
    }

    @Test
    public void testGetTicketClass() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final GetTicketClassesRequest request = new GetTicketClassesRequest();
        request.setLimit(1);
        final Page<TicketClassResponse> collection = mMasterDataClient.getTicketClasses(request);
        Assert.assertNotNull(collection);
        Assert.assertFalse(collection
                               .getElements()
                               .isEmpty());

        final TicketClassResponse ticketClass = collection
            .getElements()
            .get(0);
        Assert.assertNotNull(ticketClass);
        Assert.assertNotNull(ticketClass.getProperties());

        final String id = ticketClass
            .getProperties()
            .getId();

        final GetTicketClassRequest req = new GetTicketClassRequest(id);
        req
            .embed()
            .description(true)
            .shortDescription(true);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final TicketClassResponse response = mMasterDataClient.getTicketClass(req);

        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getProperties());
        Assert.assertEquals(req.getId(),
                            response
                                .getProperties()
                                .getId());
    }

    @Test
    public void testGetCustomerSpecificSettings() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final GetCustomerSpecificSettingCollectionRequest request = new GetCustomerSpecificSettingCollectionRequest();
        request.setLimit(3);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final Page<CustomerSpecificSettingResponse> response = mMasterDataClient.getCustomerSpecificSettings(request);

        Assert.assertNotNull(response);
        Assert.assertFalse(response
                               .getElements()
                               .isEmpty());
    }

    @Test
    public void testGetCustomerSpecificSetting() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final GetCustomerSpecificSettingCollectionRequest req = new GetCustomerSpecificSettingCollectionRequest();
        req.setLimit(3);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final Page<CustomerSpecificSettingResponse> res = mMasterDataClient.getCustomerSpecificSettings(req);
        Assert.assertNotNull(res);
        Assert.assertFalse(res
                               .getElements()
                               .isEmpty());

        final GetCustomerSpecificSettingRequest request = new GetCustomerSpecificSettingRequest(res
                                                                                                    .getElements()
                                                                                                    .get(0)
                                                                                                    .getProperties()
                                                                                                    .getId());

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final CustomerSpecificSettingResponse response = mMasterDataClient.getCustomerSpecificSetting(request);
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getProperties());

        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getProperties());
        Assert.assertEquals(request.getId(),
                            response
                                .getProperties()
                                .getId());
    }

    @Test
    public void testGetDocumentState() throws ForceAPIException {
        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final GetDocumentStateRequest request = new GetDocumentStateRequest("TEST_ID");
        request
            .embed()
            .description(true);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final DocumentStateResponse response = mMasterDataClient.getDocumentState(request);

        // ----------------------------------------------------------------------
        // validate
        // ----------------------------------------------------------------------

        Assert.assertNotNull(response);

        final DocumentStatePropertiesWSModel properties = response.getProperties();

        Assert.assertNotNull(properties);

        Assert.assertEquals(request.getId(), properties.getId());
    }

    @Test
    public void testGetDocumentStates() throws ForceAPIException {
        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------
        final GetDocumentStateCollectionRequest request = new GetDocumentStateCollectionRequest();
        request.setLimit(3);
        request
            .embed()
            .description(true);
        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final Page<DocumentStateResponse> response = mMasterDataClient.getDocumentStates(request);

        // ----------------------------------------------------------------------
        // validate
        // ----------------------------------------------------------------------
        Assert.assertNotNull(response);
        final Pagination pagination = response.getPagination();
        Assert.assertTrue(pagination.getLimit() < 3);

        Assume.assumeFalse(response
                               .getElements()
                               .isEmpty());
    }

}