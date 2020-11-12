////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 13.09.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.device.response;

import com.forcam.na.ffwebservices.client.api.pagination.response.SpecificPage;
import com.forcam.na.ffwebservices.model.device.TimeSeriesWSModel;

import java.lang.reflect.Method;

/**
 * Page containing recorded time series of a device.
 */
public class DeviceRecordedTimeSeriesCollectionPage extends SpecificPage<TimeSeriesWSModel, DeviceRecordedTimeSeriesCollectionResponse> {

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
    public DeviceRecordedTimeSeriesCollectionPage(Object client, Method m, DeviceRecordedTimeSeriesCollectionResponse response) {super(client, m, response);}

}
