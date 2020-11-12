////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 21.11.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.staffmember.staffmemberplanning.response;

import com.forcam.na.ffwebservices.client.api.pagination.response.SpecificPage;
import com.forcam.na.ffwebservices.model.staffmember.StaffMemberAssignmentWSModel;

import java.lang.reflect.Method;

/**
 * Page containing the planning results of all staff members.
 */
public class StaffMembersPlanningResultsPage extends SpecificPage<StaffMemberAssignmentWSModel, StaffMembersPlanningResultsResponse> {

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     *
     * @param client       The client which can be used for requests.
     * @param clientMethod The method of the client which can be used for requests.
     * @param response     The current response.
     */
    public StaffMembersPlanningResultsPage(Object client, Method clientMethod, StaffMembersPlanningResultsResponse response) {
        super(client, clientMethod, response);
    }
}