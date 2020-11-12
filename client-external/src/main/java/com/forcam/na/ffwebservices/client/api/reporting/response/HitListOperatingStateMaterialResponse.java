////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 04.12.2019.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.reporting.response;

import com.forcam.na.ffwebservices.model.AbstractResponse;
import com.forcam.na.ffwebservices.model.reporting.HitListOperatingStateMaterialPropertiesWSModel;

/**
 * The hit list operating state (material) report response.
 */
public class HitListOperatingStateMaterialResponse extends AbstractResponse {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private HitListOperatingStateMaterialPropertiesWSModel mProperties;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public HitListOperatingStateMaterialPropertiesWSModel getProperties() {
        return mProperties;
    }

    public void setProperties(HitListOperatingStateMaterialPropertiesWSModel properties) {
        mProperties = properties;
    }
}
