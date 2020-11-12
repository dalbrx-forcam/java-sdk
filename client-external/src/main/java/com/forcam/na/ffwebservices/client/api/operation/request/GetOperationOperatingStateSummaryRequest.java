////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 18.07.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.operation.request;

import com.forcam.na.ffwebservices.client.api.pagination.request.CollectionRequest;
import com.forcam.na.ffwebservices.model.definition.TimeBaseFilter;
import com.forcam.na.ffwebservices.model.definition.WorkplaceState;

/**
 * Request parameter for getting operating state summary of an operation.
 */
public class GetOperationOperatingStateSummaryRequest extends CollectionRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The operation ID. */
    private String mOperationId;

    /** The workplace state ID. */
    private WorkplaceState mWorkplaceStateId;

    /** The operating state class ID. */
    private String mOperatingStateClassId;

    /** The time base. */
    private TimeBaseFilter mTimeBase;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates new instance with operation ID.
     *
     * @param operationId The operation ID.
     */
    public GetOperationOperatingStateSummaryRequest(String operationId) {
        mOperationId = operationId;
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Provides the operation ID.
     *
     * @return The operation ID.
     */
    public String getOperationId() {
        return mOperationId;
    }

    /**
     * Sets the operation ID.
     *
     * @param operationId The operation ID.
     */
    public void setOperationId(String operationId) {
        mOperationId = operationId;
    }

    /**
     * Provides the workplace state ID.
     *
     * @return The workplace state ID.
     */
    public WorkplaceState getWorkplaceStateId() {
        return mWorkplaceStateId;
    }

    /**
     * Sets the workplace state ID.
     *
     * @param workplaceStateId The workplace state ID.
     */
    public void setWorkplaceStateId(WorkplaceState workplaceStateId) {
        mWorkplaceStateId = workplaceStateId;
    }

    /**
     * Provides the operating state class ID.
     *
     * @return The operating state class ID.
     */
    public String getOperatingStateClassId() {
        return mOperatingStateClassId;
    }

    /**
     * Sets the operating state class ID.
     *
     * @param operatingStateClassId The operating state class ID.
     */
    public void setOperatingStateClassId(String operatingStateClassId) {
        mOperatingStateClassId = operatingStateClassId;
    }

    /**
     * Provides the time base.
     *
     * @return The time base.
     */
    public TimeBaseFilter getTimeBase() {
        return mTimeBase;
    }

    /**
     * Sets the time base.
     *
     * @param timeBase The time base.
     */
    public void setTimeBase(TimeBaseFilter timeBase) {
        mTimeBase = timeBase;
    }
}