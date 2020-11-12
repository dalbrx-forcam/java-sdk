////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 12.11.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.staffmember;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;
import com.forcam.na.ffwebservices.model.DateFormatUtility;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Properties model of embedded staff member planning scenarios.
 */
@XmlRootElement(name = "staffMemberPlanningScenariosProperties")
@ApiModel(value = "staffMemberPlanningScenariosProperties")
@JsonPropertyOrder({ "id", "creator", "creationDate", "startDate", "endDate", "operationsPlanningScenarioId", "numberOfPlannedStaffMembers",
                     "scheduledWorkingTime", "occupancyTime", "occupancyRate", "numberOfWorkplaces", "requirementOfStaffHours",
                     "coverageOfPersonnelRequirements" })
public class StaffMemberPlanningScenariosPropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The staff member planning scenario ID. */
    private String mId;

    /** The creator. */
    private String mCreator;

    /** The creation date. */
    private Date mCreationDate;

    /** The start date of the planning horizon. */
    private Date mStartDate;

    /** The end date of the planning horizon. */
    private Date mEndDate;

    /** The operations planning scenario ID. */
    private String mOperationsPlanningScenarioId;

    /** The number of planed staff members. */
    private Long mNumberOfPlannedStaffMembers;

    /** The sum of the scheduled working times of all planned staff members within the selected time period . */
    private Long mScheduledWorkingTime;

    /** The occupancy time. */
    private Long mOccupancyTime;

    /** The occupancy rate. */
    private Double mOccupancyRate;

    /** The number of workplaces that are occupied in the selected time period by the assignment of at least one staff member. */
    private Long mNumberOfWorkplaces;

    /** The total requirement of staff hours of all workplaces within the selected time period . */
    private Long mRequirementOfStaffHours;

    /** The coverage of personnel requirements. */
    private Double mCoverageOfPersonnelRequirements;

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return ToStringUtility
            .newToStringBuilder(this)
            .appendSuper(super.toString())
            .append("id", mId)
            .append("endDate", DateFormatUtility.formatLogging(mEndDate))
            .append("creator", mCreator)
            .append("startDate", DateFormatUtility.formatLogging(mStartDate))
            .append("creationDate", DateFormatUtility.formatLogging(mCreationDate))
            .append("occupancyTime", mOccupancyTime)
            .append("occupancyRate", mOccupancyRate)
            .append("numberOfWorkplaces", mNumberOfWorkplaces)
            .append("scheduledWorkingTime", mScheduledWorkingTime)
            .append("requirementOfStaffHours", mRequirementOfStaffHours)
            .append("numberOfPlannedStaffMembers", mNumberOfPlannedStaffMembers)
            .append("operationsPlanningScenarioId", mOperationsPlanningScenarioId)
            .append("coverageOfPersonnelRequirements", mCoverageOfPersonnelRequirements)
            .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof StaffMemberPlanningScenariosPropertiesWSModel)) {
            return false;
        }

        final StaffMemberPlanningScenariosPropertiesWSModel that = (StaffMemberPlanningScenariosPropertiesWSModel) o;

        return new EqualsBuilder()
            .append(this.getId(), that.getId())
            .append(this.getCreator(), that.getCreator())
            .append(this.getEndDate(), that.getEndDate())
            .append(this.getStartDate(), that.getStartDate())
            .append(this.getCreationDate(), that.getCreationDate())
            .append(this.getOccupancyRate(), that.getOccupancyRate())
            .append(this.getOccupancyTime(), that.getOccupancyTime())
            .append(this.getNumberOfWorkplaces(), that.getNumberOfWorkplaces())
            .append(this.getScheduledWorkingTime(), that.getScheduledWorkingTime())
            .append(this.getRequirementOfStaffHours(), that.getRequirementOfStaffHours())
            .append(this.getNumberOfPlannedStaffMembers(), that.getNumberOfPlannedStaffMembers())
            .append(this.getOperationsPlanningScenarioId(), that.getOperationsPlanningScenarioId())
            .append(this.getCoverageOfPersonnelRequirements(), that.getCoverageOfPersonnelRequirements())
            .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
            .append(this.getId())
            .append(this.getCreator())
            .append(this.getEndDate())
            .append(this.getStartDate())
            .append(this.getCreationDate())
            .append(this.getOccupancyRate())
            .append(this.getOccupancyTime())
            .append(this.getNumberOfWorkplaces())
            .append(this.getScheduledWorkingTime())
            .append(this.getRequirementOfStaffHours())
            .append(this.getNumberOfPlannedStaffMembers())
            .append(this.getOperationsPlanningScenarioId())
            .append(this.getCoverageOfPersonnelRequirements())
            .toHashCode();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Provides the staff member planning scenario ID.
     *
     * @return The staff member planning scenario ID.
     */
    public String getId() {
        return mId;
    }

    /**
     * Sets the staff member planning scenario ID.
     *
     * @param id The staff member planning scenario ID.
     */
    @ApiModelProperty(value = "UUID of the staff member planning scenario", required = true, position = 0)
    public void setId(String id) {
        mId = id;
    }

    /**
     * Provides the creator.
     *
     * @return The creator.
     */
    public String getCreator() {
        return mCreator;
    }

    /**
     * Sets the creator.
     *
     * @param creator The creator.
     */
    @ApiModelProperty(value = "The person or system that has created the planning scenario", position = 1)
    public void setCreator(String creator) {
        mCreator = creator;
    }

    /**
     * Provides the creation date.
     *
     * @return The creation date.
     */
    public Date getCreationDate() {
        return mCreationDate;
    }

    /**
     * Sets the creation date.
     *
     * @param creationDate The creation date.
     */
    @ApiModelProperty(value = "Creation timestamp of the staff member planning scenario", position = 2)
    public void setCreationDate(Date creationDate) {
        mCreationDate = creationDate;
    }

    /**
     * Provides the start date.
     *
     * @return The start date.
     */
    public Date getStartDate() {
        return mStartDate;
    }

    /**
     * Sets the start date.
     *
     * @param startDate The start date.
     */
    @ApiModelProperty(value = "The start date of the planning horizon", position = 3)
    public void setStartDate(Date startDate) {
        mStartDate = startDate;
    }

    /**
     * Provides the end date.
     *
     * @return The end date.
     */
    public Date getEndDate() {
        return mEndDate;
    }

    /**
     * Sets the end date.
     *
     * @param endDate The end date.
     */
    @ApiModelProperty(value = "The end date of the planning horizon", position = 4)
    public void setEndDate(Date endDate) {
        mEndDate = endDate;
    }

    /**
     * Provides the operations planning scenario ID.
     *
     * @return The operations planning scenario ID.
     */
    public String getOperationsPlanningScenarioId() {
        return mOperationsPlanningScenarioId;
    }

    /**
     * Sets the operations planning scenario ID.
     *
     * @param operationsPlanningScenarioId The operations planning scenario ID.
     */
    @ApiModelProperty(value = "If the planning scenario refers to an operation planning scenario, its UUID must be specified here (operations/planningScenario/{planningScenarioId})", position = 5)
    public void setOperationsPlanningScenarioId(String operationsPlanningScenarioId) {
        mOperationsPlanningScenarioId = operationsPlanningScenarioId;
    }

    /**
     * Provides the number of planned staff members.
     *
     * @return The number of planned staff members.
     */
    public Long getNumberOfPlannedStaffMembers() {
        return mNumberOfPlannedStaffMembers;
    }

    /**
     * Sets the number of planned staff members.
     *
     * @param numberOfPlannedStaffMembers The number of planned staff members.
     */
    @ApiModelProperty(value = "Number of planned staff members within the selected time period", position = 6)
    public void setNumberOfPlannedStaffMembers(Long numberOfPlannedStaffMembers) {
        mNumberOfPlannedStaffMembers = numberOfPlannedStaffMembers;
    }

    /**
     * Provides the scheduled working time.
     *
     * @return The scheduled working time.
     */
    public Long getScheduledWorkingTime() {
        return mScheduledWorkingTime;
    }

    /**
     * Sets the scheduled working time.
     *
     * @param scheduledWorkingTime The scheduled working time.
     */
    @ApiModelProperty(value = "The sum of the scheduled working times of all planned staff members within the selected time period (i.e. during the period from startDate to endDate) in msec", position = 7)
    public void setScheduledWorkingTime(Long scheduledWorkingTime) {
        mScheduledWorkingTime = scheduledWorkingTime;
    }

    /**
     * Provides the occupancy time.
     *
     * @return The occupancy time.
     */
    public Long getOccupancyTime() {
        return mOccupancyTime;
    }

    /**
     * Sets the occupancy time.
     *
     * @param occupancyTime The occupancy time.
     */
    @ApiModelProperty(value = "Sum of the occupancy times of all planned staff members within the selected time period of this planning scenario in msec.", notes = "A staff member's occupancy time is the time in which the staff member is assigned to one or more workplaces with maximum capacity. Time periods in which the staff members are only working at part of their capacity are multiplied by the capacity assigned.", position = 8)
    public void setOccupancyTime(Long occupancyTime) {
        mOccupancyTime = occupancyTime;
    }

    /**
     * Provides the occupancy rate.
     *
     * @return The occupancy rate.
     */
    public Double getOccupancyRate() {
        return mOccupancyRate;
    }

    /**
     * Sets the occupancy rate.
     *
     * @param occupancyRate The occupancy rate.
     */
    @ApiModelProperty(value = "A value between 0 and 1, which is the quotient of the occupancy time of all planned staff members within the selected time period and the scheduled working time of these staff members within the selected time period", position = 9, allowableValues = "range[0,1]", example = "0.1")
    public void setOccupancyRate(Double occupancyRate) {
        mOccupancyRate = occupancyRate;
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
     * Sets the number of workplaces.
     *
     * @param numberOfWorkplaces The number of workplaces.
     */
    @ApiModelProperty(value = "Number of workplaces that are occupied in the selected time period by the assignment of at least one staff member", position = 10)
    public void setNumberOfWorkplaces(Long numberOfWorkplaces) {
        mNumberOfWorkplaces = numberOfWorkplaces;
    }

    /**
     * Provides the requirement of staff hours.
     *
     * @return The requirement of staff hours.
     */
    public Long getRequirementOfStaffHours() {
        return mRequirementOfStaffHours;
    }

    /**
     * Sets the requirement of staff hours.
     *
     * @param requirementOfStaffHours The requirement of staff hours.
     */
    @ApiModelProperty(value = "Total requirement of staff hours of all workplaces within the selected time period in msec", position = 11)
    public void setRequirementOfStaffHours(Long requirementOfStaffHours) {
        mRequirementOfStaffHours = requirementOfStaffHours;
    }

    /**
     * Provides the coverage of personnel requirements.
     *
     * @return The coverage of personnel requirements.
     */
    public Double getCoverageOfPersonnelRequirements() {
        return mCoverageOfPersonnelRequirements;
    }

    /**
     * Sets the coverage of personnel requirements.
     *
     * @param coverageOfPersonnelRequirements The coverage of personnel requirements.
     */
    @ApiModelProperty(value = "Coverage of personnel requirements", notes = "Quotient of the occupancy time of all staff members and the total requirement of staff hours.", position = 12)
    public void setCoverageOfPersonnelRequirements(Double coverageOfPersonnelRequirements) {
        mCoverageOfPersonnelRequirements = coverageOfPersonnelRequirements;
    }
}