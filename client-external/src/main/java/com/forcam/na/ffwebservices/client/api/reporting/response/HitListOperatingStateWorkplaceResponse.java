////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 04.12.2019.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.reporting.response;

import com.forcam.na.ffwebservices.model.AbstractResponse;
import com.forcam.na.ffwebservices.model.reporting.HitListOperatingStateWorkplacePropertiesWSModel;

/**
 * The hit list operating state (workplace) report response.
 */
public class HitListOperatingStateWorkplaceResponse extends AbstractResponse {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private HitListOperatingStateWorkplacePropertiesWSModel mProperties;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public HitListOperatingStateWorkplacePropertiesWSModel getProperties() {
        return mProperties;
    }

    public void setProperties(HitListOperatingStateWorkplacePropertiesWSModel properties) {
        mProperties = properties;
    }
}
