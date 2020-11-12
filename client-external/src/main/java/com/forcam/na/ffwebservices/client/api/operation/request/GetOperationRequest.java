////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 13.10.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.operation.request;

import com.forcam.na.ffwebservices.model.operation.OperationEmbed;
import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Contains an id and values that determine what shall be embedded.
 */
public class GetOperationRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** An operation id. */
    private String mId;

    /** Determines what shall be embedded. */
    private OperationEmbed mEmbed = new OperationEmbed();

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new {@link GetOperationRequest} object with an operation ID.
     *
     * @param operationId The operation ID.
     */
    public GetOperationRequest(String operationId) {
        mId = operationId;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    public OperationEmbed embed() {
        return mEmbed;
    }

    public void embed(OperationEmbed embed) {
        mEmbed = embed;
    }

    @Override
    public String toString() {
        return ToStringUtility.newToStringBuilder(this)
            .append("id", mId)
            .append("embed", mEmbed)
            .toString();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }
}