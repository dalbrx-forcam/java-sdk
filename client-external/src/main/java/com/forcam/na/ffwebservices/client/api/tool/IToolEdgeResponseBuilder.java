////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 21.12.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.tool;

import com.forcam.na.ffwebservices.client.api.pagination.response.CollectionResponse;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.client.api.HALCollectionWSModel;
import com.forcam.na.ffwebservices.client.api.tool.request.GetToolEdgesRequest;
import com.forcam.na.ffwebservices.model.tool.ToolEdgeResponse;

/**
 * Contains methods for building responses for cut edges of tools.
 */
public interface IToolEdgeResponseBuilder {

    /**
     * Transforms a collection model to a tool cut edge collection response.
     *
     * @param request         The request.
     * @param collectionModel A collection model.
     * @return A tool cut edge collection response.
     */
    CollectionResponse<ToolEdgeResponse> getToolEdgeCollectionResponse(GetToolEdgesRequest request, HALCollectionWSModel collectionModel);

    /**
     * Converts HAL model to a tool cut edge model.
     *
     * @param serverModel The server model.
     * @return A tool cut edge model.
     */
    ToolEdgeResponse getToolEdgeResponse(HALWSModel serverModel);
}