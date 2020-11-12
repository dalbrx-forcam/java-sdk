////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 14.09.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.integration;

import com.forcam.na.ffwebservices.client.api.command.CommandClient;
import com.forcam.na.ffwebservices.client.api.exception.ForceAPIException;
import com.forcam.na.ffwebservices.model.command.CommandResponse;
import com.forcam.na.ffwebservices.model.command.machine.MachineCountCommandDataWSModel;
import com.forcam.na.ffwebservices.model.command.machine.MachineCountCommandRequest;
import com.forcam.na.ffwebservices.model.command.machine.MachineQuantityCommandDataWSModel;
import com.forcam.na.ffwebservices.model.command.machine.MachineQuantityCommandRequest;
import com.forcam.na.ffwebservices.model.command.machine.MachineStateCommandDataWSModel;
import com.forcam.na.ffwebservices.model.command.machine.MachineStateCommandRequest;
import com.forcam.na.ffwebservices.model.command.machine.MachineStateRevisionInsertCommandDataWsModel;
import com.forcam.na.ffwebservices.model.command.machine.MachineStateRevisionInsertCommandRequest;
import com.forcam.na.ffwebservices.model.command.machine.MachineStrokeCommandDataWSModel;
import com.forcam.na.ffwebservices.model.command.machine.MachineStrokeCommandRequest;
import com.forcam.na.ffwebservices.model.command.operation.OperationPhaseCommandDataWsModel;
import com.forcam.na.ffwebservices.model.command.operation.OperationPhaseCommandRequest;
import com.forcam.na.ffwebservices.model.command.operation.OperationPhaseRevisionInsertCommandDataWsModel;
import com.forcam.na.ffwebservices.model.command.operation.OperationPhaseRevisionInsertCommandRequest;
import com.forcam.na.ffwebservices.model.command.operation.OperationQuantityCommandDataWsModel;
import com.forcam.na.ffwebservices.model.command.operation.OperationQuantityCommandRequest;
import com.forcam.na.ffwebservices.model.command.operation.OperationQuantityRevisionInsertCommandDataWsModel;
import com.forcam.na.ffwebservices.model.command.operation.OperationQuantityRevisionInsertCommandRequest;
import com.forcam.na.ffwebservices.model.definition.OperationPhase;
import org.junit.*;
import org.junit.rules.*;

/**
 * Integration tests for the class {@link CommandClient}.
 */
public class CommandClientIntegrationTest extends AbstractCommandClientIntegrationTest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Helper for test exceptions and messages. */
    @Rule
    public ExpectedException mExpectedException = ExpectedException.none();

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    /**
     * Test for the method {@link CommandClient#sendOperationPhaseCommand(OperationPhaseCommandRequest)}.
     *
     * @throws ForceAPIException When unable to send operation phase command.
     */
    @Test
    public void testOperationPhaseCommand() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final OperationPhaseCommandRequest commandRequest = this.getOperationPhaseCommandRequest();

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final CommandResponse<OperationPhaseCommandDataWsModel> response = mCommandClient.sendOperationPhaseCommand(commandRequest);
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getProperties());
        Assert.assertNotNull(response
                                     .getProperties()
                                     .getData());

        final OperationPhaseCommandDataWsModel model = response
                .getProperties()
                .getData();
        Assert.assertEquals(commandRequest.getOperationId(), model.getOperationId());
        Assert.assertEquals(commandRequest.getWorkplaceId(), model.getWorkplaceId());
        Assert.assertEquals(commandRequest.getPhase(), model.getOperationPhaseId());
        Assert.assertEquals(OperationPhaseCommandDataWsModel.NAME, model.getType());
    }

    /**
     * Test for the method {@link CommandClient#sendOperationPhaseRevisionInsertCommand(OperationPhaseRevisionInsertCommandRequest)}.
     *
     * @throws ForceAPIException When unable to send operation phase revision insert command.
     */
    @Test
    public void testOperationPhaseRevisionInsertCommand() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final OperationPhaseRevisionInsertCommandRequest commandRequest = this.getOperationPhaseRevisionInsertCommandRequest();

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final CommandResponse<OperationPhaseRevisionInsertCommandDataWsModel> response = mCommandClient.sendOperationPhaseRevisionInsertCommand(commandRequest);
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getProperties());
        Assert.assertNotNull(response
                                     .getProperties()
                                     .getData());

        final OperationPhaseRevisionInsertCommandDataWsModel model = response
                .getProperties()
                .getData();
        Assert.assertEquals(commandRequest.getOperationPhaseCommandDataWsModel(), model.getOperationPhaseCommand());
        Assert.assertEquals(commandRequest
                                    .getInsertionTimestamp()
                                    .getTime(),
                            model
                                    .getInsertionTimestamp()
                                    .getTime());
        Assert.assertEquals(OperationPhaseRevisionInsertCommandDataWsModel.NAME, model.getType());
    }

    /**
     * Tests sending an invalid operation phase command.
     *
     * @throws ForceAPIException When unable to send operation phase command.
     */
    @Test
    public void testInvalidOperationPhaseCommand() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final String operationId = "operationId";
        mExpectedException.expect(ForceAPIException.class);
        mExpectedException.expectMessage("Unable to find operation for uuid: " + operationId);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final OperationPhaseCommandRequest commandRequest = new OperationPhaseCommandRequest(operationId, "workplaceId", OperationPhase.SETUP);
        mCommandClient.sendOperationPhaseCommand(commandRequest);
    }

    /**
     * Test for the method {@link CommandClient#sendOperationQuantityRevisionInsertCommand(OperationQuantityRevisionInsertCommandRequest)}.
     *
     * @throws ForceAPIException When unable to send operation quantity revision insert command.
     */
    @Test
    public void testOperationQuantityRevisionInsertCommand() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final OperationQuantityRevisionInsertCommandRequest commandRequest = this.getOperationQuantityRevisionInsertCommandRequest();

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final CommandResponse<OperationQuantityRevisionInsertCommandDataWsModel> response = mCommandClient.sendOperationQuantityRevisionInsertCommand(
                commandRequest);
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getProperties());
        Assert.assertNotNull(response
                                     .getProperties()
                                     .getData());

        final OperationQuantityRevisionInsertCommandDataWsModel model = response
                .getProperties()
                .getData();
        Assert.assertEquals(commandRequest.getOperationQuantityCommand(), model.getOperationQuantityCommand());
        Assert.assertEquals(commandRequest
                                    .getInsertionTimestamp()
                                    .getTime(),
                            model
                                    .getInsertionTimestamp()
                                    .getTime());
        Assert.assertEquals(OperationQuantityRevisionInsertCommandDataWsModel.NAME, model.getType());
    }

    /**
     * Test for the method {@link CommandClient#sendMachineCountCommand(MachineCountCommandRequest)}.
     *
     * @throws ForceAPIException When unable to send machine count command.
     */
    @Test
    public void testMachineCountCommand() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final MachineCountCommandRequest commandRequest = this.getMachineCountCommandRequest();

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final CommandResponse<MachineCountCommandDataWSModel> response = mCommandClient.sendMachineCountCommand(commandRequest);
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getProperties());
        Assert.assertNotNull(response
                                     .getProperties()
                                     .getData());

        final MachineCountCommandDataWSModel model = response
                .getProperties()
                .getData();
        Assert.assertEquals(commandRequest.getMachineId(), model.getMachineId());
        Assert.assertEquals(commandRequest.getCounterNumber(), model.getCounterNumber());
        Assert.assertEquals(commandRequest.getCount(), model.getCount());
        Assert.assertEquals(MachineCountCommandDataWSModel.NAME, model.getType());
    }

    /**
     * Test for the method {@link CommandClient#sendMachineQuantityCommand(MachineQuantityCommandRequest)}.
     *
     * @throws ForceAPIException When unable to send machine quantity command.
     */
    @Test
    public void testMachineQuantityCommand() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final MachineQuantityCommandRequest commandRequest = this.getMachineQuantityCommandRequest();

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final CommandResponse<MachineQuantityCommandDataWSModel> response = mCommandClient.sendMachineQuantityCommand(commandRequest);
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getProperties());
        Assert.assertNotNull(response
                                     .getProperties()
                                     .getData());

        final MachineQuantityCommandDataWSModel model = response
                .getProperties()
                .getData();
        Assert.assertEquals(commandRequest.getMachineId(), model.getMachineId());
        Assert.assertEquals(commandRequest.getQualityDetailId(), model.getQualityDetailId());
        Assert.assertEquals(commandRequest.getQuantity(), model.getQuantity(), 0);
        Assert.assertEquals(MachineQuantityCommandDataWSModel.NAME, model.getType());
    }

    /**
     * Test for the method {@link CommandClient#sendMachineStateCommand(MachineStateCommandRequest)}.
     *
     * @throws ForceAPIException When unable to send machine state command.
     */
    @Test
    public void testMachineStateCommand() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final MachineStateCommandRequest commandRequest = this.getMachineStateCommandRequest();

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final CommandResponse<MachineStateCommandDataWSModel> response = mCommandClient.sendMachineStateCommand(commandRequest);
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getProperties());
        Assert.assertNotNull(response
                                     .getProperties()
                                     .getData());

        final MachineStateCommandDataWSModel model = response
                .getProperties()
                .getData();
        Assert.assertEquals(commandRequest.getMachineId(), model.getMachineId());
        Assert.assertEquals(commandRequest.getAnnotation(), model.getAnnotation());
        Assert.assertEquals(commandRequest.getMachineStateDetailIds(), model.getMachineStateDetailIds());
        Assert.assertEquals(commandRequest.getMachineStateId(), model.getMachineStateId());
        Assert.assertEquals(MachineStateCommandDataWSModel.NAME, model.getType());
    }

    /**
     * Test for the method {@link CommandClient#sendMachineStateRevisionInsertCommand(MachineStateRevisionInsertCommandRequest)}.
     *
     * @throws ForceAPIException When unable to send machine state revision insert command.
     */
    @Test
    public void testMachineStateRevisionInsertCommand() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final MachineStateRevisionInsertCommandRequest commandRequest = this.getMachineStateRevisionInsertCommandRequest();

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final CommandResponse<MachineStateRevisionInsertCommandDataWsModel> response = mCommandClient.sendMachineStateRevisionInsertCommand(commandRequest);
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getProperties());
        Assert.assertNotNull(response
                                     .getProperties()
                                     .getData());

        final MachineStateRevisionInsertCommandDataWsModel model = response
                .getProperties()
                .getData();
        Assert.assertEquals(commandRequest.getMachineStatusCommand(), model.getMachineStateCommand());
        Assert.assertEquals(commandRequest
                                    .getInsertionTimestamp()
                                    .getTime(),
                            model
                                    .getInsertionTimestamp()
                                    .getTime());
        Assert.assertEquals(MachineStateRevisionInsertCommandDataWsModel.NAME, model.getType());
    }

    /**
     * Test for the method {@link CommandClient#sendMachineStrokeCommand(MachineStrokeCommandRequest)}.
     *
     * @throws ForceAPIException When unable to send machine stroke command.
     */
    @Test
    public void testMachineStrokeCommand() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final MachineStrokeCommandRequest commandRequest = this.getMachineStrokeCommandRequest();

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final CommandResponse<MachineStrokeCommandDataWSModel> response = mCommandClient.sendMachineStrokeCommand(commandRequest);
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getProperties());
        Assert.assertNotNull(response
                                     .getProperties()
                                     .getData());

        final MachineStrokeCommandDataWSModel model = response
                .getProperties()
                .getData();
        Assert.assertEquals(commandRequest.getMachineId(), model.getMachineId());
        Assert.assertEquals(commandRequest.getCounterNumber(), model.getCounterNumber());
        Assert.assertEquals(commandRequest.getStrokes(), model.getStrokes());
        Assert.assertEquals(MachineStrokeCommandDataWSModel.NAME, model.getType());
    }

    /**
     * Test for the method {@link CommandClient#sendOperationQuantityCommand(OperationQuantityCommandRequest)}.
     *
     * @throws ForceAPIException When unable to send operation quantity command.
     */
    @Test
    public void testOperationQuantityCommand() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final OperationQuantityCommandRequest commandRequest = this.getOperationQuantityCommandRequest();

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final CommandResponse<OperationQuantityCommandDataWsModel> response = mCommandClient.sendOperationQuantityCommand(commandRequest);
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getProperties());
        Assert.assertNotNull(response
                                     .getProperties()
                                     .getData());

        final OperationQuantityCommandDataWsModel model = response
                .getProperties()
                .getData();
        Assert.assertEquals(commandRequest.getOperationId(), model.getOperationId());
        Assert.assertEquals(commandRequest.getWorkplaceId(), model.getWorkplaceId());
        Assert.assertEquals(commandRequest.getQuantity(), model.getQuantity(), 0);
        Assert.assertEquals(commandRequest.getQualityDetailId(), model.getQualityDetailId());
        Assert.assertEquals(commandRequest.getAnnotation(), model.getAnnotation());
        Assert.assertEquals(commandRequest.getStaffMemberId(), model.getStaffMemberId());
        Assert.assertEquals(commandRequest.getTicketId(), model.getTicketId());
        Assert.assertEquals(OperationQuantityCommandDataWsModel.NAME, model.getType());
    }
}