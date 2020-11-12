////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 16.01.2020.
//
// Copyright (c) 2006 - 2020 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.specificsettings;

import com.forcam.na.ffwebservices.client.api.HALCollectionWSModel;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.client.api.pagination.request.CollectionRequest;
import com.forcam.na.ffwebservices.client.api.pagination.response.CollectionResponse;
import com.forcam.na.ffwebservices.client.api.specificsettings.response.CustomerSpecificSettingResponse;

/**
 * Provides methods to build {@link CustomerSpecificSettingResponse}s.
 */
public interface ICustomerSpecificSettingsResponseBuilder {
    CollectionResponse<CustomerSpecificSettingResponse> getCustomerSpecificSettingsResponse(CollectionRequest params, HALCollectionWSModel collectionModel);

    CustomerSpecificSettingResponse getCustomerSpecificSettingResponse(HALWSModel serverModel);
}
