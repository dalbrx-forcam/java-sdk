package com.forcam.na.ffwebservices.model.command.operation;

import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;
import com.forcam.na.ffwebservices.model.command.AbstractCommandDataWSModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Operation quantity command model for web services.
 */
@ApiModel(value = "operationQuantityCommand", parent = AbstractCommandDataWSModel.class)
public class OperationQuantityCommandDataWsModel extends AbstractCommandDataWSModel {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------

    /** The name as a constant string. */
    public static final String NAME = "OPERATION_QUANTITY";

    private static final long serialVersionUID = -1705921608105989817L;

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
     * Creates a new instance.
     */
    public OperationQuantityCommandDataWsModel() {
        super(NAME);
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return ToStringUtility
            .newToStringBuilder(this)
            .appendSuper(super.toString())
            .append("operationId", mOperationId)
            .append("workplaceId", mWorkplaceId)
            .append("quantityAmount", mQuantity)
            .append("qualityDetailId", mQualityDetailId)
            .append("annotation", mAnnotation)
            .append("staffMemberId", mStaffMemberId)
            .append("ticketId", mTicketId)
            .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        OperationQuantityCommandDataWsModel that = (OperationQuantityCommandDataWsModel) o;

        return new EqualsBuilder()
            .append(mQuantity, that.mQuantity)
            .append(mOperationId, that.mOperationId)
            .append(mWorkplaceId, that.mWorkplaceId)
            .append(mQualityDetailId, that.mQualityDetailId)
            .append(mAnnotation, that.mAnnotation)
            .append(mStaffMemberId, that.mStaffMemberId)
            .append(mTicketId, that.mTicketId)
            .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
            .append(mOperationId)
            .append(mWorkplaceId)
            .append(mQuantity)
            .append(mQualityDetailId)
            .append(mAnnotation)
            .append(mStaffMemberId)
            .append(mTicketId)
            .toHashCode();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Getter for operation uuid.
     *
     * @return Operation uuid.
     */
    public String getOperationId() {
        return mOperationId;
    }

    /**
     * Setter for operation uuid.
     *
     * @param operationId Operation uuid.
     */
    @ApiModelProperty(value = "UUID of the operation,", required = true, position = 1)
    public void setOperationId(String operationId) {
        mOperationId = operationId;
    }

    /**
     * Getter for workplace uuid.
     *
     * @return Workplace uuid.
     */
    public String getWorkplaceId() {
        return mWorkplaceId;
    }

    /**
     * Setter for workplace uuid.
     *
     * @param workplaceId Workplace uuid.
     */
    @ApiModelProperty(value = "UUID of the workplace. The target workplace is used if no workplace is provided.", required = false, position = 2)
    public void setWorkplaceId(String workplaceId) {
        mWorkplaceId = workplaceId;
    }

    /**
     * Getter for annotation.
     *
     * @return Annotation.
     */
    public String getAnnotation() {
        return mAnnotation;
    }

    /**
     * Setter for annotation.
     *
     * @param annotation Annotation.
     */
    @ApiModelProperty(value = "The annotation for the operation quantity.", required = false, position = 5)
    public void setAnnotation(String annotation) {
        mAnnotation = annotation;
    }

    /**
     * Getter for ticket uuid.
     *
     * @return Ticket uuid.
     */
    public String getTicketId() {
        return mTicketId;
    }

    public String getQualityDetailId() {
        return mQualityDetailId;
    }

    @ApiModelProperty(value = "UUID of the quantity reason.", required = true, position = 4)
    public void setQualityDetailId(String qualityDetailId) {
        this.mQualityDetailId = qualityDetailId;
    }

    public double getQuantity() {
        return mQuantity;
    }

    @ApiModelProperty(value = "The quantity amount which has to be booked for the operation.", required = true, position = 3)
    public void setQuantity(double mQuantity) {
        this.mQuantity = mQuantity;
    }

    /**
     * Setter for ticket uuid.
     *
     * @param ticketId Ticket uuid.
     */
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