package com.forcam.na.ffwebservices.model.qualitytype;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Properties for creation of an operation quantity type.
 */
@XmlRootElement(name = "createQuantityTypeProperties")
@ApiModel(value = "createQuantityTypeProperties")
@JsonPropertyOrder({ "description", "shortDescription", "color" })
public class CreateQualityTypePropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Short description. */
    private String mShortDescription;

    /** Description */
    private String mDescription;

    /** Color as RGB. */
    private String mColor;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Provide the short description.
     *
     * @return Short description.
     */
    public String getShortDescription() {
        return mShortDescription;
    }

    /**
     * Set the short description.
     *
     * @param shortDescription Short description.
     */
    @ApiModelProperty(value = "Short description of the quality type", required = false, position = 2)
    public void setShortDescription(String shortDescription) {
        mShortDescription = shortDescription;
    }

    /**
     * Provide the description.
     *
     * @return Description
     */
    public String getDescription() {
        return mDescription;
    }

    /**
     * Set the description.
     *
     * @param description Description
     */
    @ApiModelProperty(value = "Description of the quality type", required = false, position = 1)
    public void setDescription(String description) {
        mDescription = description;
    }

    /**
     * Provide the color.
     *
     * @return Color as RGB.
     */
    public String getColor() {
        return mColor;
    }

    /**
     * Set the color.
     *
     * @param color Color as RGB.
     */
    @ApiModelProperty(value = "Color code", example = "#ffffff", required = false, position = 3)
    public void setColor(String color) {
        mColor = color;
    }
}