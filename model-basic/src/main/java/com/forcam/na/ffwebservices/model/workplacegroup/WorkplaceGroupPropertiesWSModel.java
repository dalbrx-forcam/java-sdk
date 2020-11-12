////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 16.02.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.workplacegroup;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Contains the properties of a workplace group.
 */
@XmlRootElement(name = "workplaceGroupProperties")
@ApiModel(value = "workplaceGroupProperties")
@JsonPropertyOrder({ "id", "number", "description", "type", "erpContextId" })
public class WorkplaceGroupPropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The ID of the workplace group. */
    private String mId;

    /** The name of the workplace group. */
    private String mNumber;

    /** The description of the workplace group. */
    private String mDescription;

    /** The type of the workplace group. */
    private WorkplaceGroupType mType;

    /** The ERP context ID of the workplace group. */
    private String mErpContextId;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    @ApiModelProperty(value = "UUID of the workplace group", required = true, position = 0)
    public void setId(String id) {
        mId = id;
    }

    public String getId() {
        return mId;
    }

    @ApiModelProperty(value = "The workplace group number which is unique in its ERP context", position = 1)
    public void setNumber(String number) {
        mNumber = number;
    }

    public String getNumber() {
        return mNumber;
    }

    @ApiModelProperty(value = "A description of the workplace group", position = 2)
    public void setDescription(String description) {
        mDescription = description;
    }

    public String getDescription() {
        return mDescription;
    }

    @ApiModelProperty(value = "Type of the workplace group, either “CAPACITY_GROUP” or “PRODUCTION_LINE”", position = 3)
    public void setType(WorkplaceGroupType type) {
        mType = type;
    }

    public WorkplaceGroupType getType() {
        return mType;
    }

    @ApiModelProperty(value = "Universally unique identifier of the ERP context in which the workplace number is a unique identifier for a workplace or a workplace group. In SAP ERP, for example, this context is defined by the client, the company code, and the plant", position = 4)
    public void setErpContextId(String erpContextId) {
        mErpContextId = erpContextId;
    }

    public String getErpContextId() {
        return mErpContextId;
    }
}