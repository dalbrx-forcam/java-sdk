////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 25.01.2019.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.event;

import java.io.Serializable;

/**
 * Model containing information about person signed off workplace.
 */
public class WorkplaceStaffMemberSignedOffEventWSModel implements Serializable {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------

    private static final long serialVersionUID = -2733550159693807618L;

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private String mWorkplaceId;

    private String mStaffMemberId;

    private Boolean mForced;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public String getWorkplaceId() {
        return mWorkplaceId;
    }

    public void setWorkplaceId(String workplaceId) {
        mWorkplaceId = workplaceId;
    }

    public String getStaffMemberId() {
        return mStaffMemberId;
    }

    public void setStaffMemberId(String staffMemberId) {
        mStaffMemberId = staffMemberId;
    }

    public Boolean getForced() {
        return mForced;
    }

    public void setForced(Boolean forced) {
        mForced = forced;
    }
}
