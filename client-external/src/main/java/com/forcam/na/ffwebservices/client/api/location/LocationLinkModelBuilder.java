////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 05.12.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.location;

import com.forcam.na.ffwebservices.client.api.AbstractLinkModelBuilder;
import com.forcam.na.ffwebservices.model.location.LocationPropertiesWSModel;

import javax.inject.Inject;

/**
 * Link model builder for locations.
 */
public class LocationLinkModelBuilder extends AbstractLinkModelBuilder<LocationPropertiesWSModel> {

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Constructor for link model builder.
     */
    @Inject
    public LocationLinkModelBuilder() {
        super(LocationPropertiesWSModel.class);
    }
}
