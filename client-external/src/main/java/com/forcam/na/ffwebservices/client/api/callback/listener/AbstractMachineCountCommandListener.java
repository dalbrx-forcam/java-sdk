////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 12.09.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.callback.listener;

import com.forcam.na.ffwebservices.model.command.machine.MachineCountCommandDataWSModel;
import com.forcam.na.ffwebservices.model.event.Event;

/**
 * The abstract machine count command listener.
 */
public abstract class AbstractMachineCountCommandListener extends AbstractCallbackListener<MachineCountCommandDataWSModel> {

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Instantiates a machine count command listener.
     */
    public AbstractMachineCountCommandListener() {
        super(MachineCountCommandDataWSModel.class, Event.COMMAND__MACHINE_COUNT);
    }
}