////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 15.10.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.callback;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 * The callback handler for MQTT.
 */
public class CallbackMqttHandler implements MqttCallback {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Jackson's object mapper. */
    private final ObjectMapper mMapper = new ObjectMapper();

    /** The callback request handler. */
    private CallbackRequestHandler mCallbackRequestHandler;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Initiates a {@link CallbackMqttHandler}.
     *
     * @param requestHandler The single instance of the {@link CallbackRequestHandler}.
     */
    public CallbackMqttHandler(CallbackRequestHandler requestHandler) {
        mCallbackRequestHandler = requestHandler;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public void connectionLost(Throwable throwable) {
        mCallbackRequestHandler.connectionLost(CallbackProvider.MQTT, throwable);
    }

    @Override
    public void messageArrived(String topic, MqttMessage mqttMessage) throws Exception {
        final HALWSModel model = mMapper.readValue(new String(mqttMessage.getPayload()), HALWSModel.class);
        mCallbackRequestHandler.handleCallback(model);
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken mqttDeliveryToken) {
        // Not implemented because publishing is not possible.
    }
}