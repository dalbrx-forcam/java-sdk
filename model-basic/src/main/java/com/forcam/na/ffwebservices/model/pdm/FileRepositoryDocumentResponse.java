////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 26.10.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.pdm;

import com.forcam.na.ffwebservices.model.AbstractResponse;
import com.forcam.na.ffwebservices.model.LinkEmbeddedWSModel;
import com.forcam.na.ffwebservices.model.statusdefinition.StatusDefinitionPropertiesWSModel;

import java.util.List;

/**
 * Response model for a file repository document.
 */
public class FileRepositoryDocumentResponse extends AbstractResponse {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The file repository document properties. */
    private FileRepositoryDocumentWSModelProperties mProperties;

    /** The embedded NC state. */
    private LinkEmbeddedWSModel<StatusDefinitionPropertiesWSModel> mNcState;

    /** The embedded list of document folders. */
    private List<LinkEmbeddedWSModel<FileRepositoryFolderWSPropertiesModel>> mDocumentFolders;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public FileRepositoryDocumentWSModelProperties getProperties() {
        return mProperties;
    }

    public void setProperties(FileRepositoryDocumentWSModelProperties properties) {
        mProperties = properties;
    }

    public LinkEmbeddedWSModel<StatusDefinitionPropertiesWSModel> getNcState() {
        return mNcState;
    }

    public void setNcState(LinkEmbeddedWSModel<StatusDefinitionPropertiesWSModel> ncState) {
        mNcState = ncState;
    }

    public List<LinkEmbeddedWSModel<FileRepositoryFolderWSPropertiesModel>> getDocumentFolders() {
        return mDocumentFolders;
    }

    public void setDocumentFolders(List<LinkEmbeddedWSModel<FileRepositoryFolderWSPropertiesModel>> documentFolders) {
        mDocumentFolders = documentFolders;
    }
}