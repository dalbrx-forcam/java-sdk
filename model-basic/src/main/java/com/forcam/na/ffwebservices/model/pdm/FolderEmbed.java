////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 29.10.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.pdm;

/**
 * Contains booleans to determine what shall be embedded.
 */
public class FolderEmbed {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------

    /** Constant string for NC state. */
    public static String NC_STATE = "ncState";

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Should NC state be embedded? */
    private boolean mNcState;

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    /**
     * Determines if NC state should be embedded.
     *
     * @param ncState Should NC state be embedded?
     * @return The folder embed object with the new value.
     */
    public FolderEmbed ncState(boolean ncState) {
        mNcState = ncState;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        if (this.isNcState()) {
            builder.append(FolderEmbed.NC_STATE);
        }

        return builder.toString();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Provides flag if NC state should be embedded.
     *
     * @return Flag if NC state should be embedded.
     */
    public boolean isNcState() {
        return mNcState;
    }
}