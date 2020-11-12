////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 16.01.2020.
//
// Copyright (c) 2006 - 2020 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.specificsettings.request;

/**
 * Request for customer specific setting.
 */
public class GetCustomerSpecificSettingRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private String mId;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    public GetCustomerSpecificSettingRequest(String id) { mId = id; }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public String getId() {
        return mId;
    }

}
