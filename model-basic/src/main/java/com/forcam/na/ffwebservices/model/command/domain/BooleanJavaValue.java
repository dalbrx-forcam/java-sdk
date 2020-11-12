////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 09.09.2020.
//
// Copyright (c) 2006 - 2020 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.command.domain;

import java.io.Serializable;

/**
 * JSON model for Java {@link Boolean}.
 */
public class BooleanJavaValue extends AbstractJavaValue {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------

    static final String NAME = "BOOLEAN";

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private Boolean mValue;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    public BooleanJavaValue() {
        super(NAME);
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    @Override
    public Boolean getValue() {
        return mValue;
    }

    public void setValue(Boolean value) {
        mValue = value;
    }
}
