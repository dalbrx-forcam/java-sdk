////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 14.12.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.operation.request;

import com.forcam.na.ffwebservices.model.command.operation.OperationPhaseRequestBody;
import com.forcam.na.ffwebservices.model.definition.OperationPhase;
import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Contains an operation id and an operation phase id.
 */
public class SetOperationPhaseRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Operation phase. */
    private OperationPhaseRequestBody mOperationPhase = new OperationPhaseRequestBody();

    /** An operation id. */
    private String mOperationId;

    /** An operation phase id. */
    private OperationPhase mOperationPhaseId;

    /** Should the request be sent asynchronously? */
    private boolean mAsync = false;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new {@link SetOperationPhaseRequest} with an operation ID and an operation phase ID.
     *
     * @param operationId      The operation ID.
     * @param operationPhaseId The operation phase ID.
     */
    public SetOperationPhaseRequest(String operationId, OperationPhase operationPhaseId) {
        mOperationId = operationId;
        mOperationPhaseId = operationPhaseId;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return ToStringUtility.newToStringBuilder(this)
            .append("operationId", mOperationId)
            .append("operationPhaseId", mOperationPhaseId)
            .append("async", mAsync)
            .append("operationPhase", mOperationPhase)
            .toString();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public OperationPhaseRequestBody getOperationPhase() {
        return mOperationPhase;
    }

    public void setOperationPhase(OperationPhaseRequestBody operationPhase) {
        mOperationPhase = operationPhase;
    }

    public String getOperationId() {
        return mOperationId;
    }

    public void setOperationId(String operationId) {
        mOperationId = operationId;
    }

    public OperationPhase getOperationPhaseId() {
        return mOperationPhaseId;
    }

    public void setOperationPhaseId(OperationPhase operationPhaseId) {
        mOperationPhaseId = operationPhaseId;
    }

    public boolean isAsync() {
        return mAsync;
    }

    public void setAsync(boolean async) {
        mAsync = async;
    }
}