////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 19.12.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.staffmember;

import com.forcam.na.ffwebservices.client.api.AbstractOpenAPIMockTest;
import com.forcam.na.ffwebservices.client.api.config.GuiceTestRunner;
import com.forcam.na.ffwebservices.client.api.exception.ForceAPIException;
import com.forcam.na.ffwebservices.client.api.pagination.request.CollectionTimeFilterRequest;
import com.forcam.na.ffwebservices.client.api.pagination.response.Page;
import com.forcam.na.ffwebservices.client.api.staffmember.request.GetStaffMemberAbsencesRequest;
import com.forcam.na.ffwebservices.client.api.staffmember.request.GetStaffMemberRecordedActivitiesRequest;
import com.forcam.na.ffwebservices.client.api.staffmember.request.GetStaffMemberRequest;
import com.forcam.na.ffwebservices.client.api.staffmember.request.GetStaffMemberScheduledWorkingTimesRequest;
import com.forcam.na.ffwebservices.client.api.staffmember.request.GetStaffMemberShiftRequest;
import com.forcam.na.ffwebservices.client.api.staffmember.request.GetStaffMembersRequest;
import com.forcam.na.ffwebservices.client.api.staffmember.request.GetStaffMembersShiftsRequest;
import com.forcam.na.ffwebservices.client.api.staffmember.response.StaffMemberAbsenceCollectionPage;
import com.forcam.na.ffwebservices.client.api.staffmember.response.StaffMemberRecordedLoginPeriodCollectionPage;
import com.forcam.na.ffwebservices.client.api.staffmember.response.StaffMemberScheduledWorkingTimesPage;
import com.forcam.na.ffwebservices.client.api.staffmember.response.StaffMembersScheduledWorkingTimesCollectionPage;
import com.forcam.na.ffwebservices.model.shift.StaffMemberShiftResponse;
import com.forcam.na.ffwebservices.model.staffmember.StaffMemberResponse;
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
 * Tests for the class {@link StaffMemberClient}.
 */
@RunWith(GuiceTestRunner.class)
public class StaffMemberClientTest extends AbstractOpenAPIMockTest {

	// ------------------------------------------------------------------------
	// members
	// ------------------------------------------------------------------------

	/** Helper for test exceptions and messages. */
	@Rule
	public ExpectedException mExpectedException = ExpectedException.none();

	/** The staff member client. */
	private IStaffMemberClient mStaffMemberClient;

	// ------------------------------------------------------------------------
	// constructor
	// ------------------------------------------------------------------------

	public StaffMemberClientTest() {
		mStaffMemberClient = mBridgeAPIComponent.staffMemberClient();
	}

	// ------------------------------------------------------------------------
	// methods
	// ------------------------------------------------------------------------

	/**
	 * Test for the method {@link StaffMemberClient#getStaffMembers(GetStaffMembersRequest)}.
	 *
	 * @throws ForceAPIException    When unable to get staff members.
	 * @throws InterruptedException When unable to take the request from the server.
	 * @throws IOException          When unable to read the JSON file.
	 * @throws URISyntaxException   When unable to create a URI of the JSON file.
	 */
	@Test
	public void getStaffMembers() throws ForceAPIException, InterruptedException, IOException, URISyntaxException {

		// ----------------------------------------------------------------------
		// test fixture
		// ----------------------------------------------------------------------

		mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getStaffMembers.json")));
		final int limit = 3;
		final int offset = 0;
		final GetStaffMembersRequest request = new GetStaffMembersRequest();
		request
			.setLimit(limit)
			.setOffset(offset);
		request
			.embed()
			.erpContext(true);

		// ----------------------------------------------------------------------
		// test
		// ----------------------------------------------------------------------

		final Page<StaffMemberResponse> response = mStaffMemberClient.getStaffMembers(request);

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
	 * Test for the method {@link StaffMemberClient#getStaffMember(GetStaffMemberRequest)}.
	 *
	 * @throws ForceAPIException    When unable to get staff member.
	 * @throws InterruptedException When unable to take the request from the server.
	 * @throws IOException          When unable to read the JSON file.
	 * @throws URISyntaxException   When unable to create a URI of the JSON file.
	 */
	@Test
	public void getStaffMember() throws ForceAPIException, InterruptedException, IOException, URISyntaxException {

		// ----------------------------------------------------------------------
		// test fixture
		// ----------------------------------------------------------------------

		mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getStaffMember.json")));
		final GetStaffMemberRequest request = new GetStaffMemberRequest("TESTID");
		request
			.embed()
			.assignedWorkplaces(true)
			.erpContext(true);

		// ----------------------------------------------------------------------
		// test
		// ----------------------------------------------------------------------

		final StaffMemberResponse response = mStaffMemberClient.getStaffMember(request);

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
	 * Tests getting staff members while server is down.
	 *
	 * @throws IOException       When unable to shutdown the server.
	 * @throws ForceAPIException When unable to get staff members.
	 */
	@Test
	public void getStaffMembersShutdown() throws IOException, ForceAPIException {

		// ----------------------------------------------------------------------
		// test fixture
		// ----------------------------------------------------------------------

		final GetStaffMembersRequest request = new GetStaffMembersRequest();
		mMockWebServer.shutdown();
		mExpectedException.expect(ForceAPIException.class);
		mExpectedException.expectMessage("Unable to execute call using request: " + request);

		// ----------------------------------------------------------------------
		// test
		// ----------------------------------------------------------------------

		mStaffMemberClient.getStaffMembers(request);
	}

	/**
	 * Tests getting staff member while server is down.
	 *
	 * @throws IOException       When unable to shutdown the server.
	 * @throws ForceAPIException When unable to get staff member.
	 */
	@Test
	public void getStaffMemberShutdown() throws IOException, ForceAPIException {

		// ----------------------------------------------------------------------
		// test fixture
		// ----------------------------------------------------------------------

		final GetStaffMemberRequest request = new GetStaffMemberRequest("staffMemberId");
		mMockWebServer.shutdown();
		mExpectedException.expect(ForceAPIException.class);
		mExpectedException.expectMessage("Unable to execute call using request: " + request);

		// ----------------------------------------------------------------------
		// test
		// ----------------------------------------------------------------------

		mStaffMemberClient.getStaffMember(request);
	}

	/**
	 * Test for the method {@link StaffMemberClient#getStaffMemberAbsenceTimes(GetStaffMemberAbsencesRequest)}.
	 *
	 * @throws ForceAPIException    When unable to get person absence times.
	 * @throws InterruptedException When unable to take the request from the server.
	 * @throws IOException          When unable to read the JSON file.
	 * @throws URISyntaxException   When unable to create a URI of the JSON file.
	 */
	@Test
	public void getStaffMemberAbsenceTimes() throws IOException, URISyntaxException, ForceAPIException, InterruptedException {

		// ----------------------------------------------------------------------
		// test fixture
		// ----------------------------------------------------------------------

		mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getStaffMemberAbsenceTimes.json")));
		final int limit = 3;
		final GetStaffMemberAbsencesRequest request = new GetStaffMemberAbsencesRequest("testPersonId");
		request.setLimit(limit);

		// ----------------------------------------------------------------------
		// test
		// ----------------------------------------------------------------------

		final StaffMemberAbsenceCollectionPage page = mStaffMemberClient.getStaffMemberAbsenceTimes(request);

		final RecordedRequest recordedRequest = mMockWebServer.takeRequest();
		final String requestQuery = recordedRequest
			.getRequestUrl()
			.query();
		Assert.assertNotNull(requestQuery);
		Assert.assertTrue(requestQuery.contains("limit=" + limit));

		Assert.assertNotNull(page);
		Assert.assertNotNull(page
			.getResponse()
			.getPaginationLinks()
			.getSelf());
		Assert.assertNotNull(page
			.getResponse()
			.getProperties()
			.getElements());
	}

	/**
	 * Test for the method {@link StaffMemberClient#getStaffMemberRecordedLoginPeriods(GetStaffMemberRecordedActivitiesRequest)}.
	 *
	 * @throws ForceAPIException    When unable to get staff member recorded activities.
	 * @throws InterruptedException When unable to take the request from the server.
	 * @throws IOException          When unable to read the JSON file.
	 * @throws URISyntaxException   When unable to create a URI of the JSON file.
	 */
	@Test
	public void getStaffMemberRecordedActivities() throws IOException, URISyntaxException, ForceAPIException, InterruptedException {

		// ----------------------------------------------------------------------
		// test fixture
		// ----------------------------------------------------------------------

		mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getStaffMemberRecordedActivities.json")));
		final int limit = 3;
		final GetStaffMemberRecordedActivitiesRequest request = new GetStaffMemberRecordedActivitiesRequest("testPersonId");
		request.setLimit(limit);

		// ----------------------------------------------------------------------
		// test
		// ----------------------------------------------------------------------

		final StaffMemberRecordedLoginPeriodCollectionPage page = mStaffMemberClient.getStaffMemberRecordedLoginPeriods(request);

		final RecordedRequest recordedRequest = mMockWebServer.takeRequest();
		final String requestQuery = recordedRequest
			.getRequestUrl()
			.query();
		Assert.assertNotNull(requestQuery);
		Assert.assertTrue(requestQuery.contains("limit=" + limit));

		Assert.assertNotNull(page);
		Assert.assertNotNull(page
			.getResponse()
			.getPaginationLinks()
			.getSelf());
		Assert.assertEquals(3,
			page
				.getResponse()
				.getProperties()
				.getElements()
				.size());
		page
			.getResponse()
			.getProperties()
			.getElements()
			.forEach(element -> {
				Assert.assertNotNull(element.getOperationId());
				Assert.assertNotNull(element.getTimePeriod());
				Assert.assertNotNull(element.getWorkplaceId());
			});
	}

	/**
	 * Test for the method {@link StaffMemberClient#getStaffMemberShift(GetStaffMemberShiftRequest)}.
	 *
	 * @throws ForceAPIException    When unable to get staff member shift.
	 * @throws InterruptedException When unable to take the request from the server.
	 * @throws IOException          When unable to read the JSON file.
	 * @throws URISyntaxException   When unable to create a URI of the JSON file.
	 */
	@Test
	public void getStaffMemberShift() throws IOException, URISyntaxException, ForceAPIException, InterruptedException {

		// ----------------------------------------------------------------------
		// test fixture
		// ----------------------------------------------------------------------

		mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getStaffMemberShift.json")));
		final GetStaffMemberShiftRequest request = new GetStaffMemberShiftRequest("shiftId");
		request
			.embed()
			.shiftType(true)
			.staffMember(true);

		// ----------------------------------------------------------------------
		// test
		// ----------------------------------------------------------------------

		final StaffMemberShiftResponse response = mStaffMemberClient.getStaffMemberShift(request);

		final RecordedRequest recordedRequest = mMockWebServer.takeRequest();
		final String requestQuery = recordedRequest
			.getRequestUrl()
			.toString();
		Assert.assertNotNull(requestQuery);
		Assert.assertTrue(requestQuery.contains("shiftId"));

		Assert.assertNotNull(response);
		Assert.assertNotNull(response
			.getShiftType()
			.getEmbedded());
		Assert.assertNotNull(response
			.getStaffMember()
			.getEmbedded());
		Assert.assertNotNull(response
			.getProperties()
			.getId());
		Assert.assertNotNull(response
			.getProperties()
			.getShift());
	}

	/**
	 * Test for the method {@link StaffMemberClient#getStaffMembersShifts(GetStaffMembersShiftsRequest)}.
	 *
	 * @throws ForceAPIException    When unable to get staff members shifts.
	 * @throws InterruptedException When unable to take the request from the server.
	 * @throws IOException          When unable to read the JSON file.
	 * @throws URISyntaxException   When unable to create a URI of the JSON file.
	 */
	@Test
	public void getStaffMembersShifts() throws IOException, URISyntaxException, ForceAPIException, InterruptedException {

		// ----------------------------------------------------------------------
		// test fixture
		// ----------------------------------------------------------------------

		mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getStaffMembersShifts.json")));
		final GetStaffMembersShiftsRequest request = new GetStaffMembersShiftsRequest();
		request.setLimit(3);

		// ----------------------------------------------------------------------
		// test
		// ----------------------------------------------------------------------

		final Page<StaffMemberShiftResponse> response = mStaffMemberClient.getStaffMembersShifts(request);

		final RecordedRequest recordedRequest = mMockWebServer.takeRequest();
		final String requestQuery = recordedRequest
			.getRequestUrl()
			.query();
		Assert.assertNotNull(requestQuery);
		Assert.assertTrue(requestQuery.contains("limit=3"));

		Assert.assertNotNull(response);
		Assert.assertNotNull(response
			.getResponse()
			.getPagination());
		Assert.assertNotNull(response
			.getResponse()
			.getPagination()
			.getFirstDate());
		Assert.assertNotNull(response
			.getElements()
			.get(0)
			.getProperties()
			.getId());
		Assert.assertNotNull(response
			.getElements()
			.get(0)
			.getProperties()
			.getShift());
	}

	/**
	 * Test for the method {@link StaffMemberClient#getStaffMemberScheduledWorkingTimes(GetStaffMemberScheduledWorkingTimesRequest)}.
	 *
	 * @throws ForceAPIException    When unable to get staff member scheduled working times.
	 * @throws InterruptedException When unable to take the request from the server.
	 * @throws IOException          When unable to read the JSON file.
	 * @throws URISyntaxException   When unable to create a URI of the JSON file.
	 */
	@Test
	public void getStaffMemberScheduledWorkingTimes() throws IOException, URISyntaxException, ForceAPIException, InterruptedException {

		// ----------------------------------------------------------------------
		// test fixture
		// ----------------------------------------------------------------------

		mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getStaffMemberScheduledWorkingTimes.json")));
		final GetStaffMemberScheduledWorkingTimesRequest request = new GetStaffMemberScheduledWorkingTimesRequest("staffMemberId");
		request.setLimit(3);

		// ----------------------------------------------------------------------
		// test
		// ----------------------------------------------------------------------

		final StaffMemberScheduledWorkingTimesPage response = mStaffMemberClient.getStaffMemberScheduledWorkingTimes(request);

		final RecordedRequest recordedRequest = mMockWebServer.takeRequest();
		final String requestQuery = recordedRequest
			.getRequestUrl()
			.query();
		Assert.assertNotNull(requestQuery);
		Assert.assertTrue(requestQuery.contains("limit=3"));

		Assert.assertNotNull(response);
		Assert.assertNotNull(response
			.getResponse()
			.getPagination());
		Assert.assertNotNull(response
			.getResponse()
			.getProperties()
			.getElements()
			.get(0)
			.getStartDate());
		Assert.assertNotNull(response
			.getResponse()
			.getProperties()
			.getElements()
			.get(0)
			.getEndDate());
	}

	/**
	 * Test for the method {@link StaffMemberClient#getStaffMembersScheduledWorkingTimes(CollectionTimeFilterRequest)}.
	 *
	 * @throws ForceAPIException    When unable to get staff members scheduled working times.
	 * @throws InterruptedException When unable to take the request from the server.
	 * @throws IOException          When unable to read the JSON file.
	 * @throws URISyntaxException   When unable to create a URI of the JSON file.
	 */
	@Test
	public void getStaffMembersScheduledWorkingTimesCollection() throws IOException, URISyntaxException, ForceAPIException, InterruptedException {

		// ----------------------------------------------------------------------
		// test fixture
		// ----------------------------------------------------------------------

		mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getStaffMembersScheduledWorkingTimesCollection.json")));
		final CollectionTimeFilterRequest request = new CollectionTimeFilterRequest();
		request.setLimit(2);

		// ----------------------------------------------------------------------
		// test
		// ----------------------------------------------------------------------

		final StaffMembersScheduledWorkingTimesCollectionPage response = mStaffMemberClient.getStaffMembersScheduledWorkingTimes(request);

		final RecordedRequest recordedRequest = mMockWebServer.takeRequest();
		final String requestQuery = recordedRequest
			.getRequestUrl()
			.query();
		Assert.assertNotNull(requestQuery);
		Assert.assertTrue(requestQuery.contains("limit=2"));

		Assert.assertNotNull(response);
		Assert.assertNotNull(response
			.getResponse()
			.getPagination());
		Assert.assertNotNull(response
			.getResponse()
			.getElements()
			.get(0)
			.getStaffMemberId());
	}
}