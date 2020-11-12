package com.forcam.na.ffwebservices.client.integration;

import com.forcam.na.ffwebservices.client.api.exception.ForceAPIException;
import com.forcam.na.ffwebservices.client.api.operation.OperationClient;
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
import com.forcam.na.ffwebservices.client.api.operation.response.OperatingQuantitySummaryCollectionPage;
import com.forcam.na.ffwebservices.client.api.operation.response.OperationComponentCollectionPage;
import com.forcam.na.ffwebservices.client.api.operation.response.OperationManufacturingVariantsResponse;
import com.forcam.na.ffwebservices.client.api.operation.response.OperationOperatingStateSummaryPage;
import com.forcam.na.ffwebservices.client.api.operation.response.OperationRecordedOperationPhasePage;
import com.forcam.na.ffwebservices.client.api.operation.response.OperationRecordedOutputQuantitiesPage;
import com.forcam.na.ffwebservices.client.api.operation.response.OperationUserFieldCollectionPage;
import com.forcam.na.ffwebservices.client.api.operation.response.RecordedOperatingStateCollectionPage;
import com.forcam.na.ffwebservices.client.api.pagination.response.Page;
import com.forcam.na.ffwebservices.client.api.qualitydetail.request.GetQualityDetailsRequest;
import com.forcam.na.ffwebservices.model.definition.OperationPhase;
import com.forcam.na.ffwebservices.model.operation.OperationCurrentProductionDataResponse;
import com.forcam.na.ffwebservices.model.operation.OperationResponse;
import com.forcam.na.ffwebservices.model.operation.OperationScheduledDatesResponse;
import com.forcam.na.ffwebservices.model.operation.OperationSpecificationResponse;
import com.forcam.na.ffwebservices.model.operation.OperationTime;
import com.forcam.na.ffwebservices.model.operation.ProductionResourceToolResponse;
import com.forcam.na.ffwebservices.model.qualitydetail.QualityDetailResponse;
import com.forcam.na.ffwebservices.model.workplace.WorkplaceResponse;
import org.junit.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Integration tests for the class {@link OperationClient}.
 */
public class OperationClientIntegrationTest extends AbstractOpenAPIIntegrationTest {

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    public OperationClientIntegrationTest() {
        final Pattern operationPattern = Pattern.compile(PREFIX_GET_PATH + "/operations/.{32}\\?.*");
        mFileNames.put(operationPattern, "json/getOperation.json");

        final Pattern operationsSearchPattern = Pattern.compile(PREFIX_POST_PATH + "/operations/search\\?.*limit=3.*");
        mFileNames.put(operationsSearchPattern, "json/searchOperations.json");

        final Pattern scheduledDatesPattern = Pattern.compile(PREFIX_GET_PATH + "/operations/.{32}/scheduledDates.*");
        mFileNames.put(scheduledDatesPattern, "json/getOperationScheduledDates.json");

        final Pattern specificationPattern = Pattern.compile(PREFIX_GET_PATH + "/operations/.{32}/specification\\?.*");
        mFileNames.put(specificationPattern, "json/getOperationSpecification.json");

        final Pattern productionResourcesAndToolsPattern = Pattern.compile(PREFIX_GET_PATH + "/operations/.{32}/productionResourcesAndTools\\?.*limit=3.*");
        mFileNames.put(productionResourcesAndToolsPattern, "json/getOperationProductionResourcesAndTools.json");

        final Pattern recordedOperatingStatesPattern = Pattern.compile(PREFIX_GET_PATH + "/operations/.{32}/recordedOperatingStates\\?.*limit=3.*");
        mFileNames.put(recordedOperatingStatesPattern, "json/getOperationRecordedOperatingStates.json");

        final Pattern operationsPattern = Pattern.compile(PREFIX_GET_PATH + "/operations\\?.*limit=3.*");
        mFileNames.put(operationsPattern, "json/getOperations.json");

        final Pattern quantitySummaryPattern = Pattern.compile(PREFIX_GET_PATH + "/operations/.{32}/quantitySummary.*");
        mFileNames.put(quantitySummaryPattern, "json/getOperationQuantitySummary.json");

        final Pattern operationPhasePattern = Pattern.compile(PREFIX_POST_PATH + "/operations/.{32}/" + this.getOperationPhaseId() + "\\?.*");
        mFileNames.put(operationPhasePattern, "json/setOperationPhase.json");

        final Pattern operationComponentsPattern = Pattern.compile(PREFIX_GET_PATH + "/operations/.{32}/components\\?.*limit=3.*");
        mFileNames.put(operationComponentsPattern, "json/getOperationComponents.json");

        final Pattern currentProductionDataPattern = Pattern.compile(PREFIX_GET_PATH + "/operations/.{32}/currentProductionData");
        mFileNames.put(currentProductionDataPattern, "json/getCurrentProductionData.json");

        final Pattern currentProductionDataPattern_2 = Pattern.compile(
            PREFIX_GET_PATH + "/operations/.{32}/currentProductionData\\?.*additionalOperationTime=.*");
        mFileNames.put(currentProductionDataPattern_2, "json/getCurrentProductionDataWithAdditionalOperationTime.json");
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    /**
     * Test for the method {@link OperationClient#searchOperations(SearchOperationsRequest)}.
     *
     * @throws ForceAPIException When unable to search operations.
     */
    @Test
    public void testSearchOperations() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final SearchOperationsRequest request = new SearchOperationsRequest();
        request.setLimit(3);
        request
            .embed()
            .erpContext(true)
            .order(true)
            .description(true);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final Page<OperationResponse> operationCollectionResponse = mOperationClient.searchOperations(request);

        Assert.assertNotNull(operationCollectionResponse);
        Assert.assertFalse(operationCollectionResponse
                               .getElements()
                               .isEmpty());
    }

    /**
     * Test for the method {@link OperationClient#getOperation(GetOperationRequest)}.
     *
     * @throws ForceAPIException When unable to search operations.
     */
    @Test
    public void testGetOperation() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final String operationId = this.getOperationId();

        final GetOperationRequest operationRequest = new GetOperationRequest(operationId);
        operationRequest
            .embed()
            .erpContext(true)
            .order(true)
            .description(true)
            .plannedCapacityGroup(true)
            .plannedWorkplace(true)
            .targetCapacityGroup(true)
            .targetWorkplace(true)
            .specification(true)
            .scheduledDates(true)
            .productionResourcesAndTools(true)
            .operationPhase(true);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final OperationResponse operationModel = mOperationClient.getOperation(operationRequest);

        Assert.assertNotNull(operationModel);
        Assert.assertNotNull(operationModel.getProperties());
        Assert.assertNotNull(operationModel.getDescription());
        Assert.assertNotNull(operationModel.getOperationPhase());
        Assert.assertNotNull(operationModel.getOrder());
        Assert.assertNotNull(operationModel
                                 .getSpecification()
                                 .getEmbedded());
        Assert.assertEquals(operationRequest.getId(),
                            operationModel
                                .getProperties()
                                .getId());
    }

    /**
     * Test for the method {@link OperationClient#getScheduledDates(GetOperationScheduledDatesRequest)}.
     *
     * @throws ForceAPIException When unable to get scheduled dates.
     */
    @Test
    public void testGetScheduledDates() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final String operationId = this.getOperationId();

        final GetOperationScheduledDatesRequest scheduledDatesRequest = new GetOperationScheduledDatesRequest(operationId);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final OperationScheduledDatesResponse scheduledDatesModel = mOperationClient.getScheduledDates(scheduledDatesRequest);

        Assert.assertNotNull(scheduledDatesModel);
        Assert.assertNotNull(scheduledDatesModel.getProperties());
    }

    /**
     * Test for the method {@link OperationClient#getSpecification(GetOperationSpecificationRequest)}.
     *
     * @throws ForceAPIException When unable to get specification.
     */
    @Test
    public void testGetSpecification() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final String operationId = this.getOperationId();

        final GetOperationSpecificationRequest specificationRequest = new GetOperationSpecificationRequest(operationId);
        specificationRequest
            .embed()
            .targetWorkplace(true);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final OperationSpecificationResponse specificationModel = mOperationClient.getSpecification(specificationRequest);

        Assert.assertNotNull(specificationModel);
        Assert.assertNotNull(specificationModel.getProperties());
    }

    /**
     * Test for the method {@link OperationClient#getProductionResourcesAndTools(GetOperationProductionResourcesAndToolsRequest)}.
     *
     * @throws ForceAPIException When unable to get production resources and tools.
     */
    @Test
    public void testGetProductionResourcesAndTools() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final String operationId = this.getOperationId();

        final GetOperationProductionResourcesAndToolsRequest request = new GetOperationProductionResourcesAndToolsRequest(operationId);
        request.setLimit(3);
        request
            .embed()
            .description(true);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final Page<ProductionResourceToolResponse> productionResourceToolCollectionResponse = mOperationClient.getProductionResourcesAndTools(request);

        Assert.assertNotNull(productionResourceToolCollectionResponse);
        Assert.assertFalse(productionResourceToolCollectionResponse
                               .getElements()
                               .isEmpty());
        Assert.assertNotNull(productionResourceToolCollectionResponse
                                 .getElements()
                                 .get(0)
                                 .getDescription());
    }

    /**
     * Test for the method {@link OperationClient#getRecordedOperatingStates(GetOperationRecordedOperatingStatesRequest)}.
     *
     * @throws ForceAPIException When unable to get recorded operating states.
     */
    @Test
    public void testGetRecordedOperatingStates() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final String operationId = this.getOperationId();

        final GetOperationRecordedOperatingStatesRequest request = new GetOperationRecordedOperatingStatesRequest(operationId);
        request.setLimit(3);
        request
            .embed()
            .operatingState(true);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final RecordedOperatingStateCollectionPage recordedOperatingStateCollectionResponse = mOperationClient.getRecordedOperatingStates(request);

        Assert.assertNotNull(recordedOperatingStateCollectionResponse);
        //Assert.assertFalse(recordedOperatingStateCollectionResponse.getRecordedOperatingStates().isEmpty());
        //Assert.assertNotNull(recordedOperatingStateCollectionResponse.getRecordedOperatingStates().get(0).getOperatingState());
    }

    /**
     * Test for the method {@link OperationClient#getOperations(GetOperationsRequest)}.
     *
     * @throws ForceAPIException When unable to get operations.
     */
    @Test
    public void testGetOperations() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final GetOperationsRequest request = new GetOperationsRequest();
        request.setLimit(3);
        request
            .embed()
            .erpContext(true)
            .order(true)
            .description(true)
            .components(true)
            .userFields(true)
            .alternativeWorkplaces(true);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final Page<OperationResponse> operationCollectionResponse = mOperationClient.getOperations(request);

        Assert.assertNotNull(operationCollectionResponse);
        Assert.assertFalse(operationCollectionResponse
                               .getElements()
                               .isEmpty());
    }

    /**
     * Test for the method {@link OperationClient#getQuantitySummary(GetOperationQuantitySummaryRequest)}.
     *
     * @throws ForceAPIException When unable to get quantity summary.
     */
    @Test
    public void testGetQuantitySummary() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final String operationId = this.getOperationId();

        final GetOperationQuantitySummaryRequest quantitySummaryRequest = new GetOperationQuantitySummaryRequest(operationId);
        quantitySummaryRequest.setLimit(3);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final OperatingQuantitySummaryCollectionPage quantitySummaryModel = mOperationClient.getQuantitySummary(quantitySummaryRequest);

        Assert.assertNotNull(quantitySummaryModel);
        Assert.assertNotNull(quantitySummaryModel
                                 .getResponse()
                                 .getProperties());
    }

    /**
     * Test for the method {@link OperationClient#getOperationComponents(GetOperationComponentsRequest)}.
     *
     * @throws ForceAPIException When unable to get quantity summary.
     */
    @Test
    public void testGetOperationComponents() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final String operationId = this.getOperationId();

        final GetOperationComponentsRequest operationComponentsRequest = new GetOperationComponentsRequest(operationId);
        operationComponentsRequest.setLimit(3);
        operationComponentsRequest
            .embed()
            .operation(true);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final OperationComponentCollectionPage operationComponents = mOperationClient.getOperationComponents(operationComponentsRequest);

        Assert.assertNotNull(operationComponents);
        Assert.assertNotNull(operationComponents
                                 .getResponse()
                                 .getProperties());
        Assert.assertNotNull(operationComponents
                                 .getResponse()
                                 .getOperation()
                                 .getEmbedded());
        Assert.assertNotNull(operationComponents
                                 .getResponse()
                                 .getPagination());
        Assert.assertNotNull(operationComponents
                                 .getResponse()
                                 .getPaginationLinks());
    }

    /**
     * Test for the method {@link OperationClient#setQualityDetails(SetOperationQualityDetailsRequest)}.
     *
     * @throws ForceAPIException When unable to set quality details.
     */
    @Test
    public void testSetQualityDetails() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final GetQualityDetailsRequest qualityDetailsRequest = new GetQualityDetailsRequest();
        qualityDetailsRequest.setLimit(1);
        final Page<QualityDetailResponse> qualityDetailsCollection = mMasterDataClient.getQualityDetails(qualityDetailsRequest);
        Assert.assertNotNull(qualityDetailsCollection);
        Assert.assertFalse(qualityDetailsCollection
                               .getElements()
                               .isEmpty());
        Assert.assertNotNull(qualityDetailsCollection
                                 .getElements()
                                 .get(0)
                                 .getProperties());

        final String qualityDetailId = qualityDetailsCollection
            .getElements()
            .get(0)
            .getProperties()
            .getId();
        final String operationId = this.getOperationId();
        final double quantity = 1;

        final SetOperationQualityDetailsRequest request = new SetOperationQualityDetailsRequest(operationId);
        request
            .getOperationQualityDetail()
            .setQualityDetailId(qualityDetailId);
        request
            .getOperationQualityDetail()
            .setQuantity(quantity);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mOperationClient.setQualityDetails(request);
    }

    /**
     * Test for the method {@link OperationClient#setOperationPhase(SetOperationPhaseRequest)}.
     *
     * @throws ForceAPIException When unable to set operation phase.
     */
    @Test
    public void testSetOperationPhase() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final String operationId = this.getOperationId();
        final OperationPhase operationPhaseId = this.getOperationPhaseId();

        final SetOperationPhaseRequest request = new SetOperationPhaseRequest(operationId, operationPhaseId);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final OperationResponse operationResponse = mOperationClient.setOperationPhase(request);

        Assert.assertNotNull(operationResponse);
    }

    /**
     * Test for the method {@link OperationClient#getOperationUserFields(GetOperationUserFieldsRequest)}.
     *
     * @throws ForceAPIException When unable to get operation user fields.
     */
    @Test
    public void testGetOperationUserFields() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final String operationId = this.getOperationId();

        final GetOperationUserFieldsRequest request = new GetOperationUserFieldsRequest(operationId);
        request.setLimit(3);
        request.setOffset(0);
        request
            .embed()
            .operation(true);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final OperationUserFieldCollectionPage page = mOperationClient.getOperationUserFields(request);

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
                                 .getOperation()
                                 .getEmbedded());
    }

    /**
     * Test for the method {@link OperationClient#getOperationManufacturingVariants(String)}.
     *
     * @throws ForceAPIException When unable to get operation predicted values.
     */
    @Test
    public void testGetOperationPredictedValues() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final String operationId = this.getOperationId();

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final OperationManufacturingVariantsResponse operationPredictedValues = mOperationClient.getOperationManufacturingVariants(operationId);

        Assert.assertNotNull(operationPredictedValues);
        Assert.assertNotNull(operationPredictedValues.getSelf());
        Assert.assertNotNull(operationPredictedValues.getProperties());
    }

    /**
     * Test for the method {@link OperationClient#getRecordedOperationPhases(GetOperationRecordedOperationPhasesRequest)}.
     *
     * @throws ForceAPIException When unable to get the recorded operation phases.
     */
    @Test
    public void testOperationRecordedOperationPhases() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final String operationId = this.getOperationId();

        final GetOperationRecordedOperationPhasesRequest request = new GetOperationRecordedOperationPhasesRequest(operationId);
        final OperationRecordedOperationPhasePage page = mOperationClient.getRecordedOperationPhases(request);
        Assert.assertNotNull(page);
        Assert.assertNotNull(page
                                 .getResponse()
                                 .getPagination());
        Assert.assertNotNull(page
                                 .getResponse()
                                 .getPaginationLinks());
    }

    /**
     * Test for the method {@link OperationClient#getRecordedOutputQuantities(GetOperationRecordedOutputQuantitiesRequest)}.
     *
     * @throws ForceAPIException When unable to get the recorded output quantities of an operation.
     */
    @Test
    public void testOperationRecordedOutputQuantities() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final String operationId = this.getOperationId();

        final GetOperationRecordedOutputQuantitiesRequest request = new GetOperationRecordedOutputQuantitiesRequest(operationId);
        final OperationRecordedOutputQuantitiesPage page = mOperationClient.getRecordedOutputQuantities(request);
        Assert.assertNotNull(page);
        Assert.assertNotNull(page
                                 .getResponse()
                                 .getPagination());
        Assert.assertNotNull(page
                                 .getResponse()
                                 .getPaginationLinks());
        Assert.assertNotNull(page
                                 .getResponse()
                                 .getProperties()
                                 .getElements());
    }

    /**
     * Test for the method {@link OperationClient#getOperatingStateSummary(GetOperationOperatingStateSummaryRequest)}.
     *
     * @throws ForceAPIException When unable to get the operating state summary of an operation.
     */
    @Test
    public void testOperationOperatingStateSummary() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final String operationId = this.getOperationId();

        final GetOperationOperatingStateSummaryRequest request = new GetOperationOperatingStateSummaryRequest(operationId);
        final OperationOperatingStateSummaryPage page = mOperationClient.getOperatingStateSummary(request);
        Assert.assertNotNull(page);
        Assert.assertNotNull(page
                                 .getResponse()
                                 .getPagination());
        Assert.assertNotNull(page
                                 .getResponse()
                                 .getPaginationLinks());
        Assert.assertNotNull(page
                                 .getResponse()
                                 .getProperties()
                                 .getElements());
    }

    /**
     * Test for the method {@link OperationClient#getAlternativeWorkplaces(String)}.
     *
     * @throws ForceAPIException When unable to get the alternative workplaces of an operation.
     */
    @Test
    public void testGetAlternativeWorkplaces() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final String operationId = this.getOperationId();

        final Page<WorkplaceResponse> page = mOperationClient.getAlternativeWorkplaces(operationId);
        Assert.assertNotNull(page);
        Assert.assertNull(page.getPagination());
        Assert.assertNull(page
                              .getResponse()
                              .getPaginationLinks());
        Assert.assertNotNull(page
                                 .getResponse()
                                 .getElements());
        Assert.assertNotNull(page
                                 .getResponse()
                                 .getEmbedded());
    }

    /**
     * Test for the method {@link OperationClient#getCurrentProductionData(GetOperationCurrentProductionDataRequest)}.
     *
     * @throws ForceAPIException When unable to get the current production data of an operation.
     */
    @Test
    public void getCurrentProductionData() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final String operationId = this.getOperationId();
        final GetOperationCurrentProductionDataRequest request = new GetOperationCurrentProductionDataRequest(operationId);
        request.setAdditionalOperationTime(Collections.singletonList("test"));
        final OperationCurrentProductionDataResponse response = mOperationClient.getCurrentProductionData(request);

        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getSelf());
        Assert.assertNotNull(response
                                 .getProperties()
                                 .getOperationPhaseId());
    }

    /**
     * Test for the method {@link OperationClient#getCurrentProductionData(GetOperationCurrentProductionDataRequest)}.
     *
     * @throws ForceAPIException When unable to get the current production data of an operation.
     */
    @Test
    public void getCurrentProductionDataWithAdditionalOperationTime() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final String operationId = this.getOperationId();
        final GetOperationCurrentProductionDataRequest request = new GetOperationCurrentProductionDataRequest(operationId);
        request.setAdditionalOperationTime(Arrays.asList("operationSetupTime", "operationProductionTime"));
        final OperationCurrentProductionDataResponse response = mOperationClient.getCurrentProductionData(request);

        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getSelf());
        Assert.assertNotNull(response
                                 .getProperties()
                                 .getOperationPhaseId());
        final List<OperationTime> operationTimes = response
            .getProperties()
            .getOperationTimes();
        Assert.assertFalse(operationTimes.isEmpty());
        Assert.assertEquals(5, operationTimes.size());
        Assert.assertTrue(operationTimes
                              .get(3)
                              .getDuration() >= 0);

        Assert.assertTrue(operationTimes
                              .get(4)
                              .getDuration() >= 0);
    }

    /**
     * Returns the operation phase id of an available operation phase.
     *
     * @return An operation phase.
     */
    private OperationPhase getOperationPhaseId() {
        return OperationPhase.COMPLETED;
    }
}
