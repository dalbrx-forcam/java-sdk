////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 31.08.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.callback;

import com.forcam.na.ffwebservices.client.api.pagination.response.CollectionResponse;
import com.forcam.na.ffwebservices.client.api.pagination.request.PaginationRequest;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.model.callback.CallbackResponse;
import com.forcam.na.ffwebservices.client.api.HALCollectionWSModel;

/**
 * Contains methods for building responses for callbacks.
 */
public interface ICallbackResponseBuilder {

    /**
     * Transforms a collection model to a callback collection response.
     *
     * @param collectionModel A collection model.
     * @param request         The pagination request.
     * @return A callback collection response.
     */
    CollectionResponse<CallbackResponse> getCallbackCollectionResponse(PaginationRequest request, HALCollectionWSModel collectionModel);

    /**
     * Converts HAL model to a callback model.
     *
     * @param serverModel The server model.
     * @return A callback model.
     */
    CallbackResponse getCallbackResponse(HALWSModel serverModel);
}