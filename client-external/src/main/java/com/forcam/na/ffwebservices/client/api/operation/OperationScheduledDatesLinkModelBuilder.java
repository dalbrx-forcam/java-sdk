////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 25.04.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.operation;

import com.forcam.na.ffwebservices.client.api.AbstractLinkModelBuilder;
import com.forcam.na.ffwebservices.model.operation.OperationScheduledDatesPropertiesWSModel;

import javax.inject.Inject;

/**
 * Link model builder for operation scheduled dates.
 */
public class OperationScheduledDatesLinkModelBuilder extends AbstractLinkModelBuilder<OperationScheduledDatesPropertiesWSModel> {

    // ----------------------------------------------------------------------
    // constructors
    // ----------------------------------------------------------------------

    /** Creates new instance. */
    @Inject
    public OperationScheduledDatesLinkModelBuilder() {
        super(OperationScheduledDatesPropertiesWSModel.class);
    }
}