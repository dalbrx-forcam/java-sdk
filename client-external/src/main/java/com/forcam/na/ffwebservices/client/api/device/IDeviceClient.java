////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 13.08.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.device;

import com.forcam.na.ffwebservices.client.api.device.request.GetDeviceRecordedTimeSeriesRequest;
import com.forcam.na.ffwebservices.client.api.device.request.GetDeviceRequest;
import com.forcam.na.ffwebservices.client.api.device.request.GetDevicesRequest;
import com.forcam.na.ffwebservices.client.api.device.response.DeviceRecordedTimeSeriesCollectionPage;
import com.forcam.na.ffwebservices.client.api.exception.ForceAPIException;
import com.forcam.na.ffwebservices.client.api.pagination.response.Page;
import com.forcam.na.ffwebservices.model.device.DeviceResponse;

/**
 * Client for requesting devices.
 */
public interface IDeviceClient {

    /**
     * Sends a request to the server and gets a collection of devices as response.
     *
     * @param request The request parameter.
     * @return The device collection response.
     * @throws ForceAPIException When unable to get devices.
     */
    Page<DeviceResponse> getDevices(GetDevicesRequest request) throws ForceAPIException;

    /**
     * Sends a request to the server and gets a device by ID.
     *
     * @param request The request parameter.
     * @return The device response.
     * @throws ForceAPIException When unable to get the device.
     */
    DeviceResponse getDevice(GetDeviceRequest request) throws ForceAPIException;

    /**
     * Sends a request to the server and gets the recorded time series of a device.
     *
     * @param request The request parameter.
     * @return The device recorded time series collection response.
     * @throws ForceAPIException When unable to get the recorded time series of a device.
     */
    DeviceRecordedTimeSeriesCollectionPage getRecordedTimeSeries(GetDeviceRecordedTimeSeriesRequest request) throws ForceAPIException;
}