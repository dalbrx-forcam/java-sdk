////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 04.09.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.callback.listener;

import com.forcam.na.ffwebservices.client.api.callback.CallbackProvider;
import com.forcam.na.ffwebservices.model.callback.CallbackNotificationResponse;

/**
 * The callback listener.
 */
public interface CallbackListener {

    /**
     * Method for handling the callback event.
     *
     * @param event The callback event to handle.
     */
    void handleCallback(CallbackNotificationResponse event);

    /**
     * Checks if the listener class is responsible for the given event.
     *
     * @param event The event to check.
     * @return True if the listener class is responsible for the given event.
     */
    boolean isResponsible(CallbackNotificationResponse event);

    /**
     * Is called when the connection to the callback provider is lost.
     *
     * @param callbackProvider The callback provider.
     * @param throwable        The cause of the connection loss.
     */
    default void connectionLost(CallbackProvider callbackProvider, Throwable throwable) {
        // Empty default method.
    }
}