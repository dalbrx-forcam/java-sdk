////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 21.11.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.staffmember.staffmemberplanning.request;

import com.forcam.na.ffwebservices.model.staffmember.StaffMemberPlanningResultPropertiesWSModel;

/**
 * Request for creating a new staff member shift planning result.
 */
public class CreateStaffMemberShiftPlanningResultRequest extends GetStaffMemberShiftPlanningResultRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The planning result properties. */
    private StaffMemberPlanningResultPropertiesWSModel mStaffMemberPlanningResultProperties;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates new instance.
     *
     * @param staffMemberId            The staff member ID.
     * @param staffMemberShiftId       The staff member shift ID.
     * @param planningResultProperties The planning result properties.
     */
    public CreateStaffMemberShiftPlanningResultRequest(String staffMemberId, String staffMemberShiftId,
                                                       StaffMemberPlanningResultPropertiesWSModel planningResultProperties) {
        super(staffMemberId, staffMemberShiftId);

        mStaffMemberPlanningResultProperties = planningResultProperties;
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public StaffMemberPlanningResultPropertiesWSModel getStaffMemberPlanningResultProperties() {
        return mStaffMemberPlanningResultProperties;
    }

    public void setStaffMemberPlanningResultProperties(StaffMemberPlanningResultPropertiesWSModel staffMemberPlanningResultProperties) {
        mStaffMemberPlanningResultProperties = staffMemberPlanningResultProperties;
    }
}