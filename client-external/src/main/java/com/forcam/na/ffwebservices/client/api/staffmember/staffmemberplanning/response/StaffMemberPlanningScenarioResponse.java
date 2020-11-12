////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 12.11.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.staffmember.staffmemberplanning.response;

import com.forcam.na.ffwebservices.client.api.pagination.response.AbstractCollectionResponse;
import com.forcam.na.ffwebservices.client.api.pagination.request.PaginationRequest;
import com.forcam.na.ffwebservices.model.staffmember.StaffMemberAssignmentWSModel;
import com.forcam.na.ffwebservices.model.staffmember.StaffMemberPlanningScenarioPropertiesWSModel;

import java.util.List;

/**
 * Staff member planning scenario response.
 */
public class StaffMemberPlanningScenarioResponse extends AbstractCollectionResponse<StaffMemberAssignmentWSModel> {

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     *
     * @param request The request.
     */
    public StaffMemberPlanningScenarioResponse(PaginationRequest request) {
        super(request);
    }

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The staff member planning scenario properties. */
    private StaffMemberPlanningScenarioPropertiesWSModel mProperties = new StaffMemberPlanningScenarioPropertiesWSModel();

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    @Override
    public List<StaffMemberAssignmentWSModel> getElements() {
        return mProperties.getElements();
    }

    public StaffMemberPlanningScenarioPropertiesWSModel getProperties() {
        return mProperties;
    }

    public void setProperties(StaffMemberPlanningScenarioPropertiesWSModel properties) {
        mProperties = properties;
    }
}