////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 03.12.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.location;

import com.forcam.na.ffwebservices.model.definition.GeoCoordinates;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Location properties model.
 */
@ApiModel("locationProperties")
public class LocationPropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private GeoCoordinates mGeoCoordinates = new GeoCoordinates();

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public GeoCoordinates getGeoCoordinates() {
        return mGeoCoordinates;
    }

    @ApiModelProperty(value = "Geographic coordinates of the location")
    public void setGeoCoordinates(GeoCoordinates geoCoordinates) {
        mGeoCoordinates = geoCoordinates;
    }

}
