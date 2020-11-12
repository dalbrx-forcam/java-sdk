////////////////////////////////////////////////////////////////////////////////
//
// Created by ARabbi on 7/8/2019.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.workplace;

import com.forcam.na.ffwebservices.client.api.AbstractLinkModelBuilder;
import com.forcam.na.ffwebservices.model.operation.UserFieldCollectionPropertiesWSModel;

import javax.inject.Inject;

public class WorkplaceUserFieldsLinkModelBuilder extends AbstractLinkModelBuilder<UserFieldCollectionPropertiesWSModel> {

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Constructor for link model builder.
     */
    @Inject
    public WorkplaceUserFieldsLinkModelBuilder() {
        super(UserFieldCollectionPropertiesWSModel.class);
    }

}
