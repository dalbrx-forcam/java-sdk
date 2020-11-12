////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 15.11.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.staffmember.response;

import com.forcam.na.ffwebservices.client.api.pagination.response.SpecificPage;
import com.forcam.na.ffwebservices.model.staffmember.ScheduledWorkingTimeWSModel;

import java.lang.reflect.Method;

/**
 * Page containing scheduled working times of all staff members.
 */
public class StaffMembersScheduledWorkingTimesCollectionPage
    extends SpecificPage<ScheduledWorkingTimeWSModel, StaffMembersScheduledWorkingTimesCollectionResponse> {

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
    public StaffMembersScheduledWorkingTimesCollectionPage(Object client, Method clientMethod, StaffMembersScheduledWorkingTimesCollectionResponse response) {
        super(client, clientMethod, response);
    }
}