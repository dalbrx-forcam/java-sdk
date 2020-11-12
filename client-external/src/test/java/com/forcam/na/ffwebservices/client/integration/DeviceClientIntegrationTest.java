package com.forcam.na.ffwebservices.client.integration;

import com.forcam.na.common.webserviceaccess.requestparams.PaginationDirection;
import com.forcam.na.ffwebservices.client.api.device.DeviceClient;
import com.forcam.na.ffwebservices.client.api.device.request.GetDeviceRecordedTimeSeriesRequest;
import com.forcam.na.ffwebservices.client.api.device.request.GetDeviceRequest;
import com.forcam.na.ffwebservices.client.api.device.request.GetDevicesRequest;
import com.forcam.na.ffwebservices.client.api.device.response.DeviceRecordedTimeSeriesCollectionPage;
import com.forcam.na.ffwebservices.client.api.exception.ForceAPIException;
import com.forcam.na.ffwebservices.client.api.pagination.response.Page;
import com.forcam.na.ffwebservices.model.DateFormatUtility;
import com.forcam.na.ffwebservices.model.device.DeviceResponse;
import org.junit.*;

import java.text.ParseException;
import java.util.regex.Pattern;

////////////////////////////////////////////////////////////////////////////////
//
// Created by Dimitri Schulz on 20.09.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
public class DeviceClientIntegrationTest extends AbstractOpenAPIIntegrationTest {

    public DeviceClientIntegrationTest() {

        final Pattern nextPageTimeSeriesPattern = Pattern.compile(PREFIX_GET_PATH + "/devices/.{3}/recordedTimeSeries\\?.*paginationDirection=NEXT.*");
        mFileNames.put(nextPageTimeSeriesPattern, "json/getDeviceNextRecordedTimeSeries.json");

        final Pattern previousPageTimeSeriesPattern = Pattern.compile(
            PREFIX_GET_PATH + "/devices/.{3}/recordedTimeSeries\\?.*paginationDirection=PREVIOUS.*");
        mFileNames.put(previousPageTimeSeriesPattern, "json/getDevicePreviousRecordedTimeSeries.json");

        final Pattern firstPageTimeSeriesPattern = Pattern.compile(PREFIX_GET_PATH + "/devices/.{3}/recordedTimeSeries\\?.*limit=10$");
        mFileNames.put(firstPageTimeSeriesPattern, "json/getDeviceRecordedTimeSeries.json");

        final Pattern devicesPattern = Pattern.compile(PREFIX_GET_PATH + "/devices\\?.*limit=100.*.");
        mFileNames.put(devicesPattern, "json/getDevices.json");

        final Pattern devicePattern = Pattern.compile(PREFIX_GET_PATH + "/devices/.{3}\\?.*");
        mFileNames.put(devicePattern, "json/getDevice.json");

    }

    /**
     * Test for the method {@link DeviceClient#getDevices(GetDevicesRequest)}.
     *
     * @throws ForceAPIException
     */
    @Test
    public void testGetDevices() throws ForceAPIException {

        final GetDevicesRequest request = new GetDevicesRequest();
        request.setLimit(100);
        request.setOffset(0);
        //        request.setPhysicalQuantity("Temp1");

        final Page<DeviceResponse> response = mDeviceClient.getDevices(request);

        Assert.assertNotNull(response);
        Assert.assertFalse(response
                               .getElements()
                               .isEmpty());
    }

    /**
     * Test for the method {@link DeviceClient#getDevice(GetDeviceRequest)}.
     *
     * @throws ForceAPIException
     */
    @Test
    public void getDevice() throws ForceAPIException {

        final GetDeviceRequest request = new GetDeviceRequest("417");
        final DeviceResponse device = mDeviceClient.getDevice(request);
        Assert.assertNotNull(device);
    }

    /**
     * Test for the method {@link DeviceClient#getRecordedTimeSeries(GetDeviceRecordedTimeSeriesRequest)}.
     * First page.
     *
     * @throws ForceAPIException
     * @throws ParseException
     */
    @Test
    public void getRecordedTimeSeries() throws ForceAPIException, ParseException {
        final GetDeviceRecordedTimeSeriesRequest request = new GetDeviceRecordedTimeSeriesRequest("417");
        request.setTag("1");
        request.setLimit(10);
        request.setEndDate(DateFormatUtility.SIMPLE_DATE_FORMAT.parse("2018-09-16T02:20:06.881Z"));
        request.setStartDate(DateFormatUtility.SIMPLE_DATE_FORMAT.parse("2018-09-16T02:18:27.779Z"));

        final DeviceRecordedTimeSeriesCollectionPage timeSeriesCollection = mDeviceClient.getRecordedTimeSeries(request);

        Assert.assertNotNull(timeSeriesCollection);
        Assert.assertFalse(timeSeriesCollection
                               .getElements()
                               .isEmpty());
    }

    /**
     * Test for the method {@link DeviceClient#getRecordedTimeSeries(GetDeviceRecordedTimeSeriesRequest)}.
     * Next page.
     *
     * @throws ForceAPIException
     * @throws ParseException
     */
    @Test
    public void getRecordedTimeSeriesNext() throws ForceAPIException, ParseException {
        final GetDeviceRecordedTimeSeriesRequest request = new GetDeviceRecordedTimeSeriesRequest("417");
        request.setTag("1");
        request.setLimit(10);
        request.setEndDate(DateFormatUtility.SIMPLE_DATE_FORMAT.parse("2018-09-16T02:20:06.881Z"));
        request.setStartDate(DateFormatUtility.SIMPLE_DATE_FORMAT.parse("2018-09-16T02:18:27.779Z"));

        //second page!
        request.setPaginationTimestamp(DateFormatUtility.SIMPLE_DATE_FORMAT.parse("2018-09-16T02:19:57.875Z"));
        request.setPaginationDirection(PaginationDirection.NEXT);

        final DeviceRecordedTimeSeriesCollectionPage timeSeriesCollection = mDeviceClient.getRecordedTimeSeries(request);

        Assert.assertNotNull(timeSeriesCollection);
        Assert.assertFalse(timeSeriesCollection
                               .getElements()
                               .isEmpty());
    }

    /**
     * Test for the method {@link DeviceClient#getRecordedTimeSeries(GetDeviceRecordedTimeSeriesRequest)}.
     * Previous page.
     *
     * @throws ForceAPIException
     * @throws ParseException
     */
    @Test
    public void getRecordedTimeSeriesPrevious() throws ForceAPIException, ParseException {
        final GetDeviceRecordedTimeSeriesRequest request = new GetDeviceRecordedTimeSeriesRequest("417");
        request.setTag("1");
        request.setLimit(10);
        request.setEndDate(DateFormatUtility.SIMPLE_DATE_FORMAT.parse("2018-09-16T02:20:06.881Z"));
        request.setStartDate(DateFormatUtility.SIMPLE_DATE_FORMAT.parse("2018-09-16T02:18:27.779Z"));

        //second page!
        request.setPaginationTimestamp(DateFormatUtility.SIMPLE_DATE_FORMAT.parse("2018-09-16T02:19:56.881Z"));
        request.setPaginationDirection(PaginationDirection.PREVIOUS);

        final DeviceRecordedTimeSeriesCollectionPage timeSeriesCollection = mDeviceClient.getRecordedTimeSeries(request);

        Assert.assertNotNull(timeSeriesCollection);
        Assert.assertFalse(timeSeriesCollection
                               .getElements()
                               .isEmpty());
    }
}