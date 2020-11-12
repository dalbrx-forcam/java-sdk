////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 13.09.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.workplace.response;

import com.forcam.na.ffwebservices.client.api.pagination.response.SpecificPage;
import com.forcam.na.ffwebservices.model.TimePeriodWSModel;

import java.lang.reflect.Method;

/**
 * Page containing workplace scheduled operating times.
 */
public class WorkplaceScheduledOperatingTimesCollectionPage extends SpecificPage<TimePeriodWSModel, WorkplaceScheduledOperatingTimesCollectionResponse> {

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     *
     * @param client   The client.
     * @param m        The client method.
     * @param response The response.
     */
    public WorkplaceScheduledOperatingTimesCollectionPage(Object client, Method m, WorkplaceScheduledOperatingTimesCollectionResponse response) {
        super(client, m, response);
    }

}
