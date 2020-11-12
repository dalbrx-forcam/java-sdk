////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 06.11.2019.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.ticket;

import com.forcam.na.ffwebservices.client.api.AbstractOpenAPIMockTest;
import com.forcam.na.ffwebservices.client.api.config.GuiceTestRunner;
import com.forcam.na.ffwebservices.client.api.exception.ForceAPIException;
import com.forcam.na.ffwebservices.client.api.pagination.response.Page;
import com.forcam.na.ffwebservices.client.api.ticket.request.CreateTicketAttachmentDataRequest;
import com.forcam.na.ffwebservices.client.api.ticket.request.CreateTicketAttachmentRequest;
import com.forcam.na.ffwebservices.client.api.ticket.request.CreateTicketRequest;
import com.forcam.na.ffwebservices.client.api.ticket.request.DeleteTicketAttachmentRequest;
import com.forcam.na.ffwebservices.client.api.ticket.request.DeleteTicketRequest;
import com.forcam.na.ffwebservices.client.api.ticket.request.GetTicketAttachmentRequest;
import com.forcam.na.ffwebservices.client.api.ticket.request.GetTicketAttachmentsRequest;
import com.forcam.na.ffwebservices.client.api.ticket.request.GetTicketRequest;
import com.forcam.na.ffwebservices.client.api.ticket.request.GetTicketsRequest;
import com.forcam.na.ffwebservices.client.api.ticket.request.SetTicketStateRequest;
import com.forcam.na.ffwebservices.client.api.ticket.request.UpdateTicketRequest;
import com.forcam.na.ffwebservices.model.pdm.FileData;
import com.forcam.na.ffwebservices.model.ticket.CreateTicketAttachmentPropertiesWSModel;
import com.forcam.na.ffwebservices.model.ticket.TicketAttachmentResponse;
import com.forcam.na.ffwebservices.model.ticket.TicketResponse;
import com.forcam.na.ffwebservices.model.ticket.TicketState;
import com.forcam.na.ffwebservices.model.ticket.WriteTicketPropertiesWSModel;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.*;
import org.junit.rules.*;
import org.junit.runner.*;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Tests for the class {@link TicketClient}.
 */
@RunWith(GuiceTestRunner.class)
public class TicketClientTest extends AbstractOpenAPIMockTest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Helper for test exceptions and messages. */
    @Rule
    public ExpectedException mExpectedException = ExpectedException.none();

    /** The ticket client. */
    private ITicketClient mTicketClient;

    // ------------------------------------------------------------------------
    // constructor
    // ------------------------------------------------------------------------

    public TicketClientTest() {
        mTicketClient = mBridgeAPIComponent.ticketClient();
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    /**
     * Test for the method {@link TicketClient#getTicket(GetTicketRequest)}.
     *
     * @throws ForceAPIException    When unable to get ticket.
     * @throws InterruptedException When unable to take the request from the server.
     * @throws IOException          When unable to read the JSON file.
     * @throws URISyntaxException   When unable to create a URI of the JSON file.
     */
    @Test
    public void getTicket() throws ForceAPIException, InterruptedException, IOException, URISyntaxException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        //TODO use correct ticket json
        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getTicket.json")));
        final GetTicketRequest request = new GetTicketRequest("TESTID");

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final TicketResponse response = mTicketClient.getTicket(request);

        final RecordedRequest recordedRequest = mMockWebServer.takeRequest();
        final String requestQuery = recordedRequest
            .getRequestUrl()
            .query();
        Assert.assertNotNull(requestQuery);

        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getSelf());

        Assert.assertNotNull(response.getProperties());
        Assert.assertNotNull(response
                                 .getProperties()
                                 .getId());
    }

    /**
     * Test for the method {@link TicketClient#getTickets(GetTicketsRequest)}.
     *
     * @throws ForceAPIException    When unable to get tickets.
     * @throws InterruptedException When unable to take the request from the server.
     * @throws IOException          When unable to read the JSON file.
     * @throws URISyntaxException   When unable to create a URI of the JSON file.
     */
    @Test
    public void getTickets() throws ForceAPIException, InterruptedException, IOException, URISyntaxException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        //TODO use correct json
        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getTickets.json")));
        final int limit = 3;
        final GetTicketsRequest request = new GetTicketsRequest();
        request.setLimit(limit);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final Page<TicketResponse> response = mTicketClient.getTickets(request);

        final RecordedRequest recordedRequest = mMockWebServer.takeRequest();
        final String requestQuery = recordedRequest
            .getRequestUrl()
            .query();
        Assert.assertNotNull(requestQuery);
        Assert.assertTrue(requestQuery.contains("limit=" + limit));

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
        Assert.assertFalse(response
                               .getElements()
                               .isEmpty());
    }

    /**
     * Tests deleting a ticket while the server is down.
     *
     * @throws IOException       When unable to shutdown the server.
     * @throws ForceAPIException When unable to delete the ticket.
     */
    @Test
    public void deleteTicketShutdown() throws IOException, ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final DeleteTicketRequest request = new DeleteTicketRequest("ticketId");
        mMockWebServer.shutdown();
        mExpectedException.expect(ForceAPIException.class);
        mExpectedException.expectMessage("Unable to execute call using request: " + request);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mTicketClient.deleteTicket(request);
    }

    /**
     * Tests set a ticket state while the server is down.
     *
     * @throws IOException        When unable to shutdown the server.
     * @throws ForceAPIException  When unable to delete the ticket.
     * @throws URISyntaxException When unable to delete the ticket.
     */
    @Test
    public void testSetTicketStateShutdown() throws ForceAPIException, IOException, URISyntaxException {
        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------
        final SetTicketStateRequest request = new SetTicketStateRequest("ticketId", TicketState.CONFIRMED);
        mMockWebServer.shutdown();
        mExpectedException.expect(ForceAPIException.class);
        mExpectedException.expectMessage("Unable to execute call using request: " + request);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mTicketClient.setTicketState(request);
    }

    /**
     * Tests creating a ticket while the server is down.
     *
     * @throws IOException       When unable to shutdown the server.
     * @throws ForceAPIException When unable to delete the ticket.
     */
    @Test
    public void testCreateTicketShutDown() throws IOException, ForceAPIException {
        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------
        final CreateTicketRequest request = new CreateTicketRequest("title", "description");
        mMockWebServer.shutdown();
        mExpectedException.expect(ForceAPIException.class);
        mExpectedException.expectMessage("Unable to execute call using request: " + request);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mTicketClient.createTicket(request);
    }

    /**
     * Tests creating a ticket.
     *
     * @throws ForceAPIException When unable to delete the ticket.
     */
    @Test
    public void testCreateTicket() throws ForceAPIException, IOException, URISyntaxException, InterruptedException {
        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------
        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/createTicket.json")));
        final CreateTicketRequest request = new CreateTicketRequest("title", "description");

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------
        final TicketResponse response = mTicketClient.createTicket(request);

        final RecordedRequest recordedRequest = mMockWebServer.takeRequest();
        final String body = recordedRequest
            .getBody()
            .readUtf8();
        final WriteTicketPropertiesWSModel requestModel = mMapper.readValue(body, WriteTicketPropertiesWSModel.class);
        Assert.assertEquals(request
                                .getTicketData()
                                .getTitle(), requestModel.getTitle());
    }

    /**
     * Tests creating a ticket while the server is down.
     *
     * @throws IOException       When unable to shutdown the server.
     * @throws ForceAPIException When unable to delete the ticket.
     */
    @Test
    public void testUpdateTicketShutDown() throws IOException, ForceAPIException {
        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------
        final UpdateTicketRequest request = new UpdateTicketRequest("TESTID", new WriteTicketPropertiesWSModel());
        mMockWebServer.shutdown();
        mExpectedException.expect(ForceAPIException.class);
        mExpectedException.expectMessage("Unable to execute call using request: " + request);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mTicketClient.updateTicket(request);
    }

    /**
     * Tests creating a ticket.
     *
     * @throws ForceAPIException When unable to delete the ticket.
     */
    @Test
    public void testUpdateTicket() throws ForceAPIException, IOException, URISyntaxException, InterruptedException {
        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------
        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/createTicket.json")));
        final UpdateTicketRequest request = new UpdateTicketRequest("TESTID", new WriteTicketPropertiesWSModel());

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------
        final TicketResponse response = mTicketClient.updateTicket(request);

        final RecordedRequest recordedRequest = mMockWebServer.takeRequest();
        final String body = recordedRequest
            .getBody()
            .readUtf8();
        final WriteTicketPropertiesWSModel requestModel = mMapper.readValue(body, WriteTicketPropertiesWSModel.class);
        Assert.assertNotNull(requestModel);
        Assert.assertNotNull(response);

    }

    /**
     * Test for the method {@link TicketClient#getTicketAttachments(GetTicketAttachmentsRequest)}.
     *
     * @throws ForceAPIException    When unable to get tickets.
     * @throws InterruptedException When unable to take the request from the server.
     * @throws IOException          When unable to read the JSON file.
     * @throws URISyntaxException   When unable to create a URI of the JSON file.
     */
    @Test
    public void getTicketAttachments() throws ForceAPIException, InterruptedException, IOException, URISyntaxException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------
        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getTicketAttachments.json")));
        final int limit = 3;
        final GetTicketAttachmentsRequest request = new GetTicketAttachmentsRequest("TESTID");
        request.setLimit(limit);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final Page<TicketAttachmentResponse> response = mTicketClient.getTicketAttachments(request);

        final RecordedRequest recordedRequest = mMockWebServer.takeRequest();
        final String requestQuery = recordedRequest
            .getRequestUrl()
            .query();
        Assert.assertNotNull(requestQuery);
        Assert.assertTrue(requestQuery.contains("limit=" + limit));

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
        Assert.assertFalse(response
                               .getElements()
                               .isEmpty());
    }

    @Test
    public void getTicketAttachment() throws IOException, URISyntaxException, ForceAPIException, InterruptedException {
        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------
        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getTicketAttachment.json")));
        final int limit = 3;
        final GetTicketAttachmentRequest request = new GetTicketAttachmentRequest("TESTID", "TESTATTACHMENTID");

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------
        final TicketAttachmentResponse response = mTicketClient.getTicketAttachment(request);
        final RecordedRequest recordedRequest = mMockWebServer.takeRequest();
        final String requestQuery = recordedRequest
            .getRequestUrl()
            .query();
        Assert.assertNotNull(requestQuery);

        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getSelf());

        Assert.assertNotNull(response.getProperties());
        Assert.assertNotNull(response
                                 .getProperties()
                                 .getId());

    }

    /**
     * Tests creating a ticket attachment while the server is down.
     *
     * @throws IOException       When unable to shutdown the server.
     * @throws ForceAPIException When unable to create the ticket attachment.
     */
    @Test
    public void testCreateTicketAttachmentShutDown() throws IOException, ForceAPIException {
        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------
        final CreateTicketAttachmentRequest request = new CreateTicketAttachmentRequest("TESTID", "desc");
        mMockWebServer.shutdown();
        mExpectedException.expect(ForceAPIException.class);
        mExpectedException.expectMessage("Unable to execute call using request: " + request);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mTicketClient.createTicketAttachment(request);
    }

    /**
     * Tests creating a ticket attachment.
     *
     * @throws ForceAPIException When unable to create the ticket attachment.
     */
    @Test
    public void testCreateTicketAttachment() throws ForceAPIException, IOException, URISyntaxException, InterruptedException {
        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------
        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/createTicketAttachment.json")));
        final CreateTicketAttachmentRequest request = new CreateTicketAttachmentRequest("TESTID", "desc");

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------
        final TicketAttachmentResponse response = mTicketClient.createTicketAttachment(request);

        final RecordedRequest recordedRequest = mMockWebServer.takeRequest();
        final String body = recordedRequest
            .getBody()
            .readUtf8();
        final CreateTicketAttachmentPropertiesWSModel requestModel = mMapper.readValue(body, CreateTicketAttachmentPropertiesWSModel.class);
        Assert.assertEquals(request
                                .getTicketAttachmentData()
                                .getDescription(), requestModel.getDescription());
    }

    /**
     * Tests deleting a ticket attachment while the server is down.
     *
     * @throws ForceAPIException When unable to delete the ticket attachment.
     */
    @Test
    public void deleteTicketAttachmentShutdown() throws IOException, ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final DeleteTicketAttachmentRequest request = new DeleteTicketAttachmentRequest("ticketId", "attchamentId");
        mMockWebServer.shutdown();
        mExpectedException.expect(ForceAPIException.class);
        mExpectedException.expectMessage("Unable to execute call using request: " + request);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mTicketClient.deleteTicketAttachment(request);
    }

    @Test
    public void testGetTicketAttachmentData() throws ForceAPIException, IOException {
        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------
        final GetTicketAttachmentRequest request = new GetTicketAttachmentRequest("ticketId", "attachmentId");
        mMockWebServer.shutdown();
        mExpectedException.expect(ForceAPIException.class);
        mExpectedException.expectMessage("Unable to execute call using request: " + request);
        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------
        mTicketClient.getTicketAttachmentData(request);

    }

    @Test
    public void testCreateTicketAttachmentData() throws ForceAPIException, IOException {
        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------
        final CreateTicketAttachmentDataRequest request = new CreateTicketAttachmentDataRequest("ticketId",
                                                                                                "attachmentId",
                                                                                                new FileData("text/plain", File.createTempFile("test", ".txt")),
                                                                                                "testCreator");
        mMockWebServer.shutdown();
        mExpectedException.expect(ForceAPIException.class);
        mExpectedException.expectMessage("Unable to execute call using request: " + request);
        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------
        mTicketClient.createTicketAttachmentData(request);

    }
}
