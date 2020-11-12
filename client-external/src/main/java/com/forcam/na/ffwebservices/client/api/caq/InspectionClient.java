////////////////////////////////////////////////////////////////////////////////
//
// Created by DSchulz on 25.02.2020.
//
// Copyright (c) 2006 - 2020 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.caq;

import com.forcam.na.ffwebservices.client.api.AbstractClient;
import com.forcam.na.ffwebservices.client.api.exception.ForceAPIException;
import retrofit2.Call;

/**
 * client for inspections
 */
public class InspectionClient extends AbstractClient implements IInspectionClient {

    // ------------------------------------------------------------------------
    // members
    // -----------------------------------------------------------------------

    /** The inspection endpoint. */
    private InspectionEndpoint mInspectionEndpoint;

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public void inspectionReady(PostInspectionRedyRequest request) throws ForceAPIException {
        final Call<Void> call = mInspectionEndpoint.inspectionReady(request.getInspectionId());
        this.getResponseModel(request, call);
    }
}
