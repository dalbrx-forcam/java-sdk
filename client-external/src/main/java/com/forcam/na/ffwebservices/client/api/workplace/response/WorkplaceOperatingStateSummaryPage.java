////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 13.09.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.workplace.response;

import com.forcam.na.ffwebservices.client.api.pagination.response.SpecificPage;
import com.forcam.na.ffwebservices.model.operatingstate.OperatingStateSummaryWSModel;

import java.lang.reflect.Method;

/**
 * Page containing workplace operating state summaries.
 */
public class WorkplaceOperatingStateSummaryPage extends SpecificPage<OperatingStateSummaryWSModel, WorkplaceOperatingStateSummaryResponse> {

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
    public WorkplaceOperatingStateSummaryPage(Object client, Method m, WorkplaceOperatingStateSummaryResponse response) {super(client, m, response);}

}
