////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 24.07.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.operation.quantity;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 *
 */
@ApiModel("quantities")
@JsonPropertyOrder({ "yield", "scrap", "rework" })
public class QuantitiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private double mYield;

    private double mScrap;

    private double mRework;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    @ApiModelProperty(value = "Yield quantity", position = 0)
    public void setYield(double yield) {
        mYield = yield;
    }

    public double getYield() {
        return mYield;
    }

    @ApiModelProperty(value = "Scrap quantity", position = 1)
    public void setScrap(double scrap) {
        mScrap = scrap;
    }

    public double getScrap() {
        return mScrap;
    }

    @ApiModelProperty(value = "Rework quantities", position = 2)
    public void setRework(double rework) {
        mRework = rework;
    }

    public double getRework() {
        return mRework;
    }
}