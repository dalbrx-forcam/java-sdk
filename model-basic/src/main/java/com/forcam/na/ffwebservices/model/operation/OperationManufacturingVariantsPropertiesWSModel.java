////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 14.05.2018.
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
 * Operation manufacturing variants properties webservice model.
 */
@XmlRootElement(name = "operationManufacturingVariantsProperties")
@ApiModel(value = "operationManufacturingVariantsProperties")
@JsonPropertyOrder({ "elements" })
public class OperationManufacturingVariantsPropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private List<OperationManufacturingVariantElementWSModel> mElements = new ArrayList<>();

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    public List<OperationManufacturingVariantElementWSModel> getElements() {
        return mElements;
    }

    @ApiModelProperty(value = "Array of manufacturing variants")
    public void setElements(List<OperationManufacturingVariantElementWSModel> elements) {
        mElements = elements;
    }

}