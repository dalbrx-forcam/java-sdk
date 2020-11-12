////////////////////////////////////////////////////////////////////////////////
//
// Created by abhishekmundewal on 28-May-18.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.operation.operationplanning.request;

import com.forcam.na.ffwebservices.client.api.pagination.request.CollectionRequest;
import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Request for get planning scenario.
 */
public class GetPlanningScenarioRequest extends CollectionRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The workplace number. */
    private String mPlanningScenarioId;

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------
    @Override
    public String toString() {
        return ToStringUtility.newToStringBuilder(this)
            .appendSuper(super.toString())
            .append("mPlanningScenarioId", mPlanningScenarioId)
            .toString();
    }
    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Getter for planning scenario id.
     *
     * @return Planning scenario assignment id.
     */
    public String getPlanningScenarioId() {
        return mPlanningScenarioId;
    }

    /**
     * Setter for planning scenario id.
     *
     * @param planningScenarioId Planning scenario id.
     */
    public void setPlanningScenarioId(String planningScenarioId) {
        mPlanningScenarioId = planningScenarioId;
    }
}
