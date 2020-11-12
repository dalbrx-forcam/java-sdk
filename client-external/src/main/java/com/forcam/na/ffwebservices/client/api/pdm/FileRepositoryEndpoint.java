////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 26.10.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.pdm;

import com.forcam.na.common.webserviceaccess.requestparams.PaginationDirection;
import com.forcam.na.ffwebservices.client.api.HALCollectionWSModel;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.model.IRequestAndQueryParams;
import com.forcam.na.ffwebservices.model.pdm.CreateFileRepositoryDocumentWSModelProperties;
import com.forcam.na.ffwebservices.model.pdm.CreateFileRepositoryFolderWSPropertiesModel;
import com.forcam.na.ffwebservices.model.pdm.IFileRepositoryPaths;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.util.Date;

/**
 * An interface with methods for creating calls that can be sent to the server.
 */
public interface FileRepositoryEndpoint {

    /**
     * Creates a call that can be sent to the server and creates a file repository folder.
     *
     * @param folderProperties The folder properties.
     * @return A call that can be sent to the server.
     */
    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @POST(IFileRepositoryPaths.FILE_REPOSITORY + "/" + IFileRepositoryPaths.FOLDERS)
    Call<HALWSModel> createFolder(
        @Body
            CreateFileRepositoryFolderWSPropertiesModel folderProperties);

    /**
     * Creates a call that can be sent to the server and deletes a file repository folder by ID.
     *
     * @param folderId The folder ID.
     * @return A call that can be sent to the server.
     */
    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @DELETE(IFileRepositoryPaths.FILE_REPOSITORY + "/" +IFileRepositoryPaths.FOLDERS +  "/{" + IRequestAndQueryParams.FOLDER_ID + "}")
    Call<Void> deleteFolder(
        @Path(IRequestAndQueryParams.FOLDER_ID)
            String folderId);

    /**
     * Creates a call that can be sent to the server and gets a file repository folder by ID.
     *
     * @param folderId The folder ID.
     * @param embed    The resources which shall be embedded.
     * @return A call that can be sent to the server.
     */
    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @GET(IFileRepositoryPaths.FILE_REPOSITORY + "/" +IFileRepositoryPaths.FOLDERS +  "/{" + IRequestAndQueryParams.FOLDER_ID + "}")
    Call<HALWSModel> getFolder(
        @Path(IRequestAndQueryParams.FOLDER_ID)
            String folderId,
        @Query(IRequestAndQueryParams.EMBED)
            String embed);

    /**
     * Creates a call that can be sent to the server and gets a file repository folder by ID.
     *
     * @param name                The folder name.
     * @param workplaceNumber     The workplace number.
     * @param materialNumber      The material number.
     * @param limit               The limit.
     * @param paginationDirection The pagination direction.
     * @param paginationTimestamp The pagination timestamp.
     * @param embed               The resources which shall be embedded.
     * @return A call that can be sent to the server.
     */
    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @GET(IFileRepositoryPaths.FILE_REPOSITORY + "/" + IFileRepositoryPaths.FOLDERS )
    Call<HALCollectionWSModel> getFolders(
        @Query(IRequestAndQueryParams.NAME)
            String name,
        @Query(IRequestAndQueryParams.MATERIAL_NUMBER)
            String materialNumber,
        @Query(IRequestAndQueryParams.WORKPLACE_NUMBER)
            String workplaceNumber,
        @Query(IRequestAndQueryParams.LIMIT)
            int limit,
        @Query(IRequestAndQueryParams.PAGINATION_DIRECTION)
            PaginationDirection paginationDirection,
        @Query(IRequestAndQueryParams.PAGINATION_TIMESTAMP)
            Date paginationTimestamp,
        @Query(IRequestAndQueryParams.EMBED)
            String embed);

    /**
     * Creates a call that can be sent to the server and gets all file repository documents of a folder.
     *
     * @param folderId            The folder ID.
     * @param limit               The limit.
     * @param paginationDirection The pagination direction.
     * @param paginationTimestamp The pagination timestamp.
     * @param embed               The resources which shall be embedded.
     * @return A call that can be sent to the server.
     */
    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @GET(IFileRepositoryPaths.FILE_REPOSITORY + "/" +IFileRepositoryPaths.FOLDERS + "/{"+ IRequestAndQueryParams.FOLDER_ID +"}/" + IFileRepositoryPaths.DOCUMENTS)
    Call<HALCollectionWSModel> getDocuments(
        @Path(IRequestAndQueryParams.FOLDER_ID)
            String folderId,
        @Query(IRequestAndQueryParams.LIMIT)
            int limit,
        @Query(IRequestAndQueryParams.PAGINATION_DIRECTION)
            PaginationDirection paginationDirection,
        @Query(IRequestAndQueryParams.PAGINATION_TIMESTAMP)
            Date paginationTimestamp,
        @Query(IRequestAndQueryParams.EMBED)
            String embed);

    /**
     * Creates a call that can be sent to the server and saves a file repository document of a folder.
     *
     * @param folderId           The folder ID.
     * @param documentProperties The properties of the document.
     * @return A call that can be sent to the server.
     */
    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @POST(IFileRepositoryPaths.FILE_REPOSITORY + "/" +IFileRepositoryPaths.FOLDERS + "/{"+ IRequestAndQueryParams.FOLDER_ID +"}/" + IFileRepositoryPaths.DOCUMENTS)
    Call<HALWSModel> createDocument(
        @Path(IRequestAndQueryParams.FOLDER_ID)
            String folderId,
        @Body
            CreateFileRepositoryDocumentWSModelProperties documentProperties);
}