////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 24.11.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.tool;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * The life time model.
 */
@ApiModel(value = "lifeTime")
@JsonPropertyOrder({ "current", "warningLimit", "maximum" })
public class LifeTime {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Current life time */
    private long mCurrent;

    /** The life time warningLimit threshold. */
    private long mWarningLimit;

    /** The life time max threshold. */
    private long mMaximum;

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return ToStringUtility
            .newToStringBuilder(this)
            .append("current", mCurrent)
            .append("warning limit", mWarningLimit)
            .append("max", mMaximum)
            .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof LifeTime)) {
            return false;
        }

        LifeTime lifeTime = (LifeTime) o;

        return new EqualsBuilder()
            .append(getCurrent(), lifeTime.getCurrent())
            .append(getWarningLimit(), lifeTime.getWarningLimit())
            .append(getMaximum(), lifeTime.getMaximum())
            .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
            .append(getCurrent())
            .append(getWarningLimit())
            .append(getMaximum())
            .toHashCode();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    @ApiModelProperty(value = "The current tool life in msec", position = 2)
    public void setCurrent(long current) {
        mCurrent = current;
    }

    public long getCurrent() {
        return mCurrent;
    }

    @ApiModelProperty(value = "Warning limit for tool life in msec", position = 3)
    public void setWarningLimit(long warningLimit) {
        mWarningLimit = warningLimit;
    }

    public long getWarningLimit() {
        return mWarningLimit;
    }

    @ApiModelProperty(value = "The maximum tool life in msec", position = 4)
    public void setMaximum(long maximum) {
        mMaximum = maximum;
    }

    public long getMaximum() {
        return mMaximum;
    }
}