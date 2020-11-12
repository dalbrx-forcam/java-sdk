////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 13.09.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.pagination.response;

import com.forcam.na.ffwebservices.client.api.pagination.PaginationController;
import com.forcam.na.ffwebservices.client.api.pagination.request.PaginationRequest;
import com.forcam.na.ffwebservices.model.collection.Pagination;
import com.forcam.na.ffwebservices.model.collection.PaginationPropertiesWSModel;

import java.util.List;

/**
 * Can contain a collection of properties.
 */
public abstract class AbstractCollectionResponse<R> extends AbstractPaginationResponse {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** A collection model of properties. */
    private Pagination mPagination;

    private PaginationRequest mRequest;

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     *
     * @param request The request.
     */
    public AbstractCollectionResponse(PaginationRequest request) {
        mRequest = request;
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public Pagination getPagination() {
        return mPagination;
    }

    public void setPagination(PaginationPropertiesWSModel pagination) {
        mPagination = new Pagination(pagination);
    }

    public PaginationRequest getRequest() {
        return mRequest;
    }

    /**
     * Returns a pagination controller which can be used to request the next page of the response.
     *
     * @return The {@link PaginationController}.
     */
    public PaginationController getPaginationController() {
        return new PaginationController(this);
    }

    /**
     * Returns the elements of the response.
     *
     * @return List of elements.
     */
    public abstract List<R> getElements();
}