package com.forcam.na.ffwebservices.model.callback;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 *
 */
@XmlRootElement(name = "callbackProperties")
@ApiModel(value = "callbackProperties")
@JsonPropertyOrder({ "id", "objectFilter", "eventType", "eventName", "url", "creationDate", "maxRedeliverAttempts", "maxUnconfirmedMessages" })
public class CallbackPropertiesWSModel extends CreateCallbackPropertiesWSModel {
    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The callback uuid */
    private String mId;

    /** The creation date of the callback. */
    private Date mCreationDate;

    private Date mLastTriggeredDate;

    private Date mLastSuccessfulDate;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    @ApiModelProperty(value = "UUID of the callback", required = true, position = 0)
    public void setId(String id) {
        mId = id;
    }

    public String getId() {
        return mId;
    }

    @ApiModelProperty(value = "Creation time of the callback", position = 5)
    public void setCreationDate(Date creationDate) {
        mCreationDate = creationDate;
    }

    public Date getCreationDate() {
        return mCreationDate;
    }

    @ApiModelProperty(value = "Last point in time at which the callback was triggered", position = 6)
    public Date getLastTriggeredDate() {
        return mLastTriggeredDate;
    }

    public void setLastTriggeredDate(Date lastTriggeredDate) {
        mLastTriggeredDate = lastTriggeredDate;
    }

    @ApiModelProperty(value = "Last point in time at which the callback was delivered successfully", position = 7)
    public Date getLastSuccessfulDate() {
        return mLastSuccessfulDate;
    }

    public void setLastSuccessfulDate(Date lastSuccessfulDate) {
        mLastSuccessfulDate = lastSuccessfulDate;
    }
}