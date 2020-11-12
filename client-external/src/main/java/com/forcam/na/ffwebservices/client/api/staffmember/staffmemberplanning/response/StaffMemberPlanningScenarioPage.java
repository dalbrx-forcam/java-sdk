////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 12.11.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.staffmember.staffmemberplanning.response;

import com.forcam.na.ffwebservices.client.api.pagination.response.SpecificPage;
import com.forcam.na.ffwebservices.model.staffmember.StaffMemberAssignmentWSModel;

import java.lang.reflect.Method;

/**
 * Staff member planning scenario with page of staff member assignments.
 */
public class StaffMemberPlanningScenarioPage extends SpecificPage<StaffMemberAssignmentWSModel, StaffMemberPlanningScenarioResponse> {

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     *
     * @param client   The client.
     * @param m        The client method.
     * @param response The response.
     */
    public StaffMemberPlanningScenarioPage(Object client, Method m, StaffMemberPlanningScenarioResponse response) {super(client, m, response);}

}