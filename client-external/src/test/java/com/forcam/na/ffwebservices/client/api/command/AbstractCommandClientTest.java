////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 30.10.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.command;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.forcam.na.ffwebservices.client.api.AbstractOpenAPIMockTest;
import com.forcam.na.common.webservices.model.ErrorMessageWSModel;
import com.forcam.na.ffwebservices.model.command.AbstractCommandDataWSModel;
import com.forcam.na.ffwebservices.model.command.CommandPropertiesWSModel;
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
import com.forcam.na.ffwebservices.model.definition.MachineState;
import com.forcam.na.ffwebservices.model.definition.OperationPhase;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.RecordedRequest;
import org.apache.commons.lang3.StringUtils;
import org.junit.*;
import org.junit.rules.*;

import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Contains common code for {@link CommandClientTest and {@link CommandClientAsyncTest}.
 */
public class AbstractCommandClientTest extends AbstractOpenAPIMockTest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The id of the command. */
    String commandId;

    /** The code of the result. */
    String resultCode;

    /** A date. */
    final Date date = new Date();

    /** Helper for test exceptions and messages. */
    @Rule
    public ExpectedException mExpectedException = ExpectedException.none();

    /** The error code. */
    final String errorCode = "code";

    /** The error message. */
    final String errorMessage = "errorMessage";

    /** The error status. */
    final int errorStatus = 500;

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    /**
     * Prepares the mock server response and returns a matching {@link OperationPhaseCommandRequest}.
     *
     * @param commandDataModel An operation phase data model.
     * @return An operation phase command request.
     * @throws IOException When unable to convert the command response to a JSON string.
     */
    @SuppressWarnings("unchecked")
    OperationPhaseCommandRequest prepareOperationPhaseCommand(OperationPhaseCommandDataWsModel commandDataModel) throws IOException {
        commandId = "4d9db0f0994611e78ecedf620a307103";
        resultCode = "RC_SIMPLE_SUCCESS";
        final String workplaceId = "9E8E9851FB144E0DA266D9EBF7DA8642";
        final String operationId = "93F9CECC1EC0418DBFF8B3E63850AC8B";
        final OperationPhase operationPhase = OperationPhase.SETUP;

        commandDataModel.setOperationPhaseId(operationPhase);
        commandDataModel.setWorkplaceId(workplaceId);
        commandDataModel.setOperationId(operationId);

        final CommandPropertiesWSModel commandPropertiesWSModel = new CommandPropertiesWSModel();
        commandPropertiesWSModel.setId(commandId);
        commandPropertiesWSModel.setResultCode(resultCode);
        commandPropertiesWSModel.setTimestamp(date);
        commandPropertiesWSModel.setData(commandDataModel);

        final CommandResponse<OperationPhaseCommandDataWsModel> commandResponse = new CommandResponse();
        commandResponse.setProperties(commandPropertiesWSModel);

        final String jsonResponse = mMapper.writeValueAsString(commandResponse);
        mMockWebServer.enqueue(new MockResponse().setBody(jsonResponse));

        return new OperationPhaseCommandRequest(operationId, workplaceId, operationPhase);
    }

    /**
     * Prepares the mock server response and returns a matching {@link OperationPhaseRevisionInsertCommandRequest}.
     *
     * @param commandDataModel A operation phase revision insert data model.
     * @return A operation phase revision insert command request.
     * @throws IOException When unable to convert the command response to a JSON string.
     */
    @SuppressWarnings("unchecked")
    OperationPhaseRevisionInsertCommandRequest prepareOperationPhaseRevisionInsertCommand(OperationPhaseRevisionInsertCommandDataWsModel commandDataModel)
        throws IOException {
        commandId = "3d63d7c09f6b11e7bb37d3e30a307103";
        resultCode = "RC_SIMPLE_SUCCESS";
        final String operationId = "32862114F938457FAE68B58120915F42";
        final String workplaceId = "ED4A94BC1349472688F692B14135797C";
        final OperationPhase operationPhaseId = OperationPhase.PROCESSING;
        final String annotation = StringUtils.EMPTY;
        final Date insertionTimestamp = new Date();

        final OperationPhaseCommandDataWsModel phaseCommandDataModel = new OperationPhaseCommandDataWsModel();
        phaseCommandDataModel.setWorkplaceId(workplaceId);
        phaseCommandDataModel.setOperationId(operationId);
        phaseCommandDataModel.setOperationPhaseId(operationPhaseId);

        commandDataModel.setOperationPhaseCommand(phaseCommandDataModel);
        commandDataModel.setInsertionTimestamp(insertionTimestamp);

        final CommandPropertiesWSModel commandPropertiesWSModel = new CommandPropertiesWSModel();
        commandPropertiesWSModel.setId(commandId);
        commandPropertiesWSModel.setResultCode(resultCode);
        commandPropertiesWSModel.setTimestamp(date);
        commandPropertiesWSModel.setData(commandDataModel);

        final CommandResponse<OperationPhaseRevisionInsertCommandDataWsModel> commandResponse = new CommandResponse();
        commandResponse.setProperties(commandPropertiesWSModel);

        final String jsonResponse = mMapper.writeValueAsString(commandResponse);
        mMockWebServer.enqueue(new MockResponse().setBody(jsonResponse));

        return new OperationPhaseRevisionInsertCommandRequest(phaseCommandDataModel, insertionTimestamp);
    }

    /**
     * Prepares the mock server response and returns a matching {@link OperationQuantityCommandRequest}.
     *
     * @param commandDataModel An operation quantity data model.
     * @return An operation quantity command request.
     * @throws IOException When unable to convert the command response to a JSON string.
     */
    @SuppressWarnings("unchecked")
    OperationQuantityCommandRequest prepareOperationQuantityCommand(OperationQuantityCommandDataWsModel commandDataModel) throws IOException {
        commandId = "c97609d09f6c11e79ebdd3e30a307103";
        resultCode = "RC_SIMPLE_SUCCESS";
        final String workplaceId = "9E8E9851FB144E0DA266D9EBF7DA8642";
        final String operationId = "93F9CECC1EC0418DBFF8B3E63850AC8B";
        final String ticketId = StringUtils.EMPTY;
        final String annotation = StringUtils.EMPTY;
        final double quantity = 2;
        final String qualityDetailId = "628b5d95a5eb468f9f4878f01e27c95b";
        final String staffMemberId = StringUtils.EMPTY;

        commandDataModel.setTicketId(ticketId);
        commandDataModel.setQualityDetailId(qualityDetailId);
        commandDataModel.setQuantity(quantity);
        commandDataModel.setAnnotation(annotation);
        commandDataModel.setStaffMemberId(staffMemberId);
        commandDataModel.setWorkplaceId(workplaceId);
        commandDataModel.setOperationId(operationId);

        final CommandPropertiesWSModel commandPropertiesWSModel = new CommandPropertiesWSModel();
        commandPropertiesWSModel.setId(commandId);
        commandPropertiesWSModel.setResultCode(resultCode);
        commandPropertiesWSModel.setTimestamp(date);
        commandPropertiesWSModel.setData(commandDataModel);

        final CommandResponse<OperationQuantityCommandDataWsModel> commandResponse = new CommandResponse();
        commandResponse.setProperties(commandPropertiesWSModel);

        final String jsonResponse = mMapper.writeValueAsString(commandResponse);
        mMockWebServer.enqueue(new MockResponse().setBody(jsonResponse));

        final OperationQuantityCommandRequest commandRequest = new OperationQuantityCommandRequest(operationId, workplaceId, quantity, qualityDetailId);
        commandRequest.setStaffMemberId(staffMemberId);
        commandRequest.setAnnotation(annotation);
        commandRequest.setTicketId(ticketId);
        return commandRequest;
    }

    /**
     * Prepares the mock server response and returns a matching {@link MachineCountCommandRequest}.
     *
     * @param commandDataModel A machine count data model.
     * @return A machine count command request.
     * @throws IOException When unable to convert the command response to a JSON string.
     */
    @SuppressWarnings("unchecked")
    MachineCountCommandRequest prepareMachineCountCommand(MachineCountCommandDataWSModel commandDataModel) throws IOException {
        commandId = "477dc3609ed011e78df0d3e30a307103";
        resultCode = "RC_NOT_RECEIVED";
        final String machineId = "32862114F938457FAE68B58120915F42";
        final long counterNumber = 1;
        final long count = 1;

        commandDataModel.setMachineId(machineId);
        commandDataModel.setCounterNumber(counterNumber);
        commandDataModel.setCount(count);

        final CommandPropertiesWSModel commandPropertiesWSModel = new CommandPropertiesWSModel();
        commandPropertiesWSModel.setId(commandId);
        commandPropertiesWSModel.setResultCode(resultCode);
        commandPropertiesWSModel.setTimestamp(date);
        commandPropertiesWSModel.setData(commandDataModel);

        final CommandResponse<MachineCountCommandDataWSModel> commandResponse = new CommandResponse();
        commandResponse.setProperties(commandPropertiesWSModel);

        final String jsonResponse = mMapper.writeValueAsString(commandResponse);
        mMockWebServer.enqueue(new MockResponse().setBody(jsonResponse));

        return new MachineCountCommandRequest(machineId, counterNumber, count);
    }

    /**
     * Prepares the mock server response and returns a matching {@link MachineQuantityCommandRequest}.
     *
     * @param commandDataModel A machine quantity data model.
     * @return A machine quantity command request.
     * @throws IOException When unable to convert the command response to a JSON string.
     */
    @SuppressWarnings("unchecked")
    MachineQuantityCommandRequest prepareMachineQuantityCommand(MachineQuantityCommandDataWSModel commandDataModel) throws IOException {
        commandId = "475507e09edf11e79b95d3e30a307103";
        resultCode = "RC_NOT_RECEIVED";
        final String machineId = "32862114F938457FAE68B58120915F42";
        final double quantity = 1;
        final String qualityDetailId = "628b5d95a5eb468f9f4878f01e27c95b";

        commandDataModel.setMachineId(machineId);
        commandDataModel.setQuantity(quantity);
        commandDataModel.setQualityDetailId(qualityDetailId);

        final CommandPropertiesWSModel commandPropertiesWSModel = new CommandPropertiesWSModel();
        commandPropertiesWSModel.setId(commandId);
        commandPropertiesWSModel.setResultCode(resultCode);
        commandPropertiesWSModel.setTimestamp(date);
        commandPropertiesWSModel.setData(commandDataModel);

        final CommandResponse<MachineQuantityCommandDataWSModel> commandResponse = new CommandResponse();
        commandResponse.setProperties(commandPropertiesWSModel);

        final String jsonResponse = mMapper.writeValueAsString(commandResponse);
        mMockWebServer.enqueue(new MockResponse().setBody(jsonResponse));

        return new MachineQuantityCommandRequest(machineId, quantity, qualityDetailId);
    }

    /**
     * Prepares the mock server response and returns a matching {@link MachineStateCommandRequest}.
     *
     * @param commandDataModel A machine state data model.
     * @return A machine state command request.
     * @throws IOException When unable to convert the command response to a JSON string.
     */
    @SuppressWarnings("unchecked")
    MachineStateCommandRequest prepareMachineStateCommand(MachineStateCommandDataWSModel commandDataModel) throws IOException {
        commandId = "2fb115909f6411e7aa59d3e30a307103";
        resultCode = "RC_NOT_RECEIVED";
        final String machineId = "32862114F938457FAE68B58120915F42";
        final MachineState machineStateId = MachineState.PRODUCTION;
        final List<String> machineStateDetailIds = Collections.emptyList();
        final String annotation = StringUtils.EMPTY;

        commandDataModel.setMachineId(machineId);
        commandDataModel.setMachineStateId(machineStateId);
        commandDataModel.setMachineStateDetailIds(machineStateDetailIds);
        commandDataModel.setAnnotation(annotation);

        final CommandPropertiesWSModel commandPropertiesWSModel = new CommandPropertiesWSModel();
        commandPropertiesWSModel.setId(commandId);
        commandPropertiesWSModel.setResultCode(resultCode);
        commandPropertiesWSModel.setTimestamp(date);
        commandPropertiesWSModel.setData(commandDataModel);

        final CommandResponse<MachineStateCommandDataWSModel> commandResponse = new CommandResponse();
        commandResponse.setProperties(commandPropertiesWSModel);

        final String jsonResponse = mMapper.writeValueAsString(commandResponse);
        mMockWebServer.enqueue(new MockResponse().setBody(jsonResponse));

        final MachineStateCommandRequest commandRequest = new MachineStateCommandRequest(machineId, machineStateId);
        commandRequest.setMachineStateDetailIds(machineStateDetailIds);
        commandRequest.setAnnotation(annotation);
        return commandRequest;
    }

    /**
     * Prepares the mock server response and returns a matching {@link MachineStateRevisionInsertCommandRequest}.
     *
     * @param commandDataModel A machine state revision insert data model.
     * @return A machine state revision insert command request.
     * @throws IOException When unable to convert the command response to a JSON string.
     */
    @SuppressWarnings("unchecked")
    MachineStateRevisionInsertCommandRequest prepareMachineStateRevisionInsertCommand(MachineStateRevisionInsertCommandDataWsModel commandDataModel)
        throws IOException {
        commandId = "3d63d7c09f6b11e7bb37d3e30a307103";
        resultCode = "RC_SIMPLE_SUCCESS";
        final String machineId = "32862114F938457FAE68B58120915F42";
        final MachineState machineStateId = MachineState.PRODUCTION;
        final List<String> machineStateDetailIds = Collections.emptyList();
        final String annotation = StringUtils.EMPTY;
        final Date insertionTimestamp = new Date();

        final MachineStateCommandDataWSModel machineStatusDataModel = new MachineStateCommandDataWSModel();
        machineStatusDataModel.setMachineId(machineId);
        machineStatusDataModel.setMachineStateId(machineStateId);
        machineStatusDataModel.setMachineStateDetailIds(machineStateDetailIds);
        machineStatusDataModel.setAnnotation(annotation);

        commandDataModel.setMachineStateCommand(machineStatusDataModel);
        commandDataModel.setInsertionTimestamp(insertionTimestamp);

        final CommandPropertiesWSModel commandPropertiesWSModel = new CommandPropertiesWSModel();
        commandPropertiesWSModel.setId(commandId);
        commandPropertiesWSModel.setResultCode(resultCode);
        commandPropertiesWSModel.setTimestamp(date);
        commandPropertiesWSModel.setData(commandDataModel);

        final CommandResponse<MachineStateRevisionInsertCommandDataWsModel> commandResponse = new CommandResponse();
        commandResponse.setProperties(commandPropertiesWSModel);

        final String jsonResponse = mMapper.writeValueAsString(commandResponse);
        mMockWebServer.enqueue(new MockResponse().setBody(jsonResponse));

        return new MachineStateRevisionInsertCommandRequest(machineStatusDataModel, insertionTimestamp);
    }

    /**
     * Prepares the mock server response and returns a matching {@link MachineStrokeCommandRequest}.
     *
     * @param commandDataModel A machine stroke data model.
     * @return A machine stroke command request.
     * @throws IOException When unable to convert the command response to a JSON string.
     */
    @SuppressWarnings("unchecked")
    MachineStrokeCommandRequest prepareMachineStrokeCommand(MachineStrokeCommandDataWSModel commandDataModel) throws IOException {
        commandId = "989666809f6b11e795f9d3e30a307103";
        resultCode = "RC_NOT_RECEIVED";
        final String machineId = "32862114F938457FAE68B58120915F42";
        final short counterNumber = 0;
        final int strokes = 2;

        commandDataModel.setMachineId(machineId);
        commandDataModel.setCounterNumber(counterNumber);
        commandDataModel.setStrokes(strokes);

        final CommandPropertiesWSModel commandPropertiesWSModel = new CommandPropertiesWSModel();
        commandPropertiesWSModel.setId(commandId);
        commandPropertiesWSModel.setResultCode(resultCode);
        commandPropertiesWSModel.setTimestamp(date);
        commandPropertiesWSModel.setData(commandDataModel);

        final CommandResponse<MachineStrokeCommandDataWSModel> commandResponse = new CommandResponse();
        commandResponse.setProperties(commandPropertiesWSModel);

        final String jsonResponse = mMapper.writeValueAsString(commandResponse);
        mMockWebServer.enqueue(new MockResponse().setBody(jsonResponse));

        return new MachineStrokeCommandRequest(machineId, counterNumber, strokes);
    }

    /**
     * Verifies the request that arrived at the server.
     *
     * @param commandDataModel      The command data model.
     * @param commandDataModelClass The class of the command data model.
     * @param <T>                   The type of the command data model.
     * @throws IOException          When unable to convert the response string to a model.
     * @throws InterruptedException When unable to take the request from the server.
     */
    <T extends AbstractCommandDataWSModel> void verifyRequest(T commandDataModel, Class<T> commandDataModelClass) throws IOException, InterruptedException {
        final RecordedRequest request = mMockWebServer.takeRequest();
        final String body = request
            .getBody()
            .readUtf8();
        final T requestModel = mMapper.readValue(body, commandDataModelClass);
        Assert.assertEquals(commandDataModel, requestModel);

        final String requestQuery = request
            .getRequestUrl()
            .query();
        Assert.assertNotNull(requestQuery);
        Assert.assertTrue(requestQuery.contains("async=false"));
    }

    /**
     * Prepares an error response for the mock server.
     *
     * @throws JsonProcessingException When unable to convert the error message model to a JSON string.
     */
    void prepareErrorResponse() throws JsonProcessingException {
        final ErrorMessageWSModel errorMessageModel = new ErrorMessageWSModel();
        errorMessageModel.setCode(errorCode);
        errorMessageModel.setMessage(errorMessage);
        errorMessageModel.setStatus(errorStatus);

        final String jsonResponse = mMapper.writeValueAsString(errorMessageModel);
        mMockWebServer.enqueue(new MockResponse()
                                   .setBody(jsonResponse)
                                   .setResponseCode(errorStatus));
    }

    /**
     * Prepares the mock server response and returns a matching {@link OperationQuantityRevisionInsertCommandRequest}.
     *
     * @param commandDataModel A operation quantity revision insert data model.
     * @return A operation quantity revision insert command request.
     * @throws IOException When unable to convert the command response to a JSON string.
     */
    @SuppressWarnings("unchecked")
    OperationQuantityRevisionInsertCommandRequest prepareOperationQuantityRevisionInsertCommand(
        OperationQuantityRevisionInsertCommandDataWsModel commandDataModel) throws IOException {
        commandId = "3d63d7c09f6b11e7bb37d3e30a307103";
        resultCode = "RC_SIMPLE_SUCCESS";
        final String operationId = "32862114F938457FAE68B58120915F42";
        final double quantityAmount = 1.0;
        final String quantityDetailId = "1F9FD0E9B2594411BC417BE0B7765505";
        final String annotation = StringUtils.EMPTY;
        final Date insertionTimestamp = new Date();

        final OperationQuantityCommandDataWsModel quantityCommandDataModel = new OperationQuantityCommandDataWsModel();
        quantityCommandDataModel.setOperationId(operationId);
        quantityCommandDataModel.setQualityDetailId(quantityDetailId);
        quantityCommandDataModel.setQuantity(quantityAmount);
        quantityCommandDataModel.setAnnotation(annotation);

        commandDataModel.setOperationQuantityCommand(quantityCommandDataModel);
        commandDataModel.setInsertionTimestamp(insertionTimestamp);

        final CommandPropertiesWSModel commandPropertiesWSModel = new CommandPropertiesWSModel();
        commandPropertiesWSModel.setId(commandId);
        commandPropertiesWSModel.setResultCode(resultCode);
        commandPropertiesWSModel.setTimestamp(date);
        commandPropertiesWSModel.setData(commandDataModel);

        final CommandResponse<OperationQuantityRevisionInsertCommandDataWsModel> commandResponse = new CommandResponse();
        commandResponse.setProperties(commandPropertiesWSModel);

        final String jsonResponse = mMapper.writeValueAsString(commandResponse);
        mMockWebServer.enqueue(new MockResponse().setBody(jsonResponse));

        return new OperationQuantityRevisionInsertCommandRequest(quantityCommandDataModel, insertionTimestamp);
    }
}