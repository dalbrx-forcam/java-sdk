////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 18.09.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.material;

import com.forcam.na.ffwebservices.client.api.AbstractLinkModelBuilder;
import com.forcam.na.ffwebservices.model.material.MaterialPropertiesWSModel;

/**
 * Builds a material link model.
 */
public class MaterialLinkModelBuilder extends AbstractLinkModelBuilder<MaterialPropertiesWSModel> {

    // ----------------------------------------------------------------------
    // constructors
    // ----------------------------------------------------------------------

    public MaterialLinkModelBuilder() {
        super(MaterialPropertiesWSModel.class);
    }
}