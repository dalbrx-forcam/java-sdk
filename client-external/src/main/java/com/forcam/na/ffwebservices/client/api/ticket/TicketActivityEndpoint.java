////////////////////////////////////////////////////////////////////////////////
//
// Created by tim on 29.11.19.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.ticket;

import com.forcam.na.common.webserviceaccess.requestparams.PaginationDirection;
import com.forcam.na.ffwebservices.client.api.HALCollectionWSModel;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.model.IPathParts;
import com.forcam.na.ffwebservices.model.IRequestAndQueryParams;
import com.forcam.na.ffwebservices.model.ticket.CreateTicketActivityRemarkPropertiesWSModel;
import com.forcam.na.ffwebservices.model.ticket.CreateTicketAttachmentPropertiesWSModel;
import com.forcam.na.ffwebservices.model.ticket.TicketActivityState;
import com.forcam.na.ffwebservices.model.ticket.WriteTicketActivityPropertiesWSModel;
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
public interface TicketActivityEndpoint {

    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @GET(IPathParts.TICKETS + "/{" + IRequestAndQueryParams.TICKET_ID + "}/" + IPathParts.ACTIVITIES)
    Call<HALCollectionWSModel> getTicketActivities(
        @Path(IRequestAndQueryParams.TICKET_ID)
            String ticketId,
        @Query(IRequestAndQueryParams.ACTIVITY_TITLE)
            String activityTitle,
        @Query(IRequestAndQueryParams.ACTIVITY_EDITOR)
            String editor,
        @Query(IRequestAndQueryParams.ACTIVITY_DUE_DATE_FROM)
            Date dueDateStart,
        @Query(IRequestAndQueryParams.ACTIVITY_DUE_DATE_TO)
            Date dueDateEnd,
        @Query(IRequestAndQueryParams.TICKET_ACTIVITY_STATE_ID)
            String ticketActivityStateId,
        @Query(IRequestAndQueryParams.LIMIT)
            int limit,
        @Query(IRequestAndQueryParams.PAGINATION_DIRECTION)
            PaginationDirection paginationDirection,
        @Query(IRequestAndQueryParams.PAGINATION_TIMESTAMP)
            Date paginationTimestamp,
        @Query(IRequestAndQueryParams.PAGINATION_IDENTIFIER)
            String paginationIdentifier);

    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @GET(IPathParts.TICKETS + "/{" + IRequestAndQueryParams.TICKET_ID + "}/" + IPathParts.ACTIVITIES + "/{" + IRequestAndQueryParams.ACTIVITY_ID + "}")
    Call<HALWSModel> getTicketActivity(
        @Path(IRequestAndQueryParams.TICKET_ID)
            String ticketId,
        @Path(IRequestAndQueryParams.ACTIVITY_ID)
            String activityId,
        @Query(IRequestAndQueryParams.EMBED)
            String embed);

    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @POST(IPathParts.TICKETS + "/{" + IRequestAndQueryParams.TICKET_ID + "}/" + IPathParts.ACTIVITIES)
    Call<HALWSModel> createTicketActivity(
        @Path(IRequestAndQueryParams.TICKET_ID)
            String ticketId,
        @Body
            WriteTicketActivityPropertiesWSModel ticketActivityData);

    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @PUT(IPathParts.TICKETS + "/{" + IRequestAndQueryParams.TICKET_ID + "}/" + IPathParts.ACTIVITIES + "/{" + IRequestAndQueryParams.ACTIVITY_ID + "}")
    Call<HALWSModel> updateTicketActivity(
        @Path(IRequestAndQueryParams.TICKET_ID)
            String ticketId,
        @Path(IRequestAndQueryParams.ACTIVITY_ID)
            String activityId,
        @Body
            WriteTicketActivityPropertiesWSModel ticketActivityData);

    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @DELETE(IPathParts.TICKETS + "/{" + IRequestAndQueryParams.TICKET_ID + "}/" + IPathParts.ACTIVITIES + "/{" + IRequestAndQueryParams.ACTIVITY_ID + "}")
    Call<Void> deleteTicketActivity(
        @Path(IRequestAndQueryParams.TICKET_ID)
            String ticketId,
        @Path(IRequestAndQueryParams.ACTIVITY_ID)
            String activityId);

    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @POST(IPathParts.TICKETS + "/{" + IRequestAndQueryParams.TICKET_ID + "}/" + IPathParts.ACTIVITIES + "/{" + IRequestAndQueryParams.ACTIVITY_ID + "}/{" +
          IRequestAndQueryParams.TICKET_ACTIVITY_STATE_ID + "}")
    Call<HALWSModel> setTicketActivityState(
        @Path(IRequestAndQueryParams.TICKET_ID)
            String ticketId,
        @Path(IRequestAndQueryParams.ACTIVITY_ID)
            String activityId,
        @Path(IRequestAndQueryParams.TICKET_ACTIVITY_STATE_ID)
            TicketActivityState ticketActivityState);

    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @GET(IPathParts.TICKETS + "/{" + IRequestAndQueryParams.TICKET_ID + "}/" + IPathParts.ACTIVITIES + "/{" + IRequestAndQueryParams.ACTIVITY_ID + "}/" +
         IPathParts.TICKET_ATTACHMENTS)
    Call<HALCollectionWSModel> getTicketActivityAttachments(
        @Path(IRequestAndQueryParams.TICKET_ID)
            String ticketId,
        @Path(IRequestAndQueryParams.ACTIVITY_ID)
            String activityId,
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
    @GET(IPathParts.TICKETS + "/{" + IRequestAndQueryParams.TICKET_ID + "}/" + IPathParts.ACTIVITIES + "/{" + IRequestAndQueryParams.ACTIVITY_ID + "}/" +
         IPathParts.TICKET_ATTACHMENTS + "/{" + IRequestAndQueryParams.ATTACHMENT_ID + "}")
    Call<HALWSModel> getTicketActivityAttachment(
        @Path(IRequestAndQueryParams.TICKET_ID)
            String ticketId,
        @Path(IRequestAndQueryParams.ACTIVITY_ID)
            String activityId,
        @Path((IRequestAndQueryParams.ATTACHMENT_ID))
            String attachmentId,
        @Query(IRequestAndQueryParams.EMBED)
            String embed);

    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @GET(IPathParts.TICKETS + "/{" + IRequestAndQueryParams.TICKET_ID + "}/" + IPathParts.ACTIVITIES + "/{" + IRequestAndQueryParams.ACTIVITY_ID + "}/" +
         IPathParts.TICKET_ATTACHMENTS + "/{" + IRequestAndQueryParams.ATTACHMENT_ID + "}/data")
    Call<byte[]> getTicketActivityAttachmentData(
        @Path(IRequestAndQueryParams.TICKET_ID)
            String ticketId,
        @Path(IRequestAndQueryParams.ACTIVITY_ID)
            String activityId,
        @Path((IRequestAndQueryParams.ATTACHMENT_ID))
            String attachmentId,
        @Query(IRequestAndQueryParams.EMBED)
            String embed);

    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @DELETE(IPathParts.TICKETS + "/{" + IRequestAndQueryParams.TICKET_ID + "}/" + IPathParts.ACTIVITIES + "/{" + IRequestAndQueryParams.ACTIVITY_ID + "}/" +
            IPathParts.TICKET_ATTACHMENTS + "/{" + IRequestAndQueryParams.ATTACHMENT_ID + "}")
    Call<Void> deleteTicketActivityAttachment(
        @Path(IRequestAndQueryParams.TICKET_ID)
            String ticketId,
        @Path(IRequestAndQueryParams.ACTIVITY_ID)
            String activityId,
        @Path((IRequestAndQueryParams.ATTACHMENT_ID))
            String attachmentId);

    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @POST(IPathParts.TICKETS + "/{" + IRequestAndQueryParams.TICKET_ID + "}/" + IPathParts.ACTIVITIES + "/{" + IRequestAndQueryParams.ACTIVITY_ID + "}/" +
          IPathParts.TICKET_ATTACHMENTS)
    Call<HALWSModel> createTicketActivityAttachment(
        @Path(IRequestAndQueryParams.TICKET_ID)
            String ticketId,
        @Path(IRequestAndQueryParams.ACTIVITY_ID)
            String activityId,
        @Body
            CreateTicketAttachmentPropertiesWSModel ticketActivityAttachmentData);

    @Multipart
    @PUT(IPathParts.TICKETS + "/{" + IRequestAndQueryParams.TICKET_ID + "}/" + IPathParts.ACTIVITIES + "/{" + IRequestAndQueryParams.ACTIVITY_ID + "}/" +
         IPathParts.TICKET_ATTACHMENTS + "/{" + IRequestAndQueryParams.ATTACHMENT_ID + "}/data")
    Call<byte[]> createTicketActivityAttachmentData(
        @Path(IRequestAndQueryParams.TICKET_ID)
            String ticketId,
        @Path(IRequestAndQueryParams.ACTIVITY_ID)
            String activityId,
        @Path(IRequestAndQueryParams.ATTACHMENT_ID)
            String attachmentId,
        @Part
            MultipartBody.Part file,
        @Query(IRequestAndQueryParams.ATTACHMENT_MIME_TYPE)
            String mimeType,
        @Query(IRequestAndQueryParams.ATTACHMENT_EDITOR)
            String creator);

    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @GET(IPathParts.TICKETS + "/{" + IRequestAndQueryParams.TICKET_ID + "}/" + IPathParts.ACTIVITIES + "/{" + IRequestAndQueryParams.ACTIVITY_ID + "}/" +
         IPathParts.TICKET_ACTIVITY_REMARKS)
    Call<HALCollectionWSModel> getTicketActivityRemarks(
        @Path(IRequestAndQueryParams.TICKET_ID)
            String ticketId,
        @Path(IRequestAndQueryParams.ACTIVITY_ID)
            String activityId,
        @Query(IRequestAndQueryParams.ACTIVITY_EDITOR)
            String editor,
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
    @GET(IPathParts.TICKETS + "/{" + IRequestAndQueryParams.TICKET_ID + "}/" + IPathParts.ACTIVITIES + "/{" + IRequestAndQueryParams.ACTIVITY_ID + "}/" +
         IPathParts.TICKET_ACTIVITY_REMARKS + "/{" + IRequestAndQueryParams.ACTIVITY_REMARK_ID + "}")
    Call<HALWSModel> getTicketActivityRemark(
        @Path(IRequestAndQueryParams.TICKET_ID)
            String ticketId,
        @Path(IRequestAndQueryParams.ACTIVITY_ID)
            String activityId,
        @Path((IRequestAndQueryParams.ACTIVITY_REMARK_ID))
            String remarkId,
        @Query(IRequestAndQueryParams.EMBED)
            String embed);

    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @POST(IPathParts.TICKETS + "/{" + IRequestAndQueryParams.TICKET_ID + "}/" + IPathParts.ACTIVITIES + "/{" + IRequestAndQueryParams.ACTIVITY_ID + "}/" +
          IPathParts.TICKET_ACTIVITY_REMARKS)
    Call<HALWSModel> createTicketActivityRemark(
        @Path(IRequestAndQueryParams.TICKET_ID)
            String ticketId,
        @Path(IRequestAndQueryParams.ACTIVITY_ID)
            String activityId,
        @Body
            CreateTicketActivityRemarkPropertiesWSModel ticketActivityRemarkData);

    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @DELETE(IPathParts.TICKETS + "/{" + IRequestAndQueryParams.TICKET_ID + "}/" + IPathParts.ACTIVITIES + "/{" + IRequestAndQueryParams.ACTIVITY_ID + "}/" +
            IPathParts.TICKET_ACTIVITY_REMARKS + "/{" + IRequestAndQueryParams.ACTIVITY_REMARK_ID + "}")
    Call<Void> deleteTicketActivityRemark(
        @Path(IRequestAndQueryParams.TICKET_ID)
            String ticketId,
        @Path(IRequestAndQueryParams.ACTIVITY_ID)
            String activityId,
        @Path((IRequestAndQueryParams.ACTIVITY_REMARK_ID))
            String remarkId);

}
