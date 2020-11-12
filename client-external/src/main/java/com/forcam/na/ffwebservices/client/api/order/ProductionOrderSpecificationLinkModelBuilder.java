////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 24.10.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.order;

import com.forcam.na.ffwebservices.client.api.AbstractLinkModelBuilder;
import com.forcam.na.ffwebservices.model.order.ProductionOrderSpecificationPropertiesWSModel;

import javax.inject.Inject;

/**
 * Creates an ProductionOrderSpecification link model.
 */
public class ProductionOrderSpecificationLinkModelBuilder extends AbstractLinkModelBuilder<ProductionOrderSpecificationPropertiesWSModel> {

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Constructor for link model builder.
     */
    @Inject
    public ProductionOrderSpecificationLinkModelBuilder() {
        super(ProductionOrderSpecificationPropertiesWSModel.class);
    }
}
