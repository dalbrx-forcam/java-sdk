////////////////////////////////////////////////////////////////////////////////
//
// Created by RGupta on 6/16/2020.
//
// Copyright (c) 2006 - 2020 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.trace;

import java.io.Serializable;

/**
 * Define the warehouse feedback entities.
 */
public class WarehouseEntityWSModel implements Serializable {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------
    /** Serial version id. */
    private static final long serialVersionUID = -6472674597144016515L;
    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------
    /** Reference value. */
    private String mReferenceValue;

    /** Quality type. */
    private String mQualityType;

    /** Amount as per locale. */
    private String mAmount;

    /** Unit. */
    private String mUnit;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public String getReferenceValue() {
        return mReferenceValue;
    }

    public void setReferenceValue(String referenceValue) {
        mReferenceValue = referenceValue;
    }

    public String getQualityType() {
        return mQualityType;
    }

    public void setQualityType(String qualityType) {
        mQualityType = qualityType;
    }

    public String getAmount() {
        return mAmount;
    }

    public void setAmount(String amount) {
        mAmount = amount;
    }

    public String getUnit() {
        return mUnit;
    }

    public void setUnit(String unit) {
        mUnit = unit;
    }
}
