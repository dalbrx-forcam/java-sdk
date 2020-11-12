////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 21.11.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.staffmember.staffmemberplanning.response;

import com.forcam.na.ffwebservices.model.AbstractResponse;
import com.forcam.na.ffwebservices.model.staffmember.StaffMemberPlanningResultPropertiesWSModel;

/**
 * Staff member shift planning result response.
 */
public class StaffMemberShiftPlanningResultResponse extends AbstractResponse {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The staff member planning result properties. */
    private StaffMemberPlanningResultPropertiesWSModel mProperties = new StaffMemberPlanningResultPropertiesWSModel();

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public StaffMemberPlanningResultPropertiesWSModel getProperties() {
        return mProperties;
    }

    public void setProperties(StaffMemberPlanningResultPropertiesWSModel properties) {
        mProperties = properties;
    }
}