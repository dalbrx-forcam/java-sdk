////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 19.02.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.tool;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * The tool characteristic collection properties.
 */
@ApiModel("toolCharacteristicCollectionProperties")
@JsonPropertyOrder({ "elements" })
public class ToolCharacteristicCollectionPropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The characteristic elements. */
    private List<CharacteristicGeneralDefinition> mElements = new ArrayList<>();

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    @ApiModelProperty(value = "Array of tool characteristics", position = 0)
    public void setElements(List<CharacteristicGeneralDefinition> elements) {
        mElements = elements;
    }

    public List<CharacteristicGeneralDefinition> getElements() {
        return mElements;
    }
}