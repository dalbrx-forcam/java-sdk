////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 08.11.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.machine;

import com.forcam.na.ffwebservices.client.api.machine.request.GetMachinesRequest;
import com.forcam.na.ffwebservices.client.api.pagination.response.CollectionResponse;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.client.api.HALCollectionWSModel;
import com.forcam.na.ffwebservices.model.machine.MachineResponse;

/**
 * Contains methods for building responses for machines.
 */
public interface IMachineResponseBuilder {

    /**
     * Transforms a collection model to a machine collection response.
     *
     * @param request         The request.
     * @param collectionModel A collection model.
     * @return A machine collection response.
     */
    CollectionResponse<MachineResponse> getMachineCollectionResponse(GetMachinesRequest request, HALCollectionWSModel collectionModel);

    /**
     * Converts HAL model to a machine model.
     *
     * @param serverModel The server model.
     * @return A machine model.
     */
    MachineResponse getMachineResponse(HALWSModel serverModel);
}