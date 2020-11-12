////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 28.06.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.operation;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;
import com.forcam.na.ffwebservices.model.DateFormatUtility;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.List;

/**
 * Request body properties for setting planning scenarios.
 */
@XmlRootElement(name = "operationPlanningScenarioBodyProperties")
@ApiModel(value = "operationPlanningScenarioBodyProperties")
@JsonPropertyOrder({ "startDate", "endDate", "creator", "assignments" })
public class OperationPlanningScenariosBodyWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The start date. */
    private Date mStartDate;

    /** The end date. */
    private Date mEndDate;

    /** The person or system who has created the planning scenario. */
    private String mCreator;

    /** Operation planning scenario assignment properties. */
    private List<OperationAssignmentWSModel> mAssignments;

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return ToStringUtility
            .newToStringBuilder(this)
            .appendSuper(super.toString())
            .append("assignment", mAssignments)
            .append("startDate", DateFormatUtility.formatLogging(mStartDate))
            .append("endDate", DateFormatUtility.formatLogging(mEndDate))
            .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof OperationPlanningScenariosBodyWSModel)) {
            return false;
        }

        final OperationPlanningScenariosBodyWSModel that = (OperationPlanningScenariosBodyWSModel) o;

        return new EqualsBuilder()
            .append(this.getEndDate(), that.getEndDate())
            .append(this.getStartDate(), that.getStartDate())
            .append(this.getAssignments(), that.getAssignments())
            .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
            .append(this.getEndDate())
            .append(this.getStartDate())
            .append(this.getAssignments())
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
    @ApiModelProperty(value = "Start timestamp of the operation planning scenario", required = true, position = 0)
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
    @ApiModelProperty(value = "End timestamp of the operation planning scenario", required = true, position = 1)
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
    @ApiModelProperty(value = "The person or system that has created the operation planning scenario", position = 2)
    public void setCreator(String creator) {
        mCreator = creator;
    }

    /**
     * Provides list of operation planning scenario assignments.
     *
     * @return List of operation planning scenario assignment WS models.
     */
    public List<OperationAssignmentWSModel> getAssignments() {
        return mAssignments;
    }

    /**
     * Sets list of operation planning scenario assignments.
     *
     * @param assignments List of operation planning scenario assignment WS models.
     */
    @ApiModelProperty(value = "Array of operation assignments", position = 3, required = true)
    public void setAssignments(List<OperationAssignmentWSModel> assignments) {
        mAssignments = assignments;
    }
}
