////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 19.12.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.order;

import com.forcam.na.ffwebservices.client.api.AbstractResponseBuilder;
import com.forcam.na.ffwebservices.client.api.HALCollectionWSModel;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.client.api.erpcontext.ERPContextLinkModelBuilder;
import com.forcam.na.ffwebservices.client.api.literal.LiteralLinkModelBuilder;
import com.forcam.na.ffwebservices.client.api.operation.OperationLinkModelBuilder;
import com.forcam.na.ffwebservices.client.api.order.request.GetOperationSequenceRequest;
import com.forcam.na.ffwebservices.client.api.order.response.ProductionOrderOperationSequenceCollectionResponse;
import com.forcam.na.ffwebservices.client.api.order.response.ProductionOrderSchedulingResultCollectionResponse;
import com.forcam.na.ffwebservices.client.api.pagination.response.CollectionResponse;
import com.forcam.na.ffwebservices.client.api.pagination.request.PaginationRequest;
import com.forcam.na.ffwebservices.model.LinkEmbeddedWSModel;
import com.forcam.na.ffwebservices.model.erpcontext.ErpContextPropertiesWSModel;
import com.forcam.na.ffwebservices.model.literal.LiteralPropertiesWSModel;
import com.forcam.na.ffwebservices.model.operation.OperationPropertiesWSModel;
import com.forcam.na.ffwebservices.model.order.OrderPropertiesWSModel;
import com.forcam.na.ffwebservices.model.order.ProductionOrderEmbed;
import com.forcam.na.ffwebservices.model.order.ProductionOrderOperationSequencePropertiesWSModel;
import com.forcam.na.ffwebservices.model.order.ProductionOrderResponse;
import com.forcam.na.ffwebservices.model.order.ProductionOrderSchedulingResultPropertiesWSModel;
import com.forcam.na.ffwebservices.model.order.ProductionOrderSpecificationPropertiesWSModel;
import com.forcam.na.ffwebservices.model.order.ProductionOrderSpecificationResponse;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Builds responses for production orders.
 */
public class ProductionOrderResponseBuilder extends AbstractResponseBuilder implements IProductionOrderResponseBuilder {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The link model builder of a literal. */
    private final LiteralLinkModelBuilder mLiteralLinkModelBuilder;

    /** The link model builder of the ERP context. */
    private final ERPContextLinkModelBuilder mERPContextLinkModelBuilder;

    /** The operation link model builder. */
    private final OperationLinkModelBuilder mOperationLinkModelBuilder;

    /** The specification link model builder. */
    private final ProductionOrderSpecificationLinkModelBuilder mProductionOrderSpecificationLinkModelBuilder;

    /** The operation sequence link model builder. */
    private final ProductionOrderOperationSequenceLinkModelBuilder mProductionOrderOperationSequenceLinkModelBuilder;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     *
     * @param operationLinkModelBuilder                        Operation link model builder.
     * @param erpContextLinkModelBuilder                       ERP context link model builder.
     * @param literalLinkModelBuilder                          Literal link model builder.
     * @param productionOrderOperationSequenceLinkModelBuilder Production order operation sequence link model builder.
     * @param productionOrderSpecificationLinkModelBuilder     Production order specification link model builder.
     */
    @Inject
    public ProductionOrderResponseBuilder(LiteralLinkModelBuilder literalLinkModelBuilder, ERPContextLinkModelBuilder erpContextLinkModelBuilder,
                                          OperationLinkModelBuilder operationLinkModelBuilder,
                                          ProductionOrderSpecificationLinkModelBuilder productionOrderSpecificationLinkModelBuilder,
                                          ProductionOrderOperationSequenceLinkModelBuilder productionOrderOperationSequenceLinkModelBuilder) {
        mLiteralLinkModelBuilder = literalLinkModelBuilder;
        mERPContextLinkModelBuilder = erpContextLinkModelBuilder;
        mOperationLinkModelBuilder = operationLinkModelBuilder;
        mProductionOrderSpecificationLinkModelBuilder = productionOrderSpecificationLinkModelBuilder;
        mProductionOrderOperationSequenceLinkModelBuilder = productionOrderOperationSequenceLinkModelBuilder;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public CollectionResponse<ProductionOrderResponse> getProductionOrderCollectionResponse(PaginationRequest request, HALCollectionWSModel collectionModel) {

        final CollectionResponse<ProductionOrderResponse> collectionResponse = new CollectionResponse<>(request);
        this.initializeCollectionResponse(collectionModel, collectionResponse);
        final Map<String, List<HALWSModel>> embedded = collectionModel.getEmbedded();
        final List<HALWSModel> productionOrders = embedded.get("productionOrders");

        final List<ProductionOrderResponse> productionOrderModels = productionOrders
            .stream()
            .map(this::getProductionOrderResponse)
            .collect(Collectors.toList());

        collectionResponse.setEmbedded(productionOrderModels);
        return collectionResponse;
    }

    @Override
    public ProductionOrderResponse getProductionOrderResponse(HALWSModel serverModel) {
        final ProductionOrderResponse productionOrderModel = new ProductionOrderResponse();
        productionOrderModel.setProperties(mMapper.convertValue(serverModel.getProperties(), OrderPropertiesWSModel.class));

        final LinkEmbeddedWSModel<Object> selfLink = this.createSelfLinkModel(serverModel);
        productionOrderModel.setSelf(selfLink);

        final LinkEmbeddedWSModel<LiteralPropertiesWSModel> description = mLiteralLinkModelBuilder.buildLinkModel(serverModel,
                                                                                                                  ProductionOrderEmbed.DESCRIPTION);
        productionOrderModel.setDescription(description);

        final LinkEmbeddedWSModel<ErpContextPropertiesWSModel> erpContext = mERPContextLinkModelBuilder.buildLinkModel(serverModel,
                                                                                                                       ProductionOrderEmbed.ERP_CONTEXT);
        productionOrderModel.setErpContext(erpContext);

        final List<LinkEmbeddedWSModel<OperationPropertiesWSModel>> operations = mOperationLinkModelBuilder.buildListOfLinkModels(serverModel,
                                                                                                                                  ProductionOrderEmbed.OPERATIONS);
        productionOrderModel.setOperations(operations);

        final LinkEmbeddedWSModel<ProductionOrderSpecificationPropertiesWSModel> specification = mProductionOrderSpecificationLinkModelBuilder.buildLinkModel(
            serverModel,
            ProductionOrderEmbed.SPECIFICATION);
        productionOrderModel.setProductionOrderSpecification(specification);

        final LinkEmbeddedWSModel<ProductionOrderOperationSequencePropertiesWSModel> sequence = mProductionOrderOperationSequenceLinkModelBuilder.buildLinkModel(
            serverModel,
            ProductionOrderEmbed.OPERATION_SEQUENCE);
        productionOrderModel.setProductionOrderOperationSequence(sequence);

        return productionOrderModel;
    }

    @Override
    public ProductionOrderSpecificationResponse getProductionOrderSpecificationResponse(HALWSModel model) {
        final ProductionOrderSpecificationResponse response = new ProductionOrderSpecificationResponse();
        response.setProperties(mMapper.convertValue(model.getProperties(), ProductionOrderSpecificationPropertiesWSModel.class));

        final LinkEmbeddedWSModel<Object> selfLink = this.createSelfLinkModel(model);
        response.setSelf(selfLink);

        return response;
    }

    @Override
    public ProductionOrderOperationSequenceCollectionResponse getOperationSequenceResponse(GetOperationSequenceRequest request, HALWSModel serverModel) {
        final ProductionOrderOperationSequenceCollectionResponse response = new ProductionOrderOperationSequenceCollectionResponse(request);
        response.setProperties(mMapper.convertValue(serverModel.getProperties(), ProductionOrderOperationSequencePropertiesWSModel.class));
        response.setPagination(serverModel.getPagination());
        response.setPaginationLinks(serverModel.getLinkModels());

        return response;
    }

    @Override
    public ProductionOrderSchedulingResultCollectionResponse getProductionOrderSchedulingResultResponse(PaginationRequest request, HALWSModel serverModel) {
        final ProductionOrderSchedulingResultCollectionResponse response = new ProductionOrderSchedulingResultCollectionResponse(request);
        response.setProperties(mMapper.convertValue(serverModel.getProperties(), ProductionOrderSchedulingResultPropertiesWSModel.class));
        response.setPagination(serverModel.getPagination());
        response.setPaginationLinks(serverModel.getLinkModels());

        return response;
    }
}
