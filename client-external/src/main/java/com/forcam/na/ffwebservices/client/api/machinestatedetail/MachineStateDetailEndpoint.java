////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 10.10.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.machinestatedetail;

import com.forcam.na.ffwebservices.client.api.HALCollectionWSModel;
import com.forcam.na.ffwebservices.model.IPathParts;
import com.forcam.na.ffwebservices.model.IRequestAndQueryParams;
import com.forcam.na.ffwebservices.model.machinestatedetail.IMachineStateDetailPaths;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * An interface with methods for creating calls that can be sent to the server.
 */
public interface MachineStateDetailEndpoint {

    /**
     * Creates a call that can be sent to the server.
     *
     * @param limit  The limit.
     * @param offset The offset.
     * @param embed  The resources which shall be embedded.
     * @return A call that can be sent to the server.
     */
    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @GET(IPathParts.MASTER_DATA + "/" + IMachineStateDetailPaths.MACHINE_STATE_DETAILS)
    Call<HALCollectionWSModel> getMachineStateDetails(
        @Query(IRequestAndQueryParams.LIMIT)
        int limit,
        @Query(IRequestAndQueryParams.OFFSET)
        int offset,
        @Query(IRequestAndQueryParams.EMBED)
        String embed);
}