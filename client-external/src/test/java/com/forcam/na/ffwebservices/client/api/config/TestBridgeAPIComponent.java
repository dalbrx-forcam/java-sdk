////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 12.10.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.config;

import com.forcam.na.ffwebservices.client.api.ticket.ITicketActivityClient;
import com.forcam.na.ffwebservices.client.config.BridgeAPIComponent;
import com.forcam.na.ffwebservices.client.config.ClientModule;
import com.forcam.na.ffwebservices.client.config.EndpointModule;
import com.forcam.na.ffwebservices.client.config.InterceptorModule;
import com.forcam.na.ffwebservices.client.config.ResponseBuilderModule;
import dagger.Component;
import okhttp3.mockwebserver.MockWebServer;

import javax.inject.Singleton;

/**
 *
 */
@Singleton
@Component(modules = { TestForceAPIModule.class, ClientModule.class, EndpointModule.class, InterceptorModule.class, ResponseBuilderModule.class })
public interface TestBridgeAPIComponent extends BridgeAPIComponent {
    MockWebServer mockWebServer();

}
