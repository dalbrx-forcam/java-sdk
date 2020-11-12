////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 26.10.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.pdm.request;

import com.forcam.na.ffwebservices.client.api.pagination.request.CollectionTimestampRequest;
import com.forcam.na.ffwebservices.model.pdm.DocumentEmbed;
import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Request parameter for getting all folder documents.
 */
public class GetFolderDocumentsRequest extends CollectionTimestampRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The folder ID. */
    private String mFolderId;

    /** Determines what shall be embedded. */
    private DocumentEmbed mEmbed = new DocumentEmbed();

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    public GetFolderDocumentsRequest(String folderId) {
        mFolderId = folderId;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    public DocumentEmbed embed() {
        return mEmbed;
    }

    public void embed(DocumentEmbed embed) {
        mEmbed = embed;
    }

    @Override
    public String toString() {
        return ToStringUtility.newToStringBuilder(this)
            .append("embed", mEmbed)
            .append("folderId", mFolderId)
            .toString();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public String getFolderId() {
        return mFolderId;
    }

    public void setFolderId(String folderId) {
        mFolderId = folderId;
    }
}