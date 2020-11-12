////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 09.01.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.qualitytype;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains booleans to determine what shall be embedded.
 */
public class QualityTypeEmbed {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------

    /** Constant string for description. */
    public static String DESCRIPTION = "description";

    /** Constant string for short description. */
    public static String SHORT_DESCRIPTION = "shortDescription";

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

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
     * @return The QualityTypeEmbed object with the new value.
     */
    public QualityTypeEmbed shortDescription(boolean shortDescription) {
        mShortDescription = shortDescription;
        return this;
    }

    /**
     * Determines if description should be embedded.
     *
     * @param description Should description be embedded?
     * @return The QualityTypeEmbed object with the new value.
     */
    public QualityTypeEmbed description(boolean description) {
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