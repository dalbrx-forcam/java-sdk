////////////////////////////////////////////////////////////////////////////////
//
// Created by ARabbi on 5/10/2019.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.operation;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "operationTime")
public class OperationTime {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------
    private String mName;

    private long mDuration;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public String getName() {
        return mName;
    }

    @ApiModelProperty(value = "The name of operation time", position = 0)
    public void setName(String name) {
        mName = name;
    }

    public long getDuration() {
        return mDuration;
    }

    @ApiModelProperty(value = "The duration of the operation time", position = 1)
    public void setDuration(long duration) {
        mDuration = duration;
    }
}
