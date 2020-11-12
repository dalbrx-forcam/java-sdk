////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 26.10.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.pdm;

import com.forcam.na.ffwebservices.client.api.exception.ForceAPIException;
import com.forcam.na.ffwebservices.client.api.pagination.response.Page;
import com.forcam.na.ffwebservices.client.api.pdm.request.*;
import com.forcam.na.ffwebservices.model.pdm.CreateFileRepositoryFolderWSPropertiesModel;
import com.forcam.na.ffwebservices.model.pdm.FileRepositoryDocumentResponse;
import com.forcam.na.ffwebservices.model.pdm.FileRepositoryFolderResponse;

/**
 * REST client for file repository.
 */
public interface IFileRepositoryClient {

    /**
     * Sends a request to the server and creates a file repository folder..
     *
     * @param folderProperties The folder properties.
     * @return The created file repository folder response.
     * @throws ForceAPIException When unable to save new file repository folder.
     */
    FileRepositoryFolderResponse createFolder(CreateFileRepositoryFolderWSPropertiesModel folderProperties) throws ForceAPIException;

    /**
     * Sends a request to the server and deletes a file repository folder by ID.
     *
     * @param folderId The file repository folder ID.
     * @throws ForceAPIException When unable to delete the file repository folder.
     */
    void deleteFolder(String folderId) throws ForceAPIException;

    /**
     * Sends a request to the server and gets a file repository folder response.
     *
     * @param request The request parameter.
     * @return The file repository folder response.
     * @throws ForceAPIException When unable to get file repository folder by ID.
     */
    FileRepositoryFolderResponse getFolder(GetFolderRequest request) throws ForceAPIException;

    /**
     * Sends a request to the server and gets all filtered file repository folders.
     *
     * @param request The request parameter.
     * @return Page of file repository folder responses.
     * @throws ForceAPIException When unable to get file repository folders.
     */
    Page<FileRepositoryFolderResponse> getFolders(GetFileRepositoryFoldersRequest request) throws ForceAPIException;

    /**
     * Sends a request to the server and gets all documents of a file repository folder.
     *
     * @param request The request parameter.
     * @return Page of file repository document responses.
     * @throws ForceAPIException When unable to get file repository documents of a folder.
     */
    Page<FileRepositoryDocumentResponse> getFolderDocuments(GetFolderDocumentsRequest request) throws ForceAPIException;

    /**
     * Senda a request to the server and creates a new file repository document of a folder.
     *
     * @param request The request parameter.
     * @return The created file repository document response.
     * @throws ForceAPIException When unable to save new file repository document.
     */
    FileRepositoryDocumentResponse createDocument(CreateFileRepositoryDocumentRequest request) throws ForceAPIException;

    /**
     * Sends a request to the server and updates the file of a file repository document.
     *
     * @param request The request parameter.
     * @return The updated file repository document response.
     * @throws ForceAPIException When unable to update file repository document file.
     */
    FileRepositoryDocumentResponse updateDocumentFile(UpdateDocumentFileRequest request) throws ForceAPIException;

    /**
     * Sends a request to the server and gets the file repository document file.
     *
     * @param documentId The file repository document ID.
     * @return The document file.
     * @throws ForceAPIException When unable to get document file.
     */
    byte[] getDocumentFile(String documentId) throws ForceAPIException;

    /**
     * Sends a request to the server and get a file repository document by ID.
     *
     * @param request The request parameter.
     * @return The file repository document response.
     * @throws ForceAPIException When unable to get file repository document.
     */
    FileRepositoryDocumentResponse getDocument(GetDocumentRequest request) throws ForceAPIException;

    /**
     * Sends a request to the server and deletes file repository document by ID.
     *
     * @param documentId The file repository document ID.
     * @throws ForceAPIException When unable to delete file repository document.
     */
    void deleteDocument(String documentId) throws ForceAPIException;

    /**
     * Sends a request to the server and gets all documents.
     *
     * @param request The request parameter.
     * @return Page of file repository document responses.
     * @throws ForceAPIException When unable to get file repository documents.
     */
    Page<FileRepositoryDocumentResponse> getDocuments(GetDocumentsRequest request) throws ForceAPIException;
}