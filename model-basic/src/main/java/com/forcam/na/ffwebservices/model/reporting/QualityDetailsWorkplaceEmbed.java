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
 * Embed for quality details workplace report.
 */
public class QualityDetailsWorkplaceEmbed {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------

    public static String QUALITY_TYPES = "qualityTypes";

    public static String QUALITY_DETAILS = "qualityDetails";

    public static String WORKPLACES = "workplaces";

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private boolean mQualityTypes;

    private boolean mQualityDetails;

    private boolean mWorkplaces;

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    public QualityDetailsWorkplaceEmbed qualityTypes(boolean qualityTypes) {
        mQualityTypes = qualityTypes;
        return this;
    }

    public QualityDetailsWorkplaceEmbed qualityDetails(boolean qualityDetails) {
        mQualityDetails = qualityDetails;
        return this;
    }

    public QualityDetailsWorkplaceEmbed workplaces(boolean workplaces) {
        mWorkplaces = workplaces;
        return this;
    }

    @Override
    public String toString() {
        final List<String> embeds = new ArrayList<>();

        if (this.isQualityDetails()) {
            embeds.add(QUALITY_DETAILS);
        }

        if (this.isQualityTypes()) {
            embeds.add(QUALITY_TYPES);
        }

        if (this.isWorkplaces()) {
            embeds.add(WORKPLACES);
        }

        return String.join(",", embeds);
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public boolean isQualityDetails() {
        return mQualityDetails;
    }

    public boolean isQualityTypes() {
        return mQualityTypes;
    }

    public boolean isWorkplaces() {
        return mWorkplaces;
    }
}
