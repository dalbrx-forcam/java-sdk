////////////////////////////////////////////////////////////////////////////////
//
// Created by abhishekmundewal on 07-Jun-18.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.command.operation;

import com.forcam.na.common.webserviceaccess.util.ToStringUtility;
import com.forcam.na.ffwebservices.model.DateFormatUtility;
import com.forcam.na.ffwebservices.model.command.AbstractCommandDataWSModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.Date;

/**
 * Operation quantity revision insert command data ws model.
 */
@ApiModel(value = "operationQuantityRevisionInsertCommand", parent = AbstractCommandDataWSModel.class)
public class OperationQuantityRevisionInsertCommandDataWsModel extends AbstractCommandDataWSModel {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------
    /** The name as a constant string. */
    public static final String NAME = "OPERATION_QUANTITY_REVISION_INSERT";

    private static final long serialVersionUID = 6173314505168689574L;

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** A model of the machine status command. */
    private OperationQuantityCommandDataWsModel mOperationQuantityCommand;

    /** The insertion timestamp. */
    private Date mInsertionTimestamp;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     */
    public OperationQuantityRevisionInsertCommandDataWsModel() {
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
            .append("operationQuantityCommand", mOperationQuantityCommand)
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

        OperationQuantityRevisionInsertCommandDataWsModel that = (OperationQuantityRevisionInsertCommandDataWsModel) o;

        return new EqualsBuilder()
            .append(mOperationQuantityCommand, that.getOperationQuantityCommand())
            .append(mInsertionTimestamp, that.getInsertionTimestamp())
            .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
            .append(mOperationQuantityCommand)
            .append(mInsertionTimestamp)
            .toHashCode();
    }

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
