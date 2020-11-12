////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 13.10.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.shifttype;

import com.forcam.na.ffwebservices.client.api.AbstractLinkModelBuilder;
import com.forcam.na.ffwebservices.model.shifttype.ShiftTypePropertiesWSModel;

import javax.inject.Inject;

/**
 * Creates a shift type link model.
 */
public class ShiftTypeLinkModelBuilder extends AbstractLinkModelBuilder<ShiftTypePropertiesWSModel> {

    // ----------------------------------------------------------------------
    // constructors
    // ----------------------------------------------------------------------

    @Inject
    public ShiftTypeLinkModelBuilder() {
        super(ShiftTypePropertiesWSModel.class);
    }
}