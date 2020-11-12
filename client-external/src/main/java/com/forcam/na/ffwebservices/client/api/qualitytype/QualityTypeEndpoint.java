////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 09.01.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.qualitytype;

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
public interface QualityTypeEndpoint {

    /**
     * Creates a call that can be sent to the server.
     *
     * @param limit  The limit.
     * @param offset The offset.
     * @param embed  The resources which shall be embedded.
     * @return A call that can be sent to the server.
     */
    @Headers({ "Content-Type: application/json", "Accept: application/hal+json" })
    @GET(IPathParts.MASTER_DATA + "/" + IPathParts.QUALITY_TYPES)
    Call<HALCollectionWSModel> getQualityTypes(
        @Query(IRequestAndQueryParams.LIMIT)
            int limit,
        @Query(IRequestAndQueryParams.OFFSET)
            int offset,
        @Query(IRequestAndQueryParams.EMBED)
            String embed);

    /**
     * Creates a call that can be sent to the server.
     *
     * @param qualityTypeId The ID.
     * @param embed         The resources which shall be embedded.
     * @return A call that can be sent to the server.
     */
    @Headers({ "Content-Type: application/json", "Accept: application/hal+json" })
    @GET(IPathParts.MASTER_DATA + "/" + IPathParts.QUALITY_TYPES + "/{" + IRequestAndQueryParams.QUALITY_TYPE_ID + "}")
    Call<HALWSModel> getQualityType(
        @Path(IRequestAndQueryParams.QUALITY_TYPE_ID)
            String qualityTypeId,
        @Query(IRequestAndQueryParams.EMBED)
            String embed);
}