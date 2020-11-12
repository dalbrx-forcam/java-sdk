////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 20.12.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.literal;

import com.forcam.na.ffwebservices.client.api.HALCollectionWSModel;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.model.IRequestAndQueryParams;
import com.forcam.na.ffwebservices.model.literal.ILiteralPaths;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * An interface with methods for creating calls that can be sent to the server.
 */
public interface LiteralEndpoint {

    /**
     * Creates a call that can be sent to the server.
     *
     * @param type        The literal type.
     * @param identifier1 The first literal identifier.
     * @param identifier2 The second literal identifier.
     * @param identifier3 The third literal identifier.
     * @param limit       The limit.
     * @param offset      The offset.
     * @return A call that can be sent to the server.
     */
    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @GET(ILiteralPaths.LITERALS)
    Call<HALCollectionWSModel> getLiterals(
        @Query(IRequestAndQueryParams.TYPE)        String type,
        @Query(IRequestAndQueryParams.IDENTIFIER1) String identifier1,
        @Query(IRequestAndQueryParams.IDENTIFIER2) String identifier2,
        @Query(IRequestAndQueryParams.IDENTIFIER3) String identifier3,
        @Query(IRequestAndQueryParams.LIMIT)       int limit,
        @Query(IRequestAndQueryParams.OFFSET)      int offset);

    /**
     * Creates a call that can be sent to the server.
     *
     * @param literalId The literal Id.
     * @return A call that can be sent to the server.
     */
    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @GET(ILiteralPaths.LITERALS + "/{" + IRequestAndQueryParams.LITERAL_ID + "}")
    Call<HALWSModel> getLiteral(
        @Path(IRequestAndQueryParams.LITERAL_ID) String literalId);
}