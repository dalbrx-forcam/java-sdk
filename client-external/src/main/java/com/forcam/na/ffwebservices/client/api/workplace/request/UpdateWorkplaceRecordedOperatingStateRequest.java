////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 18.12.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.workplace.request;

import com.forcam.na.ffwebservices.model.workplace.UpdateWorkplaceRecordedOperatingStateRequestBody;
import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Contains a workplace id.
 */
public class UpdateWorkplaceRecordedOperatingStateRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Operation quality detail. */
    private UpdateWorkplaceRecordedOperatingStateRequestBody mUpdateWorkplaceRecordedOperatingState = new UpdateWorkplaceRecordedOperatingStateRequestBody();

    /** The workplace id. */
    private String mWorkplaceId;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new {@link UpdateWorkplaceRecordedOperatingStateRequest} object with a workplace ID.
     *
     * @param workplaceId The workplace ID.
     */
    public UpdateWorkplaceRecordedOperatingStateRequest(String workplaceId) {
        mWorkplaceId = workplaceId;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return ToStringUtility.newToStringBuilder(this)
            .appendSuper(super.toString())
            .append("workplaceId", mWorkplaceId)
            .append("workplaceRecordedOperatingState", mUpdateWorkplaceRecordedOperatingState)
            .toString();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public UpdateWorkplaceRecordedOperatingStateRequestBody getWorkplaceRecordedOperatingState() {
        return mUpdateWorkplaceRecordedOperatingState;
    }

    public void setWorkplaceRecordedOperatingState(UpdateWorkplaceRecordedOperatingStateRequestBody updateWorkplaceRecordedOperatingState) {
        mUpdateWorkplaceRecordedOperatingState = updateWorkplaceRecordedOperatingState;
    }

    public String getWorkplaceId() {
        return mWorkplaceId;
    }

    public void setWorkplaceId(String workplaceId) {
        mWorkplaceId = workplaceId;
    }
}