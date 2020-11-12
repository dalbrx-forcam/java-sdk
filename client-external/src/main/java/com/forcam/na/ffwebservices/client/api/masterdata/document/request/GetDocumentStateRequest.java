////////////////////////////////////////////////////////////////////////////////
//
// Created by DZeise on 09.03.2020.
//
// Copyright (c) 2006 - 2020 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.masterdata.document.request;

import com.forcam.na.common.webserviceaccess.util.ToStringUtility;
import com.forcam.na.ffwebservices.model.statusdefinition.DocumentStateEmbed;

/**
 * Contains an ID and values that determine what shall be embedded.
 */
public class GetDocumentStateRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** A document state ID. */
    private String mId;

    /** Determines what shall be embedded. */
    private DocumentStateEmbed mEmbed = new DocumentStateEmbed();

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new {@link GetDocumentStateRequest} object with an document state ID.
     *
     * @param mId The document state ID
     */
    public GetDocumentStateRequest(String mId) {
        this.mId = mId;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return ToStringUtility
            .newToStringBuilder(this)
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

    public DocumentStateEmbed embed() {
        return mEmbed;
    }

    public void embed(DocumentStateEmbed embed) {
        mEmbed = embed;
    }

}
