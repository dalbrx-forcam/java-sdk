////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 13.09.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.operation.response;

import com.forcam.na.ffwebservices.client.api.pagination.response.SpecificPage;
import com.forcam.na.ffwebservices.model.recordedoutputquantities.RecordedOutputQuantitiesWSModel;

import java.lang.reflect.Method;

/**
 * Page containing operation recorded output quantities.
 */
public class OperationRecordedOutputQuantitiesPage extends SpecificPage<RecordedOutputQuantitiesWSModel, OperationRecordedOutputQuantitiesResponse> {

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     *
     * @param client       The client.
     * @param clientMethod The client method.
     * @param response     The response.
     */
    public OperationRecordedOutputQuantitiesPage(Object client, Method clientMethod, OperationRecordedOutputQuantitiesResponse response) {
        super(client, clientMethod, response);
    }

}
