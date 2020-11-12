////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 31.08.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.callback;

import com.forcam.na.ffwebservices.client.api.AbstractOpenAPIMockTest;
import com.forcam.na.ffwebservices.client.api.callback.request.CreateCallbackRequest;
import com.forcam.na.ffwebservices.client.api.callback.request.DeleteCallbackRequest;
import com.forcam.na.ffwebservices.client.api.config.GuiceTestRunner;
import com.forcam.na.ffwebservices.client.api.exception.ForceAPIException;
import com.forcam.na.ffwebservices.client.api.pagination.request.CollectionRequest;
import com.forcam.na.ffwebservices.client.api.pagination.response.Page;
import com.forcam.na.ffwebservices.model.callback.CallbackResponse;
import com.forcam.na.ffwebservices.model.callback.CreateCallbackPropertiesWSModel;
import com.forcam.na.ffwebservices.model.event.Event;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.*;
import org.junit.rules.*;
import org.junit.runner.*;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Tests for the class {@link CallbackClient}.
 */
@RunWith(GuiceTestRunner.class)
public class CallbackClientTest extends AbstractOpenAPIMockTest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Helper for test exceptions and messages. */
    @Rule
    public ExpectedException mExpectedException = ExpectedException.none();

    /** The callback client. */
    private ICallbackClient mCallbackClient;

    // ------------------------------------------------------------------------
    // constructor
    // ------------------------------------------------------------------------

    public CallbackClientTest() {
        mCallbackClient = mBridgeAPIComponent.callbackClient();
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    /**
     * Test for the method {@link CallbackClient#getCallbacks(CollectionRequest)}.
     *
     * @throws ForceAPIException    When unable to get callbacks.
     * @throws InterruptedException When unable to take the request from the server.
     * @throws IOException          When unable to read the JSON file.
     * @throws URISyntaxException   When unable to create a URI of the JSON file.
     */
    @Test
    public void getCallbacks() throws ForceAPIException, InterruptedException, IOException, URISyntaxException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getCallbacks.json")));
        final int limit = 3;
        final int offset = 0;
        final CollectionRequest request = new CollectionRequest();
        request
            .setLimit(limit)
            .setOffset(offset);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final Page<CallbackResponse> response = mCallbackClient.getCallbacks(request);

        final RecordedRequest recordedRequest = mMockWebServer.takeRequest();
        final String requestQuery = recordedRequest
            .getRequestUrl()
            .query();
        Assert.assertNotNull(requestQuery);
        Assert.assertTrue(requestQuery.contains("limit=" + limit));
        Assert.assertTrue(requestQuery.contains("offset=" + offset));

        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getResponse());
        Assert.assertNotNull(response
                                 .getResponse()
                                 .getPaginationLinks());
        Assert.assertNotNull(response
                                 .getResponse()
                                 .getPaginationLinks()
                                 .getFirst());
        Assert.assertNotNull(response
                                 .getResponse()
                                 .getPaginationLinks()
                                 .getSelf());
        Assert.assertNotNull(response
                                 .getResponse()
                                 .getPaginationLinks()
                                 .getLast());
    }

    /**
     * Test for the method {@link CallbackClient#createCallback(CreateCallbackRequest)}.
     *
     * @throws ForceAPIException    When unable to create callback.
     * @throws InterruptedException When unable to take the request from the server.
     * @throws IOException          When unable to read the JSON file.
     * @throws URISyntaxException   When unable to create a URI of the JSON file.
     */
    @Test
    public void createCallback() throws ForceAPIException, InterruptedException, IOException, URISyntaxException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/createCallback.json")));
        final CreateCallbackRequest request = new CreateCallbackRequest(Event.COMMAND__MACHINE_COUNT);
        request.setUrl("http://test.url");

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final CallbackResponse response = mCallbackClient.createCallback(request);

        final RecordedRequest recordedRequest = mMockWebServer.takeRequest();
        final String body = recordedRequest
            .getBody()
            .readUtf8();
        final CreateCallbackPropertiesWSModel requestModel = mMapper.readValue(body, CreateCallbackPropertiesWSModel.class);

        Assert.assertEquals(request
                                .getEvent()
                                .getEventType(), requestModel.getEventType());
        Assert.assertEquals(request
                                .getEvent()
                                .getEventName()
                                .get(), requestModel.getEventName());
        Assert.assertEquals(request.getUrl(), requestModel.getUrl());
        Assert.assertEquals(request.getMaxRedeliveryAttempts(), requestModel.getMaxRedeliveryAttempts());
        Assert.assertEquals(request.getMaxUnconfirmedMessages(), requestModel.getMaxUnconfirmedMessages());

        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getSelf());
        Assert.assertNotNull(response.getProperties());
        Assert.assertNotNull(response
                                 .getProperties()
                                 .getId());
    }

    /**
     * Test for the method {@link CallbackClient#createCallback(CreateCallbackRequest)}.
     *
     * @throws ForceAPIException    When unable to create callback.
     * @throws InterruptedException When unable to take the request from the server.
     * @throws IOException          When unable to read the JSON file.
     * @throws URISyntaxException   When unable to create a URI of the JSON file.
     */
    @Test
    public void createCallbackCustomEventName() throws ForceAPIException, InterruptedException, IOException, URISyntaxException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------
        var customEventName = "CustomEventName";

        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/createCallback.json")));
        final CreateCallbackRequest request = new CreateCallbackRequest(Event.INTERNAL__CUSTOMIZED_ACTION, customEventName);
        request.setUrl("http://test.url");

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mCallbackClient.createCallback(request);

        final RecordedRequest recordedRequest = mMockWebServer.takeRequest();
        final String body = recordedRequest
            .getBody()
            .readUtf8();
        final CreateCallbackPropertiesWSModel requestModel = mMapper.readValue(body, CreateCallbackPropertiesWSModel.class);

        Assert.assertEquals(customEventName, requestModel.getEventName());
    }

    /**
     * Test for the method {@link CallbackClient#createCallback(CreateCallbackRequest)}.
     *
     * @throws ForceAPIException    When unable to create callback.
     * @throws InterruptedException When unable to take the request from the server.
     * @throws IOException          When unable to read the JSON file.
     * @throws URISyntaxException   When unable to create a URI of the JSON file.
     */
    @Test(expected = IllegalArgumentException.class)
    public void createCallbackConstructorThrows() {

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        new CreateCallbackRequest(Event.COMMAND__MACHINE_COUNT, "CustomEventName");
    }

    /**
     * Tests getting callbacks while server is down.
     *
     * @throws IOException       When unable to shutdown the server.
     * @throws ForceAPIException When unable to get callbacks.
     */
    @Test
    public void getCallbacksShutdown() throws IOException, ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final CollectionRequest request = new CollectionRequest();
        mMockWebServer.shutdown();
        mExpectedException.expect(ForceAPIException.class);
        mExpectedException.expectMessage("Unable to execute call using request: " + request);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mCallbackClient.getCallbacks(request);
    }

    /**
     * Tests creating callback while server is down.
     *
     * @throws IOException       When unable to shutdown the server.
     * @throws ForceAPIException When unable to create callback.
     */
    @Test
    public void createCallbackShutdown() throws IOException, ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final CreateCallbackRequest request = new CreateCallbackRequest(Event.COMMAND__MACHINE_COUNT);
        request.setUrl("http://test.url");
        mMockWebServer.shutdown();
        mExpectedException.expect(ForceAPIException.class);
        mExpectedException.expectMessage("Unable to execute call using request: " + request);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mCallbackClient.createCallback(request);
    }

    /**
     * Tests deleting callback while server is down.
     *
     * @throws IOException       When unable to shutdown the server.
     * @throws ForceAPIException When unable to delete callback.
     */
    @Test
    public void deleteCallbackShutdown() throws IOException, ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final DeleteCallbackRequest request = new DeleteCallbackRequest("callbackId");
        mMockWebServer.shutdown();
        mExpectedException.expect(ForceAPIException.class);
        mExpectedException.expectMessage("Unable to execute call using request: " + request);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mCallbackClient.deleteCallback(request);
    }
}