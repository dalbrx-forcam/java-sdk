////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 13.11.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.pdm;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Contains the common properties of a file repository folder used when creating or retrieving a folder.
 */
@ApiModel(value = "commonFileRepositoryFolderProperties")
@JsonPropertyOrder({ "name", "creator" })
public class CommonFileRepositoryFolderWSProperties {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The name of the folder. */
    private String mName;



    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    @ApiModelProperty(value = "Name of the folder", position = 1)
    public void setName(String name) {
        mName = name;
    }

    public String getName() {
        return mName;
    }

}
