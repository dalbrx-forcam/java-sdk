////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 14.08.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.workplace.quantity;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.forcam.na.ffwebservices.model.AbstractQuantitySummaryDetailPropertiesWSModel;
import com.forcam.na.ffwebservices.model.TimePeriodWSModel;
import com.forcam.na.ffwebservices.model.material.MaterialPropertiesWSModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Model for properties of workplace quantity summary detail.
 */
@XmlRootElement(name = "workplaceQuantitySummaryDetailProperties")
@ApiModel(value = "workplaceQuantitySummaryDetailProperties")
@JsonPropertyOrder({ "material", "quantityUnit", "targetTimePerUnit", "timePerUnit", "productionTime", "timePeriod", "quantities", "unconfirmedQuantities",
                     "totalQuantity" })
public class WorkplaceQuantitySummaryDetailPropertiesWSModel extends AbstractQuantitySummaryDetailPropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The material. */
    private MaterialPropertiesWSModel mMaterial;

    /** The quantity unit. */
    private String mQuantityUnit;

    /** The target time per unit. */
    private Long mTargetTimePerUnit;

    /** The time per unit. */
    private double mTimePerUnit;

    /** The production time. */
    private long mProductionTime;

    /** The time period. */
    private TimePeriodWSModel mTimePeriod;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Setter for material.
     *
     * @param material The material.
     */
    @ApiModelProperty(position = 0)
    public void setMaterial(MaterialPropertiesWSModel material) {
        mMaterial = material;
    }

    /**
     * Retrieve material.
     *
     * @return Material.
     */
    public MaterialPropertiesWSModel getMaterial() {
        return mMaterial;
    }

    /**
     * Setter for quantity unit.
     *
     * @param quantityUnit The quantity unit.
     */
    @ApiModelProperty(position = 1)
    public void setQuantityUnit(String quantityUnit) {
        mQuantityUnit = quantityUnit;
    }

    /**
     * Retrieve quantity unit.
     *
     * @return Quantity unit.
     */
    public String getQuantityUnit() {
        return mQuantityUnit;
    }

    /**
     * Setter for target time per unit.
     *
     * @param targetTimePerUnit The target time per unit.
     */
    @ApiModelProperty(position = 2)
    public void setTargetTimePerUnit(Long targetTimePerUnit) {
        mTargetTimePerUnit = targetTimePerUnit;
    }

    /**
     * Retrieve target time per unit.
     *
     * @return Target time per unit.
     */
    public Long getTargetTimePerUnit() {
        return mTargetTimePerUnit;
    }

    /**
     * Sets the time per unit.
     *
     * @param timePerUnit The time per unit.
     */
    @ApiModelProperty(position = 3)
    public void setTimePerUnit(double timePerUnit) {
        mTimePerUnit = timePerUnit;
    }

    /**
     * Provides the time per unit.
     *
     * @return The time per unit.
     */
    public double getTimePerUnit() {
        return mTimePerUnit;
    }

    /**
     * Sets the production time.
     *
     * @param productionTime The production time.
     */
    @ApiModelProperty(position = 4)
    public void setProductionTime(long productionTime) {
        mProductionTime = productionTime;
    }

    /**
     * Provides the production time.
     *
     * @return The production time.
     */
    public long getProductionTime() {
        return mProductionTime;
    }

    /**
     * Setter for time period.
     *
     * @param timePeriod The time period.
     */
    @ApiModelProperty(position = 5)
    public void setTimePeriod(TimePeriodWSModel timePeriod) {
        mTimePeriod = timePeriod;
    }

    /**
     * Retrieve time period.
     *
     * @return Time period.
     */
    public TimePeriodWSModel getTimePeriod() {
        return mTimePeriod;
    }
}