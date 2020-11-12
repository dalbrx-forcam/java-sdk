////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 12.11.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.staffmember;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Properties model for a staff member planning scenario.
 */
@XmlRootElement(name = "staffMemberPlanningScenarioProperties")
@ApiModel(value = "staffMemberPlanningScenarioProperties")
@JsonPropertyOrder({ "id", "creator", "creationDate", "startDate", "endDate", "operationsPlanningScenarioId", "numberOfPlannedStaffMembers",
                     "scheduledWorkingTime", "occupancyTime", "occupancyRate", "numberOfWorkplaces", "requirementOfStaffHours",
                     "coverageOfPersonnelRequirements", "elements" })
public class StaffMemberPlanningScenarioPropertiesWSModel extends StaffMemberPlanningScenariosPropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** List of staff member assignments. */
    private List<StaffMemberAssignmentWSModel> mElements = new ArrayList<>();

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public List<StaffMemberAssignmentWSModel> getElements() {
        return mElements;
    }

    @ApiModelProperty(value = "Array of Assignments", position = 13)
    public void setElements(List<StaffMemberAssignmentWSModel> elements) {
        mElements = elements;
    }
}