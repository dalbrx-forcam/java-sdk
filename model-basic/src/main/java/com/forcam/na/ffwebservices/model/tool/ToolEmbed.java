////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 20.12.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.tool;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains booleans to determine what shall be embedded.
 */
public class ToolEmbed {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------

    /** Constant string for description. */
    public static String DESCRIPTION = "description";

    /** Constant string for workplace. */
    public static String WORKPLACE = "workplace";

    /** Constant string for location. */
    public static String LOCATION = "location";

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Should description be embedded? */
    private boolean mDescription;

    /** Should workplace be embedded? */
    private boolean mWorkplace;

    /** Should location be embedded? */
    private boolean mLocation;

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    /**
     * Determines if workplace should be embedded.
     *
     * @param workplace Should workplace be embedded?
     * @return The ToolEmbed object with the new value.
     */
    public ToolEmbed workplace(boolean workplace) {
        mWorkplace = workplace;
        return this;
    }

    /**
     * Determines if description should be embedded.
     *
     * @param description Should description be embedded?
     * @return The ToolEmbed object with the new value.
     */
    public ToolEmbed description(boolean description) {
        mDescription = description;
        return this;
    }

    /**
     * Determines if location should be embedded.
     *
     * @param location The location.
     * @return The ToolEmbed object with the new value.
     */
    public ToolEmbed location(boolean location) {
        mLocation = location;
        return this;
    }

    @Override
    public String toString() {
        final List<String> embeds = new ArrayList<>();

        if (this.isDescription()) {
            embeds.add(DESCRIPTION);
        }

        if (this.isLocation()) {
            embeds.add(LOCATION);
        }

        if (this.isWorkplace()) {
            embeds.add(WORKPLACE);
        }

        return String.join(",", embeds);
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public boolean isDescription() {
        return mDescription;
    }

    public boolean isWorkplace() {
        return mWorkplace;
    }

    public boolean isLocation() {
        return mLocation;
    }
}