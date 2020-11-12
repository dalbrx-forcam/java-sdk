////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 10.12.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.operation;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The webservice model for a skill required for an operation.
 */
@ApiModel("operationRequiredSkill")
@JsonPropertyOrder({ "skillId", "minimumSkill", "capacity" })
public class OperationRequiredSkill {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private String mSkillId;

    private Double mMinimumSkill;

    private Double mCapacity;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public String getSkillId() {
        return mSkillId;
    }

    @ApiModelProperty(position = 0, value = "UUID of the required skill")
    public void setSkillId(String skillId) {
        mSkillId = skillId;
    }

    public Double getMinimumSkill() {
        return mMinimumSkill;
    }

    @ApiModelProperty(position = 1, value = "Minimum qualification required to perform the activity")
    public void setMinimumSkill(Double minimumSkill) {
        mMinimumSkill = minimumSkill;
    }

    public Double getCapacity() {
        return mCapacity;
    }

    @ApiModelProperty(position = 2, value = "Number of employees required")
    public void setCapacity(Double capacity) {
        mCapacity = capacity;
    }

}
