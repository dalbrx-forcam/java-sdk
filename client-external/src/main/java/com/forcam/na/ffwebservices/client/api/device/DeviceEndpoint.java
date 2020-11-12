////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 13.08.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.device;

import com.forcam.na.common.webserviceaccess.requestparams.PaginationDirection;
import com.forcam.na.ffwebservices.client.api.HALCollectionWSModel;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.model.IRequestAndQueryParams;
import com.forcam.na.ffwebservices.model.device.IDevicePaths;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.util.Date;

/**
 * An interface with methods for creating calls that can be sent to the server.
 */
public interface DeviceEndpoint {

    /**
     * Creates a call that can be sent to the server and gets all devices.
     *
     * @param deviceName       The device name.
     * @param physicalQuantity The physical quantity.
     * @param limit            The limit.
     * @param offset           The offset.
     * @return A call that can be sent to the server.
     */
    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @GET(IDevicePaths.DEVICES)
    Call<HALCollectionWSModel> getDevices(
        @Query(IRequestAndQueryParams.DEVICE_NAME)
            String deviceName,
        @Query(IRequestAndQueryParams.PHYSICAL_QUANTITY)
            String physicalQuantity,
        @Query(IRequestAndQueryParams.LIMIT)
            int limit,
        @Query(IRequestAndQueryParams.OFFSET)
            int offset);

    /**
     * Creates a call that can be sent to the server and gets a device by ID.
     *
     * @param deviceId The device ID.
     * @return A call that can be sent to the server.
     */
    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @GET(IDevicePaths.DEVICES + "/{" + IRequestAndQueryParams.DEVICE_ID + "}")
    Call<HALWSModel> getDevice(
        @Path(IRequestAndQueryParams.DEVICE_ID)
            String deviceId);

    /**
     * Creates a call that can be sent to the server and gets the time course of recorded process parameters or sensory measured values.
     *
     * @param deviceId              The device ID.
     * @param startDate             The start date of the considered period (default value: beginning of the current hour).
     * @param endDate               The end date of the considered period.
     * @param tag                   The tag for a specific variable or process parameter.
     * @param materialNumber        The material number.
     * @param productionOrderNumber The production order number.
     * @param operationNumber       The operation number.
     * @param limit                 The limit.
     * @param paginationDirection   The pagination direction.
     * @param paginationTimestamp   The pagination timestamp.
     * @return A call that can be sent to the server.
     */
    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @GET(IDevicePaths.DEVICES + "/{" + IRequestAndQueryParams.DEVICE_ID + "}/" + IDevicePaths.RECORDED_TIME_SERIES)
    Call<HALWSModel> getRecordedTimeSeries(
        @Path(IRequestAndQueryParams.DEVICE_ID)
            String deviceId,
        @Query(IRequestAndQueryParams.START_DATE)
            Date startDate,
        @Query(IRequestAndQueryParams.END_DATE)
            Date endDate,
        @Query(IRequestAndQueryParams.TAG)
            String tag,
        @Query(IRequestAndQueryParams.MATERIAL_NUMBER)
            String materialNumber,
        @Query(IRequestAndQueryParams.PRODUCTION_ORDER_NUMBER)
            String productionOrderNumber,
        @Query(IRequestAndQueryParams.OPERATION_NUMBER)
            String operationNumber,
        @Query(IRequestAndQueryParams.LIMIT)
            int limit,
        @Query(IRequestAndQueryParams.PAGINATION_DIRECTION)
            PaginationDirection paginationDirection,
        @Query(IRequestAndQueryParams.PAGINATION_TIMESTAMP)
            Date paginationTimestamp);
}