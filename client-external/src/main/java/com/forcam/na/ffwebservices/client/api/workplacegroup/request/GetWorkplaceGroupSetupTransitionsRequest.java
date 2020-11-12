////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 28.11.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.workplacegroup.request;

import com.forcam.na.ffwebservices.client.api.pagination.request.CollectionRequest;
import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Request for getting all setup transitions of a workplace group.
 */
public class GetWorkplaceGroupSetupTransitionsRequest extends CollectionRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The workplace group ID. */
    private String mWorkplaceGroupId;

    /** The number of the material that is produced at the workplace before the setup transition. */
    private String mPredecessorMaterial;

    /** The number of the material that is produced at the workplace after the setup transition. */
    private String mSuccessorMaterial;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates new instance.
     *
     * @param workplaceGroupId The workplace group ID.
     */
    public GetWorkplaceGroupSetupTransitionsRequest(String workplaceGroupId) {
        mWorkplaceGroupId = workplaceGroupId;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return ToStringUtility.newToStringBuilder(this)
            .appendSuper(super.toString())
            .append("workplaceGroupId", mWorkplaceGroupId)
            .append("successorMaterial", mSuccessorMaterial)
            .append("predecessorMaterial", mPredecessorMaterial)
            .toString();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public String getWorkplaceGroupId() {
        return mWorkplaceGroupId;
    }

    public void setWorkplaceGroupId(String workplaceGroupId) {
        mWorkplaceGroupId = workplaceGroupId;
    }

    public String getPredecessorMaterial() {
        return mPredecessorMaterial;
    }

    public void setPredecessorMaterial(String predecessorMaterial) {
        mPredecessorMaterial = predecessorMaterial;
    }

    public String getSuccessorMaterial() {
        return mSuccessorMaterial;
    }

    public void setSuccessorMaterial(String successorMaterial) {
        mSuccessorMaterial = successorMaterial;
    }
}