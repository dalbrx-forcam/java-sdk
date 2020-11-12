////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 06.11.2019.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.ticket;

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
import com.forcam.na.ffwebservices.model.ticket.TicketAttachmentResponse;
import com.forcam.na.ffwebservices.model.ticket.TicketResponse;

/**
 * An interface with methods that request tickets.
 */
public interface ITicketClient {

    /**
     * Sends a request to the server and gets a collection of tickets as response.
     *
     * @param request A collection of parameters.
     * @return The ticket collection response.
     * @throws ForceAPIException When unable to get tickets.
     */
    Page<TicketResponse> getTickets(GetTicketsRequest request) throws ForceAPIException;

    /**
     * Sends a request to the server and gets a ticket model as response.
     *
     * @param request A collection of parameters.
     * @return A ticket model.
     * @throws ForceAPIException When unable to get ticket.
     */
    TicketResponse getTicket(GetTicketRequest request) throws ForceAPIException;

    /**
     * Sends a deletion request to the server.
     *
     * @param request A collection of parameters.
     * @throws ForceAPIException When unable to delete ticket.
     */
    void deleteTicket(DeleteTicketRequest request) throws ForceAPIException;

    /**
     * Sends a ticket state request to the server and gets a ticket as response.
     *
     * @param request A collection of parameters.
     * @return A ticket model.
     * @throws ForceAPIException When unable to set ticket state.
     */
    TicketResponse setTicketState(SetTicketStateRequest request) throws ForceAPIException;

    /**
     * Sends a creation request to the server and gets the new ticket model as response.
     *
     * @param request A collection of parameters.
     * @return A ticket model.
     * @throws ForceAPIException When unable to create ticket.
     */
    TicketResponse createTicket(CreateTicketRequest request) throws ForceAPIException;

    /**
     * Sends an update request to the server and gets the updated ticket as response.
     *
     * @param request A collection of parameters.
     * @return A ticket model.
     * @throws ForceAPIException When unable to update ticket.
     */
    TicketResponse updateTicket(UpdateTicketRequest request) throws ForceAPIException;

    /**
     * Sends a request to the server and gets a collection of ticket attachments as response.
     *
     * @param request A collection of parameters.
     * @return The ticket attachment collection response.
     * @throws ForceAPIException When unable to get ticket attachments.
     */
    Page<TicketAttachmentResponse> getTicketAttachments(GetTicketAttachmentsRequest request) throws ForceAPIException;

    /**
     * Send a request to the server and gets a ticket attachment as response.
     *
     * @param request A collection of parameters.
     * @return The ticket attachment response.
     * @throws ForceAPIException When unable to get the ticket attachment.
     */
    TicketAttachmentResponse getTicketAttachment(GetTicketAttachmentRequest request) throws ForceAPIException;

    /**
     * Send a request to the server and gets the new ticket as response.
     *
     * @param request A collection of parameters.
     * @return The ticket attachment response.
     * @throws ForceAPIException When unable to create the ticket attachment.
     */
    TicketAttachmentResponse createTicketAttachment(CreateTicketAttachmentRequest request) throws ForceAPIException;

    /**
     * Send a deletion request ot the server.
     *
     * @param request A collection of parameters.
     * @throws ForceAPIException When unable to delete ticket attachment.
     */
    void deleteTicketAttachment(DeleteTicketAttachmentRequest request) throws ForceAPIException;

    /**
     * Send a request to the server and gets the ticket attachment data as byte array.
     *
     * @param request A collection of parameters.
     * @return The ticket attachment data as byte array.
     * @throws ForceAPIException When unable to delete ticket attachment.
     */
    byte[] getTicketAttachmentData(GetTicketAttachmentRequest request) throws ForceAPIException;

    /**
     * Send a request to the server and create a ticket attachment data as byte array.
     *
     * @param request A collection of parameters.
     * @return The ticket attachment data as byte array that was created.
     * @throws ForceAPIException When unable to delete ticket attachment.
     */
    byte[] createTicketAttachmentData(CreateTicketAttachmentDataRequest request) throws ForceAPIException;
}
