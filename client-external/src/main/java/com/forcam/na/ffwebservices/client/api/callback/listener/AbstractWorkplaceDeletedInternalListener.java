////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 12.09.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.callback.listener;

import com.forcam.na.ffwebservices.model.event.Event;

/**
 * The abstract workplace deleted internal listener.
 */
public abstract class AbstractWorkplaceDeletedInternalListener extends AbstractCallbackListener<Void> {

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Instantiates a workplace deleted internal listener.
     */
    public AbstractWorkplaceDeletedInternalListener() {
        super(Void.class, Event.INTERNAL__WORKPLACE_DELETED);
    }
}