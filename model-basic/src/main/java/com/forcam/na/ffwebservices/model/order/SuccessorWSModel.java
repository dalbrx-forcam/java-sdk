////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 30.04.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.order;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModelProperty;

/**
 * Operation successor model.
 */
@JsonPropertyOrder({ "operationId", "targetWaitTime", "targetMoveTime" })
public class SuccessorWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The operation ID. */
    private String mOperationId;

    /** The target wait time. */
    private Long mTargetWaitTime;

    /** The target move time. */
    private Long mTargetMoveTime;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Sets the operation ID.
     *
     * @param operationId The operation ID.
     */
    @ApiModelProperty(position = 0)
    public void setOperationId(String operationId) {
        mOperationId = operationId;
    }

    /**
     * Provides the operation ID.
     *
     * @return The operation ID.
     */
    public String getOperationId() {
        return mOperationId;
    }

    /**
     * Sets the target wait time.
     *
     * @param targetWaitTime The target wait time.
     */
    @ApiModelProperty(position = 1)
    public void setTargetWaitTime(Long targetWaitTime) {
        mTargetWaitTime = targetWaitTime;
    }

    /**
     * Provides the target wait time.
     *
     * @return The target wait time.
     */
    public Long getTargetWaitTime() {
        return mTargetWaitTime;
    }

    /**
     * Sets the target move time.
     *
     * @param targetMoveTime The target move time.
     */
    @ApiModelProperty(position = 2)
    public void setTargetMoveTime(Long targetMoveTime) {
        mTargetMoveTime = targetMoveTime;
    }

    /**
     * Provides the target move time.
     *
     * @return The target move time.
     */
    public Long getTargetMoveTime() {
        return mTargetMoveTime;
    }
}