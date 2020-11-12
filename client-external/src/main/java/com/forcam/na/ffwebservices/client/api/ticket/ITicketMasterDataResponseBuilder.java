////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 27.11.2019.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.ticket;

import com.forcam.na.ffwebservices.client.api.HALCollectionWSModel;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.client.api.pagination.request.CollectionRequest;
import com.forcam.na.ffwebservices.client.api.pagination.response.CollectionResponse;
import com.forcam.na.ffwebservices.model.ticket.TicketActivityStateResponse;
import com.forcam.na.ffwebservices.model.ticket.TicketClassResponse;
import com.forcam.na.ffwebservices.model.ticket.TicketStateResponse;

/**
 * Response builder for {@link TicketStateResponse} and {@link TicketActivityStateResponse}.
 */
public interface ITicketMasterDataResponseBuilder {

    TicketStateResponse getTicketStateResponse(HALWSModel serverModel);

    CollectionResponse<TicketStateResponse> getTicketStatesResponse(CollectionRequest params, HALCollectionWSModel collectionModel);

    TicketActivityStateResponse getTicketActivityStateResponse(HALWSModel serverModel);

    CollectionResponse<TicketActivityStateResponse> getTicketActivityStatesResponse(CollectionRequest params, HALCollectionWSModel collectionModel);

    TicketClassResponse getTicketClassResponse(HALWSModel serverModel);

    CollectionResponse<TicketClassResponse> getTicketClassesResponse(CollectionRequest params, HALCollectionWSModel collectionModel);
}
