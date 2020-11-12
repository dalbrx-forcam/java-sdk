////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 09.01.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.qualitytype;

import com.forcam.na.ffwebservices.client.api.pagination.response.CollectionResponse;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.client.api.HALCollectionWSModel;
import com.forcam.na.ffwebservices.client.api.qualitytype.request.GetQualityTypesRequest;
import com.forcam.na.ffwebservices.model.qualitytype.QualityTypeResponse;

/**
 * Contains methods for building responses for quality types.
 */
public interface IQualityTypeResponseBuilder {

    /**
     * Transforms a collection model to a quality type collection response.
     *
     * @param request         The request.
     * @param collectionModel A collection model.
     * @return A quality type collection response.
     */
    CollectionResponse<QualityTypeResponse> getQualityTypeCollectionResponse(GetQualityTypesRequest request, HALCollectionWSModel collectionModel);

    /**
     * Converts HAL Model into a quality type model.
     *
     * @param serverModel The model received by the server.
     * @return A quality type model.
     */
    QualityTypeResponse getQualityTypeResponse(HALWSModel serverModel);
}