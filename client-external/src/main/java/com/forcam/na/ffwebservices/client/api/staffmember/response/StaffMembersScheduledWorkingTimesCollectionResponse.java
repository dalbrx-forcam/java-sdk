////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 15.11.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.staffmember.response;

import com.forcam.na.ffwebservices.client.api.pagination.response.AbstractCollectionResponse;
import com.forcam.na.ffwebservices.client.api.pagination.request.PaginationRequest;
import com.forcam.na.ffwebservices.model.staffmember.ScheduledWorkingTimeWSModel;
import com.forcam.na.ffwebservices.model.staffmember.StaffMembersScheduledWorkingTimesPropertiesWSModel;

import java.util.List;

/**
 * Staff members scheduled working times collection response.
 */
public class StaffMembersScheduledWorkingTimesCollectionResponse extends AbstractCollectionResponse<ScheduledWorkingTimeWSModel> {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The staff members scheduled working times properties. */
    private StaffMembersScheduledWorkingTimesPropertiesWSModel mProperties = new StaffMembersScheduledWorkingTimesPropertiesWSModel();

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     *
     * @param request The request.
     */
    public StaffMembersScheduledWorkingTimesCollectionResponse(PaginationRequest request) {
        super(request);
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Sets the staff members scheduled working times properties.
     *
     * @param properties The staff members scheduled working times properties WS model.
     */
    public void setProperties(StaffMembersScheduledWorkingTimesPropertiesWSModel properties) {
        mProperties = properties;
    }

    /**
     * Provides the staff members scheduled working times properties.
     *
     * @return The staff members scheduled working times properties WS model.
     */
    public StaffMembersScheduledWorkingTimesPropertiesWSModel getProperties() {
        return mProperties;
    }

    @Override
    public List<ScheduledWorkingTimeWSModel> getElements() {
        return mProperties.getElements();
    }
}