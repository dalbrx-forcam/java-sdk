////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 31.08.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.callback.response;

import com.forcam.na.ffwebservices.client.api.pagination.response.AbstractCollectionResponse;
import com.forcam.na.ffwebservices.client.api.pagination.request.PaginationRequest;
import com.forcam.na.ffwebservices.model.callback.CallbackResponse;

import java.util.List;

/**
 * Can contain a collection of callbacks.
 */
public class CallbackCollectionResponse extends AbstractCollectionResponse<CallbackResponse> {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** A list of callback models. */
    private List<CallbackResponse> mCallbacks;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     *
     * @param request The request.
     */
    CallbackCollectionResponse(PaginationRequest request) {
        super(request);
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public void setCallbacks(List<CallbackResponse> callbacks) {
        mCallbacks = callbacks;
    }

    public List<CallbackResponse> getCallbacks() {
        return mCallbacks;
    }

    @Override
    public List<CallbackResponse> getElements() {
        return mCallbacks;
    }
}