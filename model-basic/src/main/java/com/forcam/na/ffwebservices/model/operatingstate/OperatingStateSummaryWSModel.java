////////////////////////////////////////////////////////////////////////////////
//
// Created by hiteshgarg on 2/14/2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.operatingstate;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.forcam.na.ffwebservices.model.statusdefinition.OperatingStateGeneralDefinitionWSModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Operating state summary webservice model.
 */
@ApiModel(value = "recordedOperatingStateSummary")
@JsonPropertyOrder({ "operatingState", "duration", "frequency" })
public class OperatingStateSummaryWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The operating state. */
    private OperatingStateGeneralDefinitionWSModel mOperatingState;
    /** The entire duration of the operating state during the execution of the operation in msec. */
    private Long mDuration;
    /** The frequency of the operating state during the execution of the operation. */
    private Integer mFrequency;

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final OperatingStateSummaryWSModel that = (OperatingStateSummaryWSModel) o;

        final EqualsBuilder builder = new EqualsBuilder();
        builder.append(mOperatingState, that.mOperatingState);
        builder.append(mDuration, that.mDuration);
        builder.append(mFrequency, that.mFrequency);

        return builder.isEquals();
    }

    @Override
    public int hashCode() {
        final HashCodeBuilder builder = new HashCodeBuilder();
        builder.append(mOperatingState);
        builder.append(mDuration);
        builder.append(mFrequency);
        return builder.hashCode();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Setter for {@link OperatingStateSummaryWSModel#mOperatingState}.
     *
     * @param operatingState The operating state.
     */
    @ApiModelProperty(value = "Operating state that has occurred", position = 0)
    public void setOperatingState(OperatingStateGeneralDefinitionWSModel operatingState) {
        mOperatingState = operatingState;
    }

    /**
     * Getter for {@link OperatingStateSummaryWSModel#mOperatingState}.
     *
     * @return The operating state.
     */
    public OperatingStateGeneralDefinitionWSModel getOperatingState() {
        return mOperatingState;
    }

    /**
     * Setter for {@link OperatingStateSummaryWSModel#mDuration}.
     *
     * @param duration The entire duration of the operating state during the execution of the operation in msec.
     */
    @ApiModelProperty(value = "Total duration of the operating state during the execution of the operation in msec", position = 1)
    public void setDuration(Long duration) {
        mDuration = duration;
    }

    /**
     * Getter for {@link OperatingStateSummaryWSModel#mDuration}.
     *
     * @return The entire duration of the operating state during the execution of the operation in msec.
     */
    public Long getDuration() {
        return mDuration;
    }

    /**
     * Setter for {@link OperatingStateSummaryWSModel#mFrequency}.
     *
     * @param frequency The frequency of the operating state during the execution of the operation.
     */
    @ApiModelProperty(value = "Frequency of the operating state during the execution of the operation", position = 2)
    public void setFrequency(Integer frequency) {
        mFrequency = frequency;
    }

    /**
     * Getter for {@link OperatingStateSummaryWSModel#mFrequency}.
     *
     * @return The frequency of the operating state during the execution of the operation.
     */
    public Integer getFrequency() {
        return mFrequency;
    }
}