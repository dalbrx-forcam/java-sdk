////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 25.01.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.entrypoint;

import com.forcam.na.ffwebservices.client.api.AbstractResponseBuilder;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.model.LinkEmbeddedWSModel;
import com.forcam.na.ffwebservices.model.entrypoint.EntryPointPropertiesWSModel;
import com.forcam.na.ffwebservices.model.entrypoint.EntryPointResponse;

import javax.inject.Inject;

/**
 * Builds responses for entry points.
 */
public class EntryPointResponseBuilder extends AbstractResponseBuilder implements IEntryPointResponseBuilder {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The link model builder. */
    private final NonEmbeddableLinkModelBuilder mLinkModelBuilder;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     *
     * @param nonEmbeddableLinkModelBuilder Non embeddable link model builder.
     */
    @Inject
    public EntryPointResponseBuilder(NonEmbeddableLinkModelBuilder nonEmbeddableLinkModelBuilder) {
        mLinkModelBuilder = nonEmbeddableLinkModelBuilder;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public EntryPointResponse getEntryPointResponse(HALWSModel serverModel) {
        final EntryPointResponse entryPointModel = new EntryPointResponse();
        final EntryPointPropertiesWSModel properties = mMapper.convertValue(serverModel.getProperties(), EntryPointPropertiesWSModel.class);
        entryPointModel.setProperties(properties);

        final LinkEmbeddedWSModel<Object> selfLink = this.createSelfLinkModel(serverModel);
        entryPointModel.setSelf(selfLink);

        final LinkEmbeddedWSModel documentation = mLinkModelBuilder.buildLinkModel(serverModel, "documentation");
        entryPointModel.setDocumentation(documentation);

        final LinkEmbeddedWSModel productionOrders = mLinkModelBuilder.buildLinkModel(serverModel, "productionOrders");
        entryPointModel.setProductionOrders(productionOrders);

        final LinkEmbeddedWSModel operations = mLinkModelBuilder.buildLinkModel(serverModel, "operations");
        entryPointModel.setOperations(operations);

        final LinkEmbeddedWSModel workplaces = mLinkModelBuilder.buildLinkModel(serverModel, "workplaces");
        entryPointModel.setWorkplaces(workplaces);

        final LinkEmbeddedWSModel staffMembers = mLinkModelBuilder.buildLinkModel(serverModel, "staffMembers");
        entryPointModel.setStaffMembers(staffMembers);

        final LinkEmbeddedWSModel tools = mLinkModelBuilder.buildLinkModel(serverModel, "tools");
        entryPointModel.setTools(tools);

        final LinkEmbeddedWSModel workplaceGroups = mLinkModelBuilder.buildLinkModel(serverModel, "workplaceGroups");
        entryPointModel.setTools(workplaceGroups);

        return entryPointModel;
    }
}