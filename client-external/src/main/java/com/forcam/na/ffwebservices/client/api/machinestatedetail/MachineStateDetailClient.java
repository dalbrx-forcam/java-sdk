////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 10.10.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.machinestatedetail;

import com.forcam.na.ffwebservices.client.api.AbstractClient;
import com.forcam.na.ffwebservices.client.api.HALCollectionWSModel;
import com.forcam.na.ffwebservices.client.api.exception.ForceAPIException;
import com.forcam.na.ffwebservices.client.api.machinestatedetail.request.GetMachineStateDetailsRequest;
import com.forcam.na.ffwebservices.client.api.pagination.response.CollectionResponse;
import com.forcam.na.ffwebservices.client.api.pagination.response.Page;
import com.forcam.na.ffwebservices.model.machinestatedetail.MachineStateDetailResponse;
import retrofit2.Call;

import javax.inject.Inject;
import java.lang.reflect.Method;

/**
 * Requests machine state details.
 */
public class MachineStateDetailClient extends AbstractClient implements IMachineStateDetailClient {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The machine state detail endpoint. */
    private final MachineStateDetailEndpoint mMachineStateDetailEndpoint;

    /** The machine state detail response builder. */
    private final IMachineStateDetailResponseBuilder mMachineStateDetailResponseBuilder;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     *
     * @param machineStateDetailEndpoint        Machine state detail endpoint.
     * @param machineStateDetailResponseBuilder Machine state detail response builder.
     */
    @Inject
    public MachineStateDetailClient(MachineStateDetailEndpoint machineStateDetailEndpoint,
                                    MachineStateDetailResponseBuilder machineStateDetailResponseBuilder) {
        mMachineStateDetailEndpoint = machineStateDetailEndpoint;
        mMachineStateDetailResponseBuilder = machineStateDetailResponseBuilder;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public Page<MachineStateDetailResponse> getMachineStateDetails(GetMachineStateDetailsRequest request) throws ForceAPIException {
        final Call<HALCollectionWSModel> call = mMachineStateDetailEndpoint.getMachineStateDetails(request.getLimit(),
                                                                                                   request.getOffset(),
                                                                                                   request
                                                                                                       .embed()
                                                                                                       .toString());
        final HALCollectionWSModel responseModel = this.getResponseModel(request, call);
        final CollectionResponse<MachineStateDetailResponse> response = mMachineStateDetailResponseBuilder.getMachineStateDetailCollectionResponse(request,
                                                                                                                                                   responseModel);

        final Method m = new Object() {}
            .getClass()
            .getEnclosingMethod();
        return new Page<>(this, m, response);
    }
}