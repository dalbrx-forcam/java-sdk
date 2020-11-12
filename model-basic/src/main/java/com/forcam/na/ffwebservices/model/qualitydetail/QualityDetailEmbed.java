////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 20.10.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.qualitydetail;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains booleans to determine what shall be embedded.
 */
public class QualityDetailEmbed {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------

    /** Constant string for description. */
    public static String DESCRIPTION = "description";

    /** Constant string for short description. */
    public static String SHORT_DESCRIPTION = "shortDescription";

    /** Constant string for quality type. */
    public static String QUALITY_TYPE = "qualityType";

    /** Should description be embedded? */
    private boolean mDescription;

    /** Should short description be embedded? */
    private boolean mShortDescription;

    /** Should quality type be embedded? */
    private boolean mQualityType;

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    /**
     * Determines if description should be embedded.
     *
     * @param description Should description be embedded?
     * @return The QualityDetailEmbed object with the new value.
     */
    public QualityDetailEmbed description(boolean description) {
        mDescription = description;
        return this;
    }

    /**
     * Determines if short description should be embedded.
     *
     * @param shortDescription Should short description be embedded?
     * @return The QualityDetailEmbed object with the new value.
     */
    public QualityDetailEmbed shortDescription(boolean shortDescription) {
        mShortDescription = shortDescription;
        return this;
    }

    /**
     * Determines if quality type should be embedded.
     *
     * @param qualityType Should quality type be embedded?
     * @return The QualityDetailEmbed object with the new value.
     */
    public QualityDetailEmbed qualityType(boolean qualityType) {
        mQualityType = qualityType;
        return this;
    }

    @Override
    public String toString() {
        final List<String> embeds = new ArrayList<>();

        if (this.isDescription()) {
            embeds.add(DESCRIPTION);
        }

        if (this.isShortDescription()) {
            embeds.add(SHORT_DESCRIPTION);
        }

        if (this.isQualityType()) {
            embeds.add(QUALITY_TYPE);
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

    public boolean isQualityType() {
        return mQualityType;
    }
}