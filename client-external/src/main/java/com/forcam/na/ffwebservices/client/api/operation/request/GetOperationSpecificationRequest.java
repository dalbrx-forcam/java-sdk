////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 12.12.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.operation.request;

import com.forcam.na.ffwebservices.model.operation.OperationSpecificationEmbed;
import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Contains an operation id and values that determine what shall be embedded.
 */
public class GetOperationSpecificationRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** An operation id. */
    private String mOperationId;

    /** Determines what shall be embedded. */
    private OperationSpecificationEmbed mEmbed = new OperationSpecificationEmbed();

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new {@link GetOperationSpecificationRequest} object with an operation ID.
     *
     * @param operationId The operation ID.
     */
    public GetOperationSpecificationRequest(String operationId) {
        mOperationId = operationId;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    public OperationSpecificationEmbed embed() {
        return mEmbed;
    }

    public void embed(OperationSpecificationEmbed embed) {
        mEmbed = embed;
    }

    @Override
    public String toString() {
        return ToStringUtility.newToStringBuilder(this)
            .append("operationId", mOperationId)
            .append("embed", mEmbed)
            .toString();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public String getOperationId() {
        return mOperationId;
    }

    public void setOperationId(String operationId) {
        mOperationId = operationId;
    }
}