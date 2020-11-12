////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 28.04.2020.
//
// Copyright (c) 2006 - 2020 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.pdm;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.forcam.na.common.webserviceaccess.util.ToStringUtility;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 *
 */
@ApiModel(value = "createFileRepositoryDocumentWithEditorProperties")
@JsonPropertyOrder({ "creator", "origin", "type" })
public class CreateFileRepositoryDocumentWithCreatorWSModelProperties extends CreateFileRepositoryDocumentWSModelProperties {
    
    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The originator of the document. */
    private String mCreator;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return ToStringUtility
            .newToStringBuilder(this)
            .append("mCreator", mCreator)
            .append(super.toString())
            .toString();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public String getCreator() {
        return mCreator;
    }

    @ApiModelProperty(value = "Person or application that created the document", position = 4)
    public void setCreator(String creator) {
        mCreator = creator;
    }

}
