////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 05.01.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.tool;

import com.forcam.na.ffwebservices.client.api.AbstractResponseBuilder;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.client.api.workplace.WorkplaceLinkModelBuilder;
import com.forcam.na.ffwebservices.model.LinkEmbeddedWSModel;
import com.forcam.na.ffwebservices.model.tool.ToolLocationGeneralDefinitionWSModel;
import com.forcam.na.ffwebservices.model.tool.ToolLocationResponse;
import com.forcam.na.ffwebservices.model.tool.ToolPropertiesWSModel;
import com.forcam.na.ffwebservices.model.workplace.WorkplacePropertiesWSModel;

import javax.inject.Inject;

/**
 * Builds responses for locations of tools.
 */
public class ToolLocationResponseBuilder extends AbstractResponseBuilder implements IToolLocationResponseBuilder {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The link model builder of the tool. */
    private final ToolLinkModelBuilder mToolLinkModelBuilder;

    /** The link model builder of the workplace. */
    private final WorkplaceLinkModelBuilder mWorkplaceLinkModelBuilder;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     *
     * @param workplaceLinkModelBuilder Workplace link model builder.
     * @param toolLinkModelBuilder      Tool link model builder.
     */
    @Inject
    public ToolLocationResponseBuilder(ToolLinkModelBuilder toolLinkModelBuilder, WorkplaceLinkModelBuilder workplaceLinkModelBuilder) {
        mToolLinkModelBuilder = toolLinkModelBuilder;
        mWorkplaceLinkModelBuilder = workplaceLinkModelBuilder;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public ToolLocationResponse getToolLocationResponse(HALWSModel serverModel) {
        final ToolLocationResponse locationModel = new ToolLocationResponse();
        final ToolLocationGeneralDefinitionWSModel properties = mMapper.convertValue(serverModel.getProperties(), ToolLocationGeneralDefinitionWSModel.class);
        locationModel.setProperties(properties);

        final LinkEmbeddedWSModel<Object> selfLink = this.createSelfLinkModel(serverModel);
        locationModel.setSelf(selfLink);

        final LinkEmbeddedWSModel<ToolPropertiesWSModel> tool = mToolLinkModelBuilder.buildLinkModel(serverModel, "tool");
        locationModel.setTool(tool);

        final LinkEmbeddedWSModel<WorkplacePropertiesWSModel> workplace = mWorkplaceLinkModelBuilder.buildLinkModel(serverModel, "workplace");
        locationModel.setWorkplace(workplace);

        return locationModel;
    }
}