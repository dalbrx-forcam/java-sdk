////////////////////////////////////////////////////////////////////////////////
//
// Created by abhishekmundewal on 28-May-18.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.planningscenarioassignment;

import com.forcam.na.ffwebservices.model.AbstractResponse;
import com.forcam.na.ffwebservices.model.operation.OperationPlanningScenariosPropertiesWSModel;

/**
 * A response model for planning scenario.
 */
public class PlanningScenarioResponse extends AbstractResponse {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The properties of the operation planning scenario. */
    private OperationPlanningScenariosPropertiesWSModel mProperties;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Getter for properties operation planning scenario WS model.
     *
     * @return Operation planning scenario WS model.
     */
    public OperationPlanningScenariosPropertiesWSModel getProperties() {
        return mProperties;
    }

    /**
     * Setter for properties operation planning scenario WS model.
     *
     * @param properties Operation planning scenario WS model.
     */
    public void setProperties(OperationPlanningScenariosPropertiesWSModel properties) {
        mProperties = properties;
    }

}
