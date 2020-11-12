////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 13.12.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.statusdefinition;

import com.forcam.na.ffwebservices.client.api.AbstractLinkModelBuilder;
import com.forcam.na.ffwebservices.model.statusdefinition.OperatingStatePropertiesWSModel;

import javax.inject.Inject;

/**
 * Creates an operating state link model.
 */
public class OperatingStateLinkModelBuilder extends AbstractLinkModelBuilder<OperatingStatePropertiesWSModel> {

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    @Inject
    public OperatingStateLinkModelBuilder() {
        super(OperatingStatePropertiesWSModel.class);
    }
}