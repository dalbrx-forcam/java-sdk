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
 * Creates properties of production resources and tools.
 */
@XmlRootElement(name = "createProductionResourceToolProperties")
@ApiModel(value = "createProductionResourceToolProperties")
@JsonPropertyOrder({ "itemNumber", "type", "group", "number", "description", "quantity", "quantityUnit" })
public class CreateProductionResourceToolPropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The item number. */
    private String mItemNumber;

    /** The type. */
    private String mType;

    /** The group. */
    private String mGroup;

    /** The number. */
    private String mNumber;

    /** The description. */
    private String mDescription;

    /** The quantity. */
    private Double mQuantity;

    /** The quantity unit. */
    private String mQuantityUnit;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    @ApiModelProperty(value = "Item number assigned to a production resource in the context of the operation", position = 0)
    public void setItemNumber(String itemNumber) {
        mItemNumber = itemNumber;
    }

    public String getItemNumber() {
        return mItemNumber;
    }

    @ApiModelProperty(value = "The type of a production resource which is either 'MATERIAL', 'EQUIPMENT', 'DOCUMENT' or 'OTHER_ASSETS'", position = 1)
    public void setType(String type) {
        mType = type;
    }

    public String getType() {
        return mType;
    }

    @ApiModelProperty(value = "Production resource and tool group", position = 2)
    public void setGroup(String group) {
        mGroup = group;
    }

    public String getGroup() {
        return mGroup;
    }

    @ApiModelProperty(value = "Number of the production resource (material number, equipment number or document number) which is unique within its ERP context", position = 3)
    public void setNumber(String number) {
        mNumber = number;
    }

    public String getNumber() {
        return mNumber;
    }

    @ApiModelProperty(value = "Description of the production resource", position = 4)
    public void setDescription(String description) {
        mDescription = description;
    }

    public String getDescription() {
        return mDescription;
    }

    @ApiModelProperty(value = "Required quantity of the production resource", position = 5)
    public void setQuantity(Double quantity) {
        mQuantity = quantity;
    }

    public Double getQuantity() {
        return mQuantity;
    }

    @ApiModelProperty(value = "Unit of the required quantity ", position = 6)
    public void setQuantityUnit(String quantityUnit) {
        mQuantityUnit = quantityUnit;
    }

    public String getQuantityUnit() {
        return mQuantityUnit;
    }
}