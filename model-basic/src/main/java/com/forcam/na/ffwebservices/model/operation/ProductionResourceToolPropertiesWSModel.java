////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 24.11.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.operation;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Contains the properties of production resources and tools.
 */
@XmlRootElement(name = "productionResourceToolProperties")
@ApiModel(value = "productionResourceToolProperties")
@JsonPropertyOrder({ "id", "itemNumber", "type", "group", "number", "description", "quantity", "quantityUnit" })
public class ProductionResourceToolPropertiesWSModel extends CreateProductionResourceToolPropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private String mId;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public String getId() {
        return mId;
    }

    @ApiModelProperty(value = "UUID of the production tool resource", required = true)
    public void setId(String id) {
        mId = id;
    }
}