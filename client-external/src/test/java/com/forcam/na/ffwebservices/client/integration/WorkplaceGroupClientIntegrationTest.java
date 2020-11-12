////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 28.02.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.integration;

import com.forcam.na.ffwebservices.client.api.exception.ForceAPIException;
import com.forcam.na.ffwebservices.client.api.pagination.response.Page;
import com.forcam.na.ffwebservices.client.api.workplacegroup.request.GetManufacturingVariantRuleCollectionRequest;
import com.forcam.na.ffwebservices.client.api.workplacegroup.request.GetManufacturingVariantRuleRequest;
import com.forcam.na.ffwebservices.client.api.workplacegroup.request.GetWorkplaceGroupAssignedWorkplacesRequest;
import com.forcam.na.ffwebservices.client.api.workplacegroup.request.GetWorkplaceGroupRequest;
import com.forcam.na.ffwebservices.client.api.workplacegroup.request.GetWorkplaceGroupSetupTransitionRuleCollectionRequest;
import com.forcam.na.ffwebservices.client.api.workplacegroup.request.GetWorkplaceGroupSetupTransitionsRequest;
import com.forcam.na.ffwebservices.client.api.workplacegroup.request.GetWorkplaceGroupsRequest;
import com.forcam.na.ffwebservices.client.api.workplacegroup.request.SaveOrUpdateManufacturingVariantRuleRequest;
import com.forcam.na.ffwebservices.client.api.workplacegroup.WorkplaceGroupClient;
import com.forcam.na.ffwebservices.client.api.workplacegroup.response.WorkplaceGroupSetupTransitionsResponse;
import com.forcam.na.ffwebservices.model.workplace.WorkplaceResponse;
import com.forcam.na.ffwebservices.model.workplacegroup.ManufacturingVariantRuleCriterion;
import com.forcam.na.ffwebservices.model.workplacegroup.ManufacturingVariantRuleOrigin;
import com.forcam.na.ffwebservices.model.workplacegroup.WorkplaceGroupManufacturingVariantRuleForecastRequestBody;
import com.forcam.na.ffwebservices.model.workplacegroup.WorkplaceGroupManufacturingVariantRuleRequestBody;
import com.forcam.na.ffwebservices.model.workplacegroup.WorkplaceGroupManufacturingVariantRuleResponse;
import com.forcam.na.ffwebservices.model.workplacegroup.WorkplaceGroupResponse;
import com.forcam.na.ffwebservices.model.workplacegroup.WorkplaceGroupSetupTransitionRuleResponse;
import org.junit.*;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Integration tests for the class {@link WorkplaceGroupClient}.
 */
public class WorkplaceGroupClientIntegrationTest extends AbstractOpenAPIIntegrationTest {

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    public WorkplaceGroupClientIntegrationTest() {
        final Pattern workplaceGroupsPattern = Pattern.compile(PREFIX_GET_PATH + "/workplaceGroups\\?.*limit=3.*");
        mFileNames.put(workplaceGroupsPattern, "json/getWorkplaceGroups.json");

        final Pattern workplaceGroupPattern = Pattern.compile(PREFIX_GET_PATH + "/workplaceGroups/.{32}\\?.*");
        mFileNames.put(workplaceGroupPattern, "json/getWorkplaceGroup.json");

        final Pattern workplacesPattern = Pattern.compile(PREFIX_GET_PATH + "/workplaceGroups/.{32}/assignedWorkplaces\\?.*");
        mFileNames.put(workplacesPattern, "json/getWorkplaceGroupAssignedWorkplaces.json");

        final Pattern setupTransitionsPattern = Pattern.compile(PREFIX_GET_PATH + "/workplaceGroups/.{32}/setupTransitions\\?.*");
        mFileNames.put(setupTransitionsPattern, "json/getWorkplaceGroupSetupTransitions.json");

        final Pattern setupTransitionRulesPattern = Pattern.compile(PREFIX_GET_PATH + "/workplaceGroups/.{32}/setupTrasitionRules\\?.*");
        mFileNames.put(setupTransitionRulesPattern, "json/getWorkplaceGroupSetupTransitionRules.json");
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    /**
     * Test for the method {@link WorkplaceGroupClient#getWorkplaceGroups(GetWorkplaceGroupsRequest)}.
     *
     * @throws ForceAPIException When unable to get workplace groups.
     */
    @Test
    public void testGetWorkplaceGroups() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final GetWorkplaceGroupsRequest request = new GetWorkplaceGroupsRequest();
        request.setLimit(3);
        request
            .embed()
            .description(true)
            .workplaces(true)
            .erpContext(true);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final Page<WorkplaceGroupResponse> workplaceGroupCollection = mWorkplaceGroupClient.getWorkplaceGroups(request);

        Assert.assertNotNull(workplaceGroupCollection);
    }

    /**
     * Test for the method {@link WorkplaceGroupClient#getWorkplaceGroup(GetWorkplaceGroupRequest)}.
     *
     * @throws ForceAPIException When unable to get workplace group.
     */
    @Test
    public void testGetWorkplaceGroup() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final String workplaceGroupId = this.getWorkplaceGroupId();

        final GetWorkplaceGroupRequest request = new GetWorkplaceGroupRequest(workplaceGroupId);
        request
            .embed()
            .description(true)
            .workplaces(true);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final WorkplaceGroupResponse workplaceGroupModel = mWorkplaceGroupClient.getWorkplaceGroup(request);

        Assert.assertNotNull(workplaceGroupModel);
        Assert.assertNotNull(workplaceGroupModel.getProperties());
    }

    /**
     * Test for the method {@link WorkplaceGroupClient#getAssignedWorkplaces(GetWorkplaceGroupAssignedWorkplacesRequest)}.
     *
     * @throws ForceAPIException When unable to get workplaces.
     */
    @Test
    public void testGetAssignedWorkplaces() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final String workplaceGroupId = this.getWorkplaceGroupId();

        final GetWorkplaceGroupAssignedWorkplacesRequest request = new GetWorkplaceGroupAssignedWorkplacesRequest(workplaceGroupId);
        request.setLimit(3);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final Page<WorkplaceResponse> workplaceCollection = mWorkplaceGroupClient.getAssignedWorkplaces(request);

        Assert.assertNotNull(workplaceCollection);
    }

    /**
     * Test for the method {@link WorkplaceGroupClient#getSetupTransitions(GetWorkplaceGroupSetupTransitionsRequest)}.
     *
     * @throws ForceAPIException When unable to get workplace group setup transitions.
     */
    @Test
    public void testGetSetupTransitions() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final String workplaceGroupId = this.getWorkplaceGroupId();

        final GetWorkplaceGroupSetupTransitionsRequest request = new GetWorkplaceGroupSetupTransitionsRequest(workplaceGroupId);
        request.setLimit(3);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final WorkplaceGroupSetupTransitionsResponse setupTransitions = mWorkplaceGroupClient.getSetupTransitions(request);

        Assert.assertNotNull(setupTransitions);
        Assert.assertNotNull(setupTransitions
                                 .getProperties()
                                 .getCreationDate());
        Assert.assertNotNull(setupTransitions.getElements());
        Assert.assertNotNull(setupTransitions.getPagination());
    }

    /**
     * Test for the method {@link WorkplaceGroupClient#getSetupTransitionRules(GetWorkplaceGroupSetupTransitionRuleCollectionRequest)}.
     *
     * @throws ForceAPIException When unable to get workplace group setup transition rules.
     */
    @Test
    public void testGetSetupTransitionRules() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final String workplaceGroupId = this.getWorkplaceGroupId();

        final GetWorkplaceGroupSetupTransitionRuleCollectionRequest request = new GetWorkplaceGroupSetupTransitionRuleCollectionRequest(workplaceGroupId);
        request.setLimit(3);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final Page<WorkplaceGroupSetupTransitionRuleResponse> setupTransitionRules = mWorkplaceGroupClient.getSetupTransitionRules(request);

        Assert.assertNotNull(setupTransitionRules);
        Assert.assertNotNull(setupTransitionRules
                                 .getResponse()
                                 .getEmbedded());
        Assert.assertNotNull(setupTransitionRules.getElements());
        Assert.assertNotNull(setupTransitionRules.getPagination());
        Assert.assertNotNull(setupTransitionRules
                                 .getResponse()
                                 .getPaginationLinks()
                                 .getSelf());
    }

    /**
     * Test for the method {@link WorkplaceGroupClient#getManufacturingVariantRules(GetManufacturingVariantRuleCollectionRequest)}.
     *
     * @throws ForceAPIException When unable to get workplace group manufacturing variant rules.
     */
    @Test
    public void testGetManufacturingVariantRulesCollection() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final String workplaceGroupId = this.getWorkplaceGroupId();

        final GetManufacturingVariantRuleCollectionRequest request = new GetManufacturingVariantRuleCollectionRequest(workplaceGroupId);
        request.setLimit(3);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final Page<WorkplaceGroupManufacturingVariantRuleResponse> manufacturingVariantRules = mWorkplaceGroupClient.getManufacturingVariantRules(request);

        Assert.assertNotNull(manufacturingVariantRules);
        Assert.assertNotNull(manufacturingVariantRules.getElements());
        Assert.assertNotNull(manufacturingVariantRules.getPagination());
        Assert.assertNotNull(manufacturingVariantRules
                                 .getResponse()
                                 .getEmbedded());
        Assert.assertNotNull(manufacturingVariantRules
                                 .getResponse()
                                 .getPaginationLinks()
                                 .getSelf());
    }

    /**
     * Test for the method {@link WorkplaceGroupClient#getManufacturingVariantRule(GetManufacturingVariantRuleRequest)}.
     *
     * @throws ForceAPIException When unable to get workplace group manufacturing variant rule.
     */
    @Test
    public void testGetManufacturingVariantRule() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        this.testSaveManufacturingVariantRule();

        final String workplaceGroupId = this.getWorkplaceGroupId();
        final String workplaceGroupManufacturingVariantRuleId = this.getWorkplaceGroupManufacturingVariantRuleId();

        final GetManufacturingVariantRuleRequest request = new GetManufacturingVariantRuleRequest(workplaceGroupId, workplaceGroupManufacturingVariantRuleId);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final WorkplaceGroupManufacturingVariantRuleResponse manufacturingVariantRule = mWorkplaceGroupClient.getManufacturingVariantRule(request);

        Assert.assertNotNull(manufacturingVariantRule);
        Assert.assertNotNull(manufacturingVariantRule.getSelf());
        Assert.assertNotNull(manufacturingVariantRule.getProperties());
        Assert.assertEquals(workplaceGroupManufacturingVariantRuleId,
                            manufacturingVariantRule
                                .getProperties()
                                .getId());
        Assert.assertNotNull(manufacturingVariantRule
                                 .getProperties()
                                 .getConditions());
        Assert.assertNotNull(manufacturingVariantRule
                                 .getProperties()
                                 .getOrigin());
        Assert.assertNotNull(manufacturingVariantRule
                                 .getProperties()
                                 .getCriterion());
        Assert.assertNotNull(manufacturingVariantRule
                                 .getProperties()
                                 .getForecastedDelays());
        Assert.assertNotNull(manufacturingVariantRule
                                 .getProperties()
                                 .getForecastedDelays()
                                 .getPerformance());
        Assert.assertNotNull(manufacturingVariantRule
                                 .getProperties()
                                 .getForecastedDelays()
                                 .getAdditionalSetupTime());
        Assert.assertNotNull(manufacturingVariantRule
                                 .getProperties()
                                 .getWorkplaces()
                                 .get(0));
    }

    /**
     * Test for the method {@link WorkplaceGroupClient#deleteManufacturingVariantRule(GetManufacturingVariantRuleRequest)}.
     *
     * @throws ForceAPIException When unable to delete workplace group manufacturing variant rule.
     */
    @Test
    public void testDeleteManufacturingVariantRule() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        this.testSaveManufacturingVariantRule();

        final String workplaceGroupId = this.getWorkplaceGroupId();
        final String manufacturingVariantRuleId = this.getWorkplaceGroupManufacturingVariantRuleId();

        final GetManufacturingVariantRuleRequest request = new GetManufacturingVariantRuleRequest(workplaceGroupId, manufacturingVariantRuleId);

        final WorkplaceGroupManufacturingVariantRuleResponse manufacturingVariantRule = mWorkplaceGroupClient.getManufacturingVariantRule(request);
        Assert.assertNotNull(manufacturingVariantRule);
        Assert.assertNotNull(manufacturingVariantRule
                                 .getProperties()
                                 .getId());

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mWorkplaceGroupClient.deleteManufacturingVariantRule(request);

        try {
            mWorkplaceGroupClient.getManufacturingVariantRule(request);
        } catch (ForceAPIException e) {
            Assert.assertEquals(
                "Manufacturing variant rule with id '" + manufacturingVariantRuleId + "' of workplace group '" + workplaceGroupId + "' not found",
                e.getMessage());
        }
    }

    /**
     * Test for the method {@link WorkplaceGroupClient#createManufacturingVariantRule(SaveOrUpdateManufacturingVariantRuleRequest)}.
     *
     * @throws ForceAPIException When unable to create workplace group manufacturing variant rules.
     */
    @Test
    public void testSaveManufacturingVariantRule() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final String workplaceGroupId = this.getWorkplaceGroupId();

        final List<String> workplaceIds = new ArrayList<>(1);
        workplaceIds.add(super.getWorkplaceId());

        final WorkplaceGroupManufacturingVariantRuleForecastRequestBody forecastRequestBody = new WorkplaceGroupManufacturingVariantRuleForecastRequestBody();
        forecastRequestBody.setIntermediateSetupInterval(2.4);
        forecastRequestBody.setIntermediateSetupTime(35445L);
        forecastRequestBody.setAdditionalSetupTime(3489L);
        forecastRequestBody.setStaffCapacityFactor(0.2);
        forecastRequestBody.setProcessAvailability(0.3);
        forecastRequestBody.setPerformance(0.5);
        forecastRequestBody.setQualityRate(0.2);
        forecastRequestBody.setSkillFactor(1.2);

        final WorkplaceGroupManufacturingVariantRuleRequestBody manufacturingVariantRule = new WorkplaceGroupManufacturingVariantRuleRequestBody();
        manufacturingVariantRule.setCriterion(ManufacturingVariantRuleCriterion.MATERIAL_CHARACTERISTIC);
        manufacturingVariantRule.setOrigin(ManufacturingVariantRuleOrigin.MANUAL_DATA_MAINTENANCE);
        manufacturingVariantRule.setAdditionalsConditions("Test additional conditions");
        manufacturingVariantRule.setToolIds(new ArrayList<>(0));
        manufacturingVariantRule.setForecastedDelays(forecastRequestBody);
        manufacturingVariantRule.setConditions("Test conditions");
        manufacturingVariantRule.setWorkplaceIds(workplaceIds);

        final SaveOrUpdateManufacturingVariantRuleRequest saveRequest = new SaveOrUpdateManufacturingVariantRuleRequest(workplaceGroupId,
                                                                                                                        manufacturingVariantRule);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final WorkplaceGroupManufacturingVariantRuleResponse createdManufacturingVariantRule = mWorkplaceGroupClient.createManufacturingVariantRule(saveRequest);

        Assert.assertNotNull(createdManufacturingVariantRule);
        Assert.assertNotNull(createdManufacturingVariantRule.getSelf());
        Assert.assertNotNull(createdManufacturingVariantRule
                                 .getProperties()
                                 .getId());
        Assert.assertNotNull(createdManufacturingVariantRule
                                 .getProperties()
                                 .getConditions());
    }

    /**
     * Test for the method {@link WorkplaceGroupClient#updateManufacturingVariantRule(SaveOrUpdateManufacturingVariantRuleRequest)}.
     *
     * @throws ForceAPIException When unable to update workplace group manufacturing variant rules.
     */
    @Test
    public void testUpdateManufacturingVariantRule() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        this.testSaveManufacturingVariantRule();

        final String workplaceGroupId = this.getWorkplaceGroupId();
        final String manufacturingVariantRuleId = this.getWorkplaceGroupManufacturingVariantRuleId();

        final List<String> workplaceIds = new ArrayList<>(1);
        workplaceIds.add(super.getWorkplaceId());

        final WorkplaceGroupManufacturingVariantRuleForecastRequestBody forecastRequestBody = new WorkplaceGroupManufacturingVariantRuleForecastRequestBody();
        forecastRequestBody.setIntermediateSetupTime(22222L);
        forecastRequestBody.setAdditionalSetupTime(33333L);
        forecastRequestBody.setStaffCapacityFactor(0.2);
        forecastRequestBody.setProcessAvailability(0.9);
        forecastRequestBody.setPerformance(0.9);
        forecastRequestBody.setQualityRate(0.2);

        final WorkplaceGroupManufacturingVariantRuleRequestBody manufacturingVariantRule = new WorkplaceGroupManufacturingVariantRuleRequestBody();
        manufacturingVariantRule.setCriterion(ManufacturingVariantRuleCriterion.MATERIAL_CHARACTERISTIC);
        manufacturingVariantRule.setOrigin(ManufacturingVariantRuleOrigin.AUTOMATIC_EVALUATION_SYSTEM);
        manufacturingVariantRule.setAdditionalsConditions("Test additional conditions");
        manufacturingVariantRule.setToolIds(new ArrayList<>(0));
        manufacturingVariantRule.setForecastedDelays(forecastRequestBody);
        manufacturingVariantRule.setConditions("Test conditions");
        manufacturingVariantRule.setWorkplaceIds(workplaceIds);

        final SaveOrUpdateManufacturingVariantRuleRequest request = new SaveOrUpdateManufacturingVariantRuleRequest(workplaceGroupId,
                                                                                                                    manufacturingVariantRuleId,
                                                                                                                    manufacturingVariantRule);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final WorkplaceGroupManufacturingVariantRuleResponse updatedManufacturingVariantRule = mWorkplaceGroupClient.updateManufacturingVariantRule(request);

        Assert.assertNotNull(updatedManufacturingVariantRule);
        Assert.assertNotNull(updatedManufacturingVariantRule.getSelf());
        Assert.assertNotNull(updatedManufacturingVariantRule
                                 .getProperties()
                                 .getId());
        Assert.assertEquals(ManufacturingVariantRuleOrigin.AUTOMATIC_EVALUATION_SYSTEM,
                            updatedManufacturingVariantRule
                                .getProperties()
                                .getOrigin());
        Assert.assertEquals(new Double(0.9),
                            updatedManufacturingVariantRule
                                .getProperties()
                                .getForecastedDelays()
                                .getPerformance());
        Assert.assertEquals(null,
                            updatedManufacturingVariantRule
                                .getProperties()
                                .getForecastedDelays()
                                .getIntermediateSetupInterval());
    }

    /**
     * Returns the ID of an available workplace group.
     *
     * @return A workplace group ID.
     * @throws ForceAPIException When unable to get workplace groups.
     */
    private String getWorkplaceGroupId() throws ForceAPIException {
        final GetWorkplaceGroupsRequest request = new GetWorkplaceGroupsRequest();
        request.setLimit(1);
        final Page<WorkplaceGroupResponse> workplaceGroupCollection = mWorkplaceGroupClient.getWorkplaceGroups(request);

        Assert.assertNotNull(workplaceGroupCollection);
        Assert.assertFalse(workplaceGroupCollection
                               .getElements()
                               .isEmpty());

        final WorkplaceGroupResponse workplaceGroup = workplaceGroupCollection
            .getElements()
            .get(0);
        Assert.assertNotNull(workplaceGroup.getProperties());

        return workplaceGroup
            .getProperties()
            .getId();
    }

    /**
     * Returns the ID of an available workplace group manufacturing variant rule.
     *
     * @return A workplace group manufacturing variant rule ID.
     * @throws ForceAPIException When unable to get workplace group manufacturing variant rules.
     */
    private String getWorkplaceGroupManufacturingVariantRuleId() throws ForceAPIException {
        final GetManufacturingVariantRuleCollectionRequest request = new GetManufacturingVariantRuleCollectionRequest(this.getWorkplaceGroupId());
        request.setLimit(1);
        final Page<WorkplaceGroupManufacturingVariantRuleResponse> manufacturingVariantRules = mWorkplaceGroupClient.getManufacturingVariantRules(request);

        Assert.assertNotNull(manufacturingVariantRules);
        Assert.assertFalse(manufacturingVariantRules
                               .getElements()
                               .isEmpty());

        final WorkplaceGroupManufacturingVariantRuleResponse ruleResponse = manufacturingVariantRules
            .getElements()
            .get(0);
        Assert.assertNotNull(ruleResponse.getProperties());

        return ruleResponse
            .getProperties()
            .getId();
    }
}