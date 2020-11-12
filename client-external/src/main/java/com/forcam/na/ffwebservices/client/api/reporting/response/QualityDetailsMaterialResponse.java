////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 10.12.2019.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.reporting.response;

import com.forcam.na.ffwebservices.model.AbstractResponse;
import com.forcam.na.ffwebservices.model.reporting.QualityDetailsMaterialPropertiesWSModel;

/**
 * The quality details workplace report response.
 */
public class QualityDetailsMaterialResponse extends AbstractResponse {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private QualityDetailsMaterialPropertiesWSModel properties = new QualityDetailsMaterialPropertiesWSModel();

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public QualityDetailsMaterialPropertiesWSModel getProperties() {
        return properties;
    }

    public void setProperties(QualityDetailsMaterialPropertiesWSModel properties) {
        this.properties = properties;
    }

}
