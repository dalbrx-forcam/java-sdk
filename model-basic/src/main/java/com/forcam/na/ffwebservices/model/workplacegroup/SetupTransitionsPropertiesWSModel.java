////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 28.11.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.workplacegroup;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Properties for setup transitions.
 */
@ApiModel(value = "setupTransitionsProperties")
@JsonPropertyOrder({ "creationDate", "elements" })
public class SetupTransitionsPropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The creation date. */
    private Date mCreationDate;

    /** List of setup matrix entries. */
    private List<SetupMatrixEntryWSModel> mElements = new ArrayList<>();

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public Date getCreationDate() {
        return mCreationDate;
    }

    @ApiModelProperty(value = "Creation timestamp of the setup matrix", position = 0)
    public void setCreationDate(Date creationDate) {
        mCreationDate = creationDate;
    }

    public List<SetupMatrixEntryWSModel> getElements() {
        return mElements;
    }

    @ApiModelProperty(value = "Array of setup matrix entries", position = 1)
    public void setElements(List<SetupMatrixEntryWSModel> elements) {
        mElements = elements;
    }
}