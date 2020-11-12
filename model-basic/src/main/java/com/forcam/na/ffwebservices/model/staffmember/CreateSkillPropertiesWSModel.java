////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 07.11.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.staffmember;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Webservice model containing the properties necessary to create a skill.
 */
@ApiModel(value = "skillProperties")
@JsonPropertyOrder({ "description", "shortDescription", "code", "color", "rank" })
public class CreateSkillPropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private String mDescription;

    private String mShortDescription;

    private String mCode;

    private String mColor;

    private Integer mRank;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public String getDescription() {
        return mDescription;
    }

    @ApiModelProperty(value = "The description of the skill", position = 1)
    public void setDescription(String description) {
        mDescription = description;
    }

    public String getShortDescription() {
        return mShortDescription;
    }

    @ApiModelProperty(value = "An additional short description", position = 2)
    public void setShortDescription(String shortDescription) {
        mShortDescription = shortDescription;
    }

    public String getCode() {
        return mCode;
    }

    @ApiModelProperty(value = "The code assigned to the skill", position = 3)
    public void setCode(String code) {
        mCode = code;
    }

    public String getColor() {
        return mColor;
    }

    @ApiModelProperty(value = "The hexadecimal value of the color assigned to the skill", example = "#ffffff", position = 4)
    public void setColor(String color) {
        mColor = color;
    }

    public Integer getRank() {
        return mRank;
    }

    @ApiModelProperty(value = "In automatic planning, employees with more than one skill are preferably planned for the higher ranked skill. The rank value is between 0 and 100", position = 5, allowableValues = "range[0, 100]")
    public void setRank(Integer rank) {
        mRank = rank;
    }

}
