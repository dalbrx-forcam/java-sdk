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
 * A machine count command model.
 */
public class MachineCountCommandRequest extends AbstractCommandRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Machine id. */
    private String mMachineId;

    /** Counter number. */
    private long mCounterNumber;

    /** Count. */
    private long mCount;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a machine count command model.
     *
     * @param machineId     The machine id.
     * @param counterNumber The counter number.
     * @param count         The count.
     */
    public MachineCountCommandRequest(String machineId, long counterNumber, long count) {
        mMachineId = machineId;
        mCounterNumber = counterNumber;
        mCount = count;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return ToStringUtility.newToStringBuilder(this)
            .append("machine id", mMachineId)
            .append("counter number", mCounterNumber)
            .append("count", mCount)
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

    public long getCount() {
        return mCount;
    }

    public void setCount(long count) {
        mCount = count;
    }

    public long getCounterNumber() {
        return mCounterNumber;
    }

    public void setCounterNumber(long counterNumber) {
        mCounterNumber = counterNumber;
    }
}