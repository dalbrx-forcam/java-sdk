////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 05.02.2020.
//
// Copyright (c) 2006 - 2020 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.erp;

import com.forcam.na.ffwebservices.model.erp.IErpPaths;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * ERP Endpoint
 */
public interface ERPEndpoint {

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Headers("Content-Type: application/xml")
    @POST(IErpPaths.ERP_DATA + "/orders")
    Call<Void> createERPOrder(
        @Body
            RequestBody xml);

    @Headers("Content-Type: application/xml")
    @POST(IErpPaths.ERP_DATA + "/staffMembers")
    Call<Void> createERPStaffMembers(
        @Body
            RequestBody body);
}
