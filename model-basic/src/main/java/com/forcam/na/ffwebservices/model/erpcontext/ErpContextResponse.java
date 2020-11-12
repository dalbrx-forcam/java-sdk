////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 20.12.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.erpcontext;

import com.forcam.na.ffwebservices.model.AbstractResponse;

/**
 * The response object for an ERP context.
 */
public class ErpContextResponse extends AbstractResponse {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The properties of the ERP context. */
    private ErpContextPropertiesWSModel mProperties;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public ErpContextPropertiesWSModel getProperties() {
        return mProperties;
    }

    public void setProperties(ErpContextPropertiesWSModel properties) {
        mProperties = properties;
    }
}