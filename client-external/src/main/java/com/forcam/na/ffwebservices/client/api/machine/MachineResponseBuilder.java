////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 08.11.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.machine;

import com.forcam.na.ffwebservices.client.api.AbstractResponseBuilder;
import com.forcam.na.ffwebservices.client.api.erpcontext.ERPContextLinkModelBuilder;
import com.forcam.na.ffwebservices.client.api.literal.LiteralLinkModelBuilder;
import com.forcam.na.ffwebservices.client.api.machine.request.GetMachinesRequest;
import com.forcam.na.ffwebservices.client.api.pagination.response.CollectionResponse;
import com.forcam.na.ffwebservices.client.api.workplace.WorkplaceLinkModelBuilder;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.model.LinkEmbeddedWSModel;
import com.forcam.na.ffwebservices.client.api.HALCollectionWSModel;
import com.forcam.na.ffwebservices.model.erpcontext.ErpContextPropertiesWSModel;
import com.forcam.na.ffwebservices.model.literal.LiteralPropertiesWSModel;
import com.forcam.na.ffwebservices.model.machine.MachineEmbed;
import com.forcam.na.ffwebservices.model.machine.MachinePropertiesWSModel;
import com.forcam.na.ffwebservices.model.machine.MachineResponse;
import com.forcam.na.ffwebservices.model.workplace.WorkplacePropertiesWSModel;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Builds responses for machines.
 */
public class MachineResponseBuilder extends AbstractResponseBuilder implements IMachineResponseBuilder {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The link model builder of the erp context. */
    private final ERPContextLinkModelBuilder mERPContextLinkModelBuilder;

    /** The link model builder of a literal. */
    private final LiteralLinkModelBuilder mLiteralLinkModelBuilder;

    /** The link model builder of the workplace. */
    private final WorkplaceLinkModelBuilder mWorkplaceLinkModelBuilder;

    // ------------------------------------------------------------------------
    // constructor
    // ------------------------------------------------------------------------

    @Inject
    public MachineResponseBuilder(ERPContextLinkModelBuilder erpContextLinkModelBuilder, LiteralLinkModelBuilder literalLinkModelBuilder,
                                  WorkplaceLinkModelBuilder workplaceLinkModelBuilder) {
        mERPContextLinkModelBuilder = erpContextLinkModelBuilder;
        mLiteralLinkModelBuilder = literalLinkModelBuilder;
        mWorkplaceLinkModelBuilder = workplaceLinkModelBuilder;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public CollectionResponse<MachineResponse> getMachineCollectionResponse(GetMachinesRequest request, HALCollectionWSModel collectionModel) {
        final CollectionResponse<MachineResponse> collectionResponse = new CollectionResponse<>(request);
        this.initializeCollectionResponse(collectionModel, collectionResponse);

        final Map<String, List<HALWSModel>> embedded = collectionModel.getEmbedded();
        final List<HALWSModel> machines = embedded.get("machines");

        final List<MachineResponse> machineModels = machines
            .stream()
            .map(this::getMachineResponse)
            .collect(Collectors.toList());

        collectionResponse.setEmbedded(machineModels);
        return collectionResponse;
    }

    @Override
    public MachineResponse getMachineResponse(HALWSModel serverModel) {
        final MachineResponse machineModel = new MachineResponse();
        final MachinePropertiesWSModel properties = mMapper.convertValue(serverModel.getProperties(), MachinePropertiesWSModel.class);
        machineModel.setProperties(properties);

        final LinkEmbeddedWSModel<Object> selfLink = this.createSelfLinkModel(serverModel);
        machineModel.setSelf(selfLink);

        final LinkEmbeddedWSModel<ErpContextPropertiesWSModel> erpContext = mERPContextLinkModelBuilder.buildLinkModel(serverModel, MachineEmbed.ERP_CONTEXT);
        machineModel.setErpContext(erpContext);

        final LinkEmbeddedWSModel<LiteralPropertiesWSModel> description = mLiteralLinkModelBuilder.buildLinkModel(serverModel, MachineEmbed.DESCRIPTION);
        machineModel.setDescription(description);

        final LinkEmbeddedWSModel<WorkplacePropertiesWSModel> workplace = mWorkplaceLinkModelBuilder.buildLinkModel(serverModel, MachineEmbed.WORKPLACE);
        machineModel.setWorkplace(workplace);

        return machineModel;
    }
}