////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 18.07.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.operation.response;

import com.forcam.na.ffwebservices.client.api.pagination.response.AbstractCollectionResponse;
import com.forcam.na.ffwebservices.client.api.pagination.request.PaginationRequest;
import com.forcam.na.ffwebservices.model.operatingstate.OperationPhaseCollectionPropertiesWSModel;
import com.forcam.na.ffwebservices.model.operatingstate.OperationPhaseRecordPropertiesWSModel;

import java.util.List;

/**
 * Operation recorded operation phases response.
 */
public class OperationRecordedOperationPhasesResponse extends AbstractCollectionResponse<OperationPhaseRecordPropertiesWSModel> {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The operation phase collection properties. */
    private OperationPhaseCollectionPropertiesWSModel mProperties = new OperationPhaseCollectionPropertiesWSModel();

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     *
     * @param request The request.
     */
    public OperationRecordedOperationPhasesResponse(PaginationRequest request) {
        super(request);
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Get the operation phase collection properties.
     *
     * @return Operation phase collection properties model.
     */
    public OperationPhaseCollectionPropertiesWSModel getProperties() {
        return mProperties;
    }

    /**
     * Set the operation phase collection properties.
     *
     * @param properties Operation phase collection properties.
     */
    public void setProperties(OperationPhaseCollectionPropertiesWSModel properties) {
        mProperties = properties;
    }

    @Override
    public List<OperationPhaseRecordPropertiesWSModel> getElements() {
        return mProperties.getElements();
    }

}