////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 09.01.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.qualitytype;

import com.forcam.na.ffwebservices.client.api.AbstractResponseBuilder;
import com.forcam.na.ffwebservices.client.api.HALCollectionWSModel;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.client.api.literal.LiteralLinkModelBuilder;
import com.forcam.na.ffwebservices.client.api.pagination.response.CollectionResponse;
import com.forcam.na.ffwebservices.client.api.qualitytype.request.GetQualityTypesRequest;
import com.forcam.na.ffwebservices.model.LinkEmbeddedWSModel;
import com.forcam.na.ffwebservices.model.literal.LiteralPropertiesWSModel;
import com.forcam.na.ffwebservices.model.qualitytype.QualityTypeEmbed;
import com.forcam.na.ffwebservices.model.qualitytype.QualityTypePropertiesWSModel;
import com.forcam.na.ffwebservices.model.qualitytype.QualityTypeResponse;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Builds responses for quality types.
 */
public class QualityTypeResponseBuilder extends AbstractResponseBuilder implements IQualityTypeResponseBuilder {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The link model builder of a literal. */
    private final LiteralLinkModelBuilder mLiteralLinkModelBuilder;

    /**
     * Creates a new instance.
     *
     * @param literalLinkModelBuilder Literal link model builder.
     */
    @Inject
    public QualityTypeResponseBuilder(LiteralLinkModelBuilder literalLinkModelBuilder) {
        mLiteralLinkModelBuilder = literalLinkModelBuilder;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public CollectionResponse<QualityTypeResponse> getQualityTypeCollectionResponse(GetQualityTypesRequest request, HALCollectionWSModel collectionModel) {
        final CollectionResponse<QualityTypeResponse> collectionResponse = new CollectionResponse<>(request);
        this.initializeCollectionResponse(collectionModel, collectionResponse);

        final Map<String, List<HALWSModel>> embedded = collectionModel.getEmbedded();
        final List<HALWSModel> qualityTypes = embedded.get("qualityTypes");

        final List<QualityTypeResponse> qualityTypeModels = qualityTypes
            .stream()
            .map(this::getQualityTypeResponse)
            .collect(Collectors.toList());

        collectionResponse.setEmbedded(qualityTypeModels);
        return collectionResponse;
    }

    @Override
    public QualityTypeResponse getQualityTypeResponse(HALWSModel serverModel) {
        final QualityTypeResponse qualityTypeModel = new QualityTypeResponse();
        final QualityTypePropertiesWSModel properties = mMapper.convertValue(serverModel.getProperties(), QualityTypePropertiesWSModel.class);
        qualityTypeModel.setProperties(properties);

        final LinkEmbeddedWSModel<Object> selfLink = this.createSelfLinkModel(serverModel);
        qualityTypeModel.setSelf(selfLink);

        final LinkEmbeddedWSModel<LiteralPropertiesWSModel> description = mLiteralLinkModelBuilder.buildLinkModel(serverModel, QualityTypeEmbed.DESCRIPTION);
        qualityTypeModel.setDescription(description);

        final LinkEmbeddedWSModel<LiteralPropertiesWSModel> shortDescription = mLiteralLinkModelBuilder.buildLinkModel(serverModel,
                                                                                                                       QualityTypeEmbed.SHORT_DESCRIPTION);
        qualityTypeModel.setShortDescription(shortDescription);

        return qualityTypeModel;
    }
}