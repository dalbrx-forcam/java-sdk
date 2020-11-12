package com.forcam.na.ffwebservices.client.api.operation.response;

import com.forcam.na.ffwebservices.client.api.pagination.response.AbstractCollectionResponse;
import com.forcam.na.ffwebservices.client.api.pagination.request.PaginationRequest;
import com.forcam.na.ffwebservices.model.LinkEmbeddedWSModel;
import com.forcam.na.ffwebservices.model.operation.OperationComponentCollectionPropertiesWSModel;
import com.forcam.na.ffwebservices.model.operation.OperationComponentWSModel;
import com.forcam.na.ffwebservices.model.operation.OperationPropertiesWSModel;

import java.util.List;

/**
 * Operation component collection response.
 * <p>
 * Created: 04.04.2018
 *
 * @author Nadine Uebele nadine.uebele@forcam.com
 */
public class OperationComponentCollectionResponse extends AbstractCollectionResponse<OperationComponentWSModel> {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The operation component collection properties WS model. */
    private OperationComponentCollectionPropertiesWSModel mProperties = new OperationComponentCollectionPropertiesWSModel();

    /** Linked or embedded operation. */
    private LinkEmbeddedWSModel<OperationPropertiesWSModel> mOperation;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     *
     * @param request The request.
     */
    public OperationComponentCollectionResponse(PaginationRequest request) {
        super(request);
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Provides the operation component collection properties.
     *
     * @return The operation component collection properties WS model.
     */
    public OperationComponentCollectionPropertiesWSModel getProperties() {
        return mProperties;
    }

    /**
     * Sets the operation component collection properties.
     *
     * @param properties The operation component collection properties WS model.
     */
    public void setProperties(OperationComponentCollectionPropertiesWSModel properties) {
        mProperties = properties;
    }

    /**
     * Provides the linked or embedded operation properties WS model.
     *
     * @return The linked or embedded operation properties WS model.
     */
    public LinkEmbeddedWSModel<OperationPropertiesWSModel> getOperation() {
        return mOperation;
    }

    /**
     * Sets the linked or embedded operation properties WS model.
     *
     * @param operation The linked or embedded operation properties WS model.
     */
    public void setOperation(LinkEmbeddedWSModel<OperationPropertiesWSModel> operation) {
        mOperation = operation;
    }

    @Override
    public List<OperationComponentWSModel> getElements() {
        return mProperties.getElements();
    }
}
