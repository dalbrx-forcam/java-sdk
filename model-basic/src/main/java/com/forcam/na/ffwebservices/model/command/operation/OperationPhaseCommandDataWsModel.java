package com.forcam.na.ffwebservices.model.command.operation;

import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;
import com.forcam.na.ffwebservices.model.command.AbstractCommandDataWSModel;
import com.forcam.na.ffwebservices.model.definition.OperationPhase;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Created: 22.02.2017
 *
 * @author David Albrecht
 */
@ApiModel(value = "operationPhaseCommand", parent = AbstractCommandDataWSModel.class)
public class OperationPhaseCommandDataWsModel extends AbstractCommandDataWSModel {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------

    /** The name as a constant string. */
    public static final String NAME = "OPERATION_PHASE";

    private static final long serialVersionUID = -2227168825121786125L;

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The id of the operation. */
    private String mOperationId;

    /** The id of the workplace. */
    private String mWorkplaceId;

    /** The id of the personnel. */
    private String mStaffMemberId;

    /** The id of the operation phase. */
    private OperationPhase mOperationPhaseId;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     */
    public OperationPhaseCommandDataWsModel() {
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
            .append("operationPhaseId", mOperationPhaseId)
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

        OperationPhaseCommandDataWsModel that = (OperationPhaseCommandDataWsModel) o;

        return new EqualsBuilder()
            .append(mOperationId, that.mOperationId)
            .append(mWorkplaceId, that.mWorkplaceId)
            .append(mStaffMemberId, that.mStaffMemberId)
            .append(mOperationPhaseId, that.mOperationPhaseId)
            .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
            .append(mOperationId)
            .append(mWorkplaceId)
            .append(mStaffMemberId)
            .append(mOperationPhaseId)
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

    public OperationPhase getOperationPhaseId() {
        return mOperationPhaseId;
    }

    @ApiModelProperty(value = "The operation phase", required = true)
    public void setOperationPhaseId(OperationPhase operationPhaseId) {
        mOperationPhaseId = operationPhaseId;
    }

    public void setStaffMemberId(String staffMemberId) {
        mStaffMemberId = staffMemberId;
    }

    public String getStaffMemberId() {
        return mStaffMemberId;
    }
}