////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 13.12.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.recordedoperatingstate;

import com.forcam.na.ffwebservices.client.api.AbstractResponseBuilder;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.client.api.pagination.request.PaginationRequest;
import com.forcam.na.ffwebservices.client.statusdefinition.OperatingStateLinkModelBuilder;
import com.forcam.na.ffwebservices.model.LinkEmbeddedWSModel;
import com.forcam.na.ffwebservices.model.recordedoperatingstate.OperatingStateRecordCollectionPropertiesWSModel;
import com.forcam.na.ffwebservices.model.recordedoperatingstate.OperatingStateRecordWSModel;
import com.forcam.na.ffwebservices.model.recordedoperatingstate.RecordedOperatingStateEmbed;
import com.forcam.na.ffwebservices.model.recordedoperatingstate.RecordedOperatingStateResponse;
import com.forcam.na.ffwebservices.model.statusdefinition.OperatingStatePropertiesWSModel;

import javax.inject.Inject;

/**
 * Builds responses for recorded operating states of operations.
 */
public class RecordedOperatingStateResponseBuilder extends AbstractResponseBuilder implements IRecordedOperatingStateResponseBuilder {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The link model builder of the operating state. */
    private final OperatingStateLinkModelBuilder mOperatingStateLinkModelBuilder;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     *
     * @param operatingStateLinkModelBuilder Operating state link model builder.
     */
    @Inject
    public RecordedOperatingStateResponseBuilder(OperatingStateLinkModelBuilder operatingStateLinkModelBuilder) {
        mOperatingStateLinkModelBuilder = operatingStateLinkModelBuilder;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public RecordedOperatingStateCollectionResponse getRecordedOperatingStateCollectionResponse(PaginationRequest request, HALWSModel collectionModel) {
        final RecordedOperatingStateCollectionResponse collectionResponse = new RecordedOperatingStateCollectionResponse(request);
        final OperatingStateRecordCollectionPropertiesWSModel properties = mMapper.convertValue(collectionModel.getProperties(),
                                                                                                OperatingStateRecordCollectionPropertiesWSModel.class);
        collectionResponse.setProperties(properties);
        collectionResponse.setPagination(collectionModel.getPagination());
        collectionResponse.setPaginationLinks(collectionModel.getLinkModels());

        return collectionResponse;
    }

    @Override
    public RecordedOperatingStateResponse getRecordedOperatingStateResponse(HALWSModel serverModel) {
        final RecordedOperatingStateResponse recordedOperatingStateModel = new RecordedOperatingStateResponse();
        recordedOperatingStateModel.setProperties(mMapper.convertValue(serverModel.getProperties(), OperatingStateRecordWSModel.class));

        final LinkEmbeddedWSModel<Object> selfLink = this.createSelfLinkModel(serverModel);
        recordedOperatingStateModel.setSelf(selfLink);

        final LinkEmbeddedWSModel<OperatingStatePropertiesWSModel> operatingState = mOperatingStateLinkModelBuilder.buildLinkModel(serverModel,
                                                                                                                                   RecordedOperatingStateEmbed.OPERATING_STATE);
        recordedOperatingStateModel.setOperatingState(operatingState);

        final LinkEmbeddedWSModel<OperatingStatePropertiesWSModel> operatingStateDetails = mOperatingStateLinkModelBuilder.buildLinkModel(serverModel,
                                                                                                                                          RecordedOperatingStateEmbed.OPERATING_STATE_DETAILS);
        recordedOperatingStateModel.setOperatingStateDetails(operatingStateDetails);

        return recordedOperatingStateModel;
    }
}