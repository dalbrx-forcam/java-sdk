////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 12.12.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.workplacegroup.request;

import com.forcam.na.ffwebservices.client.api.workplacegroup.request.GetManufacturingVariantRuleRequest;
import com.forcam.na.ffwebservices.model.workplacegroup.WorkplaceGroupManufacturingVariantRuleRequestBody;

/**
 * Request for creating or updating a manufacturing variant rule for a workplace group.
 */
public class SaveOrUpdateManufacturingVariantRuleRequest extends GetManufacturingVariantRuleRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The manufacturing variant rule properties. */
    private WorkplaceGroupManufacturingVariantRuleRequestBody mManufacturingVariantRule;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates new instance for creating new manufacturing variant rule.
     *
     * @param workplaceGroupId         The workplace group ID.
     * @param manufacturingVariantRule The manufacturing variant rule properties.
     */
    public SaveOrUpdateManufacturingVariantRuleRequest(String workplaceGroupId, WorkplaceGroupManufacturingVariantRuleRequestBody manufacturingVariantRule) {
        super(workplaceGroupId, null);
        mManufacturingVariantRule = manufacturingVariantRule;
    }

    /**
     * Creates new instance for updating existing manufacturing variant rule.
     *
     * @param workplaceGroupId           The workplace group ID.
     * @param manufacturingVariantRuleId The manufacturing variant rule ID.
     * @param manufacturingVariantRule   The manufacturing variant rule properties.
     */
    public SaveOrUpdateManufacturingVariantRuleRequest(String workplaceGroupId, String manufacturingVariantRuleId,
                                                       WorkplaceGroupManufacturingVariantRuleRequestBody manufacturingVariantRule) {
        super(workplaceGroupId, manufacturingVariantRuleId);
        mManufacturingVariantRule = manufacturingVariantRule;
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public WorkplaceGroupManufacturingVariantRuleRequestBody getManufacturingVariantRule() {
        return mManufacturingVariantRule;
    }

    public void setManufacturingVariantRule(WorkplaceGroupManufacturingVariantRuleRequestBody manufacturingVariantRule) {
        mManufacturingVariantRule = manufacturingVariantRule;
    }
}