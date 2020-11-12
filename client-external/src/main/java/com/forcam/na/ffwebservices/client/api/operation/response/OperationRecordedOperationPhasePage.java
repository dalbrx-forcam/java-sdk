////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 13.09.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.operation.response;

import com.forcam.na.ffwebservices.client.api.pagination.response.SpecificPage;
import com.forcam.na.ffwebservices.model.operatingstate.OperationPhaseRecordPropertiesWSModel;

import java.lang.reflect.Method;

/**
 * Page containing recorded operation phases.
 */
public class OperationRecordedOperationPhasePage extends SpecificPage<OperationPhaseRecordPropertiesWSModel, OperationRecordedOperationPhasesResponse> {

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
    public OperationRecordedOperationPhasePage(Object client, Method clientMethod, OperationRecordedOperationPhasesResponse response) {
        super(client, clientMethod, response);
    }

}
