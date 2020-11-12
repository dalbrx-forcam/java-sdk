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

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

/**
 * A Spliterator for {@link SpecificPage} which pages forward.
 *
 * @param <E> The type of the elements of the page.
 * @param <T> The type of the response.
 */
public class ForwardSpliterator<E, T extends AbstractCollectionResponse<E>> extends AbstractPageSpliterator<E, T> {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The current element index. */
    private AtomicInteger mCurrent = new AtomicInteger();

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     *
     * @param page The start page.
     */
    public ForwardSpliterator(SpecificPage<E, T> page) {
        super(page);
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public void proceedPage() throws PageNotAvailableException {
        final SpecificPage<E, T> next = this
            .getPage()
            .getNextPage();
        this.setPage(next);
        mCurrent.set(0);
    }

    @Override
    public boolean tryAdvance(Consumer<? super E> action) {
        if (this
                .getPage()
                .getPagination()
                .getTotal() == 0) {
            return false;
        }

        try {
            if (mCurrent.get() >= this.getElementCount()) {
                this.proceedPage();
            } else {
                action.accept(this.getElement(mCurrent.getAndIncrement()));
            }

            return true;
        } catch (PageNotAvailableException e) {
            return false;
        }

    }

}

