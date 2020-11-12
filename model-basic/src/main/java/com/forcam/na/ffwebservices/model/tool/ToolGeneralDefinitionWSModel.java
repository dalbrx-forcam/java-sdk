////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 23.11.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.tool;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 *
 */
@ApiModel(value = "toolGeneralDefinition")
@JsonPropertyOrder({ "id", "name", "description" })
public class ToolGeneralDefinitionWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The tool uuid */
    private String mId;

    /** Tool number / name */
    private String mName;

    /** Tool description */
    private String mDescription;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    @ApiModelProperty(value = "UUID of the tool", required = true, position = 0)
    public void setId(String id) {
        mId = id;
    }

    public String getId() {
        return mId;
    }

    @ApiModelProperty(value = "Name of the tool", position = 1)
    public void setName(String name) {
        mName = name;
    }

    public String getName() {
        return mName;
    }

    @ApiModelProperty(value = "A description of the tool", required = false, position = 2)
    public void setDescription(String description) {
        mDescription = description;
    }

    public String getDescription() {
        return mDescription;
    }

}
