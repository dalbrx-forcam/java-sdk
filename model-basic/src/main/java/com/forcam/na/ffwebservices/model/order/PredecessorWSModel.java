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
 * Operation precessor model.
 */
@JsonPropertyOrder({ "operationId", "targetQueueTime", "minimumSendAheadQuantity", "minimumOffsetTime", "minimumOverlapTime"})
public class PredecessorWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The operation ID. */
    private String mOperationId;

    /** The target queue time. */
    private Long mTargetQueueTime;

    /** The minimum send ahead quantity. */
    private Double mMinimumSendAheadQuantity;

    /** The minimum offset time. */
    private Long mMinimumOffsetTime;

    /** The minimum overlap time. */
    private Long mMinimumOverlapTime;

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
     * Sets the target queue time.
     *
     * @param targetQueueTime The target queue time.
     */
    @ApiModelProperty(position = 1)
    public void setTargetQueueTime(Long targetQueueTime) {
        mTargetQueueTime = targetQueueTime;
    }

    /**
     * Provides the target queue time.
     *
     * @return The target queue time.
     */
    public Long getTargetQueueTime() {
        return mTargetQueueTime;
    }

    /**
     * Sets the minimum of send ahead quantity.
     *
     * @param minimumSendAheadQuantity The minimum of send ahead quantity.
     */
    @ApiModelProperty(position = 2)
    public void setMinimumSendAheadQuantity(Double minimumSendAheadQuantity) {
        mMinimumSendAheadQuantity = minimumSendAheadQuantity;
    }

    /**
     * Provides the minimum of send ahead quantity.
     *
     * @return The minimum of send ahead quantity.
     */
    public Double getMinimumSendAheadQuantity() {
        return mMinimumSendAheadQuantity;
    }

    /**
     * Sets the minimum offset time.
     *
     * @param minimumOffsetTime The minimum offset time.
     */
    @ApiModelProperty(position = 3)
    public void setMinimumOffsetTime(Long minimumOffsetTime) {
        mMinimumOffsetTime = minimumOffsetTime;
    }

    /**
     * Provides the minimum offset time.
     *
     * @return The minimum offset time.
     */
    public Long getMinimumOffsetTime() {
        return mMinimumOffsetTime;
    }

    /**
     * Sets the minimum overlap time.
     *
     * @param minimumOverlapTime The minimum overlap time.
     */
    @ApiModelProperty(position = 4)
    public void setMinimumOverlapTime(Long minimumOverlapTime) {
        mMinimumOverlapTime = minimumOverlapTime;
    }

    /**
     * Provides the minimum overlap time.
     *
     * @return The minimum overlap time.
     */
    public Long getMinimumOverlapTime() {
        return mMinimumOverlapTime;
    }
}