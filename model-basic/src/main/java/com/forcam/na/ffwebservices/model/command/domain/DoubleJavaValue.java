////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 09.09.2020.
//
// Copyright (c) 2006 - 2020 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.command.domain;

/**
 * JSON model for Java {@link Double}.
 */
public class DoubleJavaValue extends AbstractJavaValue {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------

    public static final String NAME = "DOUBLE";

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private Double mValue;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    public DoubleJavaValue() {
        super(NAME);
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    @Override
    public Double getValue() {
        return mValue;
    }

    public void setValue(Double value) {
        mValue = value;
    }
}
