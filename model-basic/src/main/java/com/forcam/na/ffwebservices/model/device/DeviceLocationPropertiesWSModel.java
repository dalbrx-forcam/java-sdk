////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 04.12.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.device;

import com.forcam.na.ffwebservices.model.definition.GeoCoordinates;
import com.forcam.na.ffwebservices.model.workplace.WorkplaceGeneralDefinitionWSModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The device location model.
 */
@ApiModel("deviceLocationProperties")
public class DeviceLocationPropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The workplace to which the device be-longs, if the device belongs to a workplace. */
    private WorkplaceGeneralDefinitionWSModel mWorkplace;

    /** Geo coordinates. */
    private GeoCoordinates mGeoCoordinates;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public WorkplaceGeneralDefinitionWSModel getWorkplace() {
        return mWorkplace;
    }

    @ApiModelProperty(value = "Workplace to which the device belongs, if the device belongs to a workplace")
    public void setWorkplace(WorkplaceGeneralDefinitionWSModel workplace) {
        mWorkplace = workplace;
    }

    public GeoCoordinates getGeoCoordinates() {
        return mGeoCoordinates;
    }

    @ApiModelProperty(value = "Geographical coordinates of the device")
    public void setGeoCoordinates(GeoCoordinates geoCoordinatesWSModel) {
        mGeoCoordinates = geoCoordinatesWSModel;
    }
}
