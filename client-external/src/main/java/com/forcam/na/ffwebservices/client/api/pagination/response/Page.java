////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 12.09.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.pagination.response;

import com.forcam.na.ffwebservices.client.api.pagination.response.CollectionResponse;
import com.forcam.na.ffwebservices.client.api.pagination.response.SpecificPage;
import com.forcam.na.ffwebservices.model.AbstractResponse;

import java.lang.reflect.Method;

/**
 * Page containing elements.
 *
 * @param <E> The type of the elements.
 */
public class Page<E extends AbstractResponse> extends SpecificPage<E, CollectionResponse<E>> {

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
    public Page(Object client, Method clientMethod, CollectionResponse<E> response) {
        super(client, clientMethod, response);
    }

}
