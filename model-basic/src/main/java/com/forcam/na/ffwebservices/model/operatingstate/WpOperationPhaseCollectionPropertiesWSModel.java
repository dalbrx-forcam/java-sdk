////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 08.08.2018.
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
 * Operation phase recorded properties model for workplaces.
 */
@ApiModel("wpOperationPhaseCollectionProperties")
@JsonPropertyOrder({ "startDate", "endDate", "setupPhaseDuration", "processingPhaseDuration", "occupancyTime", "elements" })
public class WpOperationPhaseCollectionPropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Start date. */
    private Date mStartDate;

    /** End date. */
    private Date mEndDate;

    /** The actual setup time of the operation in ms. Time while the operation was in the setup phase. */
    private long mSetupPhaseDuration;

    /** The actual processing time of the operation in ms. Time while the operation was in the processing phase. */
    private long mProcessingPhaseDuration;

    /** The total execution time of all operations executed at the respective workplace within the selected period in msec. */
    private long mOccupancyTime;

    private List<OperationPhaseRecordPropertiesWSModel> mElements = new ArrayList<>();

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    /**
     * Adds duration of a setup phase.
     *
     * @param duration The duration.
     */
    public void addSetupPhaseDuration(long duration) {
        mSetupPhaseDuration += duration;
    }

    /**
     * Adds duration of a processing phase.
     *
     * @param duration The duration.
     */
    public void addProcessingPhaseDuration(long duration) {
        mProcessingPhaseDuration += duration;
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Setter for {@link OperationPhaseCollectionPropertiesWSModel#mStartDate}.
     *
     * @param startDate Start date of the operation.
     */
    @ApiModelProperty(value = "Start timestamp of the selected period", position = 0)
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
    @ApiModelProperty(value = "The end date of the selected period", position = 1)
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
    @ApiModelProperty(value = "Total duration of the setup phases of all operations executed at the respective workplace within the selected period in msec.", notes = "Setup time refers to the duration of the setup phases reported at the Shop Floor Terminal. Intermediate setup during the processing phase is therefore not included.", position = 2)
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
    @ApiModelProperty(value = "Total duration of the processing phases of all operations executed at the respective workplace within the selected period in msec", position = 3)
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
     * Setter for {@link WpOperationPhaseCollectionPropertiesWSModel#mOccupancyTime}.
     *
     * @param occupancyTime The occupancy time.
     */
    @ApiModelProperty(value = "Total execution time of all operations executed at the respective workplace within the selected period in msec", position = 4)
    public void setOccupancyTime(long occupancyTime) {
        mOccupancyTime = occupancyTime;
    }

    /**
     * Getter for {@link WpOperationPhaseCollectionPropertiesWSModel#mOccupancyTime}.
     *
     * @return Occupancy time of the workplace.
     */
    public long getOccupancyTime() {
        return mOccupancyTime;
    }

    @ApiModelProperty(value = "Array of operation phase records", notes = "Ordered by startDate in reverse chronological order", position = 5)
    public void setElements(List<OperationPhaseRecordPropertiesWSModel> elements) {
        mElements = elements;
    }

    public List<OperationPhaseRecordPropertiesWSModel> getElements() {
        return mElements;
    }
}