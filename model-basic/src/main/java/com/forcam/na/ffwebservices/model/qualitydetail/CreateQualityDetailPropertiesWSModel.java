package com.forcam.na.ffwebservices.model.qualitydetail;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Model for the creation of quantity reasons.
 */
@XmlRootElement(name = "createQualityDetailProperties")
@ApiModel(value = "createQualityDetailProperties")
@JsonPropertyOrder({ "description", "shortDescription", "qualityTypeId", "code", "color" })
public class CreateQualityDetailPropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Description of the reason. */
    private String mDescription;

    /** Short description of the reason. */
    private String mShortDescription;

    /** UUID of quantity type. */
    private QualityType mQualityTypeId;

    /** Mnemoic of the reason. */
    private String mCode;

    /** Color for the reason as RGB. */
    private String mColor;

    // ------------------------------------------------------------------------
    // getter/setter
    // ------------------------------------------------------------------------

    /**
     * Set the description.
     *
     * @param description Description
     */
    @ApiModelProperty(value = "Description of the quality detail", required = false, position = 1)
    public void setDescription(String description) {
        mDescription = description;
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
     * Set the short description.
     *
     * @param shortDescription Short description.
     */
    @ApiModelProperty(value = "Short description of the quality detail", required = false, position = 2)
    public void setShortDescription(String shortDescription) {
        mShortDescription = shortDescription;
    }

    /**
     * Provide the short description.
     *
     * @return Short description.
     */
    public String getShortDescription() {
        return mShortDescription;
    }

    @ApiModelProperty(value = "ID of the quality type", required = false, position = 3)
    public void setQualityTypeId(QualityType mQualityTypeId) {
        this.mQualityTypeId = mQualityTypeId;
    }

    public QualityType getQualityTypeId() {
        return mQualityTypeId;
    }

    @ApiModelProperty(value = "", position = 4)
    public void setCode(String code) {
        mCode = code;
    }

    public String getCode() {
        return mCode;
    }

    /**
     * Set the color as RGB value.
     *
     * @param color Color
     */
    @ApiModelProperty(value = "Color code", example = "#ffffff", required = false, position = 5)
    public void setColor(String color) {
        mColor = color;
    }

    /**
     * Provide the color as RGB value.
     *
     * @return Color
     */
    public String getColor() {
        return mColor;
    }
}