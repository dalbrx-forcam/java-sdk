////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 04.04.2019.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.staffmember;

import com.forcam.na.ffwebservices.model.TimePeriodWSModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;

/**
 *
 */
@ApiModel("staffMemberTimeAttendanceBreak")
public class StaffMemberTimeAttendanceBreakWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private TimePeriodWSModel mTimePeriod;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------


    public TimePeriodWSModel getTimePeriod() {
        return mTimePeriod;
    }

    public void setTimePeriod(TimePeriodWSModel timePeriod) {
        mTimePeriod = timePeriod;
    }

}
