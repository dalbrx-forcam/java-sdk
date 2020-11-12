////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 25.09.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.statusdefinition;

import com.forcam.na.ffwebservices.client.api.AbstractClient;
import com.forcam.na.ffwebservices.client.api.HALCollectionWSModel;
import com.forcam.na.ffwebservices.client.api.exception.ForceAPIException;
import com.forcam.na.ffwebservices.client.api.pagination.request.CollectionRequest;
import com.forcam.na.ffwebservices.client.api.pagination.response.CollectionResponse;
import com.forcam.na.ffwebservices.client.api.pagination.response.Page;
import com.forcam.na.ffwebservices.model.statusdefinition.StatusDefinitionResponse;
import retrofit2.Call;

import javax.inject.Inject;
import java.lang.reflect.Method;

/**
 * Requests status definitions.
 */
public class StatusDefinitionClient extends AbstractClient implements IStatusDefinitionClient {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The status definition endpoint. */
    private final StatusDefinitionEndpoint mStatusDefinitionEndpoint;

    /** The status definition response builder. */
    private final IStatusDefinitionResponseBuilder mStatusDefinitionResponseBuilder;

    /**
     * Creates a new instance.
     *
     * @param statusDefinitionEndpoint        Status definition endpoint.
     * @param statusDefinitionResponseBuilder Status definition response builder.
     */
    @Inject
    public StatusDefinitionClient(StatusDefinitionEndpoint statusDefinitionEndpoint, IStatusDefinitionResponseBuilder statusDefinitionResponseBuilder) {
        mStatusDefinitionEndpoint = statusDefinitionEndpoint;
        mStatusDefinitionResponseBuilder = statusDefinitionResponseBuilder;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public Page<StatusDefinitionResponse> getMachineStates(CollectionRequest params) throws ForceAPIException {
        final Call<HALCollectionWSModel> call = mStatusDefinitionEndpoint.getMachineStates(params.getLimit(), params.getOffset());
        final HALCollectionWSModel collectionModel = super.getResponseModel(params, call);
        final CollectionResponse<StatusDefinitionResponse> response = mStatusDefinitionResponseBuilder.getStatusDefinitionCollectionResponse(params,
                                                                                                                                             collectionModel,
                                                                                                                                             mStatusDefinitionResponseBuilder.MACHINE_STATES_KEY);

        final Method m = new Object() {}
            .getClass()
            .getEnclosingMethod();
        return new Page<>(this, m, response);
    }

    @Override
    public Page<StatusDefinitionResponse> getOperationProductionStates(CollectionRequest params) throws ForceAPIException {
        final Call<HALCollectionWSModel> call = mStatusDefinitionEndpoint.getOperationProductionStates(params.getLimit(), params.getOffset());
        final HALCollectionWSModel collectionModel = super.getResponseModel(params, call);
        final CollectionResponse<StatusDefinitionResponse> response = mStatusDefinitionResponseBuilder.getStatusDefinitionCollectionResponse(params,
                                                                                                                                             collectionModel,
                                                                                                                                             mStatusDefinitionResponseBuilder.OPERATION_PRODUCTION_STATES_KEY);

        final Method m = new Object() {}
            .getClass()
            .getEnclosingMethod();
        return new Page<>(this, m, response);
    }

    @Override
    public Page<StatusDefinitionResponse> getPersonnelStates(CollectionRequest params) throws ForceAPIException {
        final Call<HALCollectionWSModel> call = mStatusDefinitionEndpoint.getPersonnelStates(params.getLimit(), params.getOffset());
        final HALCollectionWSModel collectionModel = super.getResponseModel(params, call);
        final CollectionResponse<StatusDefinitionResponse> response = mStatusDefinitionResponseBuilder.getStatusDefinitionCollectionResponse(params,
                                                                                                                                             collectionModel,
                                                                                                                                             mStatusDefinitionResponseBuilder.PERSONNEL_STATES_KEY);

        final Method m = new Object() {}
            .getClass()
            .getEnclosingMethod();
        return new Page<>(this, m, response);
    }
}