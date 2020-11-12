////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 02.11.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.statusdefinition;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Properties WS model for operating state.
 */
@ApiModel(value = "operatingStateProperties")
@JsonPropertyOrder({ "id", "description", "shortDescription", "code", "color", "isRecodable", "isSplittable", "isAnnotatable", "customerCode",
                     "workplaceStateId", "operatingStateClassId" })
public class OperatingStatePropertiesWSModel extends CreateOperatingStatePropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private String mId;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    @ApiModelProperty(value = "UUID of the operating state", required = true, position = 0)
    public void setId(String id) {
        mId = id;
    }

    public String getId() {
        return mId;
    }
}