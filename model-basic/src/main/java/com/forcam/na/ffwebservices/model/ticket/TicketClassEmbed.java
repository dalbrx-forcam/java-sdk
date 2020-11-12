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
public class TicketClassEmbed {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------

    public static String SHORT_DESCRIPTION = "shortDescription";

    public static String DESCRIPTION = "description";

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
    public TicketClassEmbed shortDescription(boolean shortDescription) {
        mShortDescription = shortDescription;
        return this;
    }

    /**
     * Determines if description should be embedded.
     *
     * @param description Should description be embedded?
     * @return The StatusDefinitionEmbed object with the new value.
     */
    public TicketClassEmbed description(boolean description) {
        mDescription = description;
        return this;
    }

    @Override
    public String toString() {
        final List<String> embeds = new ArrayList<>();

        if (this.isShortDescription()) {
            embeds.add(SHORT_DESCRIPTION);
        }

        if (this.isDescription()) {
            embeds.add(DESCRIPTION);
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
