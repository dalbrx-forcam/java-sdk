package com.forcam.na.ffwebservices.client.api.operation.operationplanning.request;

import com.forcam.na.ffwebservices.model.operation.OperationAssignmentWSModel;

/**
 * Set operation planning result request parameters.
 * <p>
 * Created: 27.03.2018
 *
 * @author Nadine Uebele nadine.uebele@forcam.com
 */
public class SetOperationPlanningResultRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Operation planning result properties. */
    private OperationAssignmentWSModel mPlanningResult = new OperationAssignmentWSModel();

    /** The operation ID. */
    private String mOperationId;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates new instance.
     *
     * @param operationId The operation ID.
     */
    public SetOperationPlanningResultRequest(String operationId) {
        mOperationId = operationId;
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Provides the operation planing result properties.
     *
     * @return The operation planing result properties WS model.
     */
    public OperationAssignmentWSModel getPlanningResult() {
        return mPlanningResult;
    }

    /**
     * Sets the operation planing result properties.
     *
     * @param planningResult The operation planing result properties WS model.
     */
    public void setPlanningResult(OperationAssignmentWSModel planningResult) {
        mPlanningResult = planningResult;
    }

    /**
     * Provides the operation ID.
     *
     * @return The operation ID.
     */
    public String getOperationId() {
        return mOperationId;
    }

    /**
     * Sets the operation ID.
     *
     * @param operationId The operation ID.
     */
    public void setOperationId(String operationId) {
        mOperationId = operationId;
    }
}
