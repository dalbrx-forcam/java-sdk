////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 29.10.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.pdm;

import com.forcam.na.ffwebservices.client.api.AbstractOpenAPIMockTest;
import com.forcam.na.ffwebservices.client.api.config.GuiceTestRunner;
import com.forcam.na.ffwebservices.client.api.exception.ForceAPIException;
import com.forcam.na.ffwebservices.client.api.pagination.response.Page;
import com.forcam.na.ffwebservices.client.api.pdm.request.GetDocumentRequest;
import com.forcam.na.ffwebservices.client.api.pdm.request.GetDocumentsRequest;
import com.forcam.na.ffwebservices.client.api.pdm.request.GetFileRepositoryFoldersRequest;
import com.forcam.na.ffwebservices.client.api.pdm.request.GetFolderRequest;
import com.forcam.na.ffwebservices.model.pdm.FileRepositoryDocumentResponse;
import com.forcam.na.ffwebservices.model.pdm.FileRepositoryFolderResponse;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.*;
import org.junit.rules.*;
import org.junit.runner.*;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Tests for the class {@link FileRepositoryClient}.
 */
@RunWith(GuiceTestRunner.class)
public class FileRepositoryClientTest extends AbstractOpenAPIMockTest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Helper for test exceptions and messages. */
    @Rule
    public ExpectedException mExpectedException = ExpectedException.none();

    /** The operation client. */
    private IFileRepositoryClient mFileRepositoryClient;

    // ------------------------------------------------------------------------
    // constructor
    // ------------------------------------------------------------------------

    public FileRepositoryClientTest() {
        mFileRepositoryClient = mBridgeAPIComponent.fileRepositoryClient();
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    /**
     * Test for the method {@link FileRepositoryClient#getFolders(GetFileRepositoryFoldersRequest)}.
     *
     * @throws ForceAPIException    When unable to get file repository folders.
     * @throws InterruptedException When unable to take the request from the server.
     * @throws IOException          When unable to read the JSON file.
     * @throws URISyntaxException   When unable to create a URI of the JSON file.
     */
    @Test
    public void testGetFolders() throws ForceAPIException, InterruptedException, IOException, URISyntaxException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getFileRepositoryFolders.json")));
        final int limit = 3;
        final GetFileRepositoryFoldersRequest request = new GetFileRepositoryFoldersRequest();
        request.setLimit(limit);

        final Page<FileRepositoryFolderResponse> response = mFileRepositoryClient.getFolders(request);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        //Verify request
        final RecordedRequest recordedRequest = mMockWebServer.takeRequest();
        final String requestQuery = recordedRequest
            .getRequestUrl()
            .query();
        Assert.assertNotNull(requestQuery);
        Assert.assertTrue(requestQuery.contains("limit=" + limit));

        //Verify response model
        Assert.assertNotNull(response);
        Assert.assertNotNull(response
                                 .getResponse()
                                 .getPaginationLinks());
        Assert.assertNotNull(response
                                 .getResponse()
                                 .getPaginationLinks()
                                 .getFirst());
        Assert.assertNotNull(response
                                 .getResponse()
                                 .getPaginationLinks()
                                 .getSelf());
        Assert.assertNotNull(response
                                 .getResponse()
                                 .getPaginationLinks()
                                 .getLast());
        Assert.assertFalse(response
                               .getElements()
                               .isEmpty());

        Assert.assertNotNull(response
                                 .getElements()
                                 .get(0)
                                 .getProperties()
                                 .getCreationDate());
        Assert.assertNotNull(response
                                 .getElements()
                                 .get(0)
                                 .getProperties()
                                 .getId());
    }

    /**
     * Test for the method {@link FileRepositoryClient#getFolder(GetFolderRequest)}.
     *
     * @throws ForceAPIException    When unable to get file repository folder.
     * @throws InterruptedException When unable to take the request from the server.
     * @throws IOException          When unable to read the JSON file.
     * @throws URISyntaxException   When unable to create a URI of the JSON file.
     */
    @Test
    public void testGetFolder() throws ForceAPIException, InterruptedException, IOException, URISyntaxException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getFileRepositoryFolder.json")));
        final GetFolderRequest request = new GetFolderRequest("folderId");

        final FileRepositoryFolderResponse response = mFileRepositoryClient.getFolder(request);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        //Verify request
        final RecordedRequest recordedRequest = mMockWebServer.takeRequest();
        final String requestQuery = recordedRequest
            .getRequestUrl()
            .query();
        Assert.assertNotNull(requestQuery);

        //Verify response model
        Assert.assertNotNull(response);
        Assert.assertNotNull(response
                                 .getProperties()
                                 .getId());
        Assert.assertNotNull(response
                                 .getProperties()
                                 .getCreationDate());
        Assert.assertNotNull(response
                                 .getProperties()
                                 .getEditor());
    }

    /**
     * Test for the method {@link FileRepositoryClient#getDocuments(GetDocumentsRequest)}.
     *
     * @throws ForceAPIException    When unable to get file repository documents.
     * @throws InterruptedException When unable to take the request from the server.
     * @throws IOException          When unable to read the JSON file.
     * @throws URISyntaxException   When unable to create a URI of the JSON file.
     */
    @Test
    public void testGetDocuments() throws ForceAPIException, InterruptedException, IOException, URISyntaxException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getFileRepositoryDocuments.json")));
        final int limit = 3;
        final GetDocumentsRequest request = new GetDocumentsRequest();
        request.setLimit(limit);

        final Page<FileRepositoryDocumentResponse> response = mFileRepositoryClient.getDocuments(request);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        //Verify request
        final RecordedRequest recordedRequest = mMockWebServer.takeRequest();
        final String requestQuery = recordedRequest
            .getRequestUrl()
            .query();
        Assert.assertNotNull(requestQuery);
        Assert.assertTrue(requestQuery.contains("limit=" + limit));

        //Verify response model
        Assert.assertNotNull(response);
        Assert.assertNotNull(response
                                 .getResponse()
                                 .getPaginationLinks());
        Assert.assertNotNull(response
                                 .getResponse()
                                 .getPaginationLinks()
                                 .getFirst());
        Assert.assertNotNull(response
                                 .getResponse()
                                 .getPaginationLinks()
                                 .getSelf());
        Assert.assertNotNull(response
                                 .getResponse()
                                 .getPaginationLinks()
                                 .getLast());
        Assert.assertFalse(response
                               .getElements()
                               .isEmpty());

        Assert.assertNotNull(response
                                 .getElements()
                                 .get(0)
                                 .getProperties()
                                 .getCreationDate());
        Assert.assertNotNull(response
                                 .getElements()
                                 .get(0)
                                 .getProperties()
                                 .getName());
        Assert.assertNotNull(response
                                 .getElements()
                                 .get(0)
                                 .getProperties()
                                 .getId());
    }

    /**
     * Test for the method {@link FileRepositoryClient#getDocument(GetDocumentRequest)}.
     *
     * @throws ForceAPIException    When unable to get file repository document.
     * @throws InterruptedException When unable to take the request from the server.
     * @throws IOException          When unable to read the JSON file.
     * @throws URISyntaxException   When unable to create a URI of the JSON file.
     */
    @Test
    public void testGetDocument() throws ForceAPIException, InterruptedException, IOException, URISyntaxException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getFileRepositoryDocument.json")));
        final GetDocumentRequest request = new GetDocumentRequest("documentId");
        request
            .embed()
            .documentFolders(true);

        final FileRepositoryDocumentResponse response = mFileRepositoryClient.getDocument(request);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        //Verify request
        final RecordedRequest recordedRequest = mMockWebServer.takeRequest();
        final String requestQuery = recordedRequest
            .getRequestUrl()
            .query();
        Assert.assertNotNull(requestQuery);

        //Verify response model
        Assert.assertNotNull(response);
        Assert.assertNotNull(response
                                 .getProperties()
                                 .getId());
        Assert.assertNotNull(response
                                 .getProperties()
                                 .getCreationDate());
        Assert.assertNotNull(response
                                 .getProperties()
                                 .getEditor());
    }
}