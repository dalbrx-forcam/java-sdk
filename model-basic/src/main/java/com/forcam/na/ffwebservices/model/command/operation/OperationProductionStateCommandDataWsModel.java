////////////////////////////////////////////////////////////////////////////////
//
// Created by AMundewal on 06.09.2019.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.command.operation;

import com.forcam.na.common.webserviceaccess.util.ToStringUtility;
import com.forcam.na.ffwebservices.model.command.AbstractCommandDataWSModel;
import com.forcam.na.ffwebservices.model.definition.OperationProductionState;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.List;

/**
 * Data Wor model for operation production status command.
 */
@ApiModel(value = "operationProductionStateCommand", parent = AbstractCommandDataWSModel.class)
public class OperationProductionStateCommandDataWsModel extends AbstractCommandDataWSModel {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------

    /**
     * Serial version uuid.
     */
    private static final long serialVersionUID = -844329181850153375L;
    /**
     * The name as a constant string.
     */
    public static final String NAME = "OPERATION_PRODUCTION_STATE";

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /**
     * The id of the operation.
     */
    private String mOperationId;

    /**
     * The id of the workplace.
     */
    private String mWorkplaceId;

    /** Person id. */
    private String mStaffMemberId;

    /**
     * The id of the machine state.
     */
    private OperationProductionState mOperationProductionStateId;

    /**
     * A list of ids of machine state details.
     */
    private List<String> mOperationProductionStateDetailIds;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     */
    public OperationProductionStateCommandDataWsModel() {
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
            .append("operationId", mOperationId)
            .append("workplaceId", mWorkplaceId)
            .append("staffMemberId", mStaffMemberId)
            .append("operationProductionStateId", mOperationProductionStateId)
            .append("operationProductionStateDetailIds", mOperationProductionStateDetailIds)
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

        OperationProductionStateCommandDataWsModel that = (OperationProductionStateCommandDataWsModel) o;

        return new EqualsBuilder()
            .append(mOperationId, that.mOperationId)
            .append(mWorkplaceId, that.mWorkplaceId)
            .append(mStaffMemberId, that.mStaffMemberId)
            .append(mOperationProductionStateId, that.mOperationProductionStateId)
            .append(mOperationProductionStateDetailIds, that.mOperationProductionStateDetailIds)
            .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
            .append(mOperationId)
            .append(mWorkplaceId)
            .append(mStaffMemberId)
            .append(mOperationProductionStateId)
            .append(mOperationProductionStateDetailIds)
            .toHashCode();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public String getOperationId() {
        return mOperationId;
    }

    @ApiModelProperty(value = "UUID of the operation", required = true)
    public void setOperationId(String operationId) {
        mOperationId = operationId;
    }

    public String getWorkplaceId() {
        return mWorkplaceId;
    }

    @ApiModelProperty(value = "UUID of the workplace. The target workplace is used if no workplace is provided.", required = false)
    public void setWorkplaceId(String workplaceId) {
        mWorkplaceId = workplaceId;
    }

    public OperationProductionState getOperationProductionStateId() {
        return mOperationProductionStateId;
    }

    @ApiModelProperty(value = "UUID of the operation production status.", required = true)
    public void setOperationProductionStateId(OperationProductionState operationProductionStateId) {
        mOperationProductionStateId = operationProductionStateId;
    }

    @ApiModelProperty(value = "UUID of the operation production state detail ids.", required = true)
    public void setOperationProductionStateDetailIds(List<String> operationProductionStateDetailIds) {
        mOperationProductionStateDetailIds = operationProductionStateDetailIds;
    }

    public List<String> getOperationProductionStateDetailIds() {
        return mOperationProductionStateDetailIds;
    }

    public String getStaffMemberId() {
        return mStaffMemberId;
    }

    @ApiModelProperty(value = "UUID of the staff member", required = false)
    public void setStaffMemberId(String staffMemberId) {
        mStaffMemberId = staffMemberId;
    }
}
