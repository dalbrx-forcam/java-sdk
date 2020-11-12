////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 07.11.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.staffmember;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.forcam.na.ffwebservices.model.AbstractTimestampWithIdentifierModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * Webservice model containing the properties of a staff member skill matrix entry.
 */
@ApiModel("staffMemberSkillMatrixEntry")
@JsonPropertyOrder({ "skillId", "description", "shortDescription", "code", "skillLevel", "startDate", "endDate" })
public class StaffMemberSkillMatrixEntryWSModel extends AbstractTimestampWithIdentifierModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private String mSkillId;

    private String mDescription;

    private String mCode;

    private Double mSkillLevel;

    private Date mStartDate;

    private Date mEndDate;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public String getSkillId() {
        return mSkillId;
    }

    @ApiModelProperty(value = "UUID of the skill", position = 0)
    public void setSkillId(String skillId) {
        mSkillId = skillId;
    }

    public String getDescription() {
        return mDescription;
    }

    @ApiModelProperty(value = "A description of the skill", position = 1)
    public void setDescription(String description) {
        mDescription = description;
    }

    public String getCode() {
        return mCode;
    }

    @ApiModelProperty(value = "The code assigned to the skill", position = 2)
    public void setCode(String code) {
        mCode = code;
    }

    public Double getSkillLevel() {
        return mSkillLevel;
    }

    @ApiModelProperty(value = "A skill level has a continuous value range between 0 and 1, i.e. between 0% and 100%. Skill levels are taken into account in automatic labor capacity planning. If an employee has several skills with the same rank but different skill levels, he or she is assigned to the activity for which he or she is best qualified. Conversely, if more than one employee is available for an activity, those with the highest skill level for that activity are preferred. In order for an employee to be scheduled for an activity, he or she must have at least a minimum skill level that is set in the configuration", position = 3)
    public void setSkillLevel(Double skillLevel) {
        mSkillLevel = skillLevel;
    }

    public Date getStartDate() {
        return mStartDate;
    }

    @ApiModelProperty(value = "The date from which the qualification becomes effective", position = 4)
    public void setStartDate(Date startDate) {
        mStartDate = startDate;
    }

    public Date getEndDate() {
        return mEndDate;
    }

    @ApiModelProperty(value = "The expiration date of the qualification", position = 5)
    public void setEndDate(Date endDate) {
        mEndDate = endDate;
    }

    @Override
    public Date getPaginationDate() {
        return mStartDate;
    }

    @Override
    public String getPaginationIdentifier() {
        return mSkillId;
    }
}
