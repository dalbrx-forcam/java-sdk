////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 13.09.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.operation;

import com.forcam.na.common.webserviceaccess.requestparams.PaginationDirection;
import com.forcam.na.ffwebservices.client.api.HALCollectionWSModel;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.model.IPathParts;
import com.forcam.na.ffwebservices.model.IRequestAndQueryParams;
import com.forcam.na.ffwebservices.model.command.operation.OperationPhaseRequestBody;
import com.forcam.na.ffwebservices.model.command.operation.OperationQualityDetailRequestBody;
import com.forcam.na.ffwebservices.model.definition.OperationPhase;
import com.forcam.na.ffwebservices.model.definition.TimeBaseFilter;
import com.forcam.na.ffwebservices.model.definition.WorkplaceState;
import com.forcam.na.ffwebservices.model.operation.IOperationPaths;
import com.forcam.na.ffwebservices.model.operation.SearchOperationsRequestBody;
import com.forcam.na.ffwebservices.model.operation.UpdateOperationRecordedOperatingStateRequestBody;
import com.forcam.na.ffwebservices.model.operation.quantity.OperationQuantitySummaryCollectionWSModel;
import com.forcam.na.ffwebservices.model.qualitydetail.QualityType;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.util.Date;
import java.util.List;

/**
 * An interface with methods for creating calls that can be sent to the server.
 */
public interface OperationEndpoint {

    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @POST(IPathParts.OPERATIONS + "/" + IPathParts.SEARCH)
    Call<HALCollectionWSModel> searchOperations(
        @Body
            SearchOperationsRequestBody model,
        @Query(IRequestAndQueryParams.LIMIT)
            int limit,
        @Query(IRequestAndQueryParams.PAGINATION_DIRECTION)
            PaginationDirection paginationDirection,
        @Query(IRequestAndQueryParams.PAGINATION_TIMESTAMP)
            Date paginationTimestamp,
        @Query(IRequestAndQueryParams.PAGINATION_IDENTIFIER)
            String paginationIdentifier,
        @Query(IRequestAndQueryParams.EMBED)
            String embed);

    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @GET(IPathParts.OPERATIONS + "/{" + IRequestAndQueryParams.OPERATION_ID + "}")
    Call<HALWSModel> getOperation(
        @Path(IRequestAndQueryParams.OPERATION_ID)
            String operationId,
        @Query(IRequestAndQueryParams.EMBED)
            String embed);

    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @GET(IPathParts.OPERATIONS + "/{" + IRequestAndQueryParams.OPERATION_ID + "}/" + IPathParts.SCHEDULED_DATES)
    Call<HALWSModel> getScheduledDates(
        @Path(IRequestAndQueryParams.OPERATION_ID)
            String operationId);

    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @GET(IPathParts.OPERATIONS + "/{" + IRequestAndQueryParams.OPERATION_ID + "}/" + IPathParts.SPECIFICATION)
    Call<HALWSModel> getSpecification(
        @Path(IRequestAndQueryParams.OPERATION_ID)
            String operationId,
        @Query(IRequestAndQueryParams.EMBED)
            String embed);

    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @GET(IPathParts.OPERATIONS + "/{" + IRequestAndQueryParams.OPERATION_ID + "}/" + IPathParts.PRODUCTION_RESOURCES_AND_TOOLS)
    Call<HALCollectionWSModel> getProductionResourcesAndTools(
        @Path(IRequestAndQueryParams.OPERATION_ID)
            String operationId,
        @Query(IRequestAndQueryParams.TYPE)
            String type,
        @Query(IRequestAndQueryParams.GROUP)
            String group,
        @Query(IRequestAndQueryParams.LIMIT)
            int limit,
        @Query(IRequestAndQueryParams.OFFSET)
            int offset,
        @Query(IRequestAndQueryParams.EMBED)
            String embed);

    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @GET(IPathParts.OPERATIONS + "/{" + IRequestAndQueryParams.OPERATION_ID + "}/" + IPathParts.RECORDED_OPERATING_STATES)
    Call<HALWSModel> getRecordedOperatingStates(
        @Path(IRequestAndQueryParams.OPERATION_ID)
            String operationId,
        @Query(IRequestAndQueryParams.WORKPLACE_STATE_ID)
            WorkplaceState workplaceStateId,
        @Query(IRequestAndQueryParams.OPERATING_STATE_CLASS_ID)
            String operatingStateClassId,
        @Query(IRequestAndQueryParams.LIMIT)
            int limit,
        @Query(IRequestAndQueryParams.PAGINATION_DIRECTION)
            PaginationDirection paginationDirection,
        @Query(IRequestAndQueryParams.PAGINATION_TIMESTAMP)
            Date paginationTimestamp,
        @Query(IRequestAndQueryParams.START_DATE)
            Date startDate,
        @Query(IRequestAndQueryParams.END_DATE)
            Date endDate,
        @Query(IRequestAndQueryParams.TIME_BASE)
            TimeBaseFilter timeBase,
        @Query(IRequestAndQueryParams.EMBED)
            String embed);

    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @GET(IPathParts.OPERATIONS)
    Call<HALCollectionWSModel> getOperations(
        @Query(IRequestAndQueryParams.PRODUCTION_ORDER_NUMBER)
            String productionOrderNumber,
        @Query(IRequestAndQueryParams.PRODUCTION_ORDER_SPLIT)
            String productionOrderSplit,
        @Query(IRequestAndQueryParams.OPERATION_NUMBER)
            String operationNumber,
        @Query(IRequestAndQueryParams.OPERATION_SPLIT)
            String operationSplit,
        @Query(IRequestAndQueryParams.MATERIAL_NUMBER)
            String materialNumber,
        @Query(IRequestAndQueryParams.WORKPLACE_NUMBER)
            String workplaceNumber,
        @Query(IRequestAndQueryParams.WORKPLACE_ID)
            String workplaceId,
        @Query(IRequestAndQueryParams.START_DATE)
            Date startDate,
        @Query(IRequestAndQueryParams.END_DATE)
            Date endDate,
        @Query(IRequestAndQueryParams.OPERATION_PHASE_ID)
            OperationPhase operationPhaseId,
        @Query(IRequestAndQueryParams.PRODUCTION_ORDER_ID)
            String productionOrderId,
        @Query(IRequestAndQueryParams.IS_PLANNABLE)
            Boolean isPlannable,
        @Query(IRequestAndQueryParams.IS_DISPATCHED)
            Boolean isDispatched,
        @Query(IRequestAndQueryParams.IS_IN_PROGRESS)
            Boolean isInProgress,
        @Query(IRequestAndQueryParams.LIMIT)
            int limit,
        @Query(IRequestAndQueryParams.PAGINATION_DIRECTION)
            PaginationDirection paginationDirection,
        @Query(IRequestAndQueryParams.PAGINATION_TIMESTAMP)
            Date paginationTimestamp,
        @Query(IRequestAndQueryParams.PAGINATION_IDENTIFIER)
            String paginationIdentifier,
        @Query(IRequestAndQueryParams.EMBED)
            String embed);

    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @GET(IPathParts.OPERATIONS + "/{" + IRequestAndQueryParams.OPERATION_ID + "}/" + IPathParts.QUANTITY_SUMMARY)
    Call<OperationQuantitySummaryCollectionWSModel> getQuantitySummary(
        @Path(IRequestAndQueryParams.OPERATION_ID)
            String operationId,
        @Query(IRequestAndQueryParams.LIMIT)
            int limit,
        @Query(IRequestAndQueryParams.OFFSET)
            int offset);

    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @POST(IPathParts.OPERATIONS + "/{" + IRequestAndQueryParams.OPERATION_ID + "}/" + IPathParts.QUALITY_DETAILS)
    Call<Void> setQualityDetails(
        @Body
            OperationQualityDetailRequestBody model,
        @Path(IRequestAndQueryParams.OPERATION_ID)
            String operationId,
        @Query(IRequestAndQueryParams.ASYNC)
            boolean async);

    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @POST(IPathParts.OPERATIONS + "/{" + IRequestAndQueryParams.OPERATION_ID + "}/{" + IRequestAndQueryParams.OPERATION_PHASE_ID + "}")
    Call<HALWSModel> setOperationPhase(
        @Body
            OperationPhaseRequestBody model,
        @Path(IRequestAndQueryParams.OPERATION_ID)
            String operationId,
        @Path(IRequestAndQueryParams.OPERATION_PHASE_ID)
            OperationPhase operationPhaseId,
        @Query(IRequestAndQueryParams.ASYNC)
            boolean async);

    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @GET(IPathParts.OPERATIONS + "/{" + IRequestAndQueryParams.OPERATION_ID + "}/" + IPathParts.USER_FIELDS)
    Call<HALWSModel> getOperationUserFields(
        @Path(IRequestAndQueryParams.OPERATION_ID)
            String operationId,
        @Query(IRequestAndQueryParams.LIMIT)
            int limit,
        @Query(IRequestAndQueryParams.OFFSET)
            int offset,
        @Query(IRequestAndQueryParams.EMBED)
            String embed);

    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @GET(IPathParts.OPERATIONS + "/{" + IRequestAndQueryParams.OPERATION_ID + "}/" + IOperationPaths.COMPONENTS)
    Call<HALWSModel> getOperationComponents(
        @Path(IRequestAndQueryParams.OPERATION_ID)
            String operationId,
        @Query(IRequestAndQueryParams.LIMIT)
            int limit,
        @Query(IRequestAndQueryParams.OFFSET)
            int offset,
        @Query(IRequestAndQueryParams.EMBED)
            String embed);

    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @GET(IPathParts.OPERATIONS + "/{" + IRequestAndQueryParams.OPERATION_ID + "}/" + IPathParts.MANUFACTURING_VARIANTS)
    Call<HALWSModel> getOperationManufacturingVariants(
        @Path(IRequestAndQueryParams.OPERATION_ID)
            String operationId);

    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @GET(IPathParts.OPERATIONS + "/{" + IRequestAndQueryParams.OPERATION_ID + "}/" + IPathParts.RECORDED_OPERATION_PHASES)
    Call<HALWSModel> getRecordedOperationPhases(
        @Path(IRequestAndQueryParams.OPERATION_ID)
            String operationId,
        @Query(IRequestAndQueryParams.LIMIT)
            int limit,
        @Query(IRequestAndQueryParams.START_DATE)
            Date startDate,
        @Query(IRequestAndQueryParams.END_DATE)
            Date endDate,
        @Query(IRequestAndQueryParams.PAGINATION_DIRECTION)
            PaginationDirection paginationDirection,
        @Query(IRequestAndQueryParams.PAGINATION_TIMESTAMP)
            Date paginationTimestamp);

    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @GET(IPathParts.OPERATIONS + "/{" + IRequestAndQueryParams.OPERATION_ID + "}/" + IPathParts.OPERATING_STATE_SUMMARY)
    Call<HALWSModel> getOperatingStateSummary(
        @Path(IRequestAndQueryParams.OPERATION_ID)
            String operationId,
        @Query(IRequestAndQueryParams.WORKPLACE_STATE_ID)
            WorkplaceState workplaceStateId,
        @Query(IRequestAndQueryParams.OPERATING_STATE_CLASS_ID)
            String operatingStateClassId,
        @Query(IRequestAndQueryParams.LIMIT)
            int limit,
        @Query(IRequestAndQueryParams.OFFSET)
            int offset,
        @Query(IRequestAndQueryParams.TIME_BASE)
            TimeBaseFilter timeBase);

    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @GET(IPathParts.OPERATIONS + "/{" + IRequestAndQueryParams.OPERATION_ID + "}/" + IPathParts.RECORDED_OUTPUT_QUANTITIES)
    Call<HALWSModel> getRecordedOutputQuantities(
        @Path(IRequestAndQueryParams.OPERATION_ID)
            String operationId,
        @Query(IRequestAndQueryParams.QUALITY_TYPE_ID)
            QualityType qualityTypeId,
        @Query(IRequestAndQueryParams.LIMIT)
            int limit,
        @Query(IRequestAndQueryParams.PAGINATION_DIRECTION)
            PaginationDirection paginationDirection,
        @Query(IRequestAndQueryParams.PAGINATION_TIMESTAMP)
            Date paginationTimestamp,
        @Query(IRequestAndQueryParams.START_DATE)
            Date startDate,
        @Query(IRequestAndQueryParams.END_DATE)
            Date endDate);

    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @GET(IPathParts.OPERATIONS + "/{" + IRequestAndQueryParams.OPERATION_ID + "}/" + IPathParts.ALTERNATIVE_WORKPLACES)
    Call<HALCollectionWSModel> getAlternativeWorkplaces(
        @Path(IRequestAndQueryParams.OPERATION_ID)
            String operationId);

    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @GET(IPathParts.OPERATIONS + "/{" + IRequestAndQueryParams.OPERATION_ID + "}/" + IPathParts.OPERATION_CURRENT_PRODUCTION_DATA)
    Call<HALWSModel> getCurrentProductionData(
        @Path(IRequestAndQueryParams.OPERATION_ID)
            String operationId,
        @Query(IRequestAndQueryParams.ADDITIONAL_OPERATION_TIME)
            List<String> additionalOperationTime);

    /**
     * Creates a call that can be sent to the server.
     *
     * @param operationId The operation id.
     * @param model       The model.
     * @return A call that can be sent to the server.
     */
    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @POST(IPathParts.OPERATIONS + "/{" + IRequestAndQueryParams.OPERATION_ID + "}/" + IPathParts.RECORDED_OPERATING_STATES + "/" + IPathParts.UPDATE)
    Call<Void> updateRecordedOperatingState(
        @Path(IRequestAndQueryParams.OPERATION_ID)
            String operationId,
        @Body
            UpdateOperationRecordedOperatingStateRequestBody model);
}
