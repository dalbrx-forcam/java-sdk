////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 13.09.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.staffmember.response;

import com.forcam.na.ffwebservices.client.api.pagination.response.SpecificPage;
import com.forcam.na.ffwebservices.model.staffmember.StaffMemberLoginPeriodRecordWSModel;

import java.lang.reflect.Method;

/**
 * Page containing the recorded activies of a staff member.
 */
public class StaffMemberRecordedLoginPeriodCollectionPage
    extends SpecificPage<StaffMemberLoginPeriodRecordWSModel, StaffMemberRecordedLoginPeriodCollectionResponse> {
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
    public StaffMemberRecordedLoginPeriodCollectionPage(Object client, Method m, StaffMemberRecordedLoginPeriodCollectionResponse response) {
        super(client, m, response);
    }
}
