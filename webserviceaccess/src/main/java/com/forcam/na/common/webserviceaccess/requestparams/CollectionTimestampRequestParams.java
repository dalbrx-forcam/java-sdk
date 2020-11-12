////////////////////////////////////////////////////////////////////////////////
//
// Created by Dimitri Schulz on 17.09.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.common.webserviceaccess.requestparams;

import com.forcam.na.common.webserviceaccess.util.ToStringUtility;

import java.util.Date;

/**
 * @author Dimitri Schulz <dimitri.schulz@forcam.com>
 */
public class CollectionTimestampRequestParams extends CollectionLimitRequestParams {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------

    /** String of pagination direction */
    public static final String PARAM_PAGINATION_DIRECTION = "paginationDirection";

    /** String of pagination timestamp. */
    public static final String PARAM_PAGINATION_DATE = "paginationTimestamp";

    /** String of pagination identifier. */
    public static final String PARAM_PAGINATION_IDENTIFIER = "paginationIdentifier";

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /**
     * Page direction.
     * IF page direction is NEXT than pagination timestamp is required. Otherwise is the result always the first page!
     * IF page direction is PREVIOUS than pagination timestamp is required. Otherwise is the result always the last page!
     */
    private PaginationDirection mPaginationDirection = PaginationDirection.NEXT;

    /**
     * Pagination timestamp.
     * Use in combination with pagination direction..
     */
    private Date mPaginationTimestamp;

    /**
     * Identifier of the last or first element.
     */
    private String mPaginationIdentifier;

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return ToStringUtility
            .newToStringBuilder(this)
            .append("mPaginationDirection", mPaginationDirection)
            .append("mPaginationTimestamp", mPaginationTimestamp)
            .append("mPaginationIdentifier", mPaginationIdentifier)
            .append(super.toString())
            .toString();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * @return {@link #mPaginationDirection}.
     */
    public PaginationDirection getPaginationDirection() {
        return mPaginationDirection;
    }

    /**
     * {@link #mPaginationDirection}
     *
     * @param paginationDirection {@link #mPaginationDirection}
     */
    public void setPaginationDirection(PaginationDirection paginationDirection) {
        if (paginationDirection == null) {
            paginationDirection = PaginationDirection.NEXT;
        }
        mPaginationDirection = paginationDirection;
    }

    /**
     * Getter for {@link #mPaginationTimestamp}.
     *
     * @return Paginatin timestamp.
     */
    public Date getPaginationTimestamp() {
        return mPaginationTimestamp;
    }

    /**
     * Setter for {@link #mPaginationTimestamp}.
     *
     * @param paginationTimestamp Pagination timestamp.
     */
    public void setPaginationTimestamp(Date paginationTimestamp) {
        mPaginationTimestamp = paginationTimestamp;
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
     */
    public void setPaginationIdentifier(String paginationIdentifier) {
        mPaginationIdentifier = paginationIdentifier;
    }
}
