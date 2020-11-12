package com.forcam.na.ffwebservices.model.tool;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.ArrayList;
import java.util.List;

/**
 * Model containing the properties to create a tool edge.
 */
@ApiModel(value = "createToolEdgeProperties")
@JsonPropertyOrder({ "identifier", "lifetime", "characteristics" })
public class CreateToolEdgePropertiesWSModel extends GetToolEdgePropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The tool edge characteristics */
    private List<CharacteristicGeneralDefinition> mCharacteristics = new ArrayList<>();

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return ToStringUtility.newToStringBuilder(this)
            .appendSuper(super.toString())
            .append("characteristics", mCharacteristics)
            .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof CreateToolEdgePropertiesWSModel)) {
            return false;
        }

        CreateToolEdgePropertiesWSModel that = (CreateToolEdgePropertiesWSModel) o;

        return new EqualsBuilder()
            .appendSuper(super.equals(o))
            .append(getCharacteristics(), that.getCharacteristics())
            .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
            .appendSuper(super.hashCode())
            .append(getCharacteristics())
            .toHashCode();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    @ApiModelProperty(value = "Characteristics of the tool edge", position = 3)
    public void setCharacteristics(List<CharacteristicGeneralDefinition> characteristics) {
        mCharacteristics = characteristics;
    }

    public List<CharacteristicGeneralDefinition> getCharacteristics() {
        return mCharacteristics;
    }
}