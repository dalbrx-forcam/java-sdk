////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 20.12.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.tool;

import com.forcam.na.ffwebservices.client.api.exception.ForceAPIException;
import com.forcam.na.ffwebservices.client.api.pagination.response.Page;
import com.forcam.na.ffwebservices.client.api.tool.request.*;
import com.forcam.na.ffwebservices.client.api.tool.response.CharacteristicCollectionPage;
import com.forcam.na.ffwebservices.model.tool.ToolEdgeResponse;
import com.forcam.na.ffwebservices.model.tool.ToolLocationResponse;
import com.forcam.na.ffwebservices.model.tool.ToolResponse;

/**
 * An interface with methods that request tools.
 */
public interface IToolClient {

    /**
     * Sends a request to the server and gets a collection of tools as response.
     *
     * @param request A collection of parameters.
     * @return The tool collection response.
     * @throws ForceAPIException When unable to get tools.
     */
    Page<ToolResponse> getTools(GetToolsRequest request) throws ForceAPIException;

    /**
     * Sends a creation request to the server and gets the new tool model as response.
     *
     * @param request A collection of parameters.
     * @return A tool model.
     * @throws ForceAPIException When unable to create tool.
     */
    ToolResponse createTool(CreateToolRequest request) throws ForceAPIException;

    /**
     * Sends a request to the server and gets a tool model as response.
     *
     * @param request A collection of parameters.
     * @return A tool model.
     * @throws ForceAPIException When unable to get tool.
     */
    ToolResponse getTool(GetToolRequest request) throws ForceAPIException;

    /**
     * Sends a deletion request to the server.
     *
     * @param request A collection of parameters.
     * @throws ForceAPIException When unable to delete tool.
     */
    void deleteTool(DeleteToolRequest request) throws ForceAPIException;

    /**
     * Sends a request to the server and gets a collection of characteristics of a tool as response.
     *
     * @param request A collection of parameters.
     * @return The characteristic collection response.
     * @throws ForceAPIException When unable to get characteristics.
     */
    CharacteristicCollectionPage getCharacteristics(GetToolCharacteristicsRequest request) throws ForceAPIException;

    /**
     * Sends a put request to the server and gets a collection of characteristics of a tool as response.
     *
     * @param request A collection of parameters.
     * @return The characteristic collection response.
     * @throws ForceAPIException When unable to put characteristics.
     */
    CharacteristicCollectionPage putCharacteristics(PutToolCharacteristicsRequest request) throws ForceAPIException;

    /**
     * Sends a request to the server and gets a collection of cut edges of a tool as response.
     *
     * @param request A collection of parameters.
     * @return The cut edge collection response.
     * @throws ForceAPIException When unable to get edges.
     */
    Page<ToolEdgeResponse> getEdges(GetToolEdgesRequest request) throws ForceAPIException;

    /**
     * Sends a creation request to the server and gets the new tool cut edge model as response.
     *
     * @param request A collection of parameters.
     * @return A cut edge model.
     * @throws ForceAPIException When unable to create edge.
     */
    ToolEdgeResponse createEdge(CreateToolEdgeRequest request) throws ForceAPIException;

    /**
     * Sends a request to the server and gets a cut edge of a tool as response.
     *
     * @param request A collection of parameters.
     * @return A cut edge model.
     * @throws ForceAPIException When unable to get edge.
     */
    ToolEdgeResponse getEdge(GetToolEdgeRequest request) throws ForceAPIException;

    /**
     * Sends an update request to the server and gets the updated tool cut edge as response.
     *
     * @param request A collection of parameters.
     * @return A cut edge model.
     * @throws ForceAPIException When unable to update edge.
     */
    ToolEdgeResponse updateEdge(UpdateToolEdgeRequest request) throws ForceAPIException;

    /**
     * Sends a request to the server and gets a collection of characteristics of a tool cut edge as response.
     *
     * @param request A collection of parameters.
     * @return The characteristic collection response.
     * @throws ForceAPIException When unable to get edge characteristics.
     */
    CharacteristicCollectionPage getEdgeCharacteristics(GetToolEdgeCharacteristicsRequest request) throws ForceAPIException;

    /**
     * Sends a put request to the server and gets a collection of characteristics of a tool cut edge as response.
     *
     * @param request A collection of parameters.
     * @return The characteristic collection response.
     * @throws ForceAPIException When unable to put edge characteristics.
     */
    CharacteristicCollectionPage putEdgeCharacteristics(PutToolEdgeCharacteristicsRequest request) throws ForceAPIException;

    /**
     * Sends a request to the server and gets a location of a tool as response.
     *
     * @param request A collection of parameters.
     * @return A location model.
     * @throws ForceAPIException When unable to get location.
     */
    ToolLocationResponse getLocation(GetToolLocationRequest request) throws ForceAPIException;

    /**
     * Sends a put request to the server and gets the updated tool location as response.
     *
     * @param request A collection of parameters.
     * @return A location model.
     * @throws ForceAPIException When unable to put location.
     */
    ToolLocationResponse putLocation(PutToolLocationRequest request) throws ForceAPIException;

    /**
     * Sends a deletion request to the server and gets the deleted tool location as response.
     *
     * @param request A collection of parameters.
     * @throws ForceAPIException When unable to delete location.
     */
    void deleteLocation(DeleteToolLocationRequest request) throws ForceAPIException;

    /**
     * Sends a tool state request to the server and gets a tool as response.
     *
     * @param request A collection of parameters.
     * @return A tool model.
     * @throws ForceAPIException When unable to set tool state.
     */
    ToolResponse setToolState(SetToolStateRequest request) throws ForceAPIException;
}