////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 19.03.2019.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.workplacegroup;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@XmlRootElement(name = "createSetupTransitionRuleBody")
@ApiModel(value = "createSetupTransitionRuleBody")
@JsonPropertyOrder({ "origin", "workplaceIds", "workplaceNumbers", "criterion", "predecessorConditions", "successorConditions", "setupTimeIncrement",
                     "setupTime" })
public class CreateSetupTransitionRulePropertiesBody extends CreateSetupTransitionRulePropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** List of workplace IDs. */
    private List<String> mWorkplaceIds = new ArrayList<>();

    /** List of workplace numbers. */
    private List<String> mWorkplaceNumbers = new ArrayList<>();

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public List<String> getWorkplaceIds() {
        return mWorkplaceIds;
    }

    @ApiModelProperty(value = "List of workplace IDs", position = 2)
    public void setWorkplaceIds(List<String> workplaceIds) {
        mWorkplaceIds = workplaceIds;
    }

    public List<String> getWorkplaceNumbers() {
        return mWorkplaceNumbers;
    }

    @ApiModelProperty(value = "List of workplace numbers", position = 3)
    public void setWorkplaceNumbers(List<String> workplaceNumbers) {
        mWorkplaceNumbers = workplaceNumbers;
    }
}