////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 13.09.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.operation.response;

import com.forcam.na.ffwebservices.client.api.pagination.response.SpecificPage;
import com.forcam.na.ffwebservices.model.operation.quantity.OperationQuantitySummaryDetailPropertiesWSModel;

import java.lang.reflect.Method;

/**
 * Page containing Operation quantity summaries.
 */
public class OperatingQuantitySummaryCollectionPage
    extends SpecificPage<OperationQuantitySummaryDetailPropertiesWSModel, OperationQuantitySummaryCollectionResponse> {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     *
     * @param client       The client.
     * @param clientMethod The client method.
     * @param response     The response.
     */
    public OperatingQuantitySummaryCollectionPage(Object client, Method clientMethod, OperationQuantitySummaryCollectionResponse response) {
        super(client, clientMethod, response);
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

}
