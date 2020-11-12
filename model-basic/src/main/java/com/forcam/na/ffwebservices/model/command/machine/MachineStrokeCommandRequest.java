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
 * A machine stroke command model.
 */
public class MachineStrokeCommandRequest extends AbstractCommandRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Machine id. */
    private String mMachineId;
    /** Counter number. */
    private short mCounterNumber;
    /** Strokes. */
    private int mStrokes;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a machine stroke command model.
     *
     * @param machineId     The machine id.
     * @param counterNumber The counter number.
     * @param strokes       The strokes.
     */
    public MachineStrokeCommandRequest(String machineId, short counterNumber, int strokes) {
        mMachineId = machineId;
        mCounterNumber = counterNumber;
        mStrokes = strokes;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return ToStringUtility.newToStringBuilder(this)
            .append("machine id", mMachineId)
            .append("counter number", mCounterNumber)
            .append("strokes", mStrokes)
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

    public short getCounterNumber() {
        return mCounterNumber;
    }

    public void setCounterNumber(short counterNumber) {
        mCounterNumber = counterNumber;
    }

    public int getStrokes() {
        return mStrokes;
    }

    public void setStrokes(int strokes) {
        mStrokes = strokes;
    }
}