////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 04.09.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.callback.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.forcam.na.ffwebservices.client.api.callback.EventModel;
import com.forcam.na.ffwebservices.model.callback.CallbackNotificationResponse;
import com.forcam.na.ffwebservices.model.callback.CallbackNotificationResponsePropertiesWSModel;
import com.forcam.na.ffwebservices.model.event.Event;
import com.forcam.na.ffwebservices.model.event.EventObjectType;

import java.util.Optional;

/**
 * The abstract listener.
 */
public abstract class AbstractCallbackListener<T> implements CallbackListener {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Jackson's object mapper. */
    private final static ObjectMapper mMapper = new ObjectMapper();

    /** The class type of the data object. */
    private final Class<T> mDataClass;

    /** The event. */
    private final Event mEvent;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Instantiates a callback listener.
     *
     * @param dataClass The class type of the data object.
     * @param event     The event the listener is responsible for.
     */
    public AbstractCallbackListener(Class<T> dataClass, Event event) {
        mDataClass = dataClass;
        mEvent = event;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public void handleCallback(CallbackNotificationResponse event) {
        final EventModel<T> eventModel = new EventModel<>();
        final CallbackNotificationResponsePropertiesWSModel properties = event.getProperties();
        eventModel.setCallbackId(properties.getCallbackId());
        eventModel.setTimestamp(properties.getTimestamp());
        eventModel.setEventType(properties.getEventType());
        eventModel.setObjectType(properties.getObjectType());
        eventModel.setObjectId(properties.getObjectId());
        eventModel.setEventName(properties.getEventName());
        final T data = mMapper.convertValue(properties.getData(), mDataClass);
        eventModel.setData(data);
        eventModel.setCallbackLink(event
                                       .getCallback()
                                       .getLink());
        handle(eventModel);
    }

    @Override
    public boolean isResponsible(CallbackNotificationResponse event) {
        final String eventName = event
            .getProperties()
            .getEventName();
        final EventObjectType eventObjectType = event
            .getProperties()
            .getObjectType();

        boolean eventNameEquals = true;

        if (eventName != null) {
            final Optional<String> registeredEventName = mEvent.getEventName();
            eventNameEquals = registeredEventName
                .map(s -> s.equals(eventName))
                .orElse(false);
        }

        return eventNameEquals && (mEvent
                                       .getEventObjectType()
                                       .equals(eventObjectType));
    }

    /**
     * Method which has to be implemented in order to handle the given event.
     *
     * @param e The event to handle.
     */
    public abstract void handle(EventModel<T> e);
}