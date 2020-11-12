////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 29.08.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.staffmember;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Staff member recorded activities collection properties model.
 */
@ApiModel(value = "staffMemberRecordedActivitiesProperties")
public class StaffMemberRecordedActivitiesCollectionPropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The staff member recorded activities. */
    private List<StaffMemberLoginPeriodRecordWSModel> mElements = new ArrayList<>();

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Provides the list of staff member recorded activities.
     *
     * @param elements List of staff member recorded activities WS models.
     */
    @ApiModelProperty(value = "Array of activity records")
    public void setElements(List<StaffMemberLoginPeriodRecordWSModel> elements) {
        mElements = elements;
    }

    /**
     * Sets the list of staff member recorded activities.
     *
     * @return The list of staff member recorded activities WS models.
     */
    public List<StaffMemberLoginPeriodRecordWSModel> getElements() {
        return mElements;
    }
}