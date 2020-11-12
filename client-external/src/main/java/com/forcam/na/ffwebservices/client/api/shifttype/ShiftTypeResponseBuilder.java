////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 20.10.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.shifttype;

import com.forcam.na.ffwebservices.client.api.AbstractResponseBuilder;
import com.forcam.na.ffwebservices.client.api.literal.LiteralLinkModelBuilder;
import com.forcam.na.ffwebservices.client.api.pagination.response.CollectionResponse;
import com.forcam.na.ffwebservices.client.api.shifttype.request.GetShiftTypesRequest;
import com.forcam.na.ffwebservices.client.api.workplace.WorkplaceLinkModelBuilder;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.model.LinkEmbeddedWSModel;
import com.forcam.na.ffwebservices.client.api.HALCollectionWSModel;
import com.forcam.na.ffwebservices.model.literal.LiteralPropertiesWSModel;
import com.forcam.na.ffwebservices.model.shifttype.ShiftTypeEmbed;
import com.forcam.na.ffwebservices.model.shifttype.ShiftTypePropertiesWSModel;
import com.forcam.na.ffwebservices.model.shifttype.ShiftTypeResponse;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Builds responses for shift types.
 */
public class ShiftTypeResponseBuilder extends AbstractResponseBuilder implements IShiftTypeResponseBuilder {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The link model builder of a literal. */
    private final LiteralLinkModelBuilder mLiteralLinkModelBuilder;

    /** The link model builder of the workplace. */
    private final WorkplaceLinkModelBuilder mWorkplaceLinkModelBuilder;

    /** The link model builder of the shift type. */
    private final ShiftTypeLinkModelBuilder mShiftTypeLinkModelBuilder;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    @Inject
    public ShiftTypeResponseBuilder(LiteralLinkModelBuilder literalLinkModelBuilder, WorkplaceLinkModelBuilder workplaceLinkModelBuilder,
                                    ShiftTypeLinkModelBuilder shiftTypeLinkModelBuilder) {
        mLiteralLinkModelBuilder = literalLinkModelBuilder;
        mWorkplaceLinkModelBuilder = workplaceLinkModelBuilder;
        mShiftTypeLinkModelBuilder = shiftTypeLinkModelBuilder;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public CollectionResponse<ShiftTypeResponse> getShiftTypeCollectionResponse(GetShiftTypesRequest request, HALCollectionWSModel collectionModel) {
        final CollectionResponse<ShiftTypeResponse> collectionResponse = new CollectionResponse<>(request);
        this.initializeCollectionResponse(collectionModel, collectionResponse);

        final Map<String, List<HALWSModel>> embedded = collectionModel.getEmbedded();
        final List<HALWSModel> shiftTypes = embedded.get("shiftTypes");

        final List<ShiftTypeResponse> shiftTypeModels = shiftTypes
            .stream()
            .map(this::getShiftTypeResponse)
            .collect(Collectors.toList());

        collectionResponse.setEmbedded(shiftTypeModels);
        return collectionResponse;
    }

    @Override
    public ShiftTypeResponse getShiftTypeResponse(HALWSModel serverModel) {
        final ShiftTypeResponse shiftTypeModel = new ShiftTypeResponse();
        final ShiftTypePropertiesWSModel properties = mMapper.convertValue(serverModel.getProperties(), ShiftTypePropertiesWSModel.class);
        shiftTypeModel.setProperties(properties);

        final LinkEmbeddedWSModel<LiteralPropertiesWSModel> description = mLiteralLinkModelBuilder.buildLinkModel(serverModel, ShiftTypeEmbed.DESCRIPTION);
        shiftTypeModel.setDescription(description);

        final LinkEmbeddedWSModel<LiteralPropertiesWSModel> shortDescription = mLiteralLinkModelBuilder.buildLinkModel(serverModel,
                                                                                                                       ShiftTypeEmbed.SHORT_DESCRIPTION);
        shiftTypeModel.setShortDescription(shortDescription);

        final LinkEmbeddedWSModel<Object> selfLink = this.createSelfLinkModel(serverModel);
        shiftTypeModel.setSelf(selfLink);

        return shiftTypeModel;
    }
}