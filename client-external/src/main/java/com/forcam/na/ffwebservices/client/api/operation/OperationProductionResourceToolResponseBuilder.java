////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 13.12.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.operation;

import com.forcam.na.ffwebservices.client.api.AbstractResponseBuilder;
import com.forcam.na.ffwebservices.client.api.HALCollectionWSModel;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.client.api.literal.LiteralLinkModelBuilder;
import com.forcam.na.ffwebservices.client.api.operation.request.GetOperationProductionResourcesAndToolsRequest;
import com.forcam.na.ffwebservices.client.api.pagination.response.CollectionResponse;
import com.forcam.na.ffwebservices.model.LinkEmbeddedWSModel;
import com.forcam.na.ffwebservices.model.literal.LiteralPropertiesWSModel;
import com.forcam.na.ffwebservices.model.operation.OperationProductionResourceToolEmbed;
import com.forcam.na.ffwebservices.model.operation.ProductionResourceToolPropertiesWSModel;
import com.forcam.na.ffwebservices.model.operation.ProductionResourceToolResponse;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Builds responses for production resources and tools of operations.
 */
public class OperationProductionResourceToolResponseBuilder extends AbstractResponseBuilder implements IOperationProductionResourceToolResponseBuilder {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The link model builder of a literal. */
    private final LiteralLinkModelBuilder mLiteralLinkModelBuilder;

    /**
     * Creates a new instance.
     *
     * @param literalLinkModelBuilder Literal link model builder.
     */
    @Inject
    public OperationProductionResourceToolResponseBuilder(LiteralLinkModelBuilder literalLinkModelBuilder) {
        mLiteralLinkModelBuilder = literalLinkModelBuilder;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public CollectionResponse<ProductionResourceToolResponse> getOperationProductionResourceToolCollectionResponse(
            GetOperationProductionResourcesAndToolsRequest request, HALCollectionWSModel collectionModel) {
        final CollectionResponse<ProductionResourceToolResponse> collectionResponse = new CollectionResponse<>(request);
        this.initializeCollectionResponse(collectionModel, collectionResponse);

        final Map<String, List<HALWSModel>> embedded = collectionModel.getEmbedded();
        final List<HALWSModel> productionResourcesAndTools = embedded.get("productionResourcesAndTools");

        final List<ProductionResourceToolResponse> productionResourceToolModels = productionResourcesAndTools
            .stream()
            .map(this::getOperationProductionResourceToolResponse)
            .collect(Collectors.toList());

        collectionResponse.setEmbedded(productionResourceToolModels);
        return collectionResponse;
    }

    @Override
    public ProductionResourceToolResponse getOperationProductionResourceToolResponse(HALWSModel serverModel) {
        final ProductionResourceToolResponse productionResourceToolModel = new ProductionResourceToolResponse();
        productionResourceToolModel.setProperties(mMapper.convertValue(serverModel.getProperties(), ProductionResourceToolPropertiesWSModel.class));

        final LinkEmbeddedWSModel<Object> selfLink = this.createSelfLinkModel(serverModel);
        productionResourceToolModel.setSelf(selfLink);

        final LinkEmbeddedWSModel<LiteralPropertiesWSModel> description = mLiteralLinkModelBuilder.buildLinkModel(serverModel,
                                                                                                                  OperationProductionResourceToolEmbed.DESCRIPTION);
        productionResourceToolModel.setDescription(description);

        return productionResourceToolModel;
    }
}