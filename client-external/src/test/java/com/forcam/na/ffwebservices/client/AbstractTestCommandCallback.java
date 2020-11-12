////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 27.10.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client;

import com.forcam.na.ffwebservices.client.api.command.ICommandClientAsync;
import com.forcam.na.ffwebservices.model.command.AbstractCommandDataWSModel;
import com.forcam.na.ffwebservices.model.command.AbstractCommandRequest;
import com.forcam.na.ffwebservices.model.command.CommandResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Callback for commands for testing.
 */
public abstract class AbstractTestCommandCallback<T extends AbstractCommandRequest, S extends AbstractCommandDataWSModel>
    implements ICommandClientAsync.CommandCallback<T, S> {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------

    /** Logger for class. */
    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractTestCommandCallback.class);

    /** Is the test successful? */
    private boolean mSuccessful;

    /** The countdown latch. */
    private CountDownLatch mCountDown = new CountDownLatch(1);

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public void onResponse(T request, CommandResponse<S> response) {
        if (response != null && response.getProperties() != null && response.getProperties().getData() != null) {
            this.onResponse(request, response.getProperties().getData());
        }
        this.release();
    }

    /**
     * Compares response with request.
     *
     * @param request The request.
     * @param model   The response model.
     */
    public abstract void onResponse(T request, S model);

    @Override
    public void onFailure(T request, Throwable t) {
        this.fail();
    }

    /**
     * Is the test successful?
     *
     * @return True if the test is successful.
     */
    public boolean isSuccessful() {
        return mSuccessful;
    }

    /** Sets the test as unsuccessful. */
    public void fail() {
        mSuccessful = false;
    }

    /** Sets the test as successful. */
    public void success() {
        mSuccessful = true;
    }

    /**
     * Wait for the server response.
     *
     * @param timeout The maximum time to wait.
     * @param unit    The time unit for the timeout.
     * @throws InterruptedException When thread is interrupted while waiting.
     * @throws TimeoutException     When a timeout occurs.
     */
    public void wait(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
        boolean countedDown = mCountDown.await(timeout, unit);

        if (!countedDown) {
            throw new TimeoutException("Timeout after " + timeout + " " + unit);
        }
    }

    /** Releases the waiting thread. */
    private void release() {
        mCountDown.countDown();
    }
}