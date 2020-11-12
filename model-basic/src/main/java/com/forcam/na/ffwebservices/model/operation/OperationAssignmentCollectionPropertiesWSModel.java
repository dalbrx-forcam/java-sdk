////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 13.09.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.operation;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;
import com.forcam.na.ffwebservices.model.DateFormatUtility;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Operation planning result collection properties model.
 */
@ApiModel(value = "operationAssignmentCollectionProperties")
@XmlRootElement(name = "operationAssignmentCollectionProperties")
@JsonPropertyOrder({ "startDate", "endDate", "numberOfWorkplaces", "scheduledOperatingTime", "plannedProcessingTime", "plannedExecutionTime",
                     "numberOfPlannedProductionOrders", "plannedLeadTime", "minimumLeadTimeWithSetup", "numberOfPartiallyPlannedProductionOrders",
                     "adherenceToDeliveryDates", "schedulingEfficiency", "occupancyRate", "setupReduction" })
public class OperationAssignmentCollectionPropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The start date. */
    private Date mStartDate;

    /** The end date. */
    private Date mEndDate;

    /** Number of workplaces. */
    private Long mNumberOfWorkplaces;

    /** Scheduled operating time. */
    private Long mScheduledOperatingTime;

    /** Planned processing time. */
    private Long mPlannedProcessingTime;

    /** Planned execution time. */
    private Long mPlannedExecutionTime;

    /** Number of planned production orders. */
    private Long mNumberOfPlannedProductionOrders;

    /** Plannable lead time. */
    private Long mPlannedLeadTime;

    /** The shortest lead time possible, taking into account the specified setup times. */
    private Long mMinimumLeadTimeWithSetup;

    /** Number of partially planned production orders. */
    private Long mNumberOfPartiallyPlannedProductionOrders;

    /** Adherence to delivery dates. */
    private Double mAdherenceToDeliveryDates;

    /** Scheduling efficiency. */
    private Double mSchedulingEfficiency;

    /** Occupancy rate. */
    private Double mOccupancyRate;

    /** Setup reduction. */
    private Double mSetupReduction;

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return ToStringUtility
            .newToStringBuilder(this)
            .appendSuper(super.toString())
            .append("startDate", DateFormatUtility.formatLogging(mStartDate))
            .append("endDate", DateFormatUtility.formatLogging(mEndDate))
            .append("adherenceToDeliveryDates", mAdherenceToDeliveryDates)
            .append("schedulingEfficiency", mSchedulingEfficiency)
            .append("occupancyRate", mOccupancyRate)
            .append("setupReduction", mSetupReduction)
            .append("numberOfPartiallyPlannedProductionOrders", mNumberOfPartiallyPlannedProductionOrders)
            .append("numberOfPlannedProductionOrders", mNumberOfPlannedProductionOrders)
            .append("numberOfWorkplaces", mNumberOfWorkplaces)
            .append("plannableLeadTime", mPlannedLeadTime)
            .append("plannedExecutionTime", mPlannedExecutionTime)
            .append("plannedProcessingTime", mPlannedProcessingTime)
            .append("scheduledOperatingTime", mScheduledOperatingTime)
            .append("minimumLeadTimeWithSetup", mMinimumLeadTimeWithSetup)
            .toString();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Getter for start date.
     *
     * @return Start date.
     */
    public Date getStartDate() {
        return mStartDate;
    }

    /**
     * Setter for start date.
     *
     * @param startDate Start date.
     */
    @ApiModelProperty(value = "Start timestamp of the planning horizon", position = 0)
    public void setStartDate(Date startDate) {
        mStartDate = startDate;
    }

    /**
     * Getter for end date.
     *
     * @return End date.
     */
    public Date getEndDate() {
        return mEndDate;
    }

    /**
     * Setter for end date.
     *
     * @param endDate End date.
     */
    @ApiModelProperty(value = "End timestamp of the planning horizon", position = 1)
    public void setEndDate(Date endDate) {
        mEndDate = endDate;
    }

    /**
     * Getter for adherence to delivery dates.
     *
     * @return Adherence to delivery dates.
     */
    public Double getAdherenceToDeliveryDates() {
        return mAdherenceToDeliveryDates;
    }

    /**
     * Setter for adherence to delivery dates.
     *
     * @param adherenceToDeliveryDates Adherence to delivery dates.
     */
    @ApiModelProperty(value = "Share of order that are not delayed among all planned orders", position = 10)
    public void setAdherenceToDeliveryDates(Double adherenceToDeliveryDates) {
        mAdherenceToDeliveryDates = adherenceToDeliveryDates;
    }

    /**
     * Getter for scheduling efficiency.
     *
     * @return Scheduling efficiency.
     */
    public Double getSchedulingEfficiency() {
        return mSchedulingEfficiency;
    }

    /**
     * Setter for scheduling efficiency.
     *
     * @param schedulingEfficiency Scheduling efficiency.
     */
    @ApiModelProperty(value = "A value between 0 and 1, which is the quotient of the minimum lead time with setup and the planned lead time of all production orders in the entire planning result", position = 11)
    public void setSchedulingEfficiency(Double schedulingEfficiency) {
        mSchedulingEfficiency = schedulingEfficiency;
    }

    /**
     * Getter for occupancy rate.
     *
     * @return Occupancy rate.
     */
    public Double getOccupancyRate() {
        return mOccupancyRate;
    }

    /**
     * Setter for occupancy rate.
     *
     * @param occupancyRate Occupancy rate.
     */
    @ApiModelProperty(value = "Quotient of the duration in which the workplaces are occupied and the scheduled operating time of the workplaces within the planning horizon", position = 12)
    public void setOccupancyRate(Double occupancyRate) {
        mOccupancyRate = occupancyRate;
    }

    /**
     * Getter for setup reduction.
     *
     * @return Setup reduction.
     */
    public Double getSetupReduction() {
        return mSetupReduction;
    }

    /**
     * Setter for setup reduction.
     *
     * @param setupReduction Setup reduction.
     */
    @ApiModelProperty(value = "Quotient of setup times and execution times of operations within the planning horizon", position = 13)
    public void setSetupReduction(Double setupReduction) {
        mSetupReduction = setupReduction;
    }

    /**
     * Provides the number of workplaces.
     *
     * @return The number of workplaces.
     */
    public Long getNumberOfWorkplaces() {
        return mNumberOfWorkplaces;
    }

    /**
     * Sets number of workplaces.
     *
     * @param numberOfWorkplaces The number of workplaces.
     */
    @ApiModelProperty(value = "Number of workplaces that are occupied in the planning scenario by the assignment of at least one operation", position = 2)
    public void setNumberOfWorkplaces(Long numberOfWorkplaces) {
        mNumberOfWorkplaces = numberOfWorkplaces;
    }

    /**
     * Provides the scheduled operating time.
     *
     * @return The scheduled operating time.
     */
    public Long getScheduledOperatingTime() {
        return mScheduledOperatingTime;
    }

    /**
     * Sets the scheduled operating time.
     *
     * @param scheduledOperatingTime The scheduled operating time.
     */
    @ApiModelProperty(value = "Sum of the scheduled operating times of all workplaces planned in the planning scenario within the planning horizon in msec", position = 3)
    public void setScheduledOperatingTime(Long scheduledOperatingTime) {
        mScheduledOperatingTime = scheduledOperatingTime;
    }

    /**
     * Provides the planned processing time.
     *
     * @return The planned processing time.
     */
    public Long getPlannedProcessingTime() {
        return mPlannedProcessingTime;
    }

    /**
     * Sets the planned processing time.
     *
     * @param plannedProcessingTime The planned processing time.
     */
    @ApiModelProperty(value = "Total processing time of all operations dispatches within the planning horizon in msec", position = 4)
    public void setPlannedProcessingTime(Long plannedProcessingTime) {
        mPlannedProcessingTime = plannedProcessingTime;
    }

    /**
     * Provides the planned execution time.
     *
     * @return The planned execution time.
     */
    public Long getPlannedExecutionTime() {
        return mPlannedExecutionTime;
    }

    /**
     * Sets planned execution time.
     *
     * @param plannedExecutionTime The planned execution time.
     */
    @ApiModelProperty(value = "Total execution time of all operations dispatches within the planning horizon in msec", position = 5)
    public void setPlannedExecutionTime(Long plannedExecutionTime) {
        mPlannedExecutionTime = plannedExecutionTime;
    }

    /**
     * Provides the number of planned production orders.
     *
     * @return The number of planned production orders.
     */
    public Long getNumberOfPlannedProductionOrders() {
        return mNumberOfPlannedProductionOrders;
    }

    /**
     * Sets number of planned production orders.
     *
     * @param numberOfPlannedProductionOrders The number of planned production orders.
     */
    @ApiModelProperty(value = "Number of completely planned production orders", notes = "A production order is completely planned if all its operations that have not yet been started or planned have been dispatched in the entire planning result.", position = 6)
    public void setNumberOfPlannedProductionOrders(Long numberOfPlannedProductionOrders) {
        mNumberOfPlannedProductionOrders = numberOfPlannedProductionOrders;
    }

    /**
     * Provides the plannable lead time.
     *
     * @return The plannable lead time.
     */
    public Long getPlannedLeadTime() {
        return mPlannedLeadTime;
    }

    /**
     * Sets the plannable lead time.
     *
     * @param plannedLeadTime The plannable lead time.
     */
    @ApiModelProperty(value = "Total lead time of all completely planned production orders", position = 7)
    public void setPlannedLeadTime(Long plannedLeadTime) {
        mPlannedLeadTime = plannedLeadTime;
    }

    /**
     * Provides the shortest lead time possible, taking into account the specified setup times.
     *
     * @return The shortest lead time possible, taking into account the specified setup times.
     */
    public Long getMinimumLeadTimeWithSetup() {
        return mMinimumLeadTimeWithSetup;
    }

    /**
     * Sets the shortest lead time possible, taking into account the specified setup times.
     *
     * @param minimumLeadTimeWithSetup The shortest lead time possible, taking into account the specified setup times.
     */
    @ApiModelProperty(value = "The shortest lead time possible, taking into account the specified setup times", position = 8)
    public void setMinimumLeadTimeWithSetup(Long minimumLeadTimeWithSetup) {
        mMinimumLeadTimeWithSetup = minimumLeadTimeWithSetup;
    }

    /**
     * Provides the number of partially planned production orders.
     *
     * @return The number of partially planned production orders.
     */
    public Long getNumberOfPartiallyPlannedProductionOrders() {
        return mNumberOfPartiallyPlannedProductionOrders;
    }

    /**
     * Sets number of partially planned production orders.
     *
     * @param numberOfPartiallyPlannedProductionOrders Number of partially planned production orders.
     */
    @ApiModelProperty(value = "The number of partially planned production orders", notes = "A production order is partially planned if some but not all operations that have not yet been started have been dispatched in the entire planning result.", position = 9)
    public void setNumberOfPartiallyPlannedProductionOrders(Long numberOfPartiallyPlannedProductionOrders) {
        mNumberOfPartiallyPlannedProductionOrders = numberOfPartiallyPlannedProductionOrders;
    }
}