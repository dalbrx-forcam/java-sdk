////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 23.10.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.staffmember;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Properties model for staff member planning results.
 */
@ApiModel(value = "staffMemberPlanningResultCollectionProperties")
@JsonPropertyOrder({ "startDate", "endDate", "numberOfPlannedStaffMembers", "scheduledWorkingTime", "occupancyTime", "occupancyRate", "numberOfWorkplaces",
                     "requirementOfStaffHours", "coverageOfPersonnelRequirements", "elements" })
public class StaffMemberPlanningResultCollectionProperties {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The start date. */
    private Date mStartDate;

    /** The end date. */
    private Date mEndDate;

    /** Number of planned staff members. */
    private long mNumberOfPlannedStaffMembers;

    /** Scheduled working time. */
    private long mScheduledWorkingTime;

    /** Occupancy time. */
    private long mOccupancyTime;

    /** The occupancy rate. */
    private Double mOccupancyRate;

    /** Number of workplaces. */
    private long mNumberOfWorkplaces;

    /** The requirement of staff hours. */
    private long mRequirementOfStaffHours;

    /** Coverage of personnel requirements */
    private Double mCoverageOfPersonnelRequirements;

    /** List of staff member assignments. */
    private List<StaffMemberAssignmentWSModel> mElements = new ArrayList<>();

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public Date getStartDate() {
        return mStartDate;
    }

    @ApiModelProperty(value = "Start timestamp of the selected time period", position = 0)
    public void setStartDate(Date startDate) {
        mStartDate = startDate;
    }

    public Date getEndDate() {
        return mEndDate;
    }

    @ApiModelProperty(value = "End timestamp of the selected time period", position = 1)
    public void setEndDate(Date endDate) {
        mEndDate = endDate;
    }

    public long getNumberOfPlannedStaffMembers() {
        return mNumberOfPlannedStaffMembers;
    }

    @ApiModelProperty(value = "Number of planned staff members within the selected time period", position = 2)
    public void setNumberOfPlannedStaffMembers(long numberOfPlannedStaffMembers) {
        mNumberOfPlannedStaffMembers = numberOfPlannedStaffMembers;
    }

    public long getScheduledWorkingTime() {
        return mScheduledWorkingTime;
    }

    @ApiModelProperty(value = "Sum of the scheduled working times of all planned staff members within the selected period in msec", position = 3)
    public void setScheduledWorkingTime(long scheduledWorkingTime) {
        mScheduledWorkingTime = scheduledWorkingTime;
    }

    public long getOccupancyTime() {
        return mOccupancyTime;
    }

    @ApiModelProperty(value = "Sum of the occupancy times of all planned staff members within the selected time period", position = 4)
    public void setOccupancyTime(long occupancyTime) {
        mOccupancyTime = occupancyTime;
    }

    public Double getOccupancyRate() {
        return mOccupancyRate;
    }

    @ApiModelProperty(value = "Quotient of the occupancy time of all planned staff members and the scheduled working time of these staff members within the selected time period", position = 5)
    public void setOccupancyRate(Double occupancyRate) {
        mOccupancyRate = occupancyRate;
    }

    public long getNumberOfWorkplaces() {
        return mNumberOfWorkplaces;
    }

    @ApiModelProperty(value = "The number of workplaces that are occupied in the selected time period by the assignment of at least one staff member", position = 6)
    public void setNumberOfWorkplaces(long numberOfWorkplaces) {
        mNumberOfWorkplaces = numberOfWorkplaces;
    }

    public long getRequirementOfStaffHours() {
        return mRequirementOfStaffHours;
    }

    @ApiModelProperty(value = "The total requirement of staff hours of all workplaces, within the selected time period (i.e. during the period from startDate to endDate) in msec", position = 7)
    public void setRequirementOfStaffHours(long requirementOfStaffHours) {
        mRequirementOfStaffHours = requirementOfStaffHours;
    }

    public Double getCoverageOfPersonnelRequirements() {
        return mCoverageOfPersonnelRequirements;
    }

    @ApiModelProperty(value = "Coverage of personnel requirements.\nQuotient of the occupancy time of all staff members and the total requirement of staff hours", position = 8)
    public void setCoverageOfPersonnelRequirements(Double coverageOfPersonnelRequirements) {
        mCoverageOfPersonnelRequirements = coverageOfPersonnelRequirements;
    }

    public List<StaffMemberAssignmentWSModel> getElements() {
        return mElements;
    }

    @ApiModelProperty(value = "Array of staff member assignments", position = 9)
    public void setElements(List<StaffMemberAssignmentWSModel> elements) {
        mElements = elements;
    }
}