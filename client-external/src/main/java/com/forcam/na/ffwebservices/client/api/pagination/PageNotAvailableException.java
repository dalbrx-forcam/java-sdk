////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 10.09.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.pagination;

/**
 *
 */
public class PageNotAvailableException extends Exception {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     */
    public PageNotAvailableException() {
        super();
    }

    /**
     * Creates a new instance.
     *
     * @param e The cause.
     */
    public PageNotAvailableException(Exception e) {
        super(e);
    }

    /**
     * Creates a new instance.
     *
     * @param m The message.
     */
    public PageNotAvailableException(String m) {
        super(m);
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

}
