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
 * Webservice model for the properties of the hit list operating state material report.
 */
@ApiModel("hitListOperatingStateMaterialProperties")
public class HitListOperatingStateMaterialPropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private List<HitListOperatingStateMaterialEntry> mElements = new ArrayList<>();

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public List<HitListOperatingStateMaterialEntry> getElements() {
        return mElements;
    }

    public void setElements(List<HitListOperatingStateMaterialEntry> elements) {
        mElements = elements;
    }

}
