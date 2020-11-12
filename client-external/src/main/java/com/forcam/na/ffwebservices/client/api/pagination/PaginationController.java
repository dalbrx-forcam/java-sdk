////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 12.09.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.pagination;

import com.forcam.na.ffwebservices.client.api.pagination.request.PaginationRequest;
import com.forcam.na.ffwebservices.client.api.pagination.response.AbstractCollectionResponse;

/**
 * Wraps the pagination methods of a response.
 */
public class PaginationController {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The collection response. */
    private AbstractCollectionResponse mCollectionResponse;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     *
     * @param response The response which determines the current page.
     */
    public PaginationController(AbstractCollectionResponse response) {
        mCollectionResponse = response;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    /**
     * Creates a request for the next page.
     *
     * @return The request for the previous page.
     * @throws PageNotAvailableException If no previous page is available.
     */
    public PaginationRequest nextPageRequest() throws PageNotAvailableException {
        return PaginationUtil.nextPageRequest(mCollectionResponse);
    }

    /**
     * Creates a request for the previous page.
     *
     * @return The request for the previous page.
     * @throws PageNotAvailableException If no previous page is available.
     */
    public PaginationRequest previousPageRequest() throws PageNotAvailableException {
        return PaginationUtil.previousPageRequest(mCollectionResponse);
    }

    /**
     * Creates a request for the first page.
     *
     * @return The request for the first page.
     * @throws PageNotAvailableException If no first page is available.
     */
    public PaginationRequest firstPageRequest() throws PageNotAvailableException {
        return PaginationUtil.firstPageRequest(mCollectionResponse);
    }

    /**
     * Creates a request for the last page.
     *
     * @return The request for the last page.
     * @throws PageNotAvailableException If no last page is available.
     */
    public PaginationRequest lastPageRequest() throws PageNotAvailableException {
        return PaginationUtil.lastPageRequest(mCollectionResponse);
    }
}
