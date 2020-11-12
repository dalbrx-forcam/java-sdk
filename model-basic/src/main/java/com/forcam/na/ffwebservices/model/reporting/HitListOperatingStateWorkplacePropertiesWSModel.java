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
 * Webservice model for the properties of the hit list operating state workplace.
 */
@ApiModel("hitListOperatingStateWorkplaceProperties")
public class HitListOperatingStateWorkplacePropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private List<HitListOperatingStateWorkplaceEntry> mElements = new ArrayList<>();

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public List<HitListOperatingStateWorkplaceEntry> getElements() {
        return mElements;
    }

    public void setElements(List<HitListOperatingStateWorkplaceEntry> elements) {
        mElements = elements;
    }

}
