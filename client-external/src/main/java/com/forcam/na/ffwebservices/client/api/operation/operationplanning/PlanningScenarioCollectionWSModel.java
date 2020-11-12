////////////////////////////////////////////////////////////////////////////////
//
// Created by abhishekmundewal on 28-May-18.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.operation.operationplanning;

import com.forcam.na.ffwebservices.model.collection.AbstractCollectionWSModel;
import com.forcam.na.ffwebservices.model.operation.OperationPlanningScenariosPropertiesWSModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Planning scenario collection WS model.
 */
public class PlanningScenarioCollectionWSModel extends AbstractCollectionWSModel<OperationPlanningScenariosPropertiesWSModel> {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** A collection of operation planning scenario properties WS model. */
    private List<OperationPlanningScenariosPropertiesWSModel> mProperties = new ArrayList<>();

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Getter for operation planning scenario properties WS model.
     *
     * @return Operation planning scenario properties WS model.
     */
    public List<OperationPlanningScenariosPropertiesWSModel> getProperties() {
        return mProperties;
    }

    /**
     * Setter for operation planning scenario properties WS model.
     *
     * @param properties Operation planning scenario properties WS model.
     */
    public void setProperties(List<OperationPlanningScenariosPropertiesWSModel> properties) {
        mProperties = properties;
    }

}
