////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 20.10.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.qualitydetail;

import com.forcam.na.ffwebservices.client.api.AbstractResponseBuilder;
import com.forcam.na.ffwebservices.client.api.HALCollectionWSModel;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.client.api.literal.LiteralLinkModelBuilder;
import com.forcam.na.ffwebservices.client.api.pagination.response.CollectionResponse;
import com.forcam.na.ffwebservices.client.api.qualitydetail.request.GetQualityDetailsRequest;
import com.forcam.na.ffwebservices.client.api.qualitytype.QualityTypeLinkModelBuilder;
import com.forcam.na.ffwebservices.model.LinkEmbeddedWSModel;
import com.forcam.na.ffwebservices.model.literal.LiteralPropertiesWSModel;
import com.forcam.na.ffwebservices.model.qualitydetail.QualityDetailEmbed;
import com.forcam.na.ffwebservices.model.qualitydetail.QualityDetailPropertiesWSModel;
import com.forcam.na.ffwebservices.model.qualitydetail.QualityDetailResponse;
import com.forcam.na.ffwebservices.model.qualitytype.QualityTypePropertiesWSModel;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Builds responses for quality details.
 */
public class QualityDetailResponseBuilder extends AbstractResponseBuilder implements IQualityDetailResponseBuilder {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The link model builder of a literal. */
    private final LiteralLinkModelBuilder mLiteralLinkModelBuilder;

    /** The link model builder of the quality type. */
    private final QualityTypeLinkModelBuilder mQualityTypeLinkModelBuilder;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     *
     * @param literalLinkModelBuilder     Literal link model builder.
     * @param qualityTypeLinkModelBuilder Quality type link model builder.
     */
    @Inject
    public QualityDetailResponseBuilder(LiteralLinkModelBuilder literalLinkModelBuilder, QualityTypeLinkModelBuilder qualityTypeLinkModelBuilder) {
        mLiteralLinkModelBuilder = literalLinkModelBuilder;
        mQualityTypeLinkModelBuilder = qualityTypeLinkModelBuilder;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public CollectionResponse<QualityDetailResponse> getQualityDetailCollectionResponse(GetQualityDetailsRequest request,
                                                                                        HALCollectionWSModel collectionModel) {
        final CollectionResponse<QualityDetailResponse> collectionResponse = new CollectionResponse<>(request);
        this.initializeCollectionResponse(collectionModel, collectionResponse);

        final Map<String, List<HALWSModel>> embedded = collectionModel.getEmbedded();
        final List<HALWSModel> qualityDetails = embedded.get("qualityDetails");

        final List<QualityDetailResponse> qualityDetailModels = qualityDetails
            .stream()
            .map(this::getQualityDetailResponse)
            .collect(Collectors.toList());

        collectionResponse.setEmbedded(qualityDetailModels);
        return collectionResponse;
    }

    @Override
    public QualityDetailResponse getQualityDetailResponse(HALWSModel serverModel) {
        final QualityDetailResponse qualityDetailModel = new QualityDetailResponse();
        final QualityDetailPropertiesWSModel properties = mMapper.convertValue(serverModel.getProperties(), QualityDetailPropertiesWSModel.class);
        qualityDetailModel.setProperties(properties);

        final LinkEmbeddedWSModel<Object> selfLink = this.createSelfLinkModel(serverModel);
        qualityDetailModel.setSelf(selfLink);

        final LinkEmbeddedWSModel<LiteralPropertiesWSModel> description = mLiteralLinkModelBuilder.buildLinkModel(serverModel, QualityDetailEmbed.DESCRIPTION);
        qualityDetailModel.setDescription(description);

        final LinkEmbeddedWSModel<LiteralPropertiesWSModel> shortDescription = mLiteralLinkModelBuilder.buildLinkModel(serverModel,
                                                                                                                       QualityDetailEmbed.SHORT_DESCRIPTION);
        qualityDetailModel.setShortDescription(shortDescription);

        final LinkEmbeddedWSModel<QualityTypePropertiesWSModel> qualityType = mQualityTypeLinkModelBuilder.buildLinkModel(serverModel,
                                                                                                                          QualityDetailEmbed.QUALITY_TYPE);
        qualityDetailModel.setQualityType(qualityType);

        return qualityDetailModel;
    }
}