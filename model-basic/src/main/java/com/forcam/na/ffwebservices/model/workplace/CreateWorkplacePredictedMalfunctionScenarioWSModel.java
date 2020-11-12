////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 25.09.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.workplace;

import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Model for creating a predicted malfunction scenario.
 */
public class CreateWorkplacePredictedMalfunctionScenarioWSModel extends CreatePredictedMalfunctionScenarioPropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** List of imminent malfunctions. */
    private List<ImminentMalfunctionWSModel> mElements = new ArrayList<>();

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public List<ImminentMalfunctionWSModel> getElements() {
        return mElements;
    }

    @ApiModelProperty(value = "Array of imminent malfunctions")
    public void setElements(List<ImminentMalfunctionWSModel> elements) {
        mElements = elements;
    }
}