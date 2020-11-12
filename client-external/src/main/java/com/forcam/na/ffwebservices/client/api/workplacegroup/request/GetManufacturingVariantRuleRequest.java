////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 12.12.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.workplacegroup.request;

/**
 * Request for getting a manufacturing variant rule.
 */
public class GetManufacturingVariantRuleRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The workplace group ID. */
    private String mWorkplaceGroupId;

    /** The manufacturing variant rule ID. */
    private String mManufacturingVariantRuleId;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates new instance.
     *
     * @param workplaceGroupId           The workplace group ID.
     * @param manufacturingVariantRuleId The manufacturing variant rule ID.
     */
    public GetManufacturingVariantRuleRequest(String workplaceGroupId, String manufacturingVariantRuleId) {
        mWorkplaceGroupId = workplaceGroupId;
        mManufacturingVariantRuleId = manufacturingVariantRuleId;
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

    public String getManufacturingVariantRuleId() {
        return mManufacturingVariantRuleId;
    }

    public void setManufacturingVariantRuleId(String manufacturingVariantRuleId) {
        mManufacturingVariantRuleId = manufacturingVariantRuleId;
    }
}