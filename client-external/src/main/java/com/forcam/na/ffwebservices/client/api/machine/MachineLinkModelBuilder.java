////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 18.09.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.machine;

import com.forcam.na.ffwebservices.client.api.AbstractLinkModelBuilder;
import com.forcam.na.ffwebservices.model.machine.MachinePropertiesWSModel;

import javax.inject.Inject;

/**
 * Builds a machine link model.
 */
public class MachineLinkModelBuilder extends AbstractLinkModelBuilder<MachinePropertiesWSModel> {

    // ----------------------------------------------------------------------
    // constructors
    // ----------------------------------------------------------------------

    @Inject
    public MachineLinkModelBuilder() {
        super(MachinePropertiesWSModel.class);
    }
}