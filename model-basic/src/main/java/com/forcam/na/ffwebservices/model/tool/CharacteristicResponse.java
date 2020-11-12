////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 21.12.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.tool;

import com.forcam.na.ffwebservices.model.AbstractResponse;

/**
 * The response object for the characteristic.
 */
public class CharacteristicResponse extends AbstractResponse {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The properties for the characteristic. */
    private CharacteristicGeneralDefinition mProperties;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public CharacteristicGeneralDefinition getProperties() {
        return mProperties;
    }

    public void setProperties(CharacteristicGeneralDefinition properties) {
        mProperties = properties;
    }
}