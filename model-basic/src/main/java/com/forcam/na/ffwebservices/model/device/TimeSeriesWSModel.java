////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 13.08.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.device;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * Time series model.
 */
@JsonPropertyOrder({ "timestamp", "value" })
public class TimeSeriesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The time of recording or measurement. */
    private Date mTimestamp;

    /** The corresponding value. */
    private String mValue;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Sets the timestamp.
     *
     * @param timestamp The timestamp.
     */
    @ApiModelProperty(value = "The time of recording or measurement", position = 0)
    public void setTimestamp(Date timestamp) {
        mTimestamp = timestamp;
    }

    /**
     * Provides the timestamp.
     *
     * @return The timestamp.
     */
    public Date getTimestamp() {
        return mTimestamp;
    }

    /**
     * Sets the corresponding value.
     *
     * @param value The corresponding value.
     */
    @ApiModelProperty(value = "The corresponding value", position = 1)
    public void setValue(String value) {
        mValue = value;
    }

    /**
     * Provides the corresponding value.
     *
     * @return The corresponding value.
     */
    public String getValue() {
        return mValue;
    }
}