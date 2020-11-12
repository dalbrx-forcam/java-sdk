////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 28.11.2019.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.reporting;

import io.swagger.annotations.ApiModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Webservice model for the properties of the quantity log.
 */
@ApiModel("totalQuantityProperties")
public class TotalQuantityPropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private List<TotalQuantityEntry> mElements = new ArrayList<>();

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public List<TotalQuantityEntry> getElements() {
        return mElements;
    }

    public void setElements(List<TotalQuantityEntry> elements) {
        mElements = elements;
    }

}
