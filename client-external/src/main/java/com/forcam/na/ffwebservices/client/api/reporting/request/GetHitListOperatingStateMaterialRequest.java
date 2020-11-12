////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 28.11.2019.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.reporting.request;

import com.forcam.na.ffwebservices.model.reporting.HitListOperatingStatesMaterialEmbed;

import java.util.Date;

/**
 * Request parameter for hit list operating state material report.
 */
public class GetHitListOperatingStateMaterialRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private String mMaterialId;

    private String mMaterialNumber;

    private Date mStartDate;

    private Date mEndDate;

    private HitListOperatingStatesMaterialEmbed mEmbed = new HitListOperatingStatesMaterialEmbed();

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    public GetHitListOperatingStateMaterialRequest(Date startDate) {
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

    public String getMaterialId() {
        return mMaterialId;
    }

    public void setMaterialId(String materialId) {
        mMaterialId = materialId;
    }

    public HitListOperatingStatesMaterialEmbed embed() {
        return mEmbed;
    }

    public void embed(HitListOperatingStatesMaterialEmbed embed) {
        mEmbed = embed;
    }
}
