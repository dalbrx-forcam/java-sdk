////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 25.09.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.workplace;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Workplace predicted malfunction scenario properties.
 */
@XmlRootElement(name = "workplacePredictedMalfunctionScenarioProperties")
@ApiModel(value = "workplacePredictedMalfunctionScenarioProperties")
@JsonPropertyOrder({ "id", "creator", "creationDate", "startDate", "endDate", "elements" })
public class WorkplacePredictedMalfunctionScenarioPropertiesWSModel extends EmbeddedPredictedMalfunctionScenarioPropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** List of imminent malfunctions. */
    private List<ImminentMalfunctionWSModel> mElements = new ArrayList<>();

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Provides list of imminent malfunctions.
     *
     * @return List of imminent malfunction models.
     */
    public List<ImminentMalfunctionWSModel> getElements() {
        return mElements;
    }

    /**
     * Sets list of imminent malfunctions.
     *
     * @param elements List of imminent malfunction models.
     */
    @ApiModelProperty(value = "Array of imminent malfunctions", position = 5)
    public void setElements(List<ImminentMalfunctionWSModel> elements) {
        mElements = elements;
    }
}