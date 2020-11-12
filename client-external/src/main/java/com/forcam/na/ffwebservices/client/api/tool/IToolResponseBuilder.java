////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 20.12.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.tool;

import com.forcam.na.ffwebservices.client.api.pagination.response.CollectionResponse;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.client.api.HALCollectionWSModel;
import com.forcam.na.ffwebservices.client.api.tool.request.GetToolsRequest;
import com.forcam.na.ffwebservices.model.tool.ToolResponse;

/**
 * Contains methods for building responses for tools.
 */
public interface IToolResponseBuilder {

    /**
     * Transforms a collection model to a tool collection response.
     *
     * @param request         The request.
     * @param collectionModel A collection model.
     * @return A tool collection response.
     */
    CollectionResponse<ToolResponse> getToolCollectionResponse(GetToolsRequest request, HALCollectionWSModel collectionModel);

    /**
     * Converts HAL model to a tool model.
     *
     * @param serverModel The server model.
     * @return A tool model.
     */
    ToolResponse getToolResponse(HALWSModel serverModel);
}