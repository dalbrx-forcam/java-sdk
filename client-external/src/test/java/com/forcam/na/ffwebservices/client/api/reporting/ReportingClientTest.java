////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 28.11.2019.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.reporting;

import com.forcam.na.ffwebservices.client.api.AbstractOpenAPIMockTest;
import com.forcam.na.ffwebservices.client.api.config.GuiceTestRunner;
import com.forcam.na.ffwebservices.client.api.exception.ForceAPIException;
import com.forcam.na.ffwebservices.client.api.reporting.request.GetHitListOperatingStateWorkplaceRequest;
import com.forcam.na.ffwebservices.client.api.reporting.request.GetOverallEquipmentEfficiencyRequest;
import com.forcam.na.ffwebservices.client.api.reporting.request.GetOverallProcessEfficiencyRequest;
import com.forcam.na.ffwebservices.client.api.reporting.request.GetQualityDetailsMaterialRequest;
import com.forcam.na.ffwebservices.client.api.reporting.request.GetQualityDetailsWorkplaceRequest;
import com.forcam.na.ffwebservices.client.api.reporting.request.GetTotalQuantityRequest;
import com.forcam.na.ffwebservices.client.api.reporting.response.HitListOperatingStateWorkplaceResponse;
import com.forcam.na.ffwebservices.client.api.reporting.response.OverallEquipmentEfficiencyResponse;
import com.forcam.na.ffwebservices.client.api.reporting.response.OverallProcessEfficiencyResponse;
import com.forcam.na.ffwebservices.client.api.reporting.response.QualityDetailsMaterialResponse;
import com.forcam.na.ffwebservices.client.api.reporting.response.QualityDetailsWorkplaceResponse;
import com.forcam.na.ffwebservices.client.api.reporting.response.TotalQuantityResponse;
import okhttp3.mockwebserver.MockResponse;
import org.junit.*;
import org.junit.runner.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Date;

/**
 * Tests for the {@link ReportingClient}.
 */
@RunWith(GuiceTestRunner.class)
public class ReportingClientTest extends AbstractOpenAPIMockTest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private final IReportingClient mReportingClient;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    public ReportingClientTest() {
        mReportingClient = mBridgeAPIComponent.reportingClient();
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Test
    public void testGetOverallEquipmentEfficiency() throws ForceAPIException, IOException, URISyntaxException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getReportOverallEquipmentEfficiency.json")));
        final GetOverallEquipmentEfficiencyRequest request = new GetOverallEquipmentEfficiencyRequest(new Date());

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final OverallEquipmentEfficiencyResponse response = mReportingClient.getOverallEquipmentEfficiency(request);

        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getSelf());

        Assert.assertNotNull(response.getProperties());
    }

    @Test
    public void testGetOverallProcessEfficiency() throws ForceAPIException, IOException, URISyntaxException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getReportOverallProcessEfficiency.json")));
        final GetOverallProcessEfficiencyRequest request = new GetOverallProcessEfficiencyRequest(new Date());

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final OverallProcessEfficiencyResponse response = mReportingClient.getOverallProcessEfficiency(request);

        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getSelf());

        Assert.assertNotNull(response.getProperties());
    }

    @Test
    public void testHitListOperatingStateWorkplace() throws ForceAPIException, IOException, URISyntaxException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getReportHitListOperatingStateWorkplace.json")));
        final GetHitListOperatingStateWorkplaceRequest request = new GetHitListOperatingStateWorkplaceRequest(new Date());

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final HitListOperatingStateWorkplaceResponse response = mReportingClient.getHitListOperatingStateWorkplace(request);

        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getSelf());

        Assert.assertNotNull(response.getProperties());
    }

    @Test
    public void testTotalQuantity() throws ForceAPIException, IOException, URISyntaxException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getReportTotalQuantity.json")));
        final GetTotalQuantityRequest request = new GetTotalQuantityRequest(new Date());

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final TotalQuantityResponse response = mReportingClient.getTotalQuantity(request);

        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getSelf());

        Assert.assertNotNull(response.getProperties());
    }

    @Test
    public void testQualityDetailsWorkplace() throws ForceAPIException, IOException, URISyntaxException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getReportQualityDetailsWorkplace.json")));
        final GetQualityDetailsWorkplaceRequest request = new GetQualityDetailsWorkplaceRequest(new Date());

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final QualityDetailsWorkplaceResponse response = mReportingClient.getQualityDetailsWorkplace(request);

        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getSelf());

        Assert.assertNotNull(response.getProperties());
    }

    @Test
    public void testQualityDetailsMaterial() throws ForceAPIException, IOException, URISyntaxException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getReportQualityDetailsMaterial.json")));
        final GetQualityDetailsMaterialRequest request = new GetQualityDetailsMaterialRequest(new Date());

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final QualityDetailsMaterialResponse response = mReportingClient.getQualityDetailsMaterial(request);

        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getSelf());

        Assert.assertNotNull(response.getProperties());
    }

}
