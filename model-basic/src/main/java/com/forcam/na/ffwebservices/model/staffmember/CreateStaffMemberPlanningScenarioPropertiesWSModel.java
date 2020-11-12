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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Properties model for creating a staff member planning scenario.
 */
@XmlRootElement(name = "createStaffMemberPlanningScenarioProperties")
@ApiModel(value = "createStaffMemberPlanningScenarioProperties")
@JsonPropertyOrder({ "startDate", "endDate", "creator", "elements" })
public class CreateStaffMemberPlanningScenarioPropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The start date. */
    private Date mStartDate;

    /** The end date. */
    private Date mEndDate;

    /** The creator. */
    private String mCreator;

    /** The operations planning scenario ID. */
    private String mOperationsPlanningScenarioId;

    /** List of staff member assignments. */
    private List<StaffMemberAssignmentWSModel> mElements = new ArrayList<>();

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return ToStringUtility
            .newToStringBuilder(this)
            .appendSuper(super.toString())
            .append("operationsPlanningScenarioId", mOperationsPlanningScenarioId)
            .append("startDate", DateFormatUtility.formatLogging(mStartDate))
            .append("elements", mElements)
            .append("endDate", DateFormatUtility.formatLogging(mEndDate))
            .append("creator", mCreator)
            .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof CreateStaffMemberPlanningScenarioPropertiesWSModel)) {
            return false;
        }

        final CreateStaffMemberPlanningScenarioPropertiesWSModel that = (CreateStaffMemberPlanningScenarioPropertiesWSModel) o;

        return new EqualsBuilder()
            .append(this.getEndDate(), that.getEndDate())
            .append(this.getStartDate(), that.getStartDate())
            .append(this.getElements(), that.getElements())
            .append(this.getCreator(), that.getCreator())
            .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
            .append(this.getEndDate())
            .append(this.getStartDate())
            .append(this.getElements())
            .append(this.getCreator())
            .toHashCode();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

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
    @ApiModelProperty(value = "The start date of the planning scenario", required = true, position = 0)
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
    @ApiModelProperty(value = "The end date of the planning scenario", required = true, position = 1)
    public void setEndDate(Date endDate) {
        mEndDate = endDate;
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
    @ApiModelProperty(value = "The person or system that has created the planning scenario", required = true, position = 2)
    public void setCreator(String creator) {
        mCreator = creator;
    }

    /**
     * Provides the operations planning scenario ID which is referred to.
     *
     * @return The operations planning scenario ID.
     */
    public String getOperationsPlanningScenarioId() {
        return mOperationsPlanningScenarioId;
    }

    /**
     * Sets the operations planning scenario ID which is referred to.
     *
     * @param operationsPlanningScenarioId The operations planning scenario ID.
     */
    @ApiModelProperty(value = "UUID of the operation planning scenario", required = true, notes = "If the staff member planning scenario refers to a detailed operation planning scenario", position = 3)
    public void setOperationsPlanningScenarioId(String operationsPlanningScenarioId) {
        mOperationsPlanningScenarioId = operationsPlanningScenarioId;
    }

    /**
     * Provides list of staff member assignments.
     *
     * @return The list of staff member assignments.
     */
    public List<StaffMemberAssignmentWSModel> getElements() {
        return mElements;
    }

    /**
     * Sets list of staff member assignments.
     *
     * @param elements List of staff member WS models.
     */
    @ApiModelProperty(value = "Array of staff memmber assignments", required = true, position = 4)
    public void setElements(List<StaffMemberAssignmentWSModel> elements) {
        mElements = elements;
    }
}