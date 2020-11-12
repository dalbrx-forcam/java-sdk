////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 08.01.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.tool;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * The basic tool edge properties.
 */
@ApiModel(value = "getToolEdgeProperties")
@JsonPropertyOrder({ "identifier", "lifetime" })
public class GetToolEdgePropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The tool edge identifier */
    private String mIdentifier;

    /** The tool edge life time */
    private LifeTime mLifeTime = new LifeTime();

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return ToStringUtility
            .newToStringBuilder(this)
            .append("identifier", mIdentifier)
            .append("lifetime", mLifeTime)
            .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof GetToolEdgePropertiesWSModel)) {
            return false;
        }

        GetToolEdgePropertiesWSModel that = (GetToolEdgePropertiesWSModel) o;

        return new EqualsBuilder()
            .append(mIdentifier, that.mIdentifier)
            .append(mLifeTime, that.mLifeTime)
            .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
            .append(mIdentifier)
            .append(mLifeTime)
            .toHashCode();
    }
    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public String getIdentifier() {
        return mIdentifier;
    }

    @ApiModelProperty(value = "A domain specific description of the cutting edge", required = true, position = 1)
    public void setIdentifier(String identifier) {
        mIdentifier = identifier;
    }

    public LifeTime getLifeTime() {
        return mLifeTime;
    }

    @ApiModelProperty(value = "Information on the service life of the cutting edge", position = 2)
    public void setLifeTime(LifeTime lifeTime) {
        mLifeTime = lifeTime;
    }
}