////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 12.09.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.callback.listener;

import com.forcam.na.ffwebservices.model.command.operation.OperationPhaseCommandDataWsModel;
import com.forcam.na.ffwebservices.model.event.Event;

/**
 * The abstract operation phase command listener.
 */
public abstract class AbstractOperationPhaseCommandListener extends AbstractCallbackListener<OperationPhaseCommandDataWsModel> {

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Instantiates an operation phase command listener.
     */
    public AbstractOperationPhaseCommandListener() {
        super(OperationPhaseCommandDataWsModel.class, Event.COMMAND__OPERATION_PHASE);
    }
}