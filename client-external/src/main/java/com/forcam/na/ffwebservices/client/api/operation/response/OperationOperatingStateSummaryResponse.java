////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 18.07.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.operation.response;

import com.forcam.na.ffwebservices.client.api.pagination.response.AbstractCollectionResponse;
import com.forcam.na.ffwebservices.client.api.pagination.request.PaginationRequest;
import com.forcam.na.ffwebservices.model.operatingstate.OperatingStateSummaryPropertiesWSModel;
import com.forcam.na.ffwebservices.model.operatingstate.OperatingStateSummaryWSModel;

import java.util.List;

/**
 * Operation operating state summary response model.
 */
public class OperationOperatingStateSummaryResponse extends AbstractCollectionResponse<OperatingStateSummaryWSModel> {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The operating state summary properties of an operation. */
    private OperatingStateSummaryPropertiesWSModel mProperties = new OperatingStateSummaryPropertiesWSModel();

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     *
     * @param request The request.
     */
    public OperationOperatingStateSummaryResponse(PaginationRequest request) {
        super(request);
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Provides the operation operating state summary properties.
     *
     * @return The operation operating state summary properties WS model.
     */
    public OperatingStateSummaryPropertiesWSModel getProperties() {
        return mProperties;
    }

    /**
     * Sets the operation operating state summary properties.
     *
     * @param properties The operation operating state summary properties WS model.
     */
    public void setProperties(OperatingStateSummaryPropertiesWSModel properties) {
        mProperties = properties;
    }

    @Override
    public List<OperatingStateSummaryWSModel> getElements() {
        return mProperties.getElements();
    }
}