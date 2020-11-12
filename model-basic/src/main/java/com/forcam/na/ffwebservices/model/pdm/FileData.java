////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 31.10.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.pdm;

import java.io.File;

/**
 * Contains the file to upload and the corresponding media type.
 */
public class FileData {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The media type. */
    private String mMediaType;

    /** The file. */
    private File mFile;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates new instance.
     *
     * @param mediaType The media type.
     * @param file      The file.
     */
    public FileData(String mediaType, File file) {
        mMediaType = mediaType;
        mFile = file;
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public String getMediaType() {
        return mMediaType;
    }

    public void setMediaType(String mediaType) {
        mMediaType = mediaType;
    }

    public File getFile() {
        return mFile;
    }

    public void setFile(File file) {
        mFile = file;
    }
}