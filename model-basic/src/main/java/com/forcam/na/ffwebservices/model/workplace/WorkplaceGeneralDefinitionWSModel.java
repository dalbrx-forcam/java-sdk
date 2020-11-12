////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 20.11.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.workplace;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The general definition model for a workplace.
 */
@ApiModel(value = "workplaceGeneralDefinition")
public class WorkplaceGeneralDefinitionWSModel {
    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The workplace id */
    private String mId;

    /** The workplace number (name) */
    private String mNumber;

    /** The workplace description */
    private String mDescription;

    /** The workplace erp context */
    private String mErpContextId;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public String getId() {
        return mId;
    }

    @ApiModelProperty(value = "UUID of the workplace", required = true, position = 0)
    public void setId(String id) {
        mId = id;
    }

    public String getNumber() {
        return mNumber;
    }

    @ApiModelProperty(value = "The workplace number which is unique in its ERP context", position = 1)
    public void setNumber(String number) {
        mNumber = number;
    }

    public String getDescription() {
        return mDescription;
    }

    @ApiModelProperty(value = "A description of the workplace", position = 2)
    public void setDescription(String description) {
        mDescription = description;
    }

    public String getErpContextId() {
        return mErpContextId;
    }

    @ApiModelProperty(value = "UUID of the ERP context in which the workplace number is a unique identifier for a workplace or a workplace group. In SAP ERP, for example, this context is defined by the client, the company code, and the plant", position = 3)
    public void setErpContextId(String erpContextId) {
        mErpContextId = erpContextId;
    }

}
