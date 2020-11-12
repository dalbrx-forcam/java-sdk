////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 02.11.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * Time period with start date, end date and duration.
 */
@ApiModel(value = "timePeriodDefinition")
@JsonPropertyOrder({ "startDate", "endDate", "duration" })
public class TimePeriodWSModel extends AbstractTimestampModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The start date. */
    private Date mStartDate;

    /** The end date. */
    private Date mEndDate;

    /** The duration of the time period. */
    private Long mDuration;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    @ApiModelProperty(value = "Start timestamp of the time period", position = 0)
    public void setStartDate(Date startDate) {
        mStartDate = startDate;
    }

    public Date getStartDate() {
        return mStartDate;
    }

    @ApiModelProperty(value = "End timestamp of the time period", position = 1)
    public void setEndDate(Date endDate) {
        mEndDate = endDate;
    }

    public Date getEndDate() {
        return mEndDate;
    }

    @ApiModelProperty(value = "Duration in msec", position = 2)
    public void setDuration(Long duration) {
        mDuration = duration;
    }

    public Long getDuration() {
        if (mStartDate == null) {
            return mDuration;
        } else if (mEndDate == null) {
            return (System.currentTimeMillis() - mStartDate.getTime());
        } else {
            return mEndDate.getTime() - mStartDate.getTime();
        }
    }

    @Override
    public Date getPaginationDate() {
        return mStartDate;
    }
}