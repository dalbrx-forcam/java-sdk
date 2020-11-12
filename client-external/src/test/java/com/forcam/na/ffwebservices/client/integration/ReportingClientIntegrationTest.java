////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 28.11.2019.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.integration;

import com.forcam.na.ffwebservices.client.api.exception.ForceAPIException;
import com.forcam.na.ffwebservices.client.api.reporting.request.GetHitListOperatingStateMaterialRequest;
import com.forcam.na.ffwebservices.client.api.reporting.request.GetHitListOperatingStateWorkplaceRequest;
import com.forcam.na.ffwebservices.client.api.reporting.request.GetOverallEquipmentEfficiencyRequest;
import com.forcam.na.ffwebservices.client.api.reporting.request.GetOverallProcessEfficiencyRequest;
import com.forcam.na.ffwebservices.client.api.reporting.request.GetQualityDetailsMaterialRequest;
import com.forcam.na.ffwebservices.client.api.reporting.request.GetQualityDetailsWorkplaceRequest;
import com.forcam.na.ffwebservices.client.api.reporting.request.GetTotalQuantityRequest;
import com.forcam.na.ffwebservices.client.api.reporting.response.HitListOperatingStateMaterialResponse;
import com.forcam.na.ffwebservices.client.api.reporting.response.HitListOperatingStateWorkplaceResponse;
import com.forcam.na.ffwebservices.client.api.reporting.response.OverallEquipmentEfficiencyResponse;
import com.forcam.na.ffwebservices.client.api.reporting.response.OverallProcessEfficiencyResponse;
import com.forcam.na.ffwebservices.client.api.reporting.response.QualityDetailsMaterialResponse;
import com.forcam.na.ffwebservices.client.api.reporting.response.QualityDetailsWorkplaceResponse;
import com.forcam.na.ffwebservices.client.api.reporting.response.TotalQuantityResponse;
import com.forcam.na.ffwebservices.model.reporting.IReportingPaths;
import org.junit.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * Integration tests for the class {@link com.forcam.na.ffwebservices.client.api.reporting.ReportingClient}.
 */
public class ReportingClientIntegrationTest extends AbstractOpenAPIIntegrationTest {

    public ReportingClientIntegrationTest() {

        final Pattern overallEquipmentEfficiencyPattern = Pattern.compile(
            PREFIX_GET_PATH + "/reports" + IReportingPaths.OVERALL_EQUIPMENT_EFFICIENCY + ".*");
        mFileNames.put(overallEquipmentEfficiencyPattern, "json/getReportOverallEquipmentEfficiency.json");

        final Pattern overallProcessEfficiencyPattern = Pattern.compile(
            PREFIX_GET_PATH + "/reports" + IReportingPaths.OVERALL_PROCESS_EFFICIENCY + ".*");
        mFileNames.put(overallProcessEfficiencyPattern, "json/getReportOverallProcessEfficiency.json");

        final Pattern hitListOperatingStateWorkplacePattern = Pattern.compile(
            PREFIX_GET_PATH + "/reports" + IReportingPaths.HITLIST_OPERATING_STATES_WORKPLACE + ".*");
        mFileNames.put(hitListOperatingStateWorkplacePattern, "json/getReportHitListOperatingStateWorkplace.json");

        final Pattern hitListOperatingStateMaterialPattern = Pattern.compile(
            PREFIX_GET_PATH + "/reports" + IReportingPaths.HITLIST_OPERATING_STATES_MATERIAL + ".*");
        mFileNames.put(hitListOperatingStateMaterialPattern, "json/getReportHitListOperatingStateMaterial.json");

        final Pattern qualityDetailsWorkplacePattern = Pattern.compile(
            PREFIX_GET_PATH + "/reports" + IReportingPaths.QUALITY_DETAILS_WORKPLACE + ".*");
        mFileNames.put(qualityDetailsWorkplacePattern, "json/getReportQualityDetailsWorkplace.json");

        final Pattern qualityDetailsMaterialPattern = Pattern.compile(
            PREFIX_GET_PATH + "/reports" + IReportingPaths.QUALITY_DETAILS_MATERIAL + ".*");
        mFileNames.put(qualityDetailsMaterialPattern, "json/getReportQualityDetailsMaterial.json");

        final Pattern quantityLogPattern = Pattern.compile(PREFIX_GET_PATH + "/reports" + IReportingPaths.TOTAL_QUANTITY + ".*");
        mFileNames.put(quantityLogPattern, "json/getReportTotalQuantity.json");
    }

    @Test
    public void testGetOverallEquipmentEfficiency() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final GetOverallEquipmentEfficiencyRequest request = new GetOverallEquipmentEfficiencyRequest(new Date());

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final OverallEquipmentEfficiencyResponse response = mReportingClient.getOverallEquipmentEfficiency(request);

        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getProperties());
    }

    @Test
    public void testGetOverallProcessEfficiency() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final GetOverallProcessEfficiencyRequest request = new GetOverallProcessEfficiencyRequest(new Date());

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final OverallProcessEfficiencyResponse response = mReportingClient.getOverallProcessEfficiency(request);

        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getProperties());
    }

    @Test
    public void testHitListOperatingStateWorkplace() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------
        final Date date = this.getYesterdayMidnight();

        final GetHitListOperatingStateWorkplaceRequest request = new GetHitListOperatingStateWorkplaceRequest(date);
        request
            .embed()
            .workplaces(true)
            .operatingStates(true);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final HitListOperatingStateWorkplaceResponse response = mReportingClient.getHitListOperatingStateWorkplace(request);

        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getProperties());
    }

    @Test
    public void testHitListOperatingStateMaterial() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final Date date = this.getYesterdayMidnight();

        final GetHitListOperatingStateMaterialRequest request = new GetHitListOperatingStateMaterialRequest(date);
        request
            .embed()
            .materials(true)
            .operatingStates(true);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final HitListOperatingStateMaterialResponse response = mReportingClient.getHitListOperatingStateMaterial(request);

        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getProperties());
    }

    @Test
    public void testTotalQuantity() throws ForceAPIException {
        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final Date date = this.getYesterdayMidnight();

        final GetTotalQuantityRequest request = new GetTotalQuantityRequest(date);
        request
            .embed()
            .materials(true)
            .workplaces(true);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final TotalQuantityResponse response = mReportingClient.getTotalQuantity(request);

        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getProperties());
    }

    @Test
    public void testQualityDetailsWorkplace() throws ForceAPIException {
        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final Date date = this.getYesterdayMidnight();

        final GetQualityDetailsWorkplaceRequest request = new GetQualityDetailsWorkplaceRequest(date);
        request
            .embed()
            .workplaces(true)
            .qualityDetails(true)
            .qualityTypes(true);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final QualityDetailsWorkplaceResponse response = mReportingClient.getQualityDetailsWorkplace(request);

        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getProperties());
    }

    @Test
    public void testQualityDetailsMaterial() throws ForceAPIException {
        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final Date date = this.getYesterdayMidnight();

        final GetQualityDetailsMaterialRequest request = new GetQualityDetailsMaterialRequest(date);
        request.setMaterialNumber("M-15223675");
        request
            .embed()
            .materials(true)
            .qualityDetails(true)
            .qualityTypes(true);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final QualityDetailsMaterialResponse response = mReportingClient.getQualityDetailsMaterial(request);

        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getProperties());
    }

    private Date getYesterdayMidnight() {
        final LocalTime midnight = LocalTime.MIDNIGHT;
        final LocalDate today = LocalDate.now(ZoneId.of("UTC"));
        final LocalDateTime todayMidnight = LocalDateTime.of(today, midnight);
        final LocalDateTime yesterdayMidnight = todayMidnight.minusDays(1);

        return Date.from(yesterdayMidnight
                             .atZone(ZoneId.of("UTC"))
                             .toInstant());
    }

}
