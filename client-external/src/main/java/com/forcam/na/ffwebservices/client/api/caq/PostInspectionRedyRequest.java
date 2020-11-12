////////////////////////////////////////////////////////////////////////////////
//
// Created by DSchulz on 25.02.2020.
//
// Copyright (c) 2006 - 2020 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.caq;

import com.forcam.na.common.webserviceaccess.util.ToStringUtility;

/**
 * POST request for inspection ready.
 */
public class PostInspectionRedyRequest {


    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The inspection id. */
    private String mInspectionId;
    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Instantiates a new Post inspection redy request.
     *
     * @param inspectionId The inspection id.
     */
    public PostInspectionRedyRequest(String inspectionId) {
        mInspectionId = inspectionId;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return ToStringUtility
            .newToStringBuilder(this)
            .append("inspectionId", mInspectionId)
            .toString();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Getter for {@link #mInspectionId}
     *
     * @return Inspection id.
     */
    public String getInspectionId() {
        return mInspectionId;
    }

    /**
     * Setter for {@link #mInspectionId}
     *
     * @param inspectionId Value for the {@link #mInspectionId}
     */
    public void setInspectionId(String inspectionId) {
        mInspectionId = inspectionId;
    }
}
