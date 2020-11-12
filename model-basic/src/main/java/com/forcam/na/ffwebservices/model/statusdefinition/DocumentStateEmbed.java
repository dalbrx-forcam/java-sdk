////////////////////////////////////////////////////////////////////////////////
//
// Created by DZeise on 09.03.2020.
//
// Copyright (c) 2006 - 2020 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.statusdefinition;

/**
 * Contains values, of what should be embedded.
 */
public class DocumentStateEmbed {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------

    /** Constant string for description. */
    public static String DESCRIPTION = "description";

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Should description be embedded? */
    private boolean mEmbedDescription;

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    /**
     * Determines if description should be embedded.
     *
     * @param embedDescription Should description be embedded?
     * @return The DocumentStateEmbed object with the new value.
     */
    public DocumentStateEmbed description(boolean embedDescription) {
        mEmbedDescription = embedDescription;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        if (mEmbedDescription) {
            builder.append(DocumentStateEmbed.DESCRIPTION);
        }

        return builder.toString();
    }

}
