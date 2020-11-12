////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 20.11.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.order;

/**
 * The state of a production order.
 */
public enum ProductionOrderState {

    // ------------------------------------------------------------------------
    // enums
    // ------------------------------------------------------------------------

    RELEASED,

    PLANNED,

    STARTED,

    COMPLETED,

    CLOSED;
}
