////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 27.11.2019.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.ticket;

import com.forcam.na.ffwebservices.client.api.HALCollectionWSModel;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.model.IPathParts;
import com.forcam.na.ffwebservices.model.IRequestAndQueryParams;
import com.forcam.na.ffwebservices.model.ticket.TicketActivityState;
import com.forcam.na.ffwebservices.model.ticket.TicketState;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Endpoint for ticket master data.
 */
public interface TicketMasterDataEndpoint {

    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @GET(IPathParts.MASTER_DATA + "/" + IPathParts.TICKET_STATES + "/{" + IRequestAndQueryParams.TICKET_STATE_ID + "}")
    Call<HALWSModel> getTicketState(
        @Path(IRequestAndQueryParams.TICKET_STATE_ID)
            TicketState ticketStateId,
        @Query(IRequestAndQueryParams.EMBED)
            String embed);

    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @GET(IPathParts.MASTER_DATA + "/" + IPathParts.TICKET_STATES)
    Call<HALCollectionWSModel> getTicketStates(
        @Query(IRequestAndQueryParams.LIMIT)
            int limit,
        @Query(IRequestAndQueryParams.OFFSET)
            int offset,
        @Query(IRequestAndQueryParams.EMBED)
            String embed);

    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @GET(IPathParts.MASTER_DATA + "/" + IPathParts.TICKET_ACTIVITY_STATES + "/{" + IRequestAndQueryParams.TICKET_ACTIVITY_STATE_ID + "}")
    Call<HALWSModel> getTicketActivityState(
        @Path(IRequestAndQueryParams.TICKET_ACTIVITY_STATE_ID)
            TicketActivityState ticketActivityStateId);

    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @GET(IPathParts.MASTER_DATA + "/" + IPathParts.TICKET_ACTIVITY_STATES)
    Call<HALCollectionWSModel> getTicketActivityStates(
        @Query(IRequestAndQueryParams.LIMIT)
            int limit,
        @Query(IRequestAndQueryParams.OFFSET)
            int offset);

    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @GET(IPathParts.MASTER_DATA + "/" + IPathParts.TICKET_CLASSES + "/{" + IRequestAndQueryParams.TICKET_CLASS_ID + "}")
    Call<HALWSModel> getTicketClass(
        @Path(IRequestAndQueryParams.TICKET_CLASS_ID)
            String ticketClassId,
        @Query(IRequestAndQueryParams.EMBED)
            String embed);

    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @GET(IPathParts.MASTER_DATA + "/" + IPathParts.TICKET_CLASSES)
    Call<HALCollectionWSModel> getTicketClasses(
        @Query(IRequestAndQueryParams.LIMIT)
            int limit,
        @Query(IRequestAndQueryParams.OFFSET)
            int offset,
        @Query(IRequestAndQueryParams.EMBED)
            String embed);

}
