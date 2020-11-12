////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 23.11.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.workplacegroup;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 *
 */
@ApiModel("workGroupManufacturingVariantRuleForecast")
@JsonPropertyOrder({ "delayFactor", "processAvailability", "performance", "qualityRate", "additionalSetupTime", "intermediateSetupInterval",
                     "intermediateSetupTime", "staffCapacityFactor", "skillFactor" })
public class WorkplaceGroupManufacturingVariantRuleForecastWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private Double mDelayFactor;

    private Double mProcessAvailability;

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

    public Double getDelayFactor() {
        return mDelayFactor;
    }

    @ApiModelProperty(value = "1/[processAvailability * performance * qualityRate]", position = 0)
    public void setDelayFactor(Double delayFactor) {
        mDelayFactor = delayFactor;
    }

    public Double getProcessAvailability() {
        return mProcessAvailability;
    }

    @ApiModelProperty(value = "Predicted process availability of the workplace during the execution of the operation", position = 1)
    public void setProcessAvailability(Double processAvailability) {
        mProcessAvailability = processAvailability;
    }

    public Double getPerformance() {
        return mPerformance;
    }

    @ApiModelProperty(value = "Predicted performance rate during the execution of the operation", position = 2)
    public void setPerformance(Double performance) {
        mPerformance = performance;
    }

    public Double getQualityRate() {
        return mQualityRate;
    }

    @ApiModelProperty(value = "Predicted quality rate during the execution of the operation", position = 3)
    public void setQualityRate(Double qualityRate) {
        mQualityRate = qualityRate;
    }

    public Long getAdditionalSetupTime() {
        return mAdditionalSetupTime;
    }

    @ApiModelProperty(value = "An additional setup time resulting from the special tool used in the manufacturing variant", position = 4)
    public void setAdditionalSetupTime(Long additionalSetupTime) {
        mAdditionalSetupTime = additionalSetupTime;
    }

    public Long getIntermediateSetupTime() {
        return mIntermediateSetupTime;
    }

    @ApiModelProperty(value = "The setup time for each intermediate setup", position = 6)
    public void setIntermediateSetupTime(Long intermediateSetupTime) {
        mIntermediateSetupTime = intermediateSetupTime;
    }

    public Double getStaffCapacityFactor() {
        return mStaffCapacityFactor;
    }

    @ApiModelProperty(value = "Used to determine an additional delay factor caused by understaffing", position = 7)
    public void setStaffCapacityFactor(Double staffCapacityFactor) {
        mStaffCapacityFactor = staffCapacityFactor;
    }

    public Double getSkillFactor() {
        return mSkillFactor;
    }

    @ApiModelProperty(value = "", notes = "Used to determine an additional delay factor caused by poorly qualified staff members", position = 8)
    public void setSkillFactor(Double skillFactor) {
        mSkillFactor = skillFactor;
    }

    public Double getIntermediateSetupInterval() {
        return mIntermediateSetupInterval;
    }

    @ApiModelProperty(value = "The total output quantity after which intermediate setup of the workplace is required", position = 5)
    public void setIntermediateSetupInterval(Double intermediateSetupInterval) {
        mIntermediateSetupInterval = intermediateSetupInterval;
    }
}
