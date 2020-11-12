////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 28.02.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.workplacegroup;

import com.forcam.na.ffwebservices.client.api.HALCollectionWSModel;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.model.IRequestAndQueryParams;
import com.forcam.na.ffwebservices.model.workplacegroup.CreateSetupTransitionRulePropertiesWSModel;
import com.forcam.na.ffwebservices.model.workplacegroup.Criterion;
import com.forcam.na.ffwebservices.model.workplacegroup.IWorkplaceGroupPaths;
import com.forcam.na.ffwebservices.model.workplacegroup.ManufacturingVariantRuleCriterion;
import com.forcam.na.ffwebservices.model.workplacegroup.ManufacturingVariantRuleOrigin;
import com.forcam.na.ffwebservices.model.workplacegroup.Origin;
import com.forcam.na.ffwebservices.model.workplacegroup.WorkplaceGroupManufacturingVariantRuleRequestBody;
import com.forcam.na.ffwebservices.model.workplacegroup.WorkplaceGroupType;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * An interface with methods for creating calls that can be sent to the server.
 */
public interface WorkplaceGroupEndpoint {

    /**
     * Creates a call that can be sent to the server.
     *
     * @param workplaceGroupNumber The number of the workplace group.
     * @param type                 The type of the workplace group.
     * @param erpContextId         The ERP context ID.
     * @param limit                The limit.
     * @param offset               The offset.
     * @param embed                The resources which shall be embedded.
     * @return A call that can be sent to the server.
     */
    @Headers({ "Content-Type: application/json", "Accept: application/hal+json" })
    @GET(IWorkplaceGroupPaths.WORKPLACE_GROUPS)
    Call<HALCollectionWSModel> getWorkplaceGroups(
        @Query(IRequestAndQueryParams.WORKPLACE_GROUP_NUMBER)
            String workplaceGroupNumber,
        @Query(IRequestAndQueryParams.TYPE)
            WorkplaceGroupType type,
        @Query(IRequestAndQueryParams.ERP_CONTEXT_ID)
            String erpContextId,
        @Query(IRequestAndQueryParams.LIMIT)
            int limit,
        @Query(IRequestAndQueryParams.OFFSET)
            int offset,
        @Query(IRequestAndQueryParams.EMBED)
            String embed);

    /**
     * Creates a call that can be sent to the server.
     *
     * @param workplaceGroupId The workplace group ID.
     * @param embed            The resources which shall be embedded.
     * @return A call that can be sent to the server.
     */
    @Headers({ "Content-Type: application/json", "Accept: application/hal+json" })
    @GET(IWorkplaceGroupPaths.WORKPLACE_GROUPS + "/{" + IRequestAndQueryParams.WORKPLACE_GROUP_ID + "}")
    Call<HALWSModel> getWorkplaceGroup(
        @Path(IRequestAndQueryParams.WORKPLACE_GROUP_ID)
            String workplaceGroupId,
        @Query(IRequestAndQueryParams.EMBED)
            String embed);

    /**
     * Creates a call that can be sent to the server.
     *
     * @param workplaceGroupId The workplace group ID.
     * @param limit            The limit.
     * @param offset           The offset.
     * @return A call that can be sent to the server.
     */
    @Headers({ "Content-Type: application/json", "Accept: application/hal+json" })
    @GET(IWorkplaceGroupPaths.WORKPLACE_GROUPS + "/{" + IRequestAndQueryParams.WORKPLACE_GROUP_ID + "}/" + IWorkplaceGroupPaths.ASSIGNED_WORKPLACES)
    Call<HALCollectionWSModel> getAssignedWorkplaces(
        @Path(IRequestAndQueryParams.WORKPLACE_GROUP_ID)
            String workplaceGroupId,
        @Query(IRequestAndQueryParams.LIMIT)
            int limit,
        @Query(IRequestAndQueryParams.OFFSET)
            int offset);

    /**
     * Creates a call that can be sent to the server and gets all setup transitions of a workplace group.
     *
     * @param workplaceGroupId    The workplace group ID.
     * @param predecessorMaterial The number of the material that is produced at the workplace before the setup transition.
     * @param successorMaterial   The number of the material that is produced at the workplace after the setup transition.
     * @param limit               The limit.
     * @param offset              The offset.
     * @return A call that can be sent to the server.
     */
    @Headers({ "Content-Type: application/json", "Accept: application/hal+json" })
    @GET(IWorkplaceGroupPaths.WORKPLACE_GROUPS + "/{" + IRequestAndQueryParams.WORKPLACE_GROUP_ID + "}/" + IWorkplaceGroupPaths.SETUP_TRANSITIONS)
    Call<HALWSModel> getSetupTransitions(
        @Path(IRequestAndQueryParams.WORKPLACE_GROUP_ID)
            String workplaceGroupId,
        @Query(IRequestAndQueryParams.PREDECESSOR_MATERIAL)
            String predecessorMaterial,
        @Query(IRequestAndQueryParams.SUCCESSOR_MATERIAL)
            String successorMaterial,
        @Query(IRequestAndQueryParams.LIMIT)
            int limit,
        @Query(IRequestAndQueryParams.OFFSET)
            int offset);

    /**
     * Creates a call that can be sent to the server and gets all setup transition rules of a workplace group.
     *
     * @param workplaceGroupId The workplace group ID.
     * @param origin           The origin.
     * @param criterion        The criterion.
     * @param materialNumber   The material number.
     * @param workplaceNumber  The workplace number.
     * @param limit            The limit.
     * @param offset           The offset.
     * @return A call that can be sent to the server.
     */
    @Headers({ "Content-Type: application/json", "Accept: application/hal+json" })
    @GET(IWorkplaceGroupPaths.WORKPLACE_GROUPS + "/{" + IRequestAndQueryParams.WORKPLACE_GROUP_ID + "}/" + IWorkplaceGroupPaths.SETUP_TRANSITION_RULES)
    Call<HALCollectionWSModel> getSetupTransitionRules(
        @Path(IRequestAndQueryParams.WORKPLACE_GROUP_ID)
            String workplaceGroupId,
        @Query(IRequestAndQueryParams.ORIGIN)
            Origin origin,
        @Query(IRequestAndQueryParams.CRITERION)
            Criterion criterion,
        @Query(IRequestAndQueryParams.MATERIAL_NUMBER)
            String materialNumber,
        @Query(IRequestAndQueryParams.WORKPLACE_NUMBER)
            String workplaceNumber,
        @Query(IRequestAndQueryParams.LIMIT)
            int limit,
        @Query(IRequestAndQueryParams.OFFSET)
            int offset);

    /**
     * Creates a call that can be sent to the server and creates a new setup transition rule of a workplace group.
     *
     * @param workplaceGroupId              The workplace group ID.
     * @param setupTransitionRuleProperties The setup transition rule properties.
     * @return A call that can be sent to the server.
     */
    @Headers({ "Content-Type: application/json", "Accept: application/hal+json" })
    @POST(IWorkplaceGroupPaths.WORKPLACE_GROUPS + "/{" + IRequestAndQueryParams.WORKPLACE_GROUP_ID + "}/" + IWorkplaceGroupPaths.SETUP_TRANSITION_RULES)
    Call<HALWSModel> saveSetupTransitionRule(
        @Path(IRequestAndQueryParams.WORKPLACE_GROUP_ID)
            String workplaceGroupId,
        @Body
            CreateSetupTransitionRulePropertiesWSModel setupTransitionRuleProperties);

    /**
     * Creates a call that can be sent to the server and gets a setup transition rule of a workplace group by ID.
     *
     * @param workplaceGroupId      The workplace group ID.
     * @param setupTransitionRuleId The setup transition rule ID.
     * @return A call that can be sent to the server.
     */
    @Headers({ "Content-Type: application/json", "Accept: application/hal+json" })
    @GET(IWorkplaceGroupPaths.WORKPLACE_GROUPS + "/{" + IRequestAndQueryParams.WORKPLACE_GROUP_ID + "}/" + IWorkplaceGroupPaths.SETUP_TRANSITION_RULES + "/{" +
         IRequestAndQueryParams.SETUP_TRANSITION_RULE_ID + "}")
    Call<HALWSModel> getSetupTransitionRule(
        @Path(IRequestAndQueryParams.WORKPLACE_GROUP_ID)
            String workplaceGroupId,
        @Path(IRequestAndQueryParams.SETUP_TRANSITION_RULE_ID)
            String setupTransitionRuleId);

    /**
     * Creates a call that can be sent to the server and deletes a setup transition rule of a workplace group by ID.
     *
     * @param workplaceGroupId      The workplace group ID.
     * @param setupTransitionRuleId The setup transition rule ID.
     * @return A call that can be sent to the server.
     */
    @Headers({ "Content-Type: application/json", "Accept: application/hal+json" })
    @DELETE(
        IWorkplaceGroupPaths.WORKPLACE_GROUPS + "/{" + IRequestAndQueryParams.WORKPLACE_GROUP_ID + "}/" + IWorkplaceGroupPaths.SETUP_TRANSITION_RULES + "/{" +
        IRequestAndQueryParams.SETUP_TRANSITION_RULE_ID + "}")
    Call<Void> deleteSetupTransitionRule(
        @Path(IRequestAndQueryParams.WORKPLACE_GROUP_ID)
            String workplaceGroupId,
        @Path(IRequestAndQueryParams.SETUP_TRANSITION_RULE_ID)
            String setupTransitionRuleId);

    /**
     * Creates a call that can be sent to the server and updates a setup transition rule of a workplace group.
     *
     * @param workplaceGroupId              The workplace group ID.
     * @param setupTransitionRuleId         The setup transition rule ID.
     * @param setupTransitionRuleProperties The setup transition rule properties.
     * @return A call that can be sent to the server.
     */
    @Headers({ "Content-Type: application/json", "Accept: application/hal+json" })
    @PUT(IWorkplaceGroupPaths.WORKPLACE_GROUPS + "/{" + IRequestAndQueryParams.WORKPLACE_GROUP_ID + "}/" + IWorkplaceGroupPaths.SETUP_TRANSITION_RULES + "/{" +
         IRequestAndQueryParams.SETUP_TRANSITION_RULE_ID + "}")
    Call<HALWSModel> updateSetupTransitionRule(
        @Path(IRequestAndQueryParams.WORKPLACE_GROUP_ID)
            String workplaceGroupId,
        @Path(IRequestAndQueryParams.SETUP_TRANSITION_RULE_ID)
            String setupTransitionRuleId,
        @Body
            CreateSetupTransitionRulePropertiesWSModel setupTransitionRuleProperties);

    /**
     * Creates a call that can be sent to the server and gets the manufacturing variant rule by ID.
     *
     * @param workplaceGroupId           The workplace group ID.
     * @param manufacturingVariantRuleId Manufacturing variant rule ID.
     * @return A call that can be sent to the server.
     */
    @Headers({ "Content-Type: application/json", "Accept: application/hal+json" })
    @GET(IWorkplaceGroupPaths.WORKPLACE_GROUPS + "/{" + IRequestAndQueryParams.WORKPLACE_GROUP_ID + "}/" + IWorkplaceGroupPaths.MANUFACTURING_VARIANT_RULES +
         "/{" + IRequestAndQueryParams.MANUFACTURING_VARIANT_RULE_ID + "}")
    Call<HALWSModel> getManufacturingVariantRule(
        @Path(IRequestAndQueryParams.WORKPLACE_GROUP_ID)
            String workplaceGroupId,
        @Path(IRequestAndQueryParams.MANUFACTURING_VARIANT_RULE_ID)
            String manufacturingVariantRuleId);

    /**
     * Creates a call that can be sent to the server and deletes the manufacturing variant rule by ID.
     *
     * @param workplaceGroupId           The workplace group ID.
     * @param manufacturingVariantRuleId Manufacturing variant rule ID.
     * @return A call that can be sent to the server.
     */
    @Headers({ "Content-Type: application/json", "Accept: application/hal+json" })
    @DELETE(IWorkplaceGroupPaths.WORKPLACE_GROUPS + "/{" + IRequestAndQueryParams.WORKPLACE_GROUP_ID + "}/" + IWorkplaceGroupPaths.MANUFACTURING_VARIANT_RULES +
            "/{" + IRequestAndQueryParams.MANUFACTURING_VARIANT_RULE_ID + "}")
    Call<Void> deleteManufacturingVariantRule(
        @Path(IRequestAndQueryParams.WORKPLACE_GROUP_ID)
            String workplaceGroupId,
        @Path(IRequestAndQueryParams.MANUFACTURING_VARIANT_RULE_ID)
            String manufacturingVariantRuleId);

    /**
     * Creates a call that can be sent to the server and updates manufacturing variant rule by ID.
     *
     * @param workplaceGroupId           The workplace group ID.
     * @param manufacturingVariantRuleId Manufacturing variant rule ID.
     * @param manufacturingVariantRule   The manufacturing variant rule properties.
     * @return A call that can be sent to the server.
     */
    @Headers({ "Content-Type: application/json", "Accept: application/hal+json" })
    @PUT(IWorkplaceGroupPaths.WORKPLACE_GROUPS + "/{" + IRequestAndQueryParams.WORKPLACE_GROUP_ID + "}/" + IWorkplaceGroupPaths.MANUFACTURING_VARIANT_RULES +
         "/{" + IRequestAndQueryParams.MANUFACTURING_VARIANT_RULE_ID + "}")
    Call<HALWSModel> updateManufacturingVariantRule(
        @Path(IRequestAndQueryParams.WORKPLACE_GROUP_ID)
            String workplaceGroupId,
        @Path(IRequestAndQueryParams.MANUFACTURING_VARIANT_RULE_ID)
            String manufacturingVariantRuleId,
        @Body
            WorkplaceGroupManufacturingVariantRuleRequestBody manufacturingVariantRule);

    /**
     * Creates a call that can be sent to the server and gets all manufacturing variant rules of a workplace group.
     *
     * @param workplaceGroupId The workplace group ID.
     * @param workplaceNumber  The workplace number.
     * @param materialNumber   The material number.
     * @param criterion        The criterion.
     * @param origin           The origin.
     * @param offset           The request offset.
     * @param limit            The request limit.
     * @return A call that can be sent to the server.
     */
    @Headers({ "Content-Type: application/json", "Accept: application/hal+json" })
    @GET(IWorkplaceGroupPaths.WORKPLACE_GROUPS + "/{" + IRequestAndQueryParams.WORKPLACE_GROUP_ID + "}/" + IWorkplaceGroupPaths.MANUFACTURING_VARIANT_RULES)
    Call<HALCollectionWSModel> getManufacturingVariantRules(
        @Path(IRequestAndQueryParams.WORKPLACE_GROUP_ID)
            String workplaceGroupId,
        @Query(IRequestAndQueryParams.ORIGIN)
            ManufacturingVariantRuleOrigin origin,
        @Query(IRequestAndQueryParams.CRITERION)
            ManufacturingVariantRuleCriterion criterion,
        @Query(IRequestAndQueryParams.MATERIAL_NUMBER)
            String materialNumber,
        @Query(IRequestAndQueryParams.WORKPLACE_NUMBER)
            String workplaceNumber,
        @Query(IRequestAndQueryParams.LIMIT)
            int limit,
        @Query(IRequestAndQueryParams.OFFSET)
            int offset);

    /**
     * Creates a call that can be sent to the server and creates a new manufacturing variant rule for a workplace group.
     *
     * @param workplaceGroupId         The workplace group ID.
     * @param manufacturingVariantRule The manufacturing variant rule.
     * @return A call that can be sent to the server.
     */
    @Headers({ "Content-Type: application/json", "Accept: application/hal+json" })
    @POST(IWorkplaceGroupPaths.WORKPLACE_GROUPS + "/{" + IRequestAndQueryParams.WORKPLACE_GROUP_ID + "}/" + IWorkplaceGroupPaths.MANUFACTURING_VARIANT_RULES)
    Call<HALWSModel> createManufacturingVariantRule(
        @Path(IRequestAndQueryParams.WORKPLACE_GROUP_ID)
            String workplaceGroupId,
        @Body
            WorkplaceGroupManufacturingVariantRuleRequestBody manufacturingVariantRule);
}