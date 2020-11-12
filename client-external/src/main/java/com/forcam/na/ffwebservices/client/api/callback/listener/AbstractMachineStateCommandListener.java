////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 12.09.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.callback.listener;

import com.forcam.na.ffwebservices.model.command.machine.MachineStateCommandDataWSModel;
import com.forcam.na.ffwebservices.model.event.Event;

/**
 * The abstract machine state command listener.
 */
public abstract class AbstractMachineStateCommandListener extends AbstractCallbackListener<MachineStateCommandDataWSModel> {

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Instantiates a machine state command listener.
     */
    public AbstractMachineStateCommandListener() {
        super(MachineStateCommandDataWSModel.class, Event.COMMAND__MACHINE_STATE);
    }
}