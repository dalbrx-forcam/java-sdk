////////////////////////////////////////////////////////////////////////////////
//
// Created by DZeise on 09.03.2020.
//
// Copyright (c) 2006 - 2020 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.statusdefinition;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "createDocumentStateProperties")
@JsonPropertyOrder({ "description", "code", "color" })
public class CreateDocumentStatePropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private String mDescription;

    private String mCode;

    private String mColor;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public String getDescription() {
        return mDescription;
    }

    @ApiModelProperty(value = "The description of the status definition", position = 1)
    public void setDescription(String description) {
        mDescription = description;
    }

    public String getCode() {
        return mCode;
    }

    @ApiModelProperty(value = "The code of the document state", position = 2)
    public void setCode(String code) {
        mCode = code;
    }

    public String getColor() {
        return mColor;
    }

    @ApiModelProperty(value = "The hexadecimal value of the color assigned to the document state", example = "#ffffff", position = 3)
    public void setColor(String color) {
        mColor = color;
    }

}
