////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 20.07.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.operation;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.forcam.na.ffwebservices.model.workplace.WorkplaceGeneralDefinitionWSModel;
import com.forcam.na.ffwebservices.model.workplacegroup.WorkplaceGroupPropertiesWSModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * Contains the properties of an operation specification.
 */
@ApiModel(value = "operationSpecificationProperties")
@JsonPropertyOrder({ "targetCapacityGroup", "targetWorkplace", "targetQuantity ", "plannedScrapQuantiy ", "quantityUnit ", "targetTimePerUnit ",
                     "targetMachineCycleTime ", "unitsPerMachineCycle ", "targetQueueTime", "targetSetupTime", "targetProcessingTime", "targetTeardownTime",
                     "targetWaitTime", "targetMoveTime", "minimumSendAheadQuantity", "minimumOverlapTime" })
public class OperationSpecificationPropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The targeted capacity group. */
    private WorkplaceGroupPropertiesWSModel mTargetCapacityGroup;

    /** The targeted workplace. */
    private WorkplaceGeneralDefinitionWSModel mTargetWorkplace;

    /** The targeted quantity. */
    private Double mTargetQuantity;

    /** The planned scrap quantity. */
    private Double mPlannedScrapQuantity;

    /** The quantity unit. */
    private String mQuantityUnit;

    /** The targeted time per unit. */
    private Long mTargetTimePerUnit;

    /** The targeted machine cycle time. */
    private Long mTargetMachineCycleTime;

    /** The amount of units per machine cycle. */
    private Double mUnitsPerMachineCycle;

    /** The targeted queue time. */
    private Long mTargetQueueTime;

    /** The targeted setup time. */
    private Long mTargetSetupTime;

    /** The targeted processing time. */
    private Long mTargetProcessingTime;

    /** The targeted teardown time. */
    private Long mTargetTeardownTime;

    /** The targeted wait time. */
    private Long mTargetWaitTime;

    /** The targeted move time. */
    private Long mTargetMoveTime;

    /** The minimum quantity to send ahead. */
    private Double mMinimumSendAheadQuantity;

    /** The minimum overlap time. */
    private Long mMinimumOverlapTime;

    private Date mTargetStartDate;
    private Date mTargetEndDate;
    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    @ApiModelProperty(value = "The capacity group specified in the ERP system", position = 0)
    public void setTargetCapacityGroup(WorkplaceGroupPropertiesWSModel targetCapacityGroup) {
        mTargetCapacityGroup = targetCapacityGroup;
    }

    public WorkplaceGroupPropertiesWSModel getTargetCapacityGroup() {
        return mTargetCapacityGroup;
    }

    @ApiModelProperty(position = 1, value = "Target workplace at which the operation is to be executed")
    public void setTargetWorkplace(WorkplaceGeneralDefinitionWSModel targetWorkplace) {
        mTargetWorkplace = targetWorkplace;
    }

    public WorkplaceGeneralDefinitionWSModel getTargetWorkplace() {
        return mTargetWorkplace;
    }

    @ApiModelProperty(position = 2, value = "Target yield quantity")
    public void setTargetQuantity(Double targetQuantity) {
        mTargetQuantity = targetQuantity;
    }

    public Double getTargetQuantity() {
        return mTargetQuantity;
    }

    @ApiModelProperty(value = "Planned scrap quantity", position = 3)
    public void setPlannedScrapQuantity(Double plannedScrapQuantity) {
        mPlannedScrapQuantity = plannedScrapQuantity;
    }

    public Double getPlannedScrapQuantity() {
        return mPlannedScrapQuantity;
    }

    @ApiModelProperty(position = 4)
    public void setQuantityUnit(String quantityUnit) {
        mQuantityUnit = quantityUnit;
    }

    public String getQuantityUnit() {
        return mQuantityUnit;
    }

    @ApiModelProperty(value = "Target time per unit in msec", position = 5)
    public void setTargetTimePerUnit(Long targetTimePerUnit) {
        mTargetTimePerUnit = targetTimePerUnit;
    }

    public Long getTargetTimePerUnit() {
        return mTargetTimePerUnit;
    }

    @ApiModelProperty(value = "Target machine cycles in msec", position = 6)
    public void setTargetMachineCycleTime(Long targetMachineCycleTime) {
        mTargetMachineCycleTime = targetMachineCycleTime;
    }

    public Long getTargetMachineCycleTime() {
        return mTargetMachineCycleTime;
    }

    @ApiModelProperty(value = "Number of units produced per machine cycle", position = 7)
    public void setUnitsPerMachineCycle(Double unitsPerMachineCycle) {
        mUnitsPerMachineCycle = unitsPerMachineCycle;
    }

    public Double getUnitsPerMachineCycle() {
        return mUnitsPerMachineCycle;
    }

    @ApiModelProperty(value = "Target queue time in msec", position = 8)
    public void setTargetQueueTime(Long targetQueueTime) {
        mTargetQueueTime = targetQueueTime;
    }

    public Long getTargetQueueTime() {
        return mTargetQueueTime;
    }

    @ApiModelProperty(value = "Target setup time in msec", position = 9)
    public void setTargetSetupTime(Long targetSetupTime) {
        mTargetSetupTime = targetSetupTime;
    }

    public Long getTargetSetupTime() {
        return mTargetSetupTime;
    }

    @ApiModelProperty(value = "Target processing time in msec", position = 10)
    public void setTargetProcessingTime(Long targetProcessingTime) {
        mTargetProcessingTime = targetProcessingTime;
    }

    public Long getTargetProcessingTime() {
        return mTargetProcessingTime;
    }

    @ApiModelProperty(value = "Target teardown time in msec", position = 11)
    public void setTargetTeardownTime(Long targetTeardownTime) {
        mTargetTeardownTime = targetTeardownTime;
    }

    public Long getTargetTeardownTime() {
        return mTargetTeardownTime;
    }

    @ApiModelProperty(value = "Target wait time in msec", position = 12)
    public void setTargetWaitTime(Long targetWaitTime) {
        mTargetWaitTime = targetWaitTime;
    }

    public Long getTargetWaitTime() {
        return mTargetWaitTime;
    }

    @ApiModelProperty(value = "Target move time in msec", position = 13)
    public void setTargetMoveTime(Long targetMoveTime) {
        mTargetMoveTime = targetMoveTime;
    }

    public Long getTargetMoveTime() {
        return mTargetMoveTime;
    }

    @ApiModelProperty(value = "Number of the minimum send ahead quantity", notes = "If this is greater than 0, this means that the operation can start before the previous operation has finished, but not before the minimum send ahead quantity has been produced by the previous operation", position = 14)
    public void setMinimumSendAheadQuantity(Double minimumSendAheadQuantity) {
        mMinimumSendAheadQuantity = minimumSendAheadQuantity;
    }

    public Double getMinimumSendAheadQuantity() {
        return mMinimumSendAheadQuantity;
    }

    @ApiModelProperty(value = "Duration of the minimum overlap time in msec", notes = "If this is greater than 0, this means that the operation has to start before the previous operation has finished. The latest date to start is the minimum overlap time before the end of the previous operation", position = 15)
    public void setMinimumOverlapTime(Long minimumOverlapTime) {
        mMinimumOverlapTime = minimumOverlapTime;
    }

    public Long getMinimumOverlapTime() {
        return mMinimumOverlapTime;
    }

    public void setTargetStartDate(Date targetStartDate) {
        mTargetStartDate = targetStartDate;
    }

    public Date getTargetStartDate() {
        return mTargetStartDate;
    }

    public void setTargetEndDate(Date targetEndDate) {
        mTargetEndDate = targetEndDate;
    }

    public Date getTargetEndDate() {
        return mTargetEndDate;
    }
}