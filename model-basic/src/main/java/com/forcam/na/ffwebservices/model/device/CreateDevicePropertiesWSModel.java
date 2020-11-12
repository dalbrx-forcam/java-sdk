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
import java.util.ArrayList;
import java.util.List;

/**
 * Properties of device model.
 */
@XmlRootElement(name = "createDeviceProperties")
@ApiModel(value = "createDeviceProperties")
@JsonPropertyOrder({ "name", "description", "workplace", "recordedPhysicalQuantities" })
public class CreateDevicePropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The name of the device (e.g. S7 1212C DC), which could also be an abstract device (e.g. Welding 247). */
    private String mName;

    /** A description of the device (e.g. SIMATIC S7-1200, CPU 1212C, 24 V DC) , which could also be an abstract device (e.g. Welding 247). */
    private String mDescription;

    /** List of recorded physical quantities. */
    private List<RecordedPhysicalQuantitiesWSModel> mRecordedPhysicalQuantities = new ArrayList<>();

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Sets the device name.
     *
     * @param name The device name.
     */
    @ApiModelProperty(value = "The name of the device (e.g. S7 1212C DC), which could also be an abstract device (e.g. Welding 247)", position = 1)
    public void setName(String name) {
        mName = name;
    }

    /**
     * Provides device name.
     *
     * @return The device name.
     */
    public String getName() {
        return mName;
    }

    /**
     * Sets the description.
     *
     * @param description The description.
     */
    @ApiModelProperty(value = "A description of the device (e.g. SIMATIC S7-1200, CPU 1212C, 24 V DC), which could also be an abstract device (e.g. Welding 247)", position = 2)
    public void setDescription(String description) {
        mDescription = description;
    }

    /**
     * Provides the description.
     *
     * @return The description.
     */
    public String getDescription() {
        return mDescription;
    }

    /**
     * Sets list of recorded physical quantities.
     *
     * @param recordedPhysicalQuantities List of recorded physical quantities WS models.
     */
    @ApiModelProperty(value = "Array of recorded physical quantities", position = 4)
    public void setRecordedPhysicalQuantities(List<RecordedPhysicalQuantitiesWSModel> recordedPhysicalQuantities) {
        mRecordedPhysicalQuantities = recordedPhysicalQuantities;
    }

    /**
     * Provides the list of recorded physical quantities.
     *
     * @return List of recorded physical quantities WS models.
     */
    public List<RecordedPhysicalQuantitiesWSModel> getRecordedPhysicalQuantities() {
        return mRecordedPhysicalQuantities;
    }
}