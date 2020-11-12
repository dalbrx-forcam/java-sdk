////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 28.11.2019.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.reporting;

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

/**
 * Provides methods to request reporting data.
 */
public interface IReportingClient {

    /**
     * Sends a request to the server and gets a {@link OverallEquipmentEfficiencyResponse} model as response.
     *
     * @param request The request parameters.
     * @return A {@link OverallEquipmentEfficiencyResponse}.
     * @throws ForceAPIException When unable to the response.
     */
    OverallEquipmentEfficiencyResponse getOverallEquipmentEfficiency(GetOverallEquipmentEfficiencyRequest request) throws ForceAPIException;

    /**
     * Sends a request to the server and gets a {@link OverallProcessEfficiencyResponse} model as response.
     *
     * @param request The request parameters.
     * @return A {@link OverallProcessEfficiencyResponse}.
     * @throws ForceAPIException When unable to the response.
     */
    OverallProcessEfficiencyResponse getOverallProcessEfficiency(GetOverallProcessEfficiencyRequest request) throws ForceAPIException;

    /**
     * Sends a request to the server and gets a {@link HitListOperatingStateWorkplaceResponse} model as response.
     *
     * @param request The request parameters.
     * @return A {@link HitListOperatingStateMaterialResponse}.
     * @throws ForceAPIException When unable to the response.
     */
    HitListOperatingStateWorkplaceResponse getHitListOperatingStateWorkplace(GetHitListOperatingStateWorkplaceRequest request) throws ForceAPIException;

    /**
     * Sends a request to the server and gets a {@link HitListOperatingStateMaterialResponse} model as response.
     *
     * @param request The request parameters.
     * @return A {@link HitListOperatingStateMaterialResponse}.
     * @throws ForceAPIException When unable to the response.
     */
    HitListOperatingStateMaterialResponse getHitListOperatingStateMaterial(GetHitListOperatingStateMaterialRequest request) throws ForceAPIException;

    /**
     * Sends a request to the server and gets a {@link QualityDetailsMaterialResponse} model as response.
     *
     * @param request The request parameters.
     * @return A {@link QualityDetailsMaterialResponse}.
     * @throws ForceAPIException When unable to the response.
     */
    QualityDetailsMaterialResponse getQualityDetailsMaterial(GetQualityDetailsMaterialRequest request) throws ForceAPIException;

    /**
     * Sends a request to the server and gets a {@link QualityDetailsWorkplaceResponse} model as response.
     *
     * @param request The request parameters.
     * @return A {@link QualityDetailsWorkplaceResponse}.
     * @throws ForceAPIException When unable to the response.
     */
    QualityDetailsWorkplaceResponse getQualityDetailsWorkplace(GetQualityDetailsWorkplaceRequest request) throws ForceAPIException;

    /**
     * Sends a request to the server and gets a {@link TotalQuantityResponse} model as response.
     *
     * @param request The request parameters.
     * @return A {@link TotalQuantityResponse}.
     * @throws ForceAPIException When unable to the response.
     */
    TotalQuantityResponse getTotalQuantity(GetTotalQuantityRequest request) throws ForceAPIException;
}
