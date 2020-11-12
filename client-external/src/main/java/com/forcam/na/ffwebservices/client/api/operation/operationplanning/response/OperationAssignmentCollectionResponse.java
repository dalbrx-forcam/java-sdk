////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 27.11.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.operation.operationplanning.response;

import com.forcam.na.ffwebservices.client.api.pagination.response.CollectionResponse;
import com.forcam.na.ffwebservices.client.api.pagination.request.PaginationRequest;
import com.forcam.na.ffwebservices.model.AbstractResponse;
import com.forcam.na.ffwebservices.model.operation.OperationAssignmentCollectionPropertiesWSModel;

/**
 * Collection response of operation assignments.
 */
public class OperationAssignmentCollectionResponse<E extends AbstractResponse> extends CollectionResponse<E> {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The operation planning result collection properties. */
    private OperationAssignmentCollectionPropertiesWSModel mProperties = new OperationAssignmentCollectionPropertiesWSModel();

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     *
     * @param request The request.
     */
    public OperationAssignmentCollectionResponse(PaginationRequest request) {
        super(request);
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Provides the operation planning result collection properties.
     *
     * @return The operation planning result collection properties.
     */
    public OperationAssignmentCollectionPropertiesWSModel getProperties() {
        return mProperties;
    }

    /**
     * Sets the operation planning result collection properties.
     *
     * @param properties The operation planning result collection properties.
     */
    public void setProperties(OperationAssignmentCollectionPropertiesWSModel properties) {
        mProperties = properties;
    }
}