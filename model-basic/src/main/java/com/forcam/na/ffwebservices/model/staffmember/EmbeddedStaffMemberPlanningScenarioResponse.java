////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 12.11.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.staffmember;

import com.forcam.na.ffwebservices.model.AbstractResponse;

/**
 * Response model for an embedded staff member planning scenario.
 */
public class EmbeddedStaffMemberPlanningScenarioResponse extends AbstractResponse {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The properties of the operation planning scenario. */
    private StaffMemberPlanningScenariosPropertiesWSModel mProperties;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Getter for properties operation planning scenario WS model.
     *
     * @return Operation planning scenario WS model.
     */
    public StaffMemberPlanningScenariosPropertiesWSModel getProperties() {
        return mProperties;
    }

    /**
     * Setter for properties operation planning scenario WS model.
     *
     * @param properties Operation planning scenario WS model.
     */
    public void setProperties(StaffMemberPlanningScenariosPropertiesWSModel properties) {
        mProperties = properties;
    }
}