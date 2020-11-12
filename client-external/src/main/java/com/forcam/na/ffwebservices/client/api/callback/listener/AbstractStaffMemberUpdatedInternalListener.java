////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 12.09.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.callback.listener;

import com.forcam.na.ffwebservices.model.event.Event;

/**
 * The abstract staff member updated internal listener.
 */
public abstract class AbstractStaffMemberUpdatedInternalListener extends AbstractCallbackListener<Void> {

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Instantiates a staff member updated internal listener.
     */
    public AbstractStaffMemberUpdatedInternalListener() {
        super(Void.class, Event.INTERNAL__STAFF_MEMBER_UPDATED);
    }
}