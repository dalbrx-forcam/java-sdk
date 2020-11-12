////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 12.12.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.operation;

import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.model.operation.OperationCurrentProductionDataResponse;
import com.forcam.na.ffwebservices.model.operation.OperationSpecificationResponse;

/**
 * Contains methods for building responses for the specification of operations.
 */
public interface IOperationSpecificationResponseBuilder {

    /**
     * Converts HAL model into an operation specification model.
     *
     * @param serverModel The model received by the server.
     * @return An operation specification model.
     */
    OperationSpecificationResponse getOperationSpecificationResponse(HALWSModel serverModel);

    /**
     * Converts HAL model into an operation current production data model.
     *
     * @param serverModel The model received by the server.
     * @return An operation current production data response.
     */
    OperationCurrentProductionDataResponse getOperationCurrentProductionDataResponse(HALWSModel serverModel);
}