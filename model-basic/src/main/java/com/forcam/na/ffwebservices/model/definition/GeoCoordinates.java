////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 30.11.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.definition;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * API model containing geo coordinates.
 */
@ApiModel("geoCoordinates")
public class GeoCoordinates {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private Double mLatitude;

    private Double mLongitude;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public Double getLatitude() {
        return mLatitude;
    }

    @ApiModelProperty("Value of the latitude")
    public void setLatitude(Double latitude) {
        mLatitude = latitude;
    }

    public Double getLongitude() {
        return mLongitude;
    }

    @ApiModelProperty("Value of the longitude")
    public void setLongitude(Double longitude) {
        mLongitude = longitude;
    }
}
