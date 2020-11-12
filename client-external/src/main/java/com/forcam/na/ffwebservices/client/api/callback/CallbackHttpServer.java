////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 03.09.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.callback;

import fi.iki.elonen.router.RouterNanoHTTPD;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * The HTTP server for the callback client.
 */
public class CallbackHttpServer extends RouterNanoHTTPD {

    /** Logger for class. */
    private static final Logger LOGGER = LoggerFactory.getLogger(CallbackHttpServer.class);

    /** The URL path. */
    public static final String URL_PATH = "/callbacks";

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Starts an HTTP server with the given port.
     *
     * @param port The port for the HTTP server.
     */
    public CallbackHttpServer(int port) {
        super(port);
        this.addMappings();
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    /**
     * Starts the HTTP server.
     *
     * @throws IOException When unable to start the server.
     */
    public void start() throws IOException {
        super.start();
    }

    /**
     * Stops the HTTP server.
     */
    public void stop() {
        super.stop();
    }

    @Override
    public void addMappings() {
        super.addMappings();
        addRoute(URL_PATH, CallbackHttpHandler.class);
    }
}