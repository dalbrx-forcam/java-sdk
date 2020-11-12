////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 21.02.2020.
//
// Copyright (c) 2006 - 2020 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.specificsettings.request;

import com.forcam.na.ffwebservices.client.api.pagination.request.CollectionRequest;

/**
 * Request for customer specific setting collection.
 */
public class GetCustomerSpecificSettingCollectionRequest extends CollectionRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private String mTopic;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public String getTopic() {
        return mTopic;
    }

    public void setTopic(String topic) {
        mTopic = topic;
    }

}
