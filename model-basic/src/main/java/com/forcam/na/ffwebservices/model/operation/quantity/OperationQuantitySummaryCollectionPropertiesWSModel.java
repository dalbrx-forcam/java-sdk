////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 14.08.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.operation.quantity;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.forcam.na.ffwebservices.model.material.MaterialPropertiesWSModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Model for properties of operation quantity summary.
 */
@ApiModel(value = "operationQuantitySummaryProperties")
@JsonFilter("versionFilter")
@JsonPropertyOrder({ "performance", "qualityRate", "material", "totalQuantity", "quantityUnit", "targetTimePerUnit", "timePerUnit", "productionTime",
                     "elements" })
public class OperationQuantitySummaryCollectionPropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The performance rate of the operation */
    private double mPerformance;

    /** The quality rate of the operation */
    private double mQualityRate;

    /** The material of the operation */
    private MaterialPropertiesWSModel mMaterial;

    /** The sum of the total quantities generated at all workplaces. */
    private double mTotalQuantity;

    /** The quantity unit of the operation */
    private String mQuantityUnit;

    /** The target time per unit of the operation */
    private Long mTargetTimePerUnit;

    /** The time per unit. The quotient of production time and total quantity. */
    private double mTimePerUnit;

    /**
     * The total production time of the operation in msec.
     * The production time is the sum of all durations of all operating states assigned to the production time base.
     */
    private long mProductionTime;

    /** The operation quantity summary details. */
    private List<OperationQuantitySummaryDetailPropertiesWSModel> mElements;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    @ApiModelProperty(value = "Performance rate during the entire execution of the operation", notes = "If the operation is still being executed, this property might be empty", position = 0)
    public void setPerformance(double performance) {
        mPerformance = performance;
    }

    public double getPerformance() {
        return mPerformance;
    }

    @ApiModelProperty(value = "Quality rate during the entire execution of the operation", notes = "If the operation is still being executed, this property might be empty", position = 1)
    public void setQualityRate(double qualityRate) {
        mQualityRate = qualityRate;
    }

    public double getQualityRate() {
        return mQualityRate;
    }

    /**
     * Setter for material.
     *
     * @param material Material.
     */
    @ApiModelProperty(value = "Material produced by the operation", position = 2)
    public void setMaterial(MaterialPropertiesWSModel material) {
        mMaterial = material;
    }

    /**
     * Retrieves material.
     *
     * @return Material.
     */
    public MaterialPropertiesWSModel getMaterial() {
        return mMaterial;
    }

    @ApiModelProperty(value = "Sum of the total quantities generated at all workplaces", position = 3)
    public void setTotalQuantity(double totalQuantity) {
        mTotalQuantity = totalQuantity;
    }

    public double getTotalQuantity() {
        return mTotalQuantity;
    }

    /**
     * Setter for unit of quantity.
     *
     * @param quantityUnit Unit of quantity.
     */
    @ApiModelProperty(value = "Unit of the output quantity", position = 4)
    public void setQuantityUnit(String quantityUnit) {
        mQuantityUnit = quantityUnit;
    }

    /**
     * Retrieves unit for quantity.
     *
     * @return Unit for quantity.
     */
    public String getQuantityUnit() {
        return mQuantityUnit;
    }

    /**
     * Setter for target time per unit.
     *
     * @param targetTimePerUnit Target time per unit.
     */
    @ApiModelProperty(value = "Target time per unit in msec", position = 5)
    public void setTargetTimePerUnit(Long targetTimePerUnit) {
        mTargetTimePerUnit = targetTimePerUnit;
    }

    /**
     * Retrieves target time per unit.
     *
     * @return Target time per unit.
     */
    public Long getTargetTimePerUnit() {
        return mTargetTimePerUnit;
    }

    @ApiModelProperty(value = "Time per unit in msec", notes = "Quotient of the production time and total quantity", position = 6)
    public void setTimePerUnit(double timePerUnit) {
        mTimePerUnit = timePerUnit;
    }

    public double getTimePerUnit() {
        return mTimePerUnit;
    }

    @Deprecated
    @ApiModelProperty(hidden = true, value = "Total production time of the operation in msec", notes = "Production time is the sum of the durations of all operating states assigned to the production time base", position = 7)
    public void setProductionTime(long productionTime) {
        mProductionTime = productionTime;
    }

    @Deprecated
    public long getProductionTime() {
        return mProductionTime;
    }

    @ApiModelProperty(value = "Array of quantity summaries for each workplace on which the operation has been executed", position = 8)
    public void setElements(List<OperationQuantitySummaryDetailPropertiesWSModel> elements) {
        mElements = elements;
    }

    public List<OperationQuantitySummaryDetailPropertiesWSModel> getElements() {
        return mElements;
    }
}