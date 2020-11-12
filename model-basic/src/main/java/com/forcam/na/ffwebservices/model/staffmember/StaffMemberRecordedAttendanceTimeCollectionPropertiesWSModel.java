////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 04.04.2019.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.staffmember;

import io.swagger.annotations.ApiModel;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@ApiModel(value = "staffMemberRecordedAttendanceTimeCollectionProperties")
public class StaffMemberRecordedAttendanceTimeCollectionPropertiesWSModel {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The staff member recorded activities. */
    private List<StaffMemberRecordedAttendanceTimeWSModel> mElements = new ArrayList<>();

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public List<StaffMemberRecordedAttendanceTimeWSModel> getElements() {
        return mElements;
    }

    public void setElements(List<StaffMemberRecordedAttendanceTimeWSModel> elements) {
        mElements = elements;
    }

}
