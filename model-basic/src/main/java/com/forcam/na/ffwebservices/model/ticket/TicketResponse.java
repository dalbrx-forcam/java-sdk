////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 06.11.2019.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.ticket;

import com.forcam.na.ffwebservices.model.AbstractResponse;

/**
 * The response object for a ticket.
 */
public class TicketResponse extends AbstractResponse {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private TicketPropertiesWSModel mProperties;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public TicketPropertiesWSModel getProperties() {
        return mProperties;
    }

    public void setProperties(TicketPropertiesWSModel properties) {
        mProperties = properties;
    }

}
