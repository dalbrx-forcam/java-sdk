////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 12.09.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.command;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.forcam.na.ffwebservices.client.api.exception.ForceAPIException;
import com.forcam.na.ffwebservices.model.command.AbstractCommandDataWSModel;
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
import com.forcam.na.ffwebservices.model.command.workplace.ShiftStateCommandDataWSModel;
import com.forcam.na.ffwebservices.model.command.workplace.ShiftStateCommandRequest;
import retrofit2.Call;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

/**
 * Sends commands and returns the response of the server.
 */
public class CommandClient extends AbstractCommandClient implements ICommandClient {

    // ----------------------------------------------------------------------
    // members
    // ----------------------------------------------------------------------

    public final ObjectMapper mMapper = new ObjectMapper().registerModule(new JavaTimeModule());

    /** Jackson {@link TypeReference} which allows us to convert a object to a {@code Map<String,Object>} */
    private TypeReference<HashMap<String, Object>> mapTypeRef = new TypeReference<HashMap<String, Object>>() {};

    // ----------------------------------------------------------------------
    // constructors
    // ----------------------------------------------------------------------

    /**
     * Creates a new instance.
     *
     * @param commandEndpoint Cammand endpoint.
     */
    @Inject
    public CommandClient(CommandEndpoint commandEndpoint) {
        super(commandEndpoint);
    }

    // ----------------------------------------------------------------------
    // methods
    // ----------------------------------------------------------------------

    @Override
    public <T extends AbstractCommandDataWSModel> CommandResponse<T> sendCommand(CommandRequest<T> request) throws ForceAPIException {

        final Map<String, Object> map = mMapper.convertValue(request.getCommand(), mapTypeRef);
        final Call<CommandResponse> call = mCommandEndpoint.sendCommand(map, request.isAsync());
        return super.getResponseModel(request, call);

    }

    @Override
    public CommandResponse<OperationPhaseCommandDataWsModel> sendOperationPhaseCommand(OperationPhaseCommandRequest request) throws ForceAPIException {
        final Call<CommandResponse<OperationPhaseCommandDataWsModel>> call = this.createOperationPhaseCall(request);
        return super.getResponseModel(request, call);
    }

    @Override
    public CommandResponse<MachineCountCommandDataWSModel> sendMachineCountCommand(MachineCountCommandRequest request) throws ForceAPIException {
        final Call<CommandResponse<MachineCountCommandDataWSModel>> call = this.createMachineCountCall(request);
        return super.getResponseModel(request, call);
    }

    @Override
    public CommandResponse<MachineQuantityCommandDataWSModel> sendMachineQuantityCommand(MachineQuantityCommandRequest request) throws ForceAPIException {
        final Call<CommandResponse<MachineQuantityCommandDataWSModel>> call = this.createMachineQuantityCall(request);
        return super.getResponseModel(request, call);
    }

    @Override
    public CommandResponse<MachineStateCommandDataWSModel> sendMachineStateCommand(MachineStateCommandRequest request) throws ForceAPIException {
        final Call<CommandResponse<MachineStateCommandDataWSModel>> call = this.createMachineStateCall(request);
        return super.getResponseModel(request, call);
    }

    @Override
    public CommandResponse<MachineStateRevisionInsertCommandDataWsModel> sendMachineStateRevisionInsertCommand(MachineStateRevisionInsertCommandRequest request)
        throws ForceAPIException {
        final Call<CommandResponse<MachineStateRevisionInsertCommandDataWsModel>> call = this.createMachineStateRevisionInsertCall(request);
        return super.getResponseModel(request, call);
    }

    @Override
    public CommandResponse<OperationPhaseRevisionInsertCommandDataWsModel> sendOperationPhaseRevisionInsertCommand(
        OperationPhaseRevisionInsertCommandRequest request) throws ForceAPIException {
        final Call<CommandResponse<OperationPhaseRevisionInsertCommandDataWsModel>> call = this.createOperationPhaseRevisionInsertCall(request);
        return super.getResponseModel(request, call);
    }

    @Override
    public CommandResponse<MachineStrokeCommandDataWSModel> sendMachineStrokeCommand(MachineStrokeCommandRequest request) throws ForceAPIException {
        final Call<CommandResponse<MachineStrokeCommandDataWSModel>> call = this.createMachineStrokeCall(request);
        return super.getResponseModel(request, call);
    }

    @Override
    public CommandResponse<OperationQuantityCommandDataWsModel> sendOperationQuantityCommand(OperationQuantityCommandRequest request) throws ForceAPIException {
        final Call<CommandResponse<OperationQuantityCommandDataWsModel>> call = this.createOperationQuantityCall(request);
        return super.getResponseModel(request, call);
    }

    @Override
    public CommandResponse<OperationQuantityRevisionInsertCommandDataWsModel> sendOperationQuantityRevisionInsertCommand(
        OperationQuantityRevisionInsertCommandRequest request) throws ForceAPIException {
        final Call<CommandResponse<OperationQuantityRevisionInsertCommandDataWsModel>> call = this.createOperationQuantityRevisionInsertCall(request);
        return super.getResponseModel(request, call);
    }

    @Override
    public CommandResponse<ShiftStateCommandDataWSModel> sendShiftStateCommand(ShiftStateCommandRequest request) throws ForceAPIException {
        final Call<CommandResponse<ShiftStateCommandDataWSModel>> call = this.createShiftStateCall(request);
        return super.getResponseModel(request, call);
    }

}