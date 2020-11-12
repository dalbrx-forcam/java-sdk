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

import java.util.ArrayList;
import java.util.List;

/**
 * Device recorded time series collection properties model.
 */
@ApiModel(value = "deviceRecordedTimeSeriesCollectionProperties")
@JsonPropertyOrder({ "tag, unitName, unitSymbol, elements" })
public class DeviceRecordedTimeSeriesCollectionPropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The tag for the measured variable or process parameter. */
    private Long mTag;

    /** Unit name. */
    private String mUnitName;

    /** Unit symbol. */
    private String mUnitSymbol;

    /** List of time series WS models. */
    private List<TimeSeriesWSModel> mElements = new ArrayList<>();

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Sets the tag.
     *
     * @param tag The tag.
     */
    @ApiModelProperty(value = "The tag for the measured variable or process parameter", position = 0)
    public void setTag(Long tag) {
        mTag = tag;
    }

    /**
     * Provides the tag.
     *
     * @return The tag.
     */
    public Long getTag() {
        return mTag;
    }

    /**
     * Get unit name.
     *
     * @return Unit name.
     */
    public String getUnitName() {
        return mUnitName;
    }

    /**
     * Set unit name.
     *
     * @param unitName Unit name.
     */
    @ApiModelProperty(value = "The unit name for the measured variable or process parameter", position = 1)
    public void setUnitName(String unitName) {
        mUnitName = unitName;
    }

    /**
     * Get unit symbol.
     *
     * @return Unit symbol.
     */
    public String getUnitSymbol() {
        return mUnitSymbol;
    }

    /**
     * Set unit symbol.
     *
     * @param unitSymbol Unit symbol.
     */
    @ApiModelProperty(value = "The unit symbol for the measured variable or process parameter", position = 2)
    public void setUnitSymbol(String unitSymbol) {
        mUnitSymbol = unitSymbol;
    }

    /**
     * Provides the list of time series.
     *
     * @param elements List of time series WS models.
     */
    @ApiModelProperty(value = "Array of time series elements", position = 3)
    public void setElements(List<TimeSeriesWSModel> elements) {
        mElements = elements;
    }

    /**
     * Sets the list of time series.
     *
     * @return List of time series WS models.
     */
    public List<TimeSeriesWSModel> getElements() {
        return mElements;
    }

}