////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 13.09.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.order.response;

import com.forcam.na.ffwebservices.client.api.pagination.response.SpecificPage;
import com.forcam.na.ffwebservices.model.order.ProductionOrderOperationSequenceWSModel;

import java.lang.reflect.Method;

/**
 * Page containing production order operation sequence.
 */
public class ProductionOrderOperationSequenceCollectionPage
    extends SpecificPage<ProductionOrderOperationSequenceWSModel, ProductionOrderOperationSequenceCollectionResponse> {

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     *
     * @param client   The client.
     * @param m        The client method.
     * @param response The response.
     */
    public ProductionOrderOperationSequenceCollectionPage(Object client, Method m, ProductionOrderOperationSequenceCollectionResponse response) {
        super(client, m, response);
    }
}
