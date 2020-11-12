package com.forcam.na.ffwebservices.model.command.operation;

import com.forcam.na.ffwebservices.model.command.AbstractCommandRequest;
import com.forcam.na.ffwebservices.model.definition.OperationPhase;
import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * An operation phase command model.
 */
public class OperationPhaseCommandRequest extends AbstractCommandRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The id of the operation. */
    private String mOperationId;

    /** The id of the workplace. */
    private String mWorkplaceId;

    /** The phase. */
    private OperationPhase mPhase;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates an operation phase command model.
     *
     * @param operationId The operation id.
     * @param workplaceId The workplace id.
     * @param phase The operation phase.
     */
    public OperationPhaseCommandRequest(String operationId, String workplaceId, OperationPhase phase) {
        mOperationId = operationId;
        mWorkplaceId = workplaceId;
        mPhase = phase;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return ToStringUtility.newToStringBuilder(this)
            .append("operationId", mOperationId)
            .append("workplaceId", mWorkplaceId)
            .append("phase", mPhase)
            .toString();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public String getOperationId() {
        return mOperationId;
    }

    public String getWorkplaceId() {
        return mWorkplaceId;
    }

    public OperationPhase getPhase() {
        return mPhase;
    }
}