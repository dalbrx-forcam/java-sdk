////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 31.08.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.callback;

import com.forcam.na.ffwebservices.client.api.AbstractClient;
import com.forcam.na.ffwebservices.client.api.HALCollectionWSModel;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.client.api.callback.listener.CallbackListener;
import com.forcam.na.ffwebservices.client.api.callback.request.CreateCallbackRequest;
import com.forcam.na.ffwebservices.client.api.callback.request.DeleteCallbackRequest;
import com.forcam.na.ffwebservices.client.api.exception.ForceAPIException;
import com.forcam.na.ffwebservices.client.api.pagination.request.CollectionRequest;
import com.forcam.na.ffwebservices.client.api.pagination.response.CollectionResponse;
import com.forcam.na.ffwebservices.client.api.pagination.response.Page;
import com.forcam.na.ffwebservices.model.callback.CallbackResponse;
import com.forcam.na.ffwebservices.model.callback.CreateCallbackPropertiesWSModel;
import org.apache.commons.lang3.StringUtils;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import retrofit2.Call;

import javax.inject.Inject;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.util.Optional;
import java.util.UUID;

/**
 * Requests callbacks.
 */
public class CallbackClient extends AbstractClient implements ICallbackClient {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The callback endpoint. */
    private final CallbackEndpoint mCallbackEndpoint;

    /** The callback response builder. */
    private final ICallbackResponseBuilder mCallbackResponseBuilder;

    /** The callback HTTP server. */
    private CallbackHttpServer mHttpServer;

    /** The callback request handler. */
    private CallbackRequestHandler mRequestHandler;

    /** The MQTT client. */
    private MqttClient mMqttClient;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a callback client with a retrofit client.
     *
     * @param callbackEndpoint        Callback endpoint.
     * @param callbackResponseBuilder Callback response builder.
     */
    @Inject
    public CallbackClient(CallbackEndpoint callbackEndpoint, ICallbackResponseBuilder callbackResponseBuilder) {
        mCallbackEndpoint = callbackEndpoint;
        mCallbackResponseBuilder = callbackResponseBuilder;
        mRequestHandler = CallbackRequestHandler.getInstance();
    }
    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public Page<CallbackResponse> getCallbacks(CollectionRequest request) throws ForceAPIException {
        final Call<HALCollectionWSModel> call = mCallbackEndpoint.getCallbacks(request.getLimit(), request.getOffset());
        final HALCollectionWSModel responseModel = this.getResponseModel(request, call);
        final CollectionResponse<CallbackResponse> response = mCallbackResponseBuilder.getCallbackCollectionResponse(request, responseModel);

        final Method m = new Object() {}
            .getClass()
            .getEnclosingMethod();
        return new Page<>(this, m, response);
    }

    @Override
    public CallbackResponse createCallback(CreateCallbackRequest request) throws ForceAPIException {

        if (StringUtils.isBlank(request.getUrl())) {
            throw new ForceAPIException("Unable to create callback without url");
        }

        if (request.getEvent() == null) {
            throw new ForceAPIException("Unable to create callback without event");
        }

        final CreateCallbackPropertiesWSModel callbackData = new CreateCallbackPropertiesWSModel();
        callbackData.setObjectFilter(request.getObjectFilter());
        callbackData.setEventType(request
                                      .getEvent()
                                      .getEventType());
        request
            .getEvent()
            .getEventName()
            .or(() -> Optional.ofNullable(request.getEventName()))
            .ifPresent(callbackData::setEventName);
        callbackData.setUrl(request.getUrl());
        callbackData.setMaxRedeliveryAttempts(request.getMaxRedeliveryAttempts());
        callbackData.setMaxUnconfirmedMessages(request.getMaxUnconfirmedMessages());
        final Call<HALWSModel> call = mCallbackEndpoint.createCallback(callbackData);
        final HALWSModel responseModel = this.getResponseModel(request, call);
        return mCallbackResponseBuilder.getCallbackResponse(responseModel);
    }

    @Override
    public void deleteCallback(DeleteCallbackRequest request) throws ForceAPIException {
        final Call<Void> call = mCallbackEndpoint.deleteCallback(request.getId());
        this.executeCall(request, call);
    }

    @Override
    public String startCallbackHttpServer(int port) throws IOException {
        if (mHttpServer == null) {
            mHttpServer = new CallbackHttpServer(port);
        }
        mHttpServer.start();
        final InetAddress inetAddress = InetAddress.getLocalHost();
        return "http://" + inetAddress.getHostAddress() + ":" + port + CallbackHttpServer.URL_PATH;
    }

    @Override
    public void stopCallbackHttpServer() {
        if (mHttpServer != null) {
            mHttpServer.stop();
        }
    }

    @Override
    public void addListener(CallbackListener callbackListener) {
        mRequestHandler.addListener(callbackListener);
    }

    @Override
    public void clearListeners() {
        mRequestHandler.clearListeners();
    }

    @Override
    public void connectToMqttBroker(MqttConfiguration configuration) throws MqttException {
        if (mMqttClient != null) {
            mMqttClient.close();
        }

        String clientId = configuration.getClientId();
        if (clientId == null) {
            clientId = UUID
                .randomUUID()
                .toString();
        }

        mMqttClient = new MqttClient(configuration.getServerURI(), "BridgeAPIClient-" + clientId, configuration.getPersistence());
        mMqttClient.setCallback(new CallbackMqttHandler(mRequestHandler));
        mMqttClient.connect(configuration.getOptions());
    }

    @Override
    public void disconnectFromMqttBroker() throws MqttException {
        if (mMqttClient == null) {
            throw new MqttException(MqttException.REASON_CODE_CLIENT_ALREADY_DISCONNECTED);
        }
        mMqttClient.disconnect();
        mMqttClient.close();
        mMqttClient = null;
    }

    @Override
    public void subscribeMqttTopic(String topic, int qos) throws MqttException {
        if (mMqttClient == null) {
            throw new MqttException(MqttException.REASON_CODE_CLIENT_NOT_CONNECTED);
        }
        mMqttClient.subscribe(topic, qos);
    }

    @Override
    public void unsubscribeMqttTopic(String topic) throws MqttException {
        if (mMqttClient == null) {
            throw new MqttException(MqttException.REASON_CODE_CLIENT_NOT_CONNECTED);
        }
        mMqttClient.unsubscribe(topic);
    }
}