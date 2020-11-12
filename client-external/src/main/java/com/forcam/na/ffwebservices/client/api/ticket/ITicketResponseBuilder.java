////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 06.11.2019.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.ticket;

import com.forcam.na.ffwebservices.client.api.HALCollectionWSModel;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.client.api.pagination.response.CollectionResponse;
import com.forcam.na.ffwebservices.client.api.ticket.request.GetTicketAttachmentsRequest;
import com.forcam.na.ffwebservices.client.api.ticket.request.GetTicketsRequest;
import com.forcam.na.ffwebservices.model.ticket.TicketAttachmentResponse;
import com.forcam.na.ffwebservices.model.ticket.TicketResponse;

/**
 * Contains methods for building responses for tickets.
 */
public interface ITicketResponseBuilder {

    /**
     * Converts HAL model to a ticket model.
     *
     * @param serverModel The server model.
     * @return A ticket model.
     */
    TicketResponse getTicketResponse(HALWSModel serverModel);

    /**
     * Transforms a collection model to a ticket collection response.
     *
     * @param request         The request.
     * @param responseModel A collection model.
     * @return A ticket collection response.
     */
    CollectionResponse<TicketResponse> getTicketCollectionResponse(GetTicketsRequest request, HALCollectionWSModel responseModel);

    TicketAttachmentResponse getTicketAttachmentResponse(HALWSModel serverModel);

    CollectionResponse<TicketAttachmentResponse> getTicketAttachmentCollectionResponse(GetTicketAttachmentsRequest request,
                                                                                       HALCollectionWSModel collectionModel);
}
