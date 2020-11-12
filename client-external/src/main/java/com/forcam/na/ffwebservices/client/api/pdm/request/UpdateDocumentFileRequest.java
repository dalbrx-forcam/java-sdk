////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 29.10.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.pdm.request;

import com.forcam.na.ffwebservices.model.pdm.FileData;

/**
 * Request parameter for updating a document file.
 */
public class UpdateDocumentFileRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The document ID. */
    private String mDocumentId;

    /** The editor. */
    private String mEditor;

    /** The file name. */
    private String mFileName;

    /** The file. */
    private FileData mFileData;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates new instance.
     *
     * @param documentId The document ID.
     * @param editor     The editor.
     * @param fileName   The file name.
     * @param fileData   The file data.
     */
    public UpdateDocumentFileRequest(String documentId, String editor, String fileName, FileData fileData) {
        mDocumentId = documentId;
        mEditor = editor;
        mFileName = fileName;
        mFileData = fileData;
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public String getDocumentId() {
        return mDocumentId;
    }

    public void setDocumentId(String documentId) {
        mDocumentId = documentId;
    }

    public String getEditor() {
        return mEditor;
    }

    public void setEditor(String editor) {
        mEditor = editor;
    }

    public String getFileName() {
        return mFileName;
    }

    public void setFileName(String fileName) {
        mFileName = fileName;
    }

    public FileData getFileData() {
        return mFileData;
    }

    public void setFileData(FileData fileData) {
        mFileData = fileData;
    }
}