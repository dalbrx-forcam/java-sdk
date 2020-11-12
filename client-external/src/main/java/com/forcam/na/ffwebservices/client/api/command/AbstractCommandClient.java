////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 24.10.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.command;

import com.forcam.na.ffwebservices.client.api.AbstractClient;
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

/**
 * The abstract command client.
 */
abstract class AbstractCommandClient extends AbstractClient {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The command endpoint. */
    protected final CommandEndpoint mCommandEndpoint;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     */
    AbstractCommandClient(CommandEndpoint commandEndpoint) {
        mCommandEndpoint = commandEndpoint;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    /**
     * Creates a call for an operation phase command.
     *
     * @param request The request.
     * @return A call.
     */
    protected Call<CommandResponse<OperationPhaseCommandDataWsModel>> createOperationPhaseCall(OperationPhaseCommandRequest request) {
        final OperationPhaseCommandDataWsModel operationPhaseCommand = new OperationPhaseCommandDataWsModel();
        operationPhaseCommand.setOperationId(request.getOperationId());
        operationPhaseCommand.setWorkplaceId(request.getWorkplaceId());
        operationPhaseCommand.setOperationPhaseId(request.getPhase());

        return mCommandEndpoint.sendOperationPhaseCommand(operationPhaseCommand, request.isAsync());
    }

    /**
     * Creates a call for an operation quantity command.
     *
     * @param request The request.
     * @return A call.
     */
    protected Call<CommandResponse<OperationQuantityCommandDataWsModel>> createOperationQuantityCall(OperationQuantityCommandRequest request) {
        final OperationQuantityCommandDataWsModel operationQuantityCommand = new OperationQuantityCommandDataWsModel();
        operationQuantityCommand.setOperationId(request.getOperationId());
        operationQuantityCommand.setWorkplaceId(request.getWorkplaceId());
        operationQuantityCommand.setQuantity(request.getQuantity());
        operationQuantityCommand.setQualityDetailId(request.getQualityDetailId());
        operationQuantityCommand.setAnnotation(request.getAnnotation());
        operationQuantityCommand.setStaffMemberId(request.getStaffMemberId());
        operationQuantityCommand.setTicketId(request.getTicketId());

        return mCommandEndpoint.sendOperationQuantityCommand(operationQuantityCommand, request.isAsync());
    }

    /**
     * Creates a call for a machine count command.
     *
     * @param request The request.
     * @return A call.
     */
    protected Call<CommandResponse<MachineCountCommandDataWSModel>> createMachineCountCall(MachineCountCommandRequest request) {
        final MachineCountCommandDataWSModel machineCountCommand = new MachineCountCommandDataWSModel();
        machineCountCommand.setMachineId(request.getMachineId());
        machineCountCommand.setCount(request.getCount());
        machineCountCommand.setCounterNumber(request.getCounterNumber());

        return mCommandEndpoint.sendMachineCountCommand(machineCountCommand, request.isAsync());
    }

    /**
     * Creates a call for a machine quantity command.
     *
     * @param request The request.
     * @return A call.
     */
    protected Call<CommandResponse<MachineQuantityCommandDataWSModel>> createMachineQuantityCall(MachineQuantityCommandRequest request) {
        final MachineQuantityCommandDataWSModel machineQuantityCommand = new MachineQuantityCommandDataWSModel();
        machineQuantityCommand.setMachineId(request.getMachineId());
        machineQuantityCommand.setQuantity(request.getQuantity());
        machineQuantityCommand.setQualityDetailId(request.getQualityDetailId());

        return mCommandEndpoint.sendMachineQuantityCommand(machineQuantityCommand, request.isAsync());
    }

    /**
     * Creates a call for a machine state command.
     *
     * @param request The request.
     * @return A call.
     */
    protected Call<CommandResponse<MachineStateCommandDataWSModel>> createMachineStateCall(MachineStateCommandRequest request) {
        final MachineStateCommandDataWSModel machineStatusCommand = new MachineStateCommandDataWSModel();
        machineStatusCommand.setMachineId(request.getMachineId());
        machineStatusCommand.setMachineStateId(request.getMachineStateId());
        machineStatusCommand.setMachineStateDetailIds(request.getMachineStateDetailIds());
        machineStatusCommand.setAnnotation(request.getAnnotation());

        return mCommandEndpoint.sendMachineStateCommand(machineStatusCommand, request.isAsync());
    }

    /**
     * Creates a call for a machine state revision insert command.
     *
     * @param request The request.
     * @return A call.
     */
    protected Call<CommandResponse<MachineStateRevisionInsertCommandDataWsModel>> createMachineStateRevisionInsertCall(
        MachineStateRevisionInsertCommandRequest request) {
        final MachineStateRevisionInsertCommandDataWsModel machineStatusRevisionInsertCommand = new MachineStateRevisionInsertCommandDataWsModel();
        machineStatusRevisionInsertCommand.setMachineStateCommand(request.getMachineStatusCommand());
        machineStatusRevisionInsertCommand.setInsertionTimestamp(request.getInsertionTimestamp());

        return mCommandEndpoint.sendMachineStateRevisionInsertCommand(machineStatusRevisionInsertCommand, request.isAsync());
    }

    /**
     * Creates a call for a operation phase revision insert command.
     *
     * @param request The request.
     * @return A call.
     */
    protected Call<CommandResponse<OperationPhaseRevisionInsertCommandDataWsModel>> createOperationPhaseRevisionInsertCall(
        OperationPhaseRevisionInsertCommandRequest request) {
        final OperationPhaseRevisionInsertCommandDataWsModel operationPhaseRevisionInsertCommand = new OperationPhaseRevisionInsertCommandDataWsModel();
        operationPhaseRevisionInsertCommand.setOperationPhaseCommand(request.getOperationPhaseCommandDataWsModel());
        operationPhaseRevisionInsertCommand.setInsertionTimestamp(request.getInsertionTimestamp());

        return mCommandEndpoint.sendOperationPhaseRevisionInsertCommand(operationPhaseRevisionInsertCommand, request.isAsync());
    }

    /**
     * Creates a call for a machine stroke command.
     *
     * @param request The request.
     * @return A call.
     */
    protected Call<CommandResponse<MachineStrokeCommandDataWSModel>> createMachineStrokeCall(MachineStrokeCommandRequest request) {
        final MachineStrokeCommandDataWSModel machineStrokeCommand = new MachineStrokeCommandDataWSModel();
        machineStrokeCommand.setMachineId(request.getMachineId());
        machineStrokeCommand.setCounterNumber(request.getCounterNumber());
        machineStrokeCommand.setStrokes(request.getStrokes());

        return mCommandEndpoint.sendMachineStrokeCommand(machineStrokeCommand, request.isAsync());
    }

    /**
     * Creates a call for a operation quantity revision insert command.
     *
     * @param request The request.
     * @return A call.
     */
    protected Call<CommandResponse<OperationQuantityRevisionInsertCommandDataWsModel>> createOperationQuantityRevisionInsertCall(
        OperationQuantityRevisionInsertCommandRequest request) {
        final OperationQuantityRevisionInsertCommandDataWsModel quantityRevisionInsertCommand = new OperationQuantityRevisionInsertCommandDataWsModel();
        quantityRevisionInsertCommand.setOperationQuantityCommand(request.getOperationQuantityCommand());
        quantityRevisionInsertCommand.setInsertionTimestamp(request.getInsertionTimestamp());

        return mCommandEndpoint.sendMachineStateRevisionInsertCommand(quantityRevisionInsertCommand, request.isAsync());
    }

    /**
     * Creates a call for a shift state command.
     *
     * @param request The request.
     * @return A call.
     */
    protected Call<CommandResponse<ShiftStateCommandDataWSModel>> createShiftStateCall(ShiftStateCommandRequest request) {
        final ShiftStateCommandDataWSModel shiftStateCommandDataWSModel = new ShiftStateCommandDataWSModel();
        shiftStateCommandDataWSModel.setWorkplaceId(request.getWorkplaceId());
        shiftStateCommandDataWSModel.setShiftId(request.getShiftId());
        shiftStateCommandDataWSModel.setShiftStateId(request.getShiftStateId());
        shiftStateCommandDataWSModel.setShiftTypeId(request.getShiftTypeId());
        shiftStateCommandDataWSModel.setAssociatedDate(request.getAssociatedDate());
        return mCommandEndpoint.sendShiftStateCommand(shiftStateCommandDataWSModel, request.isAsync());
    }
}