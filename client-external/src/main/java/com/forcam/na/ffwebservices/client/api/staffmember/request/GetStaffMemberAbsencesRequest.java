package com.forcam.na.ffwebservices.client.api.staffmember.request;

import com.forcam.na.ffwebservices.client.api.pagination.request.CollectionTimestampRequest;

import java.util.Date;

/**
 * Request for person absence times.
 * <p>
 * Created: 14.03.2018
 *
 * @author Nadine Uebele nadine.uebele@forcam.com
 */
public class GetStaffMemberAbsencesRequest extends CollectionTimestampRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The staff member ID. */
    private String mStaffMemberId;

    /** The start date. */
    private Date mStartDate;

    /** The end date. */
    private Date mEndDate;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates new instance.
     *
     * @param staffMemberId The staff member ID.
     */
    public GetStaffMemberAbsencesRequest(String staffMemberId) {
        mStaffMemberId = staffMemberId;
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Provides the staff member ID.
     *
     * @return The staff member ID.
     */
    public String getStaffMemberId() {
        return mStaffMemberId;
    }

    /**
     * Sets the staff member ID.
     *
     * @param staffMemberId The staff member ID.
     */
    public void setStaffMemberId(String staffMemberId) {
        mStaffMemberId = staffMemberId;
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
