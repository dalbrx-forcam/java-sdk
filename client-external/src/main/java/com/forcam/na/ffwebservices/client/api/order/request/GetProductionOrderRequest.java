////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 19.12.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.order.request;

import com.forcam.na.ffwebservices.model.order.ProductionOrderEmbed;
import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Contains an ID and values that determine what shall be embedded.
 */
public class GetProductionOrderRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** A production order ID. */
    private String mId;

    /** Determines what shall be embedded. */
    private ProductionOrderEmbed mEmbed = new ProductionOrderEmbed();

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new {@link GetProductionOrderRequest} object with a production order ID.
     *
     * @param productionOrderId The production order ID.
     */
    public GetProductionOrderRequest(String productionOrderId) {
        mId = productionOrderId;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    public ProductionOrderEmbed embed() {
        return mEmbed;
    }

    public void embed(ProductionOrderEmbed embed) {
        mEmbed = embed;
    }

    @Override
    public String toString() {
        return ToStringUtility.newToStringBuilder(this)
            .append("id", mId)
            .append("embed", mEmbed)
            .toString();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }
}