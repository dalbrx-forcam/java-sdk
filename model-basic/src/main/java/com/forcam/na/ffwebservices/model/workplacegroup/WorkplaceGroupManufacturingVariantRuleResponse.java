////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 12.12.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.workplacegroup;

import com.forcam.na.ffwebservices.model.AbstractResponse;

/**
 * Response model for a manufacturing variant rule of a workplace group.
 */
public class WorkplaceGroupManufacturingVariantRuleResponse extends AbstractResponse {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The manufacturing variant rule properties. */
    private WorkplaceGroupManufacturingVariantRulePropertiesWSModel mProperties = new WorkplaceGroupManufacturingVariantRulePropertiesWSModel();

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Provides the manufacturing variant rule properties.
     *
     * @return The manufacturing variant rule properties.
     */
    public WorkplaceGroupManufacturingVariantRulePropertiesWSModel getProperties() {
        return mProperties;
    }

    /**
     * Sets the manufacturing variant rule properties.
     *
     * @param properties The manufacturing variant rule properties.
     */
    public void setProperties(WorkplaceGroupManufacturingVariantRulePropertiesWSModel properties) {
        mProperties = properties;
    }
}