////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 24.10.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.staffmember;

import io.swagger.annotations.ApiModel;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * Staff member planning result properties model.
 */
@ApiModel("staffMemberPlanningResultProperties")
public class StaffMemberPlanningResultPropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** List of staff member assignments. */
    private List<StaffMemberAssignmentWSModel> mElements;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    @NotEmpty(message = "Elements must not be empty")
    public List<StaffMemberAssignmentWSModel> getElements() {
        return mElements;
    }

    public void setElements(List<StaffMemberAssignmentWSModel> elements) {
        mElements = elements;
    }
}