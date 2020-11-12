////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 20.10.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.machinestatedetail;

import com.forcam.na.ffwebservices.client.api.AbstractResponseBuilder;
import com.forcam.na.ffwebservices.client.api.HALCollectionWSModel;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.client.api.literal.LiteralLinkModelBuilder;
import com.forcam.na.ffwebservices.client.api.machinestatedetail.request.GetMachineStateDetailsRequest;
import com.forcam.na.ffwebservices.client.api.pagination.response.CollectionResponse;
import com.forcam.na.ffwebservices.model.LinkEmbeddedWSModel;
import com.forcam.na.ffwebservices.model.literal.LiteralPropertiesWSModel;
import com.forcam.na.ffwebservices.model.machinestatedetail.MachineStateDetailEmbed;
import com.forcam.na.ffwebservices.model.machinestatedetail.MachineStateDetailPropertiesWSModel;
import com.forcam.na.ffwebservices.model.machinestatedetail.MachineStateDetailResponse;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Builds responses for machine state details.
 */
public class MachineStateDetailResponseBuilder extends AbstractResponseBuilder implements IMachineStateDetailResponseBuilder {

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
    public MachineStateDetailResponseBuilder(LiteralLinkModelBuilder literalLinkModelBuilder) {
        mLiteralLinkModelBuilder = literalLinkModelBuilder;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public CollectionResponse<MachineStateDetailResponse> getMachineStateDetailCollectionResponse(GetMachineStateDetailsRequest request,
                                                                                                  HALCollectionWSModel collectionModel) {
        final CollectionResponse<MachineStateDetailResponse> collectionResponse = new CollectionResponse<>(request);
        this.initializeCollectionResponse(collectionModel, collectionResponse);

        final Map<String, List<HALWSModel>> embedded = collectionModel.getEmbedded();
        final List<HALWSModel> machineStateDetails = embedded.get("machineStateDetails");

        final List<MachineStateDetailResponse> machineStateDetailModels = machineStateDetails
            .stream()
            .map(this::getMachineStateDetailResponse)
            .collect(Collectors.toList());

        collectionResponse.setEmbedded(machineStateDetailModels);
        return collectionResponse;
    }

    @Override
    public MachineStateDetailResponse getMachineStateDetailResponse(HALWSModel serverModel) {
        final MachineStateDetailResponse machineStateDetailModel = new MachineStateDetailResponse();
        final MachineStateDetailPropertiesWSModel properties = mMapper.convertValue(serverModel.getProperties(), MachineStateDetailPropertiesWSModel.class);
        machineStateDetailModel.setProperties(properties);

        final LinkEmbeddedWSModel<Object> selfLink = this.createSelfLinkModel(serverModel);
        machineStateDetailModel.setSelf(selfLink);

        final LinkEmbeddedWSModel<LiteralPropertiesWSModel> description = mLiteralLinkModelBuilder.buildLinkModel(serverModel,
                                                                                                                  MachineStateDetailEmbed.DESCRIPTION);
        machineStateDetailModel.setDescription(description);

        final LinkEmbeddedWSModel<LiteralPropertiesWSModel> shortDescription = mLiteralLinkModelBuilder.buildLinkModel(serverModel,
                                                                                                                       MachineStateDetailEmbed.SHORT_DESCRIPTION);
        machineStateDetailModel.setShortDescription(shortDescription);

        return machineStateDetailModel;
    }
}