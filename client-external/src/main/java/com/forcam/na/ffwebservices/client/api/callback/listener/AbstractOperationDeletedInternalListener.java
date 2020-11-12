////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 12.09.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.callback.listener;

import com.forcam.na.ffwebservices.model.event.Event;

/**
 * The abstract operation deleted internal listener.
 */
public abstract class AbstractOperationDeletedInternalListener extends AbstractCallbackListener<Void> {

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Instantiates an operation deleted internal listener.
     */
    public AbstractOperationDeletedInternalListener() {
        super(Void.class, Event.INTERNAL__OPERATION_DELETED);
    }
}