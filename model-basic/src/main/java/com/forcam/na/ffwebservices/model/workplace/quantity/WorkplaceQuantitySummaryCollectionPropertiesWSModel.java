////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 19.01.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.workplace.quantity;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Properties model for workplace quantity summary.
 */
@ApiModel("workplaceQuantitySummaryCollectionProperties")
@JsonPropertyOrder({ "performance", "timeBasedQualityRate", "quantityBasedQualityRate", "elements"})
public class WorkplaceQuantitySummaryCollectionPropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The performance rate of the workplace. */
    private double mPerformance;

    /** The time based quality rate of the workplace. */
    private double mTimeBasedQualityRate;

    /** The quantity based quality rate of the workplace. */
    private double mQuantityBasedQualityRate;

    /** The workplace quantity summary details. */
    private List<WorkplaceQuantitySummaryDetailPropertiesWSModel> mElements = new ArrayList<>();

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    @ApiModelProperty(value = "The performance rate of the workplace during the selected time period.", position = 0)
    public void setPerformance(double performance) {
        mPerformance = performance;
    }

    public double getPerformance() {
        return mPerformance;
    }

    @ApiModelProperty(value = "The time based quality rate of the work-place during the selected time period.", position = 1)
    public void setTimeBasedQualityRate(double qualityRate) {
        mTimeBasedQualityRate = qualityRate;
    }

    public double getTimeBasedQualityRate() {
        return mTimeBasedQualityRate;
    }

    @ApiModelProperty(value = "The quantity based quality rate of the work-place during the selected time period.", position = 2)
    public void setQuantityBasedQualityRate(double qualityRate) {
        mQuantityBasedQualityRate = qualityRate;
    }

    public double getQuantityBasedQualityRate() {
        return mQuantityBasedQualityRate;
    }

    @ApiModelProperty(position = 3)
    public void setElements(List<WorkplaceQuantitySummaryDetailPropertiesWSModel> elements) {
        mElements = elements;
    }

    public List<WorkplaceQuantitySummaryDetailPropertiesWSModel> getElements() {
        return mElements;
    }
}