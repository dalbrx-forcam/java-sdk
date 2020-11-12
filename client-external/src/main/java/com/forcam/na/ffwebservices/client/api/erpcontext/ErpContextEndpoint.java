////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 20.12.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.erpcontext;

import com.forcam.na.ffwebservices.client.api.HALCollectionWSModel;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.model.IRequestAndQueryParams;
import com.forcam.na.ffwebservices.model.erpcontext.ERPContextType;
import com.forcam.na.ffwebservices.model.erpcontext.IErpContextPaths;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * An interface with methods for creating calls that can be sent to the server.
 */
public interface ErpContextEndpoint {

    /**
     * Creates a call that can be sent to the server.
     *
     * @param identifier1    The first identifier.
     * @param identifier2    The second identifier.
     * @param identifier3    The third identifier.
     * @param erpSystem      The ERP system identifier.
     * @param erpContextType The ERP context type.
     * @param limit          The limit.
     * @param offset         The offset.
     * @return A call that can be sent to the server.
     */
    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @GET(IErpContextPaths.ERP_CONTEXTS)
    Call<HALCollectionWSModel> getErpContexts(
        @Query(IRequestAndQueryParams.IDENTIFIER1)
            String identifier1,
        @Query(IRequestAndQueryParams.IDENTIFIER2)
            String identifier2,
        @Query(IRequestAndQueryParams.IDENTIFIER3)
            String identifier3,
        @Query(IRequestAndQueryParams.ERP_SYSTEM)
            String erpSystem,
        @Query(IRequestAndQueryParams.ERP_CONTEXT_TYPE)
            ERPContextType erpContextType,
        @Query(IRequestAndQueryParams.LIMIT)
            int limit,
        @Query(IRequestAndQueryParams.OFFSET)
            int offset);

    /**
     * Creates a call that can be sent to the server.
     *
     * @param erpContextId The ERP context Id.
     * @return A call that can be sent to the server.
     */
    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @GET(IErpContextPaths.ERP_CONTEXTS + "/{" + IRequestAndQueryParams.ERP_CONTEXT_ID + "}")
    Call<HALWSModel> getErpContext(
        @Path(IRequestAndQueryParams.ERP_CONTEXT_ID)
            String erpContextId);
}