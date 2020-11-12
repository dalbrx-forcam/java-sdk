////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 13.09.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.callback;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.client.api.callback.listener.CallbackListener;
import com.forcam.na.ffwebservices.model.LinkEmbeddedWSModel;
import com.forcam.na.ffwebservices.model.callback.CallbackNotificationResponse;
import com.forcam.na.ffwebservices.model.callback.CallbackNotificationResponsePropertiesWSModel;
import com.forcam.na.ffwebservices.model.callback.CallbackPropertiesWSModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The request handler for the callback client.
 */
public class CallbackRequestHandler {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Jackson's object mapper. */
    private final ObjectMapper mMapper = new ObjectMapper();

    /** The registered callback listeners. */
    private final List<CallbackListener> mCallbackListeners = Collections.synchronizedList(new ArrayList<>());

    /** The link model builder of the callback. */
    private final CallbackLinkModelBuilder mCallbackLinkModelBuilder = new CallbackLinkModelBuilder();

    /** The single instance of the {@link CallbackRequestHandler}. */
    private static CallbackRequestHandler mInstance;

    /**
     * Returns the single instance of the {@link CallbackRequestHandler}.
     *
     * @return The single instance of the {@link CallbackRequestHandler}.
     */
    public static CallbackRequestHandler getInstance() {
        if (mInstance == null) {
            mInstance = new CallbackRequestHandler();
        }
        return mInstance;
    }

    /**
     * A private constructor to establish a singleton.
     */
    private CallbackRequestHandler() {
        // Singleton
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    /**
     * Registers a new {@link CallbackListener}.
     *
     * @param callbackListener The callback listener to register.
     */
    protected void addListener(CallbackListener callbackListener) {
        mCallbackListeners.add(callbackListener);
    }

    protected void clearListeners() {
        mCallbackListeners.clear();
    }

    /**
     * Converts HAL model to a callback notification model.
     *
     * @param serverModel The server model.
     * @return A callback notification model.
     */
    private CallbackNotificationResponse getCallbackNotificationResponse(HALWSModel serverModel) {
        final CallbackNotificationResponse callbackNotificationModel = new CallbackNotificationResponse();
        final CallbackNotificationResponsePropertiesWSModel properties = mMapper.convertValue(serverModel.getProperties(),
                                                                                              CallbackNotificationResponsePropertiesWSModel.class);
        callbackNotificationModel.setProperties(properties);

        final LinkEmbeddedWSModel<CallbackPropertiesWSModel> callback = mCallbackLinkModelBuilder.buildLinkModel(serverModel, "callback");
        callbackNotificationModel.setCallback(callback);

        return callbackNotificationModel;
    }

    /**
     * Handles the given callback with matching listeners.
     *
     * @param model A {@link HALWSModel} containing a callback notification model.
     */
    public void handleCallback(HALWSModel model) {
        final CallbackNotificationResponse callbackNotificationModel = this.getCallbackNotificationResponse(model);

        for (CallbackListener listener : mCallbackListeners) {
            if (listener.isResponsible(callbackNotificationModel)) {
                listener.handleCallback(callbackNotificationModel);
            }
        }
    }

    /**
     * Handles a lost connection.
     *
     * @param provider  The callback provider, either HTTP or MQTT.
     * @param throwable The cause of the connection loss.
     */
    public void connectionLost(CallbackProvider provider, Throwable throwable) {
        for (CallbackListener listener : mCallbackListeners) {
            listener.connectionLost(provider, throwable);
        }
    }
}