////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 27.09.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.integration;

import com.forcam.na.ffwebservices.client.api.exception.ForceAPIException;
import com.forcam.na.ffwebservices.client.api.pagination.request.CollectionRequest;
import com.forcam.na.ffwebservices.client.api.pagination.response.Page;
import com.forcam.na.ffwebservices.client.statusdefinition.StatusDefinitionClient;
import com.forcam.na.ffwebservices.model.statusdefinition.StatusDefinitionResponse;
import org.junit.*;

import java.util.regex.Pattern;

/**
 * Integration tests for the class {@link StatusDefinitionClient}.
 */
public class StatusDefinitionClientIntegrationTest extends AbstractOpenAPIIntegrationTest {

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    public StatusDefinitionClientIntegrationTest() {
        final Pattern machineStatesPattern = Pattern.compile(PREFIX_GET_PATH + "/masterData/machineStates\\?.*limit=3.*");
        mFileNames.put(machineStatesPattern, "json/getMachineStates.json");

        final Pattern personnelStatesPattern = Pattern.compile(PREFIX_GET_PATH + "/masterData/staffMemberStates\\?.*limit=3.*");
        mFileNames.put(personnelStatesPattern, "json/getPersonnelStates.json");

        final Pattern operationProductionStatesPattern = Pattern.compile(PREFIX_GET_PATH + "/masterData/operationProductionStates\\?.*limit=3.*");
        mFileNames.put(operationProductionStatesPattern, "json/getOperationProductionStates.json");
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    /**
     * Test for the method {@link StatusDefinitionClient#getMachineStates(CollectionRequest params)}}.
     *
     * @throws ForceAPIException When unable to get machine status definitions.
     */
    @Test
    public void testGetMachineStates() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final CollectionRequest params = new CollectionRequest();
        params.setLimit(3);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        Page<StatusDefinitionResponse> model = mStatusDefinitionClient.getMachineStates(params);

        Assert.assertNotNull(model);
        Assert.assertFalse(model
                               .getElements()
                               .isEmpty());
    }

    /**
     * Test for the method {@link StatusDefinitionClient#getOperationProductionStates(CollectionRequest)}.
     *
     * @throws ForceAPIException When unable to get machine status definitions.
     */
    @Test
    public void testGetOperationProductionStates() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final CollectionRequest params = new CollectionRequest();
        params.setLimit(3);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        Page<StatusDefinitionResponse> model = mStatusDefinitionClient.getOperationProductionStates(params);

        Assert.assertNotNull(model);
        Assert.assertFalse(model
                               .getElements()
                               .isEmpty());
    }

    /**
     * Test for the method {@link StatusDefinitionClient#getPersonnelStates(CollectionRequest params)}}.
     *
     * @throws ForceAPIException When unable to get personnel status definitions.
     */
    @Test
    public void testGetPersonnelStates() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final CollectionRequest params = new CollectionRequest();
        params.setLimit(3);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        Page<StatusDefinitionResponse> model = mStatusDefinitionClient.getPersonnelStates(params);

        Assert.assertNotNull(model);
        Assert.assertFalse(model
                               .getElements()
                               .isEmpty());
    }
}