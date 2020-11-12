////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 10.10.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.integration;

import com.forcam.na.ffwebservices.client.api.exception.ForceAPIException;
import com.forcam.na.ffwebservices.client.api.machinestatedetail.MachineStateDetailClient;
import com.forcam.na.ffwebservices.client.api.machinestatedetail.request.GetMachineStateDetailsRequest;
import com.forcam.na.ffwebservices.client.api.pagination.response.Page;
import com.forcam.na.ffwebservices.model.machinestatedetail.MachineStateDetailResponse;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.regex.Pattern;

/**
 * Integration tests for the class {@link MachineStateDetailClient}.
 */
public class MachineStateDetailClientIntegrationTest extends AbstractOpenAPIIntegrationTest {

	// ------------------------------------------------------------------------
	// constructors
	// ------------------------------------------------------------------------

	public MachineStateDetailClientIntegrationTest() {
		final Pattern machineStateDetailsPattern = Pattern.compile(PREFIX_GET_PATH + "/masterData/machineStateDetails\\?.*limit=3.*");
		mFileNames.put(machineStateDetailsPattern, "json/getMachineStateDetails.json");
	}

	// ------------------------------------------------------------------------
	// methods
	// ------------------------------------------------------------------------

	/**
	 * Test for the method {@link MachineStateDetailClient#getMachineStateDetails(GetMachineStateDetailsRequest)}.
	 *
	 * @throws ForceAPIException When unable to get machine state details.
	 */
	@Test
	public void testGetMachineStateDetails() throws ForceAPIException {

		// ----------------------------------------------------------------------
		// test fixture
		// ----------------------------------------------------------------------

		final GetMachineStateDetailsRequest request = new GetMachineStateDetailsRequest();
		request.setLimit(3);
		request
			.embed()
			.description(true)
			.shortDescription(true);

		// ----------------------------------------------------------------------
		// test
		// ----------------------------------------------------------------------

		Page<MachineStateDetailResponse> machineStateDetailCollection = mMachineStateDetailClient.getMachineStateDetails(request);

		Assert.assertNotNull(machineStateDetailCollection);
		Assert.assertFalse(machineStateDetailCollection
			.getElements()
			.isEmpty());
		Assert.assertNotNull(machineStateDetailCollection
			.getElements()
			.get(0)
			.getProperties());
		Assert.assertNotNull(machineStateDetailCollection
			.getElements()
			.get(0)
			.getDescription()
			.getEmbedded());
		Assert.assertNotNull(machineStateDetailCollection
			.getElements()
			.get(0)
			.getShortDescription()
			.getEmbedded());
	}
}