////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 18.09.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.operation;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Properties of an operation planning scenario.
 */
@XmlRootElement(name = "operationPlanningScenarioProperties")
@ApiModel(value = "operationPlanningScenarioProperties")
@JsonPropertyOrder({ "id", "creator", "creationDate", "startDate", "endDate", "numberOfWorkplaces", "scheduledOperatingTime", "plannedProcessingTime",
                     "plannedExecutionTime", "numberOfPlannedProductionOrders", "plannedLeadTime", "minimumLeadTimeWithSetup",
                     "numberOfPartiallyPlannedProductionOrders", "adherenceToDeliveryDates", "schedulingEfficiency", "occupancyRate", "setupReduction",
                     "elements" })
public class OperationPlanningScenarioPropertiesWSModel extends OperationPlanningScenariosPropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** List of operation planning scenario assignments. */
    private List<OperationAssignmentWSModel> mElements = new ArrayList<>();

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public List<OperationAssignmentWSModel> getElements() {
        return mElements;
    }

    @ApiModelProperty(value = "Array of operation assignments", position = 18)
    public void setElements(List<OperationAssignmentWSModel> elements) {
        mElements = elements;
    }
}