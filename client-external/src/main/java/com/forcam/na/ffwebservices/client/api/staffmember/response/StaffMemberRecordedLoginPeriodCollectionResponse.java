////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 30.08.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.staffmember.response;

import com.forcam.na.ffwebservices.client.api.pagination.response.AbstractCollectionResponse;
import com.forcam.na.ffwebservices.client.api.pagination.request.PaginationRequest;
import com.forcam.na.ffwebservices.model.staffmember.StaffMemberLoginPeriodRecordWSModel;
import com.forcam.na.ffwebservices.model.staffmember.StaffMemberRecordedActivitiesCollectionPropertiesWSModel;

import java.util.List;

/**
 * Staff member recorded activities collection response model.
 */
public class StaffMemberRecordedLoginPeriodCollectionResponse extends AbstractCollectionResponse<StaffMemberLoginPeriodRecordWSModel> {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The staff member recorded activities collection properties WS model. */
    private StaffMemberRecordedActivitiesCollectionPropertiesWSModel mProperties = new StaffMemberRecordedActivitiesCollectionPropertiesWSModel();

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     *
     * @param request The request.
     */
    public StaffMemberRecordedLoginPeriodCollectionResponse(PaginationRequest request) {
        super(request);
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Sets the staff member recorded activities collection properties.
     *
     * @param properties The staff member recorded activities collection properties WS model.
     */
    public void setProperties(StaffMemberRecordedActivitiesCollectionPropertiesWSModel properties) {
        mProperties = properties;
    }

    /**
     * Provides the staff member recorded activities collection properties.
     *
     * @return The staff member recorded activities collection properties WS model.
     */
    public StaffMemberRecordedActivitiesCollectionPropertiesWSModel getProperties() {
        return mProperties;
    }

    @Override
    public List<StaffMemberLoginPeriodRecordWSModel> getElements() {
        return mProperties.getElements();
    }
}