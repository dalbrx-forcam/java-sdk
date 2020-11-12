////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 20.09.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.command.machine;

import com.forcam.na.ffwebservices.model.command.AbstractCommandRequest;
import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * A machine quantity command model.
 */
public class MachineQuantityCommandRequest extends AbstractCommandRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Machine id. */
    private String mMachineId;
    /** Quantity amount. */
    private double mQuantity;
    /** UUID for reason id. */
    private String mQualityDetailId;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a machine Count command model.
     *
     * @param machineId       The machine id.
     * @param quantity        the quantity
     * @param qualityDetailId The quality detail ID
     */
    public MachineQuantityCommandRequest(String machineId, double quantity, String qualityDetailId) {
        mMachineId = machineId;
        mQuantity = quantity;
        mQualityDetailId = qualityDetailId;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return ToStringUtility.newToStringBuilder(this)
            .append("machine id", mMachineId)
            .append("quantity", mQuantity)
            .append("quality detail id", mQualityDetailId)
            .toString();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public String getMachineId() {
        return mMachineId;
    }

    public void setMachineId(String machineId) {
        mMachineId = machineId;
    }

    public double getQuantity() {
        return mQuantity;
    }

    public void setQuantity(double quantityAmount) {
        mQuantity = quantityAmount;
    }

    public String getQualityDetailId() {
        return mQualityDetailId;
    }

    public void setQualityDetailId(String mQualityDetailId) {
        mQualityDetailId = mQualityDetailId;
    }
}