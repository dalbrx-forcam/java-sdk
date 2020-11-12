package com.forcam.na.ffwebservices.model.workplace;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.forcam.na.ffwebservices.model.operatingstate.OperatingStateSummaryWSModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Operating state summary properties of a workplace.
 * <p>
 * Created: 04.04.2018
 *
 * @author Nadine Uebele nadine.uebele@forcam.com
 */
@JsonPropertyOrder({ "scheduledOperatingTime", "occupancyTime", "processingTime", "productionTime", "setupTime", "occupancyRate", "setupReduction",
                     "processAvailability", "availability", "elements" })
public class WpOperatingStateSummaryPropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The scheduled operating time of the workplace in msec. Sum of the durations of all operating states which belong to the time base SCHEDULED_OPERATING_TIME. */
    private Long mScheduledOperatingTime;

    /** The total execution time of all operations executed at the respective workplace within the selected period in msec. */
    private Long mOccupancyTime;

    /** The total processing time of the workplace during the selected period in msec. This is the occupancy time minus the setup time. */
    private Long mProcessingTime;

    /** The actual production time of the workplace in msec. Time while the workplace was in the production phase. */
    private Long mProductionTime;

    /** The actual setup time of the workplace in msec. Time while the workplace was in the setup phase. */
    private Long mSetupTime;

    /**
     * The occupancy rate of the workplace during the selected period.
     * It is a value between 0 and 1, which is the quotient of the occupancy time and the scheduled operating time.
     */
    private double mOccupancyRate;

    /**
     * The setup reduction of the workplace during the selected period.
     * It has a value between 0 and 1, which is the quotient of the processing time and occupancy time.
     */
    private double mSetupReduction;

    /**
     * The process availability of the workplace during the selected period.
     * It has a value between 0 and 1, which is the quotient of the production time and the processing time.
     */
    private double mProcessAvailability;

    /**
     * The availability of the workplace during the selected period.
     * It has a value between 0 and 1, which is the quotient of the production time and the scheduled operating time.
     */
    private double mAvailability;

    /** The operating state summary models. */
    private List<OperatingStateSummaryWSModel> mElements = new ArrayList<>();

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Setter for {@link WpOperatingStateSummaryPropertiesWSModel#mScheduledOperatingTime}.
     *
     * @param scheduledOperatingTime The scheduled operating time.
     */
    @ApiModelProperty(value = "Scheduled operating time of the workplace during the selected period in msec", position = 0)
    public void setScheduledOperatingTime(Long scheduledOperatingTime) {
        mScheduledOperatingTime = scheduledOperatingTime;
    }

    /**
     * Getter for {@link WpOperatingStateSummaryPropertiesWSModel#mScheduledOperatingTime}.
     *
     * @return The scheduled operating time.
     */
    public Long getScheduledOperatingTime() {
        return mScheduledOperatingTime;
    }

    @ApiModelProperty(value = "Total execution time of all operations executed at the respective workplace within the selected period in msec", position = 1)
    public void setOccupancyTime(Long occupancyTime) {
        mOccupancyTime = occupancyTime;
    }

    public Long getOccupancyTime() {
        return mOccupancyTime;
    }

    @ApiModelProperty(value = "Total processing time of the workplace during the selected period in msec", notes = "Occupancy time minus the the setup time", position = 2)
    public void setProcessingTime(Long processingTime) {
        mProcessingTime = processingTime;
    }

    public Long getProcessingTime() {
        return mProcessingTime;
    }

    /**
     * Setter for {@link WpOperatingStateSummaryPropertiesWSModel#mProductionTime}.
     *
     * @param productionTime Workplace total production time.
     */
    @ApiModelProperty(value = "Total production time of the workplace during the selected period in msec", notes = "Sum of the durations of all operating states assigned to the production time base", position = 3)
    public void setProductionTime(Long productionTime) {
        mProductionTime = productionTime;
    }

    /**
     * Getter for {@link WpOperatingStateSummaryPropertiesWSModel#mProductionTime}.
     *
     * @return Workplace total production time.
     */
    public Long getProductionTime() {
        return mProductionTime;
    }

    /**
     * Setter for {@link WpOperatingStateSummaryPropertiesWSModel#mSetupTime}.
     *
     * @param setupTime Workplace total time in setup phase.
     */
    @ApiModelProperty(value = "Total setup time during the selected period in msec", notes = "Sum of the durations of all operating states assigned to the setup time base. It also includes intermediate setup during the processing phase", position = 4)
    public void setSetupTime(Long setupTime) {
        mSetupTime = setupTime;
    }

    /**
     * Getter for {@link WpOperatingStateSummaryPropertiesWSModel#mSetupTime}.
     *
     * @return Workplace total time in setup phase.
     */
    public Long getSetupTime() {
        return mSetupTime;
    }

    @ApiModelProperty(value = "Occupancy rate of the workplace during the selected period", notes = "Quotient of the occupancy time and the scheduled operating time", allowableValues = "range[0,1]", position = 5)
    public void setOccupancyRate(double occupancyRate) {
        mOccupancyRate = occupancyRate;
    }

    public double getOccupancyRate() {
        return mOccupancyRate;
    }

    @ApiModelProperty(value = "Setup reduction of the workplace during the selected period", notes = "Quotient of the processing time and occupancy time", allowableValues = "range[0,1]", position = 6)
    public void setSetupReduction(double setupReduction) {
        mSetupReduction = setupReduction;
    }

    public double getSetupReduction() {
        return mSetupReduction;
    }

    @ApiModelProperty(value = "Process availability of the workplace during the selected period", notes = "Quotient of the production time and the processing time", allowableValues = "range[0,1]", position = 7)
    public void setProcessAvailability(double processAvailability) {
        mProcessAvailability = processAvailability;
    }

    public double getProcessAvailability() {
        return mProcessAvailability;
    }

    @ApiModelProperty(value = "Availability of the workplace during the selected period", notes = "Quotient of the production time and the scheduled operating time", allowableValues = "range[0,1]", position = 8)
    public void setAvailability(double availability) {
        mAvailability = availability;
    }

    public double getAvailability() {
        return mAvailability;
    }

    /**
     * Setter for {@link WpOperatingStateSummaryPropertiesWSModel#mElements}.
     *
     * @param elements List of operating state summary WS models.
     */
    @ApiModelProperty(value = "Array of operating state summaries with duration greater than zero", position = 9)
    public void setElements(List<OperatingStateSummaryWSModel> elements) {
        mElements = elements;
    }

    /**
     * Getter for {@link WpOperatingStateSummaryPropertiesWSModel#mElements}.
     *
     * @return The list of operating state summary WS models.
     */
    public List<OperatingStateSummaryWSModel> getElements() {
        return mElements;
    }
}