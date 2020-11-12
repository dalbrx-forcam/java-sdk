////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 13.08.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.device;

import com.forcam.na.ffwebservices.client.api.AbstractResponseBuilder;
import com.forcam.na.ffwebservices.client.api.HALCollectionWSModel;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.client.api.device.request.GetDeviceRecordedTimeSeriesRequest;
import com.forcam.na.ffwebservices.client.api.device.response.DeviceRecordedTimeSeriesCollectionResponse;
import com.forcam.na.ffwebservices.client.api.literal.LiteralLinkModelBuilder;
import com.forcam.na.ffwebservices.client.api.pagination.request.PaginationRequest;
import com.forcam.na.ffwebservices.client.api.pagination.response.CollectionResponse;
import com.forcam.na.ffwebservices.model.LinkEmbeddedWSModel;
import com.forcam.na.ffwebservices.model.device.DeviceEmbed;
import com.forcam.na.ffwebservices.model.device.DeviceLocationPropertiesWSModel;
import com.forcam.na.ffwebservices.model.device.DevicePropertiesWSModel;
import com.forcam.na.ffwebservices.model.device.DeviceRecordedTimeSeriesCollectionPropertiesWSModel;
import com.forcam.na.ffwebservices.model.device.DeviceResponse;
import com.forcam.na.ffwebservices.model.literal.LiteralPropertiesWSModel;
import org.apache.commons.collections.MapUtils;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Response builder for devices.
 */
public class DeviceResponseBuilder extends AbstractResponseBuilder implements IDeviceResponseBuilder {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The link model builder for literals. */
    private final LiteralLinkModelBuilder mLiteralLinkModelBuilder;

    /** The link model builder for device locations. */
    private final DeviceLocationLinkModelBuilder mDeviceLocationLinkModelBuilder;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     *
     * @param literalLinkModelBuilder        Literal link model builder.
     * @param deviceLocationLinkModelBuilder The device location link model builder.
     */
    @Inject
    public DeviceResponseBuilder(LiteralLinkModelBuilder literalLinkModelBuilder, DeviceLocationLinkModelBuilder deviceLocationLinkModelBuilder) {
        mLiteralLinkModelBuilder = literalLinkModelBuilder;
        mDeviceLocationLinkModelBuilder = deviceLocationLinkModelBuilder;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public CollectionResponse<DeviceResponse> getDeviceCollectionResponse(PaginationRequest request, HALCollectionWSModel collectionModel) {
        final CollectionResponse<DeviceResponse> collectionResponse = new CollectionResponse<>(request);
        this.initializeCollectionResponse(collectionModel, collectionResponse);

        final Map<String, List<HALWSModel>> embedded = collectionModel.getEmbedded();
        if (MapUtils.isNotEmpty(embedded)) {
            final List<HALWSModel> devices = embedded.get("devices");

            final List<DeviceResponse> deviceResponseList = devices
                .stream()
                .map(this::getDeviceResponse)
                .collect(Collectors.toList());

            collectionResponse.setEmbedded(deviceResponseList);
        }
        return collectionResponse;
    }

    @Override
    public DeviceResponse getDeviceResponse(HALWSModel serverModel) {
        final DeviceResponse deviceResponse = new DeviceResponse();
        final DevicePropertiesWSModel properties = mMapper.convertValue(serverModel.getProperties(), DevicePropertiesWSModel.class);
        deviceResponse.setProperties(properties);

        final LinkEmbeddedWSModel<Object> selfLink = this.createSelfLinkModel(serverModel);
        deviceResponse.setSelf(selfLink);

        final LinkEmbeddedWSModel<LiteralPropertiesWSModel> description = mLiteralLinkModelBuilder.buildLinkModel(serverModel, DeviceEmbed.DESCRIPTION);
        deviceResponse.setDescription(description);

        final LinkEmbeddedWSModel<DeviceLocationPropertiesWSModel> location = mDeviceLocationLinkModelBuilder.buildLinkModel(serverModel, DeviceEmbed.LOCATION);
        deviceResponse.setLocation(location);

        return deviceResponse;
    }

    @Override
    public DeviceRecordedTimeSeriesCollectionResponse getDeviceRecordedTimeSeries(GetDeviceRecordedTimeSeriesRequest request, HALWSModel serverModel) {
        final DeviceRecordedTimeSeriesCollectionResponse response = new DeviceRecordedTimeSeriesCollectionResponse(request);
        response.setProperties(mMapper.convertValue(serverModel.getProperties(), DeviceRecordedTimeSeriesCollectionPropertiesWSModel.class));
        response.setPagination(serverModel.getPagination());
        response.setPaginationLinks(serverModel.getLinkModels());

        return response;
    }
}