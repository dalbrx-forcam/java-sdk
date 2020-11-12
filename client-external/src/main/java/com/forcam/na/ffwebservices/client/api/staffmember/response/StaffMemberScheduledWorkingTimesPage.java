////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 15.11.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.staffmember.response;

import com.forcam.na.ffwebservices.client.api.pagination.response.SpecificPage;
import com.forcam.na.ffwebservices.model.TimePeriodWSModel;

import java.lang.reflect.Method;

/**
 * Page containing the scheduled working times of a staff member.
 */
public class StaffMemberScheduledWorkingTimesPage extends SpecificPage<TimePeriodWSModel, StaffMemberScheduledWorkingTimesResponse> {

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
    public StaffMemberScheduledWorkingTimesPage(Object client, Method clientMethod, StaffMemberScheduledWorkingTimesResponse response) {
        super(client, clientMethod, response);
    }
}