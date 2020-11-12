////////////////////////////////////////////////////////////////////////////////
//
// Created by ARabbi on 7/3/2019.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.workplace.response;

import com.forcam.na.ffwebservices.client.api.pagination.response.SpecificPage;
import com.forcam.na.ffwebservices.model.operation.UserFieldWSModel;

import java.lang.reflect.Method;

/**
 * Page containing workplace user fields.
 */
public class WorkplaceUserFieldCollectionPage extends SpecificPage<UserFieldWSModel, WorkplaceUserFieldCollectionResponse> {

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
    public WorkplaceUserFieldCollectionPage(Object client, Method m, WorkplaceUserFieldCollectionResponse response) {super(client, m, response);}

}
