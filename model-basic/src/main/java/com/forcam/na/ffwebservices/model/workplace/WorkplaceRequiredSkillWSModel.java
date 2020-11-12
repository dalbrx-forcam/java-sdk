////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 08.11.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.workplace;

import com.forcam.na.ffwebservices.model.AbstractTimestampModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * Model for required skills for a workplace.
 */
@ApiModel("workplaceRequiredSkill")
public class WorkplaceRequiredSkillWSModel extends AbstractTimestampModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private String mSkillId;

    private Double mMinimumSkill;

    private String mWorkplaceShiftId;

    private Date mStartDate;

    private Date mEndDate;

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

    @ApiModelProperty(position = 1, value = "The minimum qualification required to perform the activity")
    public void setMinimumSkill(Double minimumSkill) {
        mMinimumSkill = minimumSkill;
    }

    public String getWorkplaceShiftId() {
        return mWorkplaceShiftId;
    }

    @ApiModelProperty(position = 2, value = "UUID of the workplace shift")
    public void setWorkplaceShiftId(String workplaceShiftId) {
        mWorkplaceShiftId = workplaceShiftId;
    }

    public Date getStartDate() {
        return mStartDate;
    }

    @ApiModelProperty(position = 3, notes = "If the required skills are not determined shift-related, but at the exact time (based on detailed order scheduling), the start date within the workplace shift from which the requirements exist is specified here")
    public void setStartDate(Date startDate) {
        mStartDate = startDate;
    }

    public Date getEndDate() {
        return mEndDate;
    }

    @ApiModelProperty(position = 4, notes = "If the required skills are not determined shift-related, but at the exact time (based on detailed order scheduling), the end date within the workplace shift up to which the requirements exist is specified here")
    public void setEndDate(Date endDate) {
        mEndDate = endDate;
    }

    public Double getCapacity() {
        return mCapacity;
    }

    @ApiModelProperty(position = 5, value = "Number of employees required during the corresponding workplace shift or the specified time period within this shift")
    public void setCapacity(Double capacity) {
        mCapacity = capacity;
    }

    @Override
    public Date getPaginationDate() {
        return mStartDate;
    }
}
