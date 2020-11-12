////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 13.10.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.shifttype;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains booleans to determine what shall be embedded.
 */
public class ShiftTypeEmbed {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------

    /** Constant string for description. */
    public static String DESCRIPTION = "description";

    /** Constant string for short description. */
    public static String SHORT_DESCRIPTION = "shortDescription";

    /** Should description be embedded? */
    private boolean mDescription;

    /** Should short description be embedded? */
    private boolean mShortDescription;

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    /**
     * Determines if short description should be embedded.
     *
     * @param shortDescription Should short description be embedded?
     * @return The ShiftTypeEmbed object with the new value.
     */
    public ShiftTypeEmbed shortDescription(boolean shortDescription) {
        mShortDescription = shortDescription;
        return this;
    }

    /**
     * Determines if description should be embedded.
     *
     * @param description Should description be embedded?
     * @return The ShiftTypeEmbed object with the new value.
     */
    public ShiftTypeEmbed description(boolean description) {
        mDescription = description;
        return this;
    }

    @Override
    public String toString() {
        final List<String> embeds = new ArrayList<>();

        if (this.isDescription()) {
            embeds.add(DESCRIPTION);
        }

        if (this.isShortDescription()) {
            embeds.add(SHORT_DESCRIPTION);
        }

        return String.join(",", embeds);
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public boolean isDescription() {
        return mDescription;
    }

    public boolean isShortDescription() {
        return mShortDescription;
    }
}