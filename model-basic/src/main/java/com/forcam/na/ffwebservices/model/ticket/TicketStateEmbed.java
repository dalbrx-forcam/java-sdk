////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 27.11.2019.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.ticket;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains flags to determine what shall be embedded.
 */
public class TicketStateEmbed {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------

    public static String NAME = "name";

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Should name be embedded? */
    private boolean mName;

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    /**
     * Determines if name should be embedded.
     *
     * @param name Should name be embedded?
     * @return The TicketStateEmbed object with the new value.
     */
    public TicketStateEmbed name(boolean name) {
        mName = name;
        return this;
    }

    @Override
    public String toString() {

        final List<String> embeds = new ArrayList<>();
        if (this.isName()) {
            embeds.add(NAME);
        }

        return String.join(",", embeds);
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public boolean isName() {
        return mName;
    }
}
