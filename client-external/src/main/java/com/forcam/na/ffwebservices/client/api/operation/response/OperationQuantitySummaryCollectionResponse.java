////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 31.01.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.operation.response;

import com.forcam.na.ffwebservices.client.api.pagination.response.AbstractCollectionResponse;
import com.forcam.na.ffwebservices.client.api.pagination.request.PaginationRequest;
import com.forcam.na.ffwebservices.model.operation.quantity.OperationQuantitySummaryCollectionPropertiesWSModel;
import com.forcam.na.ffwebservices.model.operation.quantity.OperationQuantitySummaryDetailPropertiesWSModel;

import java.util.List;

/**
 * The collection response for operation quantity summary.
 */
public class OperationQuantitySummaryCollectionResponse extends AbstractCollectionResponse<OperationQuantitySummaryDetailPropertiesWSModel> {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** A collection of operation quantity summary property models. */
    private OperationQuantitySummaryCollectionPropertiesWSModel mProperties = new OperationQuantitySummaryCollectionPropertiesWSModel();

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     *
     * @param request The request.
     */
    public OperationQuantitySummaryCollectionResponse(PaginationRequest request) {
        super(request);
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public OperationQuantitySummaryCollectionPropertiesWSModel getProperties() {
        return mProperties;
    }

    public void setProperties(OperationQuantitySummaryCollectionPropertiesWSModel properties) {
        mProperties = properties;
    }

    @Override
    public List<OperationQuantitySummaryDetailPropertiesWSModel> getElements() {
        return mProperties.getElements();
    }
}