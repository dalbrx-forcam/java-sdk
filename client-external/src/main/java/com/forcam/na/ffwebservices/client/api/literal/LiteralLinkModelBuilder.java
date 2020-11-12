////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 18.09.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.literal;

import com.forcam.na.ffwebservices.client.api.AbstractLinkModelBuilder;
import com.forcam.na.ffwebservices.model.literal.LiteralPropertiesWSModel;

import javax.inject.Inject;

/**
 * Builds a literal link model.
 */
public class LiteralLinkModelBuilder extends AbstractLinkModelBuilder<LiteralPropertiesWSModel> {

    // ----------------------------------------------------------------------
    // constructors
    // ----------------------------------------------------------------------

    @Inject
    public LiteralLinkModelBuilder() {
        super(LiteralPropertiesWSModel.class);
    }
}