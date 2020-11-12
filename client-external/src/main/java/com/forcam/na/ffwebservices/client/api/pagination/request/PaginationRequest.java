////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 12.09.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.pagination.request;

import com.forcam.na.common.webserviceaccess.requestparams.PaginationDirection;

import java.util.Date;

/**
 * A request with pagination information.
 */
public interface PaginationRequest {

    /**
     * The maximum number of elements on a page.
     *
     * @return The maximum number of elements on a page.
     */
    int getLimit();

    /**
     * The element offset for the page.
     *
     * @return The page offset.
     */
    int getOffset();

    /**
     * Sets the offset for the page.
     *
     * @param offset The page offset.
     * @return The {@link PaginationRequest} with new offset.
     */
    PaginationRequest setOffset(int offset);

    /**
     * The pagination timestamp.
     *
     * @return The pagination timestamp.
     */
    Date getPaginationTimestamp();

    /**
     * Sets the pagination timestamp.
     *
     * @param paginationTimestamp The pagination timestamp.
     * @return The {@link PaginationRequest} with new pagination timestamp.
     */
    PaginationRequest setPaginationTimestamp(Date paginationTimestamp);

    /**
     * The pagination direction.
     *
     * @return The pagination direction.
     */
    PaginationDirection getPaginationDirection();

    /**
     * Sets the pagination direction.
     *
     * @param paginationDirection The pagination direction.
     * @return The {@link PaginationRequest} with new pagination direction.
     */
    PaginationRequest setPaginationDirection(PaginationDirection paginationDirection);

}
