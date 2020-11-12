////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 23.11.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.operation;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 *
 */
@ApiModel("manufacturingVariantForecast")
@JsonPropertyOrder({ "delayFactor", "processAvailability", "performance", "qualityRate", "processingTime", "additionalSetupTime", "intermediateSetupTime",
                     "staffCapacityFactor", "skillFactor" })
public class OperationManufacturingVariantForecastWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private Double mDelayFactor;

    private Double mProcessAvailability;

    private Double mPerformance;

    private Double mQualityRate;

    private Long mProcessingTime;

    private Long mAdditionalSetupTime;

    private Long mIntermediateSetupTime;

    private Double mStaffCapacityFactor;

    private Double mSkillFactor;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public Double getDelayFactor() {
        return mDelayFactor;
    }

    @ApiModelProperty(value = "Defined as follows: 1/[processAvailability * performance * qualityRate] The forecast processing time is the target processing time * delay factor", position = 0)
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

    public Long getProcessingTime() {
        return mProcessingTime;
    }

    @ApiModelProperty(value = "Predicted processing time in msec, which is target processing time * dalay factor", position = 4)
    public void setProcessingTime(Long processingTime) {
        mProcessingTime = processingTime;
    }

    public Long getAdditionalSetupTime() {
        return mAdditionalSetupTime;
    }

    @ApiModelProperty(value = "Additional setup time resulting from the special tool used in the manufacturing variant", position = 5)
    public void setAdditionalSetupTime(Long additionalSetupTime) {
        mAdditionalSetupTime = additionalSetupTime;
    }

    public Long getIntermediateSetupTime() {
        return mIntermediateSetupTime;
    }

    @ApiModelProperty(value = "Time required for all intermediate setups", position = 6)
    public void setIntermediateSetupTime(Long intermediateSetupTime) {
        mIntermediateSetupTime = intermediateSetupTime;
    }

    public Double getStaffCapacityFactor() {
        return mStaffCapacityFactor;
    }

    @ApiModelProperty(value = "If a value is specified here, the factor is used as follows to determine an additional delay factor caused by understaffing: " +
                              "additional delay factor = staffCapacityFactor * number of required staff members / number of available staff members", position = 7)
    public void setStaffCapacityFactor(Double staffCapacityFactor) {
        mStaffCapacityFactor = staffCapacityFactor;
    }

    public Double getSkillFactor() {
        return mSkillFactor;
    }

    @ApiModelProperty(value =
        "If a value is specified here, the factor is used as fol-lows to determine an additional delay factor caused by poorly qualified staff members: " +
        "additional delay factor = skillFactor / skillLevel", position = 8)
    public void setSkillFactor(Double skillFactor) {
        mSkillFactor = skillFactor;
    }
}
