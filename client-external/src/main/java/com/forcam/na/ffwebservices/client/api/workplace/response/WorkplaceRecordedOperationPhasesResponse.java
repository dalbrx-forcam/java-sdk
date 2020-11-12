////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 08.08.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.workplace.response;

import com.forcam.na.ffwebservices.client.api.pagination.response.AbstractCollectionResponse;
import com.forcam.na.ffwebservices.client.api.pagination.request.PaginationRequest;
import com.forcam.na.ffwebservices.model.operatingstate.OperationPhaseRecordPropertiesWSModel;
import com.forcam.na.ffwebservices.model.operatingstate.WpOperationPhaseCollectionPropertiesWSModel;

import java.util.List;

/**
 * Response model for all recorded operation phases for a workplace.
 */
public class WorkplaceRecordedOperationPhasesResponse extends AbstractCollectionResponse<OperationPhaseRecordPropertiesWSModel> {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The recorded operation phases collection properties model. */
    private WpOperationPhaseCollectionPropertiesWSModel mProperties = new WpOperationPhaseCollectionPropertiesWSModel();

    // ------------------------------------------------------------------------
    // constructors.
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     *
     * @param request The request.
     */
    public WorkplaceRecordedOperationPhasesResponse(PaginationRequest request) {
        super(request);
    }

    // ------------------------------------------------------------------------
    // getter/setter
    // ------------------------------------------------------------------------

    /**
     * Provides the recorded operation phases of a workplace.
     *
     * @return The recorded operation phases collection properties WS model.
     */
    public WpOperationPhaseCollectionPropertiesWSModel getProperties() {
        return mProperties;
    }

    /**
     * Sets the recorded operation phases of a workplace.
     *
     * @param properties The recorded operation phases collection properties WS model.
     */
    public void setProperties(WpOperationPhaseCollectionPropertiesWSModel properties) {
        mProperties = properties;
    }

    @Override
    public List<OperationPhaseRecordPropertiesWSModel> getElements() {
        return mProperties.getElements();
    }
}