////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 09.09.2020.
//
// Copyright (c) 2006 - 2020 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.command.domain;

/**
 * JSON model for Java {@link Integer}.
 */
public class IntegerJavaValue extends AbstractJavaValue {


    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------

    static final String NAME = "INTEGER";

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private Integer mValue;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    public IntegerJavaValue() {
        super(NAME);
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    @Override
    public Integer getValue() {
        return mValue;
    }

    public void setValue(Integer value) {
        mValue = value;
    }
}
