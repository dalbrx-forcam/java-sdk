////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 28.11.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.workplacegroup.request;

import com.forcam.na.ffwebservices.client.api.pagination.request.CollectionRequest;
import com.forcam.na.ffwebservices.model.workplacegroup.Criterion;
import com.forcam.na.ffwebservices.model.workplacegroup.Origin;
import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Request for getting collection of all setup transition rules of a workplace group.
 */
public class GetWorkplaceGroupSetupTransitionRuleCollectionRequest extends CollectionRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The workplace group ID. */
    private String mWorkplaceGroupId;

    /** The origin. */
    private Origin mOrigin;

    /** The criterion. */
    private Criterion mCriterion;

    /** The material number. */
    private String mMaterialNumber;

    /** The workplace number. */
    private String mWorkplaceNumber;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates new instance.
     *
     * @param workplaceGroupId The workplace group ID.
     */
    public GetWorkplaceGroupSetupTransitionRuleCollectionRequest(String workplaceGroupId) {
        this.mWorkplaceGroupId = workplaceGroupId;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return ToStringUtility.newToStringBuilder(this)
            .appendSuper(super.toString())
            .append("workplaceGroupId", mWorkplaceGroupId)
            .append("workplaceNumber", mWorkplaceNumber)
            .append("materialNumber", mMaterialNumber)
            .append("criterion", mCriterion)
            .append("origin", mOrigin)
            .toString();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public String getWorkplaceGroupId() {
        return mWorkplaceGroupId;
    }

    public void setWorkplaceGroupId(String workplaceGroupId) {
        this.mWorkplaceGroupId = workplaceGroupId;
    }

    public Origin getOrigin() {
        return mOrigin;
    }

    public void setOrigin(Origin origin) {
        this.mOrigin = origin;
    }

    public Criterion getCriterion() {
        return mCriterion;
    }

    public void setCriterion(Criterion criterion) {
        this.mCriterion = criterion;
    }

    public String getMaterialNumber() {
        return mMaterialNumber;
    }

    public void setMaterialNumber(String materialNumber) {
        mMaterialNumber = materialNumber;
    }

    public String getWorkplaceNumber() {
        return mWorkplaceNumber;
    }

    public void setWorkplaceNumber(String workplaceNumber) {
        mWorkplaceNumber = workplaceNumber;
    }
}