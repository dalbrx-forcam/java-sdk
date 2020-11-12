package com.forcam.na.ffwebservices.model.statusdefinition;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created: 08.03.2017
 *
 * @author David Albrecht
 */
@XmlRootElement(name = "createStatusdefinitionProperties")
@ApiModel(value = "createStatusdefinitionProperties")
@JsonPropertyOrder({ "description", "shortDescription", "code", "color" })
public class CreateStatusDefinitionPropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The description. */
    private String mDescription;

    /** The short description. */
    private String mShortDescription;

    /** The code. */
    private String mCode;

    /** The color. */
    private String mColor;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    @ApiModelProperty(value = "The description of the status definition", position = 1)
    public void setDescription(String description) {
        mDescription = description;
    }

    public String getDescription() {
        return mDescription;
    }

    @ApiModelProperty(value = "An additional short description", position = 2)
    public void setShortDescription(String shortDescription) {
        mShortDescription = shortDescription;
    }

    public String getShortDescription() {
        return mShortDescription;
    }

    @ApiModelProperty(value = "The code of the status definition", position = 3)
    public void setCode(String numericCode) {
        mCode = numericCode;
    }

    public String getCode() { return mCode; }

    @ApiModelProperty(value = "The hexadecimal value of the color assigned to the status definition", example = "#ffffff", position = 4)
    public void setColor(String color) { mColor = color; }

    public String getColor() {
        return mColor;
    }
}