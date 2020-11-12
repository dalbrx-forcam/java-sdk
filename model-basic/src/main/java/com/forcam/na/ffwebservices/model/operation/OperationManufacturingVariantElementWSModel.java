////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 23.11.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.operation;

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
@ApiModel("operationManufacturingVariantElement")
@JsonPropertyOrder({ "workplaces", "tools", "additionalConditions", "forecastedDelays" })
public class OperationManufacturingVariantElementWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private List<WorkplaceGeneralDefinitionWSModel> mWorkplaces = new ArrayList<>();

    private List<ToolGeneralDefinitionWSModel> mTools = new ArrayList<>();

    private String mAdditionalConditions;

    private OperationManufacturingVariantForecastWSModel mForecast;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public List<WorkplaceGeneralDefinitionWSModel> getWorkplaces() {
        return mWorkplaces;
    }

    @ApiModelProperty(value = "Array of workplaces to describe the manufacturing variant", position = 0)
    public void setWorkplaces(List<WorkplaceGeneralDefinitionWSModel> workplaces) {
        mWorkplaces = workplaces;
    }

    public List<ToolGeneralDefinitionWSModel> getTools() {
        return mTools;
    }

    @ApiModelProperty(value = "Array of tools to describe the manufacturing variant", position = 1)
    public void setTools(List<ToolGeneralDefinitionWSModel> tools) {
        mTools = tools;
    }

    public String getAdditionalConditions() {
        return mAdditionalConditions;
    }

    @ApiModelProperty(value = "Additional conditions formulated in RSQL, which are only passed on by the IoT platform, but not evaluated", position = 2)
    public void setAdditionalConditions(String additionalConditions) {
        mAdditionalConditions = additionalConditions;
    }

    public OperationManufacturingVariantForecastWSModel getForecast() {
        return mForecast;
    }

    @ApiModelProperty(value = "Forecast delays", position = 3)
    public void setForecast(OperationManufacturingVariantForecastWSModel forecast) {
        mForecast = forecast;
    }

}
