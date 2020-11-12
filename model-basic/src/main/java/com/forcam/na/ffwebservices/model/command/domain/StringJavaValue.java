////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 09.09.2020.
//
// Copyright (c) 2006 - 2020 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.command.domain;

/**
 * JSON model for Java {@link String}.
 */
public class StringJavaValue extends AbstractJavaValue {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------

    static final String NAME = "STRING";

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private String mValue;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    public StringJavaValue() {
        super(NAME);
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    @Override
    public String getValue() {
        return mValue;
    }

    public void setValue(String value) {
        mValue = value;
    }
}
