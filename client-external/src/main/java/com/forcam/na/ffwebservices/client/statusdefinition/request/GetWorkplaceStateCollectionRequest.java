////////////////////////////////////////////////////////////////////////////////
//
// Created by DZeise on 04.03.2020.
//
// Copyright (c) 2006 - 2020 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.statusdefinition.request;

import com.forcam.na.common.webserviceaccess.util.ToStringUtility;
import com.forcam.na.ffwebservices.client.api.pagination.request.CollectionRequest;
import com.forcam.na.ffwebservices.model.statusdefinition.StatusDefinitionEmbed;

/**
 * Contains values that determine what shall be embedded.
 */
public class GetWorkplaceStateCollectionRequest extends CollectionRequest {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------
    /** Determines what shall be embedded. */
    private StatusDefinitionEmbed mEmbed = new StatusDefinitionEmbed();

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------
    public StatusDefinitionEmbed embed() {
        return mEmbed;
    }

    public void embed(StatusDefinitionEmbed embed) {
        mEmbed = embed;
    }

    @Override
    public String toString() {
        return ToStringUtility
            .newToStringBuilder(this)
            .appendSuper(super.toString())
            .append("embed", mEmbed)
            .toString();
    }

}
