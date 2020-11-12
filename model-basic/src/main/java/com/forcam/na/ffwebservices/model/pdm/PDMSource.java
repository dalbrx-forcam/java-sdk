////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 30.01.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.pdm;

/**
 * The source of a NC package or NC Element.
 */
public enum PDMSource {

    // ------------------------------------------------------------------------
    // enums
    // ------------------------------------------------------------------------

    /** Element was created (formerly NEW). */
    CREATED_INTERNALLY,
    /** Element was imported after external modification.(formerly NOR). */
    CREATED_EXTERNALLY,
    /** Element was modified in the machine control. */
    OPTIMIZED_AT_THE_MACHINE,
    /** Element was created by the machine control. */
    CREATED_AT_THE_MACHINE;
}
