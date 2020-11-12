////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 05.01.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.tool;

import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.model.tool.ToolLocationResponse;

/**
 * Contains methods for building responses for locations of tools.
 */
public interface IToolLocationResponseBuilder {

    /**
     * Converts HAL model to a tool location model.
     *
     * @param serverModel The server model.
     * @return A tool location model.
     */
    ToolLocationResponse getToolLocationResponse(HALWSModel serverModel);
}