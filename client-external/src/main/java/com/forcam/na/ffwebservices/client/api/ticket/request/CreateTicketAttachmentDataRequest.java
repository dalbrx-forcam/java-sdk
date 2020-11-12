////////////////////////////////////////////////////////////////////////////////
//
// Created by tim on 27.11.19.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.ticket.request;

import com.forcam.na.common.webserviceaccess.util.ToStringUtility;
import com.forcam.na.ffwebservices.model.pdm.FileData;

/**
 * The request object for creating a ticket attachment data.
 */
public class CreateTicketAttachmentDataRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------
    private String mUuId;
    private String mTicketUuId;
    private FileData mFileData;
    private String mCreator;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new {@link CreateTicketAttachmentDataRequest} object with a attachment Id and a ticket Id.
     *  @param ticketId     The ticket Id.
     * @param attachmentId The attachment Id.
     * @param fileData     The file data.
     * @param creator      The creator.
     */
    public CreateTicketAttachmentDataRequest(String ticketId, String attachmentId, FileData fileData, String creator) {
        mUuId = attachmentId;
        mTicketUuId = ticketId;
        mFileData = fileData;
        mCreator = creator;
    }
    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return ToStringUtility
            .newToStringBuilder(this)
            .appendSuper(super.toString())
            .append("mUuId", mUuId)
            .append("mTicketUuId", mTicketUuId)
            .append("mFileData", mFileData)
            .append("mCreator", mCreator)
            .toString();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public String getUuId() {
        return mUuId;
    }

    public void setUuId(String uuId) {
        mUuId = uuId;
    }

    public String getTicketUuId() {
        return mTicketUuId;
    }

    public void setTicketUuId(String ticketUuId) {
        mTicketUuId = ticketUuId;
    }

    public FileData getFileData() {
        return mFileData;
    }

    public void setFileData(FileData fileData) {
        mFileData = fileData;
    }

    public String getCreator() {
        return mCreator;
    }

    public void setCreator(String creator) {
        mCreator = creator;
    }
}
