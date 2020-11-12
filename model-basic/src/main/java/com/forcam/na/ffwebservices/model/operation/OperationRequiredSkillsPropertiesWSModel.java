////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 10.12.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.operation;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * The webservice model for the properties of operation required skills.
 */
@ApiModel("operationRequiredSkillsProperties")
@JsonPropertyOrder({ "setup", "processing" })
public class OperationRequiredSkillsPropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private List<OperationRequiredSkill> mSetup = new ArrayList<>();

    private List<OperationRequiredSkill> mProcessing = new ArrayList<>();

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public List<OperationRequiredSkill> getSetup() {
        return mSetup;
    }

    @ApiModelProperty(position = 0, value = "Array of required skills for setup")
    public void setSetup(List<OperationRequiredSkill> setup) {
        mSetup = setup;
    }

    public List<OperationRequiredSkill> getProcessing() {
        return mProcessing;
    }

    @ApiModelProperty(position = 1, value = "Array of required skills for processing")
    public void setProcessing(List<OperationRequiredSkill> processing) {
        mProcessing = processing;
    }

}
