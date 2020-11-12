////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 19.02.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.recordedoperatingstate;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * The recorded operating state properties model.
 */
@ApiModel("recordedOperatingStatesPropertiesModel")
@JsonPropertyOrder({ "elements" })
public class OperatingStateRecordCollectionPropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The operating state records. */
    private List<OperatingStateRecordWSModel> mElements = new ArrayList<>();

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    @ApiModelProperty(value = "Array of operating state records", position = 0)
    public void setElements(List<OperatingStateRecordWSModel> elements) {
        mElements = elements;
    }

    public List<OperatingStateRecordWSModel> getElements() {
        return mElements;
    }
}