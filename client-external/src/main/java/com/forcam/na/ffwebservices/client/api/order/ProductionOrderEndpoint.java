////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 19.12.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.order;

import com.forcam.na.common.webserviceaccess.requestparams.PaginationDirection;
import com.forcam.na.ffwebservices.client.api.HALCollectionWSModel;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.model.IPathParts;
import com.forcam.na.ffwebservices.model.IRequestAndQueryParams;
import com.forcam.na.ffwebservices.model.definition.OperationPhase;
import com.forcam.na.ffwebservices.model.order.IOrderPaths;
import com.forcam.na.ffwebservices.model.order.ProductionOrderSchedulingResultPropertiesWSModel;
import com.forcam.na.ffwebservices.model.order.SearchProductionOrdersRequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
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
public interface ProductionOrderEndpoint {

	// ------------------------------------------------------------------------
	// members
	// ------------------------------------------------------------------------

	/** Base relative url for the production order search. */
	String BASE_RELATIVE_URL_PRODUCTION_ORDERS = IOrderPaths.PRODUCTION_ORDERS;
	/** Header content type for the requests. */
	String APPLICATION_JSON_CONTENT_TYPE = "Content-Type: application/json";

	// ------------------------------------------------------------------------
	// methods
	// ------------------------------------------------------------------------

	/**
	 * Creates a call that can be sent to the server.
	 *
	 * @param productionOrderNumber The production order number,
	 * @param productionOrderSplit  The production order split.
	 * @param paginationIdentifier  The pagination identifier.
	 * @param paginationDirection   The pagination direction.
	 * @param paginationTimestamp   The pagination timestamp.
	 * @param materialNumber        The material number.
	 * @param erpContextId          The ERP context ID.
	 * @param startDate             The start date.
	 * @param endDate               The end date.
	 * @param limit                 The limit.
	 * @param embed                 The resources which shall be embedded.
	 * @return A call that can be sent to the server.
	 */
	@Headers(APPLICATION_JSON_CONTENT_TYPE)
	@GET(BASE_RELATIVE_URL_PRODUCTION_ORDERS)
	Call<HALCollectionWSModel> getProductionOrders(
		@Query(IRequestAndQueryParams.PRODUCTION_ORDER_NUMBER)
			String productionOrderNumber,
		@Query(IRequestAndQueryParams.PRODUCTION_ORDER_SPLIT)
			String productionOrderSplit,
		@Query(IRequestAndQueryParams.MATERIAL_NUMBER)
			String materialNumber,
		@Query(IRequestAndQueryParams.ERP_CONTEXT_ID)
			String erpContextId,
		@Query(IRequestAndQueryParams.START_DATE)
			Date startDate,
		@Query(IRequestAndQueryParams.END_DATE)
			Date endDate,
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

	/**
	 * Creates a call that can be sent to the server.
	 *
	 * @param productionOrderId The production order ID.
	 * @param embed             The resources which shall be embedded.
	 * @return A call that can be sent to the server.
	 */
	@Headers(APPLICATION_JSON_CONTENT_TYPE)
	@GET(BASE_RELATIVE_URL_PRODUCTION_ORDERS + "/{" + IRequestAndQueryParams.PRODUCTION_ORDER_ID + "}")
	Call<HALWSModel> getProductionOrder(
		@Path(IRequestAndQueryParams.PRODUCTION_ORDER_ID)
			String productionOrderId,
		@Query(IRequestAndQueryParams.EMBED)
			String embed);

	/**
	 * Creates a call that can be sent to the server.
	 *
	 * @param productionOrderId The production order ID.
	 * @return A call that can be sent to the server.
	 */
	@Headers(APPLICATION_JSON_CONTENT_TYPE)
	@GET(BASE_RELATIVE_URL_PRODUCTION_ORDERS + "/{" + IRequestAndQueryParams.PRODUCTION_ORDER_ID + "}/" + IPathParts.SPECIFICATION)
	Call<HALWSModel> getProductionOrderSpecification(
		@Path(IRequestAndQueryParams.PRODUCTION_ORDER_ID)
			String productionOrderId);

	/**
	 * Search the production orders based on the given parameters.
	 *
	 * @param body                 Request body containing the filter parameters.
	 * @param limit                The limit.
	 * @param paginationDirection  The pagination direction.
	 * @param paginationTimestamp  The pagination timestamp.
	 * @param paginationIdentifier The pagination identifier.
	 * @param embed                The resources which shall be embedded.
	 * @return A call that can be sent to the server and gets searched production orders.
	 */
	@Headers(APPLICATION_JSON_CONTENT_TYPE)
	@POST(BASE_RELATIVE_URL_PRODUCTION_ORDERS + "/" + IPathParts.SEARCH)
	Call<HALCollectionWSModel> searchProductionOrders(
		@Body
			SearchProductionOrdersRequestBody body,
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

	/**
	 * Creates a call that can be sent to the server.
	 *
	 * @param productionOrderId The production order ID.
	 * @param operationNumber   The operation number.
	 * @param operationSplit    The operation split.
	 * @param materialNumber    The material number.
	 * @param workplaceNumber   The workplace number.
	 * @param isPlannable       The flag if operation is plannable.
	 * @param isDispatched      The flag if the operation is dispatched.
	 * @param operationPhaseId  The operation phase ID.
	 * @param limit             The limit.
	 * @param offset            The offset.
	 * @return A call that can be sent to the server.
	 */
	@Headers({"Content-Type: application/json","Accept: application/hal+json"} )
	@GET(BASE_RELATIVE_URL_PRODUCTION_ORDERS + "/{" + IRequestAndQueryParams.PRODUCTION_ORDER_ID + "}/" + IOrderPaths.OPERATION_SEQUENCE)
	Call<HALWSModel> getProductionOrderOperationSequence(
		@Path(IRequestAndQueryParams.PRODUCTION_ORDER_ID)
			String productionOrderId,
		@Query(IRequestAndQueryParams.OPERATION_NUMBER)
			String operationNumber,
		@Query(IRequestAndQueryParams.OPERATION_SPLIT)
			String operationSplit,
		@Query(IRequestAndQueryParams.MATERIAL_NUMBER)
			String materialNumber,
		@Query(IRequestAndQueryParams.WORKPLACE_NUMBER)
			String workplaceNumber,
		@Query(IRequestAndQueryParams.IS_PLANNABLE)
			Boolean isPlannable,
		@Query(IRequestAndQueryParams.IS_DISPATCHED)
			Boolean isDispatched,
		@Query(IRequestAndQueryParams.OPERATION_PHASE_ID)
			OperationPhase operationPhaseId,
		@Query(IRequestAndQueryParams.LIMIT)
			int limit,
		@Query(IRequestAndQueryParams.OFFSET)
			int offset);

	/**
	 * Creates a call that can be sent to the server and gets production order scheduling results.
	 *
	 * @param productionOrderId The production order ID.
	 * @param limit             The limit.
	 * @param offset            The offset.
	 * @return A call that can be sent to the server.
	 */
	@Headers({"Content-Type: application/json","Accept: application/hal+json"} )
	@GET(BASE_RELATIVE_URL_PRODUCTION_ORDERS + "/{" + IRequestAndQueryParams.PRODUCTION_ORDER_ID + "}/" + IOrderPaths.SCHEDULED_DATES)
	Call<HALWSModel> getProductionOrderSchedulingResults(
		@Path(IRequestAndQueryParams.PRODUCTION_ORDER_ID)
			String productionOrderId,
		@Query(IRequestAndQueryParams.LIMIT)
			int limit,
		@Query(IRequestAndQueryParams.OFFSET)
			int offset);

	/**
	 * Creates a call that can be sent to the server and sets production order scheduling results.
	 *
	 * @param productionOrderId The production order ID.
	 * @param schedulingResults The production order scheduling results properties.
	 * @return A call that can be sent to the server.
	 */
	@Headers({"Content-Type: application/json","Accept: application/hal+json"} )
	@PUT(BASE_RELATIVE_URL_PRODUCTION_ORDERS + "/{" + IRequestAndQueryParams.PRODUCTION_ORDER_ID + "}/" + IOrderPaths.SCHEDULED_DATES)
	Call<HALWSModel> setProductionOrderSchedulingResults(
		@Path(IRequestAndQueryParams.PRODUCTION_ORDER_ID)
			String productionOrderId,
		@Body()
			ProductionOrderSchedulingResultPropertiesWSModel schedulingResults);

}
