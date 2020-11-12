////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 13.09.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.operation.response;

import com.forcam.na.ffwebservices.client.api.pagination.response.SpecificPage;
import com.forcam.na.ffwebservices.model.operatingstate.OperatingStateSummaryWSModel;

import java.lang.reflect.Method;

/**
 * Page containing operation operating state summaries.
 */
public class OperationOperatingStateSummaryPage extends SpecificPage<OperatingStateSummaryWSModel, OperationOperatingStateSummaryResponse> {

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
    public OperationOperatingStateSummaryPage(Object client, Method m, OperationOperatingStateSummaryResponse response) {
        super(client, m, response);
    }

}
