////////////////////////////////////////////////////////////////////////////////
//
// Created by tim on 18.11.19.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.ticket;

import com.forcam.na.ffwebservices.model.AbstractResponse;

/**
 * The response object for a ticket attachment.
 */
public class TicketAttachmentResponse extends AbstractResponse {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------
    private TicketAttachmentPropertiesWSModel mProperties;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public TicketAttachmentPropertiesWSModel getProperties() {
        return mProperties;
    }

    public void setProperties(TicketAttachmentPropertiesWSModel properties) {
        mProperties = properties;
    }

}
