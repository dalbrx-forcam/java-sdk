////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 08.11.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.integration;

import com.forcam.na.ffwebservices.client.api.exception.ForceAPIException;
import com.forcam.na.ffwebservices.client.api.machine.request.GetMachinesRequest;
import com.forcam.na.ffwebservices.client.api.machine.MachineClient;
import com.forcam.na.ffwebservices.client.api.pagination.response.Page;
import com.forcam.na.ffwebservices.client.api.workplace.request.GetWorkplacesRequest;
import com.forcam.na.ffwebservices.model.machine.MachineResponse;
import com.forcam.na.ffwebservices.model.workplace.WorkplaceResponse;
import org.junit.*;

import java.util.regex.Pattern;

/**
 * Integration tests for the class {@link MachineClient}.
 */
public class MachineClientIntegrationTest extends AbstractOpenAPIIntegrationTest {

	// ------------------------------------------------------------------------
	// constructors
	// ------------------------------------------------------------------------

	public MachineClientIntegrationTest() {
		final Pattern machinesPattern = Pattern.compile(PREFIX_GET_PATH + "/machines\\?.*limit=3.*");
		mFileNames.put(machinesPattern, "json/getMachines.json");
	}

	// ------------------------------------------------------------------------
	// methods
	// ------------------------------------------------------------------------

	/**
	 * Test for the method {@link MachineClient#getMachines(GetMachinesRequest)}.
	 *
	 * @throws ForceAPIException When unable to get machines.
	 */
	@Test
	public void testGetMachines() throws ForceAPIException {

		// ----------------------------------------------------------------------
		// test fixture
		// ----------------------------------------------------------------------

		final GetWorkplacesRequest workplaceRequest = new GetWorkplacesRequest();
		workplaceRequest.setLimit(1);
		final Page<WorkplaceResponse> workplaceCollection = mWorkplaceClient.getWorkplaces(workplaceRequest);

		Assert.assertNotNull(workplaceCollection);
		Assert.assertFalse(workplaceCollection
			.getElements()
			.isEmpty());

		final WorkplaceResponse workplace = workplaceCollection
			.getElements()
			.get(0);
		Assert.assertNotNull(workplace.getProperties());

		final String workplaceNumber = workplace
			.getProperties()
			.getNumber();

		final GetMachinesRequest machineRequest = new GetMachinesRequest();
		machineRequest.setLimit(3);
		machineRequest.setWorkplaceNumber(workplaceNumber);
		machineRequest
			.embed()
			.description(true)
			.erpContext(true)
			.workplace(true);

		// ----------------------------------------------------------------------
		// test
		// ----------------------------------------------------------------------

		Page<MachineResponse> machineCollection = mMachineClient.getMachines(machineRequest);

		Assert.assertNotNull(machineCollection);
		Assert.assertFalse(machineCollection
			.getElements()
			.isEmpty());
		Assert.assertNotNull(machineCollection
			.getElements()
			.get(0)
			.getProperties());
		Assert.assertNotNull(machineCollection
			.getElements()
			.get(0)
			.getDescription()
			.getEmbedded());
		Assert.assertNotNull(machineCollection
			.getElements()
			.get(0)
			.getErpContext()
			.getEmbedded());
		Assert.assertNotNull(machineCollection
			.getElements()
			.get(0)
			.getWorkplace()
			.getEmbedded());
		Assert.assertEquals(workplaceNumber,
			machineCollection
				.getElements()
				.get(0)
				.getWorkplace()
				.getEmbedded()
				.getNumber());
	}
}