////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 13.09.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.erpcontext;

import com.forcam.na.ffwebservices.client.api.AbstractLinkModelBuilder;
import com.forcam.na.ffwebservices.model.erpcontext.ErpContextPropertiesWSModel;

import javax.inject.Inject;

/**
 * Builds an ERP context link model.
 */
public class ERPContextLinkModelBuilder extends AbstractLinkModelBuilder<ErpContextPropertiesWSModel> {

    // ----------------------------------------------------------------------
    // constructors
    // ----------------------------------------------------------------------

    @Inject
    public ERPContextLinkModelBuilder() {
        super(ErpContextPropertiesWSModel.class);
    }
}