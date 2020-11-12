package com.forcam.na.ffwebservices.client.api.device;

import com.forcam.na.common.webserviceaccess.requestparams.PaginationDirection;
import com.forcam.na.ffwebservices.client.api.AbstractOpenAPIMockTest;
import com.forcam.na.ffwebservices.client.api.config.GuiceTestRunner;
import com.forcam.na.ffwebservices.client.api.device.request.GetDeviceRecordedTimeSeriesRequest;
import com.forcam.na.ffwebservices.client.api.device.request.GetDeviceRequest;
import com.forcam.na.ffwebservices.client.api.device.request.GetDevicesRequest;
import com.forcam.na.ffwebservices.client.api.device.response.DeviceRecordedTimeSeriesCollectionPage;
import com.forcam.na.ffwebservices.client.api.exception.ForceAPIException;
import com.forcam.na.ffwebservices.client.api.pagination.response.Page;
import com.forcam.na.ffwebservices.model.DateFormatUtility;
import com.forcam.na.ffwebservices.model.collection.Pagination;
import com.forcam.na.ffwebservices.model.device.DeviceResponse;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.RecordedRequest;
import org.apache.commons.lang3.StringUtils;
import org.junit.*;
import org.junit.rules.*;
import org.junit.runner.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.Date;

////////////////////////////////////////////////////////////////////////////////
//
// Created by Dimitri Schulz on 20.09.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
@RunWith(GuiceTestRunner.class)
public class DeviceClientTest extends AbstractOpenAPIMockTest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Helper for test exceptions and messages. */
    @Rule
    public ExpectedException mExpectedException = ExpectedException.none();

    private IDeviceClient mIDeviceClient;

    // ------------------------------------------------------------------------
    // constructor
    // ------------------------------------------------------------------------

    public DeviceClientTest() {
        mIDeviceClient = mBridgeAPIComponent.deviceClient();
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    /**
     * Test to getting devices
     *
     * @throws IOException          When unable to read the JSON file.
     * @throws URISyntaxException   When unable to create a URI of the JSON file.
     * @throws ForceAPIException    When unable to get devices.
     * @throws InterruptedException When unable to take the request from the server.
     */
    @Test
    public void getDevices() throws IOException, URISyntaxException, ForceAPIException, InterruptedException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------
        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getDevices.json")));

        final int limit = 2;
        final int offset = 1;
        final GetDevicesRequest request = new GetDevicesRequest();
        request.setLimit(limit);
        request.setOffset(offset);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------
        final Page<DeviceResponse> response = mIDeviceClient.getDevices(request);

        final RecordedRequest recordedRequest = mMockWebServer.takeRequest();
        final String requestQuery = recordedRequest
            .getRequestUrl()
            .query();
        Assert.assertNotNull(requestQuery);
        Assert.assertTrue(requestQuery.contains("limit=" + limit));
        Assert.assertTrue(requestQuery.contains("offset=" + offset));
        Assert.assertNotNull(response);
        Assert.assertFalse(response
                               .getElements()
                               .isEmpty());
        Assert.assertNotNull(response
                                 .getResponse()
                                 .getPaginationLinks()
                                 .getNext());
        Assert.assertNotNull(response
                                 .getResponse()
                                 .getPaginationLinks()
                                 .getLast());
        Assert.assertNotNull(response
                                 .getResponse()
                                 .getPaginationLinks()
                                 .getFirst());
        Assert.assertNotNull(response
                                 .getResponse()
                                 .getPaginationLinks()
                                 .getSelf());
        Assert.assertNull(response
                              .getResponse()
                              .getPaginationLinks()
                              .getPrev());

        Assert.assertTrue(response
                              .getResponse()
                              .getPagination()
                              .getOffset()
                              .isPresent());
        Assert.assertFalse(response
                               .getResponse()
                               .getPagination()
                               .getFirstDate()
                               .isPresent());
        Assert.assertFalse(response
                               .getResponse()
                               .getPagination()
                               .getLastDate()
                               .isPresent());
        Assert.assertTrue(response
                              .getResponse()
                              .getPagination()
                              .getPaginationType() == Pagination.PaginationType.OFFSET);
    }

    /**
     * Test to get a device.
     *
     * @throws IOException        When unable to read the JSON file.
     * @throws URISyntaxException When unable to create a URI of the JSON file.
     * @throws ForceAPIException  When unable to get devices.
     */
    @Test
    public void getDevice() throws IOException, URISyntaxException, ForceAPIException {
        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getDevice.json")));
        final String deviceId = "417";
        final GetDeviceRequest request = new GetDeviceRequest(deviceId);
        final DeviceResponse response = mIDeviceClient.getDevice(request);
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getSelf());
        Assert.assertNotNull(response.getProperties());
        Assert.assertFalse(response
                               .getProperties()
                               .getRecordedPhysicalQuantities()
                               .isEmpty());
    }

    /**
     * Test to get first page of recorded time series.
     *
     * @throws IOException        When unable to read the JSON file.
     * @throws URISyntaxException When unable to create a URI of the JSON file.
     * @throws ParseException     When unable to parse timestamp string.
     * @throws ForceAPIException  When unable to get devices.
     */
    @Test
    public void getRecordedTimeSeries() throws IOException, URISyntaxException, ParseException, ForceAPIException {
        DeviceRecordedTimeSeriesCollectionPage response = testGetRecordedTimeSeries("json/getDeviceRecordedTimeSeries.json", "", null);
        Assert.assertNull(response
                              .getResponse()
                              .getPaginationLinks()
                              .getPrev());
    }

    /**
     * Test to get next page of recordet time series.
     *
     * @throws IOException        When unable to read the JSON file.
     * @throws URISyntaxException When unable to create a URI of the JSON file.
     * @throws ParseException     When unable to parse timestamp string.
     * @throws ForceAPIException  When unable to get devices.
     */
    @Test
    public void getNextRecordedTimeSeries() throws IOException, URISyntaxException, ParseException, ForceAPIException {
        DeviceRecordedTimeSeriesCollectionPage response = testGetRecordedTimeSeries("json/getDeviceNextRecordedTimeSeries.json",
                                                                                    "2018-09-16T02:19:57.875Z",
                                                                                    PaginationDirection.NEXT);
        Assert.assertNotNull(response
                                 .getResponse()
                                 .getPaginationLinks()
                                 .getPrev());
    }

    /**
     * Test to get previous page of recorded time series.
     *
     * @throws IOException        When unable to read the JSON file.
     * @throws URISyntaxException When unable to create a URI of the JSON file.
     * @throws ParseException     When unable to parse timestamp string.
     * @throws ForceAPIException  When unable to get devices.
     */
    @Test
    public void getPreviousRecordedTimeSeries() throws IOException, URISyntaxException, ParseException, ForceAPIException {
        DeviceRecordedTimeSeriesCollectionPage response = testGetRecordedTimeSeries("json/getDevicePreviousRecordedTimeSeries.json",
                                                                                    "2018-09-16T02:19:56.881Z",
                                                                                    PaginationDirection.PREVIOUS);
        Assert.assertNull(response
                              .getResponse()
                              .getPaginationLinks()
                              .getPrev());
    }

    /**
     * Test for testing getRecordedTimeSeries for some situations.
     *
     * @param jsonFileName         Result json file name.
     * @param paginationTimeseries Pagination time series date string.
     * @param paginationDiretion   Pagination direction.
     * @return Recordet time series collection.
     * @throws IOException        When unable to read the JSON file.
     * @throws URISyntaxException When unable to create a URI of the JSON file.
     * @throws ParseException     When unable to parse timestamp string.
     * @throws ForceAPIException  When unable to get devices.
     */
    private DeviceRecordedTimeSeriesCollectionPage testGetRecordedTimeSeries(String jsonFileName, String paginationTimeseries,
                                                                             PaginationDirection paginationDiretion)
        throws IOException, URISyntaxException, ParseException, ForceAPIException {
        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson(jsonFileName)));

        final int limit = 10;
        final String deviceId = "417";
        final String tag = "1";
        final Date endDate = DateFormatUtility.SIMPLE_DATE_FORMAT.parse("2018-09-16T02:20:06.881Z");
        final Date startDate = DateFormatUtility.SIMPLE_DATE_FORMAT.parse("2018-09-16T02:18:27.779Z");
        GetDeviceRecordedTimeSeriesRequest request = new GetDeviceRecordedTimeSeriesRequest(deviceId);

        if (StringUtils.isNotEmpty(paginationTimeseries)) {
            request.setPaginationTimestamp(DateFormatUtility.SIMPLE_DATE_FORMAT.parse(paginationTimeseries));
        }

        if (paginationDiretion != null) {
            request.setPaginationDirection(paginationDiretion);
        }

        request.setTag(tag);
        request.setLimit(limit);
        request.setEndDate(endDate);
        request.setStartDate(startDate);

        DeviceRecordedTimeSeriesCollectionPage response = mIDeviceClient.getRecordedTimeSeries(request);

        Assert.assertNotNull(response);
        Assert.assertFalse(response
                               .getElements()
                               .isEmpty());
        Assert.assertNotNull(response
                                 .getResponse()
                                 .getPaginationLinks()
                                 .getFirst());
        Assert.assertNotNull(response
                                 .getResponse()
                                 .getPaginationLinks()
                                 .getLast());
        Assert.assertNotNull(response
                                 .getResponse()
                                 .getPaginationLinks()
                                 .getNext());
        Assert.assertFalse(response
                               .getResponse()
                               .getPagination()
                               .getOffset()
                               .isPresent());
        Assert.assertTrue(response
                              .getResponse()
                              .getPagination()
                              .getFirstDate()
                              .isPresent());
        Assert.assertTrue(response
                              .getResponse()
                              .getPagination()
                              .getLastDate()
                              .isPresent());
        Assert.assertTrue(response
                              .getResponse()
                              .getPagination()
                              .getPaginationType() == Pagination.PaginationType.IDENTIFIER);

        return response;
    }

}