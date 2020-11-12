////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 12.09.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.command;

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

/**
 * An interface with methods that send commands and return the response of the server.
 */
public interface ICommandClient {

    /**
     * Sends a generic command to the server.
     *
     * @param request The command request
     * @param <T>     The type of the command.
     * @return The command response.
     * @throws ForceAPIException When unable to send the command.
     */
    <T extends AbstractCommandDataWSModel> CommandResponse<T> sendCommand(CommandRequest<T> request) throws ForceAPIException;

    /**
     * Sends an {@link OperationPhaseCommandRequest} to the server and gets a response.
     *
     * @param request Contains Parameters for the server request.
     * @return Command model.
     * @throws ForceAPIException When unable to send operation phase command.
     */
    CommandResponse<OperationPhaseCommandDataWsModel> sendOperationPhaseCommand(OperationPhaseCommandRequest request) throws ForceAPIException;

    /**
     * Sends a {@link MachineCountCommandRequest} to the server and gets a response.
     *
     * @param request Contains Parameters for the server request.
     * @return Command model.
     * @throws ForceAPIException When unable to send machine count command.
     */
    CommandResponse<MachineCountCommandDataWSModel> sendMachineCountCommand(MachineCountCommandRequest request) throws ForceAPIException;

    /**
     * Sends a {@link MachineQuantityCommandRequest} to the server and gets a response.
     *
     * @param request Contains Parameters for the server request.
     * @return Command model.
     * @throws ForceAPIException When unable to send machine quantity command.
     */
    CommandResponse<MachineQuantityCommandDataWSModel> sendMachineQuantityCommand(MachineQuantityCommandRequest request) throws ForceAPIException;

    /**
     * Sends a {@link MachineStateCommandRequest} to the server and gets a response.
     *
     * @param request Contains Parameters for the server request.
     * @return Command model.
     * @throws ForceAPIException When unable to send machine status command.
     */
    CommandResponse<MachineStateCommandDataWSModel> sendMachineStateCommand(MachineStateCommandRequest request) throws ForceAPIException;

    /**
     * Sends a {@link MachineStateRevisionInsertCommandRequest} to the server and gets a response.
     *
     * @param request Contains Parameters for the server request.
     * @return Command model.
     * @throws ForceAPIException When unable to send machine status revision insert command.
     */
    CommandResponse<MachineStateRevisionInsertCommandDataWsModel> sendMachineStateRevisionInsertCommand(MachineStateRevisionInsertCommandRequest request)
        throws ForceAPIException;

    /**
     * Sends a {@link OperationPhaseRevisionInsertCommandRequest} to the server and gets a response.
     *
     * @param request Contains Parameters for the server request.
     * @return Command model.
     * @throws ForceAPIException When unable to send operation phase revision insert command.
     */
    CommandResponse<OperationPhaseRevisionInsertCommandDataWsModel> sendOperationPhaseRevisionInsertCommand(OperationPhaseRevisionInsertCommandRequest request)
        throws ForceAPIException;

    /**
     * Sends a {@link MachineStrokeCommandRequest} to the server and gets a response.
     *
     * @param request Contains Parameters for the server request.
     * @return Command model.
     * @throws ForceAPIException When unable to send machine stroke command.
     */
    CommandResponse<MachineStrokeCommandDataWSModel> sendMachineStrokeCommand(MachineStrokeCommandRequest request) throws ForceAPIException;

    /**
     * Sends an {@link OperationQuantityCommandRequest} to the server and gets a response.
     *
     * @param request Contains Parameters for the server request.
     * @return Command model.
     * @throws ForceAPIException When unable to send operation quantity command.
     */
    CommandResponse<OperationQuantityCommandDataWsModel> sendOperationQuantityCommand(OperationQuantityCommandRequest request) throws ForceAPIException;

    /**
     * Sends a {@link OperationQuantityRevisionInsertCommandRequest} to the server and gets a response.
     *
     * @param request Contains Parameters for the server request.
     * @return Command model.
     * @throws ForceAPIException When unable to send operation quantity revision insert command.
     */
    CommandResponse<OperationQuantityRevisionInsertCommandDataWsModel> sendOperationQuantityRevisionInsertCommand(
        OperationQuantityRevisionInsertCommandRequest request) throws ForceAPIException;

    /**
     * Sends a {@link ShiftStateCommandRequest} to the server and gets a response.
     *
     * @param request Contains parameters for the server request.
     * @return Command model.
     * @throws ForceAPIException When unable to send shift state command.
     */
    CommandResponse<ShiftStateCommandDataWSModel> sendShiftStateCommand(ShiftStateCommandRequest request) throws ForceAPIException;
}