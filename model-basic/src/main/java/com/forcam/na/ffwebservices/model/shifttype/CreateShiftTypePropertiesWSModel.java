////////////////////////////////////////////////////////////////////////////////
//
// Created by hiteshgarg on 8/1/2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.shifttype;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * WS model to create a shift type.
 */
@XmlRootElement(name = "createShiftTypeProperties")
@ApiModel(value = "createShiftTypeProperties")
@JsonPropertyOrder({ "description", "shortDescription", "isWorkingShift" })
public class CreateShiftTypePropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Shift type long description. */
    private String mDescription;
    /** Shift type abbreviation. */
    private String mShortDescription;
    /** Is shift type working. */
    private boolean mIsWorkingShift;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Setter for {@link CreateShiftTypePropertiesWSModel#mDescription}.
     *
     * @param shiftTypeDescription Shift type description.
     */
    @ApiModelProperty(value = "Description of the shift type", required = false, position = 1)
    public void setDescription(String shiftTypeDescription) {
        mDescription = shiftTypeDescription;
    }

    /**
     * Getter for {@link CreateShiftTypePropertiesWSModel#mDescription}.
     *
     * @return Shift type description.
     */
    public String getDescription() {
        return mDescription;
    }

    @ApiModelProperty(value = "Short description of the shift type", required = false, position = 2)
    public void setShortDescription(String shortDescription) {
        mShortDescription = shortDescription;
    }

    public String getShortDescription() {
        return mShortDescription;
    }

    /**
     * Setter for {@link CreateShiftTypePropertiesWSModel#mIsWorkingShift}.
     *
     * @param isWorkingShift {@code true} if shift is working, {@code false} otherwise.
     */
    @ApiModelProperty(value = "Boolean to indicate the shift type as working shift or nonworking shift", required = true, position = 3)
    public void setIsWorkingShift(boolean isWorkingShift) {
        mIsWorkingShift = isWorkingShift;
    }

    /**
     * Getter for {@link CreateShiftTypePropertiesWSModel#mIsWorkingShift}.
     *
     * @return {@code true} if shift is working, {@code false} otherwise.
     */
    public boolean isIsWorkingShift() {
        return mIsWorkingShift;
    }
}