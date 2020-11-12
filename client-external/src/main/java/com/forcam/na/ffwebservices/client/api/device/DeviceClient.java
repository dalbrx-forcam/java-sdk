////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 13.08.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.device;

import com.forcam.na.ffwebservices.client.api.AbstractClient;
import com.forcam.na.ffwebservices.client.api.HALCollectionWSModel;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.client.api.device.request.GetDeviceRecordedTimeSeriesRequest;
import com.forcam.na.ffwebservices.client.api.device.request.GetDeviceRequest;
import com.forcam.na.ffwebservices.client.api.device.request.GetDevicesRequest;
import com.forcam.na.ffwebservices.client.api.device.response.DeviceRecordedTimeSeriesCollectionPage;
import com.forcam.na.ffwebservices.client.api.device.response.DeviceRecordedTimeSeriesCollectionResponse;
import com.forcam.na.ffwebservices.client.api.exception.ForceAPIException;
import com.forcam.na.ffwebservices.client.api.pagination.response.CollectionResponse;
import com.forcam.na.ffwebservices.client.api.pagination.response.Page;
import com.forcam.na.ffwebservices.model.device.DeviceResponse;
import retrofit2.Call;

import javax.inject.Inject;
import java.lang.reflect.Method;

/**
 * Client for requesting devices.
 */
public class DeviceClient extends AbstractClient implements IDeviceClient {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The device endpoint. */
    private final DeviceEndpoint mDeviceEndpoint;

    /** The device response builder. */
    private final IDeviceResponseBuilder mDeviceResponseBuilder;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     *
     * @param deviceResponseBuilder Device response builder.
     * @param deviceEndpoint        Device endpoint.
     */
    @Inject
    public DeviceClient(DeviceEndpoint deviceEndpoint, IDeviceResponseBuilder deviceResponseBuilder) {
        mDeviceEndpoint = deviceEndpoint;
        mDeviceResponseBuilder = deviceResponseBuilder;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public Page<DeviceResponse> getDevices(GetDevicesRequest request) throws ForceAPIException {
        final Call<HALCollectionWSModel> call = mDeviceEndpoint.getDevices(request.getDeviceName(),
                                                                           request.getPhysicalQuantity(),
                                                                           request.getLimit(),
                                                                           request.getOffset());
        final HALCollectionWSModel responseModel = this.getResponseModel(request, call);
        final CollectionResponse<DeviceResponse> response = mDeviceResponseBuilder.getDeviceCollectionResponse(request, responseModel);

        final Method m = new Object() {}
            .getClass()
            .getEnclosingMethod();
        return new Page<>(this, m, response);
    }

    @Override
    public DeviceResponse getDevice(GetDeviceRequest request) throws ForceAPIException {
        final Call<HALWSModel> call = mDeviceEndpoint.getDevice(request.getId());
        final HALWSModel responseModel = this.getResponseModel(request, call);
        return mDeviceResponseBuilder.getDeviceResponse(responseModel);
    }

    @Override
    public DeviceRecordedTimeSeriesCollectionPage getRecordedTimeSeries(GetDeviceRecordedTimeSeriesRequest request) throws ForceAPIException {
        final Call<HALWSModel> call = mDeviceEndpoint.getRecordedTimeSeries(request.getDevicesId(),
                                                                            request.getStartDate(),
                                                                            request.getEndDate(),
                                                                            request.getTag(),
                                                                            request.getMaterialNumber(),
                                                                            request.getProductionOrderNumber(),
                                                                            request.getOperationNumber(),
                                                                            request.getLimit(),
                                                                            request.getPaginationDirection(),
                                                                            request.getPaginationTimestamp());
        final HALWSModel responseModel = this.getResponseModel(request, call);
        final DeviceRecordedTimeSeriesCollectionResponse response = mDeviceResponseBuilder.getDeviceRecordedTimeSeries(request, responseModel);

        final Method m = new Object() {}
            .getClass()
            .getEnclosingMethod();
        return new DeviceRecordedTimeSeriesCollectionPage(this, m, response);
    }
}