////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 23.05.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.order.request;

import com.forcam.na.ffwebservices.client.api.pagination.request.CollectionRequest;
import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Request parameter for getting production order scheduling results.
 */
public class GetProductionOrderSchedulingResultsRequest extends CollectionRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The production order number. */
    private String mProductionOrderId;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates new instance with production order ID.
     *
     * @param productionOrderId The production order ID.
     */
    public GetProductionOrderSchedulingResultsRequest(String productionOrderId) {
        mProductionOrderId = productionOrderId;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return ToStringUtility.newToStringBuilder(this)
            .appendSuper(super.toString())
            .append("productionOrderId", mProductionOrderId)
            .toString();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public String getProductionOrderId() {
        return mProductionOrderId;
    }

    public void setProductionOrderId(String productionOrderId) {
        mProductionOrderId = productionOrderId;
    }
}