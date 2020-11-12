////////////////////////////////////////////////////////////////////////////////
//
// Created by Dimitri Schulz on 17.09.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.collection;

import org.apache.commons.lang3.Validate;
import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;
import java.util.Optional;

/**
 * Wraps {@link PaginationPropertiesWSModel} to be able to return {@link Optional#EMPTY} in case of {@code null}.
 */
public class Pagination {
    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------

    /**
     * Pagination types.
     */
    public enum PaginationType {
        OFFSET,
        IDENTIFIER
    }

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The pagination properties. */
    private final PaginationPropertiesWSModel mPaginationProperties;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     *
     * @param paginationProperties The pagination properties.
     */
    public Pagination(PaginationPropertiesWSModel paginationProperties) {
        Validate.notNull(paginationProperties);
        mPaginationProperties = paginationProperties;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return ToStringUtility.newToStringBuilder(this)
            .append("mPaginationProperties", mPaginationProperties)
            .toString();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * The element count of the page.
     *
     * @return Element count.
     */
    public int getCount() {
        return mPaginationProperties.getCount();
    }

    /**
     * The total element count.
     *
     * @return Total element count.
     */
    public long getTotal() {
        return mPaginationProperties.getTotal();
    }

    /**
     * The requested element limit for one page.
     *
     * @return Requested element limit for one page.
     */
    public int getLimit() {
        return mPaginationProperties.getLimit();
    }

    /**
     * The element offset of the page. Only available if paging is done via offset.
     *
     * @return {@link Optional} of the element offset of the page.
     */
    public Optional<Integer> getOffset() {
        return Optional.ofNullable(mPaginationProperties.getOffset());
    }

    /**
     * The timestamp of the last element on the page which can be used for pagination via timestamp.
     * Only available if the elements have timestamps.
     *
     * @return {@link Optional} of the timestamp of the last element of the page.
     */
    public Optional<Date> getLastDate() {
        return Optional
            .ofNullable(mPaginationProperties.getLastIdentifier())
            .map(PaginationIdentifierWSModel::getTimestamp);
    }

    /**
     * The timestamp of the first element on the page which can be used for pagination via timestamp.
     * Only available if the elements have timestamps.
     *
     * @return {@link Optional} of the timestamp of the first element of the page.
     */
    public Optional<Date> getFirstDate() {
        return Optional
            .ofNullable(mPaginationProperties.getFirstIdentifier())
            .map(PaginationIdentifierWSModel::getTimestamp);
    }

    /**
     * Returns the {@link PaginationType}.
     *
     * @return The {@link PaginationType}.
     */
    public PaginationType getPaginationType() {
        if (this
            .getOffset()
            .isPresent()) {
            return PaginationType.OFFSET;
        } else {
            return PaginationType.IDENTIFIER;
        }
    }
}