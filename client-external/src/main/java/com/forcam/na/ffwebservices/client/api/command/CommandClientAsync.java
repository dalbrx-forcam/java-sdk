////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 19.10.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.command;

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
import retrofit2.Callback;
import retrofit2.Response;

import javax.inject.Inject;

/**
 * Sends asynchronous commands.
 */
public class CommandClientAsync extends AbstractCommandClient implements ICommandClientAsync {

    // ----------------------------------------------------------------------
    // constructors
    // ----------------------------------------------------------------------

    /**
     * Creates a new instance.
     *
     * @param commandEndpoint Command endpoint.
     */
    @Inject
    public CommandClientAsync(CommandEndpoint commandEndpoint) {
        super(commandEndpoint);
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public void sendOperationPhaseCommand(OperationPhaseCommandRequest request,
                                          CommandCallback<OperationPhaseCommandRequest, OperationPhaseCommandDataWsModel> callback) {
        final Call<CommandResponse<OperationPhaseCommandDataWsModel>> call = this.createOperationPhaseCall(request);
        final Callback<CommandResponse<OperationPhaseCommandDataWsModel>> retrofitCallback = this.getCommandResponseCallback(request, callback);
        call.enqueue(retrofitCallback);
    }

    @Override
    public void sendOperationQuantityCommand(OperationQuantityCommandRequest request,
                                             CommandCallback<OperationQuantityCommandRequest, OperationQuantityCommandDataWsModel> callback) {
        final Call<CommandResponse<OperationQuantityCommandDataWsModel>> call = this.createOperationQuantityCall(request);
        final Callback<CommandResponse<OperationQuantityCommandDataWsModel>> retrofitCallback = this.getCommandResponseCallback(request, callback);
        call.enqueue(retrofitCallback);
    }

    @Override
    public void sendMachineCountCommand(MachineCountCommandRequest request,
                                        CommandCallback<MachineCountCommandRequest, MachineCountCommandDataWSModel> callback) {
        final Call<CommandResponse<MachineCountCommandDataWSModel>> call = this.createMachineCountCall(request);
        final Callback<CommandResponse<MachineCountCommandDataWSModel>> retrofitCallback = this.getCommandResponseCallback(request, callback);
        call.enqueue(retrofitCallback);
    }

    @Override
    public void sendMachineQuantityCommand(MachineQuantityCommandRequest request,
                                           CommandCallback<MachineQuantityCommandRequest, MachineQuantityCommandDataWSModel> callback) {
        final Call<CommandResponse<MachineQuantityCommandDataWSModel>> call = this.createMachineQuantityCall(request);
        final Callback<CommandResponse<MachineQuantityCommandDataWSModel>> retrofitCallback = this.getCommandResponseCallback(request, callback);
        call.enqueue(retrofitCallback);
    }

    @Override
    public void sendMachineStateCommand(MachineStateCommandRequest request,
                                        CommandCallback<MachineStateCommandRequest, MachineStateCommandDataWSModel> callback) {
        final Call<CommandResponse<MachineStateCommandDataWSModel>> call = this.createMachineStateCall(request);
        final Callback<CommandResponse<MachineStateCommandDataWSModel>> retrofitCallback = this.getCommandResponseCallback(request, callback);
        call.enqueue(retrofitCallback);
    }

    @Override
    public void sendMachineStateRevisionInsertCommand(MachineStateRevisionInsertCommandRequest request,
                                                      CommandCallback<MachineStateRevisionInsertCommandRequest, MachineStateRevisionInsertCommandDataWsModel> callback) {
        final Call<CommandResponse<MachineStateRevisionInsertCommandDataWsModel>> call = this.createMachineStateRevisionInsertCall(request);
        final Callback<CommandResponse<MachineStateRevisionInsertCommandDataWsModel>> retrofitCallback = this.getCommandResponseCallback(request, callback);
        call.enqueue(retrofitCallback);
    }

    @Override
    public void sendOperationPhaseRevisionInsertCommand(OperationPhaseRevisionInsertCommandRequest request,
                                                        CommandCallback<OperationPhaseRevisionInsertCommandRequest, OperationPhaseRevisionInsertCommandDataWsModel> callback) {
        final Call<CommandResponse<OperationPhaseRevisionInsertCommandDataWsModel>> call = this.createOperationPhaseRevisionInsertCall(request);
        final Callback<CommandResponse<OperationPhaseRevisionInsertCommandDataWsModel>> retrofitCallback = this.getCommandResponseCallback(request, callback);
        call.enqueue(retrofitCallback);
    }

    @Override
    public void sendMachineStrokeCommand(MachineStrokeCommandRequest request,
                                         CommandCallback<MachineStrokeCommandRequest, MachineStrokeCommandDataWSModel> callback) {
        final Call<CommandResponse<MachineStrokeCommandDataWSModel>> call = this.createMachineStrokeCall(request);
        final Callback<CommandResponse<MachineStrokeCommandDataWSModel>> retrofitCallback = this.getCommandResponseCallback(request, callback);
        call.enqueue(retrofitCallback);
    }

    @Override
    public void sendOperationQuantityRevisionInsertCommand(OperationQuantityRevisionInsertCommandRequest request,
                                                           CommandCallback<OperationQuantityRevisionInsertCommandRequest, OperationQuantityRevisionInsertCommandDataWsModel> callback) {
        final Call<CommandResponse<OperationQuantityRevisionInsertCommandDataWsModel>> call = this.createOperationQuantityRevisionInsertCall(request);
        final Callback<CommandResponse<OperationQuantityRevisionInsertCommandDataWsModel>> retrofitCallback = this.getCommandResponseCallback(request,
                                                                                                                                              callback);
        call.enqueue(retrofitCallback);
    }

    @Override
    public void sendShiftStateCommand(ShiftStateCommandRequest request, CommandCallback<ShiftStateCommandRequest, ShiftStateCommandDataWSModel> callback) {
        final Call<CommandResponse<ShiftStateCommandDataWSModel>> call = this.createShiftStateCall(request);
        final Callback<CommandResponse<ShiftStateCommandDataWSModel>> retrofitCallback = this.getCommandResponseCallback(request, callback);
        call.enqueue(retrofitCallback);
    }

    /**
     * Returns a new command response callback.
     *
     * @param request  The command request.
     * @param callback A callback.
     * @param <T>      The type of the request.
     * @param <S>      The type of the data model.
     * @return A command response callback.
     */
    private <T extends AbstractCommandRequest, S extends AbstractCommandDataWSModel> Callback<CommandResponse<S>> getCommandResponseCallback(T request,
                                                                                                                                             CommandCallback<T, S> callback) {
        return new Callback<CommandResponse<S>>() {
            @Override
            public void onResponse(Call<CommandResponse<S>> call, Response<CommandResponse<S>> response) {
                if (response.isSuccessful()) {
                    final CommandResponse<S> body = response.body();
                    callback.onResponse(request, body);
                } else {
                    callback.onFailure(request, new CommandResponseException("Response was not successful: code " + response.code()));
                }
            }

            @Override
            public void onFailure(Call<CommandResponse<S>> call, Throwable throwable) {
                callback.onFailure(request, throwable);
            }
        };
    }
}