////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 06.11.2019.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.ticket;

import com.forcam.na.ffwebservices.client.api.AbstractResponseBuilder;
import com.forcam.na.ffwebservices.client.api.HALCollectionWSModel;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.client.api.pagination.response.CollectionResponse;
import com.forcam.na.ffwebservices.client.api.ticket.request.GetTicketAttachmentsRequest;
import com.forcam.na.ffwebservices.client.api.ticket.request.GetTicketsRequest;
import com.forcam.na.ffwebservices.model.LinkEmbeddedWSModel;
import com.forcam.na.ffwebservices.model.ticket.TicketAttachmentPropertiesWSModel;
import com.forcam.na.ffwebservices.model.ticket.TicketAttachmentResponse;
import com.forcam.na.ffwebservices.model.ticket.TicketPropertiesWSModel;
import com.forcam.na.ffwebservices.model.ticket.TicketResponse;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Builds responses for tickets.
 */
public class TicketResponseBuilder extends AbstractResponseBuilder implements ITicketResponseBuilder {

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    @Inject
    TicketResponseBuilder() {

    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public TicketResponse getTicketResponse(HALWSModel serverModel) {
        final TicketResponse ticketResponse = new TicketResponse();
        final TicketPropertiesWSModel properties = mMapper.convertValue(serverModel.getProperties(), TicketPropertiesWSModel.class);
        ticketResponse.setProperties(properties);

        final LinkEmbeddedWSModel<Object> selfLink = this.createSelfLinkModel(serverModel);
        ticketResponse.setSelf(selfLink);

        return ticketResponse;
    }

    @Override
    public CollectionResponse<TicketResponse> getTicketCollectionResponse(GetTicketsRequest request, HALCollectionWSModel collectionModel) {
        final CollectionResponse<TicketResponse> collectionResponse = new CollectionResponse<>(request);
        this.initializeCollectionResponse(collectionModel, collectionResponse);

        final Map<String, List<HALWSModel>> embedded = collectionModel.getEmbedded();
        final List<HALWSModel> tickets = embedded.get("tickets");

        final List<TicketResponse> ticketModels = tickets
            .stream()
            .map(this::getTicketResponse)
            .collect(Collectors.toList());

        collectionResponse.setEmbedded(ticketModels);
        return collectionResponse;
    }

    @Override
    public TicketAttachmentResponse getTicketAttachmentResponse(HALWSModel serverModel) {
        final TicketAttachmentResponse ticketAttachmentResponse = new TicketAttachmentResponse();
        final TicketAttachmentPropertiesWSModel properties = mMapper.convertValue(serverModel.getProperties(), TicketAttachmentPropertiesWSModel.class);
        ticketAttachmentResponse.setProperties(properties);

        final LinkEmbeddedWSModel<Object> selfLink = this.createSelfLinkModel(serverModel);
        ticketAttachmentResponse.setSelf(selfLink);

        return ticketAttachmentResponse;
    }

    @Override
    public CollectionResponse<TicketAttachmentResponse> getTicketAttachmentCollectionResponse(GetTicketAttachmentsRequest request, HALCollectionWSModel collectionModel) {
        final CollectionResponse<TicketAttachmentResponse> collectionResponse = new CollectionResponse<>(request);
        this.initializeCollectionResponse(collectionModel, collectionResponse);

        final Map<String, List<HALWSModel>> embedded = collectionModel.getEmbedded();
        final List<HALWSModel> attachments = embedded.get("attachments");

        final List<TicketAttachmentResponse> ticketAttachmentModels = attachments
            .stream()
            .map(this::getTicketAttachmentResponse)
            .collect(Collectors.toList());

        collectionResponse.setEmbedded(ticketAttachmentModels);
        return collectionResponse;
    }
}
