////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 18.12.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.workplace;

import com.forcam.na.ffwebservices.model.DateFormatUtility;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * The request body for update recorded operating state.
 */
public class UpdateWorkplaceRecordedOperatingStateRequestBody {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The operating state id. */
    private String mOperatingStateId;

    /** The start date. */
    private Date mStartDate;

    /** The end date. */
    private Date mEndDate;

    /** The remark. */
    private String mRemark;

    @Override
    public String toString() {
        return ToStringUtility.newToStringBuilder(this)
                .append("operatingStateId", mOperatingStateId)
                .append("startDate", DateFormatUtility.formatLogging(mStartDate))
                .append("endDate", DateFormatUtility.formatLogging(mEndDate))
                .append("remark", mRemark)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof UpdateWorkplaceRecordedOperatingStateRequestBody)) {
            return false;
        }

        UpdateWorkplaceRecordedOperatingStateRequestBody that = (UpdateWorkplaceRecordedOperatingStateRequestBody) o;

        return new EqualsBuilder()
                .append(mOperatingStateId, that.mOperatingStateId)
                .append(mStartDate, that.mStartDate)
                .append(mEndDate, that.mEndDate)
                .append(mRemark, that.mRemark)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(mOperatingStateId)
                .append(mStartDate)
                .append(mEndDate)
                .append(mRemark)
                .toHashCode();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public String getOperatingStateId() {
        return mOperatingStateId;
    }

    public void setOperatingStateId(String operatingStateId) {
        mOperatingStateId = operatingStateId;
    }

    @NotNull
    public Date getStartDate() {
        return mStartDate;
    }

    public void setStartDate(Date startDate) {
        mStartDate = startDate;
    }

    public Date getEndDate() {
        return mEndDate;
    }

    public void setEndDate(Date endDate) {
        mEndDate = endDate;
    }

    public String getRemark() {
        return mRemark;
    }

    public void setRemark(String remark) {
        mRemark = remark;
    }
}