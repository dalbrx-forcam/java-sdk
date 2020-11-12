package com.forcam.na.ffwebservices.client.integration;

import com.forcam.na.ffwebservices.client.api.exception.ForceAPIException;
import com.forcam.na.ffwebservices.client.api.operation.response.RecordedOperatingStateCollectionPage;
import com.forcam.na.ffwebservices.client.api.pagination.response.Page;
import com.forcam.na.ffwebservices.client.api.shift.request.GetWorkplaceShiftRequest;
import com.forcam.na.ffwebservices.client.api.shift.request.GetWorkplaceShiftsRequest;
import com.forcam.na.ffwebservices.client.api.workplace.WorkplaceClient;
import com.forcam.na.ffwebservices.client.api.workplace.request.GetOperatingStateSummaryRequest;
import com.forcam.na.ffwebservices.client.api.workplace.request.GetWorkplaceDevicesRequest;
import com.forcam.na.ffwebservices.client.api.workplace.request.GetWorkplacePredictedMalfunctionScenarioRequest;
import com.forcam.na.ffwebservices.client.api.workplace.request.GetWorkplacePredictedMalfunctionScenariosRequest;
import com.forcam.na.ffwebservices.client.api.workplace.request.GetWorkplaceQuantitySummaryRequest;
import com.forcam.na.ffwebservices.client.api.workplace.request.GetWorkplaceRecordedOperatingStatesRequest;
import com.forcam.na.ffwebservices.client.api.workplace.request.GetWorkplaceRecordedOutputQuantitiesRequest;
import com.forcam.na.ffwebservices.client.api.workplace.request.GetWorkplaceRequest;
import com.forcam.na.ffwebservices.client.api.workplace.request.GetWorkplaceTimeRangeRequest;
import com.forcam.na.ffwebservices.client.api.workplace.request.GetWorkplacesRequest;
import com.forcam.na.ffwebservices.client.api.workplace.request.UpdateWorkplaceRecordedOperatingStateRequest;
import com.forcam.na.ffwebservices.client.api.workplace.response.WorkplaceOperatingStateSummaryPage;
import com.forcam.na.ffwebservices.client.api.workplace.response.WorkplacePredictedMalfunctionScenarioPage;
import com.forcam.na.ffwebservices.client.api.workplace.response.WorkplaceQuantitySummaryCollectionPage;
import com.forcam.na.ffwebservices.client.api.workplace.response.WorkplaceRecordedOperationPhasesPage;
import com.forcam.na.ffwebservices.client.api.workplace.response.WorkplaceRecordedOutputQuantitiesPage;
import com.forcam.na.ffwebservices.client.api.workplace.response.WorkplaceScheduledMaintenanceTimesCollectionPage;
import com.forcam.na.ffwebservices.client.api.workplace.response.WorkplaceScheduledOperatingTimesCollectionPage;
import com.forcam.na.ffwebservices.client.statusdefinition.request.GetOperatingStateCollectionRequest;
import com.forcam.na.ffwebservices.model.device.DeviceResponse;
import com.forcam.na.ffwebservices.model.recordedoperatingstate.OperatingStateRecordWSModel;
import com.forcam.na.ffwebservices.model.shift.WorkplaceShiftResponse;
import com.forcam.na.ffwebservices.model.statusdefinition.OperatingStateResponse;
import com.forcam.na.ffwebservices.model.workplace.CreateWorkplacePredictedMalfunctionScenarioWSModel;
import com.forcam.na.ffwebservices.model.workplace.EmbeddedPredictedMalfunctionScenarioResponse;
import com.forcam.na.ffwebservices.model.workplace.ImminentMalfunctionWSModel;
import com.forcam.na.ffwebservices.model.workplace.WorkplaceResponse;
import org.junit.*;

import java.util.Date;
import java.util.regex.Pattern;

/**
 * Integration tests for the class {@link WorkplaceClient}.
 */
public class WorkplaceClientIntegrationTest extends AbstractOpenAPIIntegrationTest {

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    public WorkplaceClientIntegrationTest() {
        final Pattern shiftsPattern = Pattern.compile(PREFIX_GET_PATH + "/workplaces/shifts\\?.*limit=3.*");
        mFileNames.put(shiftsPattern, "json/getWorkplaceShifts.json");

        final Pattern shiftPattern = Pattern.compile(PREFIX_GET_PATH + "/workplaces/shifts/.{32}\\?.*");
        mFileNames.put(shiftPattern, "json/getWorkplaceShift.json");

        final Pattern workplacePattern = Pattern.compile(PREFIX_GET_PATH + "/workplaces/.{32}\\?.*");
        mFileNames.put(workplacePattern, "json/getWorkplace.json");

        final Pattern workplacesPattern = Pattern.compile(PREFIX_GET_PATH + "/workplaces\\?.*limit=3.*");
        mFileNames.put(workplacesPattern, "json/getWorkplaces.json");

        final Pattern recordedOperatingStatesPattern = Pattern.compile(
            PREFIX_GET_PATH + "/workplaces/.{32}/recordedOperatingStates\\?.*limit=3.*");
        mFileNames.put(recordedOperatingStatesPattern, "json/getWorkplaceRecordedOperatingStates.json");

        final Pattern quantitySummaryPattern = Pattern.compile(PREFIX_GET_PATH + "/workplaces/.{32}/quantitySummary.*");
        mFileNames.put(quantitySummaryPattern, "json/getWorkplaceQuantitySummary.json");

        final Pattern scheduledOperatingTimesPattern = Pattern.compile(
            PREFIX_GET_PATH + "/workplaces/.{32}/scheduledOperatingTimes\\?.*limit=3" + ".*");
        mFileNames.put(scheduledOperatingTimesPattern, "json/getScheduledOperatingTimes.json");

        final Pattern operatingStateSummaryPattern = Pattern.compile(PREFIX_GET_PATH + "/workplaces/.{32}/operatingStateSummary\\?.*limit=3.*");
        mFileNames.put(operatingStateSummaryPattern, "json/getWorkplaceOperatingStateSummary.json");

        final Pattern workplaceRecordedOutputQuatities = Pattern.compile(
            PREFIX_GET_PATH + "/workplaces/.{32}/recordedOutputQuantities\\?.*limit=3.*");
        mFileNames.put(workplaceRecordedOutputQuatities, "json/getWorkplaceRecordedOutputQuantities.json");

        //		final Pattern devicesPattern = Pattern.compile(PREFIX_GET_PATH + "/workplaces/.{32}/devices.*");
        //		mFileNames.put(devicesPattern, "json/getWorkplaceDevices.json");

    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    /**
     * Test for the method {@link WorkplaceClient#getWorkplaces(GetWorkplacesRequest)}.
     *
     * @throws ForceAPIException When unable to get workplaces.
     */
    @Test
    public void testGetWorkplaces() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final GetWorkplacesRequest request = new GetWorkplacesRequest();
        request.setLimit(3);
        request
            .embed()
            .erpContext(true)
            .machine(true)
            .description(true);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final Page<WorkplaceResponse> workplaceCollection = mWorkplaceClient.getWorkplaces(request);

        Assert.assertNotNull(workplaceCollection);
        Assert.assertFalse(workplaceCollection
                               .getElements()
                               .isEmpty());
    }

    /**
     * Test for the method {@link WorkplaceClient#getWorkplace(GetWorkplaceRequest)}.
     *
     * @throws ForceAPIException When unable to get workplace.
     */
    @Test
    public void testGetWorkplace() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final String workplaceId = this.getWorkplaceId();

        final GetWorkplaceRequest request = new GetWorkplaceRequest(workplaceId);
        request
            .embed()
            .erpContext(true)
            .machine(true);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final WorkplaceResponse workplaceModel = mWorkplaceClient.getWorkplace(request);

        Assert.assertNotNull(workplaceModel);
        Assert.assertNotNull(workplaceModel.getProperties());
    }

    /**
     * Test for the method {@link WorkplaceClient#getShifts(GetWorkplaceShiftsRequest)} .
     *
     * @throws ForceAPIException When unable to get shifts.
     */
    @Test
    public void testGetShifts() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final GetWorkplaceShiftsRequest request = new GetWorkplaceShiftsRequest();
        request.setLimit(3);
        request
            .embed()
            .workplace(true)
            .shiftType(true);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final Page<WorkplaceShiftResponse> shiftCollection = mWorkplaceClient.getShifts(request);

        Assert.assertNotNull(shiftCollection);
        Assert.assertFalse(shiftCollection
                               .getElements()
                               .isEmpty());
    }

    /**
     * Test for the method {@link WorkplaceClient#getShift(GetWorkplaceShiftRequest)}.
     *
     * @throws ForceAPIException When unable to get shift.
     */
    @Test
    public void testGetShift() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final GetWorkplaceShiftsRequest shiftsRequest = new GetWorkplaceShiftsRequest();
        shiftsRequest.setLimit(1);
        final Page<WorkplaceShiftResponse> shiftCollection = mWorkplaceClient.getShifts(shiftsRequest);
        Assert.assertNotNull(shiftCollection);
        Assert.assertFalse(shiftCollection
                               .getElements()
                               .isEmpty());

        final WorkplaceShiftResponse shift = shiftCollection
            .getElements()
            .get(0);
        Assert.assertNotNull(shift.getProperties());

        final String shiftId = shift
            .getProperties()
            .getId();

        final GetWorkplaceShiftRequest shiftRequest = new GetWorkplaceShiftRequest(shiftId);
        shiftRequest
            .embed()
            .workplace(true)
            .shiftType(true);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        WorkplaceShiftResponse shiftModel = mWorkplaceClient.getShift(shiftRequest);

        Assert.assertNotNull(shiftModel);
        Assert.assertNotNull(shiftModel.getProperties());
        Assert.assertNotNull(shiftModel.getSelf());
        Assert.assertNotNull(shiftModel.getWorkplace());
        Assert.assertNotNull(shiftModel
                                 .getWorkplace()
                                 .getEmbedded());
        Assert.assertNotNull(shiftModel.getShiftType());
        Assert.assertNotNull(shiftModel
                                 .getShiftType()
                                 .getEmbedded());
        Assert.assertFalse(shiftModel
                               .getProperties()
                               .getShift()
                               .getBreaks()
                               .isEmpty());
    }

    /**
     * Test for the method {@link WorkplaceClient#getRecordedOperatingStates(GetWorkplaceRecordedOperatingStatesRequest)}.
     *
     * @throws ForceAPIException When unable to get recorded operating states.
     */
    @Test
    public void testGetRecordedOperatingStates() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final String workplaceId = this.getWorkplaceId();

        final GetWorkplaceRecordedOperatingStatesRequest request = new GetWorkplaceRecordedOperatingStatesRequest(workplaceId);
        request.setLimit(3);
        request
            .embed()
            .operatingState(true);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final RecordedOperatingStateCollectionPage recordedOperatingStateCollection = mWorkplaceClient.getRecordedOperatingStates(request);

        Assert.assertNotNull(recordedOperatingStateCollection);
        Assert.assertFalse(recordedOperatingStateCollection
                               .getResponse()
                               .getProperties()
                               .getElements()
                               .isEmpty());
        Assert.assertNotNull(recordedOperatingStateCollection
                                 .getResponse()
                                 .getProperties()
                                 .getElements()
                                 .get(0)
                                 .getOperatingState());
    }

    /**
     * Test for the method {@link WorkplaceClient#updateRecordedOperatingState(UpdateWorkplaceRecordedOperatingStateRequest)}.
     *
     * @throws ForceAPIException When unable to update recorded operating state.
     */
    @Test
    public void testUpdateRecordedOperatingState() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final int PAGE_SIZE = 100;
        final GetWorkplacesRequest workplaceRequest = new GetWorkplacesRequest();
        OperatingStateRecordWSModel wantedProperties = null;
        String workplaceId = null;

        for (int i = 0; wantedProperties == null; i++) {
            workplaceRequest.setOffset(i * PAGE_SIZE);
            final Page<WorkplaceResponse> workplaceCollection = mWorkplaceClient.getWorkplaces(workplaceRequest);

            for (WorkplaceResponse workplace : workplaceCollection.getElements()) {
                workplaceId = workplace
                    .getProperties()
                    .getId();
                final GetWorkplaceRecordedOperatingStatesRequest recordedOperatingStatesRequest = new GetWorkplaceRecordedOperatingStatesRequest(workplaceId);
                final RecordedOperatingStateCollectionPage recordedOperatingStateCollectionResponse = mWorkplaceClient.getRecordedOperatingStates(
                    recordedOperatingStatesRequest);

                for (OperatingStateRecordWSModel recordedOperatingStateResponse : recordedOperatingStateCollectionResponse
                    .getResponse()
                    .getProperties()
                    .getElements()) {
                    wantedProperties = recordedOperatingStateResponse;
                }

                if (wantedProperties != null) {
                    break;
                }
            }

            if (workplaceCollection
                    .getElements()
                    .size() < PAGE_SIZE) {
                break;
            }
        }

        if (wantedProperties == null) {
            return;
        }

        final String operatingStateId = wantedProperties
            .getOperatingState()
            .getId();
        final Date startDate = wantedProperties
            .getTimePeriod()
            .getStartDate();

        final UpdateWorkplaceRecordedOperatingStateRequest request = new UpdateWorkplaceRecordedOperatingStateRequest(workplaceId);
        request
            .getWorkplaceRecordedOperatingState()
            .setOperatingStateId(operatingStateId);

        request
            .getWorkplaceRecordedOperatingState()
            .setStartDate(startDate);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mWorkplaceClient.updateRecordedOperatingState(request);
    }

    /**
     * Test for the method {@link WorkplaceClient#getQuantitySummary(GetWorkplaceQuantitySummaryRequest)}.
     *
     * @throws ForceAPIException When unable to get quantity summary.
     */
    @Test
    public void testGetQuantitySummary() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final String workplaceId = this.getWorkplaceId();

        final GetWorkplaceQuantitySummaryRequest quantitySummaryRequest = new GetWorkplaceQuantitySummaryRequest(workplaceId);
        quantitySummaryRequest.setLimit(3);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final WorkplaceQuantitySummaryCollectionPage quantitySummaryModel = mWorkplaceClient.getQuantitySummary(quantitySummaryRequest);

        Assert.assertNotNull(quantitySummaryModel);
        Assert.assertNotNull(quantitySummaryModel
                                 .getResponse()
                                 .getProperties());
    }

    /**
     * Test for the method {@link WorkplaceClient#getScheduledOperatingTimes(GetWorkplaceTimeRangeRequest)}.
     *
     * @throws ForceAPIException When unable to get scheduled operating times.
     */
    @Test
    public void testGetScheduledOperatingTimes() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final String workplaceId = this.getWorkplaceId();

        final GetWorkplaceTimeRangeRequest request = new GetWorkplaceTimeRangeRequest(workplaceId);
        request.setLimit(3);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final WorkplaceScheduledOperatingTimesCollectionPage scheduledOperatingTimesResponse = mWorkplaceClient.getScheduledOperatingTimes(request);

        Assert.assertNotNull(scheduledOperatingTimesResponse);
        Assert.assertNotNull(scheduledOperatingTimesResponse
                                 .getResponse()
                                 .getProperties());
        Assert.assertNotNull(scheduledOperatingTimesResponse
                                 .getResponse()
                                 .getPagination());
    }

    /**
     * Test for the method {@link WorkplaceClient#getWorkplaceScheduledMaintenanceTimes(GetWorkplaceTimeRangeRequest)}.
     *
     * @throws ForceAPIException When unable to get scheduled maintenance times.
     */
    @Test
    public void testGetScheduledMaintenanceTimes() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final String workplaceId = this.getWorkplaceId();
        final GetWorkplaceTimeRangeRequest request = new GetWorkplaceTimeRangeRequest(workplaceId);
        request.setLimit(3);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final WorkplaceScheduledMaintenanceTimesCollectionPage scheduledMaintenanceTimesCollectionResponse = mWorkplaceClient.getWorkplaceScheduledMaintenanceTimes(
            request);

        Assert.assertNotNull(scheduledMaintenanceTimesCollectionResponse);
        Assert.assertNotNull(scheduledMaintenanceTimesCollectionResponse
                                 .getResponse()
                                 .getProperties());
        Assert.assertNotNull(scheduledMaintenanceTimesCollectionResponse
                                 .getResponse()
                                 .getPagination());
        Assert.assertNotNull(scheduledMaintenanceTimesCollectionResponse
                                 .getResponse()
                                 .getPaginationLinks());
    }

    /**
     * Test for the method {@link WorkplaceClient#getOperatingStateSummary(GetOperatingStateSummaryRequest)}.
     *
     * @throws ForceAPIException When unable to get operating state summary.
     */
    @Test
    public void testGetOperatingStateSummary() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final String workplaceId = this.getWorkplaceId();

        final GetOperatingStateSummaryRequest request = new GetOperatingStateSummaryRequest(workplaceId);
        request.setLimit(3);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final WorkplaceOperatingStateSummaryPage response = mWorkplaceClient.getOperatingStateSummary(request);

        Assert.assertNotNull(response);
        Assert.assertNotNull(response
                                 .getResponse()
                                 .getProperties());
        Assert.assertNotNull(response
                                 .getResponse()
                                 .getProperties()
                                 .getProductionTime());
        Assert.assertNotNull(response
                                 .getResponse()
                                 .getProperties()
                                 .getScheduledOperatingTime());
        Assert.assertNotNull(response
                                 .getResponse()
                                 .getProperties()
                                 .getSetupTime());
        Assert.assertNotNull(response
                                 .getResponse()
                                 .getPagination());
        Assert.assertNotNull(response
                                 .getResponse()
                                 .getPaginationLinks());
    }

    /**
     * Test for the method {@link WorkplaceClient#getWorkplaceRecordedOutputQuantities(GetWorkplaceRecordedOutputQuantitiesRequest)}.
     *
     * @throws ForceAPIException When unable to get recorded output quantities of workplace.
     */
    @Test
    public void testGetWorkplaceRecordedOutputQuantities() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final String workplaceId = this.getWorkplaceId();

        final GetWorkplaceRecordedOutputQuantitiesRequest request = new GetWorkplaceRecordedOutputQuantitiesRequest(workplaceId);
        request.setLimit(3);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final WorkplaceRecordedOutputQuantitiesPage response = mWorkplaceClient.getWorkplaceRecordedOutputQuantities(request);

        Assert.assertNotNull(response);
        Assert.assertNotNull(response
                                 .getResponse()
                                 .getPagination());
        Assert.assertNotNull(response
                                 .getResponse()
                                 .getPaginationLinks());
        Assert.assertNotNull(response
                                 .getResponse()
                                 .getProperties()
                                 .getElements());
    }

    /**
     * Test for the method {@link WorkplaceClient#getWorkplaceRecordedOperationPhases(GetWorkplaceTimeRangeRequest)}.
     *
     * @throws ForceAPIException When unable to get recorded operation phases of a workplace.
     */
    @Test
    public void testGetWorkplaceRecordedOperationPhases() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final String workplaceId = this.getWorkplaceId();

        final GetWorkplaceTimeRangeRequest request = new GetWorkplaceTimeRangeRequest(workplaceId);
        request.setLimit(3);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final WorkplaceRecordedOperationPhasesPage response = mWorkplaceClient.getWorkplaceRecordedOperationPhases(request);

        Assert.assertNotNull(response);
        Assert.assertNotNull(response
                                 .getResponse()
                                 .getPagination());
        Assert.assertNotNull(response
                                 .getResponse()
                                 .getPaginationLinks());
        Assert.assertNotNull(response
                                 .getResponse()
                                 .getProperties()
                                 .getElements());
    }

    /**
     * Test for the method {@link WorkplaceClient#getWorkplaceDevices(GetWorkplaceDevicesRequest)}.
     *
     * @throws ForceAPIException When unable to get workplace devices.
     */
    @Test
    public void testGetWorkplaceDevices() throws ForceAPIException {
        final String workplaceId = super.getWorkplaceId();

        final GetWorkplaceDevicesRequest request = new GetWorkplaceDevicesRequest(workplaceId);
        request.setLimit(100);

        Page<DeviceResponse> response = mWorkplaceClient.getWorkplaceDevices(request);

        Assert.assertNotNull(response);
        Assert.assertFalse(response
                               .getElements()
                               .isEmpty());
    }

    /**
     * Test for the method {@link WorkplaceClient#getPredictedMalfunctionScenarios(GetWorkplacePredictedMalfunctionScenariosRequest)}.
     *
     * @throws ForceAPIException When unable to get predicted malfunction scenarios.
     */
    @Test
    public void testGetWorkplacePredictedMalfunctionScenarios() throws ForceAPIException {
        this.createPredictedMalfunctionScenario();
        final GetWorkplacePredictedMalfunctionScenariosRequest request = new GetWorkplacePredictedMalfunctionScenariosRequest();
        request.setLimit(1);
        request.setStartDate(new Date(0));

        Page<EmbeddedPredictedMalfunctionScenarioResponse> response = mWorkplaceClient.getPredictedMalfunctionScenarios(request);

        Assert.assertNotNull(response);
        Assert.assertFalse(response
                               .getElements()
                               .isEmpty());
        Assert.assertEquals(1,
                            response
                                .getElements()
                                .size());
    }

    /**
     * Test for the method {@link WorkplaceClient#getPredictedMalfunctionScenario(GetWorkplacePredictedMalfunctionScenarioRequest)}.
     *
     * @throws ForceAPIException When unable to get predicted malfunction scenario.
     */
    @Test
    public void testGetWorkplacePredictedMalfunctionScenario() throws ForceAPIException {
        final WorkplacePredictedMalfunctionScenarioPage predictedMalfunctionScenario = this.createPredictedMalfunctionScenario();
        final GetWorkplacePredictedMalfunctionScenarioRequest request = new GetWorkplacePredictedMalfunctionScenarioRequest(predictedMalfunctionScenario
                                                                                                                                .getResponse()
                                                                                                                                .getProperties()
                                                                                                                                .getId());
        request.setLimit(1);

        final WorkplacePredictedMalfunctionScenarioPage response = mWorkplaceClient.getPredictedMalfunctionScenario(request);

        Assert.assertNotNull(response);
        Assert.assertFalse(response
                               .getElements()
                               .isEmpty());
        Assert.assertEquals(this.getWorkplaceId(),
                            response
                                .getElements()
                                .get(0)
                                .getWorkplaceId());
    }

    /**
     * Test for the method {@link WorkplaceClient#savePredictedMalfunctionScenario(CreateWorkplacePredictedMalfunctionScenarioWSModel)}.
     *
     * @throws ForceAPIException When unable to save predicted malfunction scenario.
     */
    @Test
    public void testSaveWorkplacePredictedMalfunctionScenario() throws ForceAPIException {
        final WorkplacePredictedMalfunctionScenarioPage response = this.createPredictedMalfunctionScenario();

        Assert.assertNotNull(response
                                 .getResponse()
                                 .getPagination());
        Assert.assertNotNull(response
                                 .getResponse()
                                 .getProperties()
                                 .getCreationDate());
        Assert.assertFalse(response
                               .getElements()
                               .isEmpty());
    }

    /**
     * Creates a new predicted malfunction scenario.
     *
     * @return The workplace predicted malfunction scenario page.
     * @throws ForceAPIException When unable to create new predicted malfunction scenario.
     */
    private WorkplacePredictedMalfunctionScenarioPage createPredictedMalfunctionScenario() throws ForceAPIException {
        final ImminentMalfunctionWSModel imminentMalfunctionWSModel = new ImminentMalfunctionWSModel();
        imminentMalfunctionWSModel.setWorkplaceId(this.getWorkplaceId());
        imminentMalfunctionWSModel.setOperatingStateId(this.getOperatingStateId());
        imminentMalfunctionWSModel.setCriticalDate(new Date(System.currentTimeMillis() + 480000));
        imminentMalfunctionWSModel.setPrewarningDate(new Date(System.currentTimeMillis() + 55000));

        final CreateWorkplacePredictedMalfunctionScenarioWSModel scenarioWSModel = new CreateWorkplacePredictedMalfunctionScenarioWSModel();
        scenarioWSModel.setCreator("SYSTEM");
        scenarioWSModel.setStartDate(new Date(System.currentTimeMillis() + 50000));
        scenarioWSModel.setEndDate(new Date(System.currentTimeMillis() + 500000));
        scenarioWSModel
            .getElements()
            .add(imminentMalfunctionWSModel);

        final WorkplacePredictedMalfunctionScenarioPage response = mWorkplaceClient.savePredictedMalfunctionScenario(scenarioWSModel);

        Assert.assertNotNull(response);
        Assert.assertNotNull(response
                                 .getResponse()
                                 .getProperties()
                                 .getId());

        return response;
    }

    /**
     * Gets operating state ID.
     *
     * @return Operating state ID.
     * @throws ForceAPIException When unable to get operating state ID.
     */
    private String getOperatingStateId() throws ForceAPIException {
        final GetOperatingStateCollectionRequest request = new GetOperatingStateCollectionRequest();
        request.setLimit(1);
        final Page<OperatingStateResponse> operatingStates = mMasterDataClient.getOperatingStates(request);

        Assert.assertNotNull(operatingStates);
        Assert.assertNotNull(operatingStates
                                 .getElements()
                                 .get(0)
                                 .getProperties()
                                 .getId());

        return operatingStates
            .getElements()
            .get(0)
            .getProperties()
            .getId();
    }
}
