////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 11.10.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.pagination.request;

import com.forcam.na.common.webserviceaccess.requestparams.PaginationDirection;
import org.apache.commons.lang3.NotImplementedException;
import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * Can contain values for limit and offset.
 */
public class CollectionRequest extends CollectionLimitRequest implements PaginationRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The offset. */
    private int mOffset;

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    /**
     * Sets a new offset and returns the object.
     *
     * @param offset The offset.
     * @return The CollectionRequest object with a new offset.
     */
    public CollectionRequest setOffset(int offset) {
        mOffset = offset;
        return this;
    }

    @Override
    public CollectionRequest setLimit(int limit) {
        super.setLimit(limit);
        return this;
    }

    /**
     * Get pagination timestamp is not supported for CollectionRequests. Its only used with CollectionTimestampRequest.
     *
     * @throws NotImplementedException Always!
     */
    @Override
    @Deprecated
    public Date getPaginationTimestamp() {
        throw new NotImplementedException("Get pagination timestamp is not supported for CollectionRequests. Its only used with CollectionTimestampRequest");
    }

    /**
     * Set pagination timestamp is not supported for CollectionRequests. Its only used with CollectionTimestampRequest.
     *
     * @throws NotImplementedException Always!
     */
    @Override
    @Deprecated
    public PaginationRequest setPaginationTimestamp(Date paginationTimestamp) {
        throw new NotImplementedException("Set pagination timestamp is not supported for CollectionRequests. Its only used with CollectionTimestampRequest");
    }

    /**
     * Get pagination direction is not supported for CollectionRequests. Its only used with CollectionTimestampRequest.
     *
     * @throws NotImplementedException Always!
     */
    @Override
    @Deprecated
    public PaginationDirection getPaginationDirection() {
        throw new NotImplementedException("Get pagination direction is not supported for CollectionRequests. Its only used with CollectionTimestampRequest");
    }

    /**
     * Set pagination direction is not supported for CollectionRequests. Its only used with CollectionTimestampRequest.
     *
     * @throws NotImplementedException Always!
     */
    @Override
    @Deprecated
    public PaginationRequest setPaginationDirection(PaginationDirection paginationDirection) {
        throw new NotImplementedException("Set pagination direction is not supported for CollectionRequests. Its only used with CollectionTimestampRequest");
    }

    @Override
    public String toString() {
        return ToStringUtility.newToStringBuilder(this)
            .append("mOffset", mOffset)
            .append(super.toString())
            .toString();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public int getOffset() {
        return mOffset;
    }
}