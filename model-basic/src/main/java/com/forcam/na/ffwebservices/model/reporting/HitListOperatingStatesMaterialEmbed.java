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
 * Embed for hit list operating states material report.
 */
public class HitListOperatingStatesMaterialEmbed {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------

    public static String MATERIALS = "materials";

    public static String OPERATING_STATES = "operatingStates";

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private boolean mMaterials;

    private boolean mOperatingStates;

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    public HitListOperatingStatesMaterialEmbed materials(boolean materials) {
        mMaterials = materials;
        return this;
    }

    public HitListOperatingStatesMaterialEmbed operatingStates(boolean operatingStates) {
        mOperatingStates = operatingStates;
        return this;
    }

    @Override
    public String toString() {
        final List<String> embeds = new ArrayList<>();

        if (this.isMaterials()) {
            embeds.add(MATERIALS);
        }

        if (this.isOperatingStates()) {
            embeds.add(OPERATING_STATES);
        }

        return String.join(",", embeds);
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public boolean isOperatingStates() {
        return mOperatingStates;
    }

    public boolean isMaterials() {
        return mMaterials;
    }
}
