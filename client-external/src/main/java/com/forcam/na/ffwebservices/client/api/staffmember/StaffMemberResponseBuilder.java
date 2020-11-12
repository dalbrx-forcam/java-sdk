////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 19.12.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.staffmember;

import com.forcam.na.ffwebservices.client.api.AbstractResponseBuilder;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.client.api.erpcontext.ERPContextLinkModelBuilder;
import com.forcam.na.ffwebservices.client.api.location.LocationLinkModelBuilder;
import com.forcam.na.ffwebservices.client.api.operation.OperationLinkModelBuilder;
import com.forcam.na.ffwebservices.client.api.pagination.request.CollectionTimeFilterRequest;
import com.forcam.na.ffwebservices.client.api.pagination.request.CollectionTimestampRequest;
import com.forcam.na.ffwebservices.client.api.pagination.response.CollectionResponse;
import com.forcam.na.ffwebservices.client.api.shifttype.ShiftTypeLinkModelBuilder;
import com.forcam.na.ffwebservices.client.api.staffmember.request.GetStaffMemberAbsencesRequest;
import com.forcam.na.ffwebservices.client.api.staffmember.request.GetStaffMemberRecordedActivitiesRequest;
import com.forcam.na.ffwebservices.client.api.staffmember.request.GetStaffMembersRequest;
import com.forcam.na.ffwebservices.client.api.staffmember.request.GetStaffMembersShiftsRequest;
import com.forcam.na.ffwebservices.client.api.staffmember.response.StaffMemberAbsenceCollectionResponse;
import com.forcam.na.ffwebservices.client.api.staffmember.response.StaffMemberRecordedLoginPeriodCollectionResponse;
import com.forcam.na.ffwebservices.client.api.staffmember.response.StaffMemberScheduledWorkingTimesResponse;
import com.forcam.na.ffwebservices.client.api.staffmember.response.StaffMembersScheduledWorkingTimesCollectionResponse;
import com.forcam.na.ffwebservices.client.api.workplace.WorkplaceLinkModelBuilder;
import com.forcam.na.ffwebservices.model.LinkEmbeddedWSModel;
import com.forcam.na.ffwebservices.model.collection.AbstractCollectionWSModel;
import com.forcam.na.ffwebservices.model.erpcontext.ErpContextPropertiesWSModel;
import com.forcam.na.ffwebservices.model.location.LocationPropertiesWSModel;
import com.forcam.na.ffwebservices.model.operation.OperationPropertiesWSModel;
import com.forcam.na.ffwebservices.model.shift.StaffMemberShiftEmbed;
import com.forcam.na.ffwebservices.model.shift.StaffMemberShiftPropertiesWSModel;
import com.forcam.na.ffwebservices.model.shift.StaffMemberShiftResponse;
import com.forcam.na.ffwebservices.model.shifttype.ShiftTypePropertiesWSModel;
import com.forcam.na.ffwebservices.model.staffmember.StaffMemberAbsenceCollectionPropertiesWSModel;
import com.forcam.na.ffwebservices.model.staffmember.StaffMemberEmbed;
import com.forcam.na.ffwebservices.model.staffmember.StaffMemberPropertiesWSModel;
import com.forcam.na.ffwebservices.model.staffmember.StaffMemberRecordedActivitiesCollectionPropertiesWSModel;
import com.forcam.na.ffwebservices.model.staffmember.StaffMemberResponse;
import com.forcam.na.ffwebservices.model.staffmember.StaffMemberScheduledWorkingTimesPropertiesWSModel;
import com.forcam.na.ffwebservices.model.staffmember.StaffMembersScheduledWorkingTimesPropertiesWSModel;
import com.forcam.na.ffwebservices.model.workplace.WorkplacePropertiesWSModel;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Builds responses for staff members.
 */
public class StaffMemberResponseBuilder extends AbstractResponseBuilder implements IStaffMemberResponseBuilder {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The link model builder of the erp context. */
    private final ERPContextLinkModelBuilder mERPContextLinkModelBuilder;

    /** The link model builder for operations. */
    private final OperationLinkModelBuilder mOperationLinkModelBuilder;

    /** The link model builder of the shift type. */
    private final ShiftTypeLinkModelBuilder mShiftTypeLinkModelBuilder;

    /** The link model builder of the staff member. */
    private final StaffMemberLinkModelBuilder mStaffMemberLinkModelBuilder;

    /** The link model builder of the workplace. */
    private final WorkplaceLinkModelBuilder mWorkplaceLinkModelBuilder;

    /** The link model builder for locations. */
    private final LocationLinkModelBuilder mLocationLinkModelBuilder;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     *
     * @param erpContextLinkModelBuilder  ERP context link model builder.
     * @param operationLinkModelBuilder   Operation link model builder.
     * @param shiftTypeLinkModelBuilder   Shift type link model builder.
     * @param staffMemberLinkModelBuilder Staff member link model builder.
     * @param locationLinkModelBuilder    The location link model builder.
     * @param workplaceLinkModelBuilder   The workplace link model builder.
     */
    @Inject
    public StaffMemberResponseBuilder(ERPContextLinkModelBuilder erpContextLinkModelBuilder, ShiftTypeLinkModelBuilder shiftTypeLinkModelBuilder,
                                      StaffMemberLinkModelBuilder staffMemberLinkModelBuilder, OperationLinkModelBuilder operationLinkModelBuilder,
                                      WorkplaceLinkModelBuilder workplaceLinkModelBuilder, LocationLinkModelBuilder locationLinkModelBuilder) {
        mERPContextLinkModelBuilder = erpContextLinkModelBuilder;
        mShiftTypeLinkModelBuilder = shiftTypeLinkModelBuilder;
        mStaffMemberLinkModelBuilder = staffMemberLinkModelBuilder;
        mOperationLinkModelBuilder = operationLinkModelBuilder;
        mWorkplaceLinkModelBuilder = workplaceLinkModelBuilder;
        mLocationLinkModelBuilder = locationLinkModelBuilder;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public CollectionResponse<StaffMemberResponse> getStaffMemberCollectionResponse(GetStaffMembersRequest request, AbstractCollectionWSModel collectionModel) {
        final CollectionResponse<StaffMemberResponse> collectionResponse = new CollectionResponse<>(request);
        this.initializeCollectionResponse(collectionModel, collectionResponse);

        final Map<String, List<HALWSModel>> embedded = collectionModel.getEmbedded();
        final List<HALWSModel> staffMembers = embedded.get("staffMembers");

        final List<StaffMemberResponse> staffMemberModels = staffMembers
            .stream()
            .map(this::getStaffMemberResponse)
            .collect(Collectors.toList());

        collectionResponse.setEmbedded(staffMemberModels);
        return collectionResponse;
    }

    @Override
    public StaffMemberResponse getStaffMemberResponse(HALWSModel serverModel) {
        final StaffMemberResponse staffMemberResponse = new StaffMemberResponse();
        final StaffMemberPropertiesWSModel properties = mMapper.convertValue(serverModel.getProperties(), StaffMemberPropertiesWSModel.class);
        staffMemberResponse.setProperties(properties);

        final LinkEmbeddedWSModel<Object> selfLink = this.createSelfLinkModel(serverModel);
        staffMemberResponse.setSelf(selfLink);

        final LinkEmbeddedWSModel<ErpContextPropertiesWSModel> erpContext = mERPContextLinkModelBuilder.buildLinkModel(serverModel,
                                                                                                                       StaffMemberEmbed.ERP_CONTEXT);
        staffMemberResponse.setErpContext(erpContext);

        final List<LinkEmbeddedWSModel<OperationPropertiesWSModel>> currentOperations = mOperationLinkModelBuilder.buildListOfLinkModels(serverModel,
                                                                                                                                         StaffMemberEmbed.CURRENTLY_EXECUTED_OPERATIONS);
        staffMemberResponse.setCurrentlyExecutedOperations(currentOperations);

        final LinkEmbeddedWSModel<List<WorkplacePropertiesWSModel>> assignedWorkplaces = mWorkplaceLinkModelBuilder.buildLinkToCollectionModel(serverModel,
                                                                                                                                               StaffMemberEmbed.ASSIGNED_WORKPLACES);
        staffMemberResponse.setAssignedWorkplaces(assignedWorkplaces);

        final LinkEmbeddedWSModel<LocationPropertiesWSModel> location = mLocationLinkModelBuilder.buildLinkModel(serverModel, StaffMemberEmbed.LOCATION);
        staffMemberResponse.setLocation(location);

        return staffMemberResponse;
    }

    @Override
    public StaffMemberAbsenceCollectionResponse getStaffMemberAbsenceCollectionResponse(GetStaffMemberAbsencesRequest request, HALWSModel collectionWSModel) {
        final StaffMemberAbsenceCollectionResponse collectionResponse = new StaffMemberAbsenceCollectionResponse(request);
        final StaffMemberAbsenceCollectionPropertiesWSModel properties = mMapper.convertValue(collectionWSModel.getProperties(),
                                                                                              StaffMemberAbsenceCollectionPropertiesWSModel.class);
        collectionResponse.setProperties(properties);
        collectionResponse.setPagination(collectionWSModel.getPagination());
        collectionResponse.setPaginationLinks(collectionWSModel.getLinkModels());
        return collectionResponse;
    }

    @Override
    public StaffMemberRecordedLoginPeriodCollectionResponse getStaffMemberRecordedLoginPeriodsResponse(GetStaffMemberRecordedActivitiesRequest request,
                                                                                                       HALWSModel collectionModel) {
        final StaffMemberRecordedLoginPeriodCollectionResponse response = new StaffMemberRecordedLoginPeriodCollectionResponse(request);
        response.setProperties(mMapper.convertValue(collectionModel.getProperties(), StaffMemberRecordedActivitiesCollectionPropertiesWSModel.class));
        response.setPagination(collectionModel.getPagination());
        response.setPaginationLinks(collectionModel.getLinkModels());

        return response;
    }

    @Override
    public CollectionResponse<StaffMemberShiftResponse> getStaffMemberShiftCollectionResponse(GetStaffMembersShiftsRequest request,
                                                                                              AbstractCollectionWSModel collectionModel) {
        final CollectionResponse<StaffMemberShiftResponse> collectionResponse = new CollectionResponse<>(request);
        this.initializeCollectionResponse(collectionModel, collectionResponse);

        final Map<String, List<HALWSModel>> embedded = collectionModel.getEmbedded();
        final List<HALWSModel> staffMemberShifts = embedded.get("shifts");

        final List<StaffMemberShiftResponse> staffMemberModels = staffMemberShifts
            .stream()
            .map(this::getStaffMemberShiftResponse)
            .collect(Collectors.toList());

        collectionResponse.setEmbedded(staffMemberModels);
        return collectionResponse;
    }

    @Override
    public StaffMemberShiftResponse getStaffMemberShiftResponse(HALWSModel serverModel) {
        final StaffMemberShiftResponse response = new StaffMemberShiftResponse();
        final StaffMemberShiftPropertiesWSModel properties = mMapper.convertValue(serverModel.getProperties(), StaffMemberShiftPropertiesWSModel.class);
        response.setProperties(properties);

        final LinkEmbeddedWSModel<Object> selfLink = this.createSelfLinkModel(serverModel);
        response.setSelf(selfLink);

        final LinkEmbeddedWSModel<StaffMemberPropertiesWSModel> staffMember = mStaffMemberLinkModelBuilder.buildLinkModel(serverModel,
                                                                                                                          StaffMemberShiftEmbed.STAFF_MEMBER);
        response.setStaffMember(staffMember);

        final LinkEmbeddedWSModel<ShiftTypePropertiesWSModel> shiftType = mShiftTypeLinkModelBuilder.buildLinkModel(serverModel,
                                                                                                                    StaffMemberShiftEmbed.SHIFT_TYPE);
        response.setShiftType(shiftType);

        return response;
    }

    @Override
    public StaffMembersScheduledWorkingTimesCollectionResponse getStaffMembersScheduledWorkingTimesCollectionResponse(CollectionTimeFilterRequest request,
                                                                                                                      HALWSModel collectionModel) {
        final StaffMembersScheduledWorkingTimesCollectionResponse response = new StaffMembersScheduledWorkingTimesCollectionResponse(request);
        response.setProperties(mMapper.convertValue(collectionModel.getProperties(), StaffMembersScheduledWorkingTimesPropertiesWSModel.class));
        response.setPagination(collectionModel.getPagination());
        response.setPaginationLinks(collectionModel.getLinkModels());

        return response;
    }

    @Override
    public StaffMemberScheduledWorkingTimesResponse getStaffMemberScheduledWorkingTimesResponse(CollectionTimestampRequest request,
                                                                                                HALWSModel collectionModel) {
        final StaffMemberScheduledWorkingTimesResponse response = new StaffMemberScheduledWorkingTimesResponse(request);
        response.setProperties(mMapper.convertValue(collectionModel.getProperties(), StaffMemberScheduledWorkingTimesPropertiesWSModel.class));
        response.setPagination(collectionModel.getPagination());
        response.setPaginationLinks(collectionModel.getLinkModels());

        return response;
    }
}
