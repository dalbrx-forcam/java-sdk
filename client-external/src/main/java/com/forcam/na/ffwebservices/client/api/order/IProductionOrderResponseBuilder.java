////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 19.12.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.order;

import com.forcam.na.ffwebservices.client.api.order.request.GetOperationSequenceRequest;
import com.forcam.na.ffwebservices.client.api.order.response.ProductionOrderOperationSequenceCollectionResponse;
import com.forcam.na.ffwebservices.client.api.order.response.ProductionOrderSchedulingResultCollectionResponse;
import com.forcam.na.ffwebservices.client.api.pagination.response.CollectionResponse;
import com.forcam.na.ffwebservices.client.api.pagination.request.PaginationRequest;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.client.api.HALCollectionWSModel;
import com.forcam.na.ffwebservices.model.order.ProductionOrderResponse;
import com.forcam.na.ffwebservices.model.order.ProductionOrderSpecificationResponse;

/**
 * Contains methods for building responses for production orders.
 */
public interface IProductionOrderResponseBuilder {

    /**
     * Transforms a collection model into a production order collection response.
     *
     * @param request         The request.
     * @param collectionModel A collection model.
     * @return A production order collection response.
     */
    CollectionResponse<ProductionOrderResponse> getProductionOrderCollectionResponse(PaginationRequest request, HALCollectionWSModel collectionModel);

    /**
     * Converts HAL model into a production order model.
     *
     * @param model The model received by the server.
     * @return A production order model.
     */
    ProductionOrderResponse getProductionOrderResponse(HALWSModel model);

    /**
     * Converts HAL model into a production order specification model.
     *
     * @param model The model received by the server.
     * @return A production order model.
     */
    ProductionOrderSpecificationResponse getProductionOrderSpecificationResponse(HALWSModel model);

    /**
     * Transforms a HAL model into a production order operation sequence response.
     *
     * @param request     The request.
     * @param serverModel The model.
     * @return The production order operation sequence response.
     */
    ProductionOrderOperationSequenceCollectionResponse getOperationSequenceResponse(GetOperationSequenceRequest request, HALWSModel serverModel);

    /**
     * Transforms a HAL model into a production order scheduling result response.
     *
     * @param serverModel The model received by the server.
     * @param request     The pagination request.
     * @return The production order scheduling result response.
     */
    ProductionOrderSchedulingResultCollectionResponse getProductionOrderSchedulingResultResponse(PaginationRequest request, HALWSModel serverModel);

}