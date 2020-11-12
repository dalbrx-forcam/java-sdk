////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 06.02.2020.
//
// Copyright (c) 2006 - 2020 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.material.response;

import com.forcam.na.ffwebservices.model.AbstractResponse;
import com.forcam.na.ffwebservices.model.material.MaterialPropertiesWSModel;

/**
 * The material response.
 */
public class MaterialResponse extends AbstractResponse {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private MaterialPropertiesWSModel mProperties;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public void setProperties(MaterialPropertiesWSModel properties) {
        mProperties = properties;
    }

    public MaterialPropertiesWSModel getProperties() {
        return mProperties;
    }

}
