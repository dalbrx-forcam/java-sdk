////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 18.07.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.operation.response;

import com.forcam.na.ffwebservices.client.api.pagination.response.AbstractCollectionResponse;
import com.forcam.na.ffwebservices.client.api.pagination.request.PaginationRequest;
import com.forcam.na.ffwebservices.model.recordedoutputquantities.RecordedOutputQuantitiesCollectionPropertiesWSModel;
import com.forcam.na.ffwebservices.model.recordedoutputquantities.RecordedOutputQuantitiesWSModel;

import java.util.List;

/**
 * Operation recorded output quantities response model.
 */
public class OperationRecordedOutputQuantitiesResponse extends AbstractCollectionResponse<RecordedOutputQuantitiesWSModel> {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The properties model. */
    private RecordedOutputQuantitiesCollectionPropertiesWSModel mProperties = new RecordedOutputQuantitiesCollectionPropertiesWSModel();

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     *
     * @param request The request.
     */
    public OperationRecordedOutputQuantitiesResponse(PaginationRequest request) {
        super(request);
    }

    // ------------------------------------------------------------------------
    // getter/setter
    // ------------------------------------------------------------------------

    /**
     * Provides the recorded output quantities properties.
     *
     * @return The recorded output quantities collection properties WS model.
     */
    public RecordedOutputQuantitiesCollectionPropertiesWSModel getProperties() {
        return mProperties;
    }

    /**
     * Sets the recorded output quantities properties.
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
