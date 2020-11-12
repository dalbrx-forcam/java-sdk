////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 12.09.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.callback.listener;

import com.forcam.na.ffwebservices.model.event.Event;

/**
 * The abstract operation created internal listener.
 */
public abstract class AbstractOperationCreatedInternalListener extends AbstractCallbackListener<Void> {

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Instantiates an operation created internal listener.
     */
    public AbstractOperationCreatedInternalListener() {
        super(Void.class, Event.INTERNAL__OPERATION_CREATED);
    }
}