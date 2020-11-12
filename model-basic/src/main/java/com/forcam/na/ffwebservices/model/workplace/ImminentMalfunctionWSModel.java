////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 25.09.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.workplace;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * Imminent malfunction model.
 */
@ApiModel(value = "imminentMalfunction")
@JsonPropertyOrder({ "workplaceId", "operatingStateId", "prewarningDate", "criticalDate " })
public class ImminentMalfunctionWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The workplace ID. */
    private String mWorkplaceId;

    /** The operating state ID. */
    private String mOperatingStateId;

    /** The prewarning date. */
    private Date mPrewarningDate;

    /** The critical date. */
    private Date mCriticalDate;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Provides the workplace ID.
     *
     * @return The workplace ID.
     */
    public String getWorkplaceId() {
        return mWorkplaceId;
    }

    /**
     * Sets the workplace ID.
     *
     * @param workplaceId The workplace ID.
     */
    @ApiModelProperty(value = "UUID of the workplace", position = 0)
    public void setWorkplaceId(String workplaceId) {
        mWorkplaceId = workplaceId;
    }

    /**
     * Provides the operating state ID.
     *
     * @return The operating state ID.
     */
    public String getOperatingStateId() {
        return mOperatingStateId;
    }

    /**
     * Sets the operating state ID.
     *
     * @param operatingStateId The operating state ID.
     */
    @ApiModelProperty(value = "The UUID of the detailed operating state describing the machine malfunction", position = 1)
    public void setOperatingStateId(String operatingStateId) {
        mOperatingStateId = operatingStateId;
    }

    /**
     * Provides the prewarning date.
     *
     * @return The prewarning date.
     */
    public Date getPrewarningDate() {
        return mPrewarningDate;
    }

    /**
     * Sets the prewarning date.
     *
     * @param prewarningDate The prewarning date.
     */
    @ApiModelProperty(value = "The date from which the probability of the machine malfunction increases significantly", position = 2)
    public void setPrewarningDate(Date prewarningDate) {
        mPrewarningDate = prewarningDate;
    }

    /**
     * Provides the critical date.
     *
     * @return The critical date.
     */
    public Date getCriticalDate() {
        return mCriticalDate;
    }

    /**
     * Sets the critical date.
     *
     * @param criticalDate The critical date.
     */
    @ApiModelProperty(value = "The date from which the machine malfunction is highly likely to occur", position = 3)
    public void setCriticalDate(Date criticalDate) {
        mCriticalDate = criticalDate;
    }
}