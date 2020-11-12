////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 28.02.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.workplacegroup;

import com.forcam.na.ffwebservices.client.api.HALCollectionWSModel;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.client.api.pagination.request.CollectionRequest;
import com.forcam.na.ffwebservices.client.api.pagination.response.CollectionResponse;
import com.forcam.na.ffwebservices.client.api.workplacegroup.request.GetWorkplaceGroupsRequest;
import com.forcam.na.ffwebservices.client.api.workplacegroup.response.WorkplaceGroupSetupTransitionsResponse;
import com.forcam.na.ffwebservices.model.workplacegroup.WorkplaceGroupManufacturingVariantRuleResponse;
import com.forcam.na.ffwebservices.model.workplacegroup.WorkplaceGroupResponse;
import com.forcam.na.ffwebservices.model.workplacegroup.WorkplaceGroupSetupTransitionRuleResponse;

/**
 * Contains methods for building responses for workplace groups.
 */
public interface IWorkplaceGroupResponseBuilder {

    /**
     * Transforms a collection model to a workplace group collection response.
     *
     * @param request         The request.
     * @param collectionModel A collection model.
     * @return A workplace group collection response.
     */
    CollectionResponse<WorkplaceGroupResponse> getWorkplaceGroupCollectionResponse(GetWorkplaceGroupsRequest request, HALCollectionWSModel collectionModel);

    /**
     * Converts HAL model to a workplace group model.
     *
     * @param serverModel The server model.
     * @return A workplace group model.
     */
    WorkplaceGroupResponse getWorkplaceGroupResponse(HALWSModel serverModel);

    /**
     * Transforms a collection model to a collection response of workplace group setup transition rule responses.
     *
     * @param request         The request.
     * @param collectionModel The collection model.
     * @return The workplace group setup transition rule collection response.
     */
    CollectionResponse<WorkplaceGroupSetupTransitionRuleResponse> getWorkplaceGroupSetupTransitionRuleResponseCollectionResponse(CollectionRequest request,
                                                                                                                                 HALCollectionWSModel collectionModel);

    /**
     * Converts a HAL server model to a workplace group setup transition rule response.
     *
     * @param serverModel The server model.
     * @return The workplace group setup transition rule response.
     */
    WorkplaceGroupSetupTransitionRuleResponse getWorkplaceGroupSetupTransitionRuleResponse(HALWSModel serverModel);

    /**
     * Converts a HAL server model to a workplace group setup transitions response.
     *
     * @param serverModel The server model.
     * @param request     The request.
     * @return The workpalce group setup transitions response.
     */
    WorkplaceGroupSetupTransitionsResponse getWorkplaceGroupSetupTransitionsResponse(CollectionRequest request, HALWSModel serverModel);

    /**
     * Converts a HAL server model to a workplace group manufacturing variant rule response.
     *
     * @param serverModel The server model.
     * @return The workplace group manufacturing variant rule response.
     */
    WorkplaceGroupManufacturingVariantRuleResponse getWorkplaceGroupManufacturingVariantRuleResponse(HALWSModel serverModel);

    /**
     * Transforms a collection model to a collection response of workplace group manufacturing variant rule responses.
     *
     * @param request         The request.
     * @param collectionModel The collection model.
     * @return The workplace group manufacturing variant rule collection response.
     */
    CollectionResponse<WorkplaceGroupManufacturingVariantRuleResponse> getWorkplaceGroupManufacturingVariantRuleResponseCollectionResponse(
        CollectionRequest request, HALCollectionWSModel collectionModel);
}
