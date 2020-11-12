////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 02.12.2019.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.reporting.request;

import java.util.Date;

/**
 * Request parameter for overall process efficiency report.
 */
public class GetOverallProcessEfficiencyRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private String mProductionOrderId;

    private String mMaterialId;

    private String mMaterialNumber;

    private Date mStartDate;

    private Date mEndDate;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    public GetOverallProcessEfficiencyRequest(Date startDate) {
        mStartDate = startDate;
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

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

    public String getMaterialNumber() {
        return mMaterialNumber;
    }

    public void setMaterialNumber(String materialNumber) {
        mMaterialNumber = materialNumber;
    }

    public String getProductionOrderId() {
        return mProductionOrderId;
    }

    public void setProductionOrderId(String productionOrderId) {
        mProductionOrderId = productionOrderId;
    }

    public String getMaterialId() {
        return mMaterialId;
    }

    public void setMaterialId(String materialId) {
        mMaterialId = materialId;
    }
}
