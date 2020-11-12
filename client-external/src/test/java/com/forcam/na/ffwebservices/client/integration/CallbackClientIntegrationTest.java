////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 31.08.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.integration;

import com.forcam.na.ffwebservices.client.api.callback.CallbackClient;
import com.forcam.na.ffwebservices.client.api.callback.request.CreateCallbackRequest;
import com.forcam.na.ffwebservices.client.api.callback.request.DeleteCallbackRequest;
import com.forcam.na.ffwebservices.client.api.exception.ForceAPIException;
import com.forcam.na.ffwebservices.client.api.pagination.request.CollectionRequest;
import com.forcam.na.ffwebservices.client.api.pagination.response.Page;
import com.forcam.na.ffwebservices.model.callback.CallbackResponse;
import com.forcam.na.ffwebservices.model.event.Event;
import org.junit.*;

import java.util.regex.Pattern;

/**
 * Integration tests for the class {@link CallbackClient}.
 */
public class CallbackClientIntegrationTest extends AbstractOpenAPIIntegrationTest {

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    public CallbackClientIntegrationTest() {
        final Pattern callbacksPattern = Pattern.compile(PREFIX_GET_PATH + "/callbacks\\?.*limit=3.*");
        mFileNames.put(callbacksPattern, "json/getCallbacks.json");

        final Pattern createToolPattern = Pattern.compile(PREFIX_POST_PATH + "/callbacks");
        mFileNames.put(createToolPattern, "json/createCallback.json");
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    /**
     * Test for the method {@link CallbackClient#getCallbacks(CollectionRequest)}.
     *
     * @throws ForceAPIException When unable to get callbacks.
     */
    @Test
    public void testGetCallbacks() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final CollectionRequest request = new CollectionRequest();
        request.setLimit(3);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final Page<CallbackResponse> callbackCollection = mCallbackClient.getCallbacks(request);

        Assert.assertNotNull(callbackCollection);
    }

    /**
     * Test for the method {@link CallbackClient#createCallback(CreateCallbackRequest)}.
     *
     * @throws ForceAPIException When unable to create callback.
     */
    @Test
    public void testCreateCallback() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final CallbackResponse callbackModel = this.createNewCallback();

        Assert.assertNotNull(callbackModel);
        Assert.assertNotNull(callbackModel.getProperties());
    }

    /**
     * Test for the method {@link CallbackClient#deleteCallback(DeleteCallbackRequest)}.
     *
     * @throws ForceAPIException When unable to delete tool.
     */
    @Test
    public void testDeleteCallback() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final CallbackResponse responseModel = this.createNewCallback();
        final DeleteCallbackRequest request = new DeleteCallbackRequest(responseModel
                                                                            .getProperties()
                                                                            .getId());

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mCallbackClient.deleteCallback(request);
    }

    /**
     * Creates a new callback.
     *
     * @return The new callback.
     * @throws ForceAPIException When unable to create callback.
     */
    private CallbackResponse createNewCallback() throws ForceAPIException {
        final CreateCallbackRequest request = new CreateCallbackRequest(Event.COMMAND__OPERATION_PHASE);

        request.setUrl("http://www.beispielcallback.com");
        request.setMaxRedeliveryAttempts(1);
        request.setMaxUnconfirmedMessages(1);

        return mCallbackClient.createCallback(request);
    }
}