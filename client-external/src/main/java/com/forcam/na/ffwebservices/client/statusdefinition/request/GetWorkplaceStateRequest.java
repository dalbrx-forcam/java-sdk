////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 09.01.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.statusdefinition.request;

import com.forcam.na.ffwebservices.model.definition.WorkplaceState;
import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Contains an ID and values that determine what shall be embedded.
 */
public class GetWorkplaceStateRequest extends GetStatusDefinitionRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** A workplace state ID. */
    private WorkplaceState mId;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new {@link GetWorkplaceStateRequest} object with a workplace state ID.
     *
     * @param workplaceStateId The workplace state ID.
     */
    public GetWorkplaceStateRequest(WorkplaceState workplaceStateId) {
        mId = workplaceStateId;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return ToStringUtility.newToStringBuilder(this)
            .append("id", mId)
            .appendSuper(super.toString())
            .toString();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public WorkplaceState getId() {
        return mId;
    }

    public void setId(WorkplaceState id) {
        mId = id;
    }
}