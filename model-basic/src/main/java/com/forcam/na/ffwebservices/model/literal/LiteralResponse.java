////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 20.12.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.literal;

import com.forcam.na.ffwebservices.model.AbstractResponse;
import io.swagger.annotations.ApiModelProperty;

/**
 * The response object for a literal.
 */
public class LiteralResponse extends AbstractResponse {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The properties of the literal. */
    private LiteralPropertiesWSModel mProperties;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public LiteralPropertiesWSModel getProperties() {
        return mProperties;
    }

    @ApiModelProperty(value = "Properties of the literal")
    public void setProperties(LiteralPropertiesWSModel properties) {
        mProperties = properties;
    }
}