////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 22.11.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.staffmember;

import com.forcam.na.ffwebservices.client.api.AbstractOpenAPIMockTest;
import com.forcam.na.ffwebservices.client.api.config.GuiceTestRunner;
import com.forcam.na.ffwebservices.client.api.exception.ForceAPIException;
import com.forcam.na.ffwebservices.client.api.pagination.request.CollectionTimestampFilterRequest;
import com.forcam.na.ffwebservices.client.api.pagination.response.Page;
import com.forcam.na.ffwebservices.client.api.staffmember.staffmemberplanning.IStaffMemberPlanningClient;
import com.forcam.na.ffwebservices.client.api.staffmember.staffmemberplanning.StaffMemberPlanningClient;
import com.forcam.na.ffwebservices.client.api.staffmember.staffmemberplanning.request.GetStaffMemberPlanningResultsRequest;
import com.forcam.na.ffwebservices.client.api.staffmember.staffmemberplanning.request.GetStaffMemberPlanningScenarioCollectionRequest;
import com.forcam.na.ffwebservices.client.api.staffmember.staffmemberplanning.request.GetStaffMemberPlanningScenarioRequest;
import com.forcam.na.ffwebservices.client.api.staffmember.staffmemberplanning.request.GetStaffMemberShiftPlanningResultRequest;
import com.forcam.na.ffwebservices.client.api.staffmember.staffmemberplanning.response.StaffMemberPlanningScenarioPage;
import com.forcam.na.ffwebservices.client.api.staffmember.staffmemberplanning.response.StaffMemberShiftPlanningResultResponse;
import com.forcam.na.ffwebservices.client.api.staffmember.staffmemberplanning.response.StaffMembersPlanningResultsPage;
import com.forcam.na.ffwebservices.model.staffmember.EmbeddedStaffMemberPlanningScenarioResponse;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Tests for the class {@link StaffMemberPlanningClient}.
 */
@RunWith(GuiceTestRunner.class)
public class StaffMemberPlanningClientTest extends AbstractOpenAPIMockTest {

	// ------------------------------------------------------------------------
	// members
	// ------------------------------------------------------------------------

	/** Helper for test exceptions and messages. */
	@Rule
	public ExpectedException mExpectedException = ExpectedException.none();

	/** The staff member planning client. */
	private IStaffMemberPlanningClient mStaffMemberPlanningClient;

	// ------------------------------------------------------------------------
	// constructors
	// ------------------------------------------------------------------------

	public StaffMemberPlanningClientTest() {
		mStaffMemberPlanningClient = mBridgeAPIComponent.staffMemberPlanningClient();
	}

	// ------------------------------------------------------------------------
	// methods
	// ------------------------------------------------------------------------

	/**
	 * Test for the method {@link StaffMemberPlanningClient#getStaffMemberPlanningScenario(GetStaffMemberPlanningScenarioRequest)}.
	 *
	 * @throws ForceAPIException    When unable to get staff members planning scenario.
	 * @throws InterruptedException When unable to take the request from the server.
	 * @throws IOException          When unable to read the JSON file.
	 * @throws URISyntaxException   When unable to create a URI of the JSON file.
	 */
	@Test
	public void getStaffMembersPlanningScenario() throws ForceAPIException, InterruptedException, IOException, URISyntaxException {

		// ----------------------------------------------------------------------
		// test fixture
		// ----------------------------------------------------------------------

		mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getStaffMembersPlanningScenario.json")));
		final int limit = 3;
		final GetStaffMemberPlanningScenarioRequest request = new GetStaffMemberPlanningScenarioRequest("planningScenarioId");
		request.setLimit(limit);

		// ----------------------------------------------------------------------
		// test
		// ----------------------------------------------------------------------

		final StaffMemberPlanningScenarioPage response = mStaffMemberPlanningClient.getStaffMemberPlanningScenario(request);

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
		Assert.assertFalse(response
			.getElements()
			.isEmpty());

		response
			.getElements()
			.forEach(element -> {
				Assert.assertNotNull(element.getSkillId());
				Assert.assertNotNull(element.getCapacity());
				Assert.assertNotNull(element.getStartDate());
				Assert.assertNotNull(element.getWorkplaceId());
				Assert.assertNotNull(element.getStaffMemberId());
				Assert.assertNotNull(element.getWorkplaceShiftId());
				Assert.assertNotNull(element.getStaffMemberShiftId());
			});
	}

	/**
	 * Test for the method {@link StaffMemberPlanningClient#getStaffMembersPlanningScenarios(GetStaffMemberPlanningScenarioCollectionRequest)}.
	 *
	 * @throws ForceAPIException    When unable to get staff members planning scenarios.
	 * @throws InterruptedException When unable to take the request from the server.
	 * @throws IOException          When unable to read the JSON file.
	 * @throws URISyntaxException   When unable to create a URI of the JSON file.
	 */
	@Test
	public void getStaffMembersPlanningScenarios() throws ForceAPIException, InterruptedException, IOException, URISyntaxException {

		// ----------------------------------------------------------------------
		// test fixture
		// ----------------------------------------------------------------------

		mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getStaffMembersPlanningScenarioCollection.json")));
		final int limit = 2;
		final GetStaffMemberPlanningScenarioCollectionRequest request = new GetStaffMemberPlanningScenarioCollectionRequest();
		request.setLimit(limit);

		// ----------------------------------------------------------------------
		// test
		// ----------------------------------------------------------------------

		final Page<EmbeddedStaffMemberPlanningScenarioResponse> response = mStaffMemberPlanningClient.getStaffMembersPlanningScenarios(request);

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
		Assert.assertFalse(response
			.getElements()
			.isEmpty());

		response
			.getElements()
			.forEach(element -> {
				Assert.assertNotNull(element.getProperties());
				Assert.assertNotNull(element
					.getProperties()
					.getId());
				Assert.assertNotNull(element
					.getProperties()
					.getCreationDate());
				Assert.assertNotNull(element
					.getProperties()
					.getCreator());
				Assert.assertNotNull(element
					.getProperties()
					.getStartDate());
				Assert.assertNotNull(element
					.getProperties()
					.getNumberOfPlannedStaffMembers());
			});
	}

	/**
	 * Test for the method {@link StaffMemberPlanningClient#getStaffMemberShiftPlanningResult(GetStaffMemberShiftPlanningResultRequest)}.
	 *
	 * @throws ForceAPIException    When unable to get staff member shift planning results.
	 * @throws InterruptedException When unable to take the request from the server.
	 * @throws IOException          When unable to read the JSON file.
	 * @throws URISyntaxException   When unable to create a URI of the JSON file.
	 */
	@Test
	public void getStaffMemberShiftPlanningResult() throws IOException, URISyntaxException, ForceAPIException, InterruptedException {

		// ----------------------------------------------------------------------
		// test fixture
		// ----------------------------------------------------------------------

		mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getStaffMemberShiftPlanningResult.json")));
		final GetStaffMemberShiftPlanningResultRequest request = new GetStaffMemberShiftPlanningResultRequest("staffMemberId", "staffMemberShiftId");

		// ----------------------------------------------------------------------
		// test
		// ----------------------------------------------------------------------

		final StaffMemberShiftPlanningResultResponse response = mStaffMemberPlanningClient.getStaffMemberShiftPlanningResult(request);

		final RecordedRequest recordedRequest = mMockWebServer.takeRequest();
		final String requestPath = recordedRequest.getPath();
		Assert.assertNotNull(requestPath);
		Assert.assertTrue(requestPath.contains("/staffMemberId/"));
		Assert.assertTrue(requestPath.contains("/staffMemberShiftId/"));

		Assert.assertNotNull(response);
		Assert.assertFalse(response
			.getProperties()
			.getElements()
			.isEmpty());
		Assert.assertNotNull(response
			.getProperties()
			.getElements()
			.get(0)
			.getStaffMemberId());
		Assert.assertNotNull(response
			.getProperties()
			.getElements()
			.get(0)
			.getWorkplaceId());
		Assert.assertNotNull(response
			.getProperties()
			.getElements()
			.get(0)
			.getStartDate());
	}

	/**
	 * Test for the method {@link StaffMemberPlanningClient#getStaffMemberPlanningResults(GetStaffMemberPlanningResultsRequest)}.
	 *
	 * @throws ForceAPIException    When unable to get staff member planning results.
	 * @throws InterruptedException When unable to take the request from the server.
	 * @throws IOException          When unable to read the JSON file.
	 * @throws URISyntaxException   When unable to create a URI of the JSON file.
	 */
	@Test
	public void getStaffMemberPlanningResults() throws IOException, URISyntaxException, ForceAPIException, InterruptedException {

		// ----------------------------------------------------------------------
		// test fixture
		// ----------------------------------------------------------------------

		mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getStaffMemberPlanningResults.json")));
		final GetStaffMemberPlanningResultsRequest request = new GetStaffMemberPlanningResultsRequest("staffMemberId");
		request.setLimit(2);

		// ----------------------------------------------------------------------
		// test
		// ----------------------------------------------------------------------

		final Page<StaffMemberShiftPlanningResultResponse> response = mStaffMemberPlanningClient.getStaffMemberPlanningResults(request);

		final RecordedRequest recordedRequest = mMockWebServer.takeRequest();
		final String requestQuery = recordedRequest
			.getRequestUrl()
			.query();
		Assert.assertNotNull(requestQuery);
		Assert.assertTrue(requestQuery.contains("limit=2"));

		Assert.assertNotNull(response);
		Assert.assertFalse(response
			.getElements()
			.isEmpty());
		Assert.assertNotNull(response
			.getElements()
			.get(0)
			.getProperties()
			.getElements()
			.get(0)
			.getStaffMemberId());
		Assert.assertNotNull(response
			.getElements()
			.get(0)
			.getProperties()
			.getElements()
			.get(0)
			.getWorkplaceId());
		Assert.assertNotNull(response
			.getElements()
			.get(0)
			.getProperties()
			.getElements()
			.get(0)
			.getStartDate());
	}

	/**
	 * Test for the method {@link StaffMemberPlanningClient#getStaffMembersPlanningResults(CollectionTimestampFilterRequest)}.
	 *
	 * @throws ForceAPIException    When unable to get staff members planning results.
	 * @throws InterruptedException When unable to take the request from the server.
	 * @throws IOException          When unable to read the JSON file.
	 * @throws URISyntaxException   When unable to create a URI of the JSON file.
	 */
	@Test
	public void getStaffMembersPlanningResults() throws IOException, URISyntaxException, ForceAPIException, InterruptedException {

		// ----------------------------------------------------------------------
		// test fixture
		// ----------------------------------------------------------------------

		mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getStaffMembersPlanningResults.json")));
		final CollectionTimestampFilterRequest request = new CollectionTimestampFilterRequest();
		request.setLimit(2);

		// ----------------------------------------------------------------------
		// test
		// ----------------------------------------------------------------------

		final StaffMembersPlanningResultsPage response = mStaffMemberPlanningClient.getStaffMembersPlanningResults(request);

		final RecordedRequest recordedRequest = mMockWebServer.takeRequest();
		final String requestQuery = recordedRequest
			.getRequestUrl()
			.query();
		Assert.assertNotNull(requestQuery);
		Assert.assertTrue(requestQuery.contains("limit=2"));

		Assert.assertNotNull(response);
		Assert.assertFalse(response
			.getElements()
			.isEmpty());

		response
			.getElements()
			.forEach(element -> {
				Assert.assertNotNull(element.getStaffMemberId());
				Assert.assertNotNull(element.getWorkplaceId());
				Assert.assertNotNull(element.getStartDate());
			});
	}
}