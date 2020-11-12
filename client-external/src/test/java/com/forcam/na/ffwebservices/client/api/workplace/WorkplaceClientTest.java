////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 14.09.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.workplace;

import com.forcam.na.ffwebservices.client.api.AbstractOpenAPIMockTest;
import com.forcam.na.ffwebservices.client.api.config.GuiceTestRunner;
import com.forcam.na.ffwebservices.client.api.exception.ForceAPIException;
import com.forcam.na.ffwebservices.client.api.operation.response.RecordedOperatingStateCollectionPage;
import com.forcam.na.ffwebservices.client.api.pagination.response.Page;
import com.forcam.na.ffwebservices.client.api.shift.request.GetWorkplaceShiftRequest;
import com.forcam.na.ffwebservices.client.api.shift.request.GetWorkplaceShiftsRequest;
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
import com.forcam.na.ffwebservices.model.TimePeriodWSModel;
import com.forcam.na.ffwebservices.model.collection.Pagination;
import com.forcam.na.ffwebservices.model.device.DeviceResponse;
import com.forcam.na.ffwebservices.model.shift.WorkplaceShiftResponse;
import com.forcam.na.ffwebservices.model.workplace.EmbeddedPredictedMalfunctionScenarioResponse;
import com.forcam.na.ffwebservices.model.workplace.UpdateWorkplaceRecordedOperatingStateRequestBody;
import com.forcam.na.ffwebservices.model.workplace.WorkplaceResponse;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

/**
 * Tests for the class {@link WorkplaceClient}.
 */
@RunWith(GuiceTestRunner.class)
public class WorkplaceClientTest extends AbstractOpenAPIMockTest {

	// ------------------------------------------------------------------------
	// members
	// ------------------------------------------------------------------------

	/** Helper for test exceptions and messages. */
	@Rule
	public ExpectedException mExpectedException = ExpectedException.none();

	/** The workplace client. */
	private IWorkplaceClient mWorkplaceClient;

	// ------------------------------------------------------------------------
	// constructor
	// ------------------------------------------------------------------------

	public WorkplaceClientTest() {
		mWorkplaceClient = mBridgeAPIComponent.workplaceClient();
	}

	// ------------------------------------------------------------------------
	// methods
	// ------------------------------------------------------------------------

	/**
	 * Test for the method {@link WorkplaceClient#getWorkplaces(GetWorkplacesRequest)}.
	 *
	 * @throws ForceAPIException    When unable to get workplaces.
	 * @throws InterruptedException When unable to take the request from the server.
	 * @throws IOException          When unable to read the JSON file.
	 * @throws URISyntaxException   When unable to create a URI of the JSON file.
	 */
	@Test
	public void getWorkplaces() throws ForceAPIException, InterruptedException, IOException, URISyntaxException {

		// ----------------------------------------------------------------------
		// test fixture
		// ----------------------------------------------------------------------

		mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getWorkplaces.json")));
		final int limit = 3;
		final int offset = 0;
		final GetWorkplacesRequest request = new GetWorkplacesRequest();
		request
			.setLimit(limit)
			.setOffset(offset);
		request
			.embed()
			.machine(true)
			.erpContext(true);

		// ----------------------------------------------------------------------
		// test
		// ----------------------------------------------------------------------

		final Page<WorkplaceResponse> response = mWorkplaceClient.getWorkplaces(request);

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
		Assert.assertFalse(response
			.getElements()
			.isEmpty());
	}

	/**
	 * Test for the method {@link WorkplaceClient#getWorkplace(GetWorkplaceRequest)}.
	 *
	 * @throws ForceAPIException    When unable to get workplace.
	 * @throws InterruptedException When unable to take the request from the server.
	 * @throws IOException          When unable to read the JSON file.
	 * @throws URISyntaxException   When unable to create a URI of the JSON file.
	 */
	@Test
	public void getWorkplace() throws ForceAPIException, InterruptedException, IOException, URISyntaxException {

		// ----------------------------------------------------------------------
		// test fixture
		// ----------------------------------------------------------------------

		mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getWorkplace.json")));
		final GetWorkplaceRequest request = new GetWorkplaceRequest("TESTID");

		// ----------------------------------------------------------------------
		// test
		// ----------------------------------------------------------------------

		final WorkplaceResponse response = mWorkplaceClient.getWorkplace(request);

		final RecordedRequest recordedRequest = mMockWebServer.takeRequest();
		final String requestQuery = recordedRequest
			.getRequestUrl()
			.query();
		Assert.assertNotNull(requestQuery);

		Assert.assertNotNull(response);
		Assert.assertNotNull(response.getSelf());
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
	 * Test for the method {@link WorkplaceClient#getShifts(GetWorkplaceShiftsRequest)} .
	 *
	 * @throws ForceAPIException    When unable to get shifts.
	 * @throws InterruptedException When unable to take the request from the server.
	 * @throws IOException          When unable to read the JSON file.
	 * @throws URISyntaxException   When unable to create a URI of the JSON file.
	 */
	@Test
	public void getShifts() throws ForceAPIException, InterruptedException, IOException, URISyntaxException {

		// ----------------------------------------------------------------------
		// test fixture
		// ----------------------------------------------------------------------

		mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getWorkplaceShifts.json")));
		final int limit = 3;
		final GetWorkplaceShiftsRequest request = new GetWorkplaceShiftsRequest();
		request.setLimit(limit);
		request
			.embed()
			.workplace(true)
			.shiftType(true);

		// ----------------------------------------------------------------------
		// test
		// ----------------------------------------------------------------------

		final Page<WorkplaceShiftResponse> response = mWorkplaceClient.getShifts(request);

		final RecordedRequest recordedRequest = mMockWebServer.takeRequest();
		final String requestQuery = recordedRequest
			.getRequestUrl()
			.query();
		Assert.assertNotNull(requestQuery);
		Assert.assertTrue(requestQuery.contains("embed=" + request
			.embed()
			.toString()));
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
		Assert.assertFalse(response
			.getElements()
			.isEmpty());
	}

	/**
	 * Test for the method {@link WorkplaceClient#getShift(GetWorkplaceShiftRequest)}.
	 *
	 * @throws ForceAPIException    When unable to get shift.
	 * @throws InterruptedException When unable to take the request from the server.
	 * @throws IOException          When unable to read the JSON file.
	 * @throws URISyntaxException   When unable to create a URI of the JSON file.
	 */
	@Test
	public void getShift() throws ForceAPIException, InterruptedException, IOException, URISyntaxException {

		// ----------------------------------------------------------------------
		// test fixture
		// ----------------------------------------------------------------------

		mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getWorkplaceShift.json")));
		final GetWorkplaceShiftRequest request = new GetWorkplaceShiftRequest("TESTID");
		request
			.embed()
			.workplace(true)
			.shiftType(true);

		// ----------------------------------------------------------------------
		// test
		// ----------------------------------------------------------------------

		final WorkplaceShiftResponse response = mWorkplaceClient.getShift(request);

		final RecordedRequest recordedRequest = mMockWebServer.takeRequest();
		final String requestQuery = recordedRequest
			.getRequestUrl()
			.query();
		Assert.assertNotNull(requestQuery);

		Assert.assertNotNull(response);
		Assert.assertNotNull(response.getSelf());
		Assert.assertNotNull(response.getWorkplace());
		Assert.assertNotNull(response
			.getWorkplace()
			.getLink());
		Assert.assertNotNull(response.getShiftType());
		Assert.assertNotNull(response
			.getShiftType()
			.getLink());
		Assert.assertNotNull(response.getProperties());
		Assert.assertNotNull(response
			.getProperties()
			.getId());
		Assert.assertFalse(response
			.getProperties()
			.getShift()
			.getBreaks()
			.isEmpty());
	}

	/**
	 * Test for the method {@link WorkplaceClient#getRecordedOperatingStates(GetWorkplaceRecordedOperatingStatesRequest)}.
	 *
	 * @throws ForceAPIException    When unable to get recorded operating states.
	 * @throws InterruptedException When unable to take the request from the server.
	 * @throws IOException          When unable to read the JSON file.
	 * @throws URISyntaxException   When unable to create a URI of the JSON file.
	 */
	@Test
	public void getRecordedOperatingStates() throws ForceAPIException, InterruptedException, IOException, URISyntaxException {

		// ----------------------------------------------------------------------
		// test fixture
		// ----------------------------------------------------------------------

		mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getWorkplaceRecordedOperatingStates.json")));
		final int limit = 3;
		final GetWorkplaceRecordedOperatingStatesRequest request = new GetWorkplaceRecordedOperatingStatesRequest("TESTID");
		request.setLimit(limit);
		request
			.embed()
			.operatingState(true);

		// ----------------------------------------------------------------------
		// test
		// ----------------------------------------------------------------------

		final RecordedOperatingStateCollectionPage page = mWorkplaceClient.getRecordedOperatingStates(request);

		final RecordedRequest recordedRequest = mMockWebServer.takeRequest();
		final String requestQuery = recordedRequest
			.getRequestUrl()
			.query();
		Assert.assertNotNull(requestQuery);
		Assert.assertTrue(requestQuery.contains("embed=" + request
			.embed()
			.toString()));
		Assert.assertTrue(requestQuery.contains("limit=" + limit));

		Assert.assertNotNull(page);
		Assert.assertFalse(page
			.getResponse()
			.getProperties()
			.getElements()
			.isEmpty());
	}

	/**
	 * Test for the method {@link WorkplaceClient#updateRecordedOperatingState(UpdateWorkplaceRecordedOperatingStateRequest)}.
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
		final String workplaceId = "TESTID";
		final UpdateWorkplaceRecordedOperatingStateRequest request = new UpdateWorkplaceRecordedOperatingStateRequest(workplaceId);

		// ----------------------------------------------------------------------
		// test
		// ----------------------------------------------------------------------

		mWorkplaceClient.updateRecordedOperatingState(request);

		final RecordedRequest recordedRequest = mMockWebServer.takeRequest();
		final String requestUrl = recordedRequest
			.getRequestUrl()
			.toString();
		Assert.assertNotNull(requestUrl);
		Assert.assertTrue(requestUrl.contains(workplaceId));

		final String body = recordedRequest
			.getBody()
			.readUtf8();
		final UpdateWorkplaceRecordedOperatingStateRequestBody requestModel = mMapper.readValue(body, UpdateWorkplaceRecordedOperatingStateRequestBody.class);
		Assert.assertEquals(request.getWorkplaceRecordedOperatingState(), requestModel);
	}

	/**
	 * Test for the method {@link WorkplaceClient#getQuantitySummary(GetWorkplaceQuantitySummaryRequest)}.
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

		mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getWorkplaceQuantitySummary.json")));
		final int limit = 3;
		final int offset = 0;
		final String workplaceId = "TESTID";
		final GetWorkplaceQuantitySummaryRequest request = new GetWorkplaceQuantitySummaryRequest(workplaceId);
		request
			.setLimit(limit)
			.setOffset(offset);

		// ----------------------------------------------------------------------
		// test
		// ----------------------------------------------------------------------

		final WorkplaceQuantitySummaryCollectionPage page = mWorkplaceClient.getQuantitySummary(request);

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
		Assert.assertTrue(requestUrl.contains(workplaceId));

		Assert.assertNotNull(page);
		Assert.assertNotNull(page
			.getResponse()
			.getProperties());
	}

	/**
	 * Test for the method {@link WorkplaceClient#getScheduledOperatingTimes(GetWorkplaceTimeRangeRequest)}.
	 *
	 * @throws ForceAPIException    When unable to get quantity summary.
	 * @throws InterruptedException When unable to take the request from the server.
	 * @throws IOException          When unable to read the JSON file.
	 * @throws URISyntaxException   When unable to create a URI of the JSON file.
	 */
	@Test
	public void testGetScheduledOperatingTimes() throws ForceAPIException, InterruptedException, IOException, URISyntaxException {

		// ----------------------------------------------------------------------
		// test fixture
		// ----------------------------------------------------------------------

		mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getScheduledOperatingTimes.json")));
		final int limit = 3;
		final String workplaceId = "TESTID";
		final GetWorkplaceTimeRangeRequest request = new GetWorkplaceTimeRangeRequest(workplaceId);
		request.setLimit(limit);

		// ----------------------------------------------------------------------
		// test
		// ----------------------------------------------------------------------

		final WorkplaceScheduledOperatingTimesCollectionPage page = mWorkplaceClient.getScheduledOperatingTimes(request);

		final RecordedRequest recordedRequest = mMockWebServer.takeRequest();
		final String requestQuery = recordedRequest
			.getRequestUrl()
			.query();
		Assert.assertNotNull(requestQuery);
		Assert.assertTrue(requestQuery.contains("limit=" + limit));

		final String requestUrl = recordedRequest
			.getRequestUrl()
			.toString();
		Assert.assertNotNull(requestUrl);
		Assert.assertTrue(requestUrl.contains(workplaceId));

		Assert.assertNotNull(page);
		Assert.assertNotNull(page
			.getResponse()
			.getProperties());
		Assert.assertEquals(3,
			page
				.getResponse()
				.getProperties()
				.getElements()
				.size());

		validateTimePeriodModels(page
			.getResponse()
			.getProperties()
			.getElements());
	}

	/**
	 * Test for the method {@link WorkplaceClient#getWorkplaceScheduledMaintenanceTimes(GetWorkplaceTimeRangeRequest)}.
	 *
	 * @throws ForceAPIException    When unable to get the scheduled maintenance times.
	 * @throws InterruptedException When unable to take the request from the server.
	 * @throws IOException          When unable to read the JSON file.
	 * @throws URISyntaxException   When unable to create a URI of the JSON file.
	 */
	@Test
	public void testGetScheduledMaintenanceTimes() throws ForceAPIException, InterruptedException, IOException, URISyntaxException {

		// ----------------------------------------------------------------------
		// test fixture
		// ----------------------------------------------------------------------

		mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getWorkplaceScheduledMaintenanceTimes.json")));
		final int limit = 3;
		final String workplaceId = "TESTID";
		final GetWorkplaceTimeRangeRequest request = new GetWorkplaceTimeRangeRequest(workplaceId);
		request.setLimit(limit);

		// ----------------------------------------------------------------------
		// test
		// ----------------------------------------------------------------------

		final WorkplaceScheduledMaintenanceTimesCollectionPage page = mWorkplaceClient.getWorkplaceScheduledMaintenanceTimes(request);

		final RecordedRequest recordedRequest = mMockWebServer.takeRequest();
		final String requestQuery = recordedRequest
			.getRequestUrl()
			.query();
		Assert.assertNotNull(requestQuery);
		Assert.assertTrue(requestQuery.contains("limit=" + limit));

		final String requestUrl = recordedRequest
			.getRequestUrl()
			.toString();
		Assert.assertNotNull(requestUrl);
		Assert.assertTrue(requestUrl.contains(workplaceId));

		Assert.assertNotNull(page);
		Assert.assertNotNull(page
			.getResponse()
			.getProperties());
		Assert.assertEquals(3,
			page
				.getResponse()
				.getProperties()
				.getElements()
				.size());

		validateTimePeriodModels(page
			.getResponse()
			.getProperties()
			.getElements());
	}

	/**
	 * Validate time period WS models.
	 *
	 * @param elements List of time period WS models.
	 */
	private void validateTimePeriodModels(List<TimePeriodWSModel> elements) {
		elements.forEach(model -> {
			Assert.assertTrue(model.getDuration() > 0);
			Assert.assertNotNull(model.getStartDate());
			Assert.assertNotNull(model.getEndDate());
			Assert.assertEquals(model
					.getDuration()
					.longValue(),
				model
					.getEndDate()
					.getTime() - model
					.getStartDate()
					.getTime());
		});
	}

	/**
	 * Test for the method {@link WorkplaceClient#getOperatingStateSummary(GetOperatingStateSummaryRequest)}.
	 *
	 * @throws ForceAPIException    When unable to get operating state summary.
	 * @throws InterruptedException When unable to take the request from the server.
	 * @throws IOException          When unable to read the JSON file.
	 * @throws URISyntaxException   When unable to create a URI of the JSON file.
	 */
	@Test
	public void testGetOperatingStateSummary() throws ForceAPIException, InterruptedException, IOException, URISyntaxException {

		// ----------------------------------------------------------------------
		// test fixture
		// ----------------------------------------------------------------------

		mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getWorkplaceOperatingStateSummary.json")));
		final int limit = 3;
		final int offset = 0;
		final String workplaceId = "TESTID";
		final GetOperatingStateSummaryRequest request = new GetOperatingStateSummaryRequest(workplaceId);
		request
			.setLimit(limit)
			.setOffset(offset);

		// ----------------------------------------------------------------------
		// test
		// ----------------------------------------------------------------------

		final WorkplaceOperatingStateSummaryPage page = mWorkplaceClient.getOperatingStateSummary(request);

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
		Assert.assertTrue(requestUrl.contains(workplaceId));

		Assert.assertNotNull(page);
		Assert.assertNotNull(page
			.getResponse()
			.getProperties());
		Assert.assertEquals(2,
			page
				.getResponse()
				.getProperties()
				.getElements()
				.size());
	}

	/**
	 * Test for the method {@link WorkplaceClient#getWorkplaceRecordedOutputQuantities(GetWorkplaceRecordedOutputQuantitiesRequest)}.
	 *
	 * @throws ForceAPIException    When unable to get recorded output quantities of workplace.
	 * @throws InterruptedException When unable to take the request from the server.
	 * @throws IOException          When unable to read the JSON file.
	 * @throws URISyntaxException   When unable to create a URI of the JSON file.
	 */
	@Test
	public void testGetWorkplaceRecordedOutputQuantities() throws ForceAPIException, InterruptedException, IOException, URISyntaxException {

		// ----------------------------------------------------------------------
		// test fixture
		// ----------------------------------------------------------------------

		mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getWorkplaceRecordedOutputQuantities.json")));
		final int limit = 3;
		final int offset = 0;
		final String workplaceId = "TESTID";
		final GetWorkplaceRecordedOutputQuantitiesRequest request = new GetWorkplaceRecordedOutputQuantitiesRequest(workplaceId);
		request.setLimit(limit);

		// ----------------------------------------------------------------------
		// test
		// ----------------------------------------------------------------------

		final WorkplaceRecordedOutputQuantitiesPage page = mWorkplaceClient.getWorkplaceRecordedOutputQuantities(request);

		final RecordedRequest recordedRequest = mMockWebServer.takeRequest();
		final String requestQuery = recordedRequest
			.getRequestUrl()
			.query();
		Assert.assertNotNull(requestQuery);
		Assert.assertTrue(requestQuery.contains("limit=" + limit));

		final String requestUrl = recordedRequest
			.getRequestUrl()
			.toString();
		Assert.assertNotNull(requestUrl);
		Assert.assertTrue(requestUrl.contains(workplaceId));

		Assert.assertNotNull(page);
		Assert.assertNotNull(page
			.getResponse()
			.getProperties());
		Assert.assertEquals(3,
			page
				.getResponse()
				.getProperties()
				.getElements()
				.size());
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
	 * Test for the method {@link WorkplaceClient#getWorkplaceRecordedOperationPhases(GetWorkplaceTimeRangeRequest)}.
	 *
	 * @throws ForceAPIException    When unable to get recorded operation phases of workplace.
	 * @throws InterruptedException When unable to take the request from the server.
	 * @throws IOException          When unable to read the JSON file.
	 * @throws URISyntaxException   When unable to create a URI of the JSON file.
	 */
	@Test
	public void testGetWorkplaceRecordedOperationPhases() throws ForceAPIException, InterruptedException, IOException, URISyntaxException {

		// ----------------------------------------------------------------------
		// test fixture
		// ----------------------------------------------------------------------

		mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getWorkplaceRecordedOperationPhases.json")));
		final int limit = 3;
		final String workplaceId = "TESTID";
		final GetWorkplaceTimeRangeRequest request = new GetWorkplaceTimeRangeRequest(workplaceId);
		request.setLimit(limit);

		// ----------------------------------------------------------------------
		// test
		// ----------------------------------------------------------------------

		final WorkplaceRecordedOperationPhasesPage page = mWorkplaceClient.getWorkplaceRecordedOperationPhases(request);

		final RecordedRequest recordedRequest = mMockWebServer.takeRequest();
		final String requestQuery = recordedRequest
			.getRequestUrl()
			.query();
		Assert.assertNotNull(requestQuery);
		Assert.assertTrue(requestQuery.contains("limit=" + limit));

		final String requestUrl = recordedRequest
			.getRequestUrl()
			.toString();
		Assert.assertNotNull(requestUrl);
		Assert.assertTrue(requestUrl.contains(workplaceId));

		Assert.assertNotNull(page);
		Assert.assertNotNull(page
			.getResponse()
			.getProperties());
		Assert.assertEquals(3,
			page
				.getResponse()
				.getProperties()
				.getElements()
				.size());
		Assert.assertNotNull(page
			.getResponse()
			.getProperties()
			.getElements()
			.get(0)
			.getOperationId());
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
			.getEndDate());
		Assert.assertNotNull(page
			.getResponse()
			.getProperties()
			.getElements()
			.get(0)
			.getStartDate());
	}

	/**
	 * Tests getting workplaces while server is down.
	 *
	 * @throws IOException       When unable to shutdown the server.
	 * @throws ForceAPIException When unable to get workplaces.
	 */
	@Test
	public void getWorkplacesShutdown() throws IOException, ForceAPIException {

		// ----------------------------------------------------------------------
		// test fixture
		// ----------------------------------------------------------------------

		final GetWorkplacesRequest request = new GetWorkplacesRequest();
		mMockWebServer.shutdown();
		mExpectedException.expect(ForceAPIException.class);
		mExpectedException.expectMessage("Unable to execute call using request: " + request);

		// ----------------------------------------------------------------------
		// test
		// ----------------------------------------------------------------------

		mWorkplaceClient.getWorkplaces(request);
	}

	/**
	 * Tests getting workplace while server is down.
	 *
	 * @throws IOException       When unable to shutdown the server.
	 * @throws ForceAPIException When unable to get workplace.
	 */
	@Test
	public void getWorkplaceShutdown() throws IOException, ForceAPIException {

		// ----------------------------------------------------------------------
		// test fixture
		// ----------------------------------------------------------------------

		final GetWorkplaceRequest request = new GetWorkplaceRequest("workplaceId");
		mMockWebServer.shutdown();
		mExpectedException.expect(ForceAPIException.class);
		mExpectedException.expectMessage("Unable to execute call using request: " + request);

		// ----------------------------------------------------------------------
		// test
		// ----------------------------------------------------------------------

		mWorkplaceClient.getWorkplace(request);
	}

	/**
	 * Tests getting shifts while server is down.
	 *
	 * @throws IOException       When unable to shutdown the server.
	 * @throws ForceAPIException When unable to get shifts.
	 */
	@Test
	public void getShiftsShutdown() throws IOException, ForceAPIException {

		// ----------------------------------------------------------------------
		// test fixture
		// ----------------------------------------------------------------------

		final GetWorkplaceShiftsRequest request = new GetWorkplaceShiftsRequest();
		mMockWebServer.shutdown();
		mExpectedException.expect(ForceAPIException.class);
		mExpectedException.expectMessage("Unable to execute call using request: " + request);

		// ----------------------------------------------------------------------
		// test
		// ----------------------------------------------------------------------

		mWorkplaceClient.getShifts(request);
	}

	/**
	 * Tests getting a shift while server is down.
	 *
	 * @throws IOException       When unable to shutdown the server.
	 * @throws ForceAPIException When unable to get shift.
	 */
	@Test
	public void getShiftShutdown() throws IOException, ForceAPIException {

		// ----------------------------------------------------------------------
		// test fixture
		// ----------------------------------------------------------------------

		final GetWorkplaceShiftRequest request = new GetWorkplaceShiftRequest("shiftId");
		mMockWebServer.shutdown();
		mExpectedException.expect(ForceAPIException.class);
		mExpectedException.expectMessage("Unable to execute call using request: " + request);

		// ----------------------------------------------------------------------
		// test
		// ----------------------------------------------------------------------

		mWorkplaceClient.getShift(request);
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

		final GetWorkplaceRecordedOperatingStatesRequest request = new GetWorkplaceRecordedOperatingStatesRequest("workplaceId");
		mMockWebServer.shutdown();
		mExpectedException.expect(ForceAPIException.class);
		mExpectedException.expectMessage("Unable to execute call using request: " + request);

		// ----------------------------------------------------------------------
		// test
		// ----------------------------------------------------------------------

		mWorkplaceClient.getRecordedOperatingStates(request);
	}

	/**
	 * Tests updating the recorded operating state of workplace while server is down.
	 *
	 * @throws IOException       When unable to shutdown the server.
	 * @throws ForceAPIException When unable to update recorded operating state.
	 */
	@Test
	public void updateRecordedOperatingStateShutdown() throws IOException, ForceAPIException {

		// ----------------------------------------------------------------------
		// test fixture
		// ----------------------------------------------------------------------

		final UpdateWorkplaceRecordedOperatingStateRequest request = new UpdateWorkplaceRecordedOperatingStateRequest("workplaceId");
		mMockWebServer.shutdown();
		mExpectedException.expect(ForceAPIException.class);
		mExpectedException.expectMessage("Unable to execute call using request: " + request);

		// ----------------------------------------------------------------------
		// test
		// ----------------------------------------------------------------------

		mWorkplaceClient.updateRecordedOperatingState(request);
	}

	/**
	 * Tests getting the quantity summary of workplace while server is down.
	 *
	 * @throws IOException       When unable to shutdown the server.
	 * @throws ForceAPIException When unable to get quantity summary.
	 */
	@Test
	public void getQuantitySummaryShutdown() throws IOException, ForceAPIException {

		// ----------------------------------------------------------------------
		// test fixture
		// ----------------------------------------------------------------------

		final GetWorkplaceQuantitySummaryRequest request = new GetWorkplaceQuantitySummaryRequest("workplaceId");
		mMockWebServer.shutdown();
		mExpectedException.expect(ForceAPIException.class);
		mExpectedException.expectMessage("Unable to execute call using request: " + request);

		// ----------------------------------------------------------------------
		// test
		// ----------------------------------------------------------------------

		mWorkplaceClient.getQuantitySummary(request);
	}

	/**
	 * Tests getting devices for workplace.
	 *
	 * @throws ForceAPIException    When unable to get devices.
	 * @throws InterruptedException When unable to take the request from the server.
	 * @throws IOException          When unable to read the JSON file.
	 * @throws URISyntaxException   When unable to create a URI of the JSON file.
	 */
	@Test
	public void testGetWorkplaceDevices() throws ForceAPIException, IOException, URISyntaxException, InterruptedException {

		// ----------------------------------------------------------------------
		// test fixture
		// ----------------------------------------------------------------------
		mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getWorkplaceDevices.json")));

		final String workplaceId = "DA2360D8BC78462EAE0BCCB05A57068C";
		final int limit = 100;
		final int offset = 1;

		final GetWorkplaceDevicesRequest request = new GetWorkplaceDevicesRequest(workplaceId);
		request.setLimit(limit);
		request.setOffset(offset);

		// ----------------------------------------------------------------------
		// test
		// ----------------------------------------------------------------------
		Page<DeviceResponse> response = mWorkplaceClient.getWorkplaceDevices(request);

		final RecordedRequest recordedRequest = mMockWebServer.takeRequest();
		final String requestQuery = recordedRequest
			.getRequestUrl()
			.query();
		Assert.assertNotNull(requestQuery);
		Assert.assertTrue(requestQuery.contains("limit=" + limit));
		Assert.assertTrue(requestQuery.contains("offset=" + offset));
		Assert.assertNotNull(response);
		Assert.assertFalse(response
			.getElements()
			.isEmpty());
		Assert.assertNull(response
			.getResponse()
			.getPaginationLinks()
			.getNext());
		Assert.assertNotNull(response
			.getResponse()
			.getPaginationLinks()
			.getLast());
		Assert.assertNotNull(response
			.getResponse()
			.getPaginationLinks()
			.getFirst());
		Assert.assertNotNull(response
			.getResponse()
			.getPaginationLinks()
			.getSelf());
		Assert.assertNull(response
			.getResponse()
			.getPaginationLinks()
			.getPrev());

		Assert.assertTrue(response
			.getResponse()
			.getPagination()
			.getOffset()
			.isPresent());
		Assert.assertFalse(response
			.getResponse()
			.getPagination()
			.getFirstDate()
			.isPresent());
		Assert.assertFalse(response
			.getResponse()
			.getPagination()
			.getLastDate()
			.isPresent());
		Assert.assertTrue(response
			.getResponse()
			.getPagination()
			.getPaginationType() == Pagination.PaginationType.OFFSET);
	}

	/**
	 * Tests getting workplaces predicted malfunction scenarios.
	 *
	 * @throws ForceAPIException    When unable to get predicted malfunction scenarios.
	 * @throws InterruptedException When unable to take the request from the server.
	 * @throws IOException          When unable to read the JSON file.
	 * @throws URISyntaxException   When unable to create a URI of the JSON file.
	 */
	@Test
	public void testGetPredictedMalfunctionScenarios() throws ForceAPIException, IOException, URISyntaxException, InterruptedException {

		// ----------------------------------------------------------------------
		// test fixture
		// ----------------------------------------------------------------------
		mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getWorkplacePredictedMalfunctionScenarios.json")));

		final int limit = 100;
		final int offset = 1;

		final GetWorkplacePredictedMalfunctionScenariosRequest request = new GetWorkplacePredictedMalfunctionScenariosRequest();
		request.setLimit(limit);
		request.setOffset(offset);

		// ----------------------------------------------------------------------
		// test
		// ----------------------------------------------------------------------

		Page<EmbeddedPredictedMalfunctionScenarioResponse> response = mWorkplaceClient.getPredictedMalfunctionScenarios(request);

		final RecordedRequest recordedRequest = mMockWebServer.takeRequest();
		final String requestQuery = recordedRequest
			.getRequestUrl()
			.query();
		Assert.assertNotNull(requestQuery);
		Assert.assertTrue(requestQuery.contains("limit=" + limit));
		Assert.assertTrue(requestQuery.contains("offset=" + offset));
		Assert.assertNotNull(response);
		Assert.assertFalse(response
			.getElements()
			.isEmpty());
		Assert.assertNull(response
			.getResponse()
			.getPaginationLinks()
			.getNext());
		Assert.assertNotNull(response
			.getResponse()
			.getPaginationLinks()
			.getLast());
		Assert.assertNotNull(response
			.getResponse()
			.getPaginationLinks()
			.getFirst());
		Assert.assertNotNull(response
			.getResponse()
			.getPaginationLinks()
			.getSelf());
		Assert.assertNull(response
			.getResponse()
			.getPaginationLinks()
			.getPrev());

		Assert.assertNotNull(response
			.getElements()
			.get(0)
			.getProperties()
			.getCreationDate());
		Assert.assertNotNull(response
			.getElements()
			.get(0)
			.getProperties()
			.getId());
	}

	/**
	 * Tests getting predicted malfunction scenario.
	 *
	 * @throws ForceAPIException    When unable to get predicted malfunction scenario.
	 * @throws InterruptedException When unable to take the request from the server.
	 * @throws IOException          When unable to read the JSON file.
	 * @throws URISyntaxException   When unable to create a URI of the JSON file.
	 */
	@Test
	public void testGetPredictedMalfunctionScenario() throws ForceAPIException, IOException, URISyntaxException, InterruptedException {

		// ----------------------------------------------------------------------
		// test fixture
		// ----------------------------------------------------------------------
		mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getWorkplacePredictedMalfunctionScenario.json")));

		final int limit = 100;
		final int offset = 0;

		final GetWorkplacePredictedMalfunctionScenarioRequest request = new GetWorkplacePredictedMalfunctionScenarioRequest("scenarioId");
		request.setLimit(limit);
		request.setOffset(offset);

		// ----------------------------------------------------------------------
		// test
		// ----------------------------------------------------------------------

		WorkplacePredictedMalfunctionScenarioPage response = mWorkplaceClient.getPredictedMalfunctionScenario(request);

		final RecordedRequest recordedRequest = mMockWebServer.takeRequest();
		final String requestQuery = recordedRequest
			.getRequestUrl()
			.query();
		Assert.assertNotNull(requestQuery);
		Assert.assertTrue(requestQuery.contains("limit=" + limit));
		Assert.assertTrue(requestQuery.contains("offset=" + offset));
		Assert.assertNotNull(response);
		Assert.assertFalse(response
			.getElements()
			.isEmpty());
		Assert.assertNull(response
			.getResponse()
			.getPaginationLinks()
			.getNext());
		Assert.assertNotNull(response
			.getResponse()
			.getPaginationLinks()
			.getLast());
		Assert.assertNotNull(response
			.getResponse()
			.getPaginationLinks()
			.getFirst());
		Assert.assertNotNull(response
			.getResponse()
			.getPaginationLinks()
			.getSelf());
		Assert.assertNull(response
			.getResponse()
			.getPaginationLinks()
			.getPrev());

		Assert.assertNotNull(response
			.getResponse()
			.getProperties()
			.getEndDate());
		Assert.assertNotNull(response
			.getResponse()
			.getProperties()
			.getCreator());
	}
}