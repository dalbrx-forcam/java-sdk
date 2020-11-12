////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 02.10.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.shift;

import com.forcam.na.ffwebservices.model.AbstractResponse;
import com.forcam.na.ffwebservices.model.LinkEmbeddedWSModel;
import com.forcam.na.ffwebservices.model.shifttype.ShiftTypePropertiesWSModel;
import com.forcam.na.ffwebservices.model.workplace.WorkplacePropertiesWSModel;

/**
 * A model for shifts.
 */
public class WorkplaceShiftResponse extends AbstractResponse {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The properties of the shift. */
    private WorkplaceShiftPropertiesWSModel mProperties;

    /** The embedded workplace. */
    private LinkEmbeddedWSModel<WorkplacePropertiesWSModel> mWorkplace;

    /** The embedded shift type. */
    private LinkEmbeddedWSModel<ShiftTypePropertiesWSModel> mShiftType;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public WorkplaceShiftPropertiesWSModel getProperties() {
        return mProperties;
    }

    public void setProperties(WorkplaceShiftPropertiesWSModel properties) {
        mProperties = properties;
    }

    public LinkEmbeddedWSModel<WorkplacePropertiesWSModel> getWorkplace() {
        return mWorkplace;
    }

    public void setWorkplace(LinkEmbeddedWSModel<WorkplacePropertiesWSModel> workplace) {
        mWorkplace = workplace;
    }

    public LinkEmbeddedWSModel<ShiftTypePropertiesWSModel> getShiftType() {
        return mShiftType;
    }

    public void setShiftType(LinkEmbeddedWSModel<ShiftTypePropertiesWSModel> shiftType) {
        mShiftType = shiftType;
    }
}