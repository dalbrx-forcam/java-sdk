////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 14.09.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.command;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.forcam.na.ffwebservices.client.api.config.GuiceTestRunner;
import com.forcam.na.ffwebservices.client.api.exception.ForceAPIErrorMessageException;
import com.forcam.na.ffwebservices.client.api.exception.ForceAPIException;
import com.forcam.na.ffwebservices.model.command.AbstractCommandDataWSModel;
import com.forcam.na.ffwebservices.model.command.AbstractCommandRequest;
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
import com.forcam.na.ffwebservices.model.command.operation.CommandRequest;
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

/**
 * Tests for the class {@link CommandClient}.
 */
@RunWith(GuiceTestRunner.class)
public class CommandClientTest extends AbstractCommandClientTest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The command client. */
    private ICommandClient mCommandClient;

    // ------------------------------------------------------------------------
    // constructor
    // ------------------------------------------------------------------------

    public CommandClientTest() {
        mCommandClient = mBridgeAPIComponent.commandClient();
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    /**
     * Test for the method {@link CommandClient#sendOperationPhaseCommand(OperationPhaseCommandRequest)}.
     *
     * @throws ForceAPIException    When unable to send operation phase command.
     * @throws IOException          When unable to convert the command response to a JSON string.
     * @throws InterruptedException When unable to take the request from the server.
     */
    @Test
    public void sendOperationPhaseCommand() throws ForceAPIException, IOException, InterruptedException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final OperationPhaseCommandDataWsModel commandDataModel = new OperationPhaseCommandDataWsModel();
        final OperationPhaseCommandRequest commandRequest = this.prepareOperationPhaseCommand(commandDataModel);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final CommandResponse<OperationPhaseCommandDataWsModel> responseModel = mCommandClient.sendOperationPhaseCommand(commandRequest);

        this.verifyRequest(commandDataModel, OperationPhaseCommandDataWsModel.class);
        this.verifyResponseModel(commandDataModel, responseModel);
    }

    /**
     * Test for the method {@link CommandClient#sendMachineCountCommand(MachineCountCommandRequest)}.
     *
     * @throws ForceAPIException    When unable to send machine count command.
     * @throws IOException          When unable to convert the command model to a JSON string.
     * @throws InterruptedException When unable to take the request from the server.
     */
    @Test
    public void sendMachineCountCommand() throws ForceAPIException, IOException, InterruptedException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final MachineCountCommandDataWSModel commandDataModel = new MachineCountCommandDataWSModel();
        final MachineCountCommandRequest commandRequest = this.prepareMachineCountCommand(commandDataModel);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final CommandResponse<MachineCountCommandDataWSModel> responseModel = mCommandClient.sendMachineCountCommand(commandRequest);

        this.verifyRequest(commandDataModel, MachineCountCommandDataWSModel.class);
        this.verifyResponseModel(commandDataModel, responseModel);
    }

    /**
     * Test for the method {@link CommandClient#sendMachineQuantityCommand(MachineQuantityCommandRequest)}.
     *
     * @throws ForceAPIException    When unable to send machine quantity command.
     * @throws IOException          When unable to convert the command model to a JSON string.
     * @throws InterruptedException When unable to take the request from the server.
     */
    @Test
    public void sendMachineQuantityCommand() throws ForceAPIException, IOException, InterruptedException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final MachineQuantityCommandDataWSModel commandDataModel = new MachineQuantityCommandDataWSModel();
        final MachineQuantityCommandRequest commandRequest = this.prepareMachineQuantityCommand(commandDataModel);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final CommandResponse<MachineQuantityCommandDataWSModel> responseModel = mCommandClient.sendMachineQuantityCommand(commandRequest);

        this.verifyRequest(commandDataModel, MachineQuantityCommandDataWSModel.class);
        this.verifyResponseModel(commandDataModel, responseModel);
    }

    /**
     * Test for the method {@link CommandClient#sendMachineStateCommand(MachineStateCommandRequest)}.
     *
     * @throws ForceAPIException    When unable to send machine state command.
     * @throws IOException          When unable to convert the command model to a JSON string.
     * @throws InterruptedException When unable to take the request from the server.
     */
    @Test
    public void sendMachineStateCommand() throws ForceAPIException, IOException, InterruptedException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final MachineStateCommandDataWSModel commandDataModel = new MachineStateCommandDataWSModel();
        final MachineStateCommandRequest commandRequest = this.prepareMachineStateCommand(commandDataModel);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final CommandResponse<MachineStateCommandDataWSModel> responseModel = mCommandClient.sendMachineStateCommand(commandRequest);

        this.verifyRequest(commandDataModel, MachineStateCommandDataWSModel.class);
        this.verifyResponseModel(commandDataModel, responseModel);
    }

    /**
     * Test for the method {@link CommandClient#sendMachineStateRevisionInsertCommand(MachineStateRevisionInsertCommandRequest)}.
     *
     * @throws ForceAPIException    When unable to send machine state revision insert command.
     * @throws IOException          When unable to convert the command model to a JSON string.
     * @throws InterruptedException When unable to take the request from the server.
     */
    @Test
    public void sendMachineStateRevisionInsertCommand() throws ForceAPIException, IOException, InterruptedException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final MachineStateRevisionInsertCommandDataWsModel commandDataModel = new MachineStateRevisionInsertCommandDataWsModel();
        final MachineStateRevisionInsertCommandRequest commandRequest = this.prepareMachineStateRevisionInsertCommand(commandDataModel);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final CommandResponse<MachineStateRevisionInsertCommandDataWsModel> responseModel = mCommandClient.sendMachineStateRevisionInsertCommand(commandRequest);

        this.verifyRequest(commandDataModel, MachineStateRevisionInsertCommandDataWsModel.class);
        this.verifyResponseModel(commandDataModel, responseModel);
    }

    /**
     * Test for the method {@link CommandClient#sendOperationPhaseRevisionInsertCommand(OperationPhaseRevisionInsertCommandRequest)}.
     *
     * @throws ForceAPIException    When unable to send operation phase revision insert command.
     * @throws IOException          When unable to convert the command model to a JSON string.
     * @throws InterruptedException When unable to take the request from the server.
     */
    @Test
    public void sendOperationPhaseRevisionInsertCommand() throws ForceAPIException, IOException, InterruptedException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final OperationPhaseRevisionInsertCommandDataWsModel commandDataModel = new OperationPhaseRevisionInsertCommandDataWsModel();
        final OperationPhaseRevisionInsertCommandRequest commandRequest = this.prepareOperationPhaseRevisionInsertCommand(commandDataModel);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final CommandResponse<OperationPhaseRevisionInsertCommandDataWsModel> responseModel = mCommandClient.sendOperationPhaseRevisionInsertCommand(
            commandRequest);

        this.verifyRequest(commandDataModel, OperationPhaseRevisionInsertCommandDataWsModel.class);
        this.verifyResponseModel(commandDataModel, responseModel);
    }

    /**
     * Test for the method {@link CommandClient#sendMachineStrokeCommand(MachineStrokeCommandRequest)}.
     *
     * @throws ForceAPIException    When unable to send machine stroke command.
     * @throws IOException          When unable to convert the command model to a JSON string.
     * @throws InterruptedException When unable to take the request from the server.
     */
    @Test
    public void sendMachineStrokeCommand() throws ForceAPIException, IOException, InterruptedException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final MachineStrokeCommandDataWSModel commandDataModel = new MachineStrokeCommandDataWSModel();
        final MachineStrokeCommandRequest commandRequest = this.prepareMachineStrokeCommand(commandDataModel);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final CommandResponse<MachineStrokeCommandDataWSModel> responseModel = mCommandClient.sendMachineStrokeCommand(commandRequest);

        this.verifyRequest(commandDataModel, MachineStrokeCommandDataWSModel.class);
        this.verifyResponseModel(commandDataModel, responseModel);
    }

    /**
     * Test for the method {@link CommandClient#sendOperationQuantityCommand(OperationQuantityCommandRequest)}.
     *
     * @throws ForceAPIException    When unable to send operation quantity command.
     * @throws IOException          When unable to convert the command model to a JSON string.
     * @throws InterruptedException When unable to take the request from the server.
     */
    @Test
    public void sendOperationQuantityCommand() throws ForceAPIException, IOException, InterruptedException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final OperationQuantityCommandDataWsModel commandDataModel = new OperationQuantityCommandDataWsModel();
        final OperationQuantityCommandRequest commandRequest = this.prepareOperationQuantityCommand(commandDataModel);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final CommandResponse<OperationQuantityCommandDataWsModel> responseModel = mCommandClient.sendOperationQuantityCommand(commandRequest);

        this.verifyRequest(commandDataModel, OperationQuantityCommandDataWsModel.class);
        this.verifyResponseModel(commandDataModel, responseModel);
    }

    /**
     * Sends an operation phase error.
     *
     * @throws JsonProcessingException When unable to transform an object into a JSON string.
     * @throws ForceAPIException       When unable to send operation phase command.
     */
    @Test
    public void sendOperationPhaseError() throws JsonProcessingException, ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        this.prepareErrorResponse();
        final OperationPhaseCommandRequest commandRequest = new OperationPhaseCommandRequest("operationId", "workplaceId", OperationPhase.SETUP);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        try {
            mCommandClient.sendOperationPhaseCommand(commandRequest);
            Assert.fail();
        } catch (ForceAPIErrorMessageException e) {
            Assert.assertEquals(errorCode,
                                e
                                    .getMessageWSModel()
                                    .getCode());
            Assert.assertEquals(errorMessage,
                                e
                                    .getMessageWSModel()
                                    .getMessage());
            Assert.assertEquals(errorStatus,
                                e
                                    .getMessageWSModel()
                                    .getStatus());
        }
    }

    /**
     * Sends a machine count error.
     *
     * @throws JsonProcessingException When unable to transform an object into a JSON string.
     * @throws ForceAPIException       When unable to send machine count command.
     */
    @Test
    public void sendMachineCountError() throws JsonProcessingException, ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        this.prepareErrorResponse();
        final MachineCountCommandRequest commandRequest = new MachineCountCommandRequest("machineId", 0, 0);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        try {
            mCommandClient.sendMachineCountCommand(commandRequest);
            Assert.fail();
        } catch (ForceAPIErrorMessageException e) {
            Assert.assertEquals(errorCode,
                                e
                                    .getMessageWSModel()
                                    .getCode());
            Assert.assertEquals(errorMessage,
                                e
                                    .getMessageWSModel()
                                    .getMessage());
            Assert.assertEquals(errorStatus,
                                e
                                    .getMessageWSModel()
                                    .getStatus());
        }
    }

    /**
     * Sends a machine quantity error.
     *
     * @throws JsonProcessingException When unable to transform an object into a JSON string.
     * @throws ForceAPIException       When unable to send machine quantity command.
     */
    @Test
    public void sendMachineQuantityError() throws JsonProcessingException, ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        this.prepareErrorResponse();
        final MachineQuantityCommandRequest commandRequest = new MachineQuantityCommandRequest("machineId", 0, "qualityDetailId");

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        try {
            mCommandClient.sendMachineQuantityCommand(commandRequest);
            Assert.fail();
        } catch (ForceAPIErrorMessageException e) {
            Assert.assertEquals(errorCode,
                                e
                                    .getMessageWSModel()
                                    .getCode());
            Assert.assertEquals(errorMessage,
                                e
                                    .getMessageWSModel()
                                    .getMessage());
            Assert.assertEquals(errorStatus,
                                e
                                    .getMessageWSModel()
                                    .getStatus());
        }
    }

    /**
     * Sends a machine state error.
     *
     * @throws JsonProcessingException When unable to transform an object into a JSON string.
     * @throws ForceAPIException       When unable to send machine state command.
     */
    @Test
    public void sendMachineStateError() throws JsonProcessingException, ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        this.prepareErrorResponse();
        final MachineStateCommandRequest commandRequest = new MachineStateCommandRequest("machineId", MachineState.PRODUCTION);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        try {
            mCommandClient.sendMachineStateCommand(commandRequest);
            Assert.fail();
        } catch (ForceAPIErrorMessageException e) {
            Assert.assertEquals(errorCode,
                                e
                                    .getMessageWSModel()
                                    .getCode());
            Assert.assertEquals(errorMessage,
                                e
                                    .getMessageWSModel()
                                    .getMessage());
            Assert.assertEquals(errorStatus,
                                e
                                    .getMessageWSModel()
                                    .getStatus());
        }
    }

    /**
     * Sends a machine state revision insert error.
     *
     * @throws JsonProcessingException When unable to transform an object into a JSON string.
     * @throws ForceAPIException       When unable to send machine state revision insert command.
     */
    @Test
    public void sendMachineStateRevisionInsertError() throws JsonProcessingException, ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        this.prepareErrorResponse();
        final MachineStateRevisionInsertCommandRequest commandRequest = new MachineStateRevisionInsertCommandRequest(new MachineStateCommandDataWSModel(),
                                                                                                                     new Date());

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        try {
            mCommandClient.sendMachineStateRevisionInsertCommand(commandRequest);
            Assert.fail();
        } catch (ForceAPIErrorMessageException e) {
            Assert.assertEquals(errorCode,
                                e
                                    .getMessageWSModel()
                                    .getCode());
            Assert.assertEquals(errorMessage,
                                e
                                    .getMessageWSModel()
                                    .getMessage());
            Assert.assertEquals(errorStatus,
                                e
                                    .getMessageWSModel()
                                    .getStatus());
        }
    }

    /**
     * Sends a machine stroke error.
     *
     * @throws JsonProcessingException When unable to transform an object into a JSON string.
     * @throws ForceAPIException       When unable to send machine stroke command.
     */
    @Test
    public void sendMachineStrokeError() throws JsonProcessingException, ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        this.prepareErrorResponse();
        final MachineStrokeCommandRequest commandRequest = new MachineStrokeCommandRequest("machineId", (short) 0, 0);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        try {
            mCommandClient.sendMachineStrokeCommand(commandRequest);
            Assert.fail();
        } catch (ForceAPIErrorMessageException e) {
            Assert.assertEquals(errorCode,
                                e
                                    .getMessageWSModel()
                                    .getCode());
            Assert.assertEquals(errorMessage,
                                e
                                    .getMessageWSModel()
                                    .getMessage());
            Assert.assertEquals(errorStatus,
                                e
                                    .getMessageWSModel()
                                    .getStatus());
        }
    }

    /**
     * Sends an operation quantity error.
     *
     * @throws JsonProcessingException When unable to transform an object into a JSON string.
     * @throws ForceAPIException       When unable to send operation quantity command.
     */
    @Test
    public void sendOperationQuantityError() throws JsonProcessingException, ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        this.prepareErrorResponse();
        final OperationQuantityCommandRequest commandRequest = new OperationQuantityCommandRequest("operationId", "workplaceId", 0, "qualityDetailId");

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        try {
            mCommandClient.sendOperationQuantityCommand(commandRequest);
            Assert.fail();
        } catch (ForceAPIErrorMessageException e) {
            Assert.assertEquals(errorCode,
                                e
                                    .getMessageWSModel()
                                    .getCode());
            Assert.assertEquals(errorMessage,
                                e
                                    .getMessageWSModel()
                                    .getMessage());
            Assert.assertEquals(errorStatus,
                                e
                                    .getMessageWSModel()
                                    .getStatus());
        }
    }

    /**
     * Tests sending operation phase command while server is down.
     *
     * @throws IOException       When unable to shutdown the mock server.
     * @throws ForceAPIException When unable to send operation phase command.
     */
    @Test
    public void sendOperationPhaseShutdown() throws IOException, ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final OperationPhaseCommandRequest commandRequest = new OperationPhaseCommandRequest("operationId", "workplaceId", OperationPhase.SETUP);
        this.prepareServerShutdown(commandRequest);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mCommandClient.sendOperationPhaseCommand(commandRequest);
    }

    /**
     * Tests sending machine count command while server is down.
     *
     * @throws IOException       When unable to shutdown the mock server.
     * @throws ForceAPIException When unable to send machine count command.
     */
    @Test
    public void sendMachineCountShutdown() throws IOException, ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final MachineCountCommandRequest commandRequest = new MachineCountCommandRequest("machineId", 0, 0);
        this.prepareServerShutdown(commandRequest);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mCommandClient.sendMachineCountCommand(commandRequest);
    }

    /**
     * Tests sending machine quantity command while server is down.
     *
     * @throws IOException       When unable to shutdown the mock server.
     * @throws ForceAPIException When unable to send machine quantity command.
     */
    @Test
    public void sendMachineQuantityShutdown() throws IOException, ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final MachineQuantityCommandRequest commandRequest = new MachineQuantityCommandRequest("machineId", 0, "qualitydetailId");
        this.prepareServerShutdown(commandRequest);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mCommandClient.sendMachineQuantityCommand(commandRequest);
    }

    /**
     * Tests sending machine state command while server is down.
     *
     * @throws IOException       When unable to shutdown the mock server.
     * @throws ForceAPIException When unable to send machine state command.
     */
    @Test
    public void sendMachineStateShutdown() throws IOException, ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final MachineStateCommandRequest commandRequest = new MachineStateCommandRequest("machineId", MachineState.PRODUCTION);
        this.prepareServerShutdown(commandRequest);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mCommandClient.sendMachineStateCommand(commandRequest);
    }

    /**
     * Tests sending machine state revision insert command while server is down.
     *
     * @throws IOException       When unable to shutdown the mock server.
     * @throws ForceAPIException When unable to send machine state revision insert command.
     */
    @Test
    public void sendMachineStateRevisionInsertShutdown() throws IOException, ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final MachineStateRevisionInsertCommandRequest commandRequest = new MachineStateRevisionInsertCommandRequest(new MachineStateCommandDataWSModel(),
                                                                                                                     new Date());
        this.prepareServerShutdown(commandRequest);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mCommandClient.sendMachineStateRevisionInsertCommand(commandRequest);
    }

    /**
     * Tests sending machine stroke command while server is down.
     *
     * @throws IOException       When unable to shutdown the mock server.
     * @throws ForceAPIException When unable to send machine stroke command.
     */
    @Test
    public void sendMachineStrokeShutdown() throws IOException, ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final MachineStrokeCommandRequest commandRequest = new MachineStrokeCommandRequest("machineId", (short) 0, 0);
        this.prepareServerShutdown(commandRequest);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mCommandClient.sendMachineStrokeCommand(commandRequest);
    }

    /**
     * Tests sending operation quantity command while server is down.
     *
     * @throws IOException       When unable to shutdown the mock server.
     * @throws ForceAPIException When unable to send operation quantity command.
     */
    @Test
    public void sendOperationQuantityShutdown() throws IOException, ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final OperationQuantityCommandRequest commandRequest = new OperationQuantityCommandRequest("operationId", "workplaceId", 0, "qualityDetailId");
        this.prepareServerShutdown(commandRequest);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mCommandClient.sendOperationQuantityCommand(commandRequest);
    }

    /**
     * Verifies the response model sent by the server.
     *
     * @param commandDataModel The command data model.
     * @param responseModel    The command response.
     * @param <T>              The type of the command data model.
     */
    private <T extends AbstractCommandDataWSModel> void verifyResponseModel(T commandDataModel, CommandResponse<T> responseModel) {
        Assert.assertNotNull(responseModel);
        Assert.assertNotNull(responseModel.getProperties());
        Assert.assertEquals(commandId,
                            responseModel
                                .getProperties()
                                .getId());
        Assert.assertEquals(resultCode,
                            responseModel
                                .getProperties()
                                .getResultCode());
        Assert.assertEquals(date,
                            responseModel
                                .getProperties()
                                .getTimestamp());
        Assert.assertEquals(commandDataModel,
                            responseModel
                                .getProperties()
                                .getData());
    }

    /**
     * Shutdown of the mock server.
     *
     * @param commandRequest The command request.
     * @param <T>            The type of the command request.
     * @throws IOException When unable to shutdown the mock server.
     */
    private <T extends AbstractCommandRequest> void prepareServerShutdown(T commandRequest) throws IOException {
        mMockWebServer.shutdown();
        mExpectedException.expect(ForceAPIException.class);
        mExpectedException.expectMessage("Unable to execute call using request: " + commandRequest);
    }

    /**
     * Test for the method {@link CommandClient#sendOperationQuantityRevisionInsertCommand(OperationQuantityRevisionInsertCommandRequest)}.
     *
     * @throws ForceAPIException    When unable to send operation quantity revision insert command.
     * @throws IOException          When unable to convert the command model to a JSON string.
     * @throws InterruptedException When unable to take the request from the server.
     */
    @Test
    public void sendOperationQuantityRevisionInsertCommand() throws ForceAPIException, IOException, InterruptedException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final OperationQuantityRevisionInsertCommandDataWsModel commandDataModel = new OperationQuantityRevisionInsertCommandDataWsModel();
        final OperationQuantityRevisionInsertCommandRequest commandRequest = this.prepareOperationQuantityRevisionInsertCommand(commandDataModel);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final CommandResponse<OperationQuantityRevisionInsertCommandDataWsModel> responseModel = mCommandClient.sendOperationQuantityRevisionInsertCommand(
            commandRequest);

        this.verifyRequest(commandDataModel, OperationQuantityRevisionInsertCommandDataWsModel.class);
        this.verifyResponseModel(commandDataModel, responseModel);
    }

    @Test
    public void sendCommand() throws ForceAPIException, IOException, InterruptedException {

        final OperationPhaseCommandDataWsModel operationPhaseCommand = new OperationPhaseCommandDataWsModel();
        operationPhaseCommand.setOperationId("operationId");
        operationPhaseCommand.setWorkplaceId("workplaceId");
        operationPhaseCommand.setOperationPhaseId(OperationPhase.PROCESSING);

        final CommandRequest<OperationPhaseCommandDataWsModel> operationPhaseRequest = new CommandRequest<>(operationPhaseCommand);

        prepareOperationPhaseCommand(operationPhaseCommand);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final CommandResponse<OperationPhaseCommandDataWsModel> commandResponse = mCommandClient.sendCommand(operationPhaseRequest);
        this.verifyRequest(operationPhaseCommand, OperationPhaseCommandDataWsModel.class);
        this.verifyResponseModel(operationPhaseCommand, commandResponse);
    }
}