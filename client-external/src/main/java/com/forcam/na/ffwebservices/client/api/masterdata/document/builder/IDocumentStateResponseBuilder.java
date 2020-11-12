////////////////////////////////////////////////////////////////////////////////
//
// Created by DZeise on 09.03.2020.
//
// Copyright (c) 2006 - 2020 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.masterdata.document.builder;

import com.forcam.na.ffwebservices.client.api.HALCollectionWSModel;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.client.api.pagination.response.CollectionResponse;
import com.forcam.na.ffwebservices.client.api.masterdata.document.request.GetDocumentStateCollectionRequest;
import com.forcam.na.ffwebservices.model.statusdefinition.DocumentStateResponse;

/**
 * Contains methods for building responses for document states.
 */
public interface IDocumentStateResponseBuilder {

    String DOCUMENT_STATES_KEY = "documentStates";

    /**
     * Transforms a collection model to a document state collection response.
     *
     * @param request         The request.
     * @param collectionModel A collection model.
     * @return A document state collection response.
     */
    CollectionResponse<DocumentStateResponse> getDocumentStateCollectionResponse(GetDocumentStateCollectionRequest request,
                                                                                 HALCollectionWSModel collectionModel);

    /**
     * Converts HAL Model into a document state model.
     *
     * @param serverModel The model received by the server.
     * @return A document state model.
     */
    DocumentStateResponse getDocumentStateResponse(HALWSModel serverModel);

}
