////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 09.09.2020.
//
// Copyright (c) 2006 - 2020 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.command.domain;

/**
 * JSON model for Java {@link Long}.
 */
public class LongJavaValue extends AbstractJavaValue {


    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------

    public static final String NAME = "LONG";

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private Long mValue;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    public LongJavaValue() {
        super(NAME);
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    @Override
    public Long getValue() {
        return mValue;
    }

    public void setValue(Long value) {
        mValue = value;
    }
}
