////////////////////////////////////////////////////////////////////////////////
//
// Created by hiteshgarg on 5/16/2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.order.request;

import com.forcam.na.ffwebservices.client.api.pagination.request.CollectionTimestampRequest;
import com.forcam.na.ffwebservices.model.order.ProductionOrderEmbed;
import com.forcam.na.ffwebservices.model.order.SearchProductionOrdersRequestBody;
import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Search production order request parameters.
 */
public class SearchProductionOrderRequest extends CollectionTimestampRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Determines what shall be embedded. */
    private ProductionOrderEmbed mEmbed = new ProductionOrderEmbed();
    /** Search production orders request body. */
    private SearchProductionOrdersRequestBody mSearchProductionOrdersRequestBody = new SearchProductionOrdersRequestBody();

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    /**
     * Get/Set the details on which resources will be embedded for the production order.
     *
     * @return {@link ProductionOrderEmbed}.
     */
    public ProductionOrderEmbed embed() {
        return mEmbed;
    }

    @Override
    public String toString() {
        return ToStringUtility.newToStringBuilder(this)
            .appendSuper(super.toString())
            .append("embed", mEmbed)
            .append("searchProductionOrdersRequestBody", mSearchProductionOrdersRequestBody)
            .toString();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Getter for {@link SearchProductionOrderRequest#mEmbed}.
     *
     * @return Determines what shall be embedded.
     */
    public ProductionOrderEmbed getEmbed() {
        return mEmbed;
    }

    /**
     * Setter for {@link SearchProductionOrderRequest#mEmbed}.
     *
     * @param embed Determines what shall be embedded.
     */
    public void setEmbed(ProductionOrderEmbed embed) {
        mEmbed = embed;
    }

    /**
     * Getter for {@link SearchProductionOrderRequest#mSearchProductionOrdersRequestBody}.
     *
     * @return Search production orders request body.
     */
    public SearchProductionOrdersRequestBody getSearchProductionOrdersRequestBody() {
        return mSearchProductionOrdersRequestBody;
    }

}
