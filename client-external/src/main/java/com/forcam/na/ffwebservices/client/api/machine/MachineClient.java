////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 08.11.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.machine;

import com.forcam.na.ffwebservices.client.api.AbstractClient;
import com.forcam.na.ffwebservices.client.api.exception.ForceAPIException;
import com.forcam.na.ffwebservices.client.api.machine.request.GetMachinesRequest;
import com.forcam.na.ffwebservices.client.api.pagination.response.CollectionResponse;
import com.forcam.na.ffwebservices.client.api.pagination.response.Page;
import com.forcam.na.ffwebservices.client.api.HALCollectionWSModel;
import com.forcam.na.ffwebservices.model.machine.MachineResponse;
import retrofit2.Call;

import javax.inject.Inject;
import java.lang.reflect.Method;

/**
 * Requests machines.
 */
public class MachineClient extends AbstractClient implements IMachineClient {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The machine endpoint. */
    private final MachineEndpoint mMachineEndpoint;

    /** The machine response builder. */
    private final IMachineResponseBuilder mMachineResponseBuilder;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    @Inject
    public MachineClient(MachineEndpoint machineEndpoint, IMachineResponseBuilder machineResponseBuilder) {
        mMachineEndpoint = machineEndpoint;
        mMachineResponseBuilder = machineResponseBuilder;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public Page<MachineResponse> getMachines(GetMachinesRequest request) throws ForceAPIException {
        final Call<HALCollectionWSModel> call = mMachineEndpoint.getMachines(request.getWorkplaceNumber(),
                                                                             request.getLimit(),
                                                                             request.getOffset(),
                                                                             request
                                                                                 .embed()
                                                                                 .toString());
        final HALCollectionWSModel responseModel = this.getResponseModel(request, call);
        final CollectionResponse<MachineResponse> response = mMachineResponseBuilder.getMachineCollectionResponse(request, responseModel);

        final Method m = new Object() {}
            .getClass()
            .getEnclosingMethod();
        return new Page<>(this, m, response);
    }
}