////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 27.11.2019.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.ticket;

import com.forcam.na.ffwebservices.client.api.AbstractResponseBuilder;
import com.forcam.na.ffwebservices.client.api.HALCollectionWSModel;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.client.api.literal.LiteralLinkModelBuilder;
import com.forcam.na.ffwebservices.client.api.pagination.request.CollectionRequest;
import com.forcam.na.ffwebservices.client.api.pagination.response.CollectionResponse;
import com.forcam.na.ffwebservices.model.LinkEmbeddedWSModel;
import com.forcam.na.ffwebservices.model.literal.LiteralPropertiesWSModel;
import com.forcam.na.ffwebservices.model.statusdefinition.StatusDefinitionEmbed;
import com.forcam.na.ffwebservices.model.ticket.TicketActivityStatePropertiesWSModel;
import com.forcam.na.ffwebservices.model.ticket.TicketActivityStateResponse;
import com.forcam.na.ffwebservices.model.ticket.TicketClassPropertiesWSModel;
import com.forcam.na.ffwebservices.model.ticket.TicketClassResponse;
import com.forcam.na.ffwebservices.model.ticket.TicketStateEmbed;
import com.forcam.na.ffwebservices.model.ticket.TicketStatePropertiesWSModel;
import com.forcam.na.ffwebservices.model.ticket.TicketStateResponse;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 */
public class TicketMasterDataResponseBuilder extends AbstractResponseBuilder implements ITicketMasterDataResponseBuilder {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------

    /** Key for getting the machine states from a map. */
    private String TICKET_STATES_KEY = "ticketStates";

    /** Key for getting the operation phases from a map. */
    private String TICKET_ACTIVITY_STATES_KEY = "ticketActivityStates";

    /** Key for getting the tool assembly states from a map. */
    private String TICKET_CLASSES_KEY = "ticketClasses";

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private final LiteralLinkModelBuilder mLiteralLinkModelBuilder;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    @Inject
    TicketMasterDataResponseBuilder(LiteralLinkModelBuilder literalLinkModelBuilder) {
        mLiteralLinkModelBuilder = literalLinkModelBuilder;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public TicketStateResponse getTicketStateResponse(HALWSModel serverModel) {
        final TicketStateResponse ticketStateResponse = new TicketStateResponse();
        final TicketStatePropertiesWSModel properties = mMapper.convertValue(serverModel.getProperties(), TicketStatePropertiesWSModel.class);
        ticketStateResponse.setProperties(properties);

        final LinkEmbeddedWSModel<Object> selfLink = this.createSelfLinkModel(serverModel);
        ticketStateResponse.setSelf(selfLink);

        final LinkEmbeddedWSModel<LiteralPropertiesWSModel> name = mLiteralLinkModelBuilder.buildLinkModel(serverModel, TicketStateEmbed.NAME);
        ticketStateResponse.setName(name);

        return ticketStateResponse;
    }

    @Override
    public CollectionResponse<TicketStateResponse> getTicketStatesResponse(CollectionRequest params, HALCollectionWSModel collectionModel) {
        final CollectionResponse<TicketStateResponse> collectionResponse = new CollectionResponse<>(params);
        this.initializeCollectionResponse(collectionModel, collectionResponse);

        final Map<String, List<HALWSModel>> embedded = collectionModel.getEmbedded();
        final List<HALWSModel> statusDefinitions = embedded.get(TICKET_STATES_KEY);

        final List<TicketStateResponse> statusDefinitionModels = statusDefinitions
            .stream()
            .map(this::getTicketStateResponse)
            .collect(Collectors.toList());

        collectionResponse.setEmbedded(statusDefinitionModels);
        return collectionResponse;
    }

    @Override
    public TicketActivityStateResponse getTicketActivityStateResponse(HALWSModel serverModel) {
        final TicketActivityStateResponse ticketStateResponse = new TicketActivityStateResponse();
        final TicketActivityStatePropertiesWSModel properties = mMapper.convertValue(serverModel.getProperties(), TicketActivityStatePropertiesWSModel.class);
        ticketStateResponse.setProperties(properties);

        final LinkEmbeddedWSModel<Object> selfLink = this.createSelfLinkModel(serverModel);
        ticketStateResponse.setSelf(selfLink);

        return ticketStateResponse;
    }

    @Override
    public CollectionResponse<TicketActivityStateResponse> getTicketActivityStatesResponse(CollectionRequest params, HALCollectionWSModel collectionModel) {
        final CollectionResponse<TicketActivityStateResponse> collectionResponse = new CollectionResponse<>(params);
        this.initializeCollectionResponse(collectionModel, collectionResponse);

        final Map<String, List<HALWSModel>> embedded = collectionModel.getEmbedded();
        final List<HALWSModel> statusDefinitions = embedded.get(TICKET_ACTIVITY_STATES_KEY);

        final List<TicketActivityStateResponse> statusDefinitionModels = statusDefinitions
            .stream()
            .map(this::getTicketActivityStateResponse)
            .collect(Collectors.toList());

        collectionResponse.setEmbedded(statusDefinitionModels);
        return collectionResponse;
    }

    @Override
    public TicketClassResponse getTicketClassResponse(HALWSModel serverModel) {
        final TicketClassResponse ticketStateResponse = new TicketClassResponse();
        final TicketClassPropertiesWSModel properties = mMapper.convertValue(serverModel.getProperties(), TicketClassPropertiesWSModel.class);
        ticketStateResponse.setProperties(properties);

        final LinkEmbeddedWSModel<Object> selfLink = this.createSelfLinkModel(serverModel);
        ticketStateResponse.setSelf(selfLink);

        final LinkEmbeddedWSModel<LiteralPropertiesWSModel> description = mLiteralLinkModelBuilder.buildLinkModel(serverModel,
                                                                                                                  StatusDefinitionEmbed.DESCRIPTION);
        ticketStateResponse.setDescription(description);

        final LinkEmbeddedWSModel<LiteralPropertiesWSModel> shortDescription = mLiteralLinkModelBuilder.buildLinkModel(serverModel,
                                                                                                                       StatusDefinitionEmbed.SHORT_DESCRIPTION);
        ticketStateResponse.setShortDescription(shortDescription);

        return ticketStateResponse;
    }

    @Override
    public CollectionResponse<TicketClassResponse> getTicketClassesResponse(CollectionRequest params, HALCollectionWSModel collectionModel) {
        final CollectionResponse<TicketClassResponse> collectionResponse = new CollectionResponse<>(params);
        this.initializeCollectionResponse(collectionModel, collectionResponse);

        final Map<String, List<HALWSModel>> embedded = collectionModel.getEmbedded();
        final List<HALWSModel> statusDefinitions = embedded.get(TICKET_CLASSES_KEY);

        final List<TicketClassResponse> statusDefinitionModels = statusDefinitions
            .stream()
            .map(this::getTicketClassResponse)
            .collect(Collectors.toList());

        collectionResponse.setEmbedded(statusDefinitionModels);
        return collectionResponse;
    }
}
