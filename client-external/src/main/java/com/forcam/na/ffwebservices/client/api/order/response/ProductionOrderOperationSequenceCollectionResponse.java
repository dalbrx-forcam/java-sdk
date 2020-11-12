////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 07.05.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.order.response;

import com.forcam.na.ffwebservices.client.api.pagination.response.AbstractCollectionResponse;
import com.forcam.na.ffwebservices.client.api.pagination.request.PaginationRequest;
import com.forcam.na.ffwebservices.model.order.ProductionOrderOperationSequencePropertiesWSModel;
import com.forcam.na.ffwebservices.model.order.ProductionOrderOperationSequenceWSModel;

import java.util.List;

/**
 * Collection response for production order operation sequences.
 */
public class ProductionOrderOperationSequenceCollectionResponse extends AbstractCollectionResponse<ProductionOrderOperationSequenceWSModel> {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The operation sequence collection properties. */
    private ProductionOrderOperationSequencePropertiesWSModel mProperties = new ProductionOrderOperationSequencePropertiesWSModel();

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     *
     * @param request The request.
     */
    public ProductionOrderOperationSequenceCollectionResponse(PaginationRequest request) {
        super(request);
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Provides the operation sequence collection properties.
     *
     * @return The operation sequence collection properties.
     */
    public ProductionOrderOperationSequencePropertiesWSModel getProperties() {
        return mProperties;
    }

    /**
     * Sets the operation sequence collection properties.
     *
     * @param properties The operation sequence collection properties.
     */
    public void setProperties(ProductionOrderOperationSequencePropertiesWSModel properties) {
        mProperties = properties;
    }

    @Override
    public List<ProductionOrderOperationSequenceWSModel> getElements() {
        return mProperties.getElements();
    }
}