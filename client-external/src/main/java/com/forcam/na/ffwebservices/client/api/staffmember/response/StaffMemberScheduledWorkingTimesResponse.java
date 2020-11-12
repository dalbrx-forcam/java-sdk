////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 15.11.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.staffmember.response;

import com.forcam.na.ffwebservices.client.api.pagination.response.AbstractCollectionResponse;
import com.forcam.na.ffwebservices.client.api.pagination.request.PaginationRequest;
import com.forcam.na.ffwebservices.model.TimePeriodWSModel;
import com.forcam.na.ffwebservices.model.staffmember.StaffMemberScheduledWorkingTimesPropertiesWSModel;

import java.util.List;

/**
 * Staff member scheduled working times collection response.
 */
public class StaffMemberScheduledWorkingTimesResponse extends AbstractCollectionResponse<TimePeriodWSModel> {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The staff member scheduled working times properties. */
    private StaffMemberScheduledWorkingTimesPropertiesWSModel mProperties = new StaffMemberScheduledWorkingTimesPropertiesWSModel();

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     *
     * @param request The request.
     */
    public StaffMemberScheduledWorkingTimesResponse(PaginationRequest request) {
        super(request);
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Sets the staff member scheduled working times properties.
     *
     * @param properties The staff member scheduled working times properties WS model.
     */
    public void setProperties(StaffMemberScheduledWorkingTimesPropertiesWSModel properties) {
        mProperties = properties;
    }

    /**
     * Provides the staff member scheduled working times properties.
     *
     * @return The staff member scheduled working times properties WS model.
     */
    public StaffMemberScheduledWorkingTimesPropertiesWSModel getProperties() {
        return mProperties;
    }

    @Override
    public List<TimePeriodWSModel> getElements() {
        return mProperties.getElements();
    }
}