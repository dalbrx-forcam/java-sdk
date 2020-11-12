////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 14.09.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.pagination.stream;

import com.forcam.na.ffwebservices.client.api.pagination.response.AbstractCollectionResponse;
import com.forcam.na.ffwebservices.client.api.pagination.response.SpecificPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Provides a method to get the elements of all pages (paging forward).
 */
public class PageCollector<E, T extends AbstractCollectionResponse<E>> {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------
    /** Log */
    private static final Logger LOGGER = LoggerFactory.getLogger(PageCollector.class);

    /** Max retries. */
    private static final int MAX_RETRIES = 10;

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The start page. */
    private SpecificPage<E, T> mSpecificPage;

    /** Should be set to {@code true} to indicate that the source elements have been changed while paging. */
    private boolean mInterrupted;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     *
     * @param page The start page.
     */
    public PageCollector(SpecificPage<E, T> page) {
        mSpecificPage = page;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    /**
     * Returns the elements of all pages as {@link List}.
     *
     * @return The elements of all pages.
     * @throws InterruptedException If interrupted during pagination.
     */
    public List<E> getAll() throws InterruptedException {
        return this.getAll(0);
    }

    /**
     * Returns the elements of all pages as {@link List}.
     *
     * @param retry Current retry count.
     * @return The elements of all pages.
     * @throws InterruptedException If interrupted during pagination.
     */
    public List<E> getAll(int retry) throws InterruptedException {
        if (retry > MAX_RETRIES) {
            throw new InterruptedException();
        }

        try {
            return this.tryToGetAll();
        } catch (InterruptedException e) {
            LOGGER.info("Retry after interruption");
            mInterrupted = false;
            return this.getAll(retry + 1);
        }
    }

    /**
     * Tries to get the elements of all pages (going forward).
     *
     * @return All elements.
     * @throws InterruptedException If the interrupted flag has been set while iterating.
     */
    private List<E> tryToGetAll() throws InterruptedException {
        return mSpecificPage
            .streamForward()
            .map(LambdaExceptionUtil.rethrowFunction(this::hasBeenInterrupted))
            .collect(Collectors.toList());
    }

    /**
     * Method which throws {@link InterruptedException} if the interrupted flag is set or otherwise returns the given object.
     *
     * @param obj The object.
     * @return The object
     * @throws InterruptedException If the interrupted flag is set.
     */
    private E hasBeenInterrupted(E obj) throws InterruptedException {
        if (this.isInterrupted()) {
            throw new InterruptedException();
        } else {
            return obj;
        }
    }

    public boolean isInterrupted() {
        return mInterrupted;
    }

    /**
     * Should be set to {@code true} to indicate that the source elements have been changed while paging.
     *
     * @param interrupted Interrupted flag.
     */
    public void setInterrupted(boolean interrupted) {
        mInterrupted = interrupted;
    }
}
