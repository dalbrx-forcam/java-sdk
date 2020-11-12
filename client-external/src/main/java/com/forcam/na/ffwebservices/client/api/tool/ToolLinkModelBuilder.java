////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 09.01.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.tool;

import com.forcam.na.ffwebservices.client.api.AbstractLinkModelBuilder;
import com.forcam.na.ffwebservices.model.tool.ToolPropertiesWSModel;

import javax.inject.Inject;

/**
 * Creates a tool link model.
 */
public class ToolLinkModelBuilder extends AbstractLinkModelBuilder<ToolPropertiesWSModel> {

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    @Inject
    public ToolLinkModelBuilder() {
        super(ToolPropertiesWSModel.class);
    }
}