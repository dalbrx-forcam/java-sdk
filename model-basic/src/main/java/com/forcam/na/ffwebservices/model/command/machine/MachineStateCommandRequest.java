////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 20.09.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.command.machine;

import com.forcam.na.ffwebservices.model.command.AbstractCommandRequest;
import com.forcam.na.ffwebservices.model.definition.MachineState;
import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

/**
 * A machine status command model.
 */
public class MachineStateCommandRequest extends AbstractCommandRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The id of the machine. */
    private String mMachineId;

    /** The id of the machine state. */
    private MachineState mMachineStateId;

    /** A list of ids of machine state details. */
    private List<String> mMachineStateDetailIds;

    /** An annotation. */
    private String mAnnotation;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a machine status command model.
     *
     * @param machineId      The machine id.
     * @param machineStateId The machine state id.
     */
    public MachineStateCommandRequest(String machineId, MachineState machineStateId) {
        mMachineId = machineId;
        mMachineStateId = machineStateId;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return ToStringUtility.newToStringBuilder(this)
            .append("machine id", mMachineId)
            .append("machine state id", mMachineStateId)
            .append("machine state detail ids", mMachineStateDetailIds)
            .append("annotation", mAnnotation)
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

    public String getAnnotation() {
        return mAnnotation;
    }

    public void setAnnotation(String annotation) {
        mAnnotation = annotation;
    }

    public List<String> getMachineStateDetailIds() {
        return mMachineStateDetailIds;
    }

    public void setMachineStateDetailIds(List<String> statusDetailIds) {
        mMachineStateDetailIds = statusDetailIds;
    }

    public MachineState getMachineStateId() {
        return mMachineStateId;
    }

    public void setMachineStateId(MachineState machineStateId) {
        mMachineStateId = machineStateId;
    }
}