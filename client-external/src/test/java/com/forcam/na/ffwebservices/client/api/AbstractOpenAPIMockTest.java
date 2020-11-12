////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 14.09.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.forcam.na.ffwebservices.client.api.config.DaggerTestBridgeAPIComponent;
import com.forcam.na.ffwebservices.client.api.config.TestBridgeAPIComponent;
import okhttp3.mockwebserver.MockWebServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Contains the different clients for testing with a mock server.
 */
public class AbstractOpenAPIMockTest {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------

    /** Logger for class. */
    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractOpenAPIMockTest.class);

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** A mapper. */
    protected ObjectMapper mMapper = new ObjectMapper();

    /** A mock web server. */
    protected MockWebServer mMockWebServer;

    protected TestBridgeAPIComponent mBridgeAPIComponent;

    public AbstractOpenAPIMockTest() {
        mBridgeAPIComponent = DaggerTestBridgeAPIComponent.create();
        mMockWebServer = mBridgeAPIComponent.mockWebServer();
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    /**
     * Returns a JSON file as a string.
     *
     * @param file The name of a JSON file.
     * @return A JSON string.
     * @throws IOException        When unable to read the JSON file.
     * @throws URISyntaxException When unable to create a URI of the JSON file.
     */
    protected String getJson(String file) throws IOException, URISyntaxException {
        final URL resource = getClass()
            .getClassLoader()
            .getResource(file);
        if (resource != null) {
            final Path path = Paths.get(resource.toURI());
            return new String(Files.readAllBytes(path));
        }

        LOGGER.error("Unable to find file {}", file);
        return "{}";
    }
}