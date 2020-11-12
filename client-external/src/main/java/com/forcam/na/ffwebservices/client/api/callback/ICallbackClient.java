////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 31.08.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.callback;

import com.forcam.na.ffwebservices.client.api.callback.listener.CallbackListener;
import com.forcam.na.ffwebservices.client.api.callback.request.CreateCallbackRequest;
import com.forcam.na.ffwebservices.client.api.callback.request.DeleteCallbackRequest;
import com.forcam.na.ffwebservices.client.api.exception.ForceAPIException;
import com.forcam.na.ffwebservices.client.api.pagination.request.CollectionRequest;
import com.forcam.na.ffwebservices.client.api.pagination.response.Page;
import com.forcam.na.ffwebservices.model.callback.CallbackResponse;
import org.eclipse.paho.client.mqttv3.MqttException;

import java.io.IOException;

/**
 * An interface with methods that request callbacks.
 */
public interface ICallbackClient {

    /**
     * Sends a request to the server and gets a collection of callbacks as response.
     *
     * @param request A collection of parameters.
     * @return The callback collection response.
     * @throws ForceAPIException When unable to get callbacks.
     */
    Page<CallbackResponse> getCallbacks(CollectionRequest request) throws ForceAPIException;

    /**
     * Sends a creation request to the server and gets the new callback model as response.
     *
     * @param request A collection of parameters.
     * @return A callback model.
     * @throws ForceAPIException When unable to create callback.
     */
    CallbackResponse createCallback(CreateCallbackRequest request) throws ForceAPIException;

    /**
     * Sends a deletion request to the server.
     *
     * @param request A collection of parameters.
     * @throws ForceAPIException When unable to delete callback.
     */
    void deleteCallback(DeleteCallbackRequest request) throws ForceAPIException;

    /**
     * Starts the callback HTTP server.
     *
     * @param port The port of the server.
     * @return URL of callback HTTP server.
     * @throws IOException When unable to start the server.
     */
    String startCallbackHttpServer(int port) throws IOException;

    /**
     * Stops the callback HTTP server.
     */
    void stopCallbackHttpServer();

    /**
     * Registers a new {@link CallbackListener}.
     *
     * @param callbackListener The callback listener to register.
     */
    void addListener(CallbackListener callbackListener);

    /**
     * Remove all registered {@link CallbackListener}s.
     */
    void clearListeners();

    /**
     * Connects to the MQTT broker with the given configuration.
     *
     * @param configuration The configuration for the connection with the broker.
     * @throws MqttException When unable to connect to the MQTT broker.
     */
    void connectToMqttBroker(MqttConfiguration configuration) throws MqttException;

    /**
     * Disconnects from the MQTT broker.
     *
     * @throws MqttException When unable to disconnect from the MQTT broker.
     */
    void disconnectFromMqttBroker() throws MqttException;

    /**
     * Subscribes to the given topic with the given quality of service.
     *
     * @param topic The topic to subscribe to.
     * @param qos   The quality of service.
     * @throws MqttException When unable to subscribe to the given topic.
     */
    void subscribeMqttTopic(String topic, int qos) throws MqttException;

    /**
     * Unsubscribes from the given topic.
     *
     * @param topic The topic to unsubscribe from.
     * @throws MqttException When unable to unsubscribe from the given topic.
     */
    void unsubscribeMqttTopic(String topic) throws MqttException;
}