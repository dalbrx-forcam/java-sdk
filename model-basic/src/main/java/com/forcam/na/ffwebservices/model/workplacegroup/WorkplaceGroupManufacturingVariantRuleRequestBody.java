////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 23.11.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.workplacegroup;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * The workplace group processing variant request body used when creating a processing variant.
 */
@JsonPropertyOrder({ "origin", "criterion", "conditions", "workplaces", "tools", "additionalConditions", "forecastedDelays" })
public class WorkplaceGroupManufacturingVariantRuleRequestBody {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    @NotNull
    private ManufacturingVariantRuleOrigin mOrigin;

    @NotNull
    private ManufacturingVariantRuleCriterion mCriterion;

    @NotBlank
    private String mConditions;

    @NotEmpty
    private List<String> mWorkplaceIds;

    @NotNull
    private List<String> mToolIds;

    @NotBlank
    private String mAdditionalsConditions;

    @NotNull
    private WorkplaceGroupManufacturingVariantRuleForecastRequestBody mForecastedDelays;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public ManufacturingVariantRuleOrigin getOrigin() {
        return mOrigin;
    }

    @ApiModelProperty(position = 0, required = true)
    public void setOrigin(ManufacturingVariantRuleOrigin origin) {
        mOrigin = origin;
    }

    public ManufacturingVariantRuleCriterion getCriterion() {
        return mCriterion;
    }

    @ApiModelProperty(position = 1, required = true)
    public void setCriterion(ManufacturingVariantRuleCriterion criterion) {
        mCriterion = criterion;
    }

    public String getConditions() {
        return mConditions;
    }

    @ApiModelProperty(position = 2, required = true)
    public void setConditions(String conditions) {
        mConditions = conditions;
    }

    public List<String> getWorkplaceIds() {
        return mWorkplaceIds;
    }

    @ApiModelProperty(position = 3, required = true)
    public void setWorkplaceIds(List<String> workplaceIds) {
        mWorkplaceIds = workplaceIds;
    }

    public List<String> getToolIds() {
        return mToolIds;
    }

    @ApiModelProperty(position = 4, required = true)
    public void setToolIds(List<String> toolIds) {
        mToolIds = toolIds;
    }

    public String getAdditionalsConditions() {
        return mAdditionalsConditions;
    }

    @ApiModelProperty(position = 5, required = true)
    public void setAdditionalsConditions(String additionalsConditions) {
        mAdditionalsConditions = additionalsConditions;
    }

    public WorkplaceGroupManufacturingVariantRuleForecastRequestBody getForecastedDelays() {
        return mForecastedDelays;
    }

    @ApiModelProperty(position = 6, required = true)
    public void setForecastedDelays(WorkplaceGroupManufacturingVariantRuleForecastRequestBody forecastedDelays) {
        mForecastedDelays = forecastedDelays;
    }

}
