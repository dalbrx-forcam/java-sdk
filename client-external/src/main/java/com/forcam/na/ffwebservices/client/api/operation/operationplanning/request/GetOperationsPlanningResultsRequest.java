////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 14.09.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.operation.operationplanning.request;

import com.forcam.na.ffwebservices.client.api.pagination.request.CollectionRequest;

import java.util.Date;

/**
 * Request parameter for getting all operations planning results.
 */
public class GetOperationsPlanningResultsRequest extends CollectionRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The start date. */
    private Date mStartDate;

    /** The end date. */
    private Date mEndDate;

    /** The workplace group number. */
    private String mWorkplaceGroupNumber;

    /** The workplace group ID. */
    private String mWorkplaceGroupId;

    /** The workplace number. */
    private String mWorkplaceNumber;

    /** The ERP context ID. */
    private String mErpContextId;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Provides the start date.
     *
     * @return The start date.
     */
    public Date getStartDate() {
        return mStartDate;
    }

    /**
     * Sets the start date.
     *
     * @param startDate The start date.
     */
    public void setStartDate(Date startDate) {
        mStartDate = startDate;
    }

    /**
     * Provides the end date.
     *
     * @return The end date.
     */
    public Date getEndDate() {
        return mEndDate;
    }

    /**
     * Sets the end date.
     *
     * @param endDate The end date.
     */
    public void setEndDate(Date endDate) {
        mEndDate = endDate;
    }

    /**
     * Provides the workplace group number.
     *
     * @return The workplace group number.
     */
    public String getWorkplaceGroupNumber() {
        return mWorkplaceGroupNumber;
    }

    /**
     * Sets the workplace group number.
     *
     * @param workplaceGroupNumber The workplace group number.
     */
    public void setWorkplaceGroupNumber(String workplaceGroupNumber) {
        mWorkplaceGroupNumber = workplaceGroupNumber;
    }

    /**
     * Provides the workplace group ID.
     *
     * @return The workplace group ID.
     */
    public String getWorkplaceGroupId() {
        return mWorkplaceGroupId;
    }

    /**
     * Sets the workplace group ID.
     *
     * @param workplaceGroupId The workplace group ID.
     */
    public void setWorkplaceGroupId(String workplaceGroupId) {
        mWorkplaceGroupId = workplaceGroupId;
    }

    /**
     * Provides the workplace number.
     *
     * @return The workplace number.
     */
    public String getWorkplaceNumber() {
        return mWorkplaceNumber;
    }

    /**
     * Sets the workplace number.
     *
     * @param workplaceNumber The workplace number.
     */
    public void setWorkplaceNumber(String workplaceNumber) {
        mWorkplaceNumber = workplaceNumber;
    }

    /**
     * Provides the ERP context ID.
     *
     * @return The ERP context ID.
     */
    public String getErpContextId() {
        return mErpContextId;
    }

    /**
     * Sets the ERP context ID.
     *
     * @param erpContextId The ERP context ID.
     */
    public void setErpContextId(String erpContextId) {
        mErpContextId = erpContextId;
    }
}