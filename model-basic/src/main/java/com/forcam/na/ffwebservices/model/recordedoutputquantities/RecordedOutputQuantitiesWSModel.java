////////////////////////////////////////////////////////////////////////////////
//
// Created by hiteshgarg on 2/9/2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.recordedoutputquantities;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.forcam.na.ffwebservices.model.AbstractTimestampWithIdentifierModel;
import com.forcam.na.ffwebservices.model.qualitydetail.QualityType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * Operation recorded output quantities model from webservices.
 */
@ApiModel("recordedOutputQuantities")
@JsonPropertyOrder({ "quantity", "bookingTime", "qualityTypeId", "qualityDetailId" })
public class RecordedOutputQuantitiesWSModel extends AbstractTimestampWithIdentifierModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The recorded quantity. */
    private Double mQuantity;

    /** Time of the quantity booking. */
    private Date mBookingTime;

    /** The UUID of the quality type of the booked output quantity. */
    private QualityType mQualityTypeId;

    /** UUID of the quality detail. */
    private String mQualityDetailId;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Setter for {@link RecordedOutputQuantitiesWSModel#mQuantity}.
     *
     * @param quantity The recorded quantity.
     */
    @ApiModelProperty(value = "Booked output quantity", position = 0)
    public void setQuantity(Double quantity) {
        mQuantity = quantity;
    }

    /**
     * Getter for {@link RecordedOutputQuantitiesWSModel#mQuantity}.
     *
     * @return The recorded quantity.
     */
    public Double getQuantity() {
        return mQuantity;
    }

    /**
     * Setter for {@link RecordedOutputQuantitiesWSModel#mBookingTime}.
     *
     * @param bookingTime Time of the quantity booking.
     */
    @ApiModelProperty(value = "Timestamp of the quantity booking", position = 1)
    public void setBookingTime(Date bookingTime) {
        mBookingTime = bookingTime;
    }

    /**
     * Getter for {@link RecordedOutputQuantitiesWSModel#mBookingTime}.
     *
     * @return Time of the quantity booking.
     */
    public Date getBookingTime() {
        return mBookingTime;
    }

    /**
     * Setter for {@link RecordedOutputQuantitiesWSModel#mQualityTypeId}.
     *
     * @param qualityTypeId The UUID of the quality type of the booked output quantity.
     */
    @ApiModelProperty(value = "ID of the quality type of the booked output quantity", position = 2)
    public void setQualityTypeId(QualityType qualityTypeId) {
        mQualityTypeId = qualityTypeId;
    }

    /**
     * Getter for {@link RecordedOutputQuantitiesWSModel#mQualityTypeId}.
     *
     * @return The UUID of the quality type of the booked output quantity.
     */
    public QualityType getQualityTypeId() {
        return mQualityTypeId;
    }

    /**
     * Setter for {@link RecordedOutputQuantitiesWSModel#mQualityDetailId}.
     *
     * @param qualityDetailId UUID of the quality detail.
     */
    @ApiModelProperty(value = "UUID of the quality detail", position = 3)
    public void setQualityDetailId(String qualityDetailId) {
        mQualityDetailId = qualityDetailId;
    }

    /**
     * Getter for {@link RecordedOutputQuantitiesWSModel#mQualityDetailId}.
     *
     * @return UUID of the quality detail.
     */
    public String getQualityDetailId() {
        return mQualityDetailId;
    }

    @Override
    public Date getPaginationDate() {
        return mBookingTime;
    }

    @Override
    public String getPaginationIdentifier() {
        return mQualityDetailId;
    }
}