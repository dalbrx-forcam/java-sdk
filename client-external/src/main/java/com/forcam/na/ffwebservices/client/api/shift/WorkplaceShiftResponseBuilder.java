////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 20.10.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.shift;

import com.forcam.na.ffwebservices.client.api.AbstractResponseBuilder;
import com.forcam.na.ffwebservices.client.api.HALCollectionWSModel;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.client.api.pagination.response.CollectionResponse;
import com.forcam.na.ffwebservices.client.api.shift.request.GetWorkplaceShiftsRequest;
import com.forcam.na.ffwebservices.client.api.shifttype.ShiftTypeLinkModelBuilder;
import com.forcam.na.ffwebservices.client.api.workplace.WorkplaceLinkModelBuilder;
import com.forcam.na.ffwebservices.model.LinkEmbeddedWSModel;
import com.forcam.na.ffwebservices.model.shift.WorkplaceShiftEmbed;
import com.forcam.na.ffwebservices.model.shift.WorkplaceShiftPropertiesWSModel;
import com.forcam.na.ffwebservices.model.shift.WorkplaceShiftResponse;
import com.forcam.na.ffwebservices.model.shifttype.ShiftTypePropertiesWSModel;
import com.forcam.na.ffwebservices.model.workplace.WorkplacePropertiesWSModel;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Builds responses for shifts.
 */
public class WorkplaceShiftResponseBuilder extends AbstractResponseBuilder implements IWorkplaceShiftResponseBuilder {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The link model builder of the workplace. */
    private final WorkplaceLinkModelBuilder mWorkplaceLinkModelBuilder;

    /** The link model builder of the shift type. */
    private final ShiftTypeLinkModelBuilder mShiftTypeLinkModelBuilder;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     *
     * @param shiftTypeLinkModelBuilder Shift type link model builder.
     * @param workplaceLinkModelBuilder Workplace link model builder.
     */
    @Inject
    public WorkplaceShiftResponseBuilder(WorkplaceLinkModelBuilder workplaceLinkModelBuilder, ShiftTypeLinkModelBuilder shiftTypeLinkModelBuilder) {
        mWorkplaceLinkModelBuilder = workplaceLinkModelBuilder;
        mShiftTypeLinkModelBuilder = shiftTypeLinkModelBuilder;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public CollectionResponse<WorkplaceShiftResponse> getWorkplaceShiftCollectionResponse(GetWorkplaceShiftsRequest request,
                                                                                          HALCollectionWSModel collectionModel) {
        final CollectionResponse<WorkplaceShiftResponse> collectionResponse = new CollectionResponse<>(request);
        this.initializeCollectionResponse(collectionModel, collectionResponse);

        final Map<String, List<HALWSModel>> embedded = collectionModel.getEmbedded();
        final List<HALWSModel> shifts = embedded.get("shifts");

        final List<WorkplaceShiftResponse> shiftModels = shifts
            .stream()
            .map(this::getWorkplaceShiftResponse)
            .collect(Collectors.toList());

        collectionResponse.setEmbedded(shiftModels);
        return collectionResponse;
    }

    @Override
    public WorkplaceShiftResponse getWorkplaceShiftResponse(HALWSModel serverModel) {
        final WorkplaceShiftResponse shiftModel = new WorkplaceShiftResponse();
        final WorkplaceShiftPropertiesWSModel properties = mMapper.convertValue(serverModel.getProperties(), WorkplaceShiftPropertiesWSModel.class);
        shiftModel.setProperties(properties);

        final LinkEmbeddedWSModel<Object> selfLink = this.createSelfLinkModel(serverModel);
        shiftModel.setSelf(selfLink);

        final LinkEmbeddedWSModel<WorkplacePropertiesWSModel> workplace = mWorkplaceLinkModelBuilder.buildLinkModel(serverModel, WorkplaceShiftEmbed.WORKPLACE);
        shiftModel.setWorkplace(workplace);

        final LinkEmbeddedWSModel<ShiftTypePropertiesWSModel> shiftType = mShiftTypeLinkModelBuilder.buildLinkModel(serverModel,
                                                                                                                    WorkplaceShiftEmbed.SHIFT_TYPE);
        shiftModel.setShiftType(shiftType);

        return shiftModel;
    }
}