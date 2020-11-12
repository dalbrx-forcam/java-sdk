////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 14.09.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.pagination.stream;

import com.forcam.na.ffwebservices.client.api.pagination.response.AbstractCollectionResponse;
import com.forcam.na.ffwebservices.client.api.pagination.PageNotAvailableException;
import com.forcam.na.ffwebservices.client.api.pagination.response.SpecificPage;

import java.util.List;
import java.util.Spliterator;

/**
 * {@link Spliterator} used for pages.
 */
public abstract class AbstractPageSpliterator<E, T extends AbstractCollectionResponse<E>> implements Spliterator<E> {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The current page. */
    private SpecificPage<E, T> mPage;

    /** The elements of the current page. */
    private List<E> mElements;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     *
     * @param page The start page.
     */
    AbstractPageSpliterator(SpecificPage<E, T> page) {
        this.setPage(page);
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public Spliterator<E> trySplit() {
        //currently no parallel processing!
        return null;
    }

    @Override
    public long estimateSize() {
        return Long.MAX_VALUE;
    }

    @Override
    public int characteristics() {
        return 0;
    }

    public E getElement(int index) {
        return mElements.get(index);
    }

    public int getElementCount() {
        return mElements.size();
    }

    protected abstract void proceedPage() throws PageNotAvailableException;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public SpecificPage<E, T> getPage() {
        return mPage;
    }

    public void setPage(SpecificPage<E, T> page) {
        mPage = page;
        mElements = page.getElements();
    }

    public List<E> getElements() {
        return mElements;
    }
}
