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
 * Workplace maintenance request command webservice model.
 */
@ApiModel(value = "workplaceMaintenanceRequestCommand", parent = AbstractCommandDataWSModel.class)
public class WorkplaceMaintenanceRequestCommandDataWSModel extends AbstractCommandDataWSModel {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------

    public static final String NAME = "WORKPLACE_MAINTENANCE_REQUEST";

    private static final long serialVersionUID = 3895881165263924773L;

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Persistence id of workplace */
    private String mWorkplaceId;

    /** Persistence id of person who requested maintenance */
    private String mStaffMemberId;

    /** Persistence id of status reason */
    private String mMachineStateDetailId;

    /** Additional comment (beside the given reason) of the person who requested maintenance */
    private String mComment;

    /** Generated id for the maintenance request */
    private Long mMaintenanceRequestId;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     */
    public WorkplaceMaintenanceRequestCommandDataWSModel() {
        super(NAME);
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public String getComment() {
        return mComment;
    }

    public void setComment(String comment) {
        mComment = comment;
    }

    public String getMachineStateDetailId() {
        return mMachineStateDetailId;
    }

    public void setMachineStateDetailId(String machineStateDetailId) {
        mMachineStateDetailId = machineStateDetailId;
    }

    public String getStaffMemberId() {
        return mStaffMemberId;
    }

    public void setStaffMemberId(String staffMemberId) {
        mStaffMemberId = staffMemberId;
    }

    public String getWorkplaceId() {
        return mWorkplaceId;
    }

    public void setWorkplaceId(String workplaceId) {
        mWorkplaceId = workplaceId;
    }

    public Long getMaintenanceRequestId() {
        return mMaintenanceRequestId;
    }

    public void setMaintenanceRequestId(Long maintenanceRequestId) {
        mMaintenanceRequestId = maintenanceRequestId;
    }

}
