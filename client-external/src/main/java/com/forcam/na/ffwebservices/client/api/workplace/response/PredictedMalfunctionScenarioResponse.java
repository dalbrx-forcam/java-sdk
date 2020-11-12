////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 26.09.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.workplace.response;

import com.forcam.na.ffwebservices.client.api.pagination.response.AbstractCollectionResponse;
import com.forcam.na.ffwebservices.client.api.pagination.request.PaginationRequest;
import com.forcam.na.ffwebservices.model.workplace.ImminentMalfunctionWSModel;
import com.forcam.na.ffwebservices.model.workplace.WorkplacePredictedMalfunctionScenarioPropertiesWSModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Predicted malfunction scenario response.
 */
public class PredictedMalfunctionScenarioResponse extends AbstractCollectionResponse<ImminentMalfunctionWSModel> {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The predicted malfunction scenario properties. */
    private WorkplacePredictedMalfunctionScenarioPropertiesWSModel mProperties = new WorkplacePredictedMalfunctionScenarioPropertiesWSModel();

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     *
     * @param request The request.
     */
    public PredictedMalfunctionScenarioResponse(PaginationRequest request) {
        super(request);
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public List<ImminentMalfunctionWSModel> getElements() {
        return mProperties.getElements();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Provides the workplace predicted malfunction scenario properties.
     *
     * @return The workplace predicted malfunction scenario properties model.
     */
    public WorkplacePredictedMalfunctionScenarioPropertiesWSModel getProperties() {
        return mProperties;
    }

    /**
     * Sets the workplace predicted malfunction scenario properties.
     *
     * @param properties The workplace predicted malfunction scenario properties model.
     */
    @ApiModelProperty(value = "The workplace predicted malfunction scenario properties")
    public void setProperties(WorkplacePredictedMalfunctionScenarioPropertiesWSModel properties) {
        mProperties = properties;
    }
}