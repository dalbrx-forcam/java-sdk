////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 13.08.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.device;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModelProperty;

/**
 * Recorded physical quantities model.
 */
@JsonPropertyOrder({ "tag", "name", "physicalQuantity", "unit" })
public class RecordedPhysicalQuantitiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** A short tag for the measured variable or process parameter (e. g. 242, P1,P2, T2), which is used to identify it within the record-ed time series. */
    private String mTag;

    /** The name of the measured variable or process parameter. */
    private String mName;

    /** The physical quantity that is measured (e. g. Frequenz). */
    private String mPhysicalQuantity;

    /** The physical unit of the measured variable or process parame-ter (e. g. Hertz). */
    private String mUnit;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Sets the tag.
     *
     * @param tag The tag.
     */
    @ApiModelProperty(value = "A short tag for the measured variable or process parameter (e.g. 242, P1, P2, T2)", notes = "Used to identify it within the recorded time series", position = 0)
    public void setTag(String tag) {
        mTag = tag;
    }

    /**
     * Provides the tag.
     *
     * @return The tag.
     */
    public String getTag() {
        return mTag;
    }

    /**
     * Sets the name.
     *
     * @param name The name.
     */
    @ApiModelProperty(value = "The name of the measured variable or process parameter (e.g. front spindle speed)", position = 1)
    public void setName(String name) {
        mName = name;
    }

    /**
     * Provides the name.
     *
     * @return The name.
     */
    public String getName() {
        return mName;
    }

    /**
     * Sets the physical quantity.
     *
     * @param physicalQuantity The physical quantity.
     */
    @ApiModelProperty(value = "The physical quantity that is measured", example = "Frequency", position = 2)
    public void setPhysicalQuantity(String physicalQuantity) {
        mPhysicalQuantity = physicalQuantity;
    }

    /**
     * Provides the physical quantity.
     *
     * @return The physical quantity.
     */
    public String getPhysicalQuantity() {
        return mPhysicalQuantity;
    }

    /**
     * Sets the unit.
     *
     * @param unit The unit.
     */
    @ApiModelProperty(value = "The physical unit of the measured variable or process parameter", example = "Herz", position = 3)
    public void setUnit(String unit) {
        mUnit = unit;
    }

    /**
     * Provides the unit.
     *
     * @return The unit.
     */
    public String getUnit() {
        return mUnit;
    }
}