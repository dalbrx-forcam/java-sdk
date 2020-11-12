////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 12.12.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.operation;

import com.forcam.na.ffwebservices.client.api.AbstractResponseBuilder;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.client.api.workplace.WorkplaceLinkModelBuilder;
import com.forcam.na.ffwebservices.model.LinkEmbeddedWSModel;
import com.forcam.na.ffwebservices.model.operation.OperationCurrentProductionDataPropertiesWSModel;
import com.forcam.na.ffwebservices.model.operation.OperationCurrentProductionDataResponse;
import com.forcam.na.ffwebservices.model.operation.OperationSpecificationEmbed;
import com.forcam.na.ffwebservices.model.operation.OperationSpecificationPropertiesWSModel;
import com.forcam.na.ffwebservices.model.operation.OperationSpecificationResponse;
import com.forcam.na.ffwebservices.model.workplace.WorkplacePropertiesWSModel;

import javax.inject.Inject;

/**
 * Builds responses for the specification of operations.
 */
public class OperationSpecificationResponseBuilder extends AbstractResponseBuilder implements IOperationSpecificationResponseBuilder {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The link model builder of the target workplace. */
    private final WorkplaceLinkModelBuilder mWorkplaceLinkModelBuilder;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     *
     * @param workplaceLinkModelBuilder Workplace link model builder.
     */
    @Inject
    public OperationSpecificationResponseBuilder(WorkplaceLinkModelBuilder workplaceLinkModelBuilder) {
        mWorkplaceLinkModelBuilder = workplaceLinkModelBuilder;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public OperationSpecificationResponse getOperationSpecificationResponse(HALWSModel serverModel) {
        final OperationSpecificationResponse specificationModel = new OperationSpecificationResponse();
        specificationModel.setProperties(mMapper.convertValue(serverModel.getProperties(), OperationSpecificationPropertiesWSModel.class));

        final LinkEmbeddedWSModel<Object> selfLink = this.createSelfLinkModel(serverModel);
        specificationModel.setSelf(selfLink);

        final LinkEmbeddedWSModel<WorkplacePropertiesWSModel> targetWorkplace = mWorkplaceLinkModelBuilder.buildLinkModel(serverModel,
                                                                                                                          OperationSpecificationEmbed.TARGET_WORKPLACE);
        specificationModel.setTargetWorkplace(targetWorkplace);

        return specificationModel;
    }

    @Override
    public OperationCurrentProductionDataResponse getOperationCurrentProductionDataResponse(HALWSModel serverModel) {
        final OperationCurrentProductionDataResponse response = new OperationCurrentProductionDataResponse();
        response.setProperties(mMapper.convertValue(serverModel.getProperties(), OperationCurrentProductionDataPropertiesWSModel.class));

        final LinkEmbeddedWSModel<Object> selfLink = this.createSelfLinkModel(serverModel);
        response.setSelf(selfLink);

        return response;
    }
}