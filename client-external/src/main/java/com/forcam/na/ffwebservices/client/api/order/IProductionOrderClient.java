////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 19.12.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.order;

import com.forcam.na.ffwebservices.client.api.exception.ForceAPIException;
import com.forcam.na.ffwebservices.client.api.order.request.*;
import com.forcam.na.ffwebservices.client.api.order.response.ProductionOrderOperationSequenceCollectionPage;
import com.forcam.na.ffwebservices.client.api.order.response.ProductionOrderSchedulingResultCollectionPage;
import com.forcam.na.ffwebservices.client.api.pagination.response.Page;
import com.forcam.na.ffwebservices.model.order.ProductionOrderResponse;
import com.forcam.na.ffwebservices.model.order.ProductionOrderSpecificationResponse;

/**
 * An interface with methods that request production orders.
 */
public interface IProductionOrderClient {

    /**
     * Sends a request to the server and gets a collection of production orders as response.
     *
     * @param request A collection of parameters.
     * @return Production order collection response.
     * @throws ForceAPIException When unable to get production orders.
     */
    Page<ProductionOrderResponse> getProductionOrders(GetProductionOrdersRequest request) throws ForceAPIException;

    /**
     * Sends a post request to the server and gets a collection of searched production orders as response.
     *
     * @param request A collection of parameters to search production orders.
     * @return Production order collection response.
     * @throws ForceAPIException When unable to get production orders.
     */
    Page<ProductionOrderResponse> searchProductionOrders(SearchProductionOrderRequest request) throws ForceAPIException;

    /**
     * Sends a request to the server and gets a production order model as response.
     *
     * @param request A collection of parameters.
     * @return Production order server model.
     * @throws ForceAPIException When unable to get production order.
     */
    ProductionOrderResponse getProductionOrder(GetProductionOrderRequest request) throws ForceAPIException;

    /**
     * Sends a request to the server and gets a production order specification model as response.
     *
     * @param request A collection of parameters.
     * @return Production order server model.
     * @throws ForceAPIException When unable to get production order.
     */
    ProductionOrderSpecificationResponse getProductionOrderSpecification(GetProductionOrderSpecificationRequest request) throws ForceAPIException;

    /**
     * Sends a request to the server and gets the operation sequence for a production order.
     *
     * @param request A collection of parameters.
     * @return Production order operation sequence server model.
     * @throws ForceAPIException When unable to get operations of production order.
     */
    ProductionOrderOperationSequenceCollectionPage getProductionOrderOperationSequence(GetOperationSequenceRequest request) throws ForceAPIException;

    /**
     * Sends a request to the server and gets the scheduling results for a production order.
     *
     * @param request A collection of parameters.
     * @return Production order operation sequence server model.
     * @throws ForceAPIException When unable to get scheduling result of production order.
     */
    ProductionOrderSchedulingResultCollectionPage getProductionOrderSchedulingResults(GetProductionOrderSchedulingResultsRequest request)
        throws ForceAPIException;

    /**
     * Sends a request to the server and gets the operation sequence for a production order.
     *
     * @param request A collection of parameters.
     * @return Production order operation sequence server model.
     * @throws ForceAPIException When unable to set scheduling result of production order.
     */
    ProductionOrderSchedulingResultCollectionPage setProductionOrderSchedulingResults(SetProductionOrderSchedulingResultRequest request)
        throws ForceAPIException;
}