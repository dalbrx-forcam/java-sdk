////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 11.09.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.callback;

import com.forcam.na.ffwebservices.model.LinkWSModel;
import com.forcam.na.ffwebservices.model.event.EventObjectType;
import com.forcam.na.ffwebservices.model.event.EventType;
import io.swagger.annotations.ApiModelProperty;
import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * The event model with a type parameter for data.
 */
public class EventModel<T> {

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
    private EventObjectType mObjectType;

    /** The object id. */
    private String mObjectId;

    /** The event name. */
    private String mEventName;

    /** The event data. */
    private T mData;

    /** The callback link model. */
    private LinkWSModel mCallbackLink;

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return ToStringUtility.newToStringBuilder(this).append("mCallbackId", mCallbackId).append("mTimestamp", mTimestamp).append("mEventType", mEventType).append(
            "mObjectType",
            mObjectType).append("mObjectId", mObjectId).append("mEventName", mEventName).append("mData", mData).append("mCallback", mCallbackLink).toString();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    @ApiModelProperty(value = "The ID of the callback which leads to the notification")
    public void setCallbackId(String callbackId) {
        mCallbackId = callbackId;
    }

    public String getCallbackId() {
        return mCallbackId;
    }

    @ApiModelProperty(value = "The timestamp when the event occured")
    public void setTimestamp(Date timestamp) {
        mTimestamp = timestamp;
    }

    public Date getTimestamp() {
        return mTimestamp;
    }

    @ApiModelProperty(value = "The type of the event")
    public void setEventType(EventType eventType) {
        mEventType = eventType;
    }

    public EventType getEventType() {
        return mEventType;
    }

    public void setObjectType(EventObjectType objectType) {
        mObjectType = objectType;
    }

    public EventObjectType getObjectType() {
        return mObjectType;
    }

    public void setObjectId(String objectId) {
        mObjectId = objectId;
    }

    public String getObjectId() {
        return mObjectId;
    }

    @ApiModelProperty(value = "The name of the event")
    public void setEventName(String eventName) {
        mEventName = eventName;
    }

    public String getEventName() {
        return mEventName;
    }

    public void setData(T data) {
        mData = data;
    }

    public T getData() {
        return mData;
    }

    public void setCallbackLink(LinkWSModel callback) {
        mCallbackLink = callback;
    }

    public LinkWSModel getCallbackLink() {
        return mCallbackLink;
    }
}