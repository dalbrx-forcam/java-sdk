package com.forcam.na.ffwebservices.client.api.workplace.response;

import com.forcam.na.ffwebservices.client.api.pagination.request.PaginationRequest;
import com.forcam.na.ffwebservices.client.api.pagination.response.AbstractCollectionResponse;
import com.forcam.na.ffwebservices.model.operation.UserFieldCollectionPropertiesWSModel;
import com.forcam.na.ffwebservices.model.operation.UserFieldWSModel;

import java.util.List;

/**
 * Collection response for workplace user fields.
 */
public class WorkplaceUserFieldCollectionResponse extends AbstractCollectionResponse<UserFieldWSModel> {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The workplace user field collection properties WS model. */
    private UserFieldCollectionPropertiesWSModel mProperties = new UserFieldCollectionPropertiesWSModel();

    /** The workplace id. */
    private String mWorkplaceId;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     *
     * @param request The request.
     */
    public WorkplaceUserFieldCollectionResponse(PaginationRequest request) {
        super(request);
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Sets the workplace user field collection properties.
     *
     * @param properties The workplace user field collection properties WS model.
     */
    public void setProperties(UserFieldCollectionPropertiesWSModel properties) {
        mProperties = properties;
    }

    /**
     * Provides the workplace user field collection properties.
     *
     * @return The workplace user field collection properties WS model.
     */
    public UserFieldCollectionPropertiesWSModel getProperties() {
        return mProperties;
    }

    @Override
    public List<UserFieldWSModel> getElements() {
        return mProperties.getElements();
    }

    public String getWorkplaceId() {
        return mWorkplaceId;
    }

    /**
     * Sets the workplace id.
     *
     * @param workplaceId The workplace id.
     */
    public void setWorkplaceId(String workplaceId) {
        mWorkplaceId = workplaceId;
    }
}
