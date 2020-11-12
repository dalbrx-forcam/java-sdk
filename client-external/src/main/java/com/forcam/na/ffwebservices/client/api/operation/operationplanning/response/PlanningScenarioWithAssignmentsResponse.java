////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 24.09.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.operation.operationplanning.response;

import com.forcam.na.ffwebservices.client.api.pagination.response.AbstractCollectionResponse;
import com.forcam.na.ffwebservices.client.api.pagination.request.PaginationRequest;
import com.forcam.na.ffwebservices.model.operation.OperationAssignmentWSModel;
import com.forcam.na.ffwebservices.model.operation.OperationPlanningScenarioPropertiesWSModel;

import java.util.List;

/**
 *
 */
public class PlanningScenarioWithAssignmentsResponse extends AbstractCollectionResponse<OperationAssignmentWSModel> {

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     *
     * @param request The request.
     */
    public PlanningScenarioWithAssignmentsResponse(PaginationRequest request) {
        super(request);
    }

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The operation planning scenario properties. */
    private OperationPlanningScenarioPropertiesWSModel mProperties = new OperationPlanningScenarioPropertiesWSModel();

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    @Override
    public List getElements() {
        return mProperties.getElements();
    }

    /**
     * Provides the operation planning scenario properties.
     *
     * @return The operation planning scenario properties WS model.
     */
    public OperationPlanningScenarioPropertiesWSModel getProperties() {
        return mProperties;
    }

    /**
     * Sets the The operation planning scenario properties.
     *
     * @param properties The operation planning scenario properties WS model.
     */
    public void setProperties(OperationPlanningScenarioPropertiesWSModel properties) {
        mProperties = properties;
    }
}