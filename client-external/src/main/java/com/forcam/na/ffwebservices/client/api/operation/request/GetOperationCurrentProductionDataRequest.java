////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 11.02.2020.
//
// Copyright (c) 2006 - 2020 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.operation.request;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * Request parameter for current production data of an operation.
 */
public class GetOperationCurrentProductionDataRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private String mOperationId;

    private List<String> mAdditionalOperationTime = new ArrayList<>();

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    public GetOperationCurrentProductionDataRequest(String operationId) {
        mOperationId = operationId;
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public List<String> getAdditionalOperationTime() {
        return mAdditionalOperationTime;
    }

    public void setAdditionalOperationTime(List<String> additionalOperationTime) {
        mAdditionalOperationTime = additionalOperationTime;
    }

    public String getOperationId() {
        return mOperationId;
    }

    public void setOperationId(String operationId) {
        mOperationId = operationId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
            .append("operationId", mOperationId)
            .append("additionalOperationTime", mAdditionalOperationTime)
            .toString();
    }
}
