////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 12.09.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.callback.listener;

import com.forcam.na.ffwebservices.model.event.Event;

/**
 * The abstract operation updated internal listener.
 */
public abstract class AbstractOperationUpdatedInternalListener extends AbstractCallbackListener<Void> {

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Instantiates an operation updated internal listener.
     */
    public AbstractOperationUpdatedInternalListener() {
        super(Void.class, Event.INTERNAL__OPERATION_UPDATED);
    }
}