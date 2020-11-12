////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 19.02.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.recordedoutputquantities;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Operation recorded output quantities collection properties model.
 */
@ApiModel("recordedOperationOutputQuantitiesProperties")
@JsonPropertyOrder({ "elements" })
public class RecordedOutputQuantitiesCollectionPropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The recorded output quantities. */
    private List<RecordedOutputQuantitiesWSModel> mElements = new ArrayList<>();

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public List<RecordedOutputQuantitiesWSModel> getElements() {
        return mElements;
    }

    @ApiModelProperty(value = "Array or recorded output quantities", position = 0)
    public void setElements(List<RecordedOutputQuantitiesWSModel> elements) {
        mElements = elements;
    }
}