////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 02.12.2019.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.reporting;

import io.swagger.annotations.ApiModel;

import java.util.Date;

/**
 * Entry of the total quantity report.
 */
@ApiModel("totalQuantityEntry")
public class TotalQuantityEntry {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private String mWorkplaceId;

    private String mMaterialId;

    private Date mStartDate;

    private Date mEndDate;

    private Double mTargetQuantity;

    private Double mYieldQuantity;

    private Double mReworkQuantity;

    private Double mScrapQuantity;

    private Double mTotalQuantity;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public String getWorkplaceId() {
        return mWorkplaceId;
    }

    public void setWorkplaceId(String workplaceId) {
        mWorkplaceId = workplaceId;
    }

    public String getMaterialId() {
        return mMaterialId;
    }

    public void setMaterialId(String material) {
        mMaterialId = material;
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

    public Double getTargetQuantity() {
        return mTargetQuantity;
    }

    public void setTargetQuantity(Double targetQuantity) {
        mTargetQuantity = targetQuantity;
    }

    public Double getYieldQuantity() {
        return mYieldQuantity;
    }

    public void setYieldQuantity(Double yieldQuantity) {
        mYieldQuantity = yieldQuantity;
    }

    public Double getReworkQuantity() {
        return mReworkQuantity;
    }

    public void setReworkQuantity(Double reworkQuantity) {
        mReworkQuantity = reworkQuantity;
    }

    public Double getScrapQuantity() {
        return mScrapQuantity;
    }

    public void setScrapQuantity(Double scrapQuantity) {
        mScrapQuantity = scrapQuantity;
    }

    public Double getTotalQuantity() {
        return mTotalQuantity;
    }

    public void setTotalQuantity(Double totalQuantity) {
        mTotalQuantity = totalQuantity;
    }
}
