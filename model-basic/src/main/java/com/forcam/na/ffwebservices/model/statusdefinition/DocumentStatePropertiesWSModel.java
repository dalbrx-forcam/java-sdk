////////////////////////////////////////////////////////////////////////////////
//
// Created by DZeise on 09.03.2020.
//
// Copyright (c) 2006 - 2020 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.statusdefinition;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "documentStateProperties")
@JsonPropertyOrder({ "id", "description", "code", "color" })
public class DocumentStatePropertiesWSModel extends CreateDocumentStatePropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private String mId;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    @ApiModelProperty(value = "UUID of the document state", required = true)
    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }
}
