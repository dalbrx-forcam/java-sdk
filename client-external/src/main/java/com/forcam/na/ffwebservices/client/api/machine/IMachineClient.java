////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 08.11.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.machine;

import com.forcam.na.ffwebservices.client.api.exception.ForceAPIException;
import com.forcam.na.ffwebservices.client.api.machine.request.GetMachinesRequest;
import com.forcam.na.ffwebservices.client.api.pagination.response.Page;
import com.forcam.na.ffwebservices.model.machine.MachineResponse;

/**
 * An interface with methods that request machines.
 */
public interface IMachineClient {

    /**
     * Sends a request to the server and gets a collection of machines as response.
     *
     * @param request A collection of parameters.
     * @return The machine collection response.
     * @throws ForceAPIException When unable to get machines.
     */
    Page<MachineResponse> getMachines(GetMachinesRequest request) throws ForceAPIException;
}