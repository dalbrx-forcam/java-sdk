////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 25.06.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.operation;

import com.forcam.na.ffwebservices.client.api.AbstractLinkModelBuilder;
import com.forcam.na.ffwebservices.model.operation.OperationAssignmentWSModel;

import javax.inject.Inject;

/**
 * Link model builder for operation forecast result.
 */
public class OperationForecastResultLinkModelBuilder extends AbstractLinkModelBuilder<OperationAssignmentWSModel> {

    // ----------------------------------------------------------------------
    // constructors
    // ----------------------------------------------------------------------

    /** Creates new instance. */
    @Inject
    public OperationForecastResultLinkModelBuilder() {
        super(OperationAssignmentWSModel.class);
    }
}