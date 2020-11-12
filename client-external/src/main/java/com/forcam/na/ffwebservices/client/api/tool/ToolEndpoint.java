////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 20.12.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.tool;

import com.forcam.na.ffwebservices.client.api.HALCollectionWSModel;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.model.IPathParts;
import com.forcam.na.ffwebservices.model.IRequestAndQueryParams;
import com.forcam.na.ffwebservices.model.tool.CharacteristicGeneralDefinition;
import com.forcam.na.ffwebservices.model.tool.CreateToolEdgePropertiesWSModel;
import com.forcam.na.ffwebservices.model.tool.CreateToolLocationPropertiesWSModel;
import com.forcam.na.ffwebservices.model.tool.CreateToolPropertiesWSModel;
import com.forcam.na.ffwebservices.model.tool.IToolPaths;
import com.forcam.na.ffwebservices.model.tool.ToolEdgePropertiesWSModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.util.List;

/**
 * An interface with methods for creating calls that can be sent to the server.
 */
public interface ToolEndpoint {

    /**
     * Creates a call that can be sent to the server.
     *
     * @param identifier  The first tool identifier.
     * @param identifier2 The second tool identifier.
     * @param identifier3 The third tool identifier.
     * @param limit       The limit.
     * @param offset      The offset.
     * @param embed       The resources which shall be embedded.
     * @return A call that can be sent to the server.
     */
    @Headers({ "Content-Type: application/json", "Accept: application/hal+json" })
    @GET(IToolPaths.TOOLS)
    Call<HALCollectionWSModel> getTools(
        @Query(IRequestAndQueryParams.IDENTIFIER)
            String identifier,
        @Query(IRequestAndQueryParams.IDENTIFIER2)
            String identifier2,
        @Query(IRequestAndQueryParams.IDENTIFIER3)
            String identifier3,
        @Query(IRequestAndQueryParams.LIMIT)
            int limit,
        @Query(IRequestAndQueryParams.OFFSET)
            int offset,
        @Query(IRequestAndQueryParams.EMBED)
            String embed);

    /**
     * Creates a call that can be sent to the server.
     *
     * @param toolData The tool data.
     * @return A call that can be sent to the server.
     */
    @Headers({ "Content-Type: application/json", "Accept: application/hal+json" })
    @POST(IToolPaths.TOOLS)
    Call<HALWSModel> createTool(
        @Body
            CreateToolPropertiesWSModel toolData);

    /**
     * Creates a call that can be sent to the server.
     *
     * @param toolId The tool ID.
     * @param embed  The resources which shall be embedded.
     * @return A call that can be sent to the server.
     */
    @Headers({ "Content-Type: application/json", "Accept: application/hal+json" })
    @GET(IToolPaths.TOOLS + "/{" + IRequestAndQueryParams.TOOL_ID + "}")
    Call<HALWSModel> getTool(
        @Path(IRequestAndQueryParams.TOOL_ID)
            String toolId,
        @Query(IRequestAndQueryParams.EMBED)
            String embed);

    /**
     * Creates a call that can be sent to the server.
     *
     * @param toolId The tool ID.
     * @return A call that can be sent to the server.
     */
    @Headers({ "Content-Type: application/json", "Accept: application/hal+json" })
    @DELETE(IToolPaths.TOOLS + "/{" + IRequestAndQueryParams.TOOL_ID + "}")
    Call<Void> deleteTool(
        @Path(IRequestAndQueryParams.TOOL_ID)
            String toolId);

    /**
     * Creates a call that can be sent to the server.
     *
     * @param toolId The tool ID.
     * @param limit  The limit.
     * @param offset The offset.
     * @return A call that can be sent to the server.
     */
    @Headers({ "Content-Type: application/json", "Accept: application/hal+json" })
    @GET(IToolPaths.TOOLS + "/{" + IRequestAndQueryParams.TOOL_ID + "}/" + IToolPaths.CHARACTERISTICS)
    Call<HALWSModel> getCharacteristics(
        @Path(IRequestAndQueryParams.TOOL_ID)
            String toolId,
        @Query(IRequestAndQueryParams.LIMIT)
            int limit,
        @Query(IRequestAndQueryParams.OFFSET)
            int offset);

    /**
     * Creates a call that can be sent to the server.
     *
     * @param toolId          The tool ID.
     * @param characteristics The characteristics.
     * @return A call that can be sent to the server.
     */
    @Headers({ "Content-Type: application/json", "Accept: application/hal+json" })
    @PUT(IToolPaths.TOOLS + "/{" + IRequestAndQueryParams.TOOL_ID + "}/" + IToolPaths.CHARACTERISTICS)
    Call<HALWSModel> putCharacteristics(
        @Path(IRequestAndQueryParams.TOOL_ID)
            String toolId,
        @Body
            List<CharacteristicGeneralDefinition> characteristics);

    /**
     * Creates a call that can be sent to the server.
     *
     * @param toolId     The tool ID.
     * @param identifier The tool cut edge identifier.
     * @return A call that can be sent to the server.
     */
    @Headers({ "Content-Type: application/json", "Accept: application/hal+json" })
    @GET(IToolPaths.TOOLS + "/{" + IRequestAndQueryParams.TOOL_ID + "}/" + IToolPaths.EDGES)
    Call<HALCollectionWSModel> getEdges(
        @Path(IRequestAndQueryParams.TOOL_ID)
            String toolId,
        @Query(IRequestAndQueryParams.IDENTIFIER)
            String identifier);

    /**
     * Creates a call that can be sent to the server.
     *
     * @param toolId   The tool ID.
     * @param toolEdge The tool cut edge data.
     * @return A call that can be sent to the server.
     */
    @Headers({ "Content-Type: application/json", "Accept: application/hal+json" })
    @POST(IToolPaths.TOOLS + "/{" + IRequestAndQueryParams.TOOL_ID + "}/" + IToolPaths.EDGES)
    Call<HALWSModel> createEdge(
        @Path(IRequestAndQueryParams.TOOL_ID)
            String toolId,
        @Body
            CreateToolEdgePropertiesWSModel toolEdge);

    /**
     * Creates a call that can be sent to the server.
     *
     * @param toolId The tool ID.
     * @param edgeId The tool cut edge ID.
     * @return A call that can be sent to the server.
     */
    @Headers({ "Content-Type: application/json", "Accept: application/hal+json" })
    @GET(IToolPaths.TOOLS + "/{" + IRequestAndQueryParams.TOOL_ID + "}/" + IToolPaths.EDGES + "/{" + IRequestAndQueryParams.EDGE_ID + "}")
    Call<HALWSModel> getEdge(
        @Path(IRequestAndQueryParams.TOOL_ID)
            String toolId,
        @Path(IRequestAndQueryParams.EDGE_ID)
            String edgeId);

    /**
     * Creates a call that can be sent to the server.
     *
     * @param toolId   The tool ID.
     * @param edgeId   The tool cut edge ID.
     * @param toolEdge The tool cut edge data.
     * @return A call that can be sent to the server.
     */
    @Headers({ "Content-Type: application/json", "Accept: application/hal+json" })
    @PUT(IToolPaths.TOOLS + "/{" + IRequestAndQueryParams.TOOL_ID + "}/" + IToolPaths.EDGES + "/{" + IRequestAndQueryParams.EDGE_ID + "}")
    Call<HALWSModel> updateEdge(
        @Path(IRequestAndQueryParams.TOOL_ID)
            String toolId,
        @Path(IRequestAndQueryParams.EDGE_ID)
            String edgeId,
        @Body
            ToolEdgePropertiesWSModel toolEdge);

    /**
     * Creates a call that can be sent to the server.
     *
     * @param toolId The tool ID.
     * @param edgeId The tool cut edge ID.
     * @param limit  The limit.
     * @param offset The offset.
     * @return A call that can be sent to the server.
     */
    @Headers({ "Content-Type: application/json", "Accept: application/hal+json" })
    @GET(IToolPaths.TOOLS + "/{" + IRequestAndQueryParams.TOOL_ID + "}/" + IToolPaths.EDGES + "/{" + IRequestAndQueryParams.EDGE_ID + "}/" +
         IToolPaths.CHARACTERISTICS)
    Call<HALWSModel> getEdgeCharacteristics(
        @Path(IRequestAndQueryParams.TOOL_ID)
            String toolId,
        @Path(IRequestAndQueryParams.EDGE_ID)
            String edgeId,
        @Query(IRequestAndQueryParams.LIMIT)
            int limit,
        @Query(IRequestAndQueryParams.OFFSET)
            int offset);

    /**
     * Creates a call that can be sent to the server.
     *
     * @param toolId          The tool ID.
     * @param edgeId          The tool cut edge ID.
     * @param characteristics The characteristics.
     * @return A call that can be sent to the server.
     */
    @Headers({ "Content-Type: application/json", "Accept: application/hal+json" })
    @PUT(IToolPaths.TOOLS + "/{" + IRequestAndQueryParams.TOOL_ID + "}/" + IToolPaths.EDGES + "/{" + IRequestAndQueryParams.EDGE_ID + "}/" +
         IToolPaths.CHARACTERISTICS)
    Call<HALWSModel> putEdgeCharacteristics(
        @Path(IRequestAndQueryParams.TOOL_ID)
            String toolId,
        @Path(IRequestAndQueryParams.EDGE_ID)
            String edgeId,
        @Body
            List<CharacteristicGeneralDefinition> characteristics);

    /**
     * Creates a call that can be sent to the server.
     *
     * @param toolId The tool ID.
     * @return A call that can be sent to the server.
     */
    @Headers({ "Content-Type: application/json", "Accept: application/hal+json" })
    @GET(IToolPaths.TOOLS + "/{" + IRequestAndQueryParams.TOOL_ID + "}/" + IPathParts.LOCATION)
    Call<HALWSModel> getLocation(
        @Path(IRequestAndQueryParams.TOOL_ID)
            String toolId);

    /**
     * Creates a call that can be sent to the server.
     *
     * @param toolId   The tool ID.
     * @param location The location.
     * @return A call that can be sent to the server.
     */
    @Headers({ "Content-Type: application/json", "Accept: application/hal+json" })
    @PUT(IToolPaths.TOOLS + "/{" + IRequestAndQueryParams.TOOL_ID + "}/" + IPathParts.LOCATION)
    Call<HALWSModel> putLocation(
        @Path(IRequestAndQueryParams.TOOL_ID)
            String toolId,
        @Body
            CreateToolLocationPropertiesWSModel location);

    /**
     * Creates a call that can be sent to the server.
     *
     * @param toolId The tool ID.
     * @return A call that can be sent to the server.
     */
    @Headers({ "Content-Type: application/json", "Accept: application/hal+json" })
    @DELETE(IToolPaths.TOOLS + "/{" + IRequestAndQueryParams.TOOL_ID + "}/" + IPathParts.LOCATION)
    Call<Void> deleteLocation(
        @Path(IRequestAndQueryParams.TOOL_ID)
            String toolId);

    /**
     * Creates a call that can be sent to the server.
     *
     * @param toolId      The tool ID.
     * @param toolStateId The tool state ID.
     * @return A call that can be sent to the server.
     */
    @Headers({ "Content-Type: application/json", "Accept: application/hal+json" })
    @POST(IToolPaths.TOOLS + "/{" + IRequestAndQueryParams.TOOL_ID + "}/{" + IRequestAndQueryParams.TOOL_STATE_ID + "}")
    Call<HALWSModel> setToolState(
        @Path(IRequestAndQueryParams.TOOL_ID)
            String toolId,
        @Path(IRequestAndQueryParams.TOOL_STATE_ID)
            String toolStateId);
}