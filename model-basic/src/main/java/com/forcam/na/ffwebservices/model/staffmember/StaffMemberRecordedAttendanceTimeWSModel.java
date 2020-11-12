////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 04.04.2019.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.staffmember;

import com.forcam.na.ffwebservices.model.AbstractTimestampModel;
import com.forcam.na.ffwebservices.model.TimePeriodWSModel;
import io.swagger.annotations.ApiModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 */
@ApiModel("staffMemberRecordedAttendanceTime")
public class StaffMemberRecordedAttendanceTimeWSModel extends AbstractTimestampModel {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Time period from start date to end date of the activity. */
    private TimePeriodWSModel mTimePeriod;

    /** List of breaks. */
    private List<StaffMemberTimeAttendanceBreakWSModel> mBreaks = new ArrayList<>();

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public TimePeriodWSModel getTimePeriod() {
        return mTimePeriod;
    }

    public void setTimePeriod(TimePeriodWSModel timePeriod) {
        mTimePeriod = timePeriod;
    }

    public List<StaffMemberTimeAttendanceBreakWSModel> getBreaks() {
        return mBreaks;
    }

    public void setBreaks(List<StaffMemberTimeAttendanceBreakWSModel> breaks) {
        mBreaks = breaks;
    }

    @Override
    public Date getPaginationDate() {
        return this
            .getTimePeriod()
            .getStartDate();
    }
}
