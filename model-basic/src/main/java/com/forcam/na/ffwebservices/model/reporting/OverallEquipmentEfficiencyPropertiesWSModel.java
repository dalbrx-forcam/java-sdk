////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 28.11.2019.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.reporting;

import io.swagger.annotations.ApiModel;

/**
 * Webservice model for the properties of the overall equipment efficiency
 */
@ApiModel("overallEquipmentEfficiencyProperties")
public class OverallEquipmentEfficiencyPropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private Double mAvailability;
    private Double mQuality;
    private Double mOEE;
    private Double mPerformance;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public void setAvailability(Double availability) {
        mAvailability = availability;
    }

    public Double getAvailability() {
        return mAvailability;
    }

    public void setQuality(Double quality) {
        mQuality = quality;
    }

    public Double getQuality() {
        return mQuality;
    }

    public void setOEE(Double oee) {
        mOEE = oee;
    }

    public Double getOEE() {
        return mOEE;
    }

    public void setPerformance(Double performance) {
        mPerformance = performance;
    }

    public Double getPerformance() {
        return mPerformance;
    }
}
