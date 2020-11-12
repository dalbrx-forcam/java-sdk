////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 28.02.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.workplacegroup;

import com.forcam.na.ffwebservices.client.api.AbstractClient;
import com.forcam.na.ffwebservices.client.api.HALCollectionWSModel;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.client.api.exception.ForceAPIException;
import com.forcam.na.ffwebservices.client.api.pagination.response.CollectionResponse;
import com.forcam.na.ffwebservices.client.api.pagination.response.Page;
import com.forcam.na.ffwebservices.client.api.workplace.IWorkplaceResponseBuilder;
import com.forcam.na.ffwebservices.client.api.workplacegroup.request.*;
import com.forcam.na.ffwebservices.client.api.workplacegroup.response.WorkplaceGroupSetupTransitionsResponse;
import com.forcam.na.ffwebservices.model.workplace.WorkplaceResponse;
import com.forcam.na.ffwebservices.model.workplacegroup.CreateSetupTransitionRulePropertiesWSModel;
import com.forcam.na.ffwebservices.model.workplacegroup.WorkplaceGroupManufacturingVariantRuleResponse;
import com.forcam.na.ffwebservices.model.workplacegroup.WorkplaceGroupResponse;
import com.forcam.na.ffwebservices.model.workplacegroup.WorkplaceGroupSetupTransitionRuleResponse;
import retrofit2.Call;

import javax.inject.Inject;
import java.lang.reflect.Method;

/**
 * Requests workplace groups and assigned workplaces of workplace groups.
 */
public class WorkplaceGroupClient extends AbstractClient implements IWorkplaceGroupClient {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The workplace group endpoint. */
    private final WorkplaceGroupEndpoint mWorkplaceGroupEndpoint;

    /** The workplace group response builder. */
    private final IWorkplaceGroupResponseBuilder mWorkplaceGroupResponseBuilder;

    /** The workplace response builder. */
    private final IWorkplaceResponseBuilder mWorkplaceResponseBuilder;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     *
     * @param workplaceGroupEndpoint        Workplace group endpoint.
     * @param workplaceGroupResponseBuilder Workplace group response builder.
     * @param workplaceResponseBuilder      Workplace response builder.
     */
    @Inject
    public WorkplaceGroupClient(WorkplaceGroupEndpoint workplaceGroupEndpoint, IWorkplaceGroupResponseBuilder workplaceGroupResponseBuilder,
                                IWorkplaceResponseBuilder workplaceResponseBuilder) {
        mWorkplaceGroupEndpoint = workplaceGroupEndpoint;
        mWorkplaceGroupResponseBuilder = workplaceGroupResponseBuilder;
        mWorkplaceResponseBuilder = workplaceResponseBuilder;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public Page<WorkplaceGroupResponse> getWorkplaceGroups(GetWorkplaceGroupsRequest request) throws ForceAPIException {
        final Call<HALCollectionWSModel> call = mWorkplaceGroupEndpoint.getWorkplaceGroups(request.getWorkplaceGroupNumber(),
                                                                                           request.getType(),
                                                                                           request.getErpContextId(),
                                                                                           request.getLimit(),
                                                                                           request.getOffset(),
                                                                                           request
                                                                                               .embed()
                                                                                               .toString());
        final HALCollectionWSModel responseModel = this.getResponseModel(request, call);

        final CollectionResponse<WorkplaceGroupResponse> response = mWorkplaceGroupResponseBuilder.getWorkplaceGroupCollectionResponse(request, responseModel);

        final Method m = new Object() {}
            .getClass()
            .getEnclosingMethod();
        return new Page<>(this, m, response);
    }

    @Override
    public WorkplaceGroupResponse getWorkplaceGroup(GetWorkplaceGroupRequest request) throws ForceAPIException {
        final Call<HALWSModel> call = mWorkplaceGroupEndpoint.getWorkplaceGroup(request.getId(),
                                                                                request
                                                                                    .embed()
                                                                                    .toString());
        final HALWSModel responseModel = this.getResponseModel(request, call);
        return mWorkplaceGroupResponseBuilder.getWorkplaceGroupResponse(responseModel);
    }

    @Override
    public Page<WorkplaceResponse> getAssignedWorkplaces(GetWorkplaceGroupAssignedWorkplacesRequest request) throws ForceAPIException {
        final Call<HALCollectionWSModel> call = mWorkplaceGroupEndpoint.getAssignedWorkplaces(request.getWorkplaceGroupId(),
                                                                                              request.getLimit(),
                                                                                              request.getOffset());
        final HALCollectionWSModel responseModel = this.getResponseModel(request, call);
        final CollectionResponse<WorkplaceResponse> response = mWorkplaceResponseBuilder.getWorkplaceCollectionResponse(request, responseModel);

        final Method m = new Object() {}
            .getClass()
            .getEnclosingMethod();
        return new Page<>(this, m, response);
    }

    @Override
    public WorkplaceGroupSetupTransitionsResponse getSetupTransitions(GetWorkplaceGroupSetupTransitionsRequest request) throws ForceAPIException {
        final Call<HALWSModel> call = mWorkplaceGroupEndpoint.getSetupTransitions(request.getWorkplaceGroupId(),
                                                                                  request.getPredecessorMaterial(),
                                                                                  request.getSuccessorMaterial(),
                                                                                  request.getLimit(),
                                                                                  request.getOffset());
        final HALWSModel responseModel = this.getResponseModel(request, call);
        return mWorkplaceGroupResponseBuilder.getWorkplaceGroupSetupTransitionsResponse(request, responseModel);
    }

    @Override
    public Page<WorkplaceGroupSetupTransitionRuleResponse> getSetupTransitionRules(GetWorkplaceGroupSetupTransitionRuleCollectionRequest request)
        throws ForceAPIException {
        final Call<HALCollectionWSModel> call = mWorkplaceGroupEndpoint.getSetupTransitionRules(request.getWorkplaceGroupId(),
                                                                                                request.getOrigin(),
                                                                                                request.getCriterion(),
                                                                                                request.getMaterialNumber(),
                                                                                                request.getWorkplaceNumber(),
                                                                                                request.getLimit(),
                                                                                                request.getOffset());
        final HALCollectionWSModel responseModel = this.getResponseModel(request, call);
        final CollectionResponse<WorkplaceGroupSetupTransitionRuleResponse> response = mWorkplaceGroupResponseBuilder.getWorkplaceGroupSetupTransitionRuleResponseCollectionResponse(
            request,
            responseModel);

        final Method m = new Object() {}
            .getClass()
            .getEnclosingMethod();
        return new Page<>(this, m, response);
    }

    @Override
    public WorkplaceGroupSetupTransitionRuleResponse saveSetupTransitionRule(String workplaceGroupId,
                                                                             CreateSetupTransitionRulePropertiesWSModel setupTransitionRuleProperties)
        throws ForceAPIException {
        final Call<HALWSModel> call = mWorkplaceGroupEndpoint.saveSetupTransitionRule(workplaceGroupId, setupTransitionRuleProperties);
        final HALWSModel responseModel = this.getResponseModel(workplaceGroupId, call);

        return mWorkplaceGroupResponseBuilder.getWorkplaceGroupSetupTransitionRuleResponse(responseModel);
    }

    @Override
    public WorkplaceGroupSetupTransitionRuleResponse getSetupTransitionRule(GetWorkplaceGroupSetupTransitionRuleRequest request) throws ForceAPIException {
        final Call<HALWSModel> call = mWorkplaceGroupEndpoint.getSetupTransitionRule(request.getWorkplaceGroupId(), request.getSetupTransitionRuleId());
        final HALWSModel responseModel = this.getResponseModel(request, call);
        return mWorkplaceGroupResponseBuilder.getWorkplaceGroupSetupTransitionRuleResponse(responseModel);
    }

    @Override
    public void deleteSetupTransitionRule(GetWorkplaceGroupSetupTransitionRuleRequest request) throws ForceAPIException {
        final Call<Void> call = mWorkplaceGroupEndpoint.deleteSetupTransitionRule(request.getWorkplaceGroupId(), request.getSetupTransitionRuleId());
        this.executeCall(request, call);
    }

    @Override
    public WorkplaceGroupSetupTransitionRuleResponse updateSetupTransitionRule(GetWorkplaceGroupSetupTransitionRuleRequest request,
                                                                               CreateSetupTransitionRulePropertiesWSModel setupTransitionRuleProperties)
        throws ForceAPIException {
        final Call<HALWSModel> call = mWorkplaceGroupEndpoint.updateSetupTransitionRule(request.getWorkplaceGroupId(),
                                                                                        request.getSetupTransitionRuleId(),
                                                                                        setupTransitionRuleProperties);
        final HALWSModel responseModel = this.getResponseModel(request, call);
        return mWorkplaceGroupResponseBuilder.getWorkplaceGroupSetupTransitionRuleResponse(responseModel);
    }

    @Override
    public WorkplaceGroupManufacturingVariantRuleResponse getManufacturingVariantRule(GetManufacturingVariantRuleRequest request) throws ForceAPIException {
        final Call<HALWSModel> call = mWorkplaceGroupEndpoint.getManufacturingVariantRule(request.getWorkplaceGroupId(),
                                                                                          request.getManufacturingVariantRuleId());
        final HALWSModel responseModel = this.getResponseModel(request, call);
        return mWorkplaceGroupResponseBuilder.getWorkplaceGroupManufacturingVariantRuleResponse(responseModel);
    }

    @Override
    public void deleteManufacturingVariantRule(GetManufacturingVariantRuleRequest request) throws ForceAPIException {
        final Call<Void> call = mWorkplaceGroupEndpoint.deleteManufacturingVariantRule(request.getWorkplaceGroupId(), request.getManufacturingVariantRuleId());
        this.executeCall(request, call);
    }

    @Override
    public WorkplaceGroupManufacturingVariantRuleResponse updateManufacturingVariantRule(SaveOrUpdateManufacturingVariantRuleRequest request)
        throws ForceAPIException {
        final Call<HALWSModel> call = mWorkplaceGroupEndpoint.updateManufacturingVariantRule(request.getWorkplaceGroupId(),
                                                                                             request.getManufacturingVariantRuleId(),
                                                                                             request.getManufacturingVariantRule());
        final HALWSModel responseModel = this.getResponseModel(request, call);
        return mWorkplaceGroupResponseBuilder.getWorkplaceGroupManufacturingVariantRuleResponse(responseModel);
    }

    @Override
    public Page<WorkplaceGroupManufacturingVariantRuleResponse> getManufacturingVariantRules(GetManufacturingVariantRuleCollectionRequest request)
        throws ForceAPIException {
        final Call<HALCollectionWSModel> call = mWorkplaceGroupEndpoint.getManufacturingVariantRules(request.getWorkplaceGroupId(),
                                                                                                     request.getOrigin(),
                                                                                                     request.getCriterion(),
                                                                                                     request.getMaterialNumber(),
                                                                                                     request.getWorkplaceNumber(),
                                                                                                     request.getLimit(),
                                                                                                     request.getOffset());
        final HALCollectionWSModel responseModel = this.getResponseModel(request, call);
        final CollectionResponse<WorkplaceGroupManufacturingVariantRuleResponse> response = mWorkplaceGroupResponseBuilder.getWorkplaceGroupManufacturingVariantRuleResponseCollectionResponse(
            request,
            responseModel);

        final Method m = new Object() {}
            .getClass()
            .getEnclosingMethod();
        return new Page<>(this, m, response);
    }

    @Override
    public WorkplaceGroupManufacturingVariantRuleResponse createManufacturingVariantRule(SaveOrUpdateManufacturingVariantRuleRequest request)
        throws ForceAPIException {
        final Call<HALWSModel> call = mWorkplaceGroupEndpoint.createManufacturingVariantRule(request.getWorkplaceGroupId(),
                                                                                             request.getManufacturingVariantRule());
        final HALWSModel responseModel = this.getResponseModel(request, call);
        return mWorkplaceGroupResponseBuilder.getWorkplaceGroupManufacturingVariantRuleResponse(responseModel);
    }
}