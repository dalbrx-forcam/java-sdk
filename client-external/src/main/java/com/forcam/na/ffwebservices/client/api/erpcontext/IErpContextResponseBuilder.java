////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 20.12.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.erpcontext;

import com.forcam.na.ffwebservices.client.api.erpcontext.request.GetErpContextsRequest;
import com.forcam.na.ffwebservices.client.api.pagination.response.CollectionResponse;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.client.api.HALCollectionWSModel;
import com.forcam.na.ffwebservices.model.erpcontext.ErpContextResponse;

/**
 * Contains methods for building responses for ERP contexts.
 */
public interface IErpContextResponseBuilder {

    /**
     * Transforms a collection model to an ERP context collection response.
     *
     * @param request         The request.
     * @param collectionModel A collection model.
     * @return An ERP context collection response.
     */
    CollectionResponse<ErpContextResponse> getErpContextCollectionResponse(GetErpContextsRequest request, HALCollectionWSModel collectionModel);

    /**
     * Converts HAL model to an ERP context model.
     *
     * @param serverModel The server model.
     * @return An ERP context model.
     */
    ErpContextResponse getErpContextResponse(HALWSModel serverModel);
}