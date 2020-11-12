////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 09.01.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.statusdefinition.request;

import com.forcam.na.ffwebservices.model.definition.OperationPhase;
import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Contains an ID and values that determine what shall be embedded.
 */
public class GetOperationPhaseRequest extends GetStatusDefinitionRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** An operation phase ID. */
    private OperationPhase mId;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new {@link GetOperationPhaseRequest} object with an operation phase ID.
     *
     * @param operationPhaseId The operation phase ID.
     */
    public GetOperationPhaseRequest(OperationPhase operationPhaseId) {
        mId = operationPhaseId;
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

    public OperationPhase getId() {
        return mId;
    }

    public void setId(OperationPhase id) {
        mId = id;
    }
}