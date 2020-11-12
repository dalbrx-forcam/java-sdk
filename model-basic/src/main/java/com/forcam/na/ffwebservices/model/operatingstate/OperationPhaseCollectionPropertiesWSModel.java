////////////////////////////////////////////////////////////////////////////////
//
// Created by hiteshgarg on 2/1/2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.operatingstate;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Operation phase recorded properties model for webservice.
 */
@ApiModel("operationPhaseCollectionProperties")
@JsonPropertyOrder({ "startDate", "endDate", "setupPhaseDuration", "processingPhaseDuration", "executionTime", "elements" })
public class OperationPhaseCollectionPropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Start date of the operation . */
    private Date mStartDate;

    /** End date of the operation . */
    private Date mEndDate;

    /** The actual setup time of the operation in ms. Time while the operation was in the setup phase. */
    private long mSetupPhaseDuration;

    /** The actual processing time of the operation in ms. Time while the operation was in the processing phase. */
    private long mProcessingPhaseDuration;

    /** The actual processing time of the operation in ms. Sum of setup time and processing time. */
    private long mExecutionTime;

    private List<OperationPhaseRecordPropertiesWSModel> mElements = new ArrayList<>();

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Setter for {@link OperationPhaseCollectionPropertiesWSModel#mStartDate}.
     *
     * @param startDate Start date of the operation.
     */
    @ApiModelProperty(value = "Timestamp of the first execution period", notes = "This is either identical with the start timestamp of the first setup phase or the start timestamp of the first processing phase", position = 0)
    public void setStartDate(Date startDate) {
        mStartDate = startDate;
    }

    /**
     * Getter for {@link OperationPhaseCollectionPropertiesWSModel#mStartDate}.
     *
     * @return Start date of the operation.
     */
    public Date getStartDate() {
        return mStartDate;
    }

    /**
     * Setter for {@link OperationPhaseCollectionPropertiesWSModel#mEndDate}.
     *
     * @param endDate End date of the operation .
     */
    @ApiModelProperty(value = "End timestamp of the last execution period", position = 1)
    public void setEndDate(Date endDate) {
        mEndDate = endDate;
    }

    /**
     * Getter for {@link OperationPhaseCollectionPropertiesWSModel#mEndDate}.
     *
     * @return End date of the operation.
     */
    public Date getEndDate() {
        return mEndDate;
    }

    /**
     * Setter for {@link OperationPhaseCollectionPropertiesWSModel#mSetupPhaseDuration}.
     *
     * @param setupPhaseDuration The actual setup time of the operation in ms. Time while the operation was in the setup phase.
     */
    @ApiModelProperty(value = "Duration of all setup phases of the operation in msec", notes = "The setup time refers to the duration of the setup phases reported at the Shop Floor Terminal. Intermediate setup during the processing phase is therefore not included", position = 2)
    public void setSetupPhaseDuration(long setupPhaseDuration) {
        mSetupPhaseDuration = setupPhaseDuration;
    }

    /**
     * Getter for {@link OperationPhaseCollectionPropertiesWSModel#mSetupPhaseDuration}.
     *
     * @return Setup time of the operation.
     */
    public long getSetupPhaseDuration() {
        return mSetupPhaseDuration;
    }

    /**
     * Setter for {@link OperationPhaseCollectionPropertiesWSModel#mProcessingPhaseDuration}.
     *
     * @param processingPhaseDuration The actual processing time of the operation in ms. Time while the operation was in the processing phase.
     */

    @ApiModelProperty(value = "Duration of all processing phases of the operation in msec", position = 3)
    public void setProcessingPhaseDuration(long processingPhaseDuration) {
        mProcessingPhaseDuration = processingPhaseDuration;
    }

    /**
     * Getter for {@link OperationPhaseCollectionPropertiesWSModel#mProcessingPhaseDuration}.
     *
     * @return Processing time of the operation.
     */
    public long getProcessingPhaseDuration() {
        return mProcessingPhaseDuration;
    }

    /**
     * Setter for {@link OperationPhaseCollectionPropertiesWSModel#mExecutionTime}.
     *
     * @param executionTime The execution time.
     */
    @ApiModelProperty(value = "Entire execution time of the operation in msec", position = 4)
    public void setExecutionTime(long executionTime) {
        mExecutionTime = executionTime;
    }

    /**
     * Getter for {@link OperationPhaseCollectionPropertiesWSModel#mExecutionTime}.
     *
     * @return Execution time of the operation.
     */
    public long getExecutionTime() {
        return mSetupPhaseDuration + mProcessingPhaseDuration;
    }

    @ApiModelProperty(value = "Array of operation phase records", position = 5)
    public void setElements(List<OperationPhaseRecordPropertiesWSModel> elements) {
        mElements = elements;
    }

    public List<OperationPhaseRecordPropertiesWSModel> getElements() {
        return mElements;
    }
}