////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 11.11.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.definition;

/**
 * Supported Timebases. The name has to be equal to the entries in {@link TimeBaseFilter}.
 */
public enum TimeBase {
    PROD("PRODUCTION"),
    SETUP("SETUP"),
    OEE("SCHEDULED_OPERATING_TIME"),
    MALFUNCTION("MALFUNCTION"),
    MAINT("MAINTENANCE");

    private String mName;

    TimeBase(String name) {
        mName = name;
    }

    public String getName() {
        return mName;
    }
}
