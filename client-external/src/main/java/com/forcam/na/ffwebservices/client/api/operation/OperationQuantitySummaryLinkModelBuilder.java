////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 29.10.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.operation;

import com.forcam.na.ffwebservices.client.api.AbstractLinkModelBuilder;
import com.forcam.na.ffwebservices.model.operation.quantity.OperationQuantitySummaryCollectionPropertiesWSModel;

import javax.inject.Inject;

/**
 *
 */
public class OperationQuantitySummaryLinkModelBuilder extends AbstractLinkModelBuilder<OperationQuantitySummaryCollectionPropertiesWSModel> {

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Constructor for link model builder.
     */
    @Inject
    public OperationQuantitySummaryLinkModelBuilder() {
        super(OperationQuantitySummaryCollectionPropertiesWSModel.class);
    }

}
