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
import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.util.Date;

/**
 * An interface with methods for creating calls that can be sent to the server.
 */
public interface FileRepositoryDocumentEndpoint {

    /**
     * Creates a call that can be sent to the server and uploads a file corresponding to a document.
     *
     * @param file       The file to upload.
     * @param editor     The editor.
     * @param fileName   The file name.
     * @param documentId The document ID.
     * @return A call that can be sent to the server.
     */
    @Multipart
    @PUT("fileRepository/documents/{documentId}/file")
    Call<HALWSModel> updateDocumentFile(
        @Path("documentId")
            String documentId,
        @Query("fileName")
            String fileName,
        @Query("editor")
            String editor,
        @Part
            MultipartBody.Part file);

    /**
     * Creates a call that can be sent to the server and download the file corresponding to the document.
     *
     * @param documentId The document ID.
     * @return A call that can be sent to the server.
     */
    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @GET("fileRepository/documents/{documentId}/file")
    Call<byte[]> getDocumentFile(
        @Path("documentId")
            String documentId);

    /**
     * Creates a call that can be sent to the server and gets a document by ID.
     *
     * @param documentId The document ID.
     * @param embed      The resources which shall be embedded.
     * @return A call that can be sent to the server.
     */
    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @GET("fileRepository/documents/{documentId}")
    Call<HALWSModel> getDocument(
        @Path("documentId")
            String documentId,
        @Query("embed")
            String embed);

    /**
     * Creates a call that can be sent to the server and deletes a document by ID.
     *
     * @param documentId The document ID.
     * @return A call that can be sent to the server.
     */
    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @DELETE("fileRepository/documents/{documentId}")
    Call<Void> deleteDocument(
        @Path("documentId")
            String documentId);

    /**
     * Creates a call that can be sent to the server and uploads a file corresponding to a document.
     *
     * @param limit               The limit.
     * @param paginationDirection The pagination direction.
     * @param paginationTimestamp The pagination timestamp.
     * @param embed               The resources which shall be embedded.
     * @return A call that can be sent to the server.
     */
    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @GET("fileRepository/documents")
    Call<HALCollectionWSModel> getDocuments(
        @Query("limit")
            int limit,
        @Query("paginationDirection")
            PaginationDirection paginationDirection,
        @Query("paginationTimestamp")
            Date paginationTimestamp,
        @Query("embed")
            String embed);
}