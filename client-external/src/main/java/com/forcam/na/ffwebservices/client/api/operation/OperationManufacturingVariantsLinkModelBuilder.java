////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 25.06.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.operation;

import com.forcam.na.ffwebservices.client.api.AbstractLinkModelBuilder;
import com.forcam.na.ffwebservices.model.operation.OperationManufacturingVariantsPropertiesWSModel;

import javax.inject.Inject;

/**
 * Link model builder for operation manufacturing variants.
 */
public class OperationManufacturingVariantsLinkModelBuilder extends AbstractLinkModelBuilder<OperationManufacturingVariantsPropertiesWSModel> {

    // ----------------------------------------------------------------------
    // constructors
    // ----------------------------------------------------------------------

    /** Creates new instance. */
    @Inject
    public OperationManufacturingVariantsLinkModelBuilder() {
        super(OperationManufacturingVariantsPropertiesWSModel.class);
    }
}