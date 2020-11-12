////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 20.12.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.tool;

import com.forcam.na.ffwebservices.client.api.AbstractClient;
import com.forcam.na.ffwebservices.client.api.HALCollectionWSModel;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.client.api.exception.ForceAPIException;
import com.forcam.na.ffwebservices.client.api.pagination.response.CollectionResponse;
import com.forcam.na.ffwebservices.client.api.pagination.response.Page;
import com.forcam.na.ffwebservices.client.api.tool.request.*;
import com.forcam.na.ffwebservices.client.api.tool.response.CharacteristicCollectionPage;
import com.forcam.na.ffwebservices.client.api.tool.response.CharacteristicCollectionResponse;
import com.forcam.na.ffwebservices.model.tool.ToolEdgeResponse;
import com.forcam.na.ffwebservices.model.tool.ToolLocationResponse;
import com.forcam.na.ffwebservices.model.tool.ToolResponse;
import retrofit2.Call;

import javax.inject.Inject;
import java.lang.reflect.Method;

/**
 * Requests tools.
 */
public class ToolClient extends AbstractClient implements IToolClient {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The tool endpoint. */
    private final ToolEndpoint mToolEndpoint;

    /** The tool response builder. */
    private final IToolResponseBuilder mToolResponseBuilder;

    /** The characteristic response builder. */
    private final ICharacteristicResponseBuilder mCharacteristicResponseBuilder;

    /** The tool cut edge response builder. */
    private final IToolEdgeResponseBuilder mToolEdgeResponseBuilder;

    /** The tool location response builder. */
    private final IToolLocationResponseBuilder mToolLocationResponseBuilder;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     *
     * @param characteristicResponseBuilder Characteristic response builder.
     * @param toolEdgeResponseBuilder       Tool edge response builder.
     * @param toolEndpoint                  Tool endpoint.
     * @param toolLocationResponseBuilder   Tool location response builder.
     * @param toolResponseBuilder           Tool response builder.
     */
    @Inject
    public ToolClient(ToolEndpoint toolEndpoint, IToolResponseBuilder toolResponseBuilder, ICharacteristicResponseBuilder characteristicResponseBuilder,
                      IToolEdgeResponseBuilder toolEdgeResponseBuilder, IToolLocationResponseBuilder toolLocationResponseBuilder) {
        mToolEndpoint = toolEndpoint;
        mToolResponseBuilder = toolResponseBuilder;
        mCharacteristicResponseBuilder = characteristicResponseBuilder;
        mToolEdgeResponseBuilder = toolEdgeResponseBuilder;
        mToolLocationResponseBuilder = toolLocationResponseBuilder;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public Page<ToolResponse> getTools(GetToolsRequest request) throws ForceAPIException {
        final Call<HALCollectionWSModel> call = mToolEndpoint.getTools(request.getIdentifier(),
                                                                       request.getIdentifier2(),
                                                                       request.getIdentifier3(),
                                                                       request.getLimit(),
                                                                       request.getOffset(),
                                                                       request
                                                                           .embed()
                                                                           .toString());
        final HALCollectionWSModel responseModel = this.getResponseModel(request, call);
        final CollectionResponse<ToolResponse> response = mToolResponseBuilder.getToolCollectionResponse(request, responseModel);

        final Method m = new Object() {}
            .getClass()
            .getEnclosingMethod();
        return new Page<>(this, m, response);
    }

    @Override
    public ToolResponse createTool(CreateToolRequest request) throws ForceAPIException {
        final Call<HALWSModel> call = mToolEndpoint.createTool(request.getToolData());
        final HALWSModel responseModel = this.getResponseModel(request, call);
        return mToolResponseBuilder.getToolResponse(responseModel);
    }

    @Override
    public ToolResponse getTool(GetToolRequest request) throws ForceAPIException {
        final Call<HALWSModel> call = mToolEndpoint.getTool(request.getId(),
                                                            request
                                                                .embed()
                                                                .toString());
        final HALWSModel responseModel = this.getResponseModel(request, call);
        return mToolResponseBuilder.getToolResponse(responseModel);
    }

    @Override
    public void deleteTool(DeleteToolRequest request) throws ForceAPIException {
        final Call<Void> call = mToolEndpoint.deleteTool(request.getId());
        this.executeCall(request, call);
    }

    @Override
    public CharacteristicCollectionPage getCharacteristics(GetToolCharacteristicsRequest request) throws ForceAPIException {
        final Call<HALWSModel> call = mToolEndpoint.getCharacteristics(request.getToolId(), request.getLimit(), request.getOffset());
        final HALWSModel responseModel = this.getResponseModel(request, call);
        final CharacteristicCollectionResponse response = mCharacteristicResponseBuilder.getCharacteristicCollectionResponse(request, responseModel);

        final Method m = new Object() {}
            .getClass()
            .getEnclosingMethod();
        return new CharacteristicCollectionPage(this, m, response);
    }

    @Override
    public CharacteristicCollectionPage putCharacteristics(PutToolCharacteristicsRequest request) throws ForceAPIException {
        final Call<HALWSModel> call = mToolEndpoint.putCharacteristics(request.getToolId(), request.getCharacteristics());
        final HALWSModel responseModel = this.getResponseModel(request, call);
        final GetToolCharacteristicsRequest getRequest = new GetToolCharacteristicsRequest(request.getToolId());
        final CharacteristicCollectionResponse response = mCharacteristicResponseBuilder.getCharacteristicCollectionResponse(getRequest, responseModel);

        final Method m = new Object() {}
            .getClass()
            .getEnclosingMethod();
        return new CharacteristicCollectionPage(this, m, response);
    }

    @Override
    public Page<ToolEdgeResponse> getEdges(GetToolEdgesRequest request) throws ForceAPIException {
        final Call<HALCollectionWSModel> call = mToolEndpoint.getEdges(request.getToolId(), request.getIdentifier());
        final HALCollectionWSModel responseModel = this.getResponseModel(request, call);
        final CollectionResponse<ToolEdgeResponse> response = mToolEdgeResponseBuilder.getToolEdgeCollectionResponse(request, responseModel);

        final Method m = new Object() {}
            .getClass()
            .getEnclosingMethod();
        return new Page<>(this, m, response);
    }

    @Override
    public ToolEdgeResponse createEdge(CreateToolEdgeRequest request) throws ForceAPIException {
        final Call<HALWSModel> call = mToolEndpoint.createEdge(request.getToolId(), request.getToolEdge());
        final HALWSModel responseModel = this.getResponseModel(request, call);
        return mToolEdgeResponseBuilder.getToolEdgeResponse(responseModel);
    }

    @Override
    public ToolEdgeResponse getEdge(GetToolEdgeRequest request) throws ForceAPIException {
        final Call<HALWSModel> call = mToolEndpoint.getEdge(request.getToolId(), request.getId());
        final HALWSModel responseModel = this.getResponseModel(request, call);
        return mToolEdgeResponseBuilder.getToolEdgeResponse(responseModel);
    }

    @Override
    public ToolEdgeResponse updateEdge(UpdateToolEdgeRequest request) throws ForceAPIException {
        final Call<HALWSModel> call = mToolEndpoint.updateEdge(request.getToolId(), request.getId(), request.getToolEdge());
        final HALWSModel responseModel = this.getResponseModel(request, call);
        return mToolEdgeResponseBuilder.getToolEdgeResponse(responseModel);
    }

    @Override
    public CharacteristicCollectionPage getEdgeCharacteristics(GetToolEdgeCharacteristicsRequest request) throws ForceAPIException {
        final Call<HALWSModel> call = mToolEndpoint.getEdgeCharacteristics(request.getToolId(), request.getEdgeId(), request.getLimit(), request.getOffset());
        final HALWSModel responseModel = this.getResponseModel(request, call);
        final CharacteristicCollectionResponse response = mCharacteristicResponseBuilder.getCharacteristicCollectionResponse(request, responseModel);

        final Method m = new Object() {}
            .getClass()
            .getEnclosingMethod();
        return new CharacteristicCollectionPage(this, m, response);
    }

    @Override
    public CharacteristicCollectionPage putEdgeCharacteristics(PutToolEdgeCharacteristicsRequest request) throws ForceAPIException {
        final Call<HALWSModel> call = mToolEndpoint.putEdgeCharacteristics(request.getToolId(), request.getEdgeId(), request.getCharacteristics());
        final HALWSModel responseModel = this.getResponseModel(request, call);
        final GetToolEdgeCharacteristicsRequest getRequest = new GetToolEdgeCharacteristicsRequest(request.getToolId(), request.getEdgeId());
        final CharacteristicCollectionResponse response = mCharacteristicResponseBuilder.getCharacteristicCollectionResponse(getRequest, responseModel);

        final Method m = new Object() {}
            .getClass()
            .getEnclosingMethod();
        return new CharacteristicCollectionPage(this, m, response);
    }

    @Override
    public ToolLocationResponse getLocation(GetToolLocationRequest request) throws ForceAPIException {
        final Call<HALWSModel> call = mToolEndpoint.getLocation(request.getToolId());
        final HALWSModel responseModel = this.getResponseModel(request, call);
        return mToolLocationResponseBuilder.getToolLocationResponse(responseModel);
    }

    @Override
    public ToolLocationResponse putLocation(PutToolLocationRequest request) throws ForceAPIException {
        final Call<HALWSModel> call = mToolEndpoint.putLocation(request.getToolId(), request.getLocation());
        final HALWSModel responseModel = this.getResponseModel(request, call);
        return mToolLocationResponseBuilder.getToolLocationResponse(responseModel);
    }

    @Override
    public void deleteLocation(DeleteToolLocationRequest request) throws ForceAPIException {
        final Call<Void> call = mToolEndpoint.deleteLocation(request.getToolId());
        this.executeCall(request, call);
    }

    @Override
    public ToolResponse setToolState(SetToolStateRequest request) throws ForceAPIException {
        final Call<HALWSModel> call = mToolEndpoint.setToolState(request.getToolId(), request.getToolStateId());
        final HALWSModel responseModel = this.getResponseModel(request, call);
        return mToolResponseBuilder.getToolResponse(responseModel);
    }
}