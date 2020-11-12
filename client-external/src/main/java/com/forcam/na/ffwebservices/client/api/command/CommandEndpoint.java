////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 12.09.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.command;

import com.forcam.na.ffwebservices.model.IRequestAndQueryParams;
import com.forcam.na.ffwebservices.model.command.CommandResponse;
import com.forcam.na.ffwebservices.model.command.ICommandPaths;
import com.forcam.na.ffwebservices.model.command.machine.MachineCountCommandDataWSModel;
import com.forcam.na.ffwebservices.model.command.machine.MachineQuantityCommandDataWSModel;
import com.forcam.na.ffwebservices.model.command.machine.MachineStateCommandDataWSModel;
import com.forcam.na.ffwebservices.model.command.machine.MachineStateRevisionInsertCommandDataWsModel;
import com.forcam.na.ffwebservices.model.command.machine.MachineStrokeCommandDataWSModel;
import com.forcam.na.ffwebservices.model.command.operation.OperationPhaseCommandDataWsModel;
import com.forcam.na.ffwebservices.model.command.operation.OperationPhaseRevisionInsertCommandDataWsModel;
import com.forcam.na.ffwebservices.model.command.operation.OperationQuantityCommandDataWsModel;
import com.forcam.na.ffwebservices.model.command.operation.OperationQuantityRevisionInsertCommandDataWsModel;
import com.forcam.na.ffwebservices.model.command.workplace.ShiftStateCommandDataWSModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

import java.util.Map;

/**
 * An interface with methods for creating Calls that can be sent to the server.
 */
public interface CommandEndpoint {

    /**
     * Creates a Call that can be sent to the server.
     *
     * @param model The operation phase ommand model.
     * @param async Determines if the call is asynchronous.
     * @return A call that can be sent to the server.
     */
    @Headers({"Content-Type: application/json","Accept: application/json"} )
    @POST(ICommandPaths.COMMANDS)
    Call<CommandResponse<OperationPhaseCommandDataWsModel>> sendOperationPhaseCommand(
        @Body
            OperationPhaseCommandDataWsModel model,
        @Query(IRequestAndQueryParams.ASYNC)
            boolean async);

    /**
     * Creates a Call that can be sent to the server.
     *
     * @param model The machine count ommand model.
     * @param async Determines if the call is asynchronous.
     * @return A call that can be sent to the server.
     */
    @Headers({"Content-Type: application/json","Accept: application/json"} )
    @POST(ICommandPaths.COMMANDS)
    Call<CommandResponse<MachineCountCommandDataWSModel>> sendMachineCountCommand(
        @Body
            MachineCountCommandDataWSModel model,
        @Query(IRequestAndQueryParams.ASYNC)
            boolean async);

    /**
     * Creates a Call that can be sent to the server.
     *
     * @param model The machine quantity command model.
     * @param async Determines if the call is asynchronous.
     * @return A call that can be sent to the server.
     */
    @Headers({"Content-Type: application/json","Accept: application/json"} )
    @POST(ICommandPaths.COMMANDS)
    Call<CommandResponse<MachineQuantityCommandDataWSModel>> sendMachineQuantityCommand(
        @Body
            MachineQuantityCommandDataWSModel model,
        @Query(IRequestAndQueryParams.ASYNC)
            boolean async);

    /**
     * Creates a Call that can be sent to the server.
     *
     * @param model The machine status command model.
     * @param async Determines if the call is asynchronous.
     * @return A call that can be sent to the server.
     */
    @Headers({"Content-Type: application/json","Accept: application/json"} )
    @POST(ICommandPaths.COMMANDS)
    Call<CommandResponse<MachineStateCommandDataWSModel>> sendMachineStateCommand(
        @Body
            MachineStateCommandDataWSModel model,
        @Query(IRequestAndQueryParams.ASYNC)
            boolean async);

    /**
     * Creates a Call that can be sent to the server.
     *
     * @param model The machine status revision insert command model.
     * @param async Determines if the call is asynchronous.
     * @return A call that can be sent to the server.
     */
    @Headers({"Content-Type: application/json","Accept: application/json"} )
    @POST(ICommandPaths.COMMANDS)
    Call<CommandResponse<MachineStateRevisionInsertCommandDataWsModel>> sendMachineStateRevisionInsertCommand(
        @Body
            MachineStateRevisionInsertCommandDataWsModel model,
        @Query(IRequestAndQueryParams.ASYNC)
            boolean async);

    /**
     * Creates a Call that can be sent to the server.
     *
     * @param model The operation phase revision insert command model.
     * @param async Determines if the call is asynchronous.
     * @return A call that can be sent to the server.
     */
    @Headers({"Content-Type: application/json","Accept: application/json"} )
    @POST(ICommandPaths.COMMANDS)
    Call<CommandResponse<OperationPhaseRevisionInsertCommandDataWsModel>> sendOperationPhaseRevisionInsertCommand(
        @Body
            OperationPhaseRevisionInsertCommandDataWsModel model,
        @Query(IRequestAndQueryParams.ASYNC)
            boolean async);

    /**
     * Creates a Call that can be sent to the server.
     *
     * @param model The machine stroke command model.
     * @param async Determines if the call is asynchronous.
     * @return A call that can be sent to the server.
     */
    @Headers({"Content-Type: application/json","Accept: application/json"} )
    @POST(ICommandPaths.COMMANDS)
    Call<CommandResponse<MachineStrokeCommandDataWSModel>> sendMachineStrokeCommand(
        @Body
            MachineStrokeCommandDataWSModel model,
        @Query(IRequestAndQueryParams.ASYNC)
            boolean async);

    /**
     * Creates a Call that can be sent to the server.
     *
     * @param model The operation quantity  command model.
     * @param async Determines if the call is asynchronous.
     * @return A call that can be sent to the server.
     */
    @Headers({"Content-Type: application/json","Accept: application/json"} )
    @POST(ICommandPaths.COMMANDS)
    Call<CommandResponse<OperationQuantityCommandDataWsModel>> sendOperationQuantityCommand(
        @Body
            OperationQuantityCommandDataWsModel model,
        @Query(IRequestAndQueryParams.ASYNC)
            boolean async);

    /**
     * Creates a Call that can be sent to the server.
     *
     * @param model The operation quantity revision insert command model.
     * @param async Determines if the call is asynchronous.
     * @return A call that can be sent to the server.
     */
    @Headers({"Content-Type: application/json","Accept: application/json"} )
    @POST(ICommandPaths.COMMANDS)
    Call<CommandResponse<OperationQuantityRevisionInsertCommandDataWsModel>> sendMachineStateRevisionInsertCommand(
        @Body
            OperationQuantityRevisionInsertCommandDataWsModel model,
        @Query(IRequestAndQueryParams.ASYNC)
            boolean async);

    /**
     * Creates a Call that can be sent to the server.
     *
     * @param shiftStateCommand The shift state command model.
     * @param async             Determines if the call is asynchronous.
     * @return A call that can be sent to the server.
     */
    @Headers({"Content-Type: application/json","Accept: application/json"} )
    @POST(ICommandPaths.COMMANDS)
    Call<CommandResponse<ShiftStateCommandDataWSModel>> sendShiftStateCommand(
        @Body
            ShiftStateCommandDataWSModel shiftStateCommand,
        @Query(IRequestAndQueryParams.ASYNC)
            boolean async);

    @Headers({"Content-Type: application/json","Accept: application/json"} )
    @POST(ICommandPaths.COMMANDS)
    Call<CommandResponse> sendCommand(
        @Body
            Map<String, Object> command,
        @Query(IRequestAndQueryParams.ASYNC)
            boolean async);
}