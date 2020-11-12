////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 13.12.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.operation;

import com.forcam.na.ffwebservices.client.api.AbstractResponseBuilder;
import com.forcam.na.ffwebservices.client.api.pagination.response.CollectionResponse;
import com.forcam.na.ffwebservices.client.api.pagination.request.PaginationRequest;
import com.forcam.na.ffwebservices.client.statusdefinition.OperatingStateLinkModelBuilder;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.model.LinkEmbeddedWSModel;
import com.forcam.na.ffwebservices.client.api.HALCollectionWSModel;
import com.forcam.na.ffwebservices.model.operation.OperationRecordedOperatingStateEmbed;
import com.forcam.na.ffwebservices.model.operation.OperationRecordedOperatingStateResponse;
import com.forcam.na.ffwebservices.model.recordedoperatingstate.OperatingStateRecordWSModel;
import com.forcam.na.ffwebservices.model.statusdefinition.OperatingStatePropertiesWSModel;
import javax.inject.Inject;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Builds responses for recorded operating states of operations.
 */
public class OperationRecordedOperatingStateResponseBuilder extends AbstractResponseBuilder implements IOperationRecordedOperatingStateResponseBuilder {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The link model builder of the operating state. */
    @Inject
    OperatingStateLinkModelBuilder mOperatingStateLinkModelBuilder;

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    public CollectionResponse<OperationRecordedOperatingStateResponse> getOperationRecordedOperatingStateCollectionResponse(PaginationRequest request,
                                                                                                                            HALCollectionWSModel collectionModel) {
        final CollectionResponse<OperationRecordedOperatingStateResponse> collectionResponse = new CollectionResponse<>(request);
        this.initializeCollectionResponse(collectionModel, collectionResponse);

        final Map<String, List<HALWSModel>> embedded = collectionModel.getEmbedded();
        final List<HALWSModel> recordedOperatingStates = embedded.get("recordedOperatingStates");

        final List<OperationRecordedOperatingStateResponse> recordedOperatingStateModels = recordedOperatingStates
            .stream()
            .map(this::getOperationRecordedOperatingStateResponse)
            .collect(Collectors.toList());

        collectionResponse.setEmbedded(recordedOperatingStateModels);
        return collectionResponse;
    }

    @Override
    public OperationRecordedOperatingStateResponse getOperationRecordedOperatingStateResponse(HALWSModel serverModel) {
        final OperationRecordedOperatingStateResponse recordedOperatingStateModel = new OperationRecordedOperatingStateResponse();
        recordedOperatingStateModel.setProperties(mMapper.convertValue(serverModel.getProperties(), OperatingStateRecordWSModel.class));

        final LinkEmbeddedWSModel<Object> selfLink = this.createSelfLinkModel(serverModel);
        recordedOperatingStateModel.setSelf(selfLink);

        final LinkEmbeddedWSModel<OperatingStatePropertiesWSModel> operatingState = mOperatingStateLinkModelBuilder.buildLinkModel(serverModel,
                                                                                                                                   OperationRecordedOperatingStateEmbed.OPERATING_STATE);
        recordedOperatingStateModel.setOperatingState(operatingState);

        return recordedOperatingStateModel;
    }
}