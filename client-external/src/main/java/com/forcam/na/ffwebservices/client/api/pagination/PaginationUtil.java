////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 10.09.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.pagination;

import com.forcam.na.ffwebservices.client.api.pagination.request.PaginationRequest;
import com.forcam.na.ffwebservices.client.api.pagination.response.AbstractCollectionResponse;
import com.forcam.na.ffwebservices.model.collection.Pagination;
import com.forcam.na.common.webserviceaccess.requestparams.PaginationDirection;
import com.rits.cloning.Cloner;

import java.util.Date;

/**
 * Utility class which provides methods to paginate.
 */
class PaginationUtil {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Cloner used to clone requests. */
    private static Cloner mCloner = new Cloner();

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    /**
     * Creates a request for the next page.
     *
     * @param response The response.
     * @return The request for the next page.
     * @throws PageNotAvailableException If no next page is available.
     */
    static PaginationRequest nextPageRequest(AbstractCollectionResponse response) throws PageNotAvailableException {
        final Pagination pagination = response.getPagination();
        final PaginationRequest originalRequest = response.getRequest();

        if (originalRequest != null) {

            switch (pagination.getPaginationType()) {
                case OFFSET:
                    final int nextPageOffset = pagination.getOffset().orElse(0) + pagination.getLimit();
                    if (nextPageOffset < pagination.getTotal()) {
                        return cloneWithOffset(originalRequest, nextPageOffset);
                    } else {
                        throw new PageNotAvailableException("No next page available.");
                    }
                case IDENTIFIER:
                    if (response.getPaginationLinks() != null && response.getPaginationLinks().getNext() != null) {
                        return response.getPagination().getLastDate().map(date -> {
                            final PaginationRequest request = cloneWithTimestamp(originalRequest, date);
                            request.setPaginationDirection(PaginationDirection.NEXT);
                            return request;
                        }).orElseThrow(() -> new PageNotAvailableException("No next page available."));
                    }

                default:
                    throw new PageNotAvailableException("Unable to determine pagination type Pagination:" + pagination);

            }
        }

        throw new PageNotAvailableException("No original request found.");
    }

    /**
     * Creates a request for the previous page.
     *
     * @param response The response.
     * @return The request for the previous page.
     * @throws PageNotAvailableException If no previous page is available.
     */
    static PaginationRequest previousPageRequest(AbstractCollectionResponse response) throws PageNotAvailableException {
        final Pagination pagination = response.getPagination();
        final PaginationRequest originalRequest = response.getRequest();

        if (originalRequest != null) {
            switch (pagination.getPaginationType()) {
                case OFFSET:
                    final int previousPageOffset = pagination.getOffset().orElse(0) - pagination.getLimit();
                    if (previousPageOffset >= 0) {
                        return cloneWithOffset(originalRequest, previousPageOffset);
                    } else {
                        throw new PageNotAvailableException("No previous page available.");
                    }
                case IDENTIFIER:
                    if (response.getPaginationLinks() != null && response.getPaginationLinks().getPrev() != null) {
                        return response.getPagination().getFirstDate().map(date -> {
                            final PaginationRequest request = cloneWithTimestamp(originalRequest, date);
                            request.setPaginationDirection(PaginationDirection.PREVIOUS);
                            return request;
                        }).orElseThrow(() -> new PageNotAvailableException("No previous page available."));
                    }
                default:
                    throw new PageNotAvailableException("Unable to determine pagination type Pagination:" + pagination);
            }
        }

        throw new PageNotAvailableException("No original request found.");
    }

    /**
     * Creates a request for the first page.
     *
     * @param response The response.
     * @return The request for the first page.
     * @throws PageNotAvailableException If no first page is available.
     */
    static PaginationRequest firstPageRequest(AbstractCollectionResponse response) throws PageNotAvailableException {
        final Pagination pagination = response.getPagination();
        final PaginationRequest originalRequest = response.getRequest();

        if (originalRequest != null) {
            switch (pagination.getPaginationType()) {
                case OFFSET:
                    return cloneWithOffset(originalRequest, 0);
                case IDENTIFIER:
                    final PaginationRequest request = cloneWithTimestamp(originalRequest, null);
                    request.setPaginationDirection(PaginationDirection.NEXT);
                    return request;
                default:
                    throw new PageNotAvailableException("Unable to determine pagination type Pagination:" + pagination);
            }
        }

        throw new PageNotAvailableException("No original request found.");
    }

    /**
     * Creates a request for the last page.
     *
     * @param response The response.
     * @return The request for the last page.
     * @throws PageNotAvailableException If no last page is available.
     */
    static PaginationRequest lastPageRequest(AbstractCollectionResponse response) throws PageNotAvailableException {
        final Pagination pagination = response.getPagination();
        final PaginationRequest originalRequest = response.getRequest();

        if (originalRequest != null) {

            switch (pagination.getPaginationType()) {
                case OFFSET:
                    final long lastPageOffset;
                    if (pagination.getTotal() > 0) {
                        final long fullPages = pagination.getLimit() == 0 ? pagination.getTotal() : pagination.getTotal() / pagination.getLimit();
                        final long partialPages = pagination.getTotal() % pagination.getLimit() > 0 ? 1 : 0;
                        lastPageOffset = (fullPages + partialPages - 1) * pagination.getLimit();
                    } else {
                        lastPageOffset = 0;
                    }

                    return cloneWithOffset(originalRequest, (int) lastPageOffset);
                case IDENTIFIER:
                    PaginationRequest request = cloneWithTimestamp(originalRequest, null);
                    request.setPaginationDirection(PaginationDirection.PREVIOUS);
                    return request;
                default:
                    throw new PageNotAvailableException("Unable to determine pagination type Pagination:" + pagination);
            }
        }

        throw new PageNotAvailableException("No original request found.");
    }

    /**
     * Creates a clone of the request and sets the offset.
     *
     * @param originalRequest The original request.
     * @param offset          The offset.
     * @return The cloned request with the offset.
     */
    private static PaginationRequest cloneWithOffset(PaginationRequest originalRequest, int offset) {
        final PaginationRequest request = mCloner.deepClone(originalRequest);
        request.setOffset(offset);
        return request;
    }

    /**
     * Creates a clone of the request and sets the offset.
     *
     * @param originalRequest The original request.
     * @param timestamp       The pagination timestamp.
     * @return The cloned request with the offset.
     */
    private static PaginationRequest cloneWithTimestamp(PaginationRequest originalRequest, Date timestamp) {
        final PaginationRequest request = mCloner.deepClone(originalRequest);
        request.setPaginationTimestamp(timestamp);
        return request;
    }
}
