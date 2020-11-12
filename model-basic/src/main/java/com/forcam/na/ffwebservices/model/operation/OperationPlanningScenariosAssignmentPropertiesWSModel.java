////////////////////////////////////////////////////////////////////////////////
//
// Created by abhishekmundewal on 11-May-18.
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
 * Operation planning scenarios collection properties model.
 */
@XmlRootElement(name = "operationPlanningScenarioAssignmentProperties")
@ApiModel(value = "operationPlanningScenarioAssignmentProperties")
@JsonPropertyOrder({ "elements" })
public class OperationPlanningScenariosAssignmentPropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The operation planning scenarios. */
    private List<OperationAssignmentWSModel> mElements = new ArrayList<>();

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Provides the list of operation planning scenarios.
     *
     * @param elements List of operation planning scenarios WS models.
     */
    @ApiModelProperty(value = "Array of operation assignments", position = 0)
    public void setElements(List<OperationAssignmentWSModel> elements) {
        mElements = elements;
    }

    /**
     * Sets the list of operation planning scenarios.
     *
     * @return The list of operation planning scenarios WS models.
     */
    public List<OperationAssignmentWSModel> getElements() {
        return mElements;
    }
}