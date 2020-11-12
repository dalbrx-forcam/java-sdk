////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 29.10.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.pdm.request;

import com.forcam.na.ffwebservices.model.pdm.CreateFileRepositoryDocumentWSModelProperties;

/**
 * Request parameter for creating a new folder document.
 */
public class CreateFileRepositoryDocumentRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The folder ID. */
    private String mFolderId;

    /** The properties of the document. */
    private CreateFileRepositoryDocumentWSModelProperties mDocumentProperties;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates new instance with the folder ID.
     *
     * @param folderId The folder ID.
     */
    public CreateFileRepositoryDocumentRequest(String folderId) {
        mFolderId = folderId;
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

    public CreateFileRepositoryDocumentWSModelProperties getDocumentProperties() {
        return mDocumentProperties;
    }

    public void setDocumentProperties(CreateFileRepositoryDocumentWSModelProperties documentProperties) {
        mDocumentProperties = documentProperties;
    }
}