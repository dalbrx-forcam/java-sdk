////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 05.12.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.common.webserviceaccess.requestparams;

/**
 * Exception thrown if the offset is invalid.
 */
public class InvalidOffsetException extends RuntimeException {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private int mOffset;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     *
     * @param offset The offset.
     */
    public InvalidOffsetException(int offset) {
        super();
        mOffset = offset;
    }

    public int getOffset() {
        return mOffset;
    }
}
