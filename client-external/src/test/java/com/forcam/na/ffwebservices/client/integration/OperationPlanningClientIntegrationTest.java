////////////////////////////////////////////////////////////////////////////////
//
// Created by abhishekmundewal on 16-May-18.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.integration;

import com.forcam.na.ffwebservices.client.api.exception.ForceAPIException;
import com.forcam.na.ffwebservices.client.api.operation.operationplanning.OperationPlanningClient;
import com.forcam.na.ffwebservices.client.api.operation.operationplanning.request.GetOperationPlanningResultRequest;
import com.forcam.na.ffwebservices.client.api.operation.operationplanning.request.GetOperationsPlanningResultsRequest;
import com.forcam.na.ffwebservices.client.api.operation.operationplanning.request.GetPlanningScenarioRequest;
import com.forcam.na.ffwebservices.client.api.operation.operationplanning.request.GetPlanningScenariosRequest;
import com.forcam.na.ffwebservices.client.api.operation.operationplanning.request.SetOperationForecastResultRequest;
import com.forcam.na.ffwebservices.client.api.operation.operationplanning.request.SetOperationPlanningResultRequest;
import com.forcam.na.ffwebservices.client.api.operation.operationplanning.request.UpdateOperationForecastResultsRequest;
import com.forcam.na.ffwebservices.client.api.operation.operationplanning.response.OperationForecastResultResponse;
import com.forcam.na.ffwebservices.client.api.operation.operationplanning.response.OperationPlanningResultResponse;
import com.forcam.na.ffwebservices.client.api.operation.operationplanning.response.OperationPlanningScenarioPage;
import com.forcam.na.ffwebservices.client.api.operation.operationplanning.response.OperationsPlanningResultPage;
import com.forcam.na.ffwebservices.client.api.operation.request.SetOperationPhaseRequest;
import com.forcam.na.ffwebservices.client.api.pagination.response.Page;
import com.forcam.na.ffwebservices.client.api.workplace.request.GetWorkplacesRequest;
import com.forcam.na.ffwebservices.model.definition.OperationPhase;
import com.forcam.na.ffwebservices.model.operation.OperationAssignmentWSModel;
import com.forcam.na.ffwebservices.model.operation.OperationPlanningScenariosBodyWSModel;
import com.forcam.na.ffwebservices.model.operation.UpdateOperationForecastRequestBody;
import com.forcam.na.ffwebservices.model.planningscenarioassignment.PlanningScenarioResponse;
import com.forcam.na.ffwebservices.model.workplace.WorkplaceResponse;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Integration test for {@link OperationPlanningClient}.
 */
public class OperationPlanningClientIntegrationTest extends AbstractOpenAPIIntegrationTest {

	// ------------------------------------------------------------------------
	// constructors
	// ------------------------------------------------------------------------

	public OperationPlanningClientIntegrationTest() {
		final Pattern planningScenariosPattern = Pattern.compile(PREFIX_GET_PATH + "/operations/planningScenarios\\?.*limit=1.*");
		mFileNames.put(planningScenariosPattern, "json/getPlanningScenarios.json");

		final Pattern planningScenarioPattern = Pattern.compile(PREFIX_GET_PATH + "/operations/planningScenarios/.{32}\\?.*limit=1.*");
		mFileNames.put(planningScenarioPattern, "json/getPlanningScenario.json");

	}
	// ------------------------------------------------------------------------
	// methods
	// ------------------------------------------------------------------------

	/**
	 * Get test planning scenario.
	 *
	 * @throws ForceAPIException Exception if test fails.
	 */
	@Test
	public void testGetPlanningScenarios() throws ForceAPIException {

		// ----------------------------------------------------------------------
		// test fixture
		// ----------------------------------------------------------------------

		final GetPlanningScenariosRequest planningScenarioRequest = new GetPlanningScenariosRequest();
		planningScenarioRequest.setLimit(100);
		planningScenarioRequest.setStartDate(new Date(0));

		// ----------------------------------------------------------------------
		// test
		// ----------------------------------------------------------------------

		final Page<PlanningScenarioResponse> scenarioCollectionResponse = mOperationPlanningClient.getPlanningScenarios(planningScenarioRequest);

		Assert.assertNotNull(scenarioCollectionResponse);
		Assert.assertFalse(scenarioCollectionResponse
			.getElements()
			.isEmpty());
		Assert.assertNotNull(scenarioCollectionResponse
			.getElements()
			.get(0)
			.getProperties());
	}

	/**
	 * Test for the method {@link OperationPlanningClient#getPlanningScenario(GetPlanningScenarioRequest)}.
	 *
	 * @throws ForceAPIException When unable to get the planning scenario.
	 */
	@Test
	public void testGetPlanningScenario() throws ForceAPIException {

		// ----------------------------------------------------------------------
		// test fixture
		// ----------------------------------------------------------------------

		final OperationPlanningScenarioPage planningScenarioResponse = this.createPlanningScenario();

		final GetPlanningScenarioRequest planningScenarioRequest = new GetPlanningScenarioRequest();
		planningScenarioRequest.setPlanningScenarioId(planningScenarioResponse
			.getResponse()
			.getProperties()
			.getId());

		// ----------------------------------------------------------------------
		// test
		// ----------------------------------------------------------------------

		final OperationPlanningScenarioPage scenarioResponse = mOperationPlanningClient.getPlanningScenario(planningScenarioRequest);
		Assert.assertNotNull(scenarioResponse);
		Assert.assertNotNull(scenarioResponse.getResponse());
		Assert.assertNotNull(scenarioResponse
			.getResponse()
			.getElements());
	}

	/**
	 * Test for the method {@link OperationPlanningClient#setPlanningScenario(OperationPlanningScenariosBodyWSModel)}.
	 *
	 * @throws ForceAPIException When unable to save the planning scenario.
	 */
	@Test
	public void testSetPlanningScenario() throws ForceAPIException {

		// ----------------------------------------------------------------------
		// test
		// ----------------------------------------------------------------------

		final OperationPlanningScenarioPage scenarioResponse = this.createPlanningScenario();
		Assert.assertNotNull(scenarioResponse);
		Assert.assertNotNull(scenarioResponse.getResponse());
		Assert.assertNotNull(scenarioResponse
			.getResponse()
			.getPagination());
		Assert.assertNotNull(scenarioResponse
			.getResponse()
			.getRequest());
		Assert.assertNotNull(scenarioResponse
			.getResponse()
			.getProperties()
			.getCreationDate());
		Assert.assertNotNull(scenarioResponse
			.getResponse()
			.getProperties()
			.getNumberOfPlannedProductionOrders());
	}

	/**
	 * Creates new operation planning scenario.
	 *
	 * @return The planning scenario.
	 * @throws ForceAPIException When unable to save planning scenario.
	 */
	private OperationPlanningScenarioPage createPlanningScenario() throws ForceAPIException {
		final SetOperationPhaseRequest operationPhaseRequest = new SetOperationPhaseRequest(this.getOperationId(), OperationPhase.RELEASED);
		mOperationClient.setOperationPhase(operationPhaseRequest);

		final OperationAssignmentWSModel operationAssignmentWSModel = new OperationAssignmentWSModel();
		operationAssignmentWSModel.setEndDate(new Date(System.currentTimeMillis() + 40000));
		operationAssignmentWSModel.setStartDate(new Date(System.currentTimeMillis() + 15000));
		operationAssignmentWSModel.setSetupStartDate(new Date(System.currentTimeMillis() + 20000));
		operationAssignmentWSModel.setSetupEndDate(new Date(System.currentTimeMillis() + 25000));
		operationAssignmentWSModel.setProcessingStartDate(new Date(System.currentTimeMillis() + 30000));
		operationAssignmentWSModel.setProcessingEndDate(new Date(System.currentTimeMillis() + 35000));
		operationAssignmentWSModel.setWorkplaceId(this.getWorkplaceId());
		operationAssignmentWSModel.setOperationId(this.getOperationId());

		final List<OperationAssignmentWSModel> planningScenarioAssignmentWSModels = new ArrayList<>();
		planningScenarioAssignmentWSModels.add(operationAssignmentWSModel);

		final OperationPlanningScenariosBodyWSModel propertiesWSModel = new OperationPlanningScenariosBodyWSModel();
		propertiesWSModel.setStartDate(new Date(System.currentTimeMillis() + 10000));
		propertiesWSModel.setEndDate(new Date(System.currentTimeMillis() + 80000));
		propertiesWSModel.setAssignments(planningScenarioAssignmentWSModels);

		final OperationPlanningScenarioPage scenarioResponse = mOperationPlanningClient.setPlanningScenario(propertiesWSModel);
		Assert.assertNotNull(scenarioResponse);
		return scenarioResponse;
	}

	/**
	 * Test for the method {@link OperationPlanningClient#getOperationPlanningResult(GetOperationPlanningResultRequest)}.
	 *
	 * @throws ForceAPIException When unable to get operation planning result.
	 */
	@Test
	public void testGetOperationPlanningResult() throws ForceAPIException {

		// ----------------------------------------------------------------------
		// test fixture
		// ----------------------------------------------------------------------

		this.createOperationPlanningResult();
		final String operationId = this.getOperationId();
		final GetOperationPlanningResultRequest request = new GetOperationPlanningResultRequest(operationId);
		request
			.embed()
			.plannedWorkplace(true);

		// ----------------------------------------------------------------------
		// test
		// ----------------------------------------------------------------------

		final OperationPlanningResultResponse operationPlanningResultResponse = mOperationPlanningClient.getOperationPlanningResult(request);

		Assert.assertNotNull(operationPlanningResultResponse);
		Assert.assertNotNull(operationPlanningResultResponse.getSelf());
		Assert.assertNotNull(operationPlanningResultResponse.getProperties());
		Assert.assertNotNull(operationPlanningResultResponse
			.getPlannedWorkplace()
			.getEmbedded());
	}

	/**
	 * Test for the method {@link OperationPlanningClient#getOperationsPlanningResults(GetOperationsPlanningResultsRequest)}.
	 *
	 * @throws ForceAPIException When unable to get operations planning results.
	 */
	@Test
	public void testGetOperationsPlanningResults() throws ForceAPIException {

		// ----------------------------------------------------------------------
		// test fixture
		// ----------------------------------------------------------------------

		this.createOperationPlanningResult();
		final GetOperationsPlanningResultsRequest request = new GetOperationsPlanningResultsRequest();
		request.setLimit(1);
		request.setEndDate(new Date(System.currentTimeMillis() + 55000));

		// ----------------------------------------------------------------------
		// test
		// ----------------------------------------------------------------------

		final OperationsPlanningResultPage page = mOperationPlanningClient.getOperationsPlanningResults(request);

		Assert.assertNotNull(page);
		Assert.assertNotNull(page
			.getResponse()
			.getProperties());
		Assert.assertNotNull(page
			.getResponse()
			.getPagination());
		Assert.assertFalse(page
			.getResponse()
			.getElements()
			.isEmpty());
	}

	/**
	 * Test for the method {@link OperationPlanningClient#deleteOperationPlanningResult(String)}.
	 *
	 * @throws ForceAPIException When unable to delete operation planning result.
	 */
	@Test
	public void testDeleteOperationPlanningResult() throws ForceAPIException {

		// ----------------------------------------------------------------------
		// test fixture
		// ----------------------------------------------------------------------

		this.createOperationPlanningResult();
		final String operationId = this.getOperationId();

		// ----------------------------------------------------------------------
		// test
		// ----------------------------------------------------------------------

		mOperationPlanningClient.deleteOperationPlanningResult(operationId);
	}

	/**
	 * Test for the method {@link OperationPlanningClient#deleteOperationForecastResult(String)}.
	 *
	 * @throws ForceAPIException When unable to delete operation forecast result.
	 */
	@Test
	public void testDeleteOperationForecastResult() throws ForceAPIException {

		// ----------------------------------------------------------------------
		// test fixture
		// ----------------------------------------------------------------------

		final String operationId = this.getOperationId();
		this.createOperationForecastResult(operationId);

		// ----------------------------------------------------------------------
		// test
		// ----------------------------------------------------------------------

		mOperationPlanningClient.deleteOperationPlanningResult(operationId);
	}

	/**
	 * Test for the method {@link OperationPlanningClient#saveOperationForecastResult(SetOperationForecastResultRequest)}.
	 *
	 * @throws ForceAPIException When unable to save operation forecast result.
	 */
	@Test
	public void testSaveOperationForecastResult() throws ForceAPIException {

		// ----------------------------------------------------------------------
		// test
		// ----------------------------------------------------------------------

		final String operationId = this.getOperationId();
		final OperationForecastResultResponse operationForecastResult = this.createOperationForecastResult(operationId);

		Assert.assertNotNull(operationForecastResult);
		Assert.assertNotNull(operationForecastResult.getSelf());
		Assert.assertNotNull(operationForecastResult.getProperties());
		Assert.assertNotNull(operationForecastResult
			.getProperties()
			.getStartDate());
		Assert.assertNotNull(operationForecastResult
			.getProperties()
			.getEndDate());
		Assert.assertNotNull(operationForecastResult
			.getProperties()
			.getSetupStartDate());
		Assert.assertNotNull(operationForecastResult
			.getProperties()
			.getSetupEndDate());
		Assert.assertNotNull(operationForecastResult
			.getProperties()
			.getProcessingStartDate());
		Assert.assertNotNull(operationForecastResult
			.getProperties()
			.getProcessingEndDate());
		Assert.assertNotNull(operationForecastResult
			.getProperties()
			.getOperationId());
		Assert.assertNotNull(operationForecastResult
			.getProperties()
			.getWorkplaceId());
	}

	/**
	 * Test for the method {@link OperationPlanningClient#updateOperationForecastResults(UpdateOperationForecastResultsRequest)}.
	 *
	 * @throws ForceAPIException When unable to update operation forecast result.
	 */
	@Test
	public void testUpdateOperationForecastResult() throws ForceAPIException {

		// ----------------------------------------------------------------------
		// test
		// ----------------------------------------------------------------------

		final Date startDate = new Date(System.currentTimeMillis() + 1000000);
		final Date endDate = new Date(System.currentTimeMillis() + 9000000);
		final Date setupStartDate = new Date(System.currentTimeMillis() + 1000000);
		final Date setupEndDate = new Date(System.currentTimeMillis() + 3000000);
		final Date processingStartDate = new Date(System.currentTimeMillis() + 3000000);
		final Date processingEndDate = new Date(System.currentTimeMillis() + 9000000);

		final String operationId = this.getOperationId();
		this.createOperationForecastResult(operationId);

		final UpdateOperationForecastRequestBody body = new UpdateOperationForecastRequestBody();

		final OperationAssignmentWSModel properties = new OperationAssignmentWSModel();
		properties.setStartDate(startDate);
		properties.setEndDate(endDate);
		properties.setSetupStartDate(setupStartDate);
		properties.setSetupEndDate(setupEndDate);
		properties.setProcessingStartDate(processingStartDate);
		properties.setProcessingEndDate(processingEndDate);
		properties.setOperationId(operationId);
		properties.setWorkplaceId(this.getWorkplaceId());

		final List<OperationAssignmentWSModel> forecastResults = new ArrayList<>(1);
		forecastResults.add(properties);

		body.setForecastResults(forecastResults);

		final UpdateOperationForecastResultsRequest request = new UpdateOperationForecastResultsRequest();
		request.setForecastResults(body);

		mOperationPlanningClient.updateOperationForecastResults(request);

		final OperationForecastResultResponse response = mOperationPlanningClient.getOperationForecastResult(operationId);
		Assert.assertNotNull(response);
		Assert.assertEquals(startDate,
			response
				.getProperties()
				.getStartDate());
		Assert.assertEquals(endDate,
			response
				.getProperties()
				.getEndDate());
		Assert.assertEquals(setupStartDate,
			response
				.getProperties()
				.getSetupStartDate());
		Assert.assertEquals(setupEndDate,
			response
				.getProperties()
				.getSetupEndDate());
		Assert.assertEquals(processingStartDate,
			response
				.getProperties()
				.getProcessingStartDate());
		Assert.assertEquals(processingEndDate,
			response
				.getProperties()
				.getProcessingEndDate());
	}

	/**
	 * Test for the method {@link OperationPlanningClient#getOperationForecastResult(String)}.
	 *
	 * @throws ForceAPIException When unable to get operation forecast result.
	 */
	@Test
	public void testGetOperationForecastResult() throws ForceAPIException {

		// ----------------------------------------------------------------------
		// test fixture
		// ----------------------------------------------------------------------

		final String operationId = this.getOperationId();
		this.createOperationForecastResult(operationId);

		// ----------------------------------------------------------------------
		// test
		// ----------------------------------------------------------------------

		final OperationForecastResultResponse operationForecastResult = mOperationPlanningClient.getOperationForecastResult(operationId);

		Assert.assertNotNull(operationForecastResult);
		Assert.assertNotNull(operationForecastResult.getSelf());
		Assert.assertNotNull(operationForecastResult.getProperties());
		Assert.assertNotNull(operationForecastResult
			.getProperties()
			.getStartDate());
		Assert.assertNotNull(operationForecastResult
			.getProperties()
			.getEndDate());
		Assert.assertNotNull(operationForecastResult
			.getProperties()
			.getSetupStartDate());
		Assert.assertNotNull(operationForecastResult
			.getProperties()
			.getSetupEndDate());
		Assert.assertNotNull(operationForecastResult
			.getProperties()
			.getProcessingStartDate());
		Assert.assertNotNull(operationForecastResult
			.getProperties()
			.getProcessingEndDate());
	}

	/**
	 * Test for the method {@link OperationPlanningClient#saveOperationPlanningResult(SetOperationPlanningResultRequest)}.
	 *
	 * @throws ForceAPIException When unable to save operation planning result.
	 */
	@Test
	public void testSaveOperationPlanningResult() throws ForceAPIException {

		// ----------------------------------------------------------------------
		// test
		// ----------------------------------------------------------------------

		final OperationPlanningResultResponse operationPlanningResultResponse = this.createOperationPlanningResult();

		Assert.assertNotNull(operationPlanningResultResponse);
		Assert.assertNotNull(operationPlanningResultResponse.getSelf());
		Assert.assertNotNull(operationPlanningResultResponse.getProperties());
	}

	/**
	 * Creates new operation planning result.
	 *
	 * @return Created operation planning result.
	 * @throws ForceAPIException When unable to save planning result.
	 */
	private OperationPlanningResultResponse createOperationPlanningResult() throws ForceAPIException {

		final String operationId = this.getOperationId();
		final SetOperationPhaseRequest operationPhaseRequest = new SetOperationPhaseRequest(operationId, OperationPhase.RELEASED);
		mOperationClient.setOperationPhase(operationPhaseRequest);

		final boolean fixed = true;
		final Date date = new Date(System.currentTimeMillis() + 50000);

		final OperationAssignmentWSModel propertiesWSModel = new OperationAssignmentWSModel();
		propertiesWSModel.setFixed(fixed);
		propertiesWSModel.setEndDate(date);
		propertiesWSModel.setStartDate(date);
		propertiesWSModel.setProcessingEndDate(date);
		propertiesWSModel.setProcessingStartDate(date);
		propertiesWSModel.setSetupEndDate(date);
		propertiesWSModel.setSetupStartDate(date);
		propertiesWSModel.setWorkplaceId(this.getPlannedWorkplaceId());
		propertiesWSModel.setOperationId(operationId);

		final SetOperationPlanningResultRequest request = new SetOperationPlanningResultRequest(operationId);
		request.setPlanningResult(propertiesWSModel);

		return mOperationPlanningClient.saveOperationPlanningResult(request);
	}

	/**
	 * Creates new operation forecast result.
	 *
	 * @return Created operation forecast result.
	 * @throws ForceAPIException When unable to save forecast result.
	 */
	private OperationForecastResultResponse createOperationForecastResult(String operationId) throws ForceAPIException {

		final SetOperationPhaseRequest operationPhaseRequest = new SetOperationPhaseRequest(operationId, OperationPhase.RELEASED);
		mOperationClient.setOperationPhase(operationPhaseRequest);

		final Date date = new Date(System.currentTimeMillis() + 100000);

		final OperationAssignmentWSModel propertiesWSModel = new OperationAssignmentWSModel();
		propertiesWSModel.setEndDate(date);
		propertiesWSModel.setStartDate(date);
		propertiesWSModel.setProcessingEndDate(date);
		propertiesWSModel.setProcessingStartDate(date);
		propertiesWSModel.setSetupEndDate(date);
		propertiesWSModel.setSetupStartDate(date);
		propertiesWSModel.setOperationId(operationId);
		propertiesWSModel.setWorkplaceId(this.getWorkplaceId());

		final SetOperationForecastResultRequest request = new SetOperationForecastResultRequest(operationId);
		request.setForecastResult(propertiesWSModel);

		return mOperationPlanningClient.saveOperationForecastResult(request);
	}

	/**
	 * Gets UUID of an available workplace.
	 *
	 * @return The workplace UUID.
	 * @throws ForceAPIException When unable to get workplaces.
	 */
	private String getPlannedWorkplaceId() throws ForceAPIException {
		final GetWorkplacesRequest request = new GetWorkplacesRequest();
		final Page<WorkplaceResponse> collectionResponse = mWorkplaceClient.getWorkplaces(request);
		return collectionResponse
			.getElements()
			.get(0)
			.getProperties()
			.getId();
	}
}
