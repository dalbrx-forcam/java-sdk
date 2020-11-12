////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 28.11.2019.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.reporting;

import io.swagger.annotations.ApiModel;

/**
 * Webservice model for the properties of the overall process efficiency
 */
@ApiModel("overallProcessEfficiencyProperties")
public class OverallProcessEfficiencyPropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private Double mQuality;
    private Double mOPE;
    private Double mPerformance;

    private Double mProcessAvailability;
    private Double mSetupReduction;
    private Double mSchedulingEfficiency;
    private Double mProductionProcessRatio;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public Double getQuality() {
        return mQuality;
    }

    public void setQuality(Double quality) {
        mQuality = quality;
    }

    public Double getOPE() {
        return mOPE;
    }

    public void setOPE(Double OPE) {
        mOPE = OPE;
    }

    public Double getPerformance() {
        return mPerformance;
    }

    public void setPerformance(Double performance) {
        mPerformance = performance;
    }

    public Double getProcessAvailability() {
        return mProcessAvailability;
    }

    public void setProcessAvailability(Double processAvailability) {
        mProcessAvailability = processAvailability;
    }

    public Double getSetupReduction() {
        return mSetupReduction;
    }

    public void setSetupReduction(Double setupReduction) {
        mSetupReduction = setupReduction;
    }

    public Double getSchedulingEfficiency() {
        return mSchedulingEfficiency;
    }

    public void setSchedulingEfficiency(Double schedulingEfficiency) {
        mSchedulingEfficiency = schedulingEfficiency;
    }

    public Double getProductionProcessRatio() {
        return mProductionProcessRatio;
    }

    public void setProductionProcessRatio(Double productionProcessRatio) {
        mProductionProcessRatio = productionProcessRatio;
    }
}
