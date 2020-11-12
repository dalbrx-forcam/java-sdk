package com.forcam.na.ffwebservices.model.command;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created: 27.04.2017
 *
 * @author David Albrecht
 */
@XmlRootElement(name = "createCommandProperties")
@ApiModel(value = "createCommandProperties")
public class CreateCommandPropertiesWSModel<T extends AbstractCommandDataWSModel> {
    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The code of the result. */
    private String mResultCode;

    /** A command data model. */
    private T mData;

    /** The timestamp. */
    private Date mTimestamp;

    private Date mBookingTimestamp;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    @ApiModelProperty(value = "The creation timestamp. Set after the command has been processed")
    public void setTimestamp(Date timestamp) {
        mTimestamp = timestamp;
    }

    public Date getTimestamp() {
        return mTimestamp;
    }

    public String getResultCode() {
        return mResultCode;
    }

    @ApiModelProperty(value = "The result code of the command. Set after the command has been processed", allowableValues = "RC_GENERIC_REQ_CANCEL_SUCCEED,RC_GENERIC_REQ_UNKNOWN_FAILURE,RC_GENERIC_REQ_NO_MSG_LISTENER_REGISTERED,RC_SIMPLE_SUCCESS,RC_ENHANCED_SUCCESS,RC_SIMPLE_FAILURE,RC_BOOKING_FAILURE")
    public void setResultCode(String resultCode) {
        mResultCode = resultCode;
    }

    public T getData() {
        return mData;
    }

    @ApiModelProperty(value = "The data of the command", dataType = "java.lang.String", example = "The command model")
    public void setData(T data) {
        mData = data;
    }

    public Date getBookingTimestamp() {
        return mBookingTimestamp;
    }

    @ApiModelProperty(value = "The booking timestamp.")
    public void setBookingTimestamp(Date bookingTimestamp) {
        mBookingTimestamp = bookingTimestamp;
    }

}