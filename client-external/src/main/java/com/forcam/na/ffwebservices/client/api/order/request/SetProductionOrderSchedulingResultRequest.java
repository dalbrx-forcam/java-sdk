////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 24.05.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.order.request;

import com.forcam.na.ffwebservices.model.order.ProductionOrderSchedulingResultPropertiesWSModel;

/**
 * Set production order scheduling result request parameter.
 */
public class SetProductionOrderSchedulingResultRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The production order ID. */
    private String mProductionOrderId;

    /** The production order scheduling result properties. */
    private ProductionOrderSchedulingResultPropertiesWSModel mSchedulingResult = new ProductionOrderSchedulingResultPropertiesWSModel();

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates new instance with production order ID.
     *
     * @param productionOrderId The production order ID.
     */
    public SetProductionOrderSchedulingResultRequest(String productionOrderId) {
        mProductionOrderId = productionOrderId;
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Provides the production order ID.
     *
     * @return The production order ID.
     */
    public String getProductionOrderId() {
        return mProductionOrderId;
    }

    /**
     * Sets the production order ID.
     *
     * @param productionOrderId The production order ID.
     */
    public void setProductionOrderId(String productionOrderId) {
        mProductionOrderId = productionOrderId;
    }

    /**
     * Provides the production order scheduling result properties.
     *
     * @return The production order scheduling result properties WS model.
     */
    public ProductionOrderSchedulingResultPropertiesWSModel getSchedulingResult() {
        return mSchedulingResult;
    }

    /**
     * Sets the production order scheduling result properties.
     *
     * @param schedulingResult The production order scheduling result properties WS model.
     */
    public void setSchedulingResult(ProductionOrderSchedulingResultPropertiesWSModel schedulingResult) {
        mSchedulingResult = schedulingResult;
    }
}