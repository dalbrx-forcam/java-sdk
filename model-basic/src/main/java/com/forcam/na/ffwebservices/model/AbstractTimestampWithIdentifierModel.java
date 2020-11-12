////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 07.11.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Provides pagination date and identifier.
 */
public abstract class AbstractTimestampWithIdentifierModel extends AbstractTimestampModel {

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    /**
     * Gets identifier which is used for pagination.
     *
     * @return Identifier for pagination.
     */
    @JsonIgnore
    public abstract String getPaginationIdentifier();

}
