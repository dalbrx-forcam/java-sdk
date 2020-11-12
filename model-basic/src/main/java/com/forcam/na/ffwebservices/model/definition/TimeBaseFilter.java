////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 13.11.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.definition;

import org.apache.commons.collections.CollectionUtils;

import java.util.Set;

/**
 * Filters for the supported TimeBases. The filter name has to correspond with the names of {@link TimeBase}.
 */
public enum TimeBaseFilter {

    PRODUCTION,
    SETUP,
    SCHEDULED_OPERATING_TIME,
    MAINTENANCE,
    MALFUNCTION,
    SCHEDULED_DOWNTIME;

    /**
     * Checks if set of time bases contains the specific time base filter.
     *
     * @param timeBaseFilter The time base filter.
     * @param timeBases      The set of time bases.
     * @return Flag if set of time bases contains selected time base.
     */
    public static boolean containsTimeBase(TimeBaseFilter timeBaseFilter, Set<String> timeBases) {
        if (timeBaseFilter == null) {
            return true;
        }

        if (timeBaseFilter == TimeBaseFilter.SCHEDULED_DOWNTIME) {
            return CollectionUtils.isEmpty(timeBases) || !timeBases.contains(TimeBaseFilter.SCHEDULED_OPERATING_TIME.name());
        }

        return CollectionUtils.isNotEmpty(timeBases) && timeBases.contains(timeBaseFilter.name());
    }
}
