////////////////////////////////////////////////////////////////////////////////
//
// Created by abhishekmundewal on 06-Jun-18.
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
 * Operation phase revision insert command request.
 */
public class OperationPhaseRevisionInsertCommandRequest extends AbstractCommandRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** A model of the machine status command. */
    private OperationPhaseCommandDataWsModel mOperationPhaseCommandDataWsModel;

    /** The insertion timestamp. */
    private Date mInsertionTimestamp;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a operation phase revision insert command model.
     *
     * @param operationPhaseCommand A model of the operation phase command.
     * @param insertionTimestamp    The timestamp of the insertion.
     */
    public OperationPhaseRevisionInsertCommandRequest(OperationPhaseCommandDataWsModel operationPhaseCommand, Date insertionTimestamp) {
        mOperationPhaseCommandDataWsModel = operationPhaseCommand;
        mInsertionTimestamp = insertionTimestamp;
    }
    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return ToStringUtility.newToStringBuilder(this)
                .append("operation phase command", mOperationPhaseCommandDataWsModel)
                .append("insertion timestamp", DateFormatUtility.formatLogging(mInsertionTimestamp))
                .toString();
    }
    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public OperationPhaseCommandDataWsModel getOperationPhaseCommandDataWsModel() {
        return mOperationPhaseCommandDataWsModel;
    }

    public void setOperationPhaseCommandDataWsModel(OperationPhaseCommandDataWsModel operationPhaseCommandDataWsModel) {
        mOperationPhaseCommandDataWsModel = operationPhaseCommandDataWsModel;
    }

    @ApiModelProperty(value = "The timestamp where the operation phase command should be inserted", required = true)
    public Date getInsertionTimestamp() {
        return mInsertionTimestamp;
    }

    public void setInsertionTimestamp(Date insertionTimestamp) {
        mInsertionTimestamp = insertionTimestamp;
    }
}
