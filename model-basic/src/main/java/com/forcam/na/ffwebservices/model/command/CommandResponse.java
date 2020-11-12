////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 14.09.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.command;

/**
 * A default command model containing properties.
 */
public class CommandResponse<T extends AbstractCommandDataWSModel> {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** A model containing command properties. */
    private CommandPropertiesWSModel<T> mProperties;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public CommandPropertiesWSModel<T> getProperties() {
        return mProperties;
    }

    public void setProperties(CommandPropertiesWSModel<T> properties) {
        this.mProperties = properties;
    }
}