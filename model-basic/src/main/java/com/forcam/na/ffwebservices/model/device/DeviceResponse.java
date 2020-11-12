////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 13.08.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.device;

import com.forcam.na.ffwebservices.model.AbstractResponse;
import com.forcam.na.ffwebservices.model.LinkEmbeddedWSModel;
import com.forcam.na.ffwebservices.model.literal.LiteralPropertiesWSModel;

/**
 * Device response model.
 */
public class DeviceResponse extends AbstractResponse {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The properties of the device. */
    private DevicePropertiesWSModel mProperties;

    /** The embedded description. */
    private LinkEmbeddedWSModel<LiteralPropertiesWSModel> mDescription;

    /** The embedded location. */
    private LinkEmbeddedWSModel<DeviceLocationPropertiesWSModel> mLocation;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Provides the device properties.
     *
     * @return The device properties WS model.
     */
    public DevicePropertiesWSModel getProperties() {
        return mProperties;
    }

    /**
     * Sets the device properties.
     *
     * @param properties The device properties WS model.
     */
    public void setProperties(DevicePropertiesWSModel properties) {
        mProperties = properties;
    }

    /**
     * The embedded description.
     *
     * @return The embedded description.
     */
    public LinkEmbeddedWSModel<LiteralPropertiesWSModel> getDescription() {
        return mDescription;
    }

    /**
     * Sets the embedded description.
     *
     * @param description The embedded description.
     */
    public void setDescription(LinkEmbeddedWSModel<LiteralPropertiesWSModel> description) {
        mDescription = description;
    }

    public LinkEmbeddedWSModel<DeviceLocationPropertiesWSModel> getLocation() {
        return mLocation;
    }

    public void setLocation(LinkEmbeddedWSModel<DeviceLocationPropertiesWSModel> location) {
        mLocation = location;
    }
}
