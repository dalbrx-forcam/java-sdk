////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 08.11.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.command.machine;

import io.swagger.annotations.ApiModel;

/**
 * Model for machine quantities with quality details.
 */
@ApiModel("machineQuantitiesWithQualityDetails")
public class MachineQuantitiesWithQualityDetailsRequestBody {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Quantity amount. */
    private double mQuantity;
    /** UUID for reason id. */
    private String mQualityDetailId;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public String getQualityDetailId() {
        return mQualityDetailId;
    }

    public void setQualityDetailId(String qualityDetailId) {
        mQualityDetailId = qualityDetailId;
    }

    public double getQuantity() {
        return mQuantity;
    }

    public void setQuantity(double quantity) {
        mQuantity = quantity;
    }

}
