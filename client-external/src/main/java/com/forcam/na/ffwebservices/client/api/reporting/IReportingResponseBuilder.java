////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 28.11.2019.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.reporting;

import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.client.api.reporting.response.HitListOperatingStateMaterialResponse;
import com.forcam.na.ffwebservices.client.api.reporting.response.HitListOperatingStateWorkplaceResponse;
import com.forcam.na.ffwebservices.client.api.reporting.response.OverallEquipmentEfficiencyResponse;
import com.forcam.na.ffwebservices.client.api.reporting.response.OverallProcessEfficiencyResponse;
import com.forcam.na.ffwebservices.client.api.reporting.response.QualityDetailsMaterialResponse;
import com.forcam.na.ffwebservices.client.api.reporting.response.QualityDetailsWorkplaceResponse;
import com.forcam.na.ffwebservices.client.api.reporting.response.TotalQuantityResponse;

/**
 * Contains methods for building responses for reports.
 */
public interface IReportingResponseBuilder {

    OverallEquipmentEfficiencyResponse getOverallEquipmentEfficiencyResponse(HALWSModel responseModel);

    OverallProcessEfficiencyResponse getOverallProcessEfficiencyResponse(HALWSModel responseModel);

    HitListOperatingStateWorkplaceResponse getHitListOperatingStateWorkplaceResponse(HALWSModel responseModel);

    HitListOperatingStateMaterialResponse getHitListOperatingStateMaterialResponse(HALWSModel responseModel);

    TotalQuantityResponse getQuantityLogResponse(HALWSModel responseModel);

    QualityDetailsMaterialResponse getQualityDetailsMaterialResponse(HALWSModel responseModel);

    QualityDetailsWorkplaceResponse getQualityDetailsWorkplaceResponse(HALWSModel responseModel);
}
