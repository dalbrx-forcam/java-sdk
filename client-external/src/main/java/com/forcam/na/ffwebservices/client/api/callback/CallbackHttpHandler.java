////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 15.10.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.callback;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import fi.iki.elonen.NanoHTTPD;
import fi.iki.elonen.router.RouterNanoHTTPD;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * The callback handler for HTTP.
 */
public class CallbackHttpHandler extends RouterNanoHTTPD.DefaultStreamHandler {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------

    /** Logger for class. */
    private static final Logger LOGGER = LoggerFactory.getLogger(CallbackHttpHandler.class);

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
     * Initiates a {@link CallbackHttpHandler}.
     */
    public CallbackHttpHandler() {
        mCallbackRequestHandler = CallbackRequestHandler.getInstance();
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public String getMimeType() {
        return null;
    }

    @Override
    public NanoHTTPD.Response.IStatus getStatus() {
        return NanoHTTPD.Response.Status.OK;
    }

    @Override
    public InputStream getData() {
        return null;
    }

    @Override
    public NanoHTTPD.Response post(RouterNanoHTTPD.UriResource uriResource, Map<String, String> urlParams, NanoHTTPD.IHTTPSession session) {
        final HashMap<String, String> map = new HashMap<>();
        try {
            session.parseBody(map);
        } catch (IOException | NanoHTTPD.ResponseException e) {
            LOGGER.error("Unable to parse body", e);
        }
        final String json = map.get("postData");

        try {
            final HALWSModel model = mMapper.readValue(json, HALWSModel.class);
            mCallbackRequestHandler.handleCallback(model);
        } catch (IOException e) {
            LOGGER.error("Unable to map json: " + json, e);
        }

        return NanoHTTPD.newFixedLengthResponse(this.getStatus(), this.getMimeType(), this.getData(), 0);
    }
}