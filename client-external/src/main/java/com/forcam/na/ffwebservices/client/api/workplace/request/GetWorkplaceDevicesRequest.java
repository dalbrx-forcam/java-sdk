////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 13.08.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.workplace.request;

import com.forcam.na.ffwebservices.client.api.pagination.request.CollectionRequest;

/**
 * Request for getting all devices which are assigned to a workplace.
 */
public class GetWorkplaceDevicesRequest extends CollectionRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The workplace ID. */
    private String mWorkplaceId;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates new instance with workplace ID.
     *
     * @param workplaceId The workplace ID.
     */
    public GetWorkplaceDevicesRequest(String workplaceId) {
        mWorkplaceId = workplaceId;
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Provides the workplace ID.
     *
     * @return The workplace ID.
     */
    public String getWorkplaceId() {
        return mWorkplaceId;
    }

    /**
     * Sets workplace ID.
     *
     * @param workplaceId The workplace ID.
     */
    public void setWorkplaceId(String workplaceId) {
        mWorkplaceId = workplaceId;
    }
}