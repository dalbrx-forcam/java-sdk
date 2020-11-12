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
 * Embed for quality details material report.
 */
public class QualityDetailsMaterialEmbed {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------

    public static String QUALITY_TYPES = "qualityTypes";

    public static String QUALITY_DETAILS = "qualityDetails";

    public static String MATERIALS = "materials";

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private boolean mQualityTypes;

    private boolean mQualityDetails;

    private boolean mMaterials;

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    public QualityDetailsMaterialEmbed qualityTypes(boolean qualityTypes) {
        mQualityTypes = qualityTypes;
        return this;
    }

    public QualityDetailsMaterialEmbed qualityDetails(boolean qualityDetails) {
        mQualityDetails = qualityDetails;
        return this;
    }

    public QualityDetailsMaterialEmbed materials(boolean materials) {
        mMaterials = materials;
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

        if (this.isMaterials()) {
            embeds.add(MATERIALS);
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

    public boolean isMaterials() {
        return mMaterials;
    }
}
