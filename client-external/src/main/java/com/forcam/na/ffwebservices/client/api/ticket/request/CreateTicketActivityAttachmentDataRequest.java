////////////////////////////////////////////////////////////////////////////////
//
// Created by tim on 10.12.19.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.ticket.request;

import com.forcam.na.common.webserviceaccess.util.ToStringUtility;
import com.forcam.na.ffwebservices.model.pdm.FileData;

/**
 * The request object for creating ticket activity attachment data.
 */
public class CreateTicketActivityAttachmentDataRequest extends CreateTicketAttachmentDataRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------
    private String mActivityUuId;
    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    public CreateTicketActivityAttachmentDataRequest(String ticketId, String activityId, String attachmentId, FileData fileData, String creator) {
        super(ticketId, attachmentId, fileData, creator);
        mActivityUuId = activityId;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------
    @Override
    public String toString() {
        return ToStringUtility
            .newToStringBuilder(this)
            .appendSuper(super.toString())
            .append("mUuId", this.getUuId())
            .append("mTicketUuId", this.getTicketUuId())
            .append("mActivityUuId", this.getActivityUuId())
            .append("mFileData", this.getFileData())
            .append("mCreator", this.getCreator())
            .toString();
    }
    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public String getActivityUuId() {
        return mActivityUuId;
    }

    public void setActivityUuId(String activityUuId) {
        mActivityUuId = activityUuId;
    }
}
