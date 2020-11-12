////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 07.05.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.operation;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.ArrayList;
import java.util.List;

/**
 * Update operation forecast request body.
 */
@JsonPropertyOrder({ "forecastResults" })
public class UpdateOperationForecastRequestBody {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** List of forecast results. */
    private List<OperationAssignmentWSModel> mForecastResults = new ArrayList<>();

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return ToStringUtility.newToStringBuilder(this)
            .append("forecastResult", mForecastResults)
            .toString();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Sets the list of forecast results.
     *
     * @param forecastResults The list of forecast results.
     */
    public void setForecastResults(List<OperationAssignmentWSModel> forecastResults) {
        mForecastResults = forecastResults;
    }

    /**
     * Provides the list of forecast results.
     *
     * @return The list of forecast results.
     */
    public List<OperationAssignmentWSModel> getForecastResults() {
        return mForecastResults;
    }
}