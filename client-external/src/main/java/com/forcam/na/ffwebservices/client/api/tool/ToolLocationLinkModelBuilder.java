////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 05.12.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.tool;

import com.forcam.na.ffwebservices.client.api.AbstractLinkModelBuilder;
import com.forcam.na.ffwebservices.model.tool.ToolLocationGeneralDefinitionWSModel;

import javax.inject.Inject;

/**
 * Link model builder for tool locations.
 */
public class ToolLocationLinkModelBuilder extends AbstractLinkModelBuilder<ToolLocationGeneralDefinitionWSModel> {

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Constructor for link model builder.
     */
    @Inject
    public ToolLocationLinkModelBuilder() {
        super(ToolLocationGeneralDefinitionWSModel.class);
    }

}
