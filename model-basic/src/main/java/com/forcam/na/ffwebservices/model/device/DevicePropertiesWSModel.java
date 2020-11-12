////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 13.08.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.device;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Device properties model.
 */
@XmlRootElement(name = "deviceProperties")
@ApiModel(value = "deviceProperties")
@JsonPropertyOrder({ "id", "name", "description", "workplace", "recordedPhysicalQuantities" })
public class DevicePropertiesWSModel extends CreateDevicePropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The device ID. */
    private String mId;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Sets the ID of the device.
     *
     * @param id The ID of the device.
     */
    @ApiModelProperty(value = "UUID of the device", required = true, position = 0)
    public void setId(String id) {
        mId = id;
    }

    /**
     * Provides the ID of the device.
     *
     * @return The ID of the device.
     */
    public String getId() {
        return mId;
    }
}