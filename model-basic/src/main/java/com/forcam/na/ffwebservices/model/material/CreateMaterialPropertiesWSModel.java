package com.forcam.na.ffwebservices.model.material;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Created: 08.03.2017
 *
 * @author David Albrecht
 */
@ApiModel(value = "createMaterialProperties")
@JsonPropertyOrder({ "number", "description", "type" })
public class CreateMaterialPropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The number. */
    private String mNumber;

    /** The description. */
    private String mDescription;

    /** The type. */
    private String mType;

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof CreateMaterialPropertiesWSModel)) {
            return false;
        }

        final CreateMaterialPropertiesWSModel other = (CreateMaterialPropertiesWSModel) obj;

        final EqualsBuilder equalsBuilder = new EqualsBuilder();
        equalsBuilder.append(this.getDescription(), other.getDescription());
        equalsBuilder.append(this.getNumber(), other.getNumber());
        equalsBuilder.append(this.getType(), other.getType());

        return equalsBuilder.isEquals();
    }

    @Override
    public int hashCode() {
        final HashCodeBuilder hashCodeBuilder = new HashCodeBuilder();
        hashCodeBuilder.append(this.getType());
        hashCodeBuilder.append(this.getDescription());
        hashCodeBuilder.append(this.getNumber());

        return hashCodeBuilder.hashCode();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    @ApiModelProperty(value = "The material number which is unique in its ERP context", required = true, position = 1)
    public void setNumber(String number) {
        mNumber = number;
    }

    public String getNumber() {
        return mNumber;
    }

    @ApiModelProperty(value = "A description of the material", position = 2)
    public void setDescription(String description) {
        mDescription = description;
    }

    public String getDescription() {
        return mDescription;
    }

    @ApiModelProperty(value = "The material type", position = 3)
    public void setType(String type) {
        mType = type;
    }

    public String getType() {
        return mType;
    }
}