////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 31.01.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.operation.quantity;

import com.forcam.na.ffwebservices.model.collection.AbstractCollectionWSModel;

/**
 * Model for operation quantity summary.
 */
public class OperationQuantitySummaryCollectionWSModel extends AbstractCollectionWSModel<OperationQuantitySummaryDetailPropertiesWSModel> {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** A collection of operation quantity summary property models. */
    private OperationQuantitySummaryCollectionPropertiesWSModel mProperties;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public OperationQuantitySummaryCollectionPropertiesWSModel getProperties() {
        return mProperties;
    }

    public void setProperties(OperationQuantitySummaryCollectionPropertiesWSModel properties) {
        mProperties = properties;
    }
}