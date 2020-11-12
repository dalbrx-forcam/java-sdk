////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 11.12.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.command.machine;

import io.swagger.annotations.ApiModel;

/**
 * Model for machine count.
 */
@ApiModel(value = "machineCount")
public class MachineCountRequestBody {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The machine count. */
    private int mCount;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public int getCount() {
        return mCount;
    }

    public void setCount(int count) {
        mCount = count;
    }

}
