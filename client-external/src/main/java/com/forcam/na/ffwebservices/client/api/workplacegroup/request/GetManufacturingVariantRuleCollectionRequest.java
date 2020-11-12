////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 12.12.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.workplacegroup.request;

import com.forcam.na.ffwebservices.client.api.pagination.request.CollectionRequest;
import com.forcam.na.ffwebservices.model.workplacegroup.ManufacturingVariantRuleCriterion;
import com.forcam.na.ffwebservices.model.workplacegroup.ManufacturingVariantRuleOrigin;

/**
 * Request for getting the manufacturing variant rules collection.
 */
public class GetManufacturingVariantRuleCollectionRequest extends CollectionRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The workplace group ID. */
    private String mWorkplaceGroupId;

    /** The origin. */
    private ManufacturingVariantRuleOrigin mOrigin;

    /** The criterion. */
    private ManufacturingVariantRuleCriterion mCriterion;

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
    public GetManufacturingVariantRuleCollectionRequest(String workplaceGroupId) {
        mWorkplaceGroupId = workplaceGroupId;
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public String getWorkplaceGroupId() {
        return mWorkplaceGroupId;
    }

    public void setWorkplaceGroupId(String workplaceGroupId) {
        mWorkplaceGroupId = workplaceGroupId;
    }

    public ManufacturingVariantRuleOrigin getOrigin() {
        return mOrigin;
    }

    public void setOrigin(ManufacturingVariantRuleOrigin origin) {
        mOrigin = origin;
    }

    public ManufacturingVariantRuleCriterion getCriterion() {
        return mCriterion;
    }

    public void setCriterion(ManufacturingVariantRuleCriterion criterion) {
        mCriterion = criterion;
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