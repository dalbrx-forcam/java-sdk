////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 28.11.2019.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.reporting.response;

import com.forcam.na.ffwebservices.model.AbstractResponse;
import com.forcam.na.ffwebservices.model.reporting.OverallEquipmentEfficiencyPropertiesWSModel;

/**
 * The overall equipment efficiency report response.
 */
public class OverallEquipmentEfficiencyResponse extends AbstractResponse {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private OverallEquipmentEfficiencyPropertiesWSModel mProperties;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public void setProperties(OverallEquipmentEfficiencyPropertiesWSModel properties) {
        mProperties = properties;
    }

    public OverallEquipmentEfficiencyPropertiesWSModel getProperties() {
        return mProperties;
    }

}
