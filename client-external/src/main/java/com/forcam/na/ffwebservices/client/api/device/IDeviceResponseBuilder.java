////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 13.08.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.device;

import com.forcam.na.ffwebservices.client.api.device.request.GetDeviceRecordedTimeSeriesRequest;
import com.forcam.na.ffwebservices.client.api.device.response.DeviceRecordedTimeSeriesCollectionResponse;
import com.forcam.na.ffwebservices.client.api.pagination.response.CollectionResponse;
import com.forcam.na.ffwebservices.client.api.pagination.request.PaginationRequest;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.client.api.HALCollectionWSModel;
import com.forcam.na.ffwebservices.model.device.DeviceResponse;

/**
 * Device response builder.
 */
public interface IDeviceResponseBuilder {

    /**
     * Converts HAL collection model to device collection response.
     *
     * @param request         The request.
     * @param collectionModel The HAL collection model.
     * @return The device collection response.
     */
    CollectionResponse<DeviceResponse> getDeviceCollectionResponse(PaginationRequest request, HALCollectionWSModel collectionModel);

    /**
     * Converts a HAL model to a device response model.
     *
     * @param serverModel The HAL server model.
     * @return The device response.
     */
    DeviceResponse getDeviceResponse(HALWSModel serverModel);

    /**
     * Converts a HAL model to a device recorded time series collection response.
     *
     * @param request     The request.
     * @param serverModel The HAL server model.
     * @return The device recorded time series collection response.
     */
    DeviceRecordedTimeSeriesCollectionResponse getDeviceRecordedTimeSeries(GetDeviceRecordedTimeSeriesRequest request, HALWSModel serverModel);
}
