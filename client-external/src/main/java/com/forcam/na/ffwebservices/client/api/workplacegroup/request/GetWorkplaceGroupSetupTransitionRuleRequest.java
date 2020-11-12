////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 28.11.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.workplacegroup.request;

import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Request for getting a workplace group setup transition rule by ID.
 */
public class GetWorkplaceGroupSetupTransitionRuleRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The workplace group ID. */
    private String mWorkplaceGroupId;

    /** The setup transition rule ID. */
    private String mSetupTransitionRuleId;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates new instance.
     *
     * @param workplaceGroupId      The workplace group ID.
     * @param setupTransitionRuleId The setup transition rule ID.
     */
    public GetWorkplaceGroupSetupTransitionRuleRequest(String workplaceGroupId, String setupTransitionRuleId) {
        mWorkplaceGroupId = workplaceGroupId;
        mSetupTransitionRuleId = setupTransitionRuleId;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return ToStringUtility.newToStringBuilder(this)
            .appendSuper(super.toString())
            .append("workplaceGroupId", mWorkplaceGroupId)
            .append("setupTransitionRuleId", mSetupTransitionRuleId)
            .toString();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public String getWorkplaceGroupId() {
        return mWorkplaceGroupId;
    }

    public void setWorkplaceGroupId(String workplaceGroupId) {
        mWorkplaceGroupId = workplaceGroupId;
    }

    public String getSetupTransitionRuleId() {
        return mSetupTransitionRuleId;
    }

    public void setSetupTransitionRuleId(String setupTransitionRuleId) {
        mSetupTransitionRuleId = setupTransitionRuleId;
    }
}