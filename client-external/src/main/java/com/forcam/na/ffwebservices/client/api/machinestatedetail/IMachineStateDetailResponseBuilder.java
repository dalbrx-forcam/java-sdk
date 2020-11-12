////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 20.10.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.machinestatedetail;

import com.forcam.na.ffwebservices.client.api.machinestatedetail.request.GetMachineStateDetailsRequest;
import com.forcam.na.ffwebservices.client.api.pagination.response.CollectionResponse;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.client.api.HALCollectionWSModel;
import com.forcam.na.ffwebservices.model.machinestatedetail.MachineStateDetailResponse;

/**
 * Contains methods for building responses for machine state details.
 */
public interface IMachineStateDetailResponseBuilder {

    /**
     * Transforms a collection model to a machine state detail collection response.
     *
     * @param request         The request.
     * @param collectionModel A collection model.
     * @return A machine state detail collection response.
     */
    CollectionResponse<MachineStateDetailResponse> getMachineStateDetailCollectionResponse(GetMachineStateDetailsRequest request,
                                                                                           HALCollectionWSModel collectionModel);

    /**
     * Converts HAL Model into a machine state detail model.
     *
     * @param serverModel The model received by the server.
     * @return A machine state detail model.
     */
    MachineStateDetailResponse getMachineStateDetailResponse(HALWSModel serverModel);
}