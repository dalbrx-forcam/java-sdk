////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 25.04.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.operation;

import com.forcam.na.ffwebservices.client.api.AbstractLinkModelBuilder;
import com.forcam.na.ffwebservices.model.operation.ProductionResourceToolPropertiesWSModel;

import javax.inject.Inject;

/**
 * Link model builder for production resources and tools.
 */
public class ProductionResourceToolLinkModelBuilder extends AbstractLinkModelBuilder<ProductionResourceToolPropertiesWSModel> {

    // ----------------------------------------------------------------------
    // constructors
    // ----------------------------------------------------------------------

    /** Creates new instance. */
    @Inject
    public ProductionResourceToolLinkModelBuilder() {
        super(ProductionResourceToolPropertiesWSModel.class);
    }
}