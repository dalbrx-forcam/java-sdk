package com.forcam.na.common.webservices.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Creates error message webservice model.
 * <p>
 * Created: 02.11.2016
 *
 * @author David Albrecht
 */

@ApiModel(value = "errorMessage")
public class ErrorMessageWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Error message. */
    private String mMessage;

    /** Status. */
    private int mStatus;

    /** Error code. */
    private String mCode;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Getter for {@link #mMessage}.
     *
     * @return Message.
     */
    public String getMessage() {
        return mMessage;
    }

    @ApiModelProperty(value = "Detailed error message", required = true)
    public void setMessage(String message) {
        this.mMessage = message;
    }

    /**
     * Getter for {@link #mCode}.
     *
     * @return Error code.
     */
    public String getCode() {
        return mCode;
    }

    @ApiModelProperty(value = "Internal error code", required = true)
    public void setCode(String code) {
        this.mCode = code;
    }

    public int getStatus() {
        return mStatus;
    }

    @ApiModelProperty(value = "HTTP status code", required = true)
    public void setStatus(int status) {
        mStatus = status;
    }

}
