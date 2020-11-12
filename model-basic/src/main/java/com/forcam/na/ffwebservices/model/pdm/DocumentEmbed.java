////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 29.10.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.pdm;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains booleans to determine what shall be embedded.
 */
public class DocumentEmbed {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------

    /** Constant string for NC state. */
    public static final String NC_STATE = "ncState";

    /** Constant string for document folders. */
    public static final String DOCUMENT_FOLDERS = "documentFolders";
    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Should NC state be embedded? */
    private boolean mNcState;

    /** Should document folders be embedded? */
    private boolean mDocumentFolders;

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    /**
     * Determines if document folders should be embedded.
     *
     * @param documentFolders Should document folders be embedded?
     * @return The document embed object with the new value.
     */
    public DocumentEmbed documentFolders(boolean documentFolders) {
        mDocumentFolders = documentFolders;
        return this;
    }

    /**
     * Determines if NC state should be embedded.
     *
     * @param ncState Should NC state be embedded?
     * @return The document embed object with the new value.
     */
    public DocumentEmbed ncState(boolean ncState) {
        mNcState = ncState;
        return this;
    }

    @Override
    public String toString() {
        final List<String> embeds = new ArrayList<>();

        if (this.isDocumentFolders()) {
            embeds.add(DOCUMENT_FOLDERS);
        }

        if (this.isNcState()) {
            embeds.add(NC_STATE);
        }

        return String.join(",", embeds);
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Provides flag if document folders should be embedded.
     *
     * @return Flag if document folders should be embedded.
     */
    public boolean isDocumentFolders() {
        return mDocumentFolders;
    }

    /**
     * Provides flag if NC state should be embedded.
     *
     * @return Flag if NC state should be embedded.
     */
    public boolean isNcState() {
        return mNcState;
    }
}