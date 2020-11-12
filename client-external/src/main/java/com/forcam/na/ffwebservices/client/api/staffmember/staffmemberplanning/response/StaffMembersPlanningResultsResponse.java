////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 21.11.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.staffmember.staffmemberplanning.response;

import com.forcam.na.ffwebservices.client.api.pagination.response.AbstractCollectionResponse;
import com.forcam.na.ffwebservices.client.api.pagination.request.PaginationRequest;
import com.forcam.na.ffwebservices.model.staffmember.StaffMemberAssignmentWSModel;
import com.forcam.na.ffwebservices.model.staffmember.StaffMemberPlanningResultCollectionProperties;

import java.util.List;

/**
 * Staff members planning results response.
 */
public class StaffMembersPlanningResultsResponse extends AbstractCollectionResponse<StaffMemberAssignmentWSModel> {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The staff member planning results properties. */
    private StaffMemberPlanningResultCollectionProperties mProperties = new StaffMemberPlanningResultCollectionProperties();

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     *
     * @param request The request.
     */
    public StaffMembersPlanningResultsResponse(PaginationRequest request) {
        super(request);
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Provides the staff member planning results properties.
     *
     * @return The staff member planning results properties.
     */
    public StaffMemberPlanningResultCollectionProperties getProperties() {
        return mProperties;
    }

    /**
     * Sets the staff member planning results properties.
     *
     * @param properties The staff member planning results properties.
     */
    public void setProperties(StaffMemberPlanningResultCollectionProperties properties) {
        mProperties = properties;
    }

    @Override
    public List<StaffMemberAssignmentWSModel> getElements() {
        return mProperties.getElements();
    }
}