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

/**
 * An interface with methods that send asynchronous commands.
 */
public interface ICommandClientAsync {

    /**
     * The interface for the command callback.
     *
     * @param <T> The type of the request.
     * @param <S> The type of the data model.
     */
    interface CommandCallback<T extends AbstractCommandRequest, S extends AbstractCommandDataWSModel> {

        /**
         * Is called when the server sent a response.
         *
         * @param request  The request.
         * @param response The response.
         */
        void onResponse(T request, CommandResponse<S> response);

        /**
         * Is called when response could not be received.
         *
         * @param request The failed request.
         * @param t       Contains details about the failure.
         */
        void onFailure(T request, Throwable t);
    }

    /**
     * Asynchronously sends an {@link OperationPhaseCommandRequest} to the server.
     *
     * @param request  The request.
     * @param callback The callback.
     */
    void sendOperationPhaseCommand(OperationPhaseCommandRequest request,
                                   CommandCallback<OperationPhaseCommandRequest, OperationPhaseCommandDataWsModel> callback);

    /**
     * Asynchronously sends an {@link OperationQuantityCommandRequest} to the server.
     *
     * @param request  The request.
     * @param callback The callback.
     */
    void sendOperationQuantityCommand(OperationQuantityCommandRequest request,
                                      CommandCallback<OperationQuantityCommandRequest, OperationQuantityCommandDataWsModel> callback);

    /**
     * Asynchronously sends a {@link MachineCountCommandRequest} to the server.
     *
     * @param request  The request.
     * @param callback The callback.
     */
    void sendMachineCountCommand(MachineCountCommandRequest request, CommandCallback<MachineCountCommandRequest, MachineCountCommandDataWSModel> callback);

    /**
     * Asynchronously sends a {@link MachineQuantityCommandRequest} to the server.
     *
     * @param request  The request.
     * @param callback The callback.
     */
    void sendMachineQuantityCommand(MachineQuantityCommandRequest request,
                                    CommandCallback<MachineQuantityCommandRequest, MachineQuantityCommandDataWSModel> callback);

    /**
     * Asynchronously sends a {@link MachineStateCommandRequest} to the server.
     *
     * @param request  The request.
     * @param callback The callback.
     */
    void sendMachineStateCommand(MachineStateCommandRequest request, CommandCallback<MachineStateCommandRequest, MachineStateCommandDataWSModel> callback);

    /**
     * Asynchronously sends a {@link MachineStateRevisionInsertCommandRequest} to the server.
     *
     * @param request  The request.
     * @param callback The callback.
     */
    void sendMachineStateRevisionInsertCommand(MachineStateRevisionInsertCommandRequest request,
                                               CommandCallback<MachineStateRevisionInsertCommandRequest, MachineStateRevisionInsertCommandDataWsModel> callback);

    /**
     * Asynchronously sends a {@link OperationPhaseRevisionInsertCommandRequest} to the server.
     *
     * @param request  The request.
     * @param callback The callback.
     */
    void sendOperationPhaseRevisionInsertCommand(OperationPhaseRevisionInsertCommandRequest request,
                                                 CommandCallback<OperationPhaseRevisionInsertCommandRequest, OperationPhaseRevisionInsertCommandDataWsModel> callback);

    /**
     * Asynchronously sends a {@link MachineStrokeCommandRequest} to the server.
     *
     * @param request  The request.
     * @param callback The callback.
     */
    void sendMachineStrokeCommand(MachineStrokeCommandRequest request, CommandCallback<MachineStrokeCommandRequest, MachineStrokeCommandDataWSModel> callback);

    /**
     * Asynchronously sends a {@link OperationQuantityRevisionInsertCommandRequest} to the server.
     *
     * @param request  The request.
     * @param callback The callback.
     */
    void sendOperationQuantityRevisionInsertCommand(OperationQuantityRevisionInsertCommandRequest request,
                                                    CommandCallback<OperationQuantityRevisionInsertCommandRequest, OperationQuantityRevisionInsertCommandDataWsModel> callback);

    /**
     * Asynchronously sends a {@link ShiftStateCommandRequest} to the server.
     *
     * @param request  The request.
     * @param callback The callback.
     */
    void sendShiftStateCommand(ShiftStateCommandRequest request, CommandCallback<ShiftStateCommandRequest, ShiftStateCommandDataWSModel> callback);

}