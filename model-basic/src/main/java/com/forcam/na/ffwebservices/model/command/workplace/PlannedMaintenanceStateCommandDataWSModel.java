////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 12.12.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.command.workplace;

import com.forcam.na.ffwebservices.model.command.AbstractCommandDataWSModel;
import io.swagger.annotations.ApiModel;

/**
 * Planned maintenance command webservice model.
 */
@ApiModel(value = "workplacePlannedMaintenanceStateCommand", parent = AbstractCommandDataWSModel.class)
public class PlannedMaintenanceStateCommandDataWSModel extends AbstractCommandDataWSModel {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------

    public static final String NAME = "WORKPLACE_PLANNED_MAINTENANCE_STATE";

    private static final long serialVersionUID = 7290479608836956750L;

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private String mWorkplaceId;

    private PlannedMaintenanceState mPlannedMaintenanceStateId;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     */
    public PlannedMaintenanceStateCommandDataWSModel() {
        super(NAME);
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public String getWorkplaceId() {
        return mWorkplaceId;
    }

    public void setWorkplaceId(String workplaceId) {
        mWorkplaceId = workplaceId;
    }

    public PlannedMaintenanceState getPlannedMaintenanceStateId() {
        return mPlannedMaintenanceStateId;
    }

    public void setPlannedMaintenanceStateId(PlannedMaintenanceState plannedMaintenanceStateId) {
        mPlannedMaintenanceStateId = plannedMaintenanceStateId;
    }
}
