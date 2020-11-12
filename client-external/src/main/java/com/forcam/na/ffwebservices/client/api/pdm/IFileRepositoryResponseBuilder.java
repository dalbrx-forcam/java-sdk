////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 26.10.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.pdm;

import com.forcam.na.ffwebservices.client.api.HALCollectionWSModel;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.client.api.pagination.response.CollectionResponse;
import com.forcam.na.ffwebservices.client.api.pagination.request.PaginationRequest;
import com.forcam.na.ffwebservices.model.pdm.FileRepositoryDocumentResponse;
import com.forcam.na.ffwebservices.model.pdm.FileRepositoryFolderResponse;

/**
 * File repository response builder.
 */
public interface IFileRepositoryResponseBuilder {

    /**
     * Converts HAL collection model to a collection response of file repository folder responses.
     *
     * @param request         The pagination request.
     * @param collectionModel The HAL collection model.
     * @return The collection response of file repository folder responses.
     */
    CollectionResponse<FileRepositoryFolderResponse> getFileRepositoryFolderCollectionResponse(PaginationRequest request, HALCollectionWSModel collectionModel);

    /**
     * Converts a HAL model to a file repository folder response.
     *
     * @param model The HAL model.
     * @return The file repository folder response.
     */
    FileRepositoryFolderResponse getFileRepositoryFolderResponse(HALWSModel model);

    /**
     * Converts HAL collection model to a collection response of file repository document responses.
     *
     * @param request         The pagination request.
     * @param collectionModel The HAL collection model.
     * @return The collection response of file repository document responses.
     */
    CollectionResponse<FileRepositoryDocumentResponse> getFileRepositoryDocumentCollectionResponse(PaginationRequest request,
                                                                                                   HALCollectionWSModel collectionModel);

    /**
     * Converts a HAL model to a file repository document response.
     *
     * @param model The HAL model.
     * @return The file repository document response.
     */
    FileRepositoryDocumentResponse getFileRepositoryDocumentResponse(HALWSModel model);
}