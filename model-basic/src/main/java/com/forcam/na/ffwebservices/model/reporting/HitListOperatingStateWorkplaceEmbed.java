////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 10.12.2019.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.reporting;

import java.util.ArrayList;
import java.util.List;

/**
 * Embed for hit list operating states workplace report.
 */
public class HitListOperatingStateWorkplaceEmbed {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------

    public static String WORKPLACES = "workplaces";

    public static String OPERATING_STATES = "operatingStates";

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private boolean mWorkplaces;

    private boolean mOperatingStates;

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    public HitListOperatingStateWorkplaceEmbed workplaces(boolean workplaces) {
        mWorkplaces = workplaces;
        return this;
    }

    public HitListOperatingStateWorkplaceEmbed operatingStates(boolean operatingStates) {
        mOperatingStates = operatingStates;
        return this;
    }

    @Override
    public String toString() {
        final List<String> embeds = new ArrayList<>();

        if (this.isWorkplaces()) {
            embeds.add(WORKPLACES);
        }

        if (this.isOperatingStates()) {
            embeds.add(OPERATING_STATES);
        }

        return String.join(",", embeds);
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public boolean isWorkplaces() {
        return mWorkplaces;
    }

    public boolean isOperatingStates() {
        return mOperatingStates;
    }

}
