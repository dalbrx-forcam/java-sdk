////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 26.01.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.entrypoint;

import com.forcam.na.ffwebservices.client.api.AbstractLinkModelBuilder;

import javax.inject.Inject;

/**
 * Creates a link model without embedding.
 */
public class NonEmbeddableLinkModelBuilder extends AbstractLinkModelBuilder {

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Constructor for a link model builder without embedding.
     */
    @Inject
    public NonEmbeddableLinkModelBuilder() {
        super(Object.class);
    }
}