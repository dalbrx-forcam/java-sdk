////////////////////////////////////////////////////////////////////////////////
//
// Created by DSchulz on 25.02.2020.
//
// Copyright (c) 2006 - 2020 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.caq;

import com.forcam.na.ffwebservices.model.IRequestAndQueryParams;
import retrofit2.Call;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

import static com.forcam.na.ffwebservices.model.caq.CAQSwaggerExplanationConstants.COMPLETE_PATH_INSPECTION_READY;

/**
 * Inspection client endpoint.
 */
public interface InspectionEndpoint {

    /**
     * Inspection ready.
     *
     * @param inspectionId The inspection id.
     * @return Call object.
     */
    @Headers({"Content-Type: application/json"} )
    @POST(COMPLETE_PATH_INSPECTION_READY)
    Call<Void> inspectionReady(
        @Path(IRequestAndQueryParams.INSPECTION_ID)
            String inspectionId);
}
