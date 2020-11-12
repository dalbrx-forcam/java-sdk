////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 10.01.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.statusdefinition.request;

import com.forcam.na.common.webserviceaccess.util.ToStringUtility;
import com.forcam.na.ffwebservices.client.api.pagination.request.CollectionRequest;
import com.forcam.na.ffwebservices.model.definition.TimeBaseFilter;
import com.forcam.na.ffwebservices.model.definition.WorkplaceState;
import com.forcam.na.ffwebservices.model.statusdefinition.OperatingStateEmbed;

/**
 * Contains values that determine what shall be embedded.
 */
public class GetOperatingStateCollectionRequest extends CollectionRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Determines what shall be embedded. */
    private OperatingStateEmbed mEmbed = new OperatingStateEmbed();

    /** The time base. */
    private TimeBaseFilter mTimeBase;

    /** The operating state class. */
    private String mOperatingStateClassId;

    /** The workplace state ID. */
    private WorkplaceState mWorkplaceState;

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    public OperatingStateEmbed embed() {
        return mEmbed;
    }

    public void embed(OperatingStateEmbed embed) {
        mEmbed = embed;
    }

    @Override
    public String toString() {
        return ToStringUtility
            .newToStringBuilder(this)
            .appendSuper(super.toString())
            .append("embed", mEmbed)
            .toString();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public TimeBaseFilter getTimeBase() {
        return mTimeBase;
    }

    public void setTimeBase(TimeBaseFilter timeBase) {
        mTimeBase = timeBase;
    }

    public String getOperatingStateClassId() {
        return mOperatingStateClassId;
    }

    public void setOperatingStateClassId(String operatingStateClassId) {
        mOperatingStateClassId = operatingStateClassId;
    }

    public WorkplaceState getWorkplaceState() {
        return mWorkplaceState;
    }

    public void setWorkplaceState(WorkplaceState workplaceState) {
        mWorkplaceState = workplaceState;
    }
}