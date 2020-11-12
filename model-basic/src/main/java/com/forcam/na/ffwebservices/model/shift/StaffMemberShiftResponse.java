////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 22.10.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.shift;

import com.forcam.na.ffwebservices.model.AbstractResponse;
import com.forcam.na.ffwebservices.model.LinkEmbeddedWSModel;
import com.forcam.na.ffwebservices.model.shifttype.ShiftTypePropertiesWSModel;
import com.forcam.na.ffwebservices.model.staffmember.StaffMemberPropertiesWSModel;

/**
 * Response model for a staff member shift.
 */
public class StaffMemberShiftResponse extends AbstractResponse {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The properties of the staff member shift. */
    private StaffMemberShiftPropertiesWSModel mProperties;

    /** The embedded staff member. */
    private LinkEmbeddedWSModel<StaffMemberPropertiesWSModel> mStaffMember;

    /** The embedded shift type. */
    private LinkEmbeddedWSModel<ShiftTypePropertiesWSModel> mShiftType;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public StaffMemberShiftPropertiesWSModel getProperties() {
        return mProperties;
    }

    public void setProperties(StaffMemberShiftPropertiesWSModel properties) {
        mProperties = properties;
    }

    public LinkEmbeddedWSModel<StaffMemberPropertiesWSModel> getStaffMember() {
        return mStaffMember;
    }

    public void setStaffMember(LinkEmbeddedWSModel<StaffMemberPropertiesWSModel> staffMember) {
        mStaffMember = staffMember;
    }

    public LinkEmbeddedWSModel<ShiftTypePropertiesWSModel> getShiftType() {
        return mShiftType;
    }

    public void setShiftType(LinkEmbeddedWSModel<ShiftTypePropertiesWSModel> shiftType) {
        mShiftType = shiftType;
    }
}