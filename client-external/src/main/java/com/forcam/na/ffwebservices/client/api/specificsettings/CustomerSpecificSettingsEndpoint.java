////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 16.01.2020.
//
// Copyright (c) 2006 - 2020 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.specificsettings;

import com.forcam.na.ffwebservices.client.api.HALCollectionWSModel;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.model.IPathParts;
import com.forcam.na.ffwebservices.model.IRequestAndQueryParams;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface CustomerSpecificSettingsEndpoint {

    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @GET(IPathParts.MASTER_DATA + "/" + IPathParts.CUSTOMER_SPECIFIC_SETTINGS)
    Call<HALCollectionWSModel> getCustomerSpecificSettings(
        @Query(IRequestAndQueryParams.CUSTOM_SPECIFIC_SETTING_TOPIC)
            String topic,
        @Query(IRequestAndQueryParams.LIMIT)
            int limit,
        @Query(IRequestAndQueryParams.OFFSET)
            int offset);

    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @GET(IPathParts.MASTER_DATA + "/" + IPathParts.CUSTOMER_SPECIFIC_SETTINGS + "/{" + IRequestAndQueryParams.CUSTOM_SPECIFIC_SETTING_ID + "}")
    Call<HALWSModel> getCustomerSpecificSetting(
        @Path(IRequestAndQueryParams.CUSTOM_SPECIFIC_SETTING_ID)
            String customSpecificSettingId);

}
