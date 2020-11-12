////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 05.12.2019.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.reporting.response;

import com.forcam.na.ffwebservices.model.AbstractResponse;
import com.forcam.na.ffwebservices.model.reporting.TotalQuantityPropertiesWSModel;

/**
 * The quantity log report response.
 */
public class TotalQuantityResponse extends AbstractResponse {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private TotalQuantityPropertiesWSModel mProperties;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public TotalQuantityPropertiesWSModel getProperties() {
        return mProperties;
    }

    public void setProperties(TotalQuantityPropertiesWSModel properties) {
        mProperties = properties;
    }

}
