package com.forcam.na.ffwebservices.client.api.operation.response;

import com.forcam.na.ffwebservices.client.api.pagination.response.AbstractCollectionResponse;
import com.forcam.na.ffwebservices.client.api.pagination.request.PaginationRequest;
import com.forcam.na.ffwebservices.model.LinkEmbeddedWSModel;
import com.forcam.na.ffwebservices.model.operation.OperationPropertiesWSModel;
import com.forcam.na.ffwebservices.model.operation.UserFieldCollectionPropertiesWSModel;
import com.forcam.na.ffwebservices.model.operation.UserFieldWSModel;

import java.util.List;

/**
 * Collection response for operation user fields.
 * <p>
 * Created: 27.03.2018
 *
 * @author Nadine Uebele nadine.uebele@forcam.com
 */
public class OperationUserFieldCollectionResponse extends AbstractCollectionResponse<UserFieldWSModel> {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The operation user field collection properties WS model. */
    private UserFieldCollectionPropertiesWSModel mProperties = new UserFieldCollectionPropertiesWSModel();

    /** The embedded operation. */
    private LinkEmbeddedWSModel<OperationPropertiesWSModel> mOperation;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     *
     * @param request The request.
     */
    public OperationUserFieldCollectionResponse(PaginationRequest request) {
        super(request);
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Sets the operation user field collection properties.
     *
     * @param properties The operation user field collection properties WS model.
     */
    public void setProperties(UserFieldCollectionPropertiesWSModel properties) {
        mProperties = properties;
    }

    /**
     * Provides the operation user field collection properties.
     *
     * @return The operation user field collection properties WS model.
     */
    public UserFieldCollectionPropertiesWSModel getProperties() {
        return mProperties;
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
    public List<UserFieldWSModel> getElements() {
        return mProperties.getElements();
    }
}
