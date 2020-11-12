////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 25.09.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.workplace;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * Predicted malfunction scenario properties model.
 */
public class CreatePredictedMalfunctionScenarioPropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The person or system who has created the malfunction scenario. */
    private String mCreator;

    /** The start date. */
    private Date mStartDate;

    /** The end date. */
    private Date mEndDate;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public String getCreator() {
        return mCreator;
    }

    @ApiModelProperty(value = "The person or system that has created the malfunction scenario", position = 1)
    public void setCreator(String creator) {
        mCreator = creator;
    }

    public Date getStartDate() {
        return mStartDate;
    }

    @ApiModelProperty(value = "The start date of the predicted malfunction scenario", required = true, position = 3)
    public void setStartDate(Date startDate) {
        mStartDate = startDate;
    }

    public Date getEndDate() {
        return mEndDate;
    }

    @ApiModelProperty(value = "The end date of the predicted malfunction scenario", required = true, position = 4)
    public void setEndDate(Date endDate) {
        mEndDate = endDate;
    }
}