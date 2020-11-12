package com.forcam.na.ffwebservices.client.api.operation.request;

import com.forcam.na.ffwebservices.client.api.pagination.request.CollectionRequest;
import com.forcam.na.ffwebservices.model.operation.OperationUserFieldEmbed;
import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Request parameters for getting operation user fields.
 *
 * Created: 29.03.2018
 *
 * @author Nadine Uebele nadine.uebele@forcam.com
 */
public class GetOperationUserFieldsRequest extends CollectionRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The operation ID. */
    private String mOperationId;

    /** Determines what shall be embedded. */
    private OperationUserFieldEmbed mEmbed = new OperationUserFieldEmbed();

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates new instance.
     *
     * @param operationId The operation ID.
     */
    public GetOperationUserFieldsRequest(String operationId) {
        mOperationId = operationId;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    public OperationUserFieldEmbed embed() {
        return mEmbed;
    }

    public void embed(OperationUserFieldEmbed embed) {
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
