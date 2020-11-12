////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 20.09.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.command.operation;

import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;
import com.forcam.na.ffwebservices.model.command.AbstractCommandRequest;
import io.swagger.annotations.ApiModelProperty;

/**
 * An operation quantity command model.
 */
public class OperationQuantityCommandRequest extends AbstractCommandRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Operation uuid. */
    private String mOperationId;
    /** Workplace uuid. */
    private String mWorkplaceId;
    /** Quantity amount to be booked. */
    private double mQuantity;
    /** Reason uuid for the quantity. */
    private String mQualityDetailId;
    /** Annotation. */
    private String mAnnotation;
    /** Person uuid. */
    private String mStaffMemberId;
    /** Ticket uuid. */
    private String mTicketId;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates an operation quantity command model.
     *
     * @param operationId     The operation id.
     * @param workplaceId     The workplace id.
     * @param quantity        The quantity.
     * @param qualityDetailId The id of the quality detail.
     */
    public OperationQuantityCommandRequest(String operationId, String workplaceId, double quantity, String qualityDetailId) {
        mOperationId = operationId;
        mWorkplaceId = workplaceId;
        mQuantity = quantity;
        mQualityDetailId = qualityDetailId;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return ToStringUtility
            .newToStringBuilder(this)
            .append("operationId", mOperationId)
            .append("workplaceId", mWorkplaceId)
            .append("quantityAmount", mQuantity)
            .append("qualityDetailId", mQualityDetailId)
            .append("annotation", mAnnotation)
            .append("staffMemberId", mStaffMemberId)
            .append("ticketId", mTicketId)
            .toString();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public String getOperationId() {
        return mOperationId;
    }

    @ApiModelProperty(value = "UUID of the operation,", required = true, position = 1)
    public void setOperationId(String operationId) {
        mOperationId = operationId;
    }

    public String getWorkplaceId() {
        return mWorkplaceId;
    }

    @ApiModelProperty(value = "UUID of the workplace.", required = true, position = 2)
    public void setWorkplaceId(String workplaceId) {
        mWorkplaceId = workplaceId;
    }

    public String getAnnotation() {
        return mAnnotation;
    }

    @ApiModelProperty(value = "The annotation for the operation quantity.", required = false, position = 5)
    public void setAnnotation(String annotation) {
        mAnnotation = annotation;
    }

    public String getTicketId() {
        return mTicketId;
    }

    public String getQualityDetailId() {
        return mQualityDetailId;
    }

    @ApiModelProperty(value = "UUID of the quantity reason.", required = true, position = 4)
    public void setQualityDetailId(String qualityDetailId) {
        mQualityDetailId = qualityDetailId;
    }

    public double getQuantity() {
        return mQuantity;
    }

    @ApiModelProperty(value = "The quantity amount which has to be booked for the operation.", required = true, position = 3)
    public void setQuantity(double quantity) {
        mQuantity = quantity;
    }

    @ApiModelProperty(value = "UUID of the ticket.", required = false, position = 7)
    public void setTicketId(String ticketId) {
        mTicketId = ticketId;
    }

    public void setStaffMemberId(String staffMemberId) {
        mStaffMemberId = staffMemberId;
    }

    public String getStaffMemberId() {
        return mStaffMemberId;
    }
}
