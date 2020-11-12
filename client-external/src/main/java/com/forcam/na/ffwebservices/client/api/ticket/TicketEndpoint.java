////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 06.11.2019.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.ticket;

import com.forcam.na.common.webserviceaccess.requestparams.PaginationDirection;
import com.forcam.na.ffwebservices.client.api.HALCollectionWSModel;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.model.IPathParts;
import com.forcam.na.ffwebservices.model.IRequestAndQueryParams;
import com.forcam.na.ffwebservices.model.ticket.CreateTicketAttachmentPropertiesWSModel;
import com.forcam.na.ffwebservices.model.ticket.TicketPriority;
import com.forcam.na.ffwebservices.model.ticket.TicketState;
import com.forcam.na.ffwebservices.model.ticket.WriteTicketPropertiesWSModel;
import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.util.Date;

/**
 * An interface with methods for creating calls that can be sent to the server.
 */
public interface TicketEndpoint {

    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @GET(IPathParts.TICKETS + "/{" + IRequestAndQueryParams.TICKET_ID + "}")
    Call<HALWSModel> getTicket(
        @Path(IRequestAndQueryParams.TICKET_ID)
            String ticketId,
        @Query(IRequestAndQueryParams.EMBED)
            String embed);

    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @GET(IPathParts.TICKETS)
    Call<HALCollectionWSModel> getTickets(
        @Query(IRequestAndQueryParams.WORKPLACE_NUMBER)
            String workplaceNumber,
        @Query(IRequestAndQueryParams.WORKPLACE_ID)
            String workplaceId,
        @Query(IRequestAndQueryParams.TICKET_TITLE)
            String ticketTitle,
        @Query(IRequestAndQueryParams.TICKET_NUMBER)
            String ticketNumber,
        @Query(IRequestAndQueryParams.CREATION_DATE_FROM)
            Date creationDateFrom,
        @Query(IRequestAndQueryParams.CREATION_DATE_TO)
            Date creationDateTo,
        @Query(IRequestAndQueryParams.OPERATION_ID)
            String operationId,
        @Query(IRequestAndQueryParams.MATERIAL_NUMBER)
            String materialNumber,
        @Query(IRequestAndQueryParams.TICKET_PRIORITY)
            TicketPriority ticketPriority,
        @Query(IRequestAndQueryParams.TICKET_STATE_ID)
            TicketState ticketStateId,
        @Query(IRequestAndQueryParams.TICKET_CLASS_ID)
            String ticketClassId,
        @Query(IRequestAndQueryParams.LIMIT)
            int limit,
        @Query(IRequestAndQueryParams.PAGINATION_DIRECTION)
            PaginationDirection paginationDirection,
        @Query(IRequestAndQueryParams.PAGINATION_TIMESTAMP)
            Date paginationTimestamp,
        @Query(IRequestAndQueryParams.PAGINATION_IDENTIFIER)
            String paginationIdentifier,
        @Query(IRequestAndQueryParams.EMBED)
            String embed);

    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @DELETE(IPathParts.TICKETS + "/{" + IRequestAndQueryParams.TICKET_ID + "}")
    Call<Void> deleteTicket(
        @Path(IRequestAndQueryParams.TICKET_ID)
            String ticketId);

    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @POST(IPathParts.TICKETS + "/{" + IRequestAndQueryParams.TICKET_ID + "}/{" + IRequestAndQueryParams.TICKET_STATE_ID + "}")
    Call<HALWSModel> setTicketState(
        @Path(IRequestAndQueryParams.TICKET_ID)
            String ticketId,
        @Path(IRequestAndQueryParams.TICKET_STATE_ID)
            TicketState ticketStateId);

    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @POST(IPathParts.TICKETS)
    Call<HALWSModel> createTicket(
        @Body
            WriteTicketPropertiesWSModel ticketData);

    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @PUT(IPathParts.TICKETS + "/{" + IRequestAndQueryParams.TICKET_ID + "}")
    Call<HALWSModel> updateTicket(
        @Path(IRequestAndQueryParams.TICKET_ID)
            String ticketId,
        @Body
            WriteTicketPropertiesWSModel ticketData);

    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @GET(IPathParts.TICKETS + "/{" + IRequestAndQueryParams.TICKET_ID + "}/" + IPathParts.TICKET_ATTACHMENTS)
    Call<HALCollectionWSModel> getTicketAttachments(
        @Path(IRequestAndQueryParams.TICKET_ID)
            String ticketId,
        @Query(IRequestAndQueryParams.ATTACHMENT_NAME)
            String name,
        @Query(IRequestAndQueryParams.CREATION_DATE_FROM)
            Date creationDateFrom,
        @Query(IRequestAndQueryParams.CREATION_DATE_TO)
            Date creationDateTo,
        @Query(IRequestAndQueryParams.LIMIT)
            int limit,
        @Query(IRequestAndQueryParams.PAGINATION_DIRECTION)
            PaginationDirection paginationDirection,
        @Query(IRequestAndQueryParams.PAGINATION_TIMESTAMP)
            Date paginationTimestamp,
        @Query(IRequestAndQueryParams.PAGINATION_IDENTIFIER)
            String paginationIdentifier);

    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @GET(
        IPathParts.TICKETS + "/{" + IRequestAndQueryParams.TICKET_ID + "}/" + IPathParts.TICKET_ATTACHMENTS + "/{" + IRequestAndQueryParams.ATTACHMENT_ID + "}")
    Call<HALWSModel> getTicketAttachment(
        @Path((IRequestAndQueryParams.ATTACHMENT_ID))
            String attachmentId,
        @Path(IRequestAndQueryParams.TICKET_ID)
            String ticketId,
        @Query(IRequestAndQueryParams.EMBED)
            String embed);

    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @POST(IPathParts.TICKETS + "/{" + IRequestAndQueryParams.TICKET_ID + "}/" + IPathParts.TICKET_ATTACHMENTS)
    Call<HALWSModel> createTicketAttachment(
        @Path(IRequestAndQueryParams.TICKET_ID)
            String ticketId,
        @Body
            CreateTicketAttachmentPropertiesWSModel ticketAttachmentData);

    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @DELETE(
        IPathParts.TICKETS + "/{" + IRequestAndQueryParams.TICKET_ID + "}/" + IPathParts.TICKET_ATTACHMENTS + "/{" + IRequestAndQueryParams.ATTACHMENT_ID + "}")
    Call<HALWSModel> deleteTicketAttachment(
        @Path(IRequestAndQueryParams.ATTACHMENT_ID)
            String attachmentId,
        @Path(IRequestAndQueryParams.TICKET_ID)
            String ticketId);

    @GET(IPathParts.TICKETS + "/{" + IRequestAndQueryParams.TICKET_ID + "}/" + IPathParts.TICKET_ATTACHMENTS + "/{" + IRequestAndQueryParams.ATTACHMENT_ID +
         "}/data")
    Call<byte[]> getTicketAttachmentData(
        @Path(IRequestAndQueryParams.TICKET_ID)
            String ticketId,
        @Path(IRequestAndQueryParams.ATTACHMENT_ID)
            String attachmentId);

    @Multipart
    @PUT(IPathParts.TICKETS + "/{" + IRequestAndQueryParams.TICKET_ID + "}/" + IPathParts.TICKET_ATTACHMENTS + "/{" + IRequestAndQueryParams.ATTACHMENT_ID +
         "}/data")
    Call<byte[]> createTicketAttachmentData(
        @Path(IRequestAndQueryParams.TICKET_ID)
            String ticketId,
        @Path(IRequestAndQueryParams.ATTACHMENT_ID)
            String attachmentId,
        @Part
            MultipartBody.Part file,
        @Query(IRequestAndQueryParams.ATTACHMENT_MIME_TYPE)
            String mimeType,
        @Query(IRequestAndQueryParams.ATTACHMENT_EDITOR)
            String creator);
}
