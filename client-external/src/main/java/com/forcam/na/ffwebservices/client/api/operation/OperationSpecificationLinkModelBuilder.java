////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 25.04.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.operation;

import com.forcam.na.ffwebservices.client.api.AbstractLinkModelBuilder;
import com.forcam.na.ffwebservices.model.operation.OperationSpecificationPropertiesWSModel;

import javax.inject.Inject;

/**
 * Link model builder for operation specifications.
 */
public class OperationSpecificationLinkModelBuilder extends AbstractLinkModelBuilder<OperationSpecificationPropertiesWSModel> {

    // ----------------------------------------------------------------------
    // constructors
    // ----------------------------------------------------------------------

    /** Creates new instance. */
    @Inject
    public OperationSpecificationLinkModelBuilder() {
        super(OperationSpecificationPropertiesWSModel.class);
    }
}