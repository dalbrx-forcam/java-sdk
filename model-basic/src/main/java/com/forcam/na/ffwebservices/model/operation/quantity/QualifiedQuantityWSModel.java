////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 06.02.2019.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.operation.quantity;

import io.swagger.annotations.ApiModel;

/**
 * Model for qualified quantity.
 */
@ApiModel("qualifiedQuantity")
public class QualifiedQuantityWSModel {
    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private double mQuantity;

    private String mQualityDetailId;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public double getQuantity() {
        return mQuantity;
    }

    public void setQuantity(double quantity) {
        mQuantity = quantity;
    }

    public String getQualityDetailId() {
        return mQualityDetailId;
    }

    public void setQualityDetailId(String qualityDetailId) {
        mQualityDetailId = qualityDetailId;
    }

}
