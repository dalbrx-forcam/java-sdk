////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 30.10.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.command;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.forcam.na.ffwebservices.client.AbstractTestCommandCallback;
import com.forcam.na.ffwebservices.client.api.config.GuiceTestRunner;
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
import com.forcam.na.ffwebservices.model.definition.MachineState;
import com.forcam.na.ffwebservices.model.definition.OperationPhase;
import org.junit.*;
import org.junit.runner.*;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Tests for the class {@link CommandClientAsync}.
 */
@RunWith(GuiceTestRunner.class)
public class CommandClientAsyncTest extends AbstractCommandClientTest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Waits so many seconds at most for a response of the server. */
    private final long mMaxWaitTime = 2;

    /** The asynchronous command client. */
    private ICommandClientAsync mCommandClientAsync;

    // ------------------------------------------------------------------------
    // constructor
    // ------------------------------------------------------------------------

    public CommandClientAsyncTest() {
        mCommandClientAsync = mBridgeAPIComponent.commandClientAsync();
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    /**
     * Test for the method {@link CommandClientAsync#sendOperationPhaseCommand(OperationPhaseCommandRequest, ICommandClientAsync.CommandCallback)} .
     *
     * @throws IOException          When unable to convert the command model to a JSON string.
     * @throws InterruptedException When thread is interrupted while waiting.
     * @throws TimeoutException     When a timeout occurs.
     */
    @Test
    public void sendOperationPhaseCommand() throws IOException, InterruptedException, TimeoutException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final OperationPhaseCommandDataWsModel commandDataModel = new OperationPhaseCommandDataWsModel();
        final OperationPhaseCommandRequest commandRequest = this.prepareOperationPhaseCommand(commandDataModel);
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
        this.verifyRequest(commandDataModel, OperationPhaseCommandDataWsModel.class);
        commandCallback.wait(mMaxWaitTime, TimeUnit.SECONDS);

        Assert.assertTrue(commandCallback.isSuccessful());
    }

    /**
     * Test for the method {@link CommandClientAsync#sendOperationPhaseRevisionInsertCommand(OperationPhaseRevisionInsertCommandRequest, ICommandClientAsync.CommandCallback)}
     *
     * @throws IOException          When unable to convert the command model to a JSON string.
     * @throws InterruptedException When thread is interrupted while waiting.
     * @throws TimeoutException     When a timeout occurs.
     */
    @Test
    public void sendOperationPhaseRevisionInsertCommand() throws IOException, InterruptedException, TimeoutException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final OperationPhaseRevisionInsertCommandDataWsModel commandDataModel = new OperationPhaseRevisionInsertCommandDataWsModel();
        final OperationPhaseRevisionInsertCommandRequest commandRequest = this.prepareOperationPhaseRevisionInsertCommand(commandDataModel);
        final AbstractTestCommandCallback<OperationPhaseRevisionInsertCommandRequest, OperationPhaseRevisionInsertCommandDataWsModel> commandCallback = new AbstractTestCommandCallback<OperationPhaseRevisionInsertCommandRequest, OperationPhaseRevisionInsertCommandDataWsModel>() {
            @Override
            public void onResponse(OperationPhaseRevisionInsertCommandRequest request, OperationPhaseRevisionInsertCommandDataWsModel model) {
                Assert.assertEquals(request.getOperationPhaseCommandDataWsModel(), model.getOperationPhaseCommand());
                Assert.assertEquals(request
                                        .getInsertionTimestamp()
                                        .getTime(),
                                    model
                                        .getInsertionTimestamp()
                                        .getTime());
                Assert.assertEquals(OperationPhaseRevisionInsertCommandDataWsModel.NAME, model.getType());

                this.success();
            }
        };

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mCommandClientAsync.sendOperationPhaseRevisionInsertCommand(commandRequest, commandCallback);
        this.verifyRequest(commandDataModel, OperationPhaseRevisionInsertCommandDataWsModel.class);
        commandCallback.wait(mMaxWaitTime, TimeUnit.SECONDS);

        Assert.assertTrue(commandCallback.isSuccessful());
    }

    /**
     * Test for the method {@link CommandClientAsync#sendOperationQuantityCommand(OperationQuantityCommandRequest, ICommandClientAsync.CommandCallback)}
     *
     * @throws IOException          When unable to convert the command model to a JSON string.
     * @throws InterruptedException When thread is interrupted while waiting.
     * @throws TimeoutException     When a timeout occurs.
     */
    @Test
    public void sendOperationQuantityCommand() throws IOException, InterruptedException, TimeoutException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final OperationQuantityCommandDataWsModel commandDataModel = new OperationQuantityCommandDataWsModel();
        final OperationQuantityCommandRequest commandRequest = this.prepareOperationQuantityCommand(commandDataModel);
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
        this.verifyRequest(commandDataModel, OperationQuantityCommandDataWsModel.class);
        commandCallback.wait(mMaxWaitTime, TimeUnit.SECONDS);

        Assert.assertTrue(commandCallback.isSuccessful());
    }

    /**
     * Test for the method {@link CommandClientAsync#sendOperationQuantityRevisionInsertCommand(OperationQuantityRevisionInsertCommandRequest, ICommandClientAsync.CommandCallback)}.
     *
     * @throws IOException          When unable to convert the command model to a JSON string.
     * @throws InterruptedException When thread is interrupted while waiting.
     * @throws TimeoutException     When a timeout occurs.
     */
    @Test
    public void sendOperationQuantityRevisionInsertCommand() throws IOException, InterruptedException, TimeoutException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final OperationQuantityRevisionInsertCommandDataWsModel commandDataModel = new OperationQuantityRevisionInsertCommandDataWsModel();
        final OperationQuantityRevisionInsertCommandRequest commandRequest = this.prepareOperationQuantityRevisionInsertCommand(commandDataModel);
        final AbstractTestCommandCallback<OperationQuantityRevisionInsertCommandRequest, OperationQuantityRevisionInsertCommandDataWsModel> commandCallback = new AbstractTestCommandCallback<OperationQuantityRevisionInsertCommandRequest, OperationQuantityRevisionInsertCommandDataWsModel>() {
            @Override
            public void onResponse(OperationQuantityRevisionInsertCommandRequest request, OperationQuantityRevisionInsertCommandDataWsModel model) {
                Assert.assertEquals(request.getOperationQuantityCommand(), model.getOperationQuantityCommand());
                Assert.assertEquals(request
                                        .getInsertionTimestamp()
                                        .getTime(),
                                    model
                                        .getInsertionTimestamp()
                                        .getTime());
                Assert.assertEquals(OperationQuantityRevisionInsertCommandDataWsModel.NAME, model.getType());

                this.success();
            }
        };

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mCommandClientAsync.sendOperationQuantityRevisionInsertCommand(commandRequest, commandCallback);
        this.verifyRequest(commandDataModel, OperationQuantityRevisionInsertCommandDataWsModel.class);
        commandCallback.wait(mMaxWaitTime, TimeUnit.SECONDS);

        Assert.assertTrue(commandCallback.isSuccessful());
    }

    /**
     * Test for the method {@link CommandClientAsync#sendMachineCountCommand(MachineCountCommandRequest, ICommandClientAsync.CommandCallback)}
     *
     * @throws IOException          When unable to convert the command model to a JSON string.
     * @throws InterruptedException When thread is interrupted while waiting.
     * @throws TimeoutException     When a timeout occurs.
     */
    @Test
    public void sendMachineCountCommand() throws IOException, InterruptedException, TimeoutException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final MachineCountCommandDataWSModel commandDataModel = new MachineCountCommandDataWSModel();
        final MachineCountCommandRequest commandRequest = this.prepareMachineCountCommand(commandDataModel);
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
        this.verifyRequest(commandDataModel, MachineCountCommandDataWSModel.class);
        commandCallback.wait(mMaxWaitTime, TimeUnit.SECONDS);

        Assert.assertTrue(commandCallback.isSuccessful());
    }

    /**
     * Test for the method {@link CommandClientAsync#sendMachineQuantityCommand(MachineQuantityCommandRequest, ICommandClientAsync.CommandCallback)}
     *
     * @throws IOException          When unable to convert the command model to a JSON string.
     * @throws InterruptedException When thread is interrupted while waiting.
     * @throws TimeoutException     When a timeout occurs.
     */
    @Test
    public void sendMachineQuantityCommand() throws IOException, InterruptedException, TimeoutException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final MachineQuantityCommandDataWSModel commandDataModel = new MachineQuantityCommandDataWSModel();
        final MachineQuantityCommandRequest commandRequest = this.prepareMachineQuantityCommand(commandDataModel);
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
        this.verifyRequest(commandDataModel, MachineQuantityCommandDataWSModel.class);
        commandCallback.wait(mMaxWaitTime, TimeUnit.SECONDS);

        Assert.assertTrue(commandCallback.isSuccessful());
    }

    /**
     * Test for the method {@link CommandClientAsync#sendMachineStateCommand(MachineStateCommandRequest, ICommandClientAsync.CommandCallback)}
     *
     * @throws IOException          When unable to convert the command model to a JSON string.
     * @throws InterruptedException When thread is interrupted while waiting.
     * @throws TimeoutException     When a timeout occurs.
     */
    @Test
    public void sendMachineStateCommand() throws IOException, InterruptedException, TimeoutException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final MachineStateCommandDataWSModel commandDataModel = new MachineStateCommandDataWSModel();
        final MachineStateCommandRequest commandRequest = this.prepareMachineStateCommand(commandDataModel);
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
        this.verifyRequest(commandDataModel, MachineStateCommandDataWSModel.class);
        commandCallback.wait(mMaxWaitTime, TimeUnit.SECONDS);

        Assert.assertTrue(commandCallback.isSuccessful());
    }

    /**
     * Test for the method {@link CommandClientAsync#sendMachineStateRevisionInsertCommand(MachineStateRevisionInsertCommandRequest, ICommandClientAsync.CommandCallback)}
     *
     * @throws IOException          When unable to convert the command model to a JSON string.
     * @throws InterruptedException When thread is interrupted while waiting.
     * @throws TimeoutException     When a timeout occurs.
     */
    @Test
    public void sendMachineStateRevisionInsertCommand() throws IOException, InterruptedException, TimeoutException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final MachineStateRevisionInsertCommandDataWsModel commandDataModel = new MachineStateRevisionInsertCommandDataWsModel();
        final MachineStateRevisionInsertCommandRequest commandRequest = this.prepareMachineStateRevisionInsertCommand(commandDataModel);
        final AbstractTestCommandCallback<MachineStateRevisionInsertCommandRequest, MachineStateRevisionInsertCommandDataWsModel> commandCallback = new AbstractTestCommandCallback<MachineStateRevisionInsertCommandRequest, MachineStateRevisionInsertCommandDataWsModel>() {
            @Override
            public void onResponse(MachineStateRevisionInsertCommandRequest request, MachineStateRevisionInsertCommandDataWsModel model) {
                Assert.assertEquals(request.getMachineStatusCommand(), model.getMachineStateCommand());
                Assert.assertEquals(request
                                        .getInsertionTimestamp()
                                        .getTime(),
                                    model
                                        .getInsertionTimestamp()
                                        .getTime());
                Assert.assertEquals(MachineStateRevisionInsertCommandDataWsModel.NAME, model.getType());

                this.success();
            }
        };

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mCommandClientAsync.sendMachineStateRevisionInsertCommand(commandRequest, commandCallback);
        this.verifyRequest(commandDataModel, MachineStateRevisionInsertCommandDataWsModel.class);
        commandCallback.wait(mMaxWaitTime, TimeUnit.SECONDS);

        Assert.assertTrue(commandCallback.isSuccessful());
    }

    /**
     * Test for the method {@link CommandClientAsync#sendMachineStrokeCommand(MachineStrokeCommandRequest, ICommandClientAsync.CommandCallback)}
     *
     * @throws IOException          When unable to convert the command model to a JSON string.
     * @throws InterruptedException When thread is interrupted while waiting.
     * @throws TimeoutException     When a timeout occurs.
     */
    @Test
    public void sendMachineStrokeCommand() throws IOException, InterruptedException, TimeoutException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final MachineStrokeCommandDataWSModel commandDataModel = new MachineStrokeCommandDataWSModel();
        final MachineStrokeCommandRequest commandRequest = this.prepareMachineStrokeCommand(commandDataModel);
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
        this.verifyRequest(commandDataModel, MachineStrokeCommandDataWSModel.class);
        commandCallback.wait(mMaxWaitTime, TimeUnit.SECONDS);

        Assert.assertTrue(commandCallback.isSuccessful());
    }

    /**
     * Sends an operation phase timeout.
     *
     * @throws JsonProcessingException When unable to transform an object into a JSON string.
     * @throws InterruptedException    When thread is interrupted while waiting.
     * @throws TimeoutException        When a timeout occurs.
     */
    @Test
    public void sendOperationPhaseTimeout() throws JsonProcessingException, InterruptedException, TimeoutException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        this.expectTimeout();
        final OperationPhaseCommandRequest commandRequest = new OperationPhaseCommandRequest("operationId", "workplaceId", OperationPhase.SETUP);
        final AbstractTestCommandCallback<OperationPhaseCommandRequest, OperationPhaseCommandDataWsModel> commandCallback = new AbstractTestCommandCallback<OperationPhaseCommandRequest, OperationPhaseCommandDataWsModel>() {
            @Override
            public void onResponse(OperationPhaseCommandRequest request, OperationPhaseCommandDataWsModel model) {
                this.success();
            }
        };

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mCommandClientAsync.sendOperationPhaseCommand(commandRequest, commandCallback);
        commandCallback.wait(mMaxWaitTime, TimeUnit.SECONDS);
        Assert.fail();
    }

    /**
     * Sends an operation quantity timeout.
     *
     * @throws JsonProcessingException When unable to transform an object into a JSON string.
     * @throws InterruptedException    When thread is interrupted while waiting.
     * @throws TimeoutException        When a timeout occurs.
     */
    @Test
    public void sendOperationQuantityTimeout() throws JsonProcessingException, InterruptedException, TimeoutException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        this.expectTimeout();
        final OperationQuantityCommandRequest commandRequest = new OperationQuantityCommandRequest("operationId", "workplaceId", 0, "qualityDetailId");
        final AbstractTestCommandCallback<OperationQuantityCommandRequest, OperationQuantityCommandDataWsModel> commandCallback = new AbstractTestCommandCallback<OperationQuantityCommandRequest, OperationQuantityCommandDataWsModel>() {
            @Override
            public void onResponse(OperationQuantityCommandRequest request, OperationQuantityCommandDataWsModel model) {
                this.success();
            }
        };

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mCommandClientAsync.sendOperationQuantityCommand(commandRequest, commandCallback);
        commandCallback.wait(mMaxWaitTime, TimeUnit.SECONDS);
        Assert.fail();
    }

    /**
     * Sends a machine count timeout.
     *
     * @throws JsonProcessingException When unable to transform an object into a JSON string.
     * @throws InterruptedException    When thread is interrupted while waiting.
     * @throws TimeoutException        When a timeout occurs.
     */
    @Test
    public void sendMachineCountTimeout() throws JsonProcessingException, InterruptedException, TimeoutException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        this.expectTimeout();
        final MachineCountCommandRequest commandRequest = new MachineCountCommandRequest("machineId", 0, 0);
        final AbstractTestCommandCallback<MachineCountCommandRequest, MachineCountCommandDataWSModel> commandCallback = new AbstractTestCommandCallback<MachineCountCommandRequest, MachineCountCommandDataWSModel>() {
            @Override
            public void onResponse(MachineCountCommandRequest request, MachineCountCommandDataWSModel model) {
                this.success();
            }
        };

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mCommandClientAsync.sendMachineCountCommand(commandRequest, commandCallback);
        commandCallback.wait(mMaxWaitTime, TimeUnit.SECONDS);
        Assert.fail();
    }

    /**
     * Sends a machine quantity timeout.
     *
     * @throws JsonProcessingException When unable to transform an object into a JSON string.
     * @throws InterruptedException    When thread is interrupted while waiting.
     * @throws TimeoutException        When a timeout occurs.
     */
    @Test
    public void sendMachineQuantityTimeout() throws JsonProcessingException, InterruptedException, TimeoutException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        this.expectTimeout();
        final MachineQuantityCommandRequest commandRequest = new MachineQuantityCommandRequest("machineId", 0, "qualityDetailId");
        final AbstractTestCommandCallback<MachineQuantityCommandRequest, MachineQuantityCommandDataWSModel> commandCallback = new AbstractTestCommandCallback<MachineQuantityCommandRequest, MachineQuantityCommandDataWSModel>() {
            @Override
            public void onResponse(MachineQuantityCommandRequest request, MachineQuantityCommandDataWSModel model) {
                this.success();
            }
        };

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mCommandClientAsync.sendMachineQuantityCommand(commandRequest, commandCallback);
        commandCallback.wait(mMaxWaitTime, TimeUnit.SECONDS);
        Assert.fail();
    }

    /**
     * Sends a machine state timeout.
     *
     * @throws JsonProcessingException When unable to transform an object into a JSON string.
     * @throws InterruptedException    When thread is interrupted while waiting.
     * @throws TimeoutException        When a timeout occurs.
     */
    @Test
    public void sendMachineStateTimeout() throws JsonProcessingException, InterruptedException, TimeoutException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        this.expectTimeout();
        final MachineStateCommandRequest commandRequest = new MachineStateCommandRequest("machineId", MachineState.PRODUCTION);
        final AbstractTestCommandCallback<MachineStateCommandRequest, MachineStateCommandDataWSModel> commandCallback = new AbstractTestCommandCallback<MachineStateCommandRequest, MachineStateCommandDataWSModel>() {
            @Override
            public void onResponse(MachineStateCommandRequest request, MachineStateCommandDataWSModel model) {
                this.success();
            }
        };

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mCommandClientAsync.sendMachineStateCommand(commandRequest, commandCallback);
        commandCallback.wait(mMaxWaitTime, TimeUnit.SECONDS);
        Assert.fail();
    }

    /**
     * Sends a machine state revision insert timeout.
     *
     * @throws JsonProcessingException When unable to transform an object into a JSON string.
     * @throws InterruptedException    When thread is interrupted while waiting.
     * @throws TimeoutException        When a timeout occurs.
     */
    @Test
    public void sendMachineStateRevisionInsertTimeout() throws JsonProcessingException, InterruptedException, TimeoutException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        this.expectTimeout();
        final MachineStateRevisionInsertCommandRequest commandRequest = new MachineStateRevisionInsertCommandRequest(new MachineStateCommandDataWSModel(),
                                                                                                                     new Date());
        final AbstractTestCommandCallback<MachineStateRevisionInsertCommandRequest, MachineStateRevisionInsertCommandDataWsModel> commandCallback = new AbstractTestCommandCallback<MachineStateRevisionInsertCommandRequest, MachineStateRevisionInsertCommandDataWsModel>() {
            @Override
            public void onResponse(MachineStateRevisionInsertCommandRequest request, MachineStateRevisionInsertCommandDataWsModel model) {
                this.success();
            }
        };

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mCommandClientAsync.sendMachineStateRevisionInsertCommand(commandRequest, commandCallback);
        commandCallback.wait(mMaxWaitTime, TimeUnit.SECONDS);
        Assert.fail();
    }

    /**
     * Sends a machine stroke timeout.
     *
     * @throws JsonProcessingException When unable to transform an object into a JSON string.
     * @throws InterruptedException    When thread is interrupted while waiting.
     * @throws TimeoutException        When a timeout occurs.
     */
    @Test
    public void sendMachineStrokeTimeout() throws JsonProcessingException, InterruptedException, TimeoutException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        this.expectTimeout();
        final MachineStrokeCommandRequest commandRequest = new MachineStrokeCommandRequest("machineId", (short) 0, 0);
        final AbstractTestCommandCallback<MachineStrokeCommandRequest, MachineStrokeCommandDataWSModel> commandCallback = new AbstractTestCommandCallback<MachineStrokeCommandRequest, MachineStrokeCommandDataWSModel>() {
            @Override
            public void onResponse(MachineStrokeCommandRequest request, MachineStrokeCommandDataWSModel model) {
                this.success();
            }
        };

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mCommandClientAsync.sendMachineStrokeCommand(commandRequest, commandCallback);
        commandCallback.wait(mMaxWaitTime, TimeUnit.SECONDS);
        Assert.fail();
    }

    /**
     * Sends an operation phase error.
     *
     * @throws JsonProcessingException When unable to transform an object into a JSON string.
     * @throws InterruptedException    When thread is interrupted while waiting.
     * @throws TimeoutException        When a timeout occurs.
     */
    @Test
    public void sendOperationPhaseError() throws JsonProcessingException, InterruptedException, TimeoutException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        this.prepareErrorResponse();
        this.expectTimeout();
        final OperationPhaseCommandRequest commandRequest = new OperationPhaseCommandRequest("operationId", "workplaceId", OperationPhase.SETUP);
        final AbstractTestCommandCallback<OperationPhaseCommandRequest, OperationPhaseCommandDataWsModel> commandCallback = new AbstractTestCommandCallback<OperationPhaseCommandRequest, OperationPhaseCommandDataWsModel>() {
            @Override
            public void onResponse(OperationPhaseCommandRequest request, OperationPhaseCommandDataWsModel model) {
                this.success();
            }
        };

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mCommandClientAsync.sendOperationPhaseCommand(commandRequest, commandCallback);
        commandCallback.wait(mMaxWaitTime, TimeUnit.SECONDS);
        Assert.fail();
    }

    /**
     * Sends an operation quantity error.
     *
     * @throws JsonProcessingException When unable to transform an object into a JSON string.
     * @throws InterruptedException    When thread is interrupted while waiting.
     * @throws TimeoutException        When a timeout occurs.
     */
    @Test
    public void sendOperationQuantityError() throws JsonProcessingException, InterruptedException, TimeoutException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        this.prepareErrorResponse();
        this.expectTimeout();
        final OperationQuantityCommandRequest commandRequest = new OperationQuantityCommandRequest("operationId", "workplaceId", 0, "qualityDetailId");
        final AbstractTestCommandCallback<OperationQuantityCommandRequest, OperationQuantityCommandDataWsModel> commandCallback = new AbstractTestCommandCallback<OperationQuantityCommandRequest, OperationQuantityCommandDataWsModel>() {
            @Override
            public void onResponse(OperationQuantityCommandRequest request, OperationQuantityCommandDataWsModel model) {
                this.success();
            }
        };

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mCommandClientAsync.sendOperationQuantityCommand(commandRequest, commandCallback);
        commandCallback.wait(mMaxWaitTime, TimeUnit.SECONDS);
        Assert.fail();
    }

    /**
     * Sends a machine count error.
     *
     * @throws JsonProcessingException When unable to transform an object into a JSON string.
     * @throws InterruptedException    When thread is interrupted while waiting.
     * @throws TimeoutException        When a timeout occurs.
     */
    @Test
    public void sendMachineCountError() throws JsonProcessingException, InterruptedException, TimeoutException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        this.prepareErrorResponse();
        this.expectTimeout();
        final MachineCountCommandRequest commandRequest = new MachineCountCommandRequest("machineId", 0, 0);
        final AbstractTestCommandCallback<MachineCountCommandRequest, MachineCountCommandDataWSModel> commandCallback = new AbstractTestCommandCallback<MachineCountCommandRequest, MachineCountCommandDataWSModel>() {
            @Override
            public void onResponse(MachineCountCommandRequest request, MachineCountCommandDataWSModel model) {
                this.success();
            }
        };

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mCommandClientAsync.sendMachineCountCommand(commandRequest, commandCallback);
        commandCallback.wait(mMaxWaitTime, TimeUnit.SECONDS);
        Assert.fail();
    }

    /**
     * Sends a machine quantity error.
     *
     * @throws JsonProcessingException When unable to transform an object into a JSON string.
     * @throws InterruptedException    When thread is interrupted while waiting.
     * @throws TimeoutException        When a timeout occurs.
     */
    @Test
    public void sendMachineQuantityError() throws JsonProcessingException, InterruptedException, TimeoutException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        this.prepareErrorResponse();
        this.expectTimeout();
        final MachineQuantityCommandRequest commandRequest = new MachineQuantityCommandRequest("machineId", 0, "qualityDetailId");
        final AbstractTestCommandCallback<MachineQuantityCommandRequest, MachineQuantityCommandDataWSModel> commandCallback = new AbstractTestCommandCallback<MachineQuantityCommandRequest, MachineQuantityCommandDataWSModel>() {
            @Override
            public void onResponse(MachineQuantityCommandRequest request, MachineQuantityCommandDataWSModel model) {
                this.success();
            }
        };

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mCommandClientAsync.sendMachineQuantityCommand(commandRequest, commandCallback);
        commandCallback.wait(mMaxWaitTime, TimeUnit.SECONDS);
        Assert.fail();
    }

    /**
     * Sends a machine state error.
     *
     * @throws JsonProcessingException When unable to transform an object into a JSON string.
     * @throws InterruptedException    When thread is interrupted while waiting.
     * @throws TimeoutException        When a timeout occurs.
     */
    @Test
    public void sendMachineStateError() throws JsonProcessingException, InterruptedException, TimeoutException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        this.prepareErrorResponse();
        this.expectTimeout();
        final MachineStateCommandRequest commandRequest = new MachineStateCommandRequest("machineId", MachineState.PRODUCTION);
        final AbstractTestCommandCallback<MachineStateCommandRequest, MachineStateCommandDataWSModel> commandCallback = new AbstractTestCommandCallback<MachineStateCommandRequest, MachineStateCommandDataWSModel>() {
            @Override
            public void onResponse(MachineStateCommandRequest request, MachineStateCommandDataWSModel model) {
                this.success();
            }
        };

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mCommandClientAsync.sendMachineStateCommand(commandRequest, commandCallback);
        commandCallback.wait(mMaxWaitTime, TimeUnit.SECONDS);
        Assert.fail();
    }

    /**
     * Sends a machine state revision insert error.
     *
     * @throws JsonProcessingException When unable to transform an object into a JSON string.
     * @throws InterruptedException    When thread is interrupted while waiting.
     * @throws TimeoutException        When a timeout occurs.
     */
    @Test
    public void sendMachineStateRevisionInsertError() throws JsonProcessingException, InterruptedException, TimeoutException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        this.prepareErrorResponse();
        this.expectTimeout();
        final MachineStateRevisionInsertCommandRequest commandRequest = new MachineStateRevisionInsertCommandRequest(new MachineStateCommandDataWSModel(),
                                                                                                                     new Date());
        final AbstractTestCommandCallback<MachineStateRevisionInsertCommandRequest, MachineStateRevisionInsertCommandDataWsModel> commandCallback = new AbstractTestCommandCallback<MachineStateRevisionInsertCommandRequest, MachineStateRevisionInsertCommandDataWsModel>() {
            @Override
            public void onResponse(MachineStateRevisionInsertCommandRequest request, MachineStateRevisionInsertCommandDataWsModel model) {
                this.success();
            }
        };

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mCommandClientAsync.sendMachineStateRevisionInsertCommand(commandRequest, commandCallback);
        commandCallback.wait(mMaxWaitTime, TimeUnit.SECONDS);
        Assert.fail();
    }

    /**
     * Sends a machine stroke error.
     *
     * @throws JsonProcessingException When unable to transform an object into a JSON string.
     * @throws InterruptedException    When thread is interrupted while waiting.
     * @throws TimeoutException        When a timeout occurs.
     */
    @Test
    public void testMachineStrokeError() throws JsonProcessingException, InterruptedException, TimeoutException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        this.prepareErrorResponse();
        this.expectTimeout();
        final MachineStrokeCommandRequest commandRequest = new MachineStrokeCommandRequest("machineId", (short) 0, 0);
        final AbstractTestCommandCallback<MachineStrokeCommandRequest, MachineStrokeCommandDataWSModel> commandCallback = new AbstractTestCommandCallback<MachineStrokeCommandRequest, MachineStrokeCommandDataWSModel>() {
            @Override
            public void onResponse(MachineStrokeCommandRequest request, MachineStrokeCommandDataWSModel model) {
                this.success();
            }
        };

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mCommandClientAsync.sendMachineStrokeCommand(commandRequest, commandCallback);
        commandCallback.wait(mMaxWaitTime, TimeUnit.SECONDS);
        Assert.fail();
    }

    /**
     * Prepares {@link TimeoutException} as the expected exception.
     */
    private void expectTimeout() {
        mExpectedException.expect(TimeoutException.class);
        mExpectedException.expectMessage("Timeout after " + mMaxWaitTime + " " + TimeUnit.SECONDS);
    }
}