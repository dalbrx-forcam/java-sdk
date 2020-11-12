////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 20.10.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.qualitydetail;

import com.forcam.na.ffwebservices.client.api.pagination.response.CollectionResponse;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.client.api.HALCollectionWSModel;
import com.forcam.na.ffwebservices.client.api.qualitydetail.request.GetQualityDetailsRequest;
import com.forcam.na.ffwebservices.model.qualitydetail.QualityDetailResponse;

/**
 * Contains methods for building responses for quality details.
 */
public interface IQualityDetailResponseBuilder {

    /**
     * Transforms a collection model to a quality detail collection response.
     *
     * @param request         The request.
     * @param collectionModel A collection model.
     * @return A quality detail collection response.
     */
    CollectionResponse<QualityDetailResponse> getQualityDetailCollectionResponse(GetQualityDetailsRequest request, HALCollectionWSModel collectionModel);

    /**
     * Converts HAL Model into a quality detail model.
     *
     * @param serverModel The model received by the server.
     * @return A quality detail model.
     */
    QualityDetailResponse getQualityDetailResponse(HALWSModel serverModel);
}