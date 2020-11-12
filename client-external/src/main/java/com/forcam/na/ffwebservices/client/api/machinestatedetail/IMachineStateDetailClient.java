////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 10.10.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.machinestatedetail;

import com.forcam.na.ffwebservices.client.api.exception.ForceAPIException;
import com.forcam.na.ffwebservices.client.api.machinestatedetail.request.GetMachineStateDetailsRequest;
import com.forcam.na.ffwebservices.client.api.pagination.response.Page;
import com.forcam.na.ffwebservices.model.machinestatedetail.MachineStateDetailResponse;

/**
 * An interface with methods that request machine state types.
 */
public interface IMachineStateDetailClient {

    /**
     * Sends a request to the server and gets a collection of machine state details as response.
     *
     * @param request A collection of parameters.
     * @return The machine state detail collection response.
     * @throws ForceAPIException When unable to get machine state details.
     */
    Page<MachineStateDetailResponse> getMachineStateDetails(GetMachineStateDetailsRequest request) throws ForceAPIException;
}