////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 10.10.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.qualitydetail;

import com.forcam.na.ffwebservices.client.api.HALCollectionWSModel;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.model.IPathParts;
import com.forcam.na.ffwebservices.model.IRequestAndQueryParams;
import com.forcam.na.ffwebservices.model.qualitydetail.QualityType;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * An interface with methods for creating calls that can be sent to the server.
 */
public interface QualityDetailEndpoint {

    /**
     * Creates a call that can be sent to the server.
     *
     * @param limit         The limit.
     * @param offset        The offset.
     * @param code          The code.
     * @param qualityTypeId The quality type ID.
     * @param embed         The resources which shall be embedded.
     * @return A call that can be sent to the server.
     */
    @Headers({ "Content-Type: application/json", "Accept: application/hal+json" })
    @GET(IPathParts.MASTER_DATA + "/" + IPathParts.QUALITY_DETAILS)
    Call<HALCollectionWSModel> getQualityDetails(
        @Query(IRequestAndQueryParams.LIMIT)
            int limit,
        @Query(IRequestAndQueryParams.OFFSET)
            int offset,
        @Query(IRequestAndQueryParams.CODE)
            String code,
        @Query(IRequestAndQueryParams.QUALITY_TYPE_ID)
            QualityType qualityTypeId,
        @Query(IRequestAndQueryParams.EMBED)
            String embed);

    /**
     * Creates a call that can be sent to the server.
     *
     * @param qualityDetailId The quality detail ID.
     * @param embed           The resources which shall be embedded.
     * @return A call that can be sent to the server.
     */
    @Headers({ "Content-Type: application/json", "Accept: application/hal+json" })
    @GET(IPathParts.MASTER_DATA + "/" + IPathParts.QUALITY_DETAILS + "/{" + IRequestAndQueryParams.QUALITY_DETAIL_ID + "}")
    Call<HALWSModel> getQualityDetail(
        @Path(IRequestAndQueryParams.QUALITY_DETAIL_ID)
            String qualityDetailId,
        @Query(IRequestAndQueryParams.EMBED)
            String embed);
}