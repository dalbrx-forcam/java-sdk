////////////////////////////////////////////////////////////////////////////////
//
// Created by tim on 29.11.19.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.ticket;

import com.forcam.na.ffwebservices.client.api.HALCollectionWSModel;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.client.api.pagination.response.CollectionResponse;
import com.forcam.na.ffwebservices.client.api.ticket.request.GetTicketActivitiesRequest;
import com.forcam.na.ffwebservices.client.api.ticket.request.GetTicketActivityAttachmentsRequest;
import com.forcam.na.ffwebservices.client.api.ticket.request.GetTicketActivityRemarksRequest;
import com.forcam.na.ffwebservices.model.ticket.TicketActivityAttachmentResponse;
import com.forcam.na.ffwebservices.model.ticket.TicketActivityRemarkResponse;
import com.forcam.na.ffwebservices.model.ticket.TicketActivityResponse;

/**
 * Contains methods for building responses for ticket activities.
 */
public interface ITicketActivityResponseBuilder {
    /**
     * Converts HAL model to a ticket activity model.
     *
     * @param serverModel The server model.
     * @return A ticket activity model.
     */
    TicketActivityResponse getTicketActivityResponse(HALWSModel serverModel);

    /**
     * Transforms a collection model to a ticket activity collection response.
     *
     * @param request       The request.
     * @param responseModel A collection model.
     * @return A ticket activity collection response.
     */
    CollectionResponse<TicketActivityResponse> getTicketCollectionResponse(GetTicketActivitiesRequest request, HALCollectionWSModel responseModel);

    /**
     * Converts HAL model to a ticket activity attachment model.
     *
     * @param serverModel The server model.
     * @return A ticket activity attachment model.
     */
    TicketActivityAttachmentResponse getTicketActivityAttachmentResponse(HALWSModel serverModel);

    /**
     * Transforms a collection model to a ticket activity attachment collection response.
     *
     * @param request         The request.
     * @param collectionModel A collection model.
     * @return A ticket activity attachment collection response.
     */
    CollectionResponse<TicketActivityAttachmentResponse> getTicketActivityAttachmentCollectionResponse(GetTicketActivityAttachmentsRequest request,
                                                                                                       HALCollectionWSModel collectionModel);

    /**
     * Converts HAL model to a ticket activity remark model.
     *
     * @param serverModel The server model.
     * @return A ticket activity remark model.
     */
    TicketActivityRemarkResponse getTicketActivityRemarkResponse(HALWSModel serverModel);

    /**
     * Transforms a collection model to a ticket activity remark collection response.
     *
     * @param request         The request.
     * @param collectionModel A collection model.
     * @return A ticket activity remark collection response.
     */
    CollectionResponse<TicketActivityRemarkResponse> getTicketActivityRemarkCollectionResponse(GetTicketActivityRemarksRequest request,
                                                                                                   HALCollectionWSModel collectionModel);
}
