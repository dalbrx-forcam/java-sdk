////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 18.01.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.forcam.na.ffwebservices.model.operation.quantity.QuantitiesWithUncategorizedWSModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Super class for quantity summary detail properties models.
 */
@JsonPropertyOrder({ "quantities", "unconfirmedQuantities", "totalQuantity"})
public class AbstractQuantitySummaryDetailPropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The booked quantities. */
    private QuantitiesWithUncategorizedWSModel mQuantities = new QuantitiesWithUncategorizedWSModel();

    /** The machine quantities. */
    private QuantitiesWithUncategorizedWSModel mUnconfirmedQuantities = new QuantitiesWithUncategorizedWSModel();

    /** The total quantity. */
    private Double mTotalQuantity;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Setter for quantities.
     *
     * @param quantities Quantities.
     */
    @ApiModelProperty(position = 6)
    public void setQuantities(QuantitiesWithUncategorizedWSModel quantities) {
        mQuantities = quantities;
    }

    /**
     * Retrieves quantities.
     *
     * @return Quantities.
     */
    public QuantitiesWithUncategorizedWSModel getQuantities() {
        return mQuantities;
    }

    /**
     * Setter for unconfirmed quantities.
     *
     * @param unconfirmedQuantities Unconfirmed quantities.
     */
    @ApiModelProperty(position = 7)
    public void setUnconfirmedQuantities(QuantitiesWithUncategorizedWSModel unconfirmedQuantities) {
        mUnconfirmedQuantities = unconfirmedQuantities;
    }

    /**
     * Retrieves unconfirmed quantities.
     *
     * @return Unconfirmed quantities.
     */
    public QuantitiesWithUncategorizedWSModel getUnconfirmedQuantities() {
        return mUnconfirmedQuantities;
    }

    /**
     * Setter for total quantity.
     *
     * @param totalQuantity The total quantity.
     */
    @ApiModelProperty(position = 8)
    public void setTotalQuantity(double totalQuantity) {
        mTotalQuantity = totalQuantity;
    }

    /**
     * Retrieve total quantity.
     *
     * @return Total quantity.
     */
    public double getTotalQuantity() {
        if (mTotalQuantity != null) {
            return mTotalQuantity;
        }

        final double confirmedQuantites = mQuantities.getYield() + mQuantities.getScrap() + mQuantities.getRework() + mQuantities.getUncategorized();
        final double unconfirmedQuantities = mUnconfirmedQuantities.getYield() + mUnconfirmedQuantities.getScrap() +
                                             mUnconfirmedQuantities.getRework() + mUnconfirmedQuantities.getUncategorized();
        return confirmedQuantites + unconfirmedQuantities;
    }
}