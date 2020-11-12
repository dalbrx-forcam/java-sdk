////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 26.09.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.workplace;

import com.forcam.na.ffwebservices.model.AbstractResponse;
import io.swagger.annotations.ApiModelProperty;

/**
 * Response model for embedded predicted malfunction scenario.
 */
public class EmbeddedPredictedMalfunctionScenarioResponse extends AbstractResponse {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The properties of the embedded predicted malfunction scenario. */
    private EmbeddedPredictedMalfunctionScenarioPropertiesWSModel mProperties;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Getter for properties of the embedded predicted malfunction scenario.
     *
     * @return Embedded predicted malfunction scenario properties model.
     */
    public EmbeddedPredictedMalfunctionScenarioPropertiesWSModel getProperties() {
        return mProperties;
    }

    /**
     * Setter for properties of the embedded predicted malfunction scenario.
     *
     * @param properties Embedded predicted malfunction scenario properties model.
     */
    @ApiModelProperty(value = "Properties of the predicted malfunction scenario")
    public void setProperties(EmbeddedPredictedMalfunctionScenarioPropertiesWSModel properties) {
        mProperties = properties;
    }
}