////////////////////////////////////////////////////////////////////////////////
//
// Created by DZeise on 10.03.2020.
//
// Copyright (c) 2006 - 2020 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.masterdata.document.builder;

import com.forcam.na.ffwebservices.client.api.AbstractResponseBuilder;
import com.forcam.na.ffwebservices.client.api.HALCollectionWSModel;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.client.api.literal.LiteralLinkModelBuilder;
import com.forcam.na.ffwebservices.client.api.masterdata.document.request.GetDocumentStateCollectionRequest;
import com.forcam.na.ffwebservices.client.api.pagination.response.CollectionResponse;
import com.forcam.na.ffwebservices.model.LinkEmbeddedWSModel;
import com.forcam.na.ffwebservices.model.literal.LiteralPropertiesWSModel;
import com.forcam.na.ffwebservices.model.statusdefinition.DocumentStateEmbed;
import com.forcam.na.ffwebservices.model.statusdefinition.DocumentStatePropertiesWSModel;
import com.forcam.na.ffwebservices.model.statusdefinition.DocumentStateResponse;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Builds responses for document states.
 */
public class DocumentStateResponseBuilder extends AbstractResponseBuilder implements IDocumentStateResponseBuilder {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The link model builder of a literal. */
    private final LiteralLinkModelBuilder mLiteralLinkModelBuilder;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    @Inject
    public DocumentStateResponseBuilder(LiteralLinkModelBuilder literalLinkModelBuilder) {
        mLiteralLinkModelBuilder = literalLinkModelBuilder;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public CollectionResponse<DocumentStateResponse> getDocumentStateCollectionResponse(GetDocumentStateCollectionRequest request,
                                                                                        HALCollectionWSModel collectionModel) {

        final CollectionResponse<DocumentStateResponse> collectionResponse = new CollectionResponse<>(request);
        this.initializeCollectionResponse(collectionModel, collectionResponse);

        final Map<String, List<HALWSModel>> embedded = collectionModel.getEmbedded();
        final List<HALWSModel> documentStates = embedded.get(DOCUMENT_STATES_KEY);

        final List<DocumentStateResponse> documentStateModels = documentStates
            .stream()
            .map(this::getDocumentStateResponse)
            .collect(Collectors.toList());

        collectionResponse.setEmbedded(documentStateModels);
        return collectionResponse;
    }

    @Override
    public DocumentStateResponse getDocumentStateResponse(HALWSModel serverModel) {
        final DocumentStateResponse documentStateResponse = new DocumentStateResponse();
        final DocumentStatePropertiesWSModel properties = mMapper.convertValue(serverModel.getProperties(), DocumentStatePropertiesWSModel.class);
        documentStateResponse.setProperties(properties);

        final LinkEmbeddedWSModel<Object> selfLink = this.createSelfLinkModel(serverModel);
        documentStateResponse.setSelf(selfLink);

        final LinkEmbeddedWSModel<LiteralPropertiesWSModel> description = mLiteralLinkModelBuilder.buildLinkModel(serverModel, DocumentStateEmbed.DESCRIPTION);
        documentStateResponse.setDescription(description);

        return documentStateResponse;
    }

}
