////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 16.01.2020.
//
// Copyright (c) 2006 - 2020 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.specificsettings.response;

import com.forcam.na.ffwebservices.model.AbstractResponse;
import com.forcam.na.ffwebservices.model.specificsettings.CustomerSpecificSettingPropertiesWSModel;

/**
 * A response model for customer specific setting.
 */
public class CustomerSpecificSettingResponse extends AbstractResponse {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private CustomerSpecificSettingPropertiesWSModel mProperties;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public void setProperties(CustomerSpecificSettingPropertiesWSModel properties) {
        mProperties = properties;
    }

    public CustomerSpecificSettingPropertiesWSModel getProperties() {
        return mProperties;
    }

}
