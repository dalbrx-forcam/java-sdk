////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 23.11.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.workplacegroup;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.PositiveOrZero;

/**
 * The workplace group manufacturing variant rule forecast request body used when creating a processing variant.
 */
@JsonPropertyOrder({ "processAvailability", "performance", "qualityRate", "additionalSetupTime", "intermediateSetupInterval", "intermediateSetupTime",
                     "staffCapacityFactor", "skillFactor" })
public class WorkplaceGroupManufacturingVariantRuleForecastRequestBody {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private Double mProcessAvailability;

    @PositiveOrZero
    private Double mPerformance;

    private Double mQualityRate;

    private Long mAdditionalSetupTime;

    private Double mIntermediateSetupInterval;

    private Long mIntermediateSetupTime;

    private Double mStaffCapacityFactor;

    private Double mSkillFactor;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public Double getProcessAvailability() {
        return mProcessAvailability;
    }

    @ApiModelProperty(position = 0, required = true)
    public void setProcessAvailability(Double processAvailability) {
        mProcessAvailability = processAvailability;
    }

    public Double getPerformance() {
        return mPerformance;
    }

    @ApiModelProperty(position = 1, required = true)
    public void setPerformance(Double performance) {
        mPerformance = performance;
    }

    public Double getQualityRate() {
        return mQualityRate;
    }

    @ApiModelProperty(position = 2, required = true)
    public void setQualityRate(Double qualityRate) {
        mQualityRate = qualityRate;
    }

    public Long getAdditionalSetupTime() {
        return mAdditionalSetupTime;
    }

    @ApiModelProperty(position = 3)
    public void setAdditionalSetupTime(Long additionalSetupTime) {
        mAdditionalSetupTime = additionalSetupTime;
    }

    public Double getIntermediateSetupInterval() {
        return mIntermediateSetupInterval;
    }

    @ApiModelProperty(position = 4)
    public void setIntermediateSetupInterval(Double intermediateSetupInterval) {
        mIntermediateSetupInterval = intermediateSetupInterval;
    }

    public Long getIntermediateSetupTime() {
        return mIntermediateSetupTime;
    }

    @ApiModelProperty(position = 5)
    public void setIntermediateSetupTime(Long intermediateSetupTime) {
        mIntermediateSetupTime = intermediateSetupTime;
    }

    public Double getStaffCapacityFactor() {
        return mStaffCapacityFactor;
    }

    @ApiModelProperty(position = 6)
    public void setStaffCapacityFactor(Double staffCapacityFactor) {
        mStaffCapacityFactor = staffCapacityFactor;
    }

    public Double getSkillFactor() {
        return mSkillFactor;
    }

    @ApiModelProperty(position = 7)
    public void setSkillFactor(Double skillFactor) {
        mSkillFactor = skillFactor;
    }

}
