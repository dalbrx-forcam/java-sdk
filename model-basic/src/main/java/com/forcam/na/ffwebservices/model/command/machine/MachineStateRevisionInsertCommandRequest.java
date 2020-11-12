////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 20.09.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.command.machine;

import com.forcam.na.ffwebservices.model.DateFormatUtility;
import com.forcam.na.ffwebservices.model.command.AbstractCommandRequest;
import io.swagger.annotations.ApiModelProperty;
import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * A machine status revision insert command model.
 */
public class MachineStateRevisionInsertCommandRequest extends AbstractCommandRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** A model of the machine status command. */
    private MachineStateCommandDataWSModel mMachineStatusCommand;

    /** The insertion timestamp. */
    private Date mInsertionTimestamp;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a machine status revision insert command model.
     *
     * @param machineStatusCommand A model of the machine status command.
     * @param insertionTimestamp   The timestamp of the insertion.
     */
    public MachineStateRevisionInsertCommandRequest(MachineStateCommandDataWSModel machineStatusCommand, Date insertionTimestamp) {
        mMachineStatusCommand = machineStatusCommand;
        mInsertionTimestamp = insertionTimestamp;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return ToStringUtility.newToStringBuilder(this)
                .append("machine status command", mMachineStatusCommand)
                .append("insertion timestamp", DateFormatUtility.formatLogging(mInsertionTimestamp))
                .toString();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public Date getInsertionTimestamp() {
        return mInsertionTimestamp;
    }

    @ApiModelProperty(value = "The timestamp where the machine status command should be inserted", required = true)
    public void setInsertionTimestamp(Date insertionTimestamp) {
        mInsertionTimestamp = insertionTimestamp;
    }

    public MachineStateCommandDataWSModel getMachineStatusCommand() {
        return mMachineStatusCommand;
    }

    public void setMachineStatusCommand(MachineStateCommandDataWSModel machineStatusCommand) {
        mMachineStatusCommand = machineStatusCommand;
    }
}