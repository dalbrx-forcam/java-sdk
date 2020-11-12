////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 26.09.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.workplace.request;

import com.forcam.na.ffwebservices.client.api.pagination.request.CollectionRequest;
import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * Request parameter for getting all predicted malfunction scenarios.
 */
public class GetWorkplacePredictedMalfunctionScenariosRequest extends CollectionRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The start date of the considered period. */
    private Date mStartDate;

    /** The end date of the considered period. */
    private Date mEndDate;

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return ToStringUtility.newToStringBuilder(this)
            .append("startDate", mStartDate)
            .append("endDate", mEndDate)
            .toString();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Provides the start date of the considered period.
     *
     * @return The start date of the considered period.
     */
    public Date getStartDate() {
        return mStartDate;
    }

    /**
     * Sets the start date of the considered period.
     *
     * @param startDate The start date of the considered period.
     */
    public void setStartDate(Date startDate) {
        mStartDate = startDate;
    }

    /**
     * Provides the end date of the considered period.
     *
     * @return The end date of the considered period.
     */
    public Date getEndDate() {
        return mEndDate;
    }

    /**
     * Sets the end date of the considered period.
     *
     * @param endDate The end date of the considered period.
     */
    public void setEndDate(Date endDate) {
        mEndDate = endDate;
    }
}