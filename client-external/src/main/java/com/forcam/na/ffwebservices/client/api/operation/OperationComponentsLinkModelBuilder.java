////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 05.11.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.operation;

import com.forcam.na.ffwebservices.client.api.AbstractLinkModelBuilder;
import com.forcam.na.ffwebservices.model.operation.OperationComponentCollectionPropertiesWSModel;

import javax.inject.Inject;

/**
 * Link model builder for operation components.
 */
public class OperationComponentsLinkModelBuilder extends AbstractLinkModelBuilder<OperationComponentCollectionPropertiesWSModel> {

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Constructor for link model builder.
     */
    @Inject
    public OperationComponentsLinkModelBuilder() {
        super(OperationComponentCollectionPropertiesWSModel.class);
    }
}