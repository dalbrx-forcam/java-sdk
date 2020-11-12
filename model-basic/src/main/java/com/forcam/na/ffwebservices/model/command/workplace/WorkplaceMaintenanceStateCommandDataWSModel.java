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
 * Workplace maintenance state command webservice model.
 */
@ApiModel(value = "workplaceMaintenanceStateCommand", parent = AbstractCommandDataWSModel.class)
public class WorkplaceMaintenanceStateCommandDataWSModel extends AbstractCommandDataWSModel {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------

    public static final String NAME = "WORKPLACE_MAINTENANCE_STATE";

    private static final long serialVersionUID = 7765834480975716768L;

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Persistence id of workplace */
    private String mWorkplaceId;

    /** Code of status (see constants of command) */
    private MaintenanceState mMaintenanceStateId;

    /** Generated id for the maintenance request */
    private Long mMaintenanceRequestId;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     */
    public WorkplaceMaintenanceStateCommandDataWSModel() {
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

    public MaintenanceState getMaintenanceStateId() {
        return mMaintenanceStateId;
    }

    public void setMaintenanceStateId(MaintenanceState maintenanceStateId) {
        mMaintenanceStateId = maintenanceStateId;
    }

    public Long getMaintenanceRequestId() {
        return mMaintenanceRequestId;
    }

    public void setMaintenanceRequestId(Long maintenanceRequestId) {
        mMaintenanceRequestId = maintenanceRequestId;
    }

}
