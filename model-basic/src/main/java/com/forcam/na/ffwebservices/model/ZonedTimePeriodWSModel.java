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

import java.time.ZonedDateTime;
import java.util.Date;

/**
 * Time period with start date, end date and duration.
 */
@ApiModel(value = "zonedTimePeriodDefinition")
@JsonPropertyOrder({ "startDate", "endDate", "duration" })
public class ZonedTimePeriodWSModel extends AbstractTimestampModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The start date. */
    private ZonedDateTime mStartDate;

    /** The end date. */
    private ZonedDateTime mEndDate;

    /** The duration of the time period. */
    private Long mDuration;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    @ApiModelProperty(value = "Start timestamp of the time period", position = 0)
    public void setStartDate(ZonedDateTime startDate) {
        mStartDate = startDate;
    }

    public ZonedDateTime getStartDate() {
        return mStartDate;
    }

    @ApiModelProperty(value = "End timestamp of the time period", position = 1)
    public void setEndDate(ZonedDateTime endDate) {
        mEndDate = endDate;
    }

    public ZonedDateTime getEndDate() {
        return mEndDate;
    }

    @ApiModelProperty(value = "Duration in msec", position = 2)
    public void setDuration(Long duration) {
        mDuration = duration;
    }

    public Long getDuration() {
        if (mStartDate == null || mEndDate == null) {
            return mDuration;
        } else {
            return mEndDate
                       .toInstant()
                       .toEpochMilli() - mStartDate
                       .toInstant()
                       .toEpochMilli();
        }
    }

    @Override
    public Date getPaginationDate() {
        return Date.from(mStartDate.toInstant());
    }
}