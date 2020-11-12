////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 26.10.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.pdm;

import com.forcam.na.ffwebservices.client.api.AbstractResponseBuilder;
import com.forcam.na.ffwebservices.client.api.HALCollectionWSModel;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.client.api.pagination.request.PaginationRequest;
import com.forcam.na.ffwebservices.client.api.pagination.response.CollectionResponse;
import com.forcam.na.ffwebservices.client.statusdefinition.StatusDefinitionLinkModelBuilder;
import com.forcam.na.ffwebservices.model.LinkEmbeddedWSModel;
import com.forcam.na.ffwebservices.model.pdm.DocumentEmbed;
import com.forcam.na.ffwebservices.model.pdm.FileRepositoryDocumentResponse;
import com.forcam.na.ffwebservices.model.pdm.FileRepositoryDocumentWSModelProperties;
import com.forcam.na.ffwebservices.model.pdm.FileRepositoryFolderResponse;
import com.forcam.na.ffwebservices.model.pdm.FileRepositoryFolderWSPropertiesModel;
import com.forcam.na.ffwebservices.model.pdm.FolderEmbed;
import com.forcam.na.ffwebservices.model.statusdefinition.StatusDefinitionPropertiesWSModel;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * File repository response builder.
 */
public class FileRepositoryResponseBuilder extends AbstractResponseBuilder implements IFileRepositoryResponseBuilder {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The link model builder of a status definition. */
    private final StatusDefinitionLinkModelBuilder mStatusDefinitionLinkModelBuilder;

    /** File repository folder link model builder. */
    private final FileRepositoryFolderLinkModelBuilder mFileRepositoryFolderLinkModelBuilder;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    @Inject
    public FileRepositoryResponseBuilder(StatusDefinitionLinkModelBuilder statusDefinitionLinkModelBuilder,
                                         FileRepositoryFolderLinkModelBuilder fileRepositoryFolderLinkModelBuilder) {
        mStatusDefinitionLinkModelBuilder = statusDefinitionLinkModelBuilder;
        mFileRepositoryFolderLinkModelBuilder = fileRepositoryFolderLinkModelBuilder;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public CollectionResponse<FileRepositoryFolderResponse> getFileRepositoryFolderCollectionResponse(PaginationRequest request,
                                                                                                      HALCollectionWSModel collectionModel) {
        final CollectionResponse<FileRepositoryFolderResponse> collectionResponse = new CollectionResponse<>(request);
        this.initializeCollectionResponse(collectionModel, collectionResponse);

        final Map<String, List<HALWSModel>> embedded = collectionModel.getEmbedded();
        final List<HALWSModel> folders = embedded.get("folders");

        final List<FileRepositoryFolderResponse> folderResponses = folders
            .stream()
            .map(this::getFileRepositoryFolderResponse)
            .collect(Collectors.toList());

        collectionResponse.setEmbedded(folderResponses);
        return collectionResponse;
    }

    @Override
    public FileRepositoryFolderResponse getFileRepositoryFolderResponse(HALWSModel model) {
        final FileRepositoryFolderResponse response = new FileRepositoryFolderResponse();
        response.setProperties(mMapper.convertValue(model.getProperties(), FileRepositoryFolderWSPropertiesModel.class));

        final LinkEmbeddedWSModel<StatusDefinitionPropertiesWSModel> ncState = mStatusDefinitionLinkModelBuilder.buildLinkModel(model, FolderEmbed.NC_STATE);
        response.setNcState(ncState);

        final LinkEmbeddedWSModel<Object> selfLink = this.createSelfLinkModel(model);
        response.setSelf(selfLink);

        return response;
    }

    @Override
    public CollectionResponse<FileRepositoryDocumentResponse> getFileRepositoryDocumentCollectionResponse(PaginationRequest request,
                                                                                                          HALCollectionWSModel collectionModel) {
        final CollectionResponse<FileRepositoryDocumentResponse> collectionResponse = new CollectionResponse<>(request);
        this.initializeCollectionResponse(collectionModel, collectionResponse);

        final Map<String, List<HALWSModel>> embedded = collectionModel.getEmbedded();
        final List<HALWSModel> documents = embedded.get("documents");

        final List<FileRepositoryDocumentResponse> documentResponses = documents
            .stream()
            .map(this::getFileRepositoryDocumentResponse)
            .collect(Collectors.toList());

        collectionResponse.setEmbedded(documentResponses);
        return collectionResponse;
    }

    @Override
    public FileRepositoryDocumentResponse getFileRepositoryDocumentResponse(HALWSModel model) {
        final FileRepositoryDocumentResponse response = new FileRepositoryDocumentResponse();
        response.setProperties(mMapper.convertValue(model.getProperties(), FileRepositoryDocumentWSModelProperties.class));

        final LinkEmbeddedWSModel<StatusDefinitionPropertiesWSModel> ncState = mStatusDefinitionLinkModelBuilder.buildLinkModel(model, DocumentEmbed.NC_STATE);
        response.setNcState(ncState);

        final List<LinkEmbeddedWSModel<FileRepositoryFolderWSPropertiesModel>> documentFolders = mFileRepositoryFolderLinkModelBuilder.buildListOfLinkModels(
            model,
            DocumentEmbed.DOCUMENT_FOLDERS);
        response.setDocumentFolders(documentFolders);

        final LinkEmbeddedWSModel<Object> selfLink = this.createSelfLinkModel(model);
        response.setSelf(selfLink);

        return response;
    }
}