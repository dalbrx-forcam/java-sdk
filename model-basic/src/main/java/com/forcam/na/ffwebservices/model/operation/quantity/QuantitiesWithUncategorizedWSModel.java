////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 24.07.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.operation.quantity;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 *
 */
@ApiModel("quantitiesWithUncategorized")
@JsonPropertyOrder({ "yield", "scrap", "rework", "uncategorized" })
public class QuantitiesWithUncategorizedWSModel extends QuantitiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private double mUncategorized;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    @ApiModelProperty(value = "Quantity received from the machine but not yet categorized as yield, scrap or rework by the operator", notes = "These quantities are always unconfirmed and can therefore only exist for currently executed operations", position = 3)
    public void setUncategorized(double uncategorized) {
        mUncategorized = uncategorized;
    }

    public double getUncategorized() {
        return mUncategorized;
    }
}