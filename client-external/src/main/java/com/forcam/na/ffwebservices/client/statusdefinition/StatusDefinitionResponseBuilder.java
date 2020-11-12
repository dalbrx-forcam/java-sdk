////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 20.10.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.statusdefinition;

import com.forcam.na.ffwebservices.client.api.AbstractResponseBuilder;
import com.forcam.na.ffwebservices.client.api.HALCollectionWSModel;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.client.api.literal.LiteralLinkModelBuilder;
import com.forcam.na.ffwebservices.client.api.pagination.request.CollectionRequest;
import com.forcam.na.ffwebservices.client.api.pagination.response.CollectionResponse;
import com.forcam.na.ffwebservices.model.LinkEmbeddedWSModel;
import com.forcam.na.ffwebservices.model.literal.LiteralPropertiesWSModel;
import com.forcam.na.ffwebservices.model.statusdefinition.StatusDefinitionEmbed;
import com.forcam.na.ffwebservices.model.statusdefinition.StatusDefinitionPropertiesWSModel;
import com.forcam.na.ffwebservices.model.statusdefinition.StatusDefinitionResponse;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Builds responses for status definitions.
 */
public class StatusDefinitionResponseBuilder extends AbstractResponseBuilder implements IStatusDefinitionResponseBuilder {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The link model builder of a literal. */
    private final LiteralLinkModelBuilder mLiteralLinkModelBuilder;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     *
     * @param literalLinkModelBuilder Literal link model builder.
     */
    @Inject
    public StatusDefinitionResponseBuilder(LiteralLinkModelBuilder literalLinkModelBuilder) {
        mLiteralLinkModelBuilder = literalLinkModelBuilder;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public CollectionResponse<StatusDefinitionResponse> getStatusDefinitionCollectionResponse(CollectionRequest params, HALCollectionWSModel collectionModel,
                                                                                              String statusDefinitionKey) {
        final CollectionResponse<StatusDefinitionResponse> collectionResponse = new CollectionResponse<>(params);
        this.initializeCollectionResponse(collectionModel, collectionResponse);

        final Map<String, List<HALWSModel>> embedded = collectionModel.getEmbedded();
        final List<HALWSModel> statusDefinitions = embedded.get(statusDefinitionKey);

        final List<StatusDefinitionResponse> statusDefinitionModels = statusDefinitions
            .stream()
            .map(this::getStatusDefinitionResponse)
            .collect(Collectors.toList());

        collectionResponse.setEmbedded(statusDefinitionModels);
        return collectionResponse;
    }

    @Override
    public StatusDefinitionResponse getStatusDefinitionResponse(HALWSModel serverModel) {
        final StatusDefinitionResponse statusDefinitionModel = new StatusDefinitionResponse();
        final StatusDefinitionPropertiesWSModel properties = mMapper.convertValue(serverModel.getProperties(), StatusDefinitionPropertiesWSModel.class);
        statusDefinitionModel.setProperties(properties);

        final LinkEmbeddedWSModel<Object> selfLink = this.createSelfLinkModel(serverModel);
        statusDefinitionModel.setSelf(selfLink);

        final LinkEmbeddedWSModel<LiteralPropertiesWSModel> description = mLiteralLinkModelBuilder.buildLinkModel(serverModel,
                                                                                                                  StatusDefinitionEmbed.DESCRIPTION);
        statusDefinitionModel.setDescription(description);

        final LinkEmbeddedWSModel<LiteralPropertiesWSModel> shortDescription = mLiteralLinkModelBuilder.buildLinkModel(serverModel,
                                                                                                                       StatusDefinitionEmbed.SHORT_DESCRIPTION);
        statusDefinitionModel.setShortDescription(shortDescription);

        return statusDefinitionModel;
    }
}