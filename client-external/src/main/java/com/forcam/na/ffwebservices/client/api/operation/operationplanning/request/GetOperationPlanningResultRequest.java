package com.forcam.na.ffwebservices.client.api.operation.operationplanning.request;

import com.forcam.na.ffwebservices.model.operation.OperationPlanningResultEmbed;
import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Request model for getting operation planning result.
 * <p>
 * Created: 10.04.2018
 *
 * @author Nadine Uebele nadine.uebele@forcam.com
 */
public class GetOperationPlanningResultRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The operation ID. */
    private String mOperationId;

    /** Determines what shall be embedded. */
    private OperationPlanningResultEmbed mEmbed = new OperationPlanningResultEmbed();

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new {@link GetOperationPlanningResultRequest} object with an operation ID.
     *
     * @param operationId The operation ID.
     */
    public GetOperationPlanningResultRequest(String operationId) {
        mOperationId = operationId;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    /**
     * Determines what shall be embedded.
     *
     * @return Operation planning result embed model.
     */
    public OperationPlanningResultEmbed embed() {
        return mEmbed;
    }

    /**
     * Sets what shall be embedded.
     *
     * @param embed Operation planning result embed model.
     */
    public void embed(OperationPlanningResultEmbed embed) {
        mEmbed = embed;
    }

    @Override
    public String toString() {
        return ToStringUtility.newToStringBuilder(this).append("operationId", mOperationId).append("embed", mEmbed).toString();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

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