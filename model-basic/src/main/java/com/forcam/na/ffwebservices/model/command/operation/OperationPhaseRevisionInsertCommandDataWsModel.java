////////////////////////////////////////////////////////////////////////////////
//
// Created by abhishekmundewal on 06-Jun-18.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.command.operation;

import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;
import com.forcam.na.ffwebservices.model.DateFormatUtility;
import com.forcam.na.ffwebservices.model.command.AbstractCommandDataWSModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.Date;

/**
 * Operation phase revision insert command data WS model.
 */
@ApiModel(value = "operationPhaseRevisionInsertCommand", parent = AbstractCommandDataWSModel.class)
public class OperationPhaseRevisionInsertCommandDataWsModel extends AbstractCommandDataWSModel {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------

    /** The name as a constant string. */
    public static final String NAME = "OPERATION_PHASE_REVISION_INSERT";

    private static final long serialVersionUID = 5336758226237072733L;

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** A model of the operation phase command. */
    private OperationPhaseCommandDataWsModel mOperationPhaseCommand;

    /** The insertion timestamp. */
    private Date mInsertionTimestamp;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     */
    public OperationPhaseRevisionInsertCommandDataWsModel() {
        super(NAME);
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return ToStringUtility
            .newToStringBuilder(this)
            .appendSuper(super.toString())
            .append("operationPhaseCommand", mOperationPhaseCommand)
            .append("insertionTimestamp", DateFormatUtility.formatLogging(mInsertionTimestamp))
            .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        OperationPhaseRevisionInsertCommandDataWsModel that = (OperationPhaseRevisionInsertCommandDataWsModel) o;

        return new EqualsBuilder()
            .append(mOperationPhaseCommand, that.getOperationPhaseCommand())
            .append(mInsertionTimestamp, that.getInsertionTimestamp())
            .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
            .append(mOperationPhaseCommand)
            .append(mInsertionTimestamp)
            .toHashCode();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public Date getInsertionTimestamp() {
        return mInsertionTimestamp;
    }

    @ApiModelProperty(value = "The timestamp where the operation phase command should be inserted", required = true)
    public void setInsertionTimestamp(Date insertionTimestamp) {
        mInsertionTimestamp = insertionTimestamp;
    }

    public OperationPhaseCommandDataWsModel getOperationPhaseCommand() {
        return mOperationPhaseCommand;
    }

    public void setOperationPhaseCommand(OperationPhaseCommandDataWsModel operationPhaseCommand) {
        mOperationPhaseCommand = operationPhaseCommand;
    }
}
