////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 04.12.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.tool;

import com.forcam.na.ffwebservices.model.definition.GeoCoordinates;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;

/**
 * The tool location request body.
 */
@ApiModel("createToolLocationProperties")
public class CreateToolLocationPropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The workplace id */
    private String mWorkplaceId;

    private GeoCoordinates mGeoCoordinates;

    /** The magazine number */
    private Short mMagazineNumber;

    /** The magazine place */
    private Short mMagazinePlace;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    @NotBlank
    public String getWorkplaceId() {
        return mWorkplaceId;
    }

    @ApiModelProperty(value = "UUID of the corresponding workplace", required = true)
    public void setWorkplaceId(String workplaceId) {
        mWorkplaceId = workplaceId;
    }

    public GeoCoordinates getGeoCoordinates() {
        return mGeoCoordinates;
    }

    @ApiModelProperty(value = "Geographical coordinates of the tool")
    public void setGeoCoordinates(GeoCoordinates geoCoordinates) {
        mGeoCoordinates = geoCoordinates;
    }

    public Short getMagazineNumber() {
        return mMagazineNumber;
    }

    @ApiModelProperty(value = "Number of the tool magazine")
    public void setMagazineNumber(Short magazineNumber) {
        mMagazineNumber = magazineNumber;
    }

    public Short getMagazinePlace() {
        return mMagazinePlace;
    }

    @ApiModelProperty(value = "Place in the tool magazine")
    public void setMagazinePlace(Short magazinePlace) {
        mMagazinePlace = magazinePlace;
    }

}
