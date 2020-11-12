////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 29.10.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.integration;

import com.forcam.na.ffwebservices.client.api.exception.ForceAPIException;
import com.forcam.na.ffwebservices.client.api.pagination.response.Page;
import com.forcam.na.ffwebservices.client.api.pdm.FileRepositoryClient;
import com.forcam.na.ffwebservices.client.api.pdm.request.CreateFileRepositoryDocumentRequest;
import com.forcam.na.ffwebservices.client.api.pdm.request.GetDocumentRequest;
import com.forcam.na.ffwebservices.client.api.pdm.request.GetDocumentsRequest;
import com.forcam.na.ffwebservices.client.api.pdm.request.GetFileRepositoryFoldersRequest;
import com.forcam.na.ffwebservices.client.api.pdm.request.GetFolderRequest;
import com.forcam.na.ffwebservices.client.api.pdm.request.UpdateDocumentFileRequest;
import com.forcam.na.ffwebservices.model.pdm.CreateFileRepositoryDocumentWSModelProperties;
import com.forcam.na.ffwebservices.model.pdm.CreateFileRepositoryFolderWSPropertiesModel;
import com.forcam.na.ffwebservices.model.pdm.FileData;
import com.forcam.na.ffwebservices.model.pdm.FileRepositoryDocumentResponse;
import com.forcam.na.ffwebservices.model.pdm.FileRepositoryFolderResponse;
import com.forcam.na.ffwebservices.model.pdm.PDMSource;
import com.google.common.io.Files;
import org.apache.commons.io.FileUtils;
import org.junit.*;

import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;

/**
 * Integration tests for the class {@link FileRepositoryClient}.
 */
public class FileRepositoryClientIntegrationTest extends AbstractOpenAPIIntegrationTest {

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    public FileRepositoryClientIntegrationTest() {
        final Pattern getFolderPattern = Pattern.compile(PREFIX_GET_PATH + "/fileRepository/folders/.{32}.*");
        mFileNames.put(getFolderPattern, "json/getFileRepositoryFolder.json");

        final Pattern getFoldersPattern = Pattern.compile(PREFIX_GET_PATH + "/fileRepository/folders\\?.*limit=2.*");
        mFileNames.put(getFoldersPattern, "json/getFileRepositoryFolders.json");

        final Pattern getDocumentPattern = Pattern.compile(PREFIX_GET_PATH + "/fileRepository/documents/.{32}.*");
        mFileNames.put(getDocumentPattern, "json/getFileRepositoryDocument.json");

        final Pattern getDocumentsPattern = Pattern.compile(PREFIX_GET_PATH + "/fileRepository/documents\\?.*limit=2.*");
        mFileNames.put(getDocumentsPattern, "json/getFileRepositoryDocuments.json");

    }
    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    /**
     * Test for the method {@link FileRepositoryClient#createDocument(CreateFileRepositoryDocumentRequest)}.
     *
     * @throws ForceAPIException When unable to create a new file repository document.
     */
    @Test
    public void testCreateDocument() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        this.createFolder();

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final FileRepositoryDocumentResponse document = this.createDocument();

        Assert.assertNotNull(document);
        Assert.assertNotNull(document
                                 .getProperties()
                                 .getId());
        Assert.assertNotNull(document
                                 .getProperties()
                                 .getCreationDate());
    }

    /**
     * Test for the method {@link FileRepositoryClient#getDocuments(GetDocumentsRequest)}.
     *
     * @throws ForceAPIException When unable to get file repository documents.
     */
    @Test
    public void testGetDocuments() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        this.createFolder();
        this.createDocument();
        final GetDocumentsRequest request = new GetDocumentsRequest();
        request.setLimit(2);
        request
            .embed()
            .documentFolders(true)
            .ncState(true);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final Page<FileRepositoryDocumentResponse> documentResponsePage = mFileRepositoryClient.getDocuments(request);

        Assert.assertNotNull(documentResponsePage);
        Assert.assertNotNull(documentResponsePage.getPagination());
        Assert.assertNotNull(documentResponsePage
                                 .getResponse()
                                 .getElements());
    }

    /**
     * Test for the method {@link FileRepositoryClient#getDocument(GetDocumentRequest)}.
     *
     * @throws ForceAPIException When unable to get file repository document.
     */
    @Test
    public void testGetDocument() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        this.createFolder();
        final FileRepositoryDocumentResponse document = this.createDocument();
        final String documentId = document
            .getProperties()
            .getId();
        final GetDocumentRequest request = new GetDocumentRequest(documentId);
        request
            .embed()
            .documentFolders(true)
            .ncState(true);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final FileRepositoryDocumentResponse documentResponse = mFileRepositoryClient.getDocument(request);

        Assert.assertNotNull(documentResponse);
        Assert.assertNotNull(documentResponse.getDocumentFolders());
        Assert.assertNotNull(documentResponse
                                 .getProperties()
                                 .getCreationDate());
        Assert.assertNotNull(documentResponse
                                 .getProperties()
                                 .getId());
    }

    /**
     * Test for the method {@link FileRepositoryClient#deleteDocument(String)}.
     *
     * @throws ForceAPIException When unable to delete file repository document.
     */
    @Test
    public void testDeleteDocument() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        this.createFolder();
        final FileRepositoryDocumentResponse document = this.createDocument();
        final String documentId = document
            .getProperties()
            .getId();

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mFileRepositoryClient.deleteDocument(documentId);
    }

    /**
     * Test for the method {@link FileRepositoryClient#getDocumentFile(String)}.
     *
     * @throws ForceAPIException When unable to get document file.
     */
    @Test
    public void testGetDocumentFile() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        this.testUploadDocumentFile();
        final String documentId = this.getDocumentId();

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final byte[] downloadedFile = mFileRepositoryClient.getDocumentFile(documentId);

        try {
            final File file = new File("src\\test\\resources\\json\\testDocumentFile.json");
            Files.write(downloadedFile, file);
            final File originalFile = new File("src\\test\\resources\\json\\getFileRepositoryDocument.json");
            Assert.assertTrue(FileUtils.contentEquals(file, originalFile));
        } catch (IOException e) {
            Assert.assertNotNull(downloadedFile);
        }
    }

    /**
     * Test for the method {@link FileRepositoryClient#updateDocumentFile(UpdateDocumentFileRequest)}.
     *
     * @throws ForceAPIException When unable to upload file.
     */
    @Test
    public void testUploadDocumentFile() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        this.createFolder();
        this.createDocument();
        final File file = new File("src\\test\\resources\\json\\getFileRepositoryDocument.json");
        final FileData fileData = new FileData("text/json", file);

        this.createFolder();
        final FileRepositoryDocumentResponse document = this.createDocument();
        final String documentId = document
            .getProperties()
            .getId();

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final UpdateDocumentFileRequest request = new UpdateDocumentFileRequest(documentId, "SYSTEM", "HelloWorld", fileData);

        mFileRepositoryClient.updateDocumentFile(request);
    }

    /**
     * Test for the method {@link FileRepositoryClient#getFolders(GetFileRepositoryFoldersRequest)}.
     *
     * @throws ForceAPIException When unable to get file repository folders.
     */
    @Test
    public void testGetFolders() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        this.createFolder();
        final GetFileRepositoryFoldersRequest request = new GetFileRepositoryFoldersRequest();
        request.setLimit(2);
        request
            .embed()
            .ncState(true);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final Page<FileRepositoryFolderResponse> folderResponsePage = mFileRepositoryClient.getFolders(request);

        Assert.assertNotNull(folderResponsePage);
        Assert.assertNotNull(folderResponsePage.getPagination());
        Assert.assertNotNull(folderResponsePage
                                 .getResponse()
                                 .getElements());
    }

    /**
     * Test for the method {@link FileRepositoryClient#getFolder(GetFolderRequest)}.
     *
     * @throws ForceAPIException When unable to get file repository folder.
     */
    @Test
    public void testGetFolder() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final FileRepositoryFolderResponse folder = this.createFolder();
        final String folderId = folder
            .getProperties()
            .getId();
        final GetFolderRequest request = new GetFolderRequest(folderId);
        request
            .embed()
            .ncState(true);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final FileRepositoryFolderResponse folderResponse = mFileRepositoryClient.getFolder(request);

        Assert.assertNotNull(folderResponse);
        Assert.assertNotNull(folderResponse
                                 .getProperties()
                                 .getCreationDate());
        Assert.assertNotNull(folderResponse
                                 .getProperties()
                                 .getId());
    }

    /**
     * Test for the method {@link FileRepositoryClient#deleteFolder(String)}.
     *
     * @throws ForceAPIException When unable to delete file repository folder.
     */
    @Test
    public void testDeleteFolder() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final FileRepositoryFolderResponse folder = this.createFolder();
        final String folderId = folder
            .getProperties()
            .getId();

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mFileRepositoryClient.deleteFolder(folderId);
    }

    // ----------------------------------------------------------------------
    // getters/setters
    // ----------------------------------------------------------------------

    /**
     * Gets document ID.
     *
     * @return The document ID.
     * @throws ForceAPIException When unable to get documents.
     */
    private String getDocumentId() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final GetDocumentsRequest request = new GetDocumentsRequest();
        request.setLimit(1);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final Page<FileRepositoryDocumentResponse> documents = mFileRepositoryClient.getDocuments(request);
        Assert.assertNotNull(documents
                                 .getElements()
                                 .get(0)
                                 .getProperties()
                                 .getId());
        return documents
            .getElements()
            .get(0)
            .getProperties()
            .getId();
    }

    /**
     * Gets folder ID.
     *
     * @return The folder ID.
     * @throws ForceAPIException When unable to get folder ID.
     */
    private String getFolderId() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final GetFileRepositoryFoldersRequest request = new GetFileRepositoryFoldersRequest();
        request.setLimit(1);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final Page<FileRepositoryFolderResponse> folders = mFileRepositoryClient.getFolders(request);
        Assert.assertNotNull(folders
                                 .getElements()
                                 .get(0)
                                 .getProperties()
                                 .getId());
        return folders
            .getElements()
            .get(0)
            .getProperties()
            .getId();
    }

    /**
     * Creates a new folder.
     *
     * @return The saved file repository folder response.
     * @throws ForceAPIException When unable to save a new folder.
     */
    private FileRepositoryFolderResponse createFolder() throws ForceAPIException {
        final CreateFileRepositoryFolderWSPropertiesModel propertiesModel = new CreateFileRepositoryFolderWSPropertiesModel();
        propertiesModel.setName("TEST");

        final FileRepositoryFolderResponse folder = mFileRepositoryClient.createFolder(propertiesModel);
        Assert.assertNotNull(folder);
        Assert.assertEquals("forcam",
                            folder
                                .getProperties()
                                .getCreator());
        Assert.assertEquals("TEST",
                            folder
                                .getProperties()
                                .getName());

        return folder;
    }

    /**
     * Creates a new document for a folder.
     *
     * @return The creates file repository document response.
     * @throws ForceAPIException When unable to create a new document.
     */
    private FileRepositoryDocumentResponse createDocument() throws ForceAPIException {
        final CreateFileRepositoryDocumentWSModelProperties properties = new CreateFileRepositoryDocumentWSModelProperties();
        properties.setOrigin(PDMSource.CREATED_INTERNALLY);
        properties.setType("txt");

        final CreateFileRepositoryDocumentRequest request = new CreateFileRepositoryDocumentRequest(this.getFolderId());
        request.setDocumentProperties(properties);

        final FileRepositoryDocumentResponse document = mFileRepositoryClient.createDocument(request);
        Assert.assertNotNull(document);

        return document;
    }
}