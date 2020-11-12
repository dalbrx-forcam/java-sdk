////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 20.12.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.tool.request;

import com.forcam.na.ffwebservices.client.api.pagination.request.CollectionRequest;
import com.forcam.na.ffwebservices.model.tool.ToolEmbed;
import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Contains values that determine what shall be embedded.
 */
public class GetToolsRequest extends CollectionRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Determines what shall be embedded. */
    private ToolEmbed mEmbed = new ToolEmbed();

    /** The first tool identifier. */
    private String identifier;

    /** The second tool identifier. */
    private String identifier2;

    /** The third tool identifier. */
    private String identifier3;

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    public ToolEmbed embed() {
        return mEmbed;
    }

    public void embed(ToolEmbed embed) {
        mEmbed = embed;
    }

    @Override
    public String toString() {
        return ToStringUtility.newToStringBuilder(this)
            .appendSuper(super.toString())
            .append("identifier", identifier)
            .append("identifier2", identifier2)
            .append("identifier3", identifier3)
            .append("embed", mEmbed)
            .toString();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getIdentifier2() {
        return identifier2;
    }

    public void setIdentifier2(String identifier2) {
        this.identifier2 = identifier2;
    }

    public String getIdentifier3() {
        return identifier3;
    }

    public void setIdentifier3(String identifier3) {
        this.identifier3 = identifier3;
    }
}