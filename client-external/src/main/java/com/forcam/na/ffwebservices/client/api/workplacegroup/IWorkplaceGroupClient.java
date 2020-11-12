////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 28.02.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.workplacegroup;

import com.forcam.na.ffwebservices.client.api.exception.ForceAPIException;
import com.forcam.na.ffwebservices.client.api.pagination.response.Page;
import com.forcam.na.ffwebservices.client.api.workplacegroup.request.*;
import com.forcam.na.ffwebservices.client.api.workplacegroup.response.WorkplaceGroupSetupTransitionsResponse;
import com.forcam.na.ffwebservices.model.workplace.WorkplaceResponse;
import com.forcam.na.ffwebservices.model.workplacegroup.CreateSetupTransitionRulePropertiesWSModel;
import com.forcam.na.ffwebservices.model.workplacegroup.WorkplaceGroupManufacturingVariantRuleResponse;
import com.forcam.na.ffwebservices.model.workplacegroup.WorkplaceGroupResponse;
import com.forcam.na.ffwebservices.model.workplacegroup.WorkplaceGroupSetupTransitionRuleResponse;

/**
 * An interface with methods that request workplace groups and assigned workplaces of workplace groups.
 */
public interface IWorkplaceGroupClient {

    /**
     * Sends a request to the server and gets a collection of workplace groups as response.
     *
     * @param request A collection of parameters.
     * @return The workplace group collection response.
     * @throws ForceAPIException When unable to get workplace groups.
     */
    Page<WorkplaceGroupResponse> getWorkplaceGroups(GetWorkplaceGroupsRequest request) throws ForceAPIException;

    /**
     * Sends a request to the server and gets a workplace group model as response.
     *
     * @param request A collection of parameters.
     * @return A workplace group model.
     * @throws ForceAPIException When unable to get workplace group.
     */
    WorkplaceGroupResponse getWorkplaceGroup(GetWorkplaceGroupRequest request) throws ForceAPIException;

    /**
     * Sends a request to the server and gets a collection of assigned workplaces as response.
     *
     * @param request A collection of parameters.
     * @return The workplace collection response.
     * @throws ForceAPIException When unable to get workplaces.
     */
    Page<WorkplaceResponse> getAssignedWorkplaces(GetWorkplaceGroupAssignedWorkplacesRequest request) throws ForceAPIException;

    /**
     * Sends a request to the server and gets all setup transitions of a workplace group.
     *
     * @param request The request.
     * @return The workplace group setup transitions response.
     * @throws ForceAPIException When unable to get the setup transitions of a workplace group.
     */
    WorkplaceGroupSetupTransitionsResponse getSetupTransitions(GetWorkplaceGroupSetupTransitionsRequest request) throws ForceAPIException;

    /**
     * Sends a request to the server and gets all setup transition rules of the workplace group.
     *
     * @param request The collection request.
     * @return A page of workplace group setup transition rule responses.
     * @throws ForceAPIException When unable to get all setup transition rules of the workplace group.
     */
    Page<WorkplaceGroupSetupTransitionRuleResponse> getSetupTransitionRules(GetWorkplaceGroupSetupTransitionRuleCollectionRequest request)
        throws ForceAPIException;

    /**
     * Sends a request to the server and creates a new setup transition rule for the workplace group.
     *
     * @param workplaceGroupId              The workplace group ID.
     * @param setupTransitionRuleProperties The properties of the setup transition rule.
     * @return The created workplace group setup transition rule response.
     * @throws ForceAPIException When unable to save the setup transition rule.
     */
    WorkplaceGroupSetupTransitionRuleResponse saveSetupTransitionRule(String workplaceGroupId,
                                                                      CreateSetupTransitionRulePropertiesWSModel setupTransitionRuleProperties)
        throws ForceAPIException;

    /**
     * Sends a request to the server and gets a setup transition rule of a workplace group by ID.
     *
     * @param request The request parameters.
     * @return The workplace group setup transition rule response.
     * @throws ForceAPIException When unable to get the setup transition rule of the workplace group.
     */
    WorkplaceGroupSetupTransitionRuleResponse getSetupTransitionRule(GetWorkplaceGroupSetupTransitionRuleRequest request) throws ForceAPIException;

    /**
     * Sends a request to the server and deletes a setup transition rule of a workplace group by ID.
     *
     * @param request The request.
     * @throws ForceAPIException When unable to delete the workplace group setup transition rule.
     */
    void deleteSetupTransitionRule(GetWorkplaceGroupSetupTransitionRuleRequest request) throws ForceAPIException;

    /**
     * Sends a request to the server and updates a setup transition rule of a workplace group.
     *
     * @param request                       The request parameters.
     * @param setupTransitionRuleProperties The new properties of the setup transition rule.
     * @return The updated workplace group setup transition rule response.
     * @throws ForceAPIException When unable to update the setup transition rule.
     */
    WorkplaceGroupSetupTransitionRuleResponse updateSetupTransitionRule(GetWorkplaceGroupSetupTransitionRuleRequest request,
                                                                        CreateSetupTransitionRulePropertiesWSModel setupTransitionRuleProperties)
        throws ForceAPIException;

    /**
     * Sends a request to the server and gets a manufacturing variant rule of a workplace group.
     *
     * @param request The request parameters.
     * @return The workplace group manufacturing variant rule response.
     * @throws ForceAPIException When unable to get manufacturing variant rule.
     */
    WorkplaceGroupManufacturingVariantRuleResponse getManufacturingVariantRule(GetManufacturingVariantRuleRequest request) throws ForceAPIException;

    /**
     * Sends a request to the server and deletes a manufacturing variant rule of a workplace group by ID.
     *
     * @param request The request parameters.
     * @throws ForceAPIException When unable to delete manufacturing variant rule.
     */
    void deleteManufacturingVariantRule(GetManufacturingVariantRuleRequest request) throws ForceAPIException;

    /**
     * Sends a request to the server and updates a manufacturing variant rule of a workplace group.
     *
     * @param request The request parameters.
     * @return The updated workplace group manufacturing variant rule response.
     * @throws ForceAPIException When unable to update the manufacturing variant rule.
     */
    WorkplaceGroupManufacturingVariantRuleResponse updateManufacturingVariantRule(SaveOrUpdateManufacturingVariantRuleRequest request) throws ForceAPIException;

    /**
     * Sends a request to the server and gets all manufacturing variant rules of a workplace group.
     *
     * @param request The request parameters.
     * @return A page of workplace group manufacturing variant rule responses.
     * @throws ForceAPIException When unable to get the manufacturing variant rules.
     */
    Page<WorkplaceGroupManufacturingVariantRuleResponse> getManufacturingVariantRules(GetManufacturingVariantRuleCollectionRequest request)
        throws ForceAPIException;

    /**
     * Sends a request to the server and creates a new manufacturing variant rule of a workplace group.
     *
     * @param request The request parameters.
     * @return The created workplace group manufacturing variant rule response.
     * @throws ForceAPIException When unable to create the manufacturing variant rule.
     */
    WorkplaceGroupManufacturingVariantRuleResponse createManufacturingVariantRule(SaveOrUpdateManufacturingVariantRuleRequest request) throws ForceAPIException;
}