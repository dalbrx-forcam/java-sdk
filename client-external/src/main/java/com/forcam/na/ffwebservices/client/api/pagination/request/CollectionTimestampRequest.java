////////////////////////////////////////////////////////////////////////////////
//
// Created by Dimitri Schulz on 17.09.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.pagination.request;

import com.forcam.na.common.webserviceaccess.requestparams.PaginationDirection;
import org.apache.commons.lang3.NotImplementedException;

import java.util.Date;

/**
 * Collection timestamp request.
 */
public class CollectionTimestampRequest extends CollectionLimitRequest implements PaginationRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /**
     * Pagination direction.
     */
    private PaginationDirection mPaginationDirection = PaginationDirection.NEXT;

    /**
     * Pagination timestamp.
     */
    private Date mPaginationTimestamp;

    /** Pagination identifier. */
    private String mPaginationIdentifier;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Getter for {@link #mPaginationDirection}.
     *
     * @return Pagination direction.
     */
    public PaginationDirection getPaginationDirection() {
        return mPaginationDirection;
    }

    /**
     * Setter for {@link #mPaginationDirection}.
     *
     * @param paginationDirection The pagination direction.
     * @return Self with the new pagination direction.
     */
    public CollectionTimestampRequest setPaginationDirection(PaginationDirection paginationDirection) {
        mPaginationDirection = paginationDirection;
        return this;
    }

    /**
     * Get offset is not supported for CollectionTimestampRequests. It can only be used with CollectionRequest.
     *
     * @throws NotImplementedException Always!
     */
    @Deprecated
    @Override
    public int getOffset() {
        throw new NotImplementedException("Get offset is not supported for CollectionTimestampRequests. It can only be used with CollectionRequest");
    }

    /**
     * Set offset is not supported for CollectionTimestampRequests. It can only be used with CollectionRequest.
     *
     * @throws NotImplementedException Always!
     */
    @Deprecated
    @Override
    public PaginationRequest setOffset(int offset) {
        throw new NotImplementedException("Set offset is not supported for CollectionTimestampRequests. It can only be used with CollectionRequest");
    }

    /**
     * Getter for {@link #mPaginationTimestamp}.
     *
     * @return Pagination timestamp.
     */
    public Date getPaginationTimestamp() {
        return mPaginationTimestamp;
    }

    /**
     * Setter for {@link #mPaginationTimestamp}.
     *
     * @param paginationTimestamp The pagination timestamp.
     * @return Self with the new pagination timestamp.
     */
    public CollectionTimestampRequest setPaginationTimestamp(Date paginationTimestamp) {
        mPaginationTimestamp = paginationTimestamp;
        return this;
    }

    /**
     * Getter for {@link #mPaginationIdentifier}.
     *
     * @return The pagination identifier.
     */
    public String getPaginationIdentifier() {
        return mPaginationIdentifier;
    }

    /**
     * Setter for {@link #mPaginationIdentifier}.
     *
     * @param paginationIdentifier The pagination identifier.
     * @return Self with the new pagination identifier.
     */
    public CollectionTimestampRequest setPaginationIdentifier(String paginationIdentifier) {
        mPaginationIdentifier = paginationIdentifier;
        return this;
    }
}
