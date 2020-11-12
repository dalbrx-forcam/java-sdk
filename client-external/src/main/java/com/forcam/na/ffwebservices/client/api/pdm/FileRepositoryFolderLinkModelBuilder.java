////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 29.10.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.pdm;

import com.forcam.na.ffwebservices.client.api.AbstractLinkModelBuilder;
import com.forcam.na.ffwebservices.model.pdm.FileRepositoryFolderWSPropertiesModel;

import javax.inject.Inject;

/**
 * Link model builder for file repository folder.
 */
public class FileRepositoryFolderLinkModelBuilder extends AbstractLinkModelBuilder<FileRepositoryFolderWSPropertiesModel> {

    // ----------------------------------------------------------------------
    // constructors
    // ----------------------------------------------------------------------

    @Inject
    public FileRepositoryFolderLinkModelBuilder() {
        super(FileRepositoryFolderWSPropertiesModel.class);
    }
}