////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 27.09.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.statusdefinition;

import com.forcam.na.ffwebservices.client.api.exception.ForceAPIException;
import com.forcam.na.ffwebservices.client.api.pagination.request.CollectionRequest;
import com.forcam.na.ffwebservices.client.api.pagination.response.Page;
import com.forcam.na.ffwebservices.model.statusdefinition.StatusDefinitionResponse;

/**
 * An interface with methods that request status definitions.
 */
public interface IStatusDefinitionClient {

    /**
     * Sends a request to the server and gets a collection of status definitions as response.
     *
     * @param params Request parameters.
     * @return Status Definition Collection Response.
     * @throws ForceAPIException When unable to get machine status definitions.
     */
    Page<StatusDefinitionResponse> getMachineStates(CollectionRequest params) throws ForceAPIException;

    Page<StatusDefinitionResponse> getOperationProductionStates(CollectionRequest params) throws ForceAPIException;

    /**
     * Sends a request to the server and gets a collection of status definitions as response.
     *
     * @param params Request parameters.
     * @return Status Definition Collection Response.
     * @throws ForceAPIException When unable to get personnel status definitions.
     */
    Page<StatusDefinitionResponse> getPersonnelStates(CollectionRequest params) throws ForceAPIException;

}