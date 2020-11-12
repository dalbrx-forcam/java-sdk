////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 25.01.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.entrypoint;

import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.model.entrypoint.EntryPointResponse;

/**
 * Contains methods for building responses for entry points.
 */
public interface IEntryPointResponseBuilder {

    /**
     * Converts HAL model to an entry point model.
     *
     * @param serverModel The server model.
     * @return An entry point model.
     */
    EntryPointResponse getEntryPointResponse(HALWSModel serverModel);
}