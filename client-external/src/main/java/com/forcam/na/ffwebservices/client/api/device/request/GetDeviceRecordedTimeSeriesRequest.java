////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 13.08.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.device.request;

import com.forcam.na.ffwebservices.client.api.pagination.request.CollectionTimestampRequest;
import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * Request parameter for getting recorded time series of a device.
 */
public class GetDeviceRecordedTimeSeriesRequest extends CollectionTimestampRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The device ID. */
    private String mDevicesId;

    /** The start date. */
    private Date mStartDate;

    /** The end date. */
    private Date mEndDate;

    /** The tag. */
    private String mTag;

    /** The material number. */
    private String mMaterialNumber;

    /** The production order number. */
    private String mProductionOrderNumber;

    /** The operation number. */
    private String mOperationNumber;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates new instance with device ID.
     *
     * @param devicesId The device ID.
     */
    public GetDeviceRecordedTimeSeriesRequest(String devicesId) {
        mDevicesId = devicesId;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return ToStringUtility.newToStringBuilder(this)
            .appendSuper(super.toString())
            .append("devicesId", mDevicesId)
            .append("startDate", mStartDate)
            .append("endDate", mEndDate)
            .append("tag", mTag)
            .append("materialNumber", mMaterialNumber)
            .append("productionOrderNumber", mProductionOrderNumber)
            .append("operationNumber", mOperationNumber)
            .toString();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Provides the device ID.
     *
     * @return The device ID.
     */
    public String getDevicesId() {
        return mDevicesId;
    }

    /**
     * Sets the device ID.
     *
     * @param devicesId The device ID.
     */
    public void setDevicesId(String devicesId) {
        mDevicesId = devicesId;
    }

    /**
     * Provides the start date.
     *
     * @return The start date.
     */
    public Date getStartDate() {
        return mStartDate;
    }

    /**
     * Sets the start date.
     *
     * @param startDate The start date.
     */
    public void setStartDate(Date startDate) {
        mStartDate = startDate;
    }

    /**
     * Provides the end date.
     *
     * @return The end date.
     */
    public Date getEndDate() {
        return mEndDate;
    }

    /**
     * Sets the end date.
     *
     * @param endDate The end date.
     */
    public void setEndDate(Date endDate) {
        mEndDate = endDate;
    }

    /**
     * Provides the tag.
     *
     * @return The tag.
     */
    public String getTag() {
        return mTag;
    }

    /**
     * Sets the tag.
     *
     * @param tag The tag.
     */
    public void setTag(String tag) {
        mTag = tag;
    }

    /**
     * Provides the material number.
     *
     * @return The material number.
     */
    public String getMaterialNumber() {
        return mMaterialNumber;
    }

    /**
     * Sets the material number.
     *
     * @param materialNumber The material number.
     */
    public void setMaterialNumber(String materialNumber) {
        mMaterialNumber = materialNumber;
    }

    /**
     * Provides the production order number.
     *
     * @return The production order number.
     */
    public String getProductionOrderNumber() {
        return mProductionOrderNumber;
    }

    /**
     * Sets the production order number.
     *
     * @param productionOrderNumber The production order number.
     */
    public void setProductionOrderNumber(String productionOrderNumber) {
        mProductionOrderNumber = productionOrderNumber;
    }

    /**
     * Provides the operation number.
     *
     * @return The operation number.
     */
    public String getOperationNumber() {
        return mOperationNumber;
    }

    /**
     * Sets the operation number.
     *
     * @param operationNumber The operation number.
     */
    public void setOperationNumber(String operationNumber) {
        mOperationNumber = operationNumber;
    }
}