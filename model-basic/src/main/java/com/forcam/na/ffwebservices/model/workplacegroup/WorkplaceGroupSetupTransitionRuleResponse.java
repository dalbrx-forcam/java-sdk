////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 28.11.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.workplacegroup;

import com.forcam.na.ffwebservices.model.AbstractResponse;

/**
 * Response model for a workplace group setup transition rule.
 */
public class WorkplaceGroupSetupTransitionRuleResponse extends AbstractResponse {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The setup transition rule properties. */
    private SetupTransitionRulePropertiesWSModel mProperties = new SetupTransitionRulePropertiesWSModel();

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public SetupTransitionRulePropertiesWSModel getProperties() {
        return mProperties;
    }

    public void setProperties(SetupTransitionRulePropertiesWSModel properties) {
        mProperties = properties;
    }
}