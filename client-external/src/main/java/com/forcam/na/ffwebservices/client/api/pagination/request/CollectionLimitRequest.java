////////////////////////////////////////////////////////////////////////////////
//
// Created by Dimitri Schulz on 17.09.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.pagination.request;

/**
 * Collection limit request.
 */
public class CollectionLimitRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The limit. */
    private int mLimit = 100;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Sets a new limit and returns the object.
     *
     * @param limit The limit.
     * @return The CollectionRequest object with a new limit.
     */
    public CollectionLimitRequest setLimit(int limit) {
        mLimit = limit;
        return this;
    }

    /**
     * Getter for {@link #mLimit}.
     *
     * @return Limit.
     */
    public int getLimit() {
        return mLimit;
    }

}
