////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 29.10.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.pdm.request;

import com.forcam.na.ffwebservices.model.pdm.DocumentEmbed;
import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Request parameter for getting a document by ID.
 */
public class GetDocumentRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Document ID. */
    private String mDocumentId;

    /** Determines what shall be embedded. */
    private DocumentEmbed mEmbed = new DocumentEmbed();

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates new instance.
     *
     * @param documentId The document ID.
     */
    public GetDocumentRequest(String documentId) {
        mDocumentId = documentId;
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
            .append("documentId", mDocumentId)
            .toString();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public String getDocumentId() {
        return mDocumentId;
    }

    public void setDocumentId(String documentId) {
        mDocumentId = documentId;
    }
}