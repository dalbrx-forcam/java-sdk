package com.forcam.na.ffwebservices.client.api.operation.request;

import com.forcam.na.ffwebservices.client.api.pagination.request.CollectionRequest;
import com.forcam.na.ffwebservices.model.operation.OperationComponentsEmbed;
import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Request parameter for getting operation components.
 * <p>
 * Created: 04.04.2018
 *
 * @author Nadine Uebele nadine.uebele@forcam.com
 */
public class GetOperationComponentsRequest extends CollectionRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The operation ID. */
    private String mOperationId;

    /** Determines what shall be embedded. */
    private OperationComponentsEmbed mEmbed = new OperationComponentsEmbed();

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance with an operation ID.
     *
     * @param operationId The operation ID.
     */
    public GetOperationComponentsRequest(String operationId) {
        mOperationId = operationId;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    public OperationComponentsEmbed embed() {
        return mEmbed;
    }

    public void embed(OperationComponentsEmbed embed) {
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