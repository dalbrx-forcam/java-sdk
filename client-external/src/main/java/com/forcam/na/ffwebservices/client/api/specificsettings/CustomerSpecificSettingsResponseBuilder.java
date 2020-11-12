////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 16.01.2020.
//
// Copyright (c) 2006 - 2020 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.specificsettings;

import com.forcam.na.ffwebservices.client.api.AbstractResponseBuilder;
import com.forcam.na.ffwebservices.client.api.HALCollectionWSModel;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.client.api.pagination.request.CollectionRequest;
import com.forcam.na.ffwebservices.client.api.pagination.response.CollectionResponse;
import com.forcam.na.ffwebservices.client.api.specificsettings.response.CustomerSpecificSettingResponse;
import com.forcam.na.ffwebservices.model.LinkEmbeddedWSModel;
import com.forcam.na.ffwebservices.model.specificsettings.CustomerSpecificSettingPropertiesWSModel;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Response builder for {@link CustomerSpecificSettingResponse}.
 */
public class CustomerSpecificSettingsResponseBuilder extends AbstractResponseBuilder implements ICustomerSpecificSettingsResponseBuilder {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------

    /** Key for getting the operation phases from a map. */
    private String CUSTOMER_SPECIFIC_SETTINGS_KEY = "customerSpecificSettings";

    @Inject
    public CustomerSpecificSettingsResponseBuilder() {
        //only inject
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public CollectionResponse<CustomerSpecificSettingResponse> getCustomerSpecificSettingsResponse(CollectionRequest params,
                                                                                                   HALCollectionWSModel collectionModel) {
        final CollectionResponse<CustomerSpecificSettingResponse> collectionResponse = new CollectionResponse<>(params);
        this.initializeCollectionResponse(collectionModel, collectionResponse);

        final Map<String, List<HALWSModel>> embedded = collectionModel.getEmbedded();
        final List<HALWSModel> statusDefinitions = embedded.get(CUSTOMER_SPECIFIC_SETTINGS_KEY);

        final List<CustomerSpecificSettingResponse> settings = statusDefinitions
            .stream()
            .map(this::getCustomerSpecificSettingResponse)
            .collect(Collectors.toList());

        collectionResponse.setEmbedded(settings);
        return collectionResponse;
    }

    @Override
    public CustomerSpecificSettingResponse getCustomerSpecificSettingResponse(HALWSModel serverModel) {
        final CustomerSpecificSettingResponse response = new CustomerSpecificSettingResponse();
        final CustomerSpecificSettingPropertiesWSModel properties = mMapper.convertValue(serverModel.getProperties(),
                                                                                         CustomerSpecificSettingPropertiesWSModel.class);
        response.setProperties(properties);

        final LinkEmbeddedWSModel<Object> selfLink = this.createSelfLinkModel(serverModel);
        response.setSelf(selfLink);

        return response;
    }
}
