////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 12.09.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.pagination.response;

import com.forcam.na.ffwebservices.client.api.pagination.PageNotAvailableException;
import com.forcam.na.ffwebservices.client.api.pagination.request.PaginationRequest;
import com.forcam.na.ffwebservices.client.api.pagination.stream.BackwardSpliterator;
import com.forcam.na.ffwebservices.client.api.pagination.stream.ForwardSpliterator;
import com.forcam.na.ffwebservices.client.api.pagination.stream.PageCollector;
import com.forcam.na.ffwebservices.model.collection.Pagination;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * A specific page with elements.
 *
 * @param <E> The type of the elements.
 */
public class SpecificPage<E, T extends AbstractCollectionResponse<E>> {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The client which can be used for requests. */
    private Object mClient;

    /** The method of the client which can be used for requests. */
    private Method mClientMethod;

    /** The current response. */
    private T mResponse;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     *
     * @param client       The client which can be used for requests.
     * @param clientMethod The method of the client which can be used for requests.
     * @param response     The current response.
     */
    public SpecificPage(Object client, Method clientMethod, T response) {
        mClient = client;
        mClientMethod = clientMethod;
        mResponse = response;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    /**
     * Returns the next page.
     *
     * @return The next page.
     * @throws PageNotAvailableException If the next page is not available.
     */
    public SpecificPage<E, T> getNextPage() throws PageNotAvailableException {
        final PaginationRequest request = mResponse
            .getPaginationController()
            .nextPageRequest();

        try {
            return (SpecificPage<E, T>) mClientMethod.invoke(mClient, request);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new PageNotAvailableException(e);
        }
    }

    /**
     * Returns a {@link Stream} of elements paging forward.
     *
     * @return {@link Stream} of elements.
     */
    public Stream<E> streamForward() {
        final Spliterator<E> spliterator = new ForwardSpliterator<>(this);
        return StreamSupport.stream(spliterator, false);
    }

    /**
     * Returns a {@link Stream} of elements paging backwards.
     *
     * @return {@link Stream} of elements.
     */
    public Stream<E> streamBackward() {
        final Spliterator<E> spliterator = new BackwardSpliterator<>(this);
        return StreamSupport.stream(spliterator, false);
    }

    /**
     * Returns the previous page.
     *
     * @return The previous page.
     * @throws PageNotAvailableException If the previous page is not available.
     */
    public SpecificPage<E, T> getPreviousPage() throws PageNotAvailableException {
        final PaginationRequest request = mResponse
            .getPaginationController()
            .previousPageRequest();

        try {
            return (SpecificPage<E, T>) mClientMethod.invoke(mClient, request);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new PageNotAvailableException(e);
        }
    }

    /**
     * Returns the next page.
     *
     * @return The last page.
     * @throws PageNotAvailableException If the last page is not available.
     */
    public SpecificPage<E, T> getLastPage() throws PageNotAvailableException {
        final PaginationRequest request = mResponse
            .getPaginationController()
            .lastPageRequest();

        try {
            return (SpecificPage<E, T>) mClientMethod.invoke(mClient, request);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new PageNotAvailableException(e);
        }
    }

    /**
     * Returns the first page.
     *
     * @return The first page.
     * @throws PageNotAvailableException If the first page is not available.
     */
    public SpecificPage<E, T> getFirstPage() throws PageNotAvailableException {
        final PaginationRequest request = mResponse
            .getPaginationController()
            .firstPageRequest();

        try {
            return (SpecificPage<E, T>) mClientMethod.invoke(mClient, request);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new PageNotAvailableException(e);
        }
    }

    /**
     * When iterating through pages it might be possible that the underlying elements change.
     * This method tries to handle such a case with a certain amount of retries.
     * <p>
     * Prerequisite: A callback has to be registered which informs about such changes which sets the interrupted flag of the PageCollector.
     * <p>
     * The method is private until such mechanism has been implemented.
     *
     * @return All elements.
     * @throws InterruptedException If it is not possible to get all elements after a certain amount of retries.
     */
    private List<E> getAllWithInterruption() throws InterruptedException {
        final PageCollector<E, T> collector = new PageCollector<>(this);
        return collector.getAll();
    }

    /**
     * Returns the elements of this page.
     *
     * @return The elements of the page.
     */
    public List<E> getElements() {
        return mResponse.getElements();
    }

    /**
     * Returns the pagination information.
     *
     * @return The {@link Pagination}.
     */
    public Pagination getPagination() {
        return mResponse.getPagination();
    }

    /**
     * Returns the response object which can be used to retrieve details of the response such as links.
     *
     * @return The response.
     */
    public T getResponse() {
        return mResponse;
    }

}
