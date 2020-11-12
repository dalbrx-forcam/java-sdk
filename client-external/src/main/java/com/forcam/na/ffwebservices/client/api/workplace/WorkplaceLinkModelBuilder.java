////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 13.10.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.workplace;

import com.forcam.na.ffwebservices.client.api.AbstractLinkModelBuilder;
import com.forcam.na.ffwebservices.model.workplace.WorkplacePropertiesWSModel;

import javax.inject.Inject;

/**
 * Creates a workplace link model.
 */
public class WorkplaceLinkModelBuilder extends AbstractLinkModelBuilder<WorkplacePropertiesWSModel> {

    // ----------------------------------------------------------------------
    // constructors
    // ----------------------------------------------------------------------

    @Inject
    public WorkplaceLinkModelBuilder() {
        super(WorkplacePropertiesWSModel.class);
    }
}