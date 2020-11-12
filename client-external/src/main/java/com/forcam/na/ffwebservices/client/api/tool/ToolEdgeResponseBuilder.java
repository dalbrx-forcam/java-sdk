////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 21.12.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.tool;

import com.forcam.na.ffwebservices.client.api.AbstractResponseBuilder;
import com.forcam.na.ffwebservices.client.api.pagination.response.CollectionResponse;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.client.api.HALCollectionWSModel;
import com.forcam.na.ffwebservices.client.api.tool.request.GetToolEdgesRequest;
import com.forcam.na.ffwebservices.model.tool.ToolEdgePropertiesWSModel;
import com.forcam.na.ffwebservices.model.tool.ToolEdgeResponse;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Builds responses for cut edges of tools.
 */
public class ToolEdgeResponseBuilder extends AbstractResponseBuilder implements IToolEdgeResponseBuilder {

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    @Inject
    public ToolEdgeResponseBuilder() {
        //empty
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public CollectionResponse<ToolEdgeResponse> getToolEdgeCollectionResponse(GetToolEdgesRequest request, HALCollectionWSModel collectionModel) {
        final CollectionResponse<ToolEdgeResponse> collectionResponse = new CollectionResponse<>(request);
        this.initializeCollectionResponse(collectionModel, collectionResponse);

        final Map<String, List<HALWSModel>> embedded = collectionModel.getEmbedded();
        final List<HALWSModel> edges = embedded.get("edges");

        final List<ToolEdgeResponse> edgeModels = edges
            .stream()
            .map(this::getToolEdgeResponse)
            .collect(Collectors.toList());

        collectionResponse.setEmbedded(edgeModels);
        return collectionResponse;
    }

    @Override
    public ToolEdgeResponse getToolEdgeResponse(HALWSModel serverModel) {
        final ToolEdgeResponse edgeModel = new ToolEdgeResponse();
        final ToolEdgePropertiesWSModel properties = mMapper.convertValue(serverModel.getProperties(), ToolEdgePropertiesWSModel.class);
        edgeModel.setProperties(properties);

        return edgeModel;
    }
}