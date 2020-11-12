////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 20.11.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.shift;

import com.forcam.na.ffwebservices.model.ZonedTimePeriodWSModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDate;
import java.util.List;

/**
 * The shift ws model.
 */
@ApiModel(value = "shift")
public class ShiftWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Shift time period. */
    private ZonedTimePeriodWSModel mTimePeriod = new ZonedTimePeriodWSModel();

    /** List of breaks. */
    private List<ShiftBreakWSModel> mBreaks;

    /** Associated day. */
    private LocalDate mAssociatedDay;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public LocalDate getAssociatedDay() {
        return mAssociatedDay;
    }

    @ApiModelProperty(value = "The associated shift day", position = 1)
    public void setAssociatedDay(LocalDate associatedDay) {
        mAssociatedDay = associatedDay;
    }

    public ZonedTimePeriodWSModel getTimePeriod() {
        return mTimePeriod;
    }

    @ApiModelProperty(value = "Time period of the shift", notes = "Duration of the shift does not include break times", required = true, position = 2)
    public void setTimePeriod(ZonedTimePeriodWSModel timePeriod) {
        mTimePeriod = timePeriod;
    }

    @ApiModelProperty(value = "Array of shift breaks", position = 5)
    public void setBreaks(List<ShiftBreakWSModel> breaks) {
        mBreaks = breaks;
    }

    public List<ShiftBreakWSModel> getBreaks() {
        return mBreaks;
    }

}
