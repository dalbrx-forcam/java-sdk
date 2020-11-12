package com.forcam.na.ffwebservices.client.api.workplace.request;

import com.forcam.na.ffwebservices.client.api.pagination.request.CollectionRequest;
import com.forcam.na.ffwebservices.model.definition.TimeBaseFilter;
import com.forcam.na.ffwebservices.model.definition.WorkplaceState;

import java.util.Date;

/**
 * Request params for getting operating state summary of a workplace.
 * <p>
 * Created: 05.04.2018
 *
 * @author Nadine Uebele nadine.uebele@forcam.com
 */
public class GetOperatingStateSummaryRequest extends CollectionRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The workplace ID. */
    private String mWorkplaceId;

    /** The workplace state ID. */
    private WorkplaceState mWorkplaceStateId;

    /** The operating state class ID. */
    private String mOperatingStateClassId;

    /** The time base. */
    private TimeBaseFilter mTimeBase;

    /** The workplace shift ID. */
    private String mShiftId;

    /** The start date. */
    private Date mStartDate;

    /** The end date. */
    private Date mEndDate;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates new instance with workplace ID.
     *
     * @param workplaceId The workplace ID.
     */
    public GetOperatingStateSummaryRequest(String workplaceId) {
        mWorkplaceId = workplaceId;
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Provides the workplace shift ID.
     *
     * @return The shift ID.
     */
    public String getShiftId() {
        return mShiftId;
    }

    /**
     * Sets the workplace shift ID.
     *
     * @param shiftId The shift ID.
     */
    public void setShiftId(String shiftId) {
        mShiftId = shiftId;
    }

    /**
     * Provides the workplace ID.
     *
     * @return The workplace ID.
     */
    public String getWorkplaceId() {
        return mWorkplaceId;
    }

    /**
     * Sets the workplace ID.
     *
     * @param workplaceId The workplace ID.
     */
    public void setWorkplaceId(String workplaceId) {
        mWorkplaceId = workplaceId;
    }

    /**
     * Provides the workplace state ID.
     *
     * @return The workplace state ID.
     */
    public WorkplaceState getWorkplaceStateId() {
        return mWorkplaceStateId;
    }

    /**
     * Sets the workplace state ID.
     *
     * @param workplaceStateId The workplace state ID.
     */
    public void setWorkplaceStateId(WorkplaceState workplaceStateId) {
        mWorkplaceStateId = workplaceStateId;
    }

    /**
     * Provides the operating state class ID.
     *
     * @return The operating state class ID.
     */
    public String getOperatingStateClassId() {
        return mOperatingStateClassId;
    }

    /**
     * Sets the operating state class ID.
     *
     * @param operatingStateClassId The operating state class ID.
     */
    public void setOperatingStateClassId(String operatingStateClassId) {
        mOperatingStateClassId = operatingStateClassId;
    }

    /**
     * Provides the time base.
     *
     * @return The time base.
     */
    public TimeBaseFilter getTimeBase() {
        return mTimeBase;
    }

    /**
     * Sets the time base.
     *
     * @param timeBase The time base.
     */
    public void setTimeBase(TimeBaseFilter timeBase) {
        mTimeBase = timeBase;
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
    public void setEndDate(Date endDate) {
        mEndDate = endDate;
    }
}
