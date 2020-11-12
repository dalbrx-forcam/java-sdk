////////////////////////////////////////////////////////////////////////////////
//
// Created by tim on 29.11.19.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.ticket;

import com.forcam.na.ffwebservices.client.api.AbstractResponseBuilder;
import com.forcam.na.ffwebservices.client.api.HALCollectionWSModel;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.client.api.pagination.response.CollectionResponse;
import com.forcam.na.ffwebservices.client.api.ticket.request.GetTicketActivitiesRequest;
import com.forcam.na.ffwebservices.client.api.ticket.request.GetTicketActivityAttachmentsRequest;
import com.forcam.na.ffwebservices.client.api.ticket.request.GetTicketActivityRemarksRequest;
import com.forcam.na.ffwebservices.model.LinkEmbeddedWSModel;
import com.forcam.na.ffwebservices.model.ticket.TicketActivityAttachmentPropertiesWSModel;
import com.forcam.na.ffwebservices.model.ticket.TicketActivityAttachmentResponse;
import com.forcam.na.ffwebservices.model.ticket.TicketActivityPropertiesWSModel;
import com.forcam.na.ffwebservices.model.ticket.TicketActivityRemarkPropertiesWSModel;
import com.forcam.na.ffwebservices.model.ticket.TicketActivityRemarkResponse;
import com.forcam.na.ffwebservices.model.ticket.TicketActivityResponse;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Builds responses for tickets.
 */
public class TicketActivityResponseBuilder extends AbstractResponseBuilder implements ITicketActivityResponseBuilder {

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------
    @Inject
    TicketActivityResponseBuilder() {

    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------
    @Override
    public TicketActivityResponse getTicketActivityResponse(HALWSModel serverModel) {
        final TicketActivityResponse ticketActivityResponse = new TicketActivityResponse();
        final TicketActivityPropertiesWSModel propertiesWSModel = mMapper.convertValue(serverModel.getProperties(), TicketActivityPropertiesWSModel.class);
        ticketActivityResponse.setProperties(propertiesWSModel);

        final LinkEmbeddedWSModel<Object> selfLink = this.createSelfLinkModel(serverModel);
        ticketActivityResponse.setSelf(selfLink);
        return ticketActivityResponse;
    }

    @Override
    public CollectionResponse<TicketActivityResponse> getTicketCollectionResponse(GetTicketActivitiesRequest request, HALCollectionWSModel responseModel) {
        final CollectionResponse<TicketActivityResponse> collectionResponse = new CollectionResponse<>(request);
        this.initializeCollectionResponse(responseModel, collectionResponse);

        final Map<String, List<HALWSModel>> embedded = responseModel.getEmbedded();
        final List<HALWSModel> ticketActivities = embedded.get("activities");

        final List<TicketActivityResponse> ticketActivityModels = ticketActivities
            .stream()
            .map(this::getTicketActivityResponse)
            .collect(Collectors.toList());
        collectionResponse.setEmbedded(ticketActivityModels);
        return collectionResponse;
    }

    @Override
    public TicketActivityAttachmentResponse getTicketActivityAttachmentResponse(HALWSModel serverModel) {
        final TicketActivityAttachmentResponse ticketActivityAttachmentResponse = new TicketActivityAttachmentResponse();
        final TicketActivityAttachmentPropertiesWSModel properties = mMapper.convertValue(serverModel.getProperties(),
                                                                                          TicketActivityAttachmentPropertiesWSModel.class);
        ticketActivityAttachmentResponse.setProperties(properties);

        final LinkEmbeddedWSModel<Object> selfLink = this.createSelfLinkModel(serverModel);
        ticketActivityAttachmentResponse.setSelf(selfLink);

        return ticketActivityAttachmentResponse;
    }

    @Override
    public CollectionResponse<TicketActivityAttachmentResponse> getTicketActivityAttachmentCollectionResponse(GetTicketActivityAttachmentsRequest request,
                                                                                                              HALCollectionWSModel collectionModel) {
        final CollectionResponse<TicketActivityAttachmentResponse> collectionResponse = new CollectionResponse<>(request);
        this.initializeCollectionResponse(collectionModel, collectionResponse);

        final Map<String, List<HALWSModel>> embedded = collectionModel.getEmbedded();
        final List<HALWSModel> attachments = embedded.get("attachments");

        final List<TicketActivityAttachmentResponse> ticketAttachmentModels = attachments
            .stream()
            .map(this::getTicketActivityAttachmentResponse)
            .collect(Collectors.toList());

        collectionResponse.setEmbedded(ticketAttachmentModels);
        return collectionResponse;
    }

    @Override
    public TicketActivityRemarkResponse getTicketActivityRemarkResponse(HALWSModel serverModel) {
        final TicketActivityRemarkResponse ticketActivityRemarkResponse = new TicketActivityRemarkResponse();
        final TicketActivityRemarkPropertiesWSModel properties = mMapper.convertValue(serverModel.getProperties(), TicketActivityRemarkPropertiesWSModel.class);
        ticketActivityRemarkResponse.setProperties(properties);

        final LinkEmbeddedWSModel<Object> selfLink = this.createSelfLinkModel(serverModel);
        ticketActivityRemarkResponse.setSelf(selfLink);

        return ticketActivityRemarkResponse;
    }

    @Override
    public CollectionResponse<TicketActivityRemarkResponse> getTicketActivityRemarkCollectionResponse(GetTicketActivityRemarksRequest request,
                                                                                                      HALCollectionWSModel collectionModel) {
        final CollectionResponse<TicketActivityRemarkResponse> collectionResponse = new CollectionResponse<>(request);
        this.initializeCollectionResponse(collectionModel, collectionResponse);

        final Map<String, List<HALWSModel>> embedded = collectionModel.getEmbedded();
        final List<HALWSModel> remarks = embedded.get("remarks");

        final List<TicketActivityRemarkResponse> ticketRemarksModels = remarks
            .stream()
            .map(this::getTicketActivityRemarkResponse)
            .collect(Collectors.toList());

        collectionResponse.setEmbedded(ticketRemarksModels);
        return collectionResponse;
    }
}
