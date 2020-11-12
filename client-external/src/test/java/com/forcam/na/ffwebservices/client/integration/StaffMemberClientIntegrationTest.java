////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 19.12.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.integration;

import com.forcam.na.ffwebservices.client.api.exception.ForceAPIException;
import com.forcam.na.ffwebservices.client.api.pagination.request.CollectionTimeFilterRequest;
import com.forcam.na.ffwebservices.client.api.pagination.response.Page;
import com.forcam.na.ffwebservices.client.api.staffmember.StaffMemberClient;
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
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Date;
import java.util.regex.Pattern;

/**
 * Integration tests for the class {@link StaffMemberClient}.
 */
public class StaffMemberClientIntegrationTest extends AbstractOpenAPIIntegrationTest {

	// ------------------------------------------------------------------------
	// constructors
	// ------------------------------------------------------------------------

	public StaffMemberClientIntegrationTest() {
		final Pattern staffMembersPattern = Pattern.compile(PREFIX_GET_PATH + "/staffMembers\\?.*limit=3.*");
		mFileNames.put(staffMembersPattern, "json/getStaffMembers.json");

		final Pattern staffMemberPattern = Pattern.compile(PREFIX_GET_PATH + "/staffMembers/.{32}\\?.*");
		mFileNames.put(staffMemberPattern, "json/getStaffMember.json");

		final Pattern staffMemberAbsenceTimesPattern = Pattern.compile(PREFIX_GET_PATH + "/staffMembers/.{32}/absenceTimes\\?.*limit=3.*");
		mFileNames.put(staffMemberAbsenceTimesPattern, "json/getStaffMemberAbsenceTimes.json");

		final Pattern staffMembersShiftsPattern = Pattern.compile(PREFIX_GET_PATH + "/staffMembers/shifts\\?.*limit=3.*");
		mFileNames.put(staffMembersShiftsPattern, "json/getStaffMembersShifts.json");

		final Pattern staffMembersShiftPattern = Pattern.compile(PREFIX_GET_PATH + "/staffMembers/shifts/.{32}\\?.*");
		mFileNames.put(staffMembersShiftPattern, "json/getStaffMemberShift.json");

		final Pattern staffMembersScheduledWorkingTimesPattern = Pattern
			.compile(PREFIX_GET_PATH + "/staffMembers/scheduledWorkingTimes\\?.*limit=3.*");
		mFileNames.put(staffMembersScheduledWorkingTimesPattern, "json/getStaffMembersScheduledWorkingTimesCollection.json");

	}

	// ------------------------------------------------------------------------
	// methods
	// ------------------------------------------------------------------------

	/**
	 * Test for the method {@link StaffMemberClient#getStaffMembers(GetStaffMembersRequest)}.
	 *
	 * @throws ForceAPIException When unable to get staff members.
	 */
	@Test
	public void testGetStaffMembers() throws ForceAPIException {

		// ----------------------------------------------------------------------
		// test fixture
		// ----------------------------------------------------------------------

		final GetStaffMembersRequest request = new GetStaffMembersRequest();
		request.setLimit(3);
		request
			.embed()
			.erpContext(true);

		// ----------------------------------------------------------------------
		// test
		// ----------------------------------------------------------------------

		final Page<StaffMemberResponse> staffMemberCollection = mStaffMemberClient.getStaffMembers(request);

		Assert.assertNotNull(staffMemberCollection);
		Assert.assertFalse(staffMemberCollection
			.getElements()
			.isEmpty());
	}

	/**
	 * Test for the method {@link StaffMemberClient#getStaffMember(GetStaffMemberRequest)}.
	 *
	 * @throws ForceAPIException When unable to get staff member.
	 */
	@Test
	public void testGetStaffMember() throws ForceAPIException {

		// ----------------------------------------------------------------------
		// test fixture
		// ----------------------------------------------------------------------

		final String staffMemberId = this.getStaffMemberId();
		final GetStaffMemberRequest staffMemberRequest = new GetStaffMemberRequest(staffMemberId);
		staffMemberRequest
			.embed()
			.erpContext(true);

		// ----------------------------------------------------------------------
		// test
		// ----------------------------------------------------------------------

		final StaffMemberResponse staffMemberModel = mStaffMemberClient.getStaffMember(staffMemberRequest);

		Assert.assertNotNull(staffMemberModel);
		Assert.assertNotNull(staffMemberModel.getProperties());
	}

	/**
	 * Tests the method {@link StaffMemberClient#getStaffMemberAbsenceTimes(GetStaffMemberAbsencesRequest)}.
	 *
	 * @throws ForceAPIException When unable to get staff member.
	 */
	@Test
	public void testGetStaffMemberAbsenceTimes() throws ForceAPIException {

		// ----------------------------------------------------------------------
		// test fixture
		// ----------------------------------------------------------------------

		final String staffMemberId = this.getStaffMemberId();
		final GetStaffMemberAbsencesRequest staffMemberAbsencesRequest = new GetStaffMemberAbsencesRequest(staffMemberId);
		staffMemberAbsencesRequest.setLimit(3);

		// ----------------------------------------------------------------------
		// test
		// ----------------------------------------------------------------------

		final StaffMemberAbsenceCollectionPage staffMemberAbsenceTimes = mStaffMemberClient.getStaffMemberAbsenceTimes(staffMemberAbsencesRequest);

		Assert.assertNotNull(staffMemberAbsenceTimes);
		Assert.assertNotNull(staffMemberAbsenceTimes
			.getResponse()
			.getProperties()
			.getElements());
	}

	/**
	 * Tests the method {@link StaffMemberClient#getStaffMemberRecordedLoginPeriods(GetStaffMemberRecordedActivitiesRequest)}.
	 *
	 * @throws ForceAPIException When unable to get staff member recorded activities.
	 */
	@Test
	public void testGetStaffMemberRecordedActivities() throws ForceAPIException {

		// ----------------------------------------------------------------------
		// test fixture
		// ----------------------------------------------------------------------

		final String staffMemberId = this.getStaffMemberId();

		final GetStaffMemberRecordedActivitiesRequest staffMemberRecordedActivitiesRequest = new GetStaffMemberRecordedActivitiesRequest(staffMemberId);
		staffMemberRecordedActivitiesRequest.setLimit(3);

		// ----------------------------------------------------------------------
		// test
		// ----------------------------------------------------------------------

		final StaffMemberRecordedLoginPeriodCollectionPage staffMemberAbsenceTimes = mStaffMemberClient.getStaffMemberRecordedLoginPeriods(
			staffMemberRecordedActivitiesRequest);

		Assert.assertNotNull(staffMemberAbsenceTimes);
		Assert.assertNotNull(staffMemberAbsenceTimes
			.getResponse()
			.getProperties()
			.getElements());
	}

	/**
	 * Tests the method {@link StaffMemberClient#getStaffMemberShift(GetStaffMemberShiftRequest)}.
	 *
	 * @throws ForceAPIException When unable to get staff member shift.
	 */
	@Test
	public void testGetStaffMemberShift() throws ForceAPIException {

		// ----------------------------------------------------------------------
		// test fixture
		// ----------------------------------------------------------------------

		final String staffMemberShiftId = this.getStaffMemberShiftId();

		final GetStaffMemberShiftRequest request = new GetStaffMemberShiftRequest(staffMemberShiftId);
		request
			.embed()
			.staffMember(true)
			.shiftType(true);

		// ----------------------------------------------------------------------
		// test
		// ----------------------------------------------------------------------

		final StaffMemberShiftResponse staffMemberShift = mStaffMemberClient.getStaffMemberShift(request);

		Assert.assertNotNull(staffMemberShift);
		Assert.assertEquals(staffMemberShiftId,
			staffMemberShift
				.getProperties()
				.getId());
		Assert.assertNotNull(staffMemberShift
			.getProperties()
			.getShift());
		Assert.assertNotNull(staffMemberShift
			.getStaffMember()
			.getEmbedded()
			.getId());
		Assert.assertNotNull(staffMemberShift
			.getShiftType()
			.getEmbedded()
			.getId());
	}

	/**
	 * Tests the method {@link StaffMemberClient#getStaffMembersShifts(GetStaffMembersShiftsRequest)}.
	 *
	 * @throws ForceAPIException When unable to get staff members shifts.
	 */
	@Test
	public void testGetStaffMembersShifts() throws ForceAPIException {

		// ----------------------------------------------------------------------
		// test
		// ----------------------------------------------------------------------

		final GetStaffMembersShiftsRequest shiftsRequest = new GetStaffMembersShiftsRequest();
		shiftsRequest.setLimit(3);
		shiftsRequest.setStartDate(new Date(0));

		final Page<StaffMemberShiftResponse> responsePage = mStaffMemberClient.getStaffMembersShifts(shiftsRequest);

		Assert.assertNotNull(responsePage);
		Assert.assertNotNull(responsePage.getElements());
		Assert.assertNotNull(responsePage
			.getResponse()
			.getPagination());
	}

	/**
	 * Tests the method {@link StaffMemberClient#getStaffMembersScheduledWorkingTimes(CollectionTimeFilterRequest)}.
	 *
	 * @throws ForceAPIException When unable to get staff members scheduled working times.
	 */
	@Test
	public void testGetStaffMembersScheduledWorkingTimesCollection() throws ForceAPIException {

		// ----------------------------------------------------------------------
		// test
		// ----------------------------------------------------------------------

		final CollectionTimeFilterRequest request = new CollectionTimeFilterRequest();
		request.setStartDate(new Date(0));
		request.setLimit(3);

		final StaffMembersScheduledWorkingTimesCollectionPage responsePage = mStaffMemberClient.getStaffMembersScheduledWorkingTimes(request);

		Assert.assertNotNull(responsePage);
		Assert.assertNotNull(responsePage.getElements());
		Assert.assertNotNull(responsePage
			.getResponse()
			.getPagination());
	}

	/**
	 * Tests the method {@link StaffMemberClient#getStaffMemberScheduledWorkingTimes(GetStaffMemberScheduledWorkingTimesRequest)}.
	 *
	 * @throws ForceAPIException When unable to get staff member scheduled working times.
	 */
	@Test
	public void testGetStaffMemberScheduledWorkingTimes() throws ForceAPIException {

		// ----------------------------------------------------------------------
		// test
		// ----------------------------------------------------------------------

		final String staffMemberId = this.getStaffMemberId();
		final GetStaffMemberScheduledWorkingTimesRequest request = new GetStaffMemberScheduledWorkingTimesRequest(staffMemberId);
		request.setLimit(3);

		final StaffMemberScheduledWorkingTimesPage responsePage = mStaffMemberClient.getStaffMemberScheduledWorkingTimes(request);

		Assert.assertNotNull(responsePage);
		Assert.assertNotNull(responsePage.getElements());
		Assert.assertNotNull(responsePage
			.getResponse()
			.getPagination());
	}
}