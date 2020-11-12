////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 03.09.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.event;

import com.forcam.na.ffwebservices.model.event.EventWSModel;
import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * The request object for posting an event.
 */
public class PostEventRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The data of the event that shall be posted. */
    private EventWSModel mEventData;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new {@link PostEventRequest} object with event data.
     *
     * @param eventData The event data.
     */
    public PostEventRequest(EventWSModel eventData) {
        mEventData = eventData;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return ToStringUtility.newToStringBuilder(this)
            .append("eventData", mEventData)
            .toString();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public void setEventData(EventWSModel eventData) {
        mEventData = eventData;
    }

    public EventWSModel getEventData() {
        return mEventData;
    }
}