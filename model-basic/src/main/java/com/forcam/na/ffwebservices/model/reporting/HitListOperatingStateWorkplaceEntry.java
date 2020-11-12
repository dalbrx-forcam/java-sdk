////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 02.12.2019.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.reporting;

import io.swagger.annotations.ApiModel;

/**
 * Entry of the hit list operating state workplace report.
 */
@ApiModel("hitListOperatingStateWorkplaceEntry")
public class HitListOperatingStateWorkplaceEntry {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private String mWorkplaceId;

    private String mOperatingStateId;

    private Double mFrequency;

    private Long mDuration;

    private Double mDurationPercentage;

    private Double mAbsoluteDurationPercentage;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public Double getFrequency() {
        return mFrequency;
    }

    public void setFrequency(Double frequency) {
        mFrequency = frequency;
    }

    public Long getDuration() {
        return mDuration;
    }

    public void setDuration(Long duration) {
        mDuration = duration;
    }

    public Double getDurationPercentage() {
        return mDurationPercentage;
    }

    public void setDurationPercentage(Double durationPercentage) {
        mDurationPercentage = durationPercentage;
    }

    public Double getAbsoluteDurationPercentage() {
        return mAbsoluteDurationPercentage;
    }

    public void setAbsoluteDurationPercentage(Double absoluteDurationPercentage) {
        mAbsoluteDurationPercentage = absoluteDurationPercentage;
    }

    public String getOperatingStateId() {
        return mOperatingStateId;
    }

    public void setOperatingStateId(String operatingStateId) {
        mOperatingStateId = operatingStateId;
    }

    public String getWorkplaceId() {
        return mWorkplaceId;
    }

    public void setWorkplaceId(String workplaceId) {
        mWorkplaceId = workplaceId;
    }
}
