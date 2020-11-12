////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 26.10.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.pdm;

import com.forcam.na.ffwebservices.client.api.AbstractClient;
import com.forcam.na.ffwebservices.client.api.HALCollectionWSModel;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.client.api.exception.ForceAPIException;
import com.forcam.na.ffwebservices.client.api.pagination.response.CollectionResponse;
import com.forcam.na.ffwebservices.client.api.pagination.response.Page;
import com.forcam.na.ffwebservices.client.api.pdm.request.*;
import com.forcam.na.ffwebservices.model.pdm.CreateFileRepositoryFolderWSPropertiesModel;
import com.forcam.na.ffwebservices.model.pdm.FileRepositoryDocumentResponse;
import com.forcam.na.ffwebservices.model.pdm.FileRepositoryFolderResponse;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;

import javax.inject.Inject;
import java.lang.reflect.Method;

/**
 * REST client for file repository.
 */
public class FileRepositoryClient extends AbstractClient implements IFileRepositoryClient {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The file repository endpoint. */
    private final FileRepositoryEndpoint mFileRepositoryEndpoint;

    /** The file repository endpoint. */
    private final FileRepositoryDocumentEndpoint mFileRepositoryDocumentEndpoint;

    /** The file repository response builder. */
    private final IFileRepositoryResponseBuilder mFileRepositoryResponseBuilder;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates new instance.
     *
     * @param fileRepositoryEndpoint         The file repository endpoint.
     * @param fileRepositoryDocumentEndpoint The file repository document endpoint.
     * @param fileRepositoryResponseBuilder  File repository response builder.
     */
    @Inject
    public FileRepositoryClient(FileRepositoryEndpoint fileRepositoryEndpoint, FileRepositoryDocumentEndpoint fileRepositoryDocumentEndpoint,
                                FileRepositoryResponseBuilder fileRepositoryResponseBuilder) {
        mFileRepositoryEndpoint = fileRepositoryEndpoint;
        mFileRepositoryDocumentEndpoint = fileRepositoryDocumentEndpoint;
        mFileRepositoryResponseBuilder = fileRepositoryResponseBuilder;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public FileRepositoryFolderResponse createFolder(CreateFileRepositoryFolderWSPropertiesModel folderProperties) throws ForceAPIException {
        final Call<HALWSModel> call = mFileRepositoryEndpoint.createFolder(folderProperties);
        final HALWSModel responseModel = this.getResponseModel(null, call);
        return mFileRepositoryResponseBuilder.getFileRepositoryFolderResponse(responseModel);
    }

    @Override
    public void deleteFolder(String folderId) throws ForceAPIException {
        final Call<Void> call = mFileRepositoryEndpoint.deleteFolder(folderId);
        this.executeCall(folderId, call);
    }

    @Override
    public FileRepositoryFolderResponse getFolder(GetFolderRequest request) throws ForceAPIException {
        final Call<HALWSModel> call = mFileRepositoryEndpoint.getFolder(request.getFolderId(),
                                                                        request
                                                                            .embed()
                                                                            .toString());
        final HALWSModel responseModel = this.getResponseModel(request, call);
        return mFileRepositoryResponseBuilder.getFileRepositoryFolderResponse(responseModel);
    }

    @Override
    public Page<FileRepositoryFolderResponse> getFolders(GetFileRepositoryFoldersRequest request) throws ForceAPIException {
        final Call<HALCollectionWSModel> call = mFileRepositoryEndpoint.getFolders(request.getName(),
                                                                                   request.getMaterialNumber(),
                                                                                   request.getWorkplaceNumber(),
                                                                                   request.getLimit(),
                                                                                   request.getPaginationDirection(),
                                                                                   request.getPaginationTimestamp(),
                                                                                   request
                                                                                       .embed()
                                                                                       .toString());
        final HALCollectionWSModel responseModel = this.getResponseModel(request, call);
        final CollectionResponse<FileRepositoryFolderResponse> response = mFileRepositoryResponseBuilder.getFileRepositoryFolderCollectionResponse(request,
                                                                                                                                                   responseModel);

        final Method m = new Object() {}
            .getClass()
            .getEnclosingMethod();
        return new Page<>(this, m, response);
    }

    @Override
    public Page<FileRepositoryDocumentResponse> getFolderDocuments(GetFolderDocumentsRequest request) throws ForceAPIException {
        final Call<HALCollectionWSModel> call = mFileRepositoryEndpoint.getDocuments(request.getFolderId(),
                                                                                     request.getLimit(),
                                                                                     request.getPaginationDirection(),
                                                                                     request.getPaginationTimestamp(),
                                                                                     request
                                                                                         .embed()
                                                                                         .toString());
        final HALCollectionWSModel responseModel = this.getResponseModel(request, call);
        final CollectionResponse<FileRepositoryDocumentResponse> response = mFileRepositoryResponseBuilder.getFileRepositoryDocumentCollectionResponse(request,
                                                                                                                                                       responseModel);

        final Method m = new Object() {}
            .getClass()
            .getEnclosingMethod();
        return new Page<>(this, m, response);
    }

    @Override
    public FileRepositoryDocumentResponse createDocument(CreateFileRepositoryDocumentRequest request) throws ForceAPIException {
        final Call<HALWSModel> call = mFileRepositoryEndpoint.createDocument(request.getFolderId(), request.getDocumentProperties());
        final HALWSModel responseModel = this.getResponseModel(request, call);
        return mFileRepositoryResponseBuilder.getFileRepositoryDocumentResponse(responseModel);
    }

    @Override
    public FileRepositoryDocumentResponse updateDocumentFile(UpdateDocumentFileRequest request) throws ForceAPIException {
        MultipartBody.Part filePart = MultipartBody.Part.createFormData("file",
                                                                        request
                                                                            .getFileData()
                                                                            .getFile()
                                                                            .getName(),
                                                                        RequestBody.create(MediaType.parse(request
                                                                                                               .getFileData()
                                                                                                               .getMediaType()),
                                                                                           request
                                                                                               .getFileData()
                                                                                               .getFile()));
        final Call<HALWSModel> call = mFileRepositoryDocumentEndpoint.updateDocumentFile(request.getDocumentId(),
                                                                                         request.getFileName(),
                                                                                         request.getEditor(),
                                                                                         filePart);
        final HALWSModel responseModel = this.getResponseModel(request, call);
        return mFileRepositoryResponseBuilder.getFileRepositoryDocumentResponse(responseModel);
    }

    @Override
    public byte[] getDocumentFile(String documentId) throws ForceAPIException {
        final Call<byte[]> call = mFileRepositoryDocumentEndpoint.getDocumentFile(documentId);
        return this.executeCall(documentId, call);
    }

    @Override
    public FileRepositoryDocumentResponse getDocument(GetDocumentRequest request) throws ForceAPIException {
        final Call<HALWSModel> call = mFileRepositoryDocumentEndpoint.getDocument(request.getDocumentId(),
                                                                                  request
                                                                                      .embed()
                                                                                      .toString());
        final HALWSModel responseModel = this.getResponseModel(request, call);
        return mFileRepositoryResponseBuilder.getFileRepositoryDocumentResponse(responseModel);
    }

    @Override
    public void deleteDocument(String documentId) throws ForceAPIException {
        final Call<Void> call = mFileRepositoryDocumentEndpoint.deleteDocument(documentId);
        this.executeCall(documentId, call);
    }

    @Override
    public Page<FileRepositoryDocumentResponse> getDocuments(GetDocumentsRequest request) throws ForceAPIException {
        final Call<HALCollectionWSModel> call = mFileRepositoryDocumentEndpoint.getDocuments(request.getLimit(),
                                                                                             request.getPaginationDirection(),
                                                                                             request.getPaginationTimestamp(),
                                                                                             request
                                                                                                 .embed()
                                                                                                 .toString());
        final HALCollectionWSModel responseModel = this.getResponseModel(request, call);
        final CollectionResponse<FileRepositoryDocumentResponse> response = mFileRepositoryResponseBuilder.getFileRepositoryDocumentCollectionResponse(request,
                                                                                                                                                       responseModel);

        final Method m = new Object() {}
            .getClass()
            .getEnclosingMethod();
        return new Page<>(this, m, response);
    }
}