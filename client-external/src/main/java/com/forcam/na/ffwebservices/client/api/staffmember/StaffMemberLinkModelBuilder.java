////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 22.10.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.staffmember;

import com.forcam.na.ffwebservices.client.api.AbstractLinkModelBuilder;
import com.forcam.na.ffwebservices.model.staffmember.StaffMemberPropertiesWSModel;

import javax.inject.Inject;

/**
 * Link model builder for a staff member.
 */
public class StaffMemberLinkModelBuilder extends AbstractLinkModelBuilder<StaffMemberPropertiesWSModel> {

    // ----------------------------------------------------------------------
    // constructors
    // ----------------------------------------------------------------------

    @Inject
    public StaffMemberLinkModelBuilder() {
        super(StaffMemberPropertiesWSModel.class);
    }
}