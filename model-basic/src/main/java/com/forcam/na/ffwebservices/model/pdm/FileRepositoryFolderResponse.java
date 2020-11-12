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

/**
 * Response model for a file repository folder.
 */
public class FileRepositoryFolderResponse extends AbstractResponse {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The NC package properties */
    private FileRepositoryFolderWSPropertiesModel mProperties;

    /** The embedded NC state. */
    private LinkEmbeddedWSModel<StatusDefinitionPropertiesWSModel> mNcState;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public FileRepositoryFolderWSPropertiesModel getProperties() {
        return mProperties;
    }

    public void setProperties(FileRepositoryFolderWSPropertiesModel properties) {
        mProperties = properties;
    }

    public LinkEmbeddedWSModel<StatusDefinitionPropertiesWSModel> getNcState() {
        return mNcState;
    }

    public void setNcState(LinkEmbeddedWSModel<StatusDefinitionPropertiesWSModel> ncState) {
        mNcState = ncState;
    }
}