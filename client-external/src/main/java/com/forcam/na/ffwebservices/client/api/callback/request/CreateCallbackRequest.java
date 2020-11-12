////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 31.08.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.callback.request;

import com.forcam.na.common.webserviceaccess.util.ToStringUtility;
import com.forcam.na.ffwebservices.model.callback.CallbackObjectFilterWSModel;
import com.forcam.na.ffwebservices.model.event.Event;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.List;

;

/**
 * The request object for creating a new callback.
 */
public class CreateCallbackRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** List of callback objects */
    private List<CallbackObjectFilterWSModel> mObjectFilter;

    /** The event */
    private Event mEvent;

    /** The event name */
    private String mEventName;

    /** Callback URL. */
    private String mUrl;

    /** Max number of redeliver attempts. */
    private Integer mMaxRedeliveryAttempts;

    /** Max number of unconfirmed messages. */
    private Integer mMaxUnconfirmedMessages;

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return ToStringUtility
            .newToStringBuilder(this)
            .appendSuper(super.toString())
            .append("mObjectFilter", mObjectFilter)
            .append("mEvent", mEvent)
            .append("mEventName", mEventName)
            .append("mUrl", mUrl)
            .append("mMaxRedeliveryAttempts", mMaxRedeliveryAttempts)
            .append("mMaxUnconfirmedMessages", mMaxUnconfirmedMessages)
            .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof CreateCallbackRequest)) {
            return false;
        }

        CreateCallbackRequest that = (CreateCallbackRequest) o;

        return new EqualsBuilder()
            .append(mObjectFilter, that.mObjectFilter)
            .append(mEvent, that.mEvent)
            .append(mEventName, that.mEventName)
            .append(mUrl, that.mUrl)
            .append(mMaxRedeliveryAttempts, that.mMaxRedeliveryAttempts)
            .append(mMaxUnconfirmedMessages, that.mMaxUnconfirmedMessages)
            .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
            .append(mObjectFilter)
            .append(mEvent)
            .append(mEventName)
            .append(mUrl)
            .append(mMaxRedeliveryAttempts)
            .append(mMaxUnconfirmedMessages)
            .toHashCode();
    }

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    public CreateCallbackRequest(Event event, String eventName) throws IllegalArgumentException {
        this.mEvent = event;
        event
            .getEventName()
            .ifPresent(name -> {
                throw new IllegalArgumentException(String.format("EventType %s already has name %s. Cannot set %s.", event.getEventType(), name, eventName));
            });
        this.mEventName = eventName;
    }

    public CreateCallbackRequest(Event event) {
        this.mEvent = event;
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public List<CallbackObjectFilterWSModel> getObjectFilter() {
        return mObjectFilter;
    }

    public void setObjectFilter(List<CallbackObjectFilterWSModel> objectFilter) {
        mObjectFilter = objectFilter;
    }

    public Event getEvent() {
        return mEvent;
    }

    public String getEventName() {
        return mEventName;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

    public Integer getMaxRedeliveryAttempts() {
        return mMaxRedeliveryAttempts;
    }

    public void setMaxRedeliveryAttempts(Integer maxRedeliveryAttempts) {
        mMaxRedeliveryAttempts = maxRedeliveryAttempts;
    }

    public Integer getMaxUnconfirmedMessages() {
        return mMaxUnconfirmedMessages;
    }

    public void setMaxUnconfirmedMessages(Integer maxUnconfirmedMessages) {
        mMaxUnconfirmedMessages = maxUnconfirmedMessages;
    }
}