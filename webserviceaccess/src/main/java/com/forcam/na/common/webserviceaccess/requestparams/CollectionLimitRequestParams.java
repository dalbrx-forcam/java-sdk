////////////////////////////////////////////////////////////////////////////////
//
// Created by Dimitri Schulz on 17.09.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.common.webserviceaccess.requestparams;

import com.forcam.na.common.webserviceaccess.util.ToStringUtility;

/**
 * @author Dimitri Schulz <dimitri.schulz@forcam.com>
 */
public class CollectionLimitRequestParams extends RequestParams {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------

    /** The maximum limit for collections */
    public static final int MAX_LIMIT = 100;

    public static final int MIN_LIMIT = 1;

    /** Name of the limit query parameter */
    public static final String PARAM_LIMIT = "limit";

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The limit. */
    private int mLimit = 100;

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return ToStringUtility
            .newToStringBuilder(this)
            .append("mLimit", mLimit)
            .append(super.toString())
            .toString();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public int getLimit() {
        return mLimit;
    }

    /**
     * Sets the limit if not above the max limit.
     *
     * @param limit The limit.
     */
    public void setLimit(int limit) {
        if (limit < MIN_LIMIT || limit > MAX_LIMIT) {
            throw new LimitExceededException(limit, MAX_LIMIT);
        }
        mLimit = Math.max(limit, MIN_LIMIT);
    }

}
