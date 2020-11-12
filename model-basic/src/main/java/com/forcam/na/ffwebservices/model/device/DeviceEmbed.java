////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 13.08.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.device;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains booleans to determine what shall be embedded.
 */
public class DeviceEmbed {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------

    /** Constant string for description. */
    public static String DESCRIPTION = "description";

    /** Constant string for location. */
    public static String LOCATION = "location";

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Should description be embedded? */
    private boolean mDescription;

    /** Should location be embedded? */
    private boolean mLocation;

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    /**
     * Determines if the description literal should be embedded.
     *
     * @param description Should description be embedded?
     * @return The workplace embed object with the new value.
     */
    public DeviceEmbed description(boolean description) {
        mDescription = description;
        return this;
    }

    /**
     * Determines if location should be embedded.
     *
     * @param location The location.
     * @return The DeviceEmbed object with the new value.
     */
    public DeviceEmbed location(boolean location) {
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

        return String.join(",", embeds);
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Provides the flag if description should be embedded.
     *
     * @return Flag if description should be embedded.
     */
    public boolean isDescription() {
        return mDescription;
    }

    public boolean isLocation() {
        return mLocation;
    }
}
