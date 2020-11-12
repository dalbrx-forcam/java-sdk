////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 18.09.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.callback;

import com.forcam.na.ffwebservices.client.api.AbstractLinkModelBuilder;
import com.forcam.na.ffwebservices.model.callback.CallbackPropertiesWSModel;

import javax.inject.Inject;

/**
 * Builds a callback link model.
 */
public class CallbackLinkModelBuilder extends AbstractLinkModelBuilder<CallbackPropertiesWSModel> {

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Instantiates a callback link model builder.
     */
    @Inject
    public CallbackLinkModelBuilder() {
        super(CallbackPropertiesWSModel.class);
    }
}