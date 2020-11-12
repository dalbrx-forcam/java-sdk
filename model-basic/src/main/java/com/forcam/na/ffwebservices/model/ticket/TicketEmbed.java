////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 06.11.2019.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.ticket;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains booleans to determine what shall be embedded.
 */
public class TicketEmbed {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------

    public static String WORKPLACE = "workplace";

    public static String SHIFT = "shift";

    public static String OPERATION = "operation";

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private boolean mShift;

    private boolean mWorkplace;

    private boolean mOperation;

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        final List<String> embeds = new ArrayList<>();
        if (this.isOperation()) {
            embeds.add(TicketEmbed.OPERATION);
        }

        if (this.isShift()) {
            embeds.add(TicketEmbed.SHIFT);
        }

        if (this.isWorkplace()) {
            embeds.add(TicketEmbed.WORKPLACE);
        }

        return String.join(",", embeds);
    }

    public TicketEmbed shift(boolean shift) {
        mShift = shift;
        return this;
    }

    public TicketEmbed workplace(boolean workplace) {
        mWorkplace = workplace;
        return this;
    }

    public TicketEmbed operation(boolean operation) {
        mOperation = operation;
        return this;
    }

    public boolean isOperation() {
        return mOperation;
    }

    public boolean isWorkplace() {
        return mWorkplace;
    }

    public boolean isShift() {
        return mShift;
    }
}
