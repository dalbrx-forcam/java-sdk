////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 18.12.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.operation.request;

import com.forcam.na.common.webserviceaccess.util.ToStringUtility;
import com.forcam.na.ffwebservices.model.operation.UpdateOperationRecordedOperatingStateRequestBody;

/**
 * Contains a workplace id.
 */
public class UpdateOperationRecordedOperatingStateRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Operation quality detail. */
    private UpdateOperationRecordedOperatingStateRequestBody mUpdateOperationRecordedOperatingState = new UpdateOperationRecordedOperatingStateRequestBody();

    /** The operation id. */
    private String mOperationId;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new {@link UpdateOperationRecordedOperatingStateRequest} object with a workplace ID.
     *
     * @param operationId The operation ID.
     */
    public UpdateOperationRecordedOperatingStateRequest(String operationId) {
        mOperationId = operationId;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return ToStringUtility
            .newToStringBuilder(this)
            .appendSuper(super.toString())
            .append("operationId", mOperationId)
            .append("workplaceRecordedOperatingState", mUpdateOperationRecordedOperatingState)
            .toString();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public UpdateOperationRecordedOperatingStateRequestBody getOperationRecordedOperatingState() {
        return mUpdateOperationRecordedOperatingState;
    }

    public void setOperationRecordedOperatingState(UpdateOperationRecordedOperatingStateRequestBody updateOperationRecordedOperatingState) {
        mUpdateOperationRecordedOperatingState = updateOperationRecordedOperatingState;
    }

    public String getOperationId() {
        return mOperationId;
    }

    public void setOperationId(String operationId) {
        mOperationId = operationId;
    }
}