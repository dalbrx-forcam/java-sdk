////////////////////////////////////////////////////////////////////////////////
//
// Created by tim on 09.12.19.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.ticket;

import com.forcam.na.ffwebservices.model.AbstractResponse;

/**
 * The response object for a ticket activity.
 */
public class TicketActivityAttachmentResponse extends AbstractResponse {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------
    private TicketActivityAttachmentPropertiesWSModel mProperties;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public TicketActivityAttachmentPropertiesWSModel getProperties() {
        return mProperties;
    }

    public void setProperties(TicketActivityAttachmentPropertiesWSModel properties) {
        mProperties = properties;
    }
}
