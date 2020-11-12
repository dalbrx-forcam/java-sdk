////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 28.11.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.workplacegroup;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.forcam.na.ffwebservices.model.workplace.WorkplaceGeneralDefinitionWSModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Properties of a setup transition rule.
 */
@XmlRootElement(name = "setupTransitionRuleProperties")
@ApiModel(value = "setupTransitionRuleProperties")
@JsonPropertyOrder({ "id", "origin", "workplaces", "criterion", "predecessorConditions", "successorConditions", "setupTimeIncrement", "setupTime" })
public class SetupTransitionRulePropertiesWSModel extends CreateSetupTransitionRulePropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The setup transition rule ID. */
    private String mId;

    /** List of affected workplace. */
    private List<WorkplaceGeneralDefinitionWSModel> mWorkplaces;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    @ApiModelProperty(value = "UUID of the setup transition rule ", required = true, position = 0)
    public void setId(String id) {
        mId = id;
    }

    public String getId() {
        return mId;
    }

    public List<WorkplaceGeneralDefinitionWSModel> getWorkplaces() {
        return mWorkplaces;
    }

    @ApiModelProperty(value = "The list of workplace if the setup time for the setup transition at different workplaces in the workplace group is different", notes = "This is rather an exception and can never be the case for a production line, because the line must always be reconfigured as a whole)", position = 2)
    public void setWorkplaces(List<WorkplaceGeneralDefinitionWSModel> workplaces) {
        mWorkplaces = workplaces;
    }
}