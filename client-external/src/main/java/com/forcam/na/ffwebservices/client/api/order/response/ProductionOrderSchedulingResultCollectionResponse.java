////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 23.05.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.order.response;

import com.forcam.na.ffwebservices.client.api.pagination.response.AbstractCollectionResponse;
import com.forcam.na.ffwebservices.client.api.pagination.request.PaginationRequest;
import com.forcam.na.ffwebservices.model.order.ProductionOrderScheduledDatesWSModel;
import com.forcam.na.ffwebservices.model.order.ProductionOrderSchedulingResultPropertiesWSModel;

import java.util.List;

/**
 * Response model for production order scheduling results request.
 */
public class ProductionOrderSchedulingResultCollectionResponse extends AbstractCollectionResponse<ProductionOrderScheduledDatesWSModel> {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The production order scheduling result properties. */
    private ProductionOrderSchedulingResultPropertiesWSModel mProperties = new ProductionOrderSchedulingResultPropertiesWSModel();

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     *
     * @param request The request.
     */
    public ProductionOrderSchedulingResultCollectionResponse(PaginationRequest request) {
        super(request);
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Provides the production order scheduling result properties.
     *
     * @return The production order scheduling result properties WS model.
     */
    public ProductionOrderSchedulingResultPropertiesWSModel getProperties() {
        return mProperties;
    }

    /**
     * Sets the production order scheduling result properties.
     *
     * @param properties The production order scheduling result properties WS model.
     */
    public void setProperties(ProductionOrderSchedulingResultPropertiesWSModel properties) {
        mProperties = properties;
    }

    @Override
    public List<ProductionOrderScheduledDatesWSModel> getElements() {
        return mProperties.getElements();
    }
}