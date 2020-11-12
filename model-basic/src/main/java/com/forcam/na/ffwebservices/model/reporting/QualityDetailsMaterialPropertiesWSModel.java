////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 09.12.2019.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.reporting;

import io.swagger.annotations.ApiModel;

import java.util.List;

/**
 * Webservice model for the properties of the quality details material report.
 */
@ApiModel("qualityDetailsMaterialProperties")
public class QualityDetailsMaterialPropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private List<QualityDetailsMaterialEntry> mElements;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public List<QualityDetailsMaterialEntry> getElements() {
        return mElements;
    }

    public void setElements(List<QualityDetailsMaterialEntry> elements) {
        mElements = elements;
    }

}
