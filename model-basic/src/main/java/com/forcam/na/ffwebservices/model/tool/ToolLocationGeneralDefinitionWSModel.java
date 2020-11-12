////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 23.11.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.tool;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;
import com.forcam.na.ffwebservices.model.definition.GeoCoordinates;
import com.forcam.na.ffwebservices.model.workplace.WorkplaceGeneralDefinitionWSModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * The general definition model for a tool location.
 */
@ApiModel(value = "toolLocationGeneralDefinition")
@JsonPropertyOrder({ "workplace", "magazineNumber", "magazinePlace" })
public class ToolLocationGeneralDefinitionWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The workplace id */
    private WorkplaceGeneralDefinitionWSModel mWorkplace;

    private GeoCoordinates mGeoCoordinates;

    /** The magazine number */
    private Short mMagazineNumber;

    /** The magazine place */
    private Short mMagazinePlace;

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return ToStringUtility
            .newToStringBuilder(this)
            .append("mMagazineNumber", mMagazineNumber)
            .append("mMagazinePlace", mMagazinePlace)
            .append("mWorkplace", mWorkplace)
            .append("mGeoCoordinates", mGeoCoordinates)
            .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof ToolLocationGeneralDefinitionWSModel)) {
            return false;
        }

        ToolLocationGeneralDefinitionWSModel that = (ToolLocationGeneralDefinitionWSModel) o;

        return new EqualsBuilder()
            .append(getMagazineNumber(), that.getMagazineNumber())
            .append(getMagazinePlace(), that.getMagazinePlace())

            .append(getWorkplace(), that.getWorkplace())
            .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
            .append(getMagazineNumber())
            .append(getMagazinePlace())
            .append(getWorkplace())
            .toHashCode();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public GeoCoordinates getGeoCoordinates() {
        return mGeoCoordinates;
    }

    @ApiModelProperty(value = "The geographical coordinates of the tool", required = true, position = 0)
    public void setGeoCoordinates(GeoCoordinates geoCoordinates) {
        mGeoCoordinates = geoCoordinates;
    }

    @ApiModelProperty(value = "UUID of the corresponding workplace", required = true, position = 1)
    public void setWorkplace(WorkplaceGeneralDefinitionWSModel workplace) {
        mWorkplace = workplace;
    }

    public WorkplaceGeneralDefinitionWSModel getWorkplace() {
        return mWorkplace;
    }

    @ApiModelProperty(value = "Number of the tool magazine", required = false, position = 3)
    public void setMagazineNumber(Short magazineNumber) {
        mMagazineNumber = magazineNumber;
    }

    public Short getMagazineNumber() {
        return mMagazineNumber;
    }

    @ApiModelProperty(value = "Place in the tool magazine", required = false, position = 4)
    public void setMagazinePlace(Short magazinePlace) {
        mMagazinePlace = magazinePlace;
    }

    public Short getMagazinePlace() {
        return mMagazinePlace;
    }

}