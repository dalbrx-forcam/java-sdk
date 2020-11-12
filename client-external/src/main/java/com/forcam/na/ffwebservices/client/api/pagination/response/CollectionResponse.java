////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 12.09.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.pagination.response;

import com.forcam.na.ffwebservices.client.api.pagination.request.PaginationRequest;
import com.forcam.na.ffwebservices.model.AbstractResponse;

import java.util.List;

/**
 * A response containing a collection of elements.
 *
 * @param <T> The type of the elements.
 */
public class CollectionResponse<T extends AbstractResponse> extends AbstractCollectionResponse<T> {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private List<T> mEmbedded;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     *
     * @param request The request.
     */
    public CollectionResponse(PaginationRequest request) {
        super(request);
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public List<T> getEmbedded() {
        return mEmbedded;
    }

    public void setEmbedded(List<T> embedded) {
        mEmbedded = embedded;
    }

    @Override
    public List<T> getElements() {
        return mEmbedded;
    }
}
