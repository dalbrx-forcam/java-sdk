////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 04.05.2020.
//
// Copyright (c) 2006 - 2020 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.util;

import java.util.Comparator;

/**
 * Compares {@link ApiVersion}.
 */
public class ApiVersionComparator implements Comparator<ApiVersion> {

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public int compare(ApiVersion o1, ApiVersion o2) {
        return Integer.compare(o1.getVersion(), o2.getVersion());
    }

    /**
     * Checks if a version is greater or equal to another version.
     *
     * @param o1 The first version
     * @param o2 The second version
     * @return {@code true} if the first version is greator or equal than the second version
     */
    public static boolean greaterThanOrEqual(ApiVersion o1, ApiVersion o2) {
        final Comparator<ApiVersion> comparing = Comparator.comparing(ApiVersion::getVersion);
        return comparing.compare(o1, o2) >= 0;
    }
}
