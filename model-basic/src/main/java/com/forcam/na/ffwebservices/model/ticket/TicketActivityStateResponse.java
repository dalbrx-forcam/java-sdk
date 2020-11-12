////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 27.11.2019.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.ticket;

import com.forcam.na.ffwebservices.model.AbstractResponse;

/**
 * The response object for a ticket activity state.
 */
public class TicketActivityStateResponse extends AbstractResponse {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private TicketActivityStatePropertiesWSModel mProperties;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public TicketActivityStatePropertiesWSModel getProperties() {
        return mProperties;
    }

    public void setProperties(TicketActivityStatePropertiesWSModel properties) {
        mProperties = properties;
    }

}
