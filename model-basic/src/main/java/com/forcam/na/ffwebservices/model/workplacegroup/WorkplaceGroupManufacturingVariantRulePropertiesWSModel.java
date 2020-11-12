////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 23.11.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.workplacegroup;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.forcam.na.ffwebservices.model.tool.ToolGeneralDefinitionWSModel;
import com.forcam.na.ffwebservices.model.workplace.WorkplaceGeneralDefinitionWSModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@ApiModel("workGroupManufacturingVariantRuleProperties")
@JsonPropertyOrder({ "id", "origin", "criterion", "conditions", "workplaces", "tools", "additionalConditions", "forecastedDelays" })
public class WorkplaceGroupManufacturingVariantRulePropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private String mId;

    private ManufacturingVariantRuleOrigin mOrigin;

    private ManufacturingVariantRuleCriterion mCriterion;

    private String mConditions;

    private List<WorkplaceGeneralDefinitionWSModel> mWorkplaces = new ArrayList<>();

    private List<ToolGeneralDefinitionWSModel> mTools = new ArrayList<>();

    private String mAdditionalConditions;

    private WorkplaceGroupManufacturingVariantRuleForecastWSModel mForecastedDelays;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public String getId() {
        return mId;
    }

    @ApiModelProperty(value = "UUID of the manufacturing variant", required = true, position = 0)
    public void setId(String id) {
        mId = id;
    }

    public ManufacturingVariantRuleOrigin getOrigin() {
        return mOrigin;
    }

    @ApiModelProperty(value = "The origin of the entry that is either 'MANUAL_DATA_MAINTENANCE' if the entry was created by manual data maintenance or 'AUTOMATIC_EVALUATION_SYSTEM' if an evaluation system has generated the entry", position = 1)
    public void setOrigin(ManufacturingVariantRuleOrigin origin) {
        mOrigin = origin;
    }

    public ManufacturingVariantRuleCriterion getCriterion() {
        return mCriterion;
    }

    @ApiModelProperty(value = "The criterion for which a material must fulfill the specified condition in order to be able to apply the manufacturing variant for producing the material. Options are MATERIAL_NUMBER or MATERIAL_CHARACTERISTICS", position = 2)
    public void setCriterion(ManufacturingVariantRuleCriterion criterion) {
        mCriterion = criterion;
    }

    public String getConditions() {
        return mConditions;
    }

    @ApiModelProperty(value =
        "If the material number is the criterion, a specification of the material by the material number, e.g. materialNumber==0815, materialNumber==0816 (the UUID of the ERP context is not required because the material number is unique in the context of a workplace group)." +
        "\n" +
        "If a material characteristic is the criterion: A condition relating to the characteristics of the material that is produced (e.g. color==black;width=lt=40)", position = 3)
    public void setConditions(String conditions) {
        mConditions = conditions;
    }

    public List<WorkplaceGeneralDefinitionWSModel> getWorkplaces() {
        return mWorkplaces;
    }

    @ApiModelProperty(value = "Array of workplaces to which the manufacturing variant applies", position = 4)
    public void setWorkplaces(List<WorkplaceGeneralDefinitionWSModel> workplaces) {
        mWorkplaces = workplaces;
    }

    public List<ToolGeneralDefinitionWSModel> getTools() {
        return mTools;
    }

    @ApiModelProperty(value = "Array of tools to which the manufacturing variant applies", notes = "(Optional)", position = 5)
    public void setTools(List<ToolGeneralDefinitionWSModel> tools) {
        mTools = tools;
    }

    public String getAdditionalConditions() {
        return mAdditionalConditions;
    }

    @ApiModelProperty(value = "The possibility of specifying further conditions formulated in RSQL", notes = "These conditions are only passed on by the IoT platform, but are not evaluated", position = 6)
    public void setAdditionalConditions(String additionalConditions) {
        mAdditionalConditions = additionalConditions;
    }

    public WorkplaceGroupManufacturingVariantRuleForecastWSModel getForecastedDelays() {
        return mForecastedDelays;
    }

    @ApiModelProperty(value = "The structure below", position = 7)
    public void setForecastedDelays(WorkplaceGroupManufacturingVariantRuleForecastWSModel forecastedDelays) {
        mForecastedDelays = forecastedDelays;
    }

}
