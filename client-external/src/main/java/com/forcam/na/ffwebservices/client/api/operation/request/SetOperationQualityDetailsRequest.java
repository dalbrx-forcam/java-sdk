////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 14.12.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.operation.request;

import com.forcam.na.ffwebservices.model.command.operation.OperationQualityDetailRequestBody;
import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Contains an operation id.
 */
public class SetOperationQualityDetailsRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Operation quality detail. */
    private OperationQualityDetailRequestBody mOperationQualityDetail = new OperationQualityDetailRequestBody();

    /** An operation id. */
    private String mOperationId;

    /** Should the request be sent asynchronously? */
    private boolean mAsync = false;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new {@link SetOperationQualityDetailsRequest} object with an operation ID.
     *
     * @param operationId The operation ID.
     */
    public SetOperationQualityDetailsRequest(String operationId) {
        mOperationId = operationId;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return ToStringUtility.newToStringBuilder(this)
            .append("operationId", mOperationId)
            .append("async", mAsync)
            .append("operationQualityDetail", mOperationQualityDetail)
            .toString();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public OperationQualityDetailRequestBody getOperationQualityDetail() {
        return mOperationQualityDetail;
    }

    public void setOperationQualityDetail(OperationQualityDetailRequestBody operationQualityDetail) {
        mOperationQualityDetail = operationQualityDetail;
    }

    public String getOperationId() {
        return mOperationId;
    }

    public void setOperationId(String operationId) {
        mOperationId = operationId;
    }

    public boolean isAsync() {
        return mAsync;
    }

    public void setAsync(boolean async) {
        mAsync = async;
    }
}