////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 27.09.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.statusdefinition;

import com.forcam.na.ffwebservices.client.api.HALCollectionWSModel;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.model.IPathParts;
import com.forcam.na.ffwebservices.model.IRequestAndQueryParams;
import com.forcam.na.ffwebservices.model.definition.OperationPhase;
import com.forcam.na.ffwebservices.model.definition.TimeBaseFilter;
import com.forcam.na.ffwebservices.model.definition.ToolAssemblyOrderState;
import com.forcam.na.ffwebservices.model.definition.WorkplaceState;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * An interface with methods for creating calls that can be sent to the server.
 */
public interface StatusDefinitionEndpoint {

    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @GET(IPathParts.MASTER_DATA + "/" + IPathParts.MACHINE_STATES)
    Call<HALCollectionWSModel> getMachineStates(
        @Query(IRequestAndQueryParams.LIMIT)
            int limit,
        @Query(IRequestAndQueryParams.OFFSET)
            int offset);

    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @GET(IPathParts.MASTER_DATA + "/" + IPathParts.OPERATION_PRODUCTION_STATES)
    Call<HALCollectionWSModel> getOperationProductionStates(
        @Query(IRequestAndQueryParams.LIMIT)
            int limit,
        @Query(IRequestAndQueryParams.OFFSET)
            int offset);

    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @GET(IPathParts.MASTER_DATA + "/" + IPathParts.OPERATION_PHASES)
    Call<HALCollectionWSModel> getOperationPhases(
        @Query(IRequestAndQueryParams.LIMIT)
            int limit,
        @Query(IRequestAndQueryParams.OFFSET)
            int offset,
        @Query(IRequestAndQueryParams.EMBED)
            String embed);

    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @GET(IPathParts.MASTER_DATA + "/" + IPathParts.TOOL_ASSEMBLY_ORDER_STATES)
    Call<HALCollectionWSModel> getToolAssemblyOrderStates(
        @Query(IRequestAndQueryParams.LIMIT)
            int limit,
        @Query(IRequestAndQueryParams.OFFSET)
            int offset,
        @Query(IRequestAndQueryParams.EMBED)
            String embed);

    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @GET(IPathParts.MASTER_DATA + "/" + IPathParts.STAFF_MEMBER_STATES)
    Call<HALCollectionWSModel> getPersonnelStates(
        @Query(IRequestAndQueryParams.LIMIT)
            int limit,
        @Query(IRequestAndQueryParams.OFFSET)
            int offset);

    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @GET(IPathParts.MASTER_DATA + "/" + IPathParts.OPERATING_STATE_CLASSES)
    Call<HALCollectionWSModel> getOperatingStateClasses(
        @Query(IRequestAndQueryParams.LIMIT)
            int limit,
        @Query(IRequestAndQueryParams.OFFSET)
            int offset,
        @Query(IRequestAndQueryParams.EMBED)
            String embed);

    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @GET(IPathParts.MASTER_DATA + "/" + IPathParts.OPERATING_STATE_CLASSES + "/{" + IRequestAndQueryParams.OPERATING_STATE_CLASS_ID + "}")
    Call<HALWSModel> getOperatingStateClass(
        @Path(IRequestAndQueryParams.OPERATING_STATE_CLASS_ID)
            String operatingStateClassId,
        @Query(IRequestAndQueryParams.EMBED)
            String embed);

    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @GET(IPathParts.MASTER_DATA + "/" + IPathParts.OPERATION_PHASES + "/{" + IRequestAndQueryParams.OPERATION_PHASE_ID + "}")
    Call<HALWSModel> getOperationPhase(
        @Path(IRequestAndQueryParams.OPERATION_PHASE_ID)
            OperationPhase operationPhaseId,
        @Query(IRequestAndQueryParams.EMBED)
            String embed);

    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @GET(IPathParts.MASTER_DATA + "/" + IPathParts.TOOL_ASSEMBLY_ORDER_STATES + "/{" + IRequestAndQueryParams.TOOL_ASSEMBLY_ORDER_STATE_ID + "}")
    Call<HALWSModel> getToolAssemblyOrderState(
        @Path(IRequestAndQueryParams.TOOL_ASSEMBLY_ORDER_STATE_ID)
            ToolAssemblyOrderState toolAssemblyOrderStateId,
        @Query(IRequestAndQueryParams.EMBED)
            String embed);

    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @GET(IPathParts.MASTER_DATA + "/" + IPathParts.WORKPLACE_STATES)
    Call<HALCollectionWSModel> getWorkplaceStates(
        @Query(IRequestAndQueryParams.LIMIT)
            int limit,
        @Query(IRequestAndQueryParams.OFFSET)
            int offset,
        @Query(IRequestAndQueryParams.EMBED)
            String embed);

    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @GET(IPathParts.MASTER_DATA + "/" + IPathParts.WORKPLACE_STATES + "/{" + IRequestAndQueryParams.WORKPLACE_STATE_ID + "}")
    Call<HALWSModel> getWorkplaceState(
        @Path(IRequestAndQueryParams.WORKPLACE_STATE_ID)
            WorkplaceState workplaceStateId,
        @Query(IRequestAndQueryParams.EMBED)
            String embed);

    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @GET(IPathParts.MASTER_DATA + "/" + IPathParts.OPERATING_STATES)
    Call<HALCollectionWSModel> getOperatingStates(
        @Query(IRequestAndQueryParams.LIMIT)
            int limit,
        @Query(IRequestAndQueryParams.OFFSET)
            int offset,
        @Query(IRequestAndQueryParams.TIME_BASE)
            TimeBaseFilter timeBase,
        @Query(IRequestAndQueryParams.WORKPLACE_STATE_ID)
            WorkplaceState workplaceStateId,
        @Query(IRequestAndQueryParams.OPERATING_STATE_CLASS_ID)
            String operatingStateClassId,
        @Query(IRequestAndQueryParams.EMBED)
            String embed);

    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @GET(IPathParts.MASTER_DATA + "/" + IPathParts.OPERATING_STATES + "/{" + IRequestAndQueryParams.OPERATING_STATE_ID + "}")
    Call<HALWSModel> getOperatingState(
        @Path(IRequestAndQueryParams.OPERATING_STATE_ID)
            String operatingStateId,
        @Query(IRequestAndQueryParams.EMBED)
            String embed);
}