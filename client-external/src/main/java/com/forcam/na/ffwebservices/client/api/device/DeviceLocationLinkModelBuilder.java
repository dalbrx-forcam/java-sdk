////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 05.12.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.device;

import com.forcam.na.ffwebservices.client.api.AbstractLinkModelBuilder;
import com.forcam.na.ffwebservices.model.device.DeviceLocationPropertiesWSModel;

import javax.inject.Inject;

/**
 * Link model builder for device locations.
 */
public class DeviceLocationLinkModelBuilder extends AbstractLinkModelBuilder<DeviceLocationPropertiesWSModel> {

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Constructor for link model builder.
     */
    @Inject
    public DeviceLocationLinkModelBuilder() {
        super(DeviceLocationPropertiesWSModel.class);
    }
}
