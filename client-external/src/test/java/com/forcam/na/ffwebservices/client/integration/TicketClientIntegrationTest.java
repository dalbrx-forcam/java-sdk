////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 07.11.2019.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.integration;

import com.forcam.na.ffwebservices.client.api.exception.ForceAPIException;
import com.forcam.na.ffwebservices.client.api.pagination.response.Page;
import com.forcam.na.ffwebservices.client.api.staffmember.StaffMemberClient;
import com.forcam.na.ffwebservices.client.api.staffmember.request.GetStaffMemberRequest;
import com.forcam.na.ffwebservices.client.api.staffmember.request.GetStaffMembersRequest;
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
import com.forcam.na.ffwebservices.model.ticket.TicketAttachmentResponse;
import com.forcam.na.ffwebservices.model.ticket.TicketResponse;
import com.forcam.na.ffwebservices.model.ticket.TicketState;
import org.junit.*;

import java.util.regex.Pattern;

/**
 * Integration tests for the class {@link com.forcam.na.ffwebservices.client.api.ticket.TicketClient}.
 */
public class TicketClientIntegrationTest extends AbstractOpenAPIIntegrationTest {

    public TicketClientIntegrationTest() {
        final Pattern ticketsPattern = Pattern.compile(PREFIX_GET_PATH + "/tickets\\?.*limit=3.*");
        mFileNames.put(ticketsPattern, "json/getTickets.json");

        final Pattern ticketPattern = Pattern.compile(PREFIX_GET_PATH + "/tickets/.{32}\\?.*");
        mFileNames.put(ticketPattern, "json/getTicket.json");

        final Pattern ticketDeletePattern = Pattern.compile("DELETEhttp://.*/ffwebservices/api/v1/tickets/.{32}\\?.*");

        final Pattern ticketSetStatePattern = Pattern.compile(PREFIX_POST_PATH + "/tickets/.{32}/.{10}\\?.*");

        final Pattern ticketCreatePattern = Pattern.compile(PREFIX_POST_PATH + "/tickets/.{32}\\?.*");
        mFileNames.put(ticketCreatePattern, "json/createTicket.json");

        final Pattern ticketUpdatePattern = Pattern.compile("PUThttp://.*/ffwebservices/api/v1/tickets/.{32}\\?.*");
        mFileNames.put(ticketUpdatePattern, "json/createTicket.json");

        final Pattern ticketAttachmentsPattern = Pattern.compile(PREFIX_GET_PATH + "/tickets/.{32}/attachments\\?.*");
        mFileNames.put(ticketAttachmentsPattern, "json/getTicketAttachments.json");

        final Pattern ticketAttachmentPattern = Pattern.compile(PREFIX_GET_PATH + "/tickets/.{32}/attachments/.{32}\\?.*");
        mFileNames.put(ticketAttachmentPattern, "json/getTicketAttachment.json");

        final Pattern ticketCreateAttachmentPattern = Pattern.compile(PREFIX_POST_PATH + "/tickets/.{32}/attachments\\?.*");
        mFileNames.put(ticketCreateAttachmentPattern, "json/creatTicketAttachment.json");
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    /**
     * Test for the method {@link StaffMemberClient#getStaffMembers(GetStaffMembersRequest)}.
     *
     * @throws ForceAPIException When unable to get staff members.
     */
    @Test
    public void testTickets() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final GetTicketsRequest request = new GetTicketsRequest();
        request.setLimit(3);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final Page<TicketResponse> ticketCollection = mTicketClient.getTickets(request);

        Assert.assertNotNull(ticketCollection);
        Assert.assertFalse(ticketCollection
                               .getElements()
                               .isEmpty());
    }

    /**
     * Test for the method {@link StaffMemberClient#getStaffMember(GetStaffMemberRequest)}.
     *
     * @throws ForceAPIException When unable to get staff member.
     */
    @Test
    public void testGetTicket() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final String ticketId = this.getTicketId();
        final GetTicketRequest ticketRequest = new GetTicketRequest(ticketId);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final TicketResponse ticketModel = mTicketClient.getTicket(ticketRequest);

        Assert.assertNotNull(ticketModel);
        Assert.assertNotNull(ticketModel.getProperties());
    }

    /**
     * Test for the method {@link com.forcam.na.ffwebservices.client.api.ticket.TicketClient#createTicket(CreateTicketRequest)}.
     *
     * @throws ForceAPIException When unable to create a new ticket
     */
    @Test
    public void testCreateTicket() throws ForceAPIException {
        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final CreateTicketRequest request = new CreateTicketRequest("title", "description");

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------
        final TicketResponse ticketModel = mTicketClient.createTicket(request);
        Assert.assertNotNull(ticketModel);
        Assert.assertNotNull(ticketModel.getProperties());
    }

    /**
     * Test for the method {@link com.forcam.na.ffwebservices.client.api.ticket.TicketClient#updateTicket(UpdateTicketRequest)}.
     *
     * @throws ForceAPIException When unable to update a ticket
     */
    @Test
    public void testUpdateTicket() throws ForceAPIException {
        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------
        final String ticketId = this.getTicketId();
        final UpdateTicketRequest request = new UpdateTicketRequest(ticketId, this.getTicketData());

        //----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------
        final TicketResponse ticketModel = mTicketClient.updateTicket(request);
        Assert.assertNotNull(ticketModel);
        Assert.assertNotNull(ticketModel.getProperties());
    }

    /**
     * Test for the method {@link com.forcam.na.ffwebservices.client.api.ticket.TicketClient#deleteTicket(DeleteTicketRequest)}.
     *
     * @throws ForceAPIException When unable to delete a ticket
     */
    @Test
    public void testDeleteTicket() throws ForceAPIException {
        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------
        final String ticketId = this.getTicketId();
        final DeleteTicketRequest request = new DeleteTicketRequest(ticketId);

        //----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------
        mTicketClient.deleteTicket(request);
    }

    /**
     * Test for the method {@link com.forcam.na.ffwebservices.client.api.ticket.TicketClient#setTicketState(SetTicketStateRequest)}.
     *
     * @throws ForceAPIException When unable to set the state of a ticket
     */
    @Test
    public void testSetTicketState() throws ForceAPIException {
        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------
        final String ticketId = this.getTicketId();
        final TicketState ticketState = this.getTicketStateId();
        final SetTicketStateRequest request = new SetTicketStateRequest(ticketId, ticketState);

        //----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------
        mTicketClient.setTicketState(request);
    }

    /**
     * Test for the method {@link com.forcam.na.ffwebservices.client.api.ticket.TicketClient#getTicketAttachments(GetTicketAttachmentsRequest)}.
     *
     * @throws ForceAPIException When unable to get ticket attachments.
     */
    @Test
    public void testTicketAttachments() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final GetTicketAttachmentsRequest request = new GetTicketAttachmentsRequest(this.getTicketId());
        request.setLimit(3);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final Page<TicketAttachmentResponse> ticketCollection = mTicketClient.getTicketAttachments(request);

        Assert.assertNotNull(ticketCollection);
        Assert.assertFalse(ticketCollection
                               .getElements()
                               .isEmpty());
    }

    /**
     * Test for the method {@link com.forcam.na.ffwebservices.client.api.ticket.TicketClient#getTicketAttachment(GetTicketAttachmentRequest)}.
     *
     * @throws ForceAPIException When unable to get a ticket attachment.
     */
    @Test
    public void testGetTicketAttachment() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final String ticketId = this.getTicketId();
        final String ticketAttachmentId = this.getTicketAttachmentId(ticketId);
        final GetTicketAttachmentRequest ticketAttachmentRequest = new GetTicketAttachmentRequest(ticketId, ticketAttachmentId);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final TicketAttachmentResponse ticketAttachmentModel = mTicketClient.getTicketAttachment(ticketAttachmentRequest);

        Assert.assertNotNull(ticketAttachmentModel);
        Assert.assertNotNull(ticketAttachmentModel.getProperties());
    }

    /**
     * Test for the method {@link com.forcam.na.ffwebservices.client.api.ticket.TicketClient#createTicketAttachment(CreateTicketAttachmentRequest)}.
     *
     * @throws ForceAPIException When unable to create a new ticket
     */
    @Test
    public void testCreateTicketAttachment() throws ForceAPIException {
        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final CreateTicketAttachmentRequest request = new CreateTicketAttachmentRequest(this.getTicketId(), "desc");

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------
        final TicketAttachmentResponse ticketAttachmentModel = mTicketClient.createTicketAttachment(request);
        Assert.assertNotNull(ticketAttachmentModel);
        Assert.assertNotNull(ticketAttachmentModel.getProperties());
    }

    /**
     * Test for the method {@link com.forcam.na.ffwebservices.client.api.ticket.TicketClient#deleteTicket(DeleteTicketRequest)}.
     *
     * @throws ForceAPIException When unable to update a ticket
     */
    @Test
    public void testDeleteTicketAttachment() throws ForceAPIException {
        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------
        final String ticketId = this.getTicketId();
        final String attachmentId = this.getTicketAttachmentId(ticketId);
        final DeleteTicketAttachmentRequest request = new DeleteTicketAttachmentRequest(ticketId, attachmentId);

        //----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------
        mTicketClient.deleteTicketAttachment(request);
    }

}
