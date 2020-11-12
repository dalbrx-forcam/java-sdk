////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 12.09.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.callback.listener;

import com.forcam.na.ffwebservices.model.event.Event;

/**
 * The abstract staff member deleted internal listener.
 */
public abstract class AbstractStaffMemberDeletedInternalListener extends AbstractCallbackListener<Void> {

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Instantiates a staff member deleted internal listener.
     */
    public AbstractStaffMemberDeletedInternalListener() {
        super(Void.class, Event.INTERNAL__STAFF_MEMBER_DELETED);
    }
}