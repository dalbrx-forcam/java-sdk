////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 13.09.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.operation.response;

import com.forcam.na.ffwebservices.client.api.pagination.response.SpecificPage;
import com.forcam.na.ffwebservices.model.operation.OperationComponentWSModel;

import java.lang.reflect.Method;

/**
 * Page containing operation components.
 */
public class OperationComponentCollectionPage extends SpecificPage<OperationComponentWSModel, OperationComponentCollectionResponse> {

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
    public OperationComponentCollectionPage(Object client, Method m, OperationComponentCollectionResponse response) {super(client, m, response);}

}
