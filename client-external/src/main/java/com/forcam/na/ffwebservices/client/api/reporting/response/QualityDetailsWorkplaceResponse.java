////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 10.12.2019.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.reporting.response;

import com.forcam.na.ffwebservices.model.AbstractResponse;
import com.forcam.na.ffwebservices.model.reporting.QualityDetailsWorkplacePropertiesWSModel;

/**
 * The quality details workplace report response.
 */
public class QualityDetailsWorkplaceResponse extends AbstractResponse {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private QualityDetailsWorkplacePropertiesWSModel properties = new QualityDetailsWorkplacePropertiesWSModel();

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public QualityDetailsWorkplacePropertiesWSModel getProperties() {
        return properties;
    }

    public void setProperties(QualityDetailsWorkplacePropertiesWSModel properties) {
        this.properties = properties;
    }

}
