////////////////////////////////////////////////////////////////////////////////
//
// Created by abhishekmundewal on 28-May-18.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.operation.operationplanning;

import com.forcam.na.common.webserviceaccess.requestparams.PaginationDirection;
import com.forcam.na.ffwebservices.client.api.HALCollectionWSModel;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.model.IPathParts;
import com.forcam.na.ffwebservices.model.IRequestAndQueryParams;
import com.forcam.na.ffwebservices.model.operation.OperationAssignmentWSModel;
import com.forcam.na.ffwebservices.model.operation.OperationPlanningResultBodyWSModel;
import com.forcam.na.ffwebservices.model.operation.OperationPlanningScenariosBodyWSModel;
import com.forcam.na.ffwebservices.model.operation.UpdateOperationForecastRequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.util.Date;

/**
 * An interface with methods for creating calls that can be sent to the server.
 */
public interface OperationPlanningEndpoint {

    /**
     * Creates a call that can be sent to the server and gets all planning scenarios.
     *
     * @param startDate           The start date.
     * @param endDate             The end date.
     * @param limit               The limit.
     * @param paginationDirection The pagination direction.
     * @param paginationTimestamp The pagination timestamp.
     * @return A call that can be sent to the server.
     */
    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @GET(IPathParts.OPERATIONS + "/" + IPathParts.PLANNING_SCENARIOS)
    Call<HALCollectionWSModel> getPlanningScenarios(
        @Query(IRequestAndQueryParams.START_DATE)
            Date startDate,
        @Query(IRequestAndQueryParams.END_DATE)
            Date endDate,
        @Query(IRequestAndQueryParams.LIMIT)
            int limit,
        @Query(IRequestAndQueryParams.PAGINATION_DIRECTION)
            PaginationDirection paginationDirection,
        @Query(IRequestAndQueryParams.PAGINATION_TIMESTAMP)
            Date paginationTimestamp);

    /**
     * Creates a call that can be sent to the server and gets the planning scenario.
     *
     * @param planningScenarioId The planning scenario ID.
     * @param limit              The limit.
     * @param offset             The offset.
     * @return A call that can be sent to the server.
     */
    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @GET(IPathParts.OPERATIONS + "/" + IPathParts.PLANNING_SCENARIOS + "/{" + IRequestAndQueryParams.PLANNING_SCENARIO_ID +"}")
    Call<HALWSModel> getPlanningScenario(
        @Path(IRequestAndQueryParams.PLANNING_SCENARIO_ID)
            String planningScenarioId,
        @Query(IRequestAndQueryParams.LIMIT)
            int limit,
        @Query(IRequestAndQueryParams.OFFSET)
            int offset);

    /**
     * Creates a call that can be sent to the server and sets the planning scenario.
     *
     * @param model The planning scenario model.
     * @return A call that can be sent to the server.
     */
    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @POST(IPathParts.OPERATIONS + "/" + IPathParts.PLANNING_SCENARIOS)
    Call<HALWSModel> setPlanningScenario(
        @Body
            OperationPlanningScenariosBodyWSModel model);

    /**
     * Creates a call that can be sent to the server and gets a planning result by operation ID.
     *
     * @param operationId The operation ID.
     * @param embed       The resources which shall be embedded.
     * @return A call that can be sent to the server.
     */
    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @GET(IPathParts.OPERATIONS + "/{" + IRequestAndQueryParams.OPERATION_ID +"}/" + IPathParts.PLANNING_RESULT)
    Call<HALWSModel> getOperationPlanningResult(
        @Path(IRequestAndQueryParams.OPERATION_ID)
            String operationId,
        @Query(IRequestAndQueryParams.EMBED)
            String embed);

    /**
     * Creates a call that can be sent to the server and gets all planning results.
     *
     * @param endDate              The end date.
     * @param startDate            The start date.
     * @param offset               The offset.
     * @param limit                The limit.
     * @param workplaceNumber      The workplace number.
     * @param workplaceGroupNumber The workplace group number.
     * @param erpContextId         The ERP context ID.
     * @param workplaceGroupId     The workplace group ID.
     * @return A call that can be sent to the server.
     */
    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @GET(IPathParts.OPERATIONS + "/" + IPathParts.PLANNING_RESULTS)
    Call<OperationAssignmentCollectionServerModel> getOperationsPlanningResults(
        @Query(IRequestAndQueryParams.START_DATE)
            Date startDate,
        @Query(IRequestAndQueryParams.END_DATE)
            Date endDate,
        @Query(IRequestAndQueryParams.WORKPLACE_GROUP_NUMBER)
            String workplaceGroupNumber,
        @Query(IRequestAndQueryParams.WORKPLACE_NUMBER)
            String workplaceNumber,
        @Query(IRequestAndQueryParams.ERP_CONTEXT_ID)
            String erpContextId,
        @Query(IRequestAndQueryParams.WORKPLACE_GROUP_ID)
            String workplaceGroupId,
        @Query(IRequestAndQueryParams.LIMIT)
            int limit,
        @Query(IRequestAndQueryParams.OFFSET)
            int offset);

    /**
     * Creates a call that can be sent to the server and update planning results.
     *
     * @param planningResult The planning result.
     * @return A call that can be sent to the server.
     */
    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @POST(IPathParts.OPERATIONS + "/" + IPathParts.PLANNING_RESULTS + "/" + IPathParts.UPDATE)
    Call<Void> updateOperationsPlanningResults(
        @Body()
            OperationPlanningResultBodyWSModel planningResult);

    /**
     * Creates a call that can be sent to the server and saves an operation planning result.
     *
     * @param operationId The operation ID.
     * @param model       The operation planning result properties model.
     * @return A call that can be sent to the server.
     */
    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @PUT(IPathParts.OPERATIONS + "/{" + IRequestAndQueryParams.OPERATION_ID + "}/" + IPathParts.PLANNING_RESULT)
    Call<HALWSModel> saveOperationPlanningResult(
        @Body
            OperationAssignmentWSModel model,
        @Path(IRequestAndQueryParams.OPERATION_ID)
            String operationId);

    /**
     * Creates a call that can be sent to the server and deletes a planning result by operation ID.
     *
     * @param operationId The operation ID.
     * @return A call that can be sent to the server.
     */
    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @DELETE(IPathParts.OPERATIONS + "/{" + IRequestAndQueryParams.OPERATION_ID + "}/" + IPathParts.PLANNING_RESULT)
    Call<Void> deleteOperationPlanningResult(
        @Path(IRequestAndQueryParams.OPERATION_ID)
            String operationId);

    /**
     * Creates a call that can be sent to the server and gets a forecast result by operation ID.
     *
     * @param operationId The operation ID.
     * @return A call that can be sent to the server.
     */
    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @GET(IPathParts.OPERATIONS + "/{" + IRequestAndQueryParams.OPERATION_ID + "}/" + IPathParts.FORECAST_RESULT)
    Call<HALWSModel> getOperationForecastResult(
        @Path(IRequestAndQueryParams.OPERATION_ID)
            String operationId);

    /**
     * Creates a call that can be sent to the server and gets all operations forecast results.
     *
     * @param useOriginalValues    Use original values flag.
     * @param startDate            The start date.
     * @param endDate              The end date.
     * @param workplaceGroupId     Workplace group ID.
     * @param erpContextId         ERP context ID.
     * @param workplaceGroupNumber The workplace group number.
     * @param offset               The offset used for pagination.
     * @param limit                The limit used for pagination.
     * @param workplaceNumber      The workplace number.
     * @return A call that can be sent to the server.
     */
    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @GET(IPathParts.OPERATIONS + "/" + IPathParts.FORECAST_RESULTS)
    Call<OperationAssignmentCollectionServerModel> getOperationsForecastResults(
        @Query(IRequestAndQueryParams.START_DATE)
            Date startDate,
        @Query(IRequestAndQueryParams.END_DATE)
            Date endDate,
        @Query(IRequestAndQueryParams.WORKPLACE_GROUP_NUMBER)
            String workplaceGroupNumber,
        @Query(IRequestAndQueryParams.WORKPLACE_NUMBER)
            String workplaceNumber,
        @Query(IRequestAndQueryParams.ERP_CONTEXT_ID)
            String erpContextId,
        @Query(IRequestAndQueryParams.WORKPLACE_GROUP_ID)
            String workplaceGroupId,
        @Query(IRequestAndQueryParams.USE_ORIGINAL_VALUES)
            boolean useOriginalValues,
        @Query(IRequestAndQueryParams.LIMIT)
            int limit,
        @Query(IRequestAndQueryParams.OFFSET)
            int offset);

    /**
     * Creates a call that can be sent to the server and saves an operation forecast result.
     *
     * @param operationId The operation ID.
     * @param model       The operation forecast result properties model.
     * @return A call that can be sent to the server.
     */
    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @PUT(IPathParts.OPERATIONS + "/{" + IRequestAndQueryParams.OPERATION_ID + "}/" + IPathParts.FORECAST_RESULT)
    Call<HALWSModel> saveOperationForecastResult(
        @Body
            OperationAssignmentWSModel model,
        @Path(IRequestAndQueryParams.OPERATION_ID)
            String operationId);

    /**
     * Creates a call that can be sent to the server and updates operation forecast results.
     *
     * @param forecastResults Set of operation forecast result properties models.
     * @return A call that can be sent to the server.
     */
    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @POST(IPathParts.OPERATIONS + "/" + IPathParts.FORECAST_RESULTS + "/" + IPathParts.UPDATE)
    Call<Void> updateOperationForecastResult(
        @Body
            UpdateOperationForecastRequestBody forecastResults);

    /**
     * Creates a call that can be sent to the server and deletes a forecast result by operation ID.
     *
     * @param operationId The operation ID.
     * @return A call that can be sent to the server.
     */
    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @DELETE(IPathParts.OPERATIONS + "/{" + IRequestAndQueryParams.OPERATION_ID + "}/" + IPathParts.FORECAST_RESULT)
    Call<Void> deleteOperationForecastResult(
        @Path(IRequestAndQueryParams.OPERATION_ID)
            String operationId);
}