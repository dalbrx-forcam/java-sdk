////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 12.09.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.callback.listener;

import com.forcam.na.ffwebservices.model.event.Event;

/**
 * The abstract production order created internal listener.
 */
public abstract class AbstractProductionOrderCreatedInternalListener extends AbstractCallbackListener<Void> {

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Instantiates a production order created internal listener.
     */
    public AbstractProductionOrderCreatedInternalListener() {
        super(Void.class, Event.INTERNAL__PRODUCTION_ORDER_CREATED);
    }
}