////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 25.04.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.workplacegroup;

import com.forcam.na.ffwebservices.client.api.AbstractLinkModelBuilder;
import com.forcam.na.ffwebservices.model.workplacegroup.WorkplaceGroupPropertiesWSModel;

import javax.inject.Inject;

/**
 * Link model builder for workplace groups.
 */
public class WorkplaceGroupLinkModelBuilder extends AbstractLinkModelBuilder<WorkplaceGroupPropertiesWSModel> {

    // ----------------------------------------------------------------------
    // constructors
    // ----------------------------------------------------------------------

    /** Creates new instance. */
    @Inject
    public WorkplaceGroupLinkModelBuilder() {
        super(WorkplaceGroupPropertiesWSModel.class);
    }
}