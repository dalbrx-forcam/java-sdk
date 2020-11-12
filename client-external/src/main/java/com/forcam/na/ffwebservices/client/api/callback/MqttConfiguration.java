////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 19.10.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.callback;

import org.eclipse.paho.client.mqttv3.MqttClientPersistence;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;

/**
 * Contains configurations for establishing an MQTT connection.
 */
public class MqttConfiguration {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The URI of the MQTT broker. */
    private String mServerURI;

    /** The ID of the client. */
    private String mClientId;

    /** MQTT connect options. */
    private MqttConnectOptions mOptions;

    /** Determines the location for data persistence. */
    private MqttClientPersistence mPersistence;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Instantiates a new {@link MqttConfiguration} object with the given server URI.
     *
     * @param serverURI The URI of the MQTT broker.
     */
    public MqttConfiguration (String serverURI) {
        mServerURI = serverURI;
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public String getServerURI() {
        return mServerURI;
    }

    public void setServerURI(String serverURI) {
        mServerURI = serverURI;
    }

    public String getClientId() {
        return mClientId;
    }

    public void setClientId(String clientId) {
        mClientId = clientId;
    }

    public MqttConnectOptions getOptions() {
        return mOptions;
    }

    public void setOptions(MqttConnectOptions options) {
        mOptions = options;
    }

    public MqttClientPersistence getPersistence() {
        return mPersistence;
    }

    public void setPersistence(MqttClientPersistence persistence) {
        mPersistence = persistence;
    }
}