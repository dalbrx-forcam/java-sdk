////////////////////////////////////////////////////////////////////////////////
//
// Created by AMundewal on 06.09.2019.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
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
 * Operation production status revision insert data WS model.
 */
@ApiModel(value = "operationProductionStateRevisionInsertCommand", parent = AbstractCommandDataWSModel.class)
public class OperationProductionStateRevisionInsertCommandDataWsModel extends AbstractCommandDataWSModel {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------
    /**
     * The name as a constant string.
     */
    public static final String NAME = "OPERATION_PRODUCTION_STATE_REVISION_INSERT";
    /**
     * Serial version uuid.
     */
    private static final long serialVersionUID = 6177496859985200830L;

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /**
     * A model of the machine status command.
     */
    private OperationProductionStateCommandDataWsModel mOperationProductionStateCommand;

    /**
     * The insertion timestamp.
     */
    private Date mInsertionTimestamp;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     */
    public OperationProductionStateRevisionInsertCommandDataWsModel() {
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
            .append("operationProductionStateCommand", mOperationProductionStateCommand)
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

        OperationProductionStateRevisionInsertCommandDataWsModel that = (OperationProductionStateRevisionInsertCommandDataWsModel) o;

        return new EqualsBuilder()
            .append(mOperationProductionStateCommand, that.getOperationProductionStateCommandDataWsModel())
            .append(mInsertionTimestamp, that.getInsertionTimestamp())
            .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
            .append(mOperationProductionStateCommand)
            .append(mInsertionTimestamp)
            .toHashCode();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public OperationProductionStateCommandDataWsModel getOperationProductionStateCommandDataWsModel() {
        return mOperationProductionStateCommand;
    }

    public void setOperationProductionStateCommandDataWsModel(OperationProductionStateCommandDataWsModel productionStateCommandDataWsModel) {
        mOperationProductionStateCommand = productionStateCommandDataWsModel;
    }

    @ApiModelProperty(value = "The timestamp where the operation production state command should be inserted", required = true)
    public Date getInsertionTimestamp() {
        return mInsertionTimestamp;
    }

    public void setInsertionTimestamp(Date insertionTimestamp) {
        mInsertionTimestamp = insertionTimestamp;
    }

}
