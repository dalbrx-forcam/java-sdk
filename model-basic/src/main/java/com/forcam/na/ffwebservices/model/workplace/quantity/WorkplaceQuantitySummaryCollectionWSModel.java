////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 01.02.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.workplace.quantity;

import com.forcam.na.ffwebservices.model.collection.AbstractBaseCollectionWSModel;
import com.forcam.na.ffwebservices.model.collection.AbstractCollectionWSModel;

/**
 * Model for workplace quantity summary.
 */
public class WorkplaceQuantitySummaryCollectionWSModel extends AbstractCollectionWSModel<WorkplaceQuantitySummaryDetailPropertiesWSModel> {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** A collection of workplace quantity summary property models. */
    private WorkplaceQuantitySummaryCollectionPropertiesWSModel mProperties;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public WorkplaceQuantitySummaryCollectionPropertiesWSModel getProperties() {
        return mProperties;
    }

    public void setProperties(WorkplaceQuantitySummaryCollectionPropertiesWSModel properties) {
        mProperties = properties;
    }
}