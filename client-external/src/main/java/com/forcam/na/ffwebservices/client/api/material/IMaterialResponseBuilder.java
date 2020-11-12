////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 06.02.2020.
//
// Copyright (c) 2006 - 2020 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.material;

import com.forcam.na.ffwebservices.client.api.HALCollectionWSModel;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.client.api.material.request.GetMaterialsRequest;
import com.forcam.na.ffwebservices.client.api.material.response.MaterialResponse;
import com.forcam.na.ffwebservices.client.api.pagination.response.CollectionResponse;

/**
 * Response builder for material.
 */
public interface IMaterialResponseBuilder {
    CollectionResponse<MaterialResponse> getMaterialCollectionResponse(GetMaterialsRequest request, HALCollectionWSModel collectionModel);

    MaterialResponse getMaterialResponse(HALWSModel serverModel);
}
