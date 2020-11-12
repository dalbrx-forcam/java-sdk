////////////////////////////////////////////////////////////////////////////////
//
// Created by DZeise on 28.06.2019.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.callback;

import com.forcam.na.common.webserviceaccess.util.ToStringUtility;
import com.forcam.na.ffwebservices.model.DateFormatUtility;
import com.forcam.na.ffwebservices.model.event.EventObjectType;
import com.forcam.na.ffwebservices.model.event.EventType;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.Date;
import java.util.Map;

/**
 *
 */
public class CallbackNotificationResponsePropertiesWSModel {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------

    private static final long serialVersionUID = 6888202920535580984L;

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The callback id. */
    private String mCallbackId;

    /** The timestamp. */
    private Date mTimestamp = new Date();

    /** The event type. */
    private EventType mEventType;

    /** The event object type. */
    private EventObjectType mObjectType = EventObjectType.NONE;

    /** The object id. */
    private String mObjectId;

    /** The event name. */
    private String mEventName;

    /** The event data. */
    private Map<String, Object> mData;

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return ToStringUtility
            .newToStringBuilder(this)
            .append("mCallbackId", mCallbackId)
            .append("mTimestamp", DateFormatUtility.formatLogging(mTimestamp))
            .append("mEventType", mEventType)
            .append("mObjectType", mObjectType)
            .append("mObjectId", mObjectId)
            .append("mEventName", mEventName)
            .append("mData", mData)
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

        final CallbackNotificationResponsePropertiesWSModel that = (CallbackNotificationResponsePropertiesWSModel) o;

        return new EqualsBuilder()
            .append(mCallbackId, that.mCallbackId)
            .append(mTimestamp, that.mTimestamp)
            .append(mEventType, that.mEventType)
            .append(mObjectType, that.mObjectType)
            .append(mObjectId, that.mObjectId)
            .append(mEventName, that.mEventName)
            .append(mData, that.mData)
            .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
            .append(mCallbackId)
            .append(mTimestamp)
            .append(mEventType)
            .append(mObjectType)
            .append(mObjectId)
            .append(mEventName)
            .append(mData)
            .toHashCode();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public String getCallbackId() {
        return mCallbackId;
    }

    @ApiModelProperty(value = "UUID of the callback which leads to the notification")
    public void setCallbackId(String callbackId) {
        mCallbackId = callbackId;
    }

    public Date getTimestamp() {
        return mTimestamp;
    }

    @ApiModelProperty(value = "The timestamp when the event occured")
    public void setTimestamp(Date timestamp) {
        mTimestamp = timestamp;
    }

    public EventType getEventType() {
        return mEventType;
    }

    @ApiModelProperty(value = "The type of the event")
    public void setEventType(EventType eventType) {
        mEventType = eventType;
    }

    public String getEventName() {
        return mEventName;
    }

    @ApiModelProperty(value = "The name of the event")
    public void setEventName(String eventName) {
        if (StringUtils.isNotBlank(eventName)) {
            mEventName = eventName;
        }
    }

    public EventObjectType getObjectType() {
        return mObjectType;
    }

    public void setObjectType(EventObjectType objectType) {
        mObjectType = objectType;
    }

    public Map<String, Object> getData() {
        return mData;
    }

    public void setData(Map<String, Object> data) {
        mData = data;
    }

    public String getObjectId() {
        return mObjectId;
    }

    public void setObjectId(String objectId) {
        mObjectId = objectId;
    }

}
