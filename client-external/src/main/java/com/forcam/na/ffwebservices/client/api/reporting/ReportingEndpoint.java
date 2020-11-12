////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 28.11.2019.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.reporting;

import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.model.IRequestAndQueryParams;
import com.forcam.na.ffwebservices.model.reporting.IReportingPaths;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.Date;

/**
 * Endpoint for reporting webservices.
 */
public interface ReportingEndpoint {

    @GET(IReportingPaths.REPORTS + IReportingPaths.OVERALL_EQUIPMENT_EFFICIENCY)
    Call<HALWSModel> getOverallEquipmentEfficiency(
        @Query(IRequestAndQueryParams.WORKPLACE_ID)
            String workplaceId,
        @Query(IRequestAndQueryParams.WORKPLACE_NUMBER)
            String workplaceNumber,
        @Query(IRequestAndQueryParams.WORKPLACE_GROUP_ID)
            String workplaceGroupId,
        @Query(IRequestAndQueryParams.WORKPLACE_GROUP_NUMBER)
            String workplaceGroupNumber,
        @Query(IRequestAndQueryParams.START_DATE)
            Date startDate,
        @Query(IRequestAndQueryParams.END_DATE)
            Date endDate);

    @GET(IReportingPaths.REPORTS + IReportingPaths.OVERALL_PROCESS_EFFICIENCY)
    Call<HALWSModel> getOverallProcessEfficiency(
        @Query(IRequestAndQueryParams.PRODUCTION_ORDER_ID)
            String productionOrderId,
        @Query(IRequestAndQueryParams.MATERIAL_ID)
            String materialId,
        @Query(IRequestAndQueryParams.MATERIAL_NUMBER)
            String materialNumber,
        @Query(IRequestAndQueryParams.START_DATE)
            Date startDate,
        @Query(IRequestAndQueryParams.END_DATE)
            Date endDate);

    @GET(IReportingPaths.REPORTS + IReportingPaths.HITLIST_OPERATING_STATES_WORKPLACE)
    Call<HALWSModel> getHitListOperatingStateWorkplace(
        @Query(IRequestAndQueryParams.WORKPLACE_ID)
            String workplaceId,
        @Query(IRequestAndQueryParams.WORKPLACE_NUMBER)
            String workplaceNumber,
        @Query(IRequestAndQueryParams.WORKPLACE_GROUP_ID)
            String workplaceGroupId,
        @Query(IRequestAndQueryParams.WORKPLACE_GROUP_NUMBER)
            String workplaceGroupNumber,
        @Query(IRequestAndQueryParams.START_DATE)
            Date startDate,
        @Query(IRequestAndQueryParams.END_DATE)
            Date endDate,
        @Query(IRequestAndQueryParams.EMBED)
            String embed);

    @GET(IReportingPaths.REPORTS + IReportingPaths.HITLIST_OPERATING_STATES_MATERIAL)
    Call<HALWSModel> getHitListOperatingStateMaterial(
        @Query(IRequestAndQueryParams.MATERIAL_ID)
            String materialId,
        @Query(IRequestAndQueryParams.MATERIAL_NUMBER)
            String materialNumber,
        @Query(IRequestAndQueryParams.START_DATE)
            Date startDate,
        @Query(IRequestAndQueryParams.END_DATE)
            Date endDate,
        @Query(IRequestAndQueryParams.EMBED)
            String embed);

    @GET(IReportingPaths.REPORTS + IReportingPaths.TOTAL_QUANTITY)
    Call<HALWSModel> getTotalQuantity(
        @Query(IRequestAndQueryParams.WORKPLACE_ID)
            String workplaceId,
        @Query(IRequestAndQueryParams.WORKPLACE_NUMBER)
            String workplaceNumber,
        @Query(IRequestAndQueryParams.WORKPLACE_GROUP_ID)
            String workplaceGroupId,
        @Query(IRequestAndQueryParams.WORKPLACE_GROUP_NUMBER)
            String workplaceGroupNumber,
        @Query(IRequestAndQueryParams.START_DATE)
            Date startDate,
        @Query(IRequestAndQueryParams.END_DATE)
            Date endDate,
        @Query(IRequestAndQueryParams.EMBED)
            String embed);

    @GET(IReportingPaths.REPORTS + IReportingPaths.QUALITY_DETAILS_MATERIAL)
    Call<HALWSModel> getQualityDetailsMaterial(
        @Query(IRequestAndQueryParams.MATERIAL_ID)
            String materialId,
        @Query(IRequestAndQueryParams.MATERIAL_NUMBER)
            String materialNumber,
        @Query(IRequestAndQueryParams.START_DATE)
            Date startDate,
        @Query(IRequestAndQueryParams.END_DATE)
            Date endDate,
        @Query(IRequestAndQueryParams.EMBED)
            String embed);

    @GET(IReportingPaths.REPORTS + IReportingPaths.QUALITY_DETAILS_WORKPLACE)
    Call<HALWSModel> getQualityDetailsWorkplace(
        @Query(IRequestAndQueryParams.WORKPLACE_ID)
            String workplaceId,
        @Query(IRequestAndQueryParams.WORKPLACE_NUMBER)
            String workplaceNumber,
        @Query(IRequestAndQueryParams.WORKPLACE_GROUP_ID)
            String workplaceGroupId,
        @Query(IRequestAndQueryParams.WORKPLACE_GROUP_NUMBER)
            String workplaceGroupNumber,
        @Query(IRequestAndQueryParams.MATERIAL_ID)
            String materialId,
        @Query(IRequestAndQueryParams.MATERIAL_NUMBER)
            String materialNumber,
        @Query(IRequestAndQueryParams.START_DATE)
            Date startDate,
        @Query(IRequestAndQueryParams.END_DATE)
            Date endDate,
        @Query(IRequestAndQueryParams.EMBED)
            String embed);
}
