////////////////////////////////////////////////////////////////////////////////
//
// Created by DZeise on 09.03.2020.
//
// Copyright (c) 2006 - 2020 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.masterdata.document.enpoint;

import com.forcam.na.ffwebservices.client.api.HALCollectionWSModel;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.model.IPathParts;
import com.forcam.na.ffwebservices.model.IRequestAndQueryParams;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface DocumentStateEndpoint {

    /**
     * Creates a call that can be sent to the server.
     *
     * @param limit  The limit.
     * @param offset The offset.
     * @param embed  The resources which shall be embedded.
     * @return A call that can be sent to the server.
     */
    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @GET(IPathParts.MASTER_DATA + "/" + IPathParts.DOCUMENT_STATES)
    Call<HALCollectionWSModel> getDocumentStates(
        @Query(IRequestAndQueryParams.LIMIT)
            int limit,
        @Query(IRequestAndQueryParams.OFFSET)
            int offset,
        @Query(IRequestAndQueryParams.EMBED)
            String embed);

    /**
     * Creates a call that can be sent to the server.
     *
     * @param documentStateId The document state ID.
     * @param embed           The resources which shall be embedded.
     * @return A call that can be sent to the server.
     */
    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @GET(IPathParts.MASTER_DATA + "/" + IPathParts.DOCUMENT_STATES + "/{" + IRequestAndQueryParams.DOCUMENT_STATE_ID + "}")
    Call<HALWSModel> getDocumentState(
        @Path(IRequestAndQueryParams.DOCUMENT_STATE_ID)
            String documentStateId,
        @Query(IRequestAndQueryParams.EMBED)
            String embed);

}
