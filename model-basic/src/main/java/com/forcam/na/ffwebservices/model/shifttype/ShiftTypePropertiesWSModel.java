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
 * Properties WS model for shift type.
 */
@XmlRootElement(name = "shiftTypeProperties")
@ApiModel(value = "shiftTypeProperties")
@JsonPropertyOrder({ "id", "description", "shortDescription", "isWorkingShift" })
public class ShiftTypePropertiesWSModel extends CreateShiftTypePropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Shift type id. */
    private String mId;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Setter for {@link ShiftTypePropertiesWSModel#mId}.
     *
     * @param id Shift type uuid.
     */
    @ApiModelProperty(value = "The UUID of the shift type", required = true, position = 0)
    public void setId(String id) {
        mId = id;
    }

    /**
     * Getter for {@link ShiftTypePropertiesWSModel#mId}.
     *
     * @return Shift type uuid.
     */
    public String getId() {
        return mId;
    }
}
