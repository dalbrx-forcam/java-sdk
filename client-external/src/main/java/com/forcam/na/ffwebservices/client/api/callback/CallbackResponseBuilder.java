////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 31.08.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.callback;

import com.forcam.na.ffwebservices.client.api.AbstractResponseBuilder;
import com.forcam.na.ffwebservices.client.api.pagination.response.CollectionResponse;
import com.forcam.na.ffwebservices.client.api.pagination.request.PaginationRequest;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.model.LinkEmbeddedWSModel;
import com.forcam.na.ffwebservices.model.callback.CallbackPropertiesWSModel;
import com.forcam.na.ffwebservices.model.callback.CallbackResponse;
import com.forcam.na.ffwebservices.client.api.HALCollectionWSModel;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Builds responses for callbacks.
 */
public class CallbackResponseBuilder extends AbstractResponseBuilder implements ICallbackResponseBuilder {

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    @Inject
    public CallbackResponseBuilder() {
        //empty
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public CollectionResponse<CallbackResponse> getCallbackCollectionResponse(PaginationRequest request, HALCollectionWSModel collectionModel) {
        final CollectionResponse<CallbackResponse> collectionResponse = new CollectionResponse<>(request);
        this.initializeCollectionResponse(collectionModel, collectionResponse);

        final Map<String, List<HALWSModel>> embedded = collectionModel.getEmbedded();
        final List<HALWSModel> callbacks = embedded.get("callbacks");

        final List<CallbackResponse> callbackModels = callbacks
            .stream()
            .map(this::getCallbackResponse)
            .collect(Collectors.toList());

        collectionResponse.setEmbedded(callbackModels);
        return collectionResponse;
    }

    @Override
    public CallbackResponse getCallbackResponse(HALWSModel serverModel) {
        final CallbackResponse callbackModel = new CallbackResponse();
        final CallbackPropertiesWSModel properties = mMapper.convertValue(serverModel.getProperties(), CallbackPropertiesWSModel.class);
        callbackModel.setProperties(properties);

        final LinkEmbeddedWSModel<Object> selfLink = this.createSelfLinkModel(serverModel);
        callbackModel.setSelf(selfLink);

        return callbackModel;
    }
}