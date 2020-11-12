////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 09.01.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.statusdefinition;

/**
 * Contains booleans to determine what shall be embedded.
 */
public class StatusDefinitionEmbed {

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
     * @return The StatusDefinitionEmbed object with the new value.
     */
    public StatusDefinitionEmbed shortDescription(boolean shortDescription) {
        mShortDescription = shortDescription;
        return this;
    }

    /**
     * Determines if description should be embedded.
     *
     * @param description Should description be embedded?
     * @return The StatusDefinitionEmbed object with the new value.
     */
    public StatusDefinitionEmbed description(boolean description) {
        mDescription = description;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        if (mShortDescription) {
            builder.append(StatusDefinitionEmbed.SHORT_DESCRIPTION);
            builder.append(",");
        }

        if (mDescription) {
            builder.append(StatusDefinitionEmbed.DESCRIPTION);
        }

        return builder.toString();
    }

}