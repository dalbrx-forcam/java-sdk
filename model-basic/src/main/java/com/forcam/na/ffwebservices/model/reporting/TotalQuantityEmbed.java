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
 * Embed for total quantity report.
 */
public class TotalQuantityEmbed {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------

    public static String WORKPLACES = "workplaces";

    public static String MATERIALS = "materials";

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private boolean mWorkplaces;

    private boolean mMaterials;

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    public TotalQuantityEmbed workplaces(boolean workplaces) {
        mWorkplaces = workplaces;
        return this;
    }

    public TotalQuantityEmbed materials(boolean materials) {
        mMaterials = materials;
        return this;
    }

    @Override
    public String toString() {
        final List<String> embeds = new ArrayList<>();

        if (this.isWorkplaces()) {
            embeds.add(WORKPLACES);
        }

        if (this.isMaterials()) {
            embeds.add(MATERIALS);
        }

        return String.join(",", embeds);
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public boolean isWorkplaces() {
        return mWorkplaces;
    }

    public boolean isMaterials() {
        return mMaterials;
    }
}
