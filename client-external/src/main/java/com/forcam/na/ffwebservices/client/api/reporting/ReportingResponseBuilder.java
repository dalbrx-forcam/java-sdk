////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 28.11.2019.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.reporting;

import com.forcam.na.ffwebservices.client.api.AbstractResponseBuilder;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.client.api.reporting.response.HitListOperatingStateMaterialResponse;
import com.forcam.na.ffwebservices.client.api.reporting.response.HitListOperatingStateWorkplaceResponse;
import com.forcam.na.ffwebservices.client.api.reporting.response.OverallEquipmentEfficiencyResponse;
import com.forcam.na.ffwebservices.client.api.reporting.response.OverallProcessEfficiencyResponse;
import com.forcam.na.ffwebservices.client.api.reporting.response.QualityDetailsMaterialResponse;
import com.forcam.na.ffwebservices.client.api.reporting.response.QualityDetailsWorkplaceResponse;
import com.forcam.na.ffwebservices.client.api.reporting.response.TotalQuantityResponse;
import com.forcam.na.ffwebservices.model.LinkEmbeddedWSModel;
import com.forcam.na.ffwebservices.model.reporting.HitListOperatingStateMaterialPropertiesWSModel;
import com.forcam.na.ffwebservices.model.reporting.HitListOperatingStateWorkplacePropertiesWSModel;
import com.forcam.na.ffwebservices.model.reporting.OverallEquipmentEfficiencyPropertiesWSModel;
import com.forcam.na.ffwebservices.model.reporting.OverallProcessEfficiencyPropertiesWSModel;
import com.forcam.na.ffwebservices.model.reporting.QualityDetailsMaterialPropertiesWSModel;
import com.forcam.na.ffwebservices.model.reporting.QualityDetailsWorkplacePropertiesWSModel;
import com.forcam.na.ffwebservices.model.reporting.TotalQuantityPropertiesWSModel;

import javax.inject.Inject;

/**
 * Builds responses for reports.
 */
public class ReportingResponseBuilder extends AbstractResponseBuilder implements IReportingResponseBuilder {

    // ------------------------------------------------------------------------
    // constructor
    // ------------------------------------------------------------------------

    @Inject
    public ReportingResponseBuilder() {
        //empty but annotated
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public OverallEquipmentEfficiencyResponse getOverallEquipmentEfficiencyResponse(HALWSModel model) {
        final OverallEquipmentEfficiencyResponse response = new OverallEquipmentEfficiencyResponse();
        final OverallEquipmentEfficiencyPropertiesWSModel properties = mMapper.convertValue(model.getProperties(),
                                                                                            OverallEquipmentEfficiencyPropertiesWSModel.class);
        response.setProperties(properties);

        final LinkEmbeddedWSModel<Object> selfLink = this.createSelfLinkModel(model);
        response.setSelf(selfLink);

        return response;
    }

    @Override
    public OverallProcessEfficiencyResponse getOverallProcessEfficiencyResponse(HALWSModel model) {
        final OverallProcessEfficiencyResponse response = new OverallProcessEfficiencyResponse();
        final OverallProcessEfficiencyPropertiesWSModel properties = mMapper.convertValue(model.getProperties(),
                                                                                          OverallProcessEfficiencyPropertiesWSModel.class);
        response.setProperties(properties);

        final LinkEmbeddedWSModel<Object> selfLink = this.createSelfLinkModel(model);
        response.setSelf(selfLink);

        return response;
    }

    @Override
    public HitListOperatingStateWorkplaceResponse getHitListOperatingStateWorkplaceResponse(HALWSModel model) {
        final HitListOperatingStateWorkplaceResponse response = new HitListOperatingStateWorkplaceResponse();
        final HitListOperatingStateWorkplacePropertiesWSModel properties = mMapper.convertValue(model.getProperties(),
                                                                                                HitListOperatingStateWorkplacePropertiesWSModel.class);
        response.setProperties(properties);

        final LinkEmbeddedWSModel<Object> selfLink = this.createSelfLinkModel(model);
        response.setSelf(selfLink);

        return response;
    }

    @Override
    public HitListOperatingStateMaterialResponse getHitListOperatingStateMaterialResponse(HALWSModel model) {
        final HitListOperatingStateMaterialResponse response = new HitListOperatingStateMaterialResponse();
        final HitListOperatingStateMaterialPropertiesWSModel properties = mMapper.convertValue(model.getProperties(),
                                                                                               HitListOperatingStateMaterialPropertiesWSModel.class);
        response.setProperties(properties);

        final LinkEmbeddedWSModel<Object> selfLink = this.createSelfLinkModel(model);
        response.setSelf(selfLink);

        return response;
    }

    @Override
    public TotalQuantityResponse getQuantityLogResponse(HALWSModel model) {
        final TotalQuantityResponse response = new TotalQuantityResponse();
        final TotalQuantityPropertiesWSModel properties = mMapper.convertValue(model.getProperties(), TotalQuantityPropertiesWSModel.class);
        response.setProperties(properties);

        final LinkEmbeddedWSModel<Object> selfLink = this.createSelfLinkModel(model);
        response.setSelf(selfLink);

        return response;
    }

    @Override
    public QualityDetailsMaterialResponse getQualityDetailsMaterialResponse(HALWSModel model) {
        final QualityDetailsMaterialResponse response = new QualityDetailsMaterialResponse();
        final QualityDetailsMaterialPropertiesWSModel properties = mMapper.convertValue(model.getProperties(), QualityDetailsMaterialPropertiesWSModel.class);
        response.setProperties(properties);

        final LinkEmbeddedWSModel<Object> selfLink = this.createSelfLinkModel(model);
        response.setSelf(selfLink);

        return response;
    }

    @Override
    public QualityDetailsWorkplaceResponse getQualityDetailsWorkplaceResponse(HALWSModel model) {
        final QualityDetailsWorkplaceResponse response = new QualityDetailsWorkplaceResponse();
        final QualityDetailsWorkplacePropertiesWSModel properties = mMapper.convertValue(model.getProperties(), QualityDetailsWorkplacePropertiesWSModel.class);
        response.setProperties(properties);

        final LinkEmbeddedWSModel<Object> selfLink = this.createSelfLinkModel(model);
        response.setSelf(selfLink);

        return response;
    }

}
