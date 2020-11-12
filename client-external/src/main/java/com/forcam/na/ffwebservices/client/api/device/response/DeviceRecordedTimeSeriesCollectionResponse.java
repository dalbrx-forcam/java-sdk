////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 13.08.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.device.response;

import com.forcam.na.ffwebservices.client.api.pagination.response.AbstractCollectionResponse;
import com.forcam.na.ffwebservices.client.api.pagination.request.PaginationRequest;
import com.forcam.na.ffwebservices.model.device.DeviceRecordedTimeSeriesCollectionPropertiesWSModel;
import com.forcam.na.ffwebservices.model.device.TimeSeriesWSModel;

import java.util.List;

/**
 * Device recorded time series collection response.
 */
public class DeviceRecordedTimeSeriesCollectionResponse extends AbstractCollectionResponse<TimeSeriesWSModel> {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The device recorded time series collection properties WS model. */
    private DeviceRecordedTimeSeriesCollectionPropertiesWSModel mProperties;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     *
     * @param request The request.
     */
    public DeviceRecordedTimeSeriesCollectionResponse(PaginationRequest request) {
        super(request);
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Provides the device recorded time series collection properties.
     *
     * @return The device recorded time series collection properties WS model.
     */
    public DeviceRecordedTimeSeriesCollectionPropertiesWSModel getProperties() {
        return mProperties;
    }

    /**
     * Sets the device recorded time series collection properties.
     *
     * @param properties The device recorded time series collection properties WS model.
     */
    public void setProperties(DeviceRecordedTimeSeriesCollectionPropertiesWSModel properties) {
        mProperties = properties;
    }

    @Override
    public List<TimeSeriesWSModel> getElements() {
        return mProperties.getElements();
    }
}