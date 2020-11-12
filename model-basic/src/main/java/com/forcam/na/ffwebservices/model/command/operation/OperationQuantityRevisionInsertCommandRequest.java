////////////////////////////////////////////////////////////////////////////////
//
// Created by abhishekmundewal on 07-Jun-18.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.command.operation;

import com.forcam.na.ffwebservices.model.DateFormatUtility;
import com.forcam.na.ffwebservices.model.command.AbstractCommandRequest;
import io.swagger.annotations.ApiModelProperty;
import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 *
 */
public class OperationQuantityRevisionInsertCommandRequest extends AbstractCommandRequest {

    /** A model of the machine status command. */
    private OperationQuantityCommandDataWsModel mOperationQuantityCommand;

    /** The insertion timestamp. */
    private Date mInsertionTimestamp;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a operation quantity revision insert command model.
     *
     * @param operationQuantityCommand A model of the operation quantity command.
     * @param insertionTimestamp       The timestamp of the insertion.
     */
    public OperationQuantityRevisionInsertCommandRequest(OperationQuantityCommandDataWsModel operationQuantityCommand, Date insertionTimestamp) {
        mOperationQuantityCommand = operationQuantityCommand;
        mInsertionTimestamp = insertionTimestamp;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return ToStringUtility.newToStringBuilder(this)
                .append("machine status command", mOperationQuantityCommand)
                .append("insertion timestamp", DateFormatUtility.formatLogging(mInsertionTimestamp))
                .toString();
    }
    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public OperationQuantityCommandDataWsModel getOperationQuantityCommand() {
        return mOperationQuantityCommand;
    }

    public void setOperationQuantityCommand(OperationQuantityCommandDataWsModel operationQuantityCommand) {
        mOperationQuantityCommand = operationQuantityCommand;
    }

    @ApiModelProperty(value = "The timestamp where the operation quantity command should be inserted", required = true)
    public Date getInsertionTimestamp() {
        return mInsertionTimestamp;
    }

    public void setInsertionTimestamp(Date insertionTimestamp) {
        mInsertionTimestamp = insertionTimestamp;
    }
}
