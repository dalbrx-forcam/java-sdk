////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 18.09.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.order;

import com.forcam.na.ffwebservices.client.api.AbstractLinkModelBuilder;
import com.forcam.na.ffwebservices.model.order.OrderPropertiesWSModel;

import javax.inject.Inject;

/**
 * Creates an order link model.
 */
public class OrderLinkModelBuilder extends AbstractLinkModelBuilder<OrderPropertiesWSModel> {

    // ----------------------------------------------------------------------
    // constructors
    // ----------------------------------------------------------------------

    @Inject
    public OrderLinkModelBuilder() {
        super(OrderPropertiesWSModel.class);
    }
}