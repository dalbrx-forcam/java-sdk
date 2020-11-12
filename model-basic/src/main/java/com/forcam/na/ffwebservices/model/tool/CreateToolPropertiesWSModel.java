////////////////////////////////////////////////////////////////////////////////
//
// Created by dalbrecht on 27-11-2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.tool;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Model containing the properties to create a tool.
 */
@ApiModel(value = "createToolProperties")
@JsonPropertyOrder({ "name", "description", "identifier1", "identifier2", "identifier3", "documentUrl", "group", "class", "characteristics" })
public class CreateToolPropertiesWSModel extends GetToolPropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The tool location. */
    private CreateToolLocationPropertiesWSModel mLocation;

    /** The tool characteristics. */
    private List<CharacteristicGeneralDefinition> mCharacteristics = new ArrayList<>();

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return ToStringUtility.newToStringBuilder(this)
            .appendSuper(super.toString())
            .append("mCharacteristics", mCharacteristics)
            .append("mLocation", mLocation)
            .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof CreateToolPropertiesWSModel)) {
            return false;
        }

        CreateToolPropertiesWSModel that = (CreateToolPropertiesWSModel) o;

        return new EqualsBuilder()
            .append(getCharacteristics(), that.getCharacteristics())
            .append(getLocation(), that.getLocation())
            .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
            .append(getCharacteristics())
            .append(getLocation())
            .toHashCode();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    @ApiModelProperty(value = "Location of the tool", position = 10)
    public void setLocation(CreateToolLocationPropertiesWSModel location) {
        mLocation = location;
    }

    @Valid
    public CreateToolLocationPropertiesWSModel getLocation() {
        return mLocation;
    }

    @ApiModelProperty(value = "Characteristics of the tool", required = false, position = 11)
    public void setCharacteristics(List<CharacteristicGeneralDefinition> characteristics) {
        mCharacteristics = characteristics;
    }

    public List<CharacteristicGeneralDefinition> getCharacteristics() {
        return mCharacteristics;
    }
}