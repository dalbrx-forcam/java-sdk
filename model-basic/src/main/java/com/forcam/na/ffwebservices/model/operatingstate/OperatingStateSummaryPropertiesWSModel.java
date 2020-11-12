////////////////////////////////////////////////////////////////////////////////
//
// Created by hiteshgarg on 2/14/2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.operatingstate;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Operating state summary properties webservice model.
 */
@JsonPropertyOrder({ "executionTime", "processingTime", "productionTime", "setupTime", "setupReduction", "processAvailability", "elements" })
public class OperatingStateSummaryPropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The total execution time of the operation in msec. */
    private long mExecutionTime;

    /** The total processing time of the operation in msec. This is the execution time minus the setup time. */
    private long mProcessingTime;

    /** The total production time of the operation in msec. The production time is the sum of the durations of all operating states assigned to the production time base. */
    private long mProductionTime;

    /**
     * The total setup time of the operation in msec. The setup time is the sum of the durations of all operating states assigned to the setup time base.
     * It also includes intermediate setup during the processing phase.
     */
    private long mSetupTime;

    /** The setup reduction of the operation. It has a value between 0 and 1, which is the quotient of the processing time and execution time. */
    private double mSetupReduction;

    /** The process availability of the operation. It has a value between 0 and 1, which is the quotient of the production time and the processing time. */
    private double mProcessAvailability;

    /** The operating state summary models. */
    private List<OperatingStateSummaryWSModel> mElements = new ArrayList<>();

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Setter for {@link OperatingStateSummaryPropertiesWSModel#mExecutionTime}.
     *
     * @param executionTime The execution time.
     */
    @ApiModelProperty(value = "Total execution time of the operation in msec", position = 0)
    public void setExecutionTime(long executionTime) {
        mExecutionTime = executionTime;
    }

    /**
     * Getter for {@link OperatingStateSummaryPropertiesWSModel#mExecutionTime}.
     *
     * @return Get operation execution time.
     */
    public long getExecutionTime() {
        return mExecutionTime;
    }

    @ApiModelProperty(value = "Total processing time of the operation in msec", notes = "This is the execution time minus the setup time", position = 1)
    public void setProcessingTime(long processingTime) {
        mProcessingTime = processingTime;
    }

    public long getProcessingTime() {
        return mProcessingTime;
    }

    /**
     * Setter for {@link OperatingStateSummaryPropertiesWSModel#mProductionTime}.
     *
     * @param productionTime Operation total production time.
     */
    @ApiModelProperty(value = "Total production time of the operation in msec", notes = "Production time is the sum of the durations of all operating states assigned to the production time base", position = 2)
    public void setProductionTime(long productionTime) {
        mProductionTime = productionTime;
    }

    /**
     * Getter for {@link OperatingStateSummaryPropertiesWSModel#mProductionTime}.
     *
     * @return Operation total production time.
     */
    public long getProductionTime() {
        return mProductionTime;
    }

    /**
     * Setter for {@link OperatingStateSummaryPropertiesWSModel#mSetupTime}.
     *
     * @param setupTime Operation total time in setup phase.
     */
    @ApiModelProperty(value = "Total setup time of the operation in msec", notes = "Setup time is the sum of the durations of all operating states assigned to the setup time base.\nIt also includes intermediate setup during the processing phase", position = 3)
    public void setSetupTime(long setupTime) {
        mSetupTime = setupTime;
    }

    /**
     * Getter for {@link OperatingStateSummaryPropertiesWSModel#mSetupTime}.
     *
     * @return Operation total time in setup phase.
     */
    public long getSetupTime() {
        return mSetupTime;
    }

    @ApiModelProperty(value = "Setup reduction of an operation", allowableValues = "range[0,1]", example = "0.1", position = 4)
    public void setSetupReduction(double setupReduction) {
        mSetupReduction = setupReduction;
    }

    public double getSetupReduction() {
        return mSetupReduction;
    }

    @ApiModelProperty(value = "Process availability of an operation", position = 5)
    public void setProcessAvailability(double processAvailability) {
        mProcessAvailability = processAvailability;
    }

    public double getProcessAvailability() {
        return mProcessAvailability;
    }

    @ApiModelProperty(value = "Array of operating state summaries with durations greater than zero", position = 6)
    public void setElements(List<OperatingStateSummaryWSModel> elements) {
        mElements = elements;
    }

    public List<OperatingStateSummaryWSModel> getElements() {
        return mElements;
    }
}