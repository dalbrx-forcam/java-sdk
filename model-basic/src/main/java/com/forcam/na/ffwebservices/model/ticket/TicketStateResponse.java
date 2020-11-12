////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 27.11.2019.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.ticket;

import com.forcam.na.ffwebservices.model.AbstractResponse;
import com.forcam.na.ffwebservices.model.LinkEmbeddedWSModel;
import com.forcam.na.ffwebservices.model.literal.LiteralPropertiesWSModel;

/**
 * The response object for a ticket state.
 */
public class TicketStateResponse extends AbstractResponse {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private TicketStatePropertiesWSModel mProperties;
    private LinkEmbeddedWSModel<LiteralPropertiesWSModel> mName;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public TicketStatePropertiesWSModel getProperties() {
        return mProperties;
    }

    public void setProperties(TicketStatePropertiesWSModel properties) {
        mProperties = properties;
    }

    public void setName(LinkEmbeddedWSModel<LiteralPropertiesWSModel> name) {
        mName = name;
    }

    public LinkEmbeddedWSModel<LiteralPropertiesWSModel> getName() {
        return mName;
    }
}
