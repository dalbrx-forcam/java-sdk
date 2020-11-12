////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 18.10.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.order;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 *
 */
@ApiModel(value = "productionOrderSpecification")
@JsonPropertyOrder({ "targetQuantity", "quantityUnit", "basicStartDate", "basicEndDate", "priority" })
public class ProductionOrderSpecificationPropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The target quantity */
    private Double mTargetQuantity;

    /** The quantity unit */
    private String mQuantityUnit;

    /** The basic start date (target start date) */
    private Date mBasicStartDate;

    /** The basic end date (target end date) */
    private Date mBasicEndDate;

    /** The order priority */
    private String mPriority;

    /** The degree of parallelization. */
    private Double mDegreeOfParallelization;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    @ApiModelProperty(value = "The target yield quantity", required = false, position = 1)
    public void setTargetQuantity(Double targetQuantity) {
        mTargetQuantity = targetQuantity;
    }

    public Double getTargetQuantity() {
        return mTargetQuantity;
    }

    @ApiModelProperty(value = "The unit of the target quantity target yield quantity", required = false, position = 2)
    public void setQuantityUnit(String quantityUnit) {
        mQuantityUnit = quantityUnit;
    }

    public String getQuantityUnit() {
        return mQuantityUnit;
    }

    @ApiModelProperty(value = "Earliest start date of the production order", required = false, position = 3)
    public void setBasicStartDate(Date basicStartDate) {
        mBasicStartDate = basicStartDate;
    }

    public Date getBasicStartDate() {
        return mBasicStartDate;
    }

    @ApiModelProperty(value = "Latest end date of the production order", required = false, position = 4)
    public void setBasicEndDate(Date basicEndDate) {
        mBasicEndDate = basicEndDate;
    }

    public Date getBasicEndDate() {
        return mBasicEndDate;
    }

    @ApiModelProperty(value = "An arbitrary integer value for the priority of a production order specified in the ERP system. The highest priority is 0.", required = false, position = 5)
    public void setPriority(String priority) {
        mPriority = priority;
    }

    public String getPriority() {
        return mPriority;
    }

    public Double getDegreeOfParallelization() {
        return mDegreeOfParallelization;
    }

    @ApiModelProperty(value = "The degree of parallelization used, among other things, to determine the throughput efficiency", required = false, position = 6)
    public void setDegreeOfParallelization(Double degreeOfParallelization) {
        mDegreeOfParallelization = degreeOfParallelization;
    }
}
