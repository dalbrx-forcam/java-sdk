////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 19.12.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.order;

import com.forcam.na.ffwebservices.client.api.AbstractClient;
import com.forcam.na.ffwebservices.client.api.HALCollectionWSModel;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.client.api.exception.ForceAPIException;
import com.forcam.na.ffwebservices.client.api.order.request.*;
import com.forcam.na.ffwebservices.client.api.order.response.ProductionOrderOperationSequenceCollectionPage;
import com.forcam.na.ffwebservices.client.api.order.response.ProductionOrderOperationSequenceCollectionResponse;
import com.forcam.na.ffwebservices.client.api.order.response.ProductionOrderSchedulingResultCollectionPage;
import com.forcam.na.ffwebservices.client.api.order.response.ProductionOrderSchedulingResultCollectionResponse;
import com.forcam.na.ffwebservices.client.api.pagination.response.CollectionResponse;
import com.forcam.na.ffwebservices.client.api.pagination.response.Page;
import com.forcam.na.ffwebservices.model.order.ProductionOrderResponse;
import com.forcam.na.ffwebservices.model.order.ProductionOrderSpecificationResponse;
import retrofit2.Call;

import javax.inject.Inject;
import java.lang.reflect.Method;

/**
 * Requests production orders.
 */
public class ProductionOrderClient extends AbstractClient implements IProductionOrderClient {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The production order endpoint. */
    private final ProductionOrderEndpoint mProductionOrderEndpoint;

    /** The production order response builder. */
    private final IProductionOrderResponseBuilder mProductionOrderResponseBuilder;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     *
     * @param productionOrderEndpoint        Production order endpoint.
     * @param productionOrderResponseBuilder Production order response builder.
     */
    @Inject
    public ProductionOrderClient(ProductionOrderEndpoint productionOrderEndpoint, IProductionOrderResponseBuilder productionOrderResponseBuilder) {
        mProductionOrderEndpoint = productionOrderEndpoint;
        mProductionOrderResponseBuilder = productionOrderResponseBuilder;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public Page<ProductionOrderResponse> getProductionOrders(GetProductionOrdersRequest request) throws ForceAPIException {
        final Call<HALCollectionWSModel> call = mProductionOrderEndpoint.getProductionOrders(request.getProductionOrderNumber(),
                                                                                             request.getProductionOrderSplit(),
                                                                                             request.getMaterialNumber(),
                                                                                             request.getErpContextId(),
                                                                                             request.getStartDate(),
                                                                                             request.getEndDate(),
                                                                                             request.getLimit(),
                                                                                             request.getPaginationDirection(),
                                                                                             request.getPaginationTimestamp(),
                                                                                             request.getPaginationIdentifier(),
                                                                                             request
                                                                                                 .embed()
                                                                                                 .toString());
        final HALCollectionWSModel responseModel = this.getResponseModel(request, call);
        CollectionResponse<ProductionOrderResponse> response = mProductionOrderResponseBuilder.getProductionOrderCollectionResponse(request, responseModel);

        final Method m = new Object() {}
            .getClass()
            .getEnclosingMethod();
        return new Page<>(this, m, response);
    }

    @Override
    public Page<ProductionOrderResponse> searchProductionOrders(SearchProductionOrderRequest request) throws ForceAPIException {
        final Call<HALCollectionWSModel> call = mProductionOrderEndpoint.searchProductionOrders(request.getSearchProductionOrdersRequestBody(),
                                                                                                request.getLimit(),
                                                                                                request.getPaginationDirection(),
                                                                                                request.getPaginationTimestamp(),
                                                                                                request.getPaginationIdentifier(),
                                                                                                request
                                                                                                    .embed()
                                                                                                    .toString());

        final HALCollectionWSModel responseModel = this.getResponseModel(request, call);
        final CollectionResponse<ProductionOrderResponse> response = mProductionOrderResponseBuilder.getProductionOrderCollectionResponse(request,
                                                                                                                                          responseModel);

        final Method m = new Object() {}
            .getClass()
            .getEnclosingMethod();
        return new Page<>(this, m, response);
    }

    @Override
    public ProductionOrderResponse getProductionOrder(GetProductionOrderRequest request) throws ForceAPIException {
        final Call<HALWSModel> call = mProductionOrderEndpoint.getProductionOrder(request.getId(),
                                                                                  request
                                                                                      .embed()
                                                                                      .toString());
        final HALWSModel responseModel = this.getResponseModel(request, call);
        return mProductionOrderResponseBuilder.getProductionOrderResponse(responseModel);
    }

    @Override
    public ProductionOrderSpecificationResponse getProductionOrderSpecification(GetProductionOrderSpecificationRequest request) throws ForceAPIException {
        final Call<HALWSModel> call = mProductionOrderEndpoint.getProductionOrderSpecification(request.getId());
        final HALWSModel responseModel = this.getResponseModel(request, call);
        return mProductionOrderResponseBuilder.getProductionOrderSpecificationResponse(responseModel);
    }

    @Override
    public ProductionOrderOperationSequenceCollectionPage getProductionOrderOperationSequence(GetOperationSequenceRequest request) throws ForceAPIException {
        final Call<HALWSModel> call = mProductionOrderEndpoint.getProductionOrderOperationSequence(request.getProductionOrderId(),
                                                                                                   request.getOperationNumber(),
                                                                                                   request.getOperationSplit(),
                                                                                                   request.getMaterialNumber(),
                                                                                                   request.getWorkplaceNumber(),
                                                                                                   request.getPlannable(),
                                                                                                   request.getDispatched(),
                                                                                                   request.getOperationPhaseId(),
                                                                                                   request.getLimit(),
                                                                                                   request.getOffset());
        final HALWSModel responseModel = this.getResponseModel(request, call);
        final ProductionOrderOperationSequenceCollectionResponse response = mProductionOrderResponseBuilder.getOperationSequenceResponse(request,
                                                                                                                                         responseModel);

        final Method m = new Object() {}
            .getClass()
            .getEnclosingMethod();
        return new ProductionOrderOperationSequenceCollectionPage(this, m, response);
    }

    @Override
    public ProductionOrderSchedulingResultCollectionPage getProductionOrderSchedulingResults(GetProductionOrderSchedulingResultsRequest request)
        throws ForceAPIException {
        final Call<HALWSModel> call = mProductionOrderEndpoint.getProductionOrderSchedulingResults(request.getProductionOrderId(),
                                                                                                   request.getLimit(),
                                                                                                   request.getOffset());
        final HALWSModel responseModel = this.getResponseModel(request, call);
        final ProductionOrderSchedulingResultCollectionResponse response = mProductionOrderResponseBuilder.getProductionOrderSchedulingResultResponse(request,
                                                                                                                                                      responseModel);

        final Method m = new Object() {}
            .getClass()
            .getEnclosingMethod();
        return new ProductionOrderSchedulingResultCollectionPage(this, m, response);
    }

    @Override
    public ProductionOrderSchedulingResultCollectionPage setProductionOrderSchedulingResults(SetProductionOrderSchedulingResultRequest request)
        throws ForceAPIException {
        final Call<HALWSModel> call = mProductionOrderEndpoint.setProductionOrderSchedulingResults(request.getProductionOrderId(),
                                                                                                   request.getSchedulingResult());
        final HALWSModel responseModel = this.getResponseModel(request, call);
        final GetProductionOrderSchedulingResultsRequest getRequest = new GetProductionOrderSchedulingResultsRequest(request.getProductionOrderId());
        final ProductionOrderSchedulingResultCollectionResponse response = mProductionOrderResponseBuilder.getProductionOrderSchedulingResultResponse(getRequest,
                                                                                                                                                      responseModel);

        final Method m = new Object() {}
            .getClass()
            .getEnclosingMethod();
        return new ProductionOrderSchedulingResultCollectionPage(this, m, response);
    }
}