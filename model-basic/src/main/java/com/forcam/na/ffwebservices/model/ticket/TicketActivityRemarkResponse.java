////////////////////////////////////////////////////////////////////////////////
//
// Created by tim on 11.12.19.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.ticket;

import com.forcam.na.ffwebservices.model.AbstractResponse;

/**
 * The response object for a ticket activity remark.
 */
public class TicketActivityRemarkResponse extends AbstractResponse {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------
    private TicketActivityRemarkPropertiesWSModel mProperties;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public TicketActivityRemarkPropertiesWSModel getProperties() {
        return mProperties;
    }

    public void setProperties(TicketActivityRemarkPropertiesWSModel properties) {
        mProperties = properties;
    }
}
