////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 12.12.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.operation;

import com.forcam.na.ffwebservices.client.api.AbstractResponseBuilder;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.model.LinkEmbeddedWSModel;
import com.forcam.na.ffwebservices.model.operation.OperationScheduledDatesPropertiesWSModel;
import com.forcam.na.ffwebservices.model.operation.OperationScheduledDatesResponse;

import javax.inject.Inject;

/**
 * Builds responses for the scheduled dates of operations.
 */
public class OperationScheduledDatesResponseBuilder extends AbstractResponseBuilder implements IOperationScheduledDatesResponseBuilder {

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    @Inject
    public OperationScheduledDatesResponseBuilder() {
        //empty
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public OperationScheduledDatesResponse getOperationScheduledDatesResponse(HALWSModel serverModel) {
        final OperationScheduledDatesResponse scheduledDatesModel = new OperationScheduledDatesResponse();
        scheduledDatesModel.setProperties(mMapper.convertValue(serverModel.getProperties(), OperationScheduledDatesPropertiesWSModel.class));

        final LinkEmbeddedWSModel<Object> selfLink = this.createSelfLinkModel(serverModel);
        scheduledDatesModel.setSelf(selfLink);

        return scheduledDatesModel;
    }
}