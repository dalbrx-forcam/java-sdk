////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 13.09.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.workplace.response;

import com.forcam.na.ffwebservices.client.api.pagination.response.SpecificPage;
import com.forcam.na.ffwebservices.model.operatingstate.OperationPhaseRecordPropertiesWSModel;

import java.lang.reflect.Method;

/**
 * Page containing workplace recorded operation phases.
 */
public class WorkplaceRecordedOperationPhasesPage extends SpecificPage<OperationPhaseRecordPropertiesWSModel, WorkplaceRecordedOperationPhasesResponse> {

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     *
     * @param client   The client.
     * @param m        The client method.
     * @param response The response.
     */
    public WorkplaceRecordedOperationPhasesPage(Object client, Method m, WorkplaceRecordedOperationPhasesResponse response) {super(client, m, response);}

}
