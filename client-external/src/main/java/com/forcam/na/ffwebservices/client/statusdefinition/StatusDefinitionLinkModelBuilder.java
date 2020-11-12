////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 10.01.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.statusdefinition;

import com.forcam.na.ffwebservices.client.api.AbstractLinkModelBuilder;
import com.forcam.na.ffwebservices.model.statusdefinition.StatusDefinitionPropertiesWSModel;

import javax.inject.Inject;

/**
 * Creates a status definition link model.
 */
public class StatusDefinitionLinkModelBuilder extends AbstractLinkModelBuilder<StatusDefinitionPropertiesWSModel> {

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    @Inject
    public StatusDefinitionLinkModelBuilder() {
        super(StatusDefinitionPropertiesWSModel.class);
    }
}