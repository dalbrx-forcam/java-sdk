////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 13.09.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.staffmember.response;

import com.forcam.na.ffwebservices.client.api.pagination.response.SpecificPage;
import com.forcam.na.ffwebservices.model.staffmember.StaffMemberAbsenceWSModel;

import java.lang.reflect.Method;

/**
 * Page containing the staff member absences.
 */
public class StaffMemberAbsenceCollectionPage extends SpecificPage<StaffMemberAbsenceWSModel, StaffMemberAbsenceCollectionResponse> {

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
    public StaffMemberAbsenceCollectionPage(Object client, Method m, StaffMemberAbsenceCollectionResponse response) {super(client, m, response);}

}
