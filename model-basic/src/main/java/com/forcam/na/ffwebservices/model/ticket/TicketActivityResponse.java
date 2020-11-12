////////////////////////////////////////////////////////////////////////////////
//
// Created by tim on 29.11.19.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.ticket;

import com.forcam.na.ffwebservices.model.AbstractResponse;

/**
 * The response object for a ticket activity.
 */
public class TicketActivityResponse extends AbstractResponse {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private TicketActivityPropertiesWSModel mProperties;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public TicketActivityPropertiesWSModel getProperties() {
        return mProperties;
    }

    public void setProperties(TicketActivityPropertiesWSModel properties) {
        mProperties = properties;
    }
}
