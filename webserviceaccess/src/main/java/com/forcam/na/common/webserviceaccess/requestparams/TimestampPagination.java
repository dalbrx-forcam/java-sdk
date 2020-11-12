////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 01.10.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.common.webserviceaccess.requestparams;

/**
 *
 */
public enum TimestampPagination {

    // ------------------------------------------------------------------------
    // enums
    // ------------------------------------------------------------------------

    PREVIOUS_WITH_TIMESTAMP,
    PREVIOUS_WITHOUT_TIMESTAMP,
    NEXT_WITH_TIMESTAMP,
    NEXT_WITHOUT_TIMESTAMP;

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    public static TimestampPagination getTimestampPagination(CollectionTimestampRequestParams params) {
        if (params.getPaginationTimestamp() == null) {

            if (params.getPaginationDirection() == PaginationDirection.PREVIOUS) {
                return PREVIOUS_WITHOUT_TIMESTAMP;
            }
            return NEXT_WITHOUT_TIMESTAMP;
        } else {
            if (params.getPaginationDirection() == PaginationDirection.PREVIOUS) {
                return PREVIOUS_WITH_TIMESTAMP;
            }
            return NEXT_WITH_TIMESTAMP;
        }
    }
}
