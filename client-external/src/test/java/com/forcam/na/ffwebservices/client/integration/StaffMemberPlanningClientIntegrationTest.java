////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 22.11.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.integration;

import com.forcam.na.ffwebservices.client.api.exception.ForceAPIException;
import com.forcam.na.ffwebservices.client.api.pagination.request.CollectionTimestampFilterRequest;
import com.forcam.na.ffwebservices.client.api.pagination.response.Page;
import com.forcam.na.ffwebservices.client.api.staffmember.staffmemberplanning.StaffMemberPlanningClient;
import com.forcam.na.ffwebservices.client.api.staffmember.staffmemberplanning.request.GetStaffMemberPlanningResultsRequest;
import com.forcam.na.ffwebservices.client.api.staffmember.staffmemberplanning.request.GetStaffMemberPlanningScenarioCollectionRequest;
import com.forcam.na.ffwebservices.client.api.staffmember.staffmemberplanning.request.GetStaffMemberPlanningScenarioRequest;
import com.forcam.na.ffwebservices.client.api.staffmember.staffmemberplanning.request.GetStaffMemberShiftPlanningResultRequest;
import com.forcam.na.ffwebservices.client.api.staffmember.staffmemberplanning.response.StaffMemberPlanningScenarioPage;
import com.forcam.na.ffwebservices.client.api.staffmember.staffmemberplanning.response.StaffMemberShiftPlanningResultResponse;
import com.forcam.na.ffwebservices.client.api.staffmember.staffmemberplanning.response.StaffMembersPlanningResultsPage;
import com.forcam.na.ffwebservices.model.staffmember.EmbeddedStaffMemberPlanningScenarioResponse;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Date;
import java.util.regex.Pattern;

/**
 * Integration tests for the class {@link StaffMemberPlanningClient}.
 */
public class StaffMemberPlanningClientIntegrationTest extends AbstractOpenAPIIntegrationTest {

	// ------------------------------------------------------------------------
	// constructors
	// ------------------------------------------------------------------------

	public StaffMemberPlanningClientIntegrationTest() {
		final Pattern staffMembersPlanningScenariosPattern = Pattern.compile(PREFIX_GET_PATH + "/staffMembers/planningScenarios\\?.*limit=2.*");
		mFileNames.put(staffMembersPlanningScenariosPattern, "json/getStaffMembersPlanningScenarioCollection.json");

		final Pattern staffMembersPlanningScenarioPattern = Pattern.compile(PREFIX_GET_PATH + "/staffMembers/planningScenarios/.{32}\\?.*");
		mFileNames.put(staffMembersPlanningScenarioPattern, "json/getStaffMembersPlanningScenario.json");

		final Pattern staffMembersPlanningResultsPattern = Pattern.compile(PREFIX_GET_PATH + "/staffMembers/planningResults.*");
		mFileNames.put(staffMembersPlanningResultsPattern, "json/getStaffMembersPlanningResults.json");

		final Pattern staffMemberPlanningResultsPattern = Pattern.compile(PREFIX_GET_PATH + "/staffMembers/.{32}/planningResults\\?.*limit=2.*");
		mFileNames.put(staffMemberPlanningResultsPattern, "json/getStaffMemberPlanningResults.json");

		final Pattern staffMemberShiftPlanningResultsPattern = Pattern
			.compile(PREFIX_GET_PATH + "/staffMembers/.{32}/shifts/.{32}/planningResult.*");
		mFileNames.put(staffMemberShiftPlanningResultsPattern, "json/getStaffMemberShiftPlanningResult.json");

	}
	// ------------------------------------------------------------------------
	// methods
	// ------------------------------------------------------------------------

	/**
	 * Test for the method {@link StaffMemberPlanningClient#getStaffMemberPlanningScenario(GetStaffMemberPlanningScenarioRequest)}.
	 *
	 * @throws ForceAPIException When unable to get staff members planning scenario.
	 */
	@Test
	public void testGetStaffMembersPlanningScenario() throws ForceAPIException {

		// ----------------------------------------------------------------------
		// test fixture
		// ----------------------------------------------------------------------

		final GetStaffMemberPlanningScenarioCollectionRequest collectionRequest = new GetStaffMemberPlanningScenarioCollectionRequest();
		collectionRequest.setLimit(1);
		collectionRequest.setStartDate(new Date(0));
		final Page<EmbeddedStaffMemberPlanningScenarioResponse> collectionResponse = mStaffMemberPlanningClient.getStaffMembersPlanningScenarios(
			collectionRequest);
		if (!collectionResponse
			.getElements()
			.isEmpty()) {

			final String planningScenarioId = collectionResponse
				.getElements()
				.get(0)
				.getProperties()
				.getId();

			final GetStaffMemberPlanningScenarioRequest request = new GetStaffMemberPlanningScenarioRequest(planningScenarioId);
			request.setLimit(3);

			// ----------------------------------------------------------------------
			// test
			// ----------------------------------------------------------------------

			final StaffMemberPlanningScenarioPage response = mStaffMemberPlanningClient.getStaffMemberPlanningScenario(request);

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
		}
	}

	/**
	 * Test for the method {@link StaffMemberPlanningClient#getStaffMembersPlanningScenarios(GetStaffMemberPlanningScenarioCollectionRequest)}.
	 *
	 * @throws ForceAPIException When unable to get staff members planning scenarios.
	 */
	@Test
	public void testGetStaffMembersPlanningScenarios() throws ForceAPIException {

		// ----------------------------------------------------------------------
		// test fixture
		// ----------------------------------------------------------------------

		final GetStaffMemberPlanningScenarioCollectionRequest request = new GetStaffMemberPlanningScenarioCollectionRequest();
		request.setLimit(2);
		request.setStartDate(new Date(0));

		// ----------------------------------------------------------------------
		// test
		// ----------------------------------------------------------------------

		final Page<EmbeddedStaffMemberPlanningScenarioResponse> response = mStaffMemberPlanningClient.getStaffMembersPlanningScenarios(request);

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
	}

	/**
	 * Tests the method {@link StaffMemberPlanningClient#getStaffMemberShiftPlanningResult(GetStaffMemberShiftPlanningResultRequest)}.
	 *
	 * @throws ForceAPIException When unable to get staff member scheduled working times.
	 */
	@Test
	public void testGetStaffMemberShiftPlanningResult() throws ForceAPIException {

		// ----------------------------------------------------------------------
		// test
		// ----------------------------------------------------------------------

		final String staffMemberId = this.getStaffMemberId();
		final String staffMemberShiftId = this.getStaffMemberShiftId();
		final GetStaffMemberShiftPlanningResultRequest request = new GetStaffMemberShiftPlanningResultRequest(staffMemberId, staffMemberShiftId);

		final StaffMemberShiftPlanningResultResponse staffMemberShiftPlanningResult = mStaffMemberPlanningClient.getStaffMemberShiftPlanningResult(request);

		Assert.assertNotNull(staffMemberShiftPlanningResult);
		Assert.assertNotNull(staffMemberShiftPlanningResult
			.getProperties()
			.getElements());
	}

	/**
	 * Tests the method {@link StaffMemberPlanningClient#getStaffMemberPlanningResults(GetStaffMemberPlanningResultsRequest)}.
	 *
	 * @throws ForceAPIException When unable to get the planning results for a staff member.
	 */
	@Test
	public void testGetStaffMemberPlanningResults() throws ForceAPIException {

		// ----------------------------------------------------------------------
		// test
		// ----------------------------------------------------------------------

		final String staffMemberId = this.getStaffMemberId();
		final GetStaffMemberPlanningResultsRequest request = new GetStaffMemberPlanningResultsRequest(staffMemberId);
		request.setLimit(2);
		request.setStartDate(new Date(0));

		final Page<StaffMemberShiftPlanningResultResponse> response = mStaffMemberPlanningClient.getStaffMemberPlanningResults(request);

		Assert.assertNotNull(response);
		Assert.assertNotNull(response.getPagination());
		Assert.assertNotNull(response.getElements());
	}

	/**
	 * Tests the method {@link StaffMemberPlanningClient#getStaffMembersPlanningResults(CollectionTimestampFilterRequest)}.
	 *
	 * @throws ForceAPIException When unable to got the planning results of all staff members.
	 */
	@Test
	public void testGetStaffMembersPlanningResults() throws ForceAPIException {

		// ----------------------------------------------------------------------
		// test
		// ----------------------------------------------------------------------

		final CollectionTimestampFilterRequest request = new CollectionTimestampFilterRequest();
		request.setLimit(2);
		request.setStartDate(new Date(0));

		final StaffMembersPlanningResultsPage response = mStaffMemberPlanningClient.getStaffMembersPlanningResults(request);

		Assert.assertNotNull(response);
		Assert.assertNotNull(response.getPagination());
		Assert.assertNotNull(response.getElements());
		Assert.assertNotNull(response
			.getResponse()
			.getProperties()
			.getStartDate());
	}
}