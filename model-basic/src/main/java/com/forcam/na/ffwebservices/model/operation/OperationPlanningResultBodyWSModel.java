////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 13.09.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.operation;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Operation planning result body model.
 */
@XmlRootElement(name = "operationPlanningResultBodyProperties")
@ApiModel(value = "operationPlanningResultBodyProperties")
public class OperationPlanningResultBodyWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Operation planning result assignment properties. */
    private List<OperationAssignmentWSModel> mAssignments;

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return ToStringUtility.newToStringBuilder(this)
            .appendSuper(super.toString())
            .append("assignment", mAssignments)
            .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof OperationPlanningResultBodyWSModel)) {
            return false;
        }

        final OperationPlanningResultBodyWSModel that = (OperationPlanningResultBodyWSModel) o;

        return new EqualsBuilder()
            .append(this.getAssignments(), that.getAssignments())
            .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
            .append(this.getAssignments())
            .toHashCode();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Sets list of operation planning result assignments.
     *
     * @param assignments List of operation planning result assignment WS models.
     */
    @ApiModelProperty(value = "Array of operation assignments")
    public void setAssignments(List<OperationAssignmentWSModel> assignments) {
        mAssignments = assignments;
    }

    /**
     * Provides list of operation planning result assignments.
     *
     * @return List of operation planning result assignment WS models.
     */
    public List<OperationAssignmentWSModel> getAssignments() {
        return mAssignments;
    }
}