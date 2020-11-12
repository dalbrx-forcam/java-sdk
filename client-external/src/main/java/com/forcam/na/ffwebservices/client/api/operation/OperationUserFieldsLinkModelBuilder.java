////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 05.11.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.operation;

import com.forcam.na.ffwebservices.client.api.AbstractLinkModelBuilder;
import com.forcam.na.ffwebservices.model.operation.UserFieldCollectionPropertiesWSModel;

import javax.inject.Inject;

/**
 * Link model builder for operation user fields.
 */
public class OperationUserFieldsLinkModelBuilder extends AbstractLinkModelBuilder<UserFieldCollectionPropertiesWSModel> {

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Constructor for link model builder.
     */
    @Inject
    public OperationUserFieldsLinkModelBuilder() {
        super(UserFieldCollectionPropertiesWSModel.class);
    }
}