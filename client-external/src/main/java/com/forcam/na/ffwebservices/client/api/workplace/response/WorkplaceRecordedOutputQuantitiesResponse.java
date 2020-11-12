////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 29.05.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.workplace.response;

import com.forcam.na.ffwebservices.client.api.pagination.response.AbstractCollectionResponse;
import com.forcam.na.ffwebservices.client.api.pagination.request.PaginationRequest;
import com.forcam.na.ffwebservices.model.recordedoutputquantities.RecordedOutputQuantitiesCollectionPropertiesWSModel;
import com.forcam.na.ffwebservices.model.recordedoutputquantities.RecordedOutputQuantitiesWSModel;

import java.util.List;

/**
 * Response model for the recorded output quantities of a workplace.
 */
public class WorkplaceRecordedOutputQuantitiesResponse extends AbstractCollectionResponse<RecordedOutputQuantitiesWSModel> {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The recorded output quantities collection properties model. */
    private RecordedOutputQuantitiesCollectionPropertiesWSModel mProperties = new RecordedOutputQuantitiesCollectionPropertiesWSModel();

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     *
     * @param request The request.
     */
    public WorkplaceRecordedOutputQuantitiesResponse(PaginationRequest request) {
        super(request);
    }

    // ------------------------------------------------------------------------
    // getter/setter
    // ------------------------------------------------------------------------

    /**
     * Provides the recorded output quantities of a workplace.
     *
     * @return The recorded output quantities collection properties WS model.
     */
    public RecordedOutputQuantitiesCollectionPropertiesWSModel getProperties() {
        return mProperties;
    }

    /**
     * Sets the recorded output quantities of a workplace.
     *
     * @param properties The recorded output quantities collection properties WS model.
     */
    public void setProperties(RecordedOutputQuantitiesCollectionPropertiesWSModel properties) {
        mProperties = properties;
    }

    @Override
    public List<RecordedOutputQuantitiesWSModel> getElements() {
        return mProperties.getElements();
    }
}
