////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 12.12.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.operation;

import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.model.operation.OperationScheduledDatesResponse;

/**
 * Contains methods for building responses for the scheduled dates of operations.
 */
public interface IOperationScheduledDatesResponseBuilder {

    /**
     * Converts HAL model into an operation scheduled dates model.
     *
     * @param serverModel The model received by the server.
     * @return An operation scheduled dates model.
     */
    OperationScheduledDatesResponse getOperationScheduledDatesResponse(HALWSModel serverModel);
}