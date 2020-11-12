////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 24.11.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.tool;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * The general definition for a characteristic.
 */
@ApiModel(value = "characteristicGeneralDefinition")
@JsonPropertyOrder({ "name", "identifier", "value", "unit" })
public class CharacteristicGeneralDefinition {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The characteristic name */
    private String mName;

    /** The characteristic identifier */
    private String mIdentifier;

    /** The characteristic value */
    private String mValue;

    /** The unit of the characteristic value */
    private String mUnit;

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return ToStringUtility
            .newToStringBuilder(this)
            .append("mIdentifier", mIdentifier)
            .append("mName", mName)
            .append("mValue", mValue)
            .append("mUnit", mUnit)
            .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof CharacteristicGeneralDefinition)) {
            return false;
        }

        CharacteristicGeneralDefinition that = (CharacteristicGeneralDefinition) o;

        return new EqualsBuilder()
            .append(getIdentifier(), that.getIdentifier())
            .append(getName(), that.getName())
            .append(getValue(), that.getValue())
            .append(getUnit(), that.getUnit())
            .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
            .append(getIdentifier())
            .append(getName())
            .append(getValue())
            .append(getUnit())
            .toHashCode();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    @ApiModelProperty(value = "Name of the characteristic", position = 0, required = true)
    public void setName(String name) {
        mName = name;
    }

    public String getName() {
        return mName;
    }

    @ApiModelProperty(value = "Technical identifier of the characteristic according to ISO 13399", required = true, position = 1)
    public void setIdentifier(String identifier) {
        mIdentifier = identifier;
    }

    public String getIdentifier() {
        return mIdentifier;
    }

    @ApiModelProperty(value = "Value of characteristic", position = 2, required = true)
    public void setValue(String value) {
        mValue = value;
    }

    public String getValue() {
        return mValue;
    }

    @ApiModelProperty(value = "Unit of the characteristic", position = 3)
    public void setUnit(String unit) {
        mUnit = unit;
    }

    public String getUnit() {
        return mUnit;
    }
}