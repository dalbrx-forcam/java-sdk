package com.forcam.na.ffwebservices.model.staffmember;

import com.forcam.na.ffwebservices.model.AbstractTimestampModel;
import com.forcam.na.ffwebservices.model.TimePeriodWSModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * Webservice model for staff member absence.
 * <p>
 * Created: 13.03.2018
 *
 * @author Nadine Uebele nadine.uebele@forcam.com
 */
@ApiModel(value = "staffMemberAbsence")
public class StaffMemberAbsenceWSModel extends AbstractTimestampModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Time period of the staff member absence. */
    private TimePeriodWSModel mTimePeriod;

    /** The reason. */
    private String mReason;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Sets the time period of the absence.
     *
     * @param timePeriod The time period.
     */
    @ApiModelProperty(position = 0)
    public void setTimePeriod(TimePeriodWSModel timePeriod) {
        mTimePeriod = timePeriod;
    }

    /**
     * Provides the time period of the absence.
     *
     * @return The time period.
     */
    public TimePeriodWSModel getTimePeriod() {
        return mTimePeriod;
    }

    /**
     * Sets the absence reason.
     *
     * @param reason The reason.
     */
    @ApiModelProperty(position = 1)
    public void setReason(String reason) {
        mReason = reason;
    }

    /**
     * Provides the absence reason.
     *
     * @return The reason.
     */
    public String getReason() {
        return mReason;
    }

    @Override
    public Date getPaginationDate() {
        return mTimePeriod.getStartDate();
    }
}