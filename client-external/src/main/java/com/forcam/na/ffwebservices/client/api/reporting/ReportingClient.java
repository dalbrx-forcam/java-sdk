////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 28.11.2019.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.reporting;

import com.forcam.na.ffwebservices.client.api.AbstractClient;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
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
import retrofit2.Call;

import javax.inject.Inject;

/**
 * Client implementing reporting methods.
 */
public class ReportingClient extends AbstractClient implements IReportingClient {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private final ReportingEndpoint mReportingEndpoint;

    private final IReportingResponseBuilder mReportingResponseBuilder;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    @Inject
    public ReportingClient(ReportingEndpoint endpoint, IReportingResponseBuilder reportingResponseBuilder) {
        mReportingEndpoint = endpoint;
        mReportingResponseBuilder = reportingResponseBuilder;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public OverallEquipmentEfficiencyResponse getOverallEquipmentEfficiency(GetOverallEquipmentEfficiencyRequest request) throws ForceAPIException {
        final Call<HALWSModel> call = mReportingEndpoint.getOverallEquipmentEfficiency(request.getWorkplaceId(),
                                                                                       request.getWorkplaceNumber(),
                                                                                       request.getWorkplaceGroupId(),
                                                                                       request.getWorkplaceGroupNumber(),
                                                                                       request.getStartDate(),
                                                                                       request.getEndDate());
        final HALWSModel responseModel = this.getResponseModel(request, call);
        return mReportingResponseBuilder.getOverallEquipmentEfficiencyResponse(responseModel);
    }

    @Override
    public OverallProcessEfficiencyResponse getOverallProcessEfficiency(GetOverallProcessEfficiencyRequest request) throws ForceAPIException {
        final Call<HALWSModel> call = mReportingEndpoint.getOverallProcessEfficiency(request.getProductionOrderId(),
                                                                                     request.getMaterialId(),
                                                                                     request.getMaterialNumber(),
                                                                                     request.getStartDate(),
                                                                                     request.getEndDate());
        final HALWSModel responseModel = this.getResponseModel(request, call);
        return mReportingResponseBuilder.getOverallProcessEfficiencyResponse(responseModel);
    }

    @Override
    public HitListOperatingStateWorkplaceResponse getHitListOperatingStateWorkplace(GetHitListOperatingStateWorkplaceRequest request) throws ForceAPIException {
        final Call<HALWSModel> call = mReportingEndpoint.getHitListOperatingStateWorkplace(request.getWorkplaceId(),
                                                                                           request.getWorkplaceNumber(),
                                                                                           request.getWorkplaceGroupId(),
                                                                                           request.getWorkplaceGroupNumber(),
                                                                                           request.getStartDate(),
                                                                                           request.getEndDate(),
                                                                                           request
                                                                                               .embed()
                                                                                               .toString());
        final HALWSModel responseModel = this.getResponseModel(request, call);
        return mReportingResponseBuilder.getHitListOperatingStateWorkplaceResponse(responseModel);
    }

    @Override
    public HitListOperatingStateMaterialResponse getHitListOperatingStateMaterial(GetHitListOperatingStateMaterialRequest request) throws ForceAPIException {
        final Call<HALWSModel> call = mReportingEndpoint.getHitListOperatingStateMaterial(request.getMaterialId(),
                                                                                          request.getMaterialNumber(),
                                                                                          request.getStartDate(),
                                                                                          request.getEndDate(),
                                                                                          request
                                                                                              .embed()
                                                                                              .toString());
        final HALWSModel responseModel = this.getResponseModel(request, call);
        return mReportingResponseBuilder.getHitListOperatingStateMaterialResponse(responseModel);
    }

    @Override
    public QualityDetailsMaterialResponse getQualityDetailsMaterial(GetQualityDetailsMaterialRequest request) throws ForceAPIException {
        final Call<HALWSModel> call = mReportingEndpoint.getQualityDetailsMaterial(request.getMaterialId(),
                                                                                   request.getMaterialNumber(),
                                                                                   request.getStartDate(),
                                                                                   request.getEndDate(),
                                                                                   request
                                                                                       .embed()
                                                                                       .toString());
        final HALWSModel responseModel = this.getResponseModel(request, call);
        return mReportingResponseBuilder.getQualityDetailsMaterialResponse(responseModel);
    }

    @Override
    public QualityDetailsWorkplaceResponse getQualityDetailsWorkplace(GetQualityDetailsWorkplaceRequest request) throws ForceAPIException {
        final Call<HALWSModel> call = mReportingEndpoint.getQualityDetailsWorkplace(request.getWorkplaceId(),
                                                                                    request.getWorkplaceNumber(),
                                                                                    request.getWorkplaceGroupId(),
                                                                                    request.getWorkplaceGroupNumber(),
                                                                                    request.getMaterialId(),
                                                                                    request.getMaterialNumber(),
                                                                                    request.getStartDate(),
                                                                                    request.getEndDate(),
                                                                                    request
                                                                                        .embed()
                                                                                        .toString());
        final HALWSModel responseModel = this.getResponseModel(request, call);
        return mReportingResponseBuilder.getQualityDetailsWorkplaceResponse(responseModel);
    }

    @Override
    public TotalQuantityResponse getTotalQuantity(GetTotalQuantityRequest request) throws ForceAPIException {
        final Call<HALWSModel> call = mReportingEndpoint.getTotalQuantity(request.getWorkplaceId(),
                                                                          request.getWorkplaceNumber(),
                                                                          request.getWorkplaceGroupId(),
                                                                          request.getWorkplaceGroupNumber(),
                                                                          request.getStartDate(),
                                                                          request.getEndDate(),
                                                                          request.embed().toString());
        final HALWSModel responseModel = this.getResponseModel(request, call);
        return mReportingResponseBuilder.getQuantityLogResponse(responseModel);
    }
}
