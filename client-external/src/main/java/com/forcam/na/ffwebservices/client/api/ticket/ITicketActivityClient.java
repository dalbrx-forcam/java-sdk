////////////////////////////////////////////////////////////////////////////////
//
// Created by tim on 29.11.19.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.ticket;

import com.forcam.na.ffwebservices.client.api.exception.ForceAPIException;
import com.forcam.na.ffwebservices.client.api.pagination.response.Page;
import com.forcam.na.ffwebservices.client.api.ticket.request.CreateTicketActivityAttachmentDataRequest;
import com.forcam.na.ffwebservices.client.api.ticket.request.CreateTicketActivityAttachmentRequest;
import com.forcam.na.ffwebservices.client.api.ticket.request.CreateTicketActivityRemarkRequest;
import com.forcam.na.ffwebservices.client.api.ticket.request.CreateTicketActivityRequest;
import com.forcam.na.ffwebservices.client.api.ticket.request.GetTicketActivitiesRequest;
import com.forcam.na.ffwebservices.client.api.ticket.request.GetTicketActivityAttachmentRequest;
import com.forcam.na.ffwebservices.client.api.ticket.request.GetTicketActivityAttachmentsRequest;
import com.forcam.na.ffwebservices.client.api.ticket.request.GetTicketActivityRemarkRequest;
import com.forcam.na.ffwebservices.client.api.ticket.request.GetTicketActivityRemarksRequest;
import com.forcam.na.ffwebservices.client.api.ticket.request.GetTicketActivityRequest;
import com.forcam.na.ffwebservices.client.api.ticket.request.SetTicketActivityStateRequest;
import com.forcam.na.ffwebservices.client.api.ticket.request.UpdateTicketActivityRequest;
import com.forcam.na.ffwebservices.model.ticket.TicketActivityAttachmentResponse;
import com.forcam.na.ffwebservices.model.ticket.TicketActivityRemarkResponse;
import com.forcam.na.ffwebservices.model.ticket.TicketActivityResponse;

/**
 * An Interface with methods that request ticket activities.
 */
public interface ITicketActivityClient {

    /**
     * Sends a request to the server and gets a collection of ticket activities as response.
     *
     * @param request A collection of parameters.
     * @return The ticket activities collection response.
     * @throws ForceAPIException When unable to get tickets.
     */
    Page<TicketActivityResponse> getTicketActivities(GetTicketActivitiesRequest request) throws ForceAPIException;

    /**
     * Sends a request to the server and gets a ticket activity as response.
     *
     * @param request The ticket id and the activity id.
     * @return The ticket activity response.
     * @throws ForceAPIException When unable to get the tickets or the activity.
     */
    TicketActivityResponse getTicketActivity(GetTicketActivityRequest request) throws ForceAPIException;

    /**
     * Sends a request to the server to create a ticket activity and gets a ticket activity as response.
     *
     * @param request The ticket id and the activity data as JSON.
     * @return The ticket activity response.
     * @throws ForceAPIException When unable to create the ticket activity.
     */
    TicketActivityResponse createTicketActivity(CreateTicketActivityRequest request) throws ForceAPIException;

    /**
     * Send a request to the server to update a ticket activity and gets the updated ticket activity as response.
     *
     * @param request The ticket id, activity id and the activity data as JSON.
     * @return The updated ticket activity response.
     * @throws ForceAPIException When unable to update the ticket activity.
     */
    TicketActivityResponse updateTicketActivity(UpdateTicketActivityRequest request) throws ForceAPIException;

    /**
     * Send a request to the server to delete a ticket activity.
     *
     * @param request The ticket id and the activity id.
     * @throws ForceAPIException When unable to delete the ticket activity.
     */
    void deleteTicketActivity(GetTicketActivityRequest request) throws ForceAPIException;

    /**
     * Send a request to the server to set the ticket activity state.
     *
     * @param request The ticket id, the activity id and the ticket activity state.
     * @return The ticket activity with the change state as response.
     * @throws ForceAPIException When unable to set the ticket activity state.
     */
    TicketActivityResponse setTicketActivityState(SetTicketActivityStateRequest request) throws ForceAPIException;

    /**
     * Send a request to the server to get the ticket activity attachments.
     *
     * @param request A collection of parameters.
     * @return The ticket activity attachment collection response.
     * @throws ForceAPIException When unable to get ticket activity attachments.
     */
    Page<TicketActivityAttachmentResponse> getTicketActivityAttachments(GetTicketActivityAttachmentsRequest request) throws ForceAPIException;

    /**
     * Send a request to the server to get the ticket activity attachment.
     *
     * @param request The ticket id, the activity id and the attachment id.
     * @return The ticket activity attachment.
     * @throws ForceAPIException When unable to get the ticket activity attachment
     */
    TicketActivityAttachmentResponse getTicketActivityAttachment(GetTicketActivityAttachmentRequest request) throws ForceAPIException;

    /**
     * Send a request to the server to get the ticket activity attachment data.
     *
     * @param request The ticket id, the activity id and the attachment id.
     * @return The ticket activity attachment data.
     * @throws ForceAPIException When unable to get the ticket activity attachment data
     */
    byte[] getTicketActivityAttachmentData(GetTicketActivityAttachmentRequest request) throws ForceAPIException;

    /**
     * Send a request to the server to delete the ticket activity attachment data.
     *
     * @param request The ticket id, the activity id and the attachment id.
     * @throws ForceAPIException When unable to delete the ticket activity attachment
     */
    void deleteTicketActivityAttachment(GetTicketActivityAttachmentRequest request) throws ForceAPIException;

    /**
     * Send a request to the server to create a ticket activity attachment.
     *
     * @param request The ticket id, the activity id and the attachment id.
     * @return The create ticket activity attachment.
     * @throws ForceAPIException When unable to get the ticket activity attachment.
     */
    TicketActivityAttachmentResponse createTicketActivityAttachment(CreateTicketActivityAttachmentRequest request) throws ForceAPIException;

    /**
     * Send a request to the server to create a ticket activity attachment data.
     *
     * @param request The ticket id, the activity id.
     * @return The ticket activity attachment data.
     * @throws ForceAPIException When unable to create the ticket activity attachment data
     */
    byte[] createTicketActivityAttachmentData(CreateTicketActivityAttachmentDataRequest request) throws ForceAPIException;

    /**
     * Send a request to the server to get the ticket activity remarks.
     *
     * @param request A collection of parameters.
     * @return The ticket activity remarks collection response.
     * @throws ForceAPIException When unable to get ticket activity remarks.
     */
    Page<TicketActivityRemarkResponse> getTicketActivityRemarks(GetTicketActivityRemarksRequest request) throws ForceAPIException;

    /**
     * Send a request to the server to get the ticket activity remarks.
     *
     * @param request The ticket id, the activity id and the remarks id.
     * @return The ticket activity remarks.
     * @throws ForceAPIException When unable to get the ticket activity remarks
     */
    TicketActivityRemarkResponse getTicketActivityRemark(GetTicketActivityRemarkRequest request) throws ForceAPIException;

    TicketActivityRemarkResponse createTicketActivityRemark(CreateTicketActivityRemarkRequest request) throws ForceAPIException;

    void deleteTicketActivityRemark(GetTicketActivityRemarkRequest request) throws ForceAPIException;
}
