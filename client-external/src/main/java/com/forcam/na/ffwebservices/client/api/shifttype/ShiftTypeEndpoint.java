////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 02.10.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.shifttype;

import com.forcam.na.ffwebservices.client.api.HALCollectionWSModel;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.model.IPathParts;
import com.forcam.na.ffwebservices.model.IRequestAndQueryParams;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * An interface with methods for creating calls that can be sent to the server.
 */
public interface ShiftTypeEndpoint {

    /**
     * Creates a call that can be sent to the server.
     *
     * @param limit  The limit.
     * @param offset The offset.
     * @param embed  The resources which shall be embedded.
     * @return A call that can be sent to the server.
     */
    @Headers({ "Content-Type: application/json", "Accept: application/hal+json" })
    @GET(IPathParts.MASTER_DATA + "/" + IPathParts.SHIFT_TYPES)
    Call<HALCollectionWSModel> getShiftTypes(
        @Query(IRequestAndQueryParams.LIMIT)
            int limit,
        @Query(IRequestAndQueryParams.OFFSET)
            int offset,
        @Query(IRequestAndQueryParams.EMBED)
            String embed);

    /**
     * Creates a call that can be sent to the server.
     *
     * @param shiftTypeId The shift type id.
     * @param embed       The resources which shall be embedded.
     * @return A call that can be sent to the server.
     */
    @Headers({ "Content-Type: application/json", "Accept: application/hal+json" })
    @GET(IPathParts.MASTER_DATA + "/" + IPathParts.SHIFT_TYPES + "/{" + IRequestAndQueryParams.SHIFT_TYPE_ID + "}")
    Call<HALWSModel> getShiftType(
        @Path(IRequestAndQueryParams.SHIFT_TYPE_ID)
            String shiftTypeId,
        @Query(IRequestAndQueryParams.EMBED)
            String embed);
}