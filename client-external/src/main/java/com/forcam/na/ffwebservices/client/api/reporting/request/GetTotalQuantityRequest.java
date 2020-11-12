////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 28.11.2019.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.reporting.request;

import com.forcam.na.ffwebservices.model.reporting.TotalQuantityEmbed;

import java.util.Date;

/**
 * Request parameter for quantity log report.
 */
public class GetTotalQuantityRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private String mWorkplaceId;

    private String mWorkplaceNumber;

    private String mWorkplaceGroupId;

    private String mWorkplaceGroupNumber;

    private Date mStartDate;

    private Date mEndDate;

    private TotalQuantityEmbed mEmbed = new TotalQuantityEmbed();

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    public GetTotalQuantityRequest(Date startDate) {
        mStartDate = startDate;
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

    public String getWorkplaceNumber() {
        return mWorkplaceNumber;
    }

    public void setWorkplaceNumber(String workplaceNumber) {
        mWorkplaceNumber = workplaceNumber;
    }

    public Date getStartDate() {
        return mStartDate;
    }

    public void setStartDate(Date startDate) {
        mStartDate = startDate;
    }

    public Date getEndDate() {
        return mEndDate;
    }

    public void setEndDate(Date endDate) {
        mEndDate = endDate;
    }

    public String getWorkplaceGroupId() {
        return mWorkplaceGroupId;
    }

    public void setWorkplaceGroupId(String workplaceGroupId) {
        mWorkplaceGroupId = workplaceGroupId;
    }

    public String getWorkplaceGroupNumber() {
        return mWorkplaceGroupNumber;
    }

    public void setWorkplaceGroupNumber(String workplaceGroupNumber) {
        mWorkplaceGroupNumber = workplaceGroupNumber;
    }

    public TotalQuantityEmbed embed() {
        return mEmbed;
    }

    public void embed(TotalQuantityEmbed embed) {
        mEmbed = embed;
    }
}
