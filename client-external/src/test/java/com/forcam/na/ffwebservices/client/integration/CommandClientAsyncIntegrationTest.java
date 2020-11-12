////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 27.10.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.integration;

import com.forcam.na.ffwebservices.client.AbstractTestCommandCallback;
import com.forcam.na.ffwebservices.client.api.command.CommandClientAsync;
import com.forcam.na.ffwebservices.client.api.command.ICommandClientAsync;
import com.forcam.na.ffwebservices.client.api.exception.ForceAPIException;
import com.forcam.na.ffwebservices.model.command.machine.MachineCountCommandDataWSModel;
import com.forcam.na.ffwebservices.model.command.machine.MachineCountCommandRequest;
import com.forcam.na.ffwebservices.model.command.machine.MachineQuantityCommandDataWSModel;
import com.forcam.na.ffwebservices.model.command.machine.MachineQuantityCommandRequest;
import com.forcam.na.ffwebservices.model.command.machine.MachineStateCommandRequest;
import com.forcam.na.ffwebservices.model.command.machine.MachineStateRevisionInsertCommandRequest;
import com.forcam.na.ffwebservices.model.command.machine.MachineStateCommandDataWSModel;
import com.forcam.na.ffwebservices.model.command.machine.MachineStateRevisionInsertCommandDataWsModel;
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
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Integration tests for the class {@link CommandClientAsync}.
 */
public class CommandClientAsyncIntegrationTest extends AbstractCommandClientIntegrationTest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Waits so many seconds at most for a response of the server. */
    private final long mMaxWaitTime = 2;

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    /**
     * Test for the method {@link CommandClientAsync#sendOperationPhaseCommand(OperationPhaseCommandRequest, ICommandClientAsync.CommandCallback)}.
     *
     * @throws ForceAPIException    When unable to send operation phase command.
     * @throws TimeoutException     When a timeout occurs.
     * @throws InterruptedException When thread is interrupted while waiting.
     */
    @Test
    public void testOperationPhaseCommand() throws ForceAPIException, TimeoutException, InterruptedException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final OperationPhaseCommandRequest commandRequest = this.getOperationPhaseCommandRequest();
        final AbstractTestCommandCallback<OperationPhaseCommandRequest, OperationPhaseCommandDataWsModel> commandCallback = new AbstractTestCommandCallback<OperationPhaseCommandRequest, OperationPhaseCommandDataWsModel>() {
            @Override
            public void onResponse(OperationPhaseCommandRequest request, OperationPhaseCommandDataWsModel model) {
                Assert.assertEquals(request.getOperationId(), model.getOperationId());
                Assert.assertEquals(request.getWorkplaceId(), model.getWorkplaceId());
                Assert.assertEquals(request.getPhase(), model.getOperationPhaseId());
                Assert.assertEquals(OperationPhaseCommandDataWsModel.NAME, model.getType());

                this.success();
            }
        };

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mCommandClientAsync.sendOperationPhaseCommand(commandRequest, commandCallback);
        commandCallback.wait(mMaxWaitTime, TimeUnit.SECONDS);

        Assert.assertTrue(commandCallback.isSuccessful());
    }

    /**
     * Test for the method {@link CommandClientAsync#sendOperationPhaseRevisionInsertCommand(OperationPhaseRevisionInsertCommandRequest, ICommandClientAsync.CommandCallback)}.
     *
     * @throws ForceAPIException    When unable to send operation phase revision insert command.
     * @throws TimeoutException     When a timeout occurs.
     * @throws InterruptedException When thread is interrupted while waiting.
     */
    @Test
    public void testOperationPhaseRevisionInsertCommand() throws ForceAPIException, TimeoutException, InterruptedException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final OperationPhaseRevisionInsertCommandRequest commandRequest = this.getOperationPhaseRevisionInsertCommandRequest();
        final AbstractTestCommandCallback<OperationPhaseRevisionInsertCommandRequest, OperationPhaseRevisionInsertCommandDataWsModel> commandCallback = new AbstractTestCommandCallback<OperationPhaseRevisionInsertCommandRequest, OperationPhaseRevisionInsertCommandDataWsModel>() {
            @Override
            public void onResponse(OperationPhaseRevisionInsertCommandRequest request, OperationPhaseRevisionInsertCommandDataWsModel model) {
                Assert.assertEquals(request.getOperationPhaseCommandDataWsModel(), model.getOperationPhaseCommand());
                Assert.assertEquals(request.getInsertionTimestamp().getTime(), model.getInsertionTimestamp().getTime());
                Assert.assertEquals(OperationPhaseRevisionInsertCommandDataWsModel.NAME, model.getType());

                this.success();
            }
        };

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mCommandClientAsync.sendOperationPhaseRevisionInsertCommand(commandRequest, commandCallback);
        commandCallback.wait(mMaxWaitTime, TimeUnit.SECONDS);

        Assert.assertTrue(commandCallback.isSuccessful());
    }



    /**
     * Test for the method {@link CommandClientAsync#sendOperationQuantityCommand(OperationQuantityCommandRequest, ICommandClientAsync.CommandCallback)}.
     *
     * @throws ForceAPIException    When unable to send operation quantity command.
     * @throws TimeoutException     When a timeout occurs.
     * @throws InterruptedException When thread is interrupted while waiting.
     */
    @Test
    public void testOperationQuantityCommand() throws ForceAPIException, TimeoutException, InterruptedException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final OperationQuantityCommandRequest commandRequest = this.getOperationQuantityCommandRequest();
        final AbstractTestCommandCallback<OperationQuantityCommandRequest, OperationQuantityCommandDataWsModel> commandCallback = new AbstractTestCommandCallback<OperationQuantityCommandRequest, OperationQuantityCommandDataWsModel>() {
            @Override
            public void onResponse(OperationQuantityCommandRequest request, OperationQuantityCommandDataWsModel model) {
                Assert.assertEquals(request.getOperationId(), model.getOperationId());
                Assert.assertEquals(request.getWorkplaceId(), model.getWorkplaceId());
                Assert.assertEquals(request.getQuantity(), model.getQuantity(), 0);
                Assert.assertEquals(request.getQualityDetailId(), model.getQualityDetailId());
                Assert.assertEquals(request.getStaffMemberId(), model.getStaffMemberId());
                Assert.assertEquals(request.getAnnotation(), model.getAnnotation());
                Assert.assertEquals(request.getTicketId(), model.getTicketId());
                Assert.assertEquals(OperationQuantityCommandDataWsModel.NAME, model.getType());

                this.success();
            }
        };

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mCommandClientAsync.sendOperationQuantityCommand(commandRequest, commandCallback);
        commandCallback.wait(mMaxWaitTime, TimeUnit.SECONDS);

        Assert.assertTrue(commandCallback.isSuccessful());
    }

    /**
     * Test for the method {@link CommandClientAsync#sendMachineCountCommand(MachineCountCommandRequest, ICommandClientAsync.CommandCallback)}.
     *
     * @throws ForceAPIException    When unable to send machine count command.
     * @throws TimeoutException     When a timeout occurs.
     * @throws InterruptedException When thread is interrupted while waiting.
     */
    @Test
    public void testMachineCountCommand() throws ForceAPIException, TimeoutException, InterruptedException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final MachineCountCommandRequest commandRequest = this.getMachineCountCommandRequest();
        final AbstractTestCommandCallback<MachineCountCommandRequest, MachineCountCommandDataWSModel> commandCallback = new AbstractTestCommandCallback<MachineCountCommandRequest, MachineCountCommandDataWSModel>() {
            @Override
            public void onResponse(MachineCountCommandRequest request, MachineCountCommandDataWSModel model) {
                Assert.assertEquals(request.getMachineId(), model.getMachineId());
                Assert.assertEquals(request.getCounterNumber(), model.getCounterNumber());
                Assert.assertEquals(request.getCount(), model.getCount());
                Assert.assertEquals(MachineCountCommandDataWSModel.NAME, model.getType());

                this.success();
            }
        };

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mCommandClientAsync.sendMachineCountCommand(commandRequest, commandCallback);
        commandCallback.wait(mMaxWaitTime, TimeUnit.SECONDS);

        Assert.assertTrue(commandCallback.isSuccessful());
    }

    /**
     * Test for the method {@link CommandClientAsync#sendMachineQuantityCommand(MachineQuantityCommandRequest, ICommandClientAsync.CommandCallback)}.
     *
     * @throws ForceAPIException    When unable to send machine quantity command.
     * @throws TimeoutException     When a timeout occurs.
     * @throws InterruptedException When thread is interrupted while waiting.
     */
    @Test
    public void testMachineQuantityCommand() throws ForceAPIException, TimeoutException, InterruptedException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final MachineQuantityCommandRequest commandRequest = this.getMachineQuantityCommandRequest();
        final AbstractTestCommandCallback<MachineQuantityCommandRequest, MachineQuantityCommandDataWSModel> commandCallback = new AbstractTestCommandCallback<MachineQuantityCommandRequest, MachineQuantityCommandDataWSModel>() {
            @Override
            public void onResponse(MachineQuantityCommandRequest request, MachineQuantityCommandDataWSModel model) {
                Assert.assertEquals(request.getMachineId(), model.getMachineId());
                Assert.assertEquals(request.getQualityDetailId(), model.getQualityDetailId());
                Assert.assertEquals(request.getQuantity(), model.getQuantity(), 0);
                Assert.assertEquals(MachineQuantityCommandDataWSModel.NAME, model.getType());

                this.success();
            }
        };

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mCommandClientAsync.sendMachineQuantityCommand(commandRequest, commandCallback);
        commandCallback.wait(mMaxWaitTime, TimeUnit.SECONDS);

        Assert.assertTrue(commandCallback.isSuccessful());
    }

    /**
     * Test for the method {@link CommandClientAsync#sendMachineStateCommand(MachineStateCommandRequest, ICommandClientAsync.CommandCallback)}.
     *
     * @throws ForceAPIException    When unable to send machine state command.
     * @throws TimeoutException     When a timeout occurs.
     * @throws InterruptedException When thread is interrupted while waiting.
     */
    @Test
    public void testMachineStateCommand() throws ForceAPIException, TimeoutException, InterruptedException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final MachineStateCommandRequest commandRequest = this.getMachineStateCommandRequest();
        final AbstractTestCommandCallback<MachineStateCommandRequest, MachineStateCommandDataWSModel> commandCallback = new AbstractTestCommandCallback<MachineStateCommandRequest, MachineStateCommandDataWSModel>() {
            @Override
            public void onResponse(MachineStateCommandRequest request, MachineStateCommandDataWSModel model) {
                Assert.assertEquals(request.getMachineId(), model.getMachineId());
                Assert.assertEquals(request.getAnnotation(), model.getAnnotation());
                Assert.assertEquals(request.getMachineStateDetailIds(), model.getMachineStateDetailIds());
                Assert.assertEquals(request.getMachineStateId(), model.getMachineStateId());
                Assert.assertEquals(MachineStateCommandDataWSModel.NAME, model.getType());

                this.success();
            }
        };

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mCommandClientAsync.sendMachineStateCommand(commandRequest, commandCallback);
        commandCallback.wait(mMaxWaitTime, TimeUnit.SECONDS);

        Assert.assertTrue(commandCallback.isSuccessful());
    }

    /**
     * Test for the method {@link CommandClientAsync#sendMachineStateRevisionInsertCommand(MachineStateRevisionInsertCommandRequest, ICommandClientAsync.CommandCallback)}.
     *
     * @throws ForceAPIException    When unable to send machine state revision insert command.
     * @throws TimeoutException     When a timeout occurs.
     * @throws InterruptedException When thread is interrupted while waiting.
     */
    @Test
    public void testMachineStateRevisionInsertCommand() throws ForceAPIException, TimeoutException, InterruptedException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final MachineStateRevisionInsertCommandRequest commandRequest = this.getMachineStateRevisionInsertCommandRequest();
        final AbstractTestCommandCallback<MachineStateRevisionInsertCommandRequest, MachineStateRevisionInsertCommandDataWsModel> commandCallback = new AbstractTestCommandCallback<MachineStateRevisionInsertCommandRequest, MachineStateRevisionInsertCommandDataWsModel>() {
            @Override
            public void onResponse(MachineStateRevisionInsertCommandRequest request, MachineStateRevisionInsertCommandDataWsModel model) {
                Assert.assertEquals(request.getMachineStatusCommand(), model.getMachineStateCommand());
                Assert.assertEquals(request.getInsertionTimestamp().getTime(), model.getInsertionTimestamp().getTime());
                Assert.assertEquals(MachineStateRevisionInsertCommandDataWsModel.NAME, model.getType());

                this.success();
            }
        };

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mCommandClientAsync.sendMachineStateRevisionInsertCommand(commandRequest, commandCallback);
        commandCallback.wait(mMaxWaitTime, TimeUnit.SECONDS);

        Assert.assertTrue(commandCallback.isSuccessful());
    }

    /**
     * Test for the method {@link CommandClientAsync#sendMachineStrokeCommand(MachineStrokeCommandRequest, ICommandClientAsync.CommandCallback)}.
     *
     * @throws ForceAPIException    When unable to send machine stroke command.
     * @throws TimeoutException     When a timeout occurs.
     * @throws InterruptedException When thread is interrupted while waiting.
     */
    @Test
    public void testMachineStrokeCommand() throws ForceAPIException, TimeoutException, InterruptedException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final MachineStrokeCommandRequest commandRequest = this.getMachineStrokeCommandRequest();
        final AbstractTestCommandCallback<MachineStrokeCommandRequest, MachineStrokeCommandDataWSModel> commandCallback = new AbstractTestCommandCallback<MachineStrokeCommandRequest, MachineStrokeCommandDataWSModel>() {
            @Override
            public void onResponse(MachineStrokeCommandRequest request, MachineStrokeCommandDataWSModel model) {
                Assert.assertEquals(request.getMachineId(), model.getMachineId());
                Assert.assertEquals(request.getCounterNumber(), model.getCounterNumber());
                Assert.assertEquals(request.getStrokes(), model.getStrokes());
                Assert.assertEquals(MachineStrokeCommandDataWSModel.NAME, model.getType());

                this.success();
            }
        };

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mCommandClientAsync.sendMachineStrokeCommand(commandRequest, commandCallback);
        commandCallback.wait(mMaxWaitTime, TimeUnit.SECONDS);

        Assert.assertTrue(commandCallback.isSuccessful());
    }


    /**
     * Test for the method {@link CommandClientAsync#sendOperationQuantityRevisionInsertCommand(OperationQuantityRevisionInsertCommandRequest, ICommandClientAsync.CommandCallback)}.
     *
     * @throws ForceAPIException    When unable to send operation quantity revision insert command.
     * @throws TimeoutException     When a timeout occurs.
     * @throws InterruptedException When thread is interrupted while waiting.
     */
    @Test
    public void testOperationQuantityRevisionInsertCommand() throws ForceAPIException, TimeoutException, InterruptedException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final OperationQuantityRevisionInsertCommandRequest commandRequest = this.getOperationQuantityRevisionInsertCommandRequest();
        final AbstractTestCommandCallback<OperationQuantityRevisionInsertCommandRequest, OperationQuantityRevisionInsertCommandDataWsModel> commandCallback = new AbstractTestCommandCallback<OperationQuantityRevisionInsertCommandRequest, OperationQuantityRevisionInsertCommandDataWsModel>() {
            @Override
            public void onResponse(OperationQuantityRevisionInsertCommandRequest request, OperationQuantityRevisionInsertCommandDataWsModel model) {
                Assert.assertEquals(request.getOperationQuantityCommand(), model.getOperationQuantityCommand());
                Assert.assertEquals(request.getInsertionTimestamp().getTime(), model.getInsertionTimestamp().getTime());
                Assert.assertEquals(OperationQuantityRevisionInsertCommandDataWsModel.NAME, model.getType());
                this.success();
            }
        };

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mCommandClientAsync.sendOperationQuantityRevisionInsertCommand(commandRequest, commandCallback);
        commandCallback.wait(mMaxWaitTime, TimeUnit.SECONDS);

        Assert.assertTrue(commandCallback.isSuccessful());
    }
}