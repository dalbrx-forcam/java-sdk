////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 06.02.2020.
//
// Copyright (c) 2006 - 2020 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.material;

import com.forcam.na.ffwebservices.client.api.HALCollectionWSModel;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.model.IRequestAndQueryParams;
import com.forcam.na.ffwebservices.model.material.IMaterialPaths;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * The material API endpoint.
 */
public interface MaterialEndpoint {

    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @GET(IMaterialPaths.MATERIALS)
    Call<HALCollectionWSModel> getMaterials(
        @Query(IRequestAndQueryParams.LIMIT)
            int limit,
        @Query(IRequestAndQueryParams.OFFSET)
            int offset);

    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @GET(IMaterialPaths.MATERIALS + "/{" + IRequestAndQueryParams.MATERIAL_ID + "}")
    Call<HALWSModel> getMaterial(
        @Path(IRequestAndQueryParams.MATERIAL_ID)
            String materialId);

}
