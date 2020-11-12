////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 09.09.2020.
//
// Copyright (c) 2006 - 2020 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.command.domain;

import java.util.HashMap;

/**
 * JSON model for Java {@link java.util.Map}.
 */
public class MapJavaValue extends AbstractJavaValue {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------

    static final String NAME = "MAP";

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private HashMap<String, AbstractJavaValue> mValue;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    public MapJavaValue() {
        super(NAME);
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public HashMap<String, AbstractJavaValue> getValue() {
        return mValue;
    }

    public void setValue(HashMap<String, AbstractJavaValue> value) {
        mValue = value;
    }
}
