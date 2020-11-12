////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 04.10.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

/**
 * Provides pagination date for time series models.
 */
public abstract class AbstractTimestampModel {

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    /**
     * Gets date which is used for comparing at the timestamp pagination.
     *
     * @return Comparing date for timestamp pagination.
     */
    @JsonIgnore
    public abstract Date getPaginationDate();
}