////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 13.08.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.device.request;

import com.forcam.na.ffwebservices.client.api.pagination.request.CollectionRequest;
import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Request for getting all devices.
 */
public class GetDevicesRequest extends CollectionRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The device name. */
    private String mDeviceName;

    /** The physical quantity that is measured at the device. */
    private String mPhysicalQuantity;

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return ToStringUtility.newToStringBuilder(this)
            .appendSuper(super.toString())
            .append("deviceName", mDeviceName)
            .append("physicalQuantity", mPhysicalQuantity)
            .toString();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Provides the device name.
     *
     * @return The device name.
     */
    public String getDeviceName() {
        return mDeviceName;
    }

    /**
     * Sets thr device name.
     *
     * @param deviceName The device name.
     */
    public void setDeviceName(String deviceName) {
        mDeviceName = deviceName;
    }

    /**
     * Provides the physical quantity.
     *
     * @return The physical quantity.
     */
    public String getPhysicalQuantity() {
        return mPhysicalQuantity;
    }

    /**
     * Sets the physical quantity.
     *
     * @param physicalQuantity The physical quantity.
     */
    public void setPhysicalQuantity(String physicalQuantity) {
        mPhysicalQuantity = physicalQuantity;
    }
}