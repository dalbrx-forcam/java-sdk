////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 28.11.2019.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.reporting.response;

import com.forcam.na.ffwebservices.model.AbstractResponse;
import com.forcam.na.ffwebservices.model.reporting.OverallProcessEfficiencyPropertiesWSModel;

/**
 * The overall process efficiency report response.
 */
public class OverallProcessEfficiencyResponse extends AbstractResponse {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private OverallProcessEfficiencyPropertiesWSModel mProperties;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public void setProperties(OverallProcessEfficiencyPropertiesWSModel properties) {
        mProperties = properties;
    }

    public OverallProcessEfficiencyPropertiesWSModel getProperties() {
        return mProperties;
    }

}
