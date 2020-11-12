////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 20.12.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.literal.request;

import com.forcam.na.ffwebservices.client.api.pagination.request.CollectionRequest;
import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Contains values that determine what shall be embedded.
 */
public class GetLiteralsRequest extends CollectionRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The literal type. */
    private String mType;

    /** The first literal identifier. */
    private String mIdentifier1;

    /** The second literal identifier. */
    private String mIdentifier2;

    /** The third literal identifier. */
    private String mIdentifier3;

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return ToStringUtility.newToStringBuilder(this)
            .appendSuper(super.toString())
            .append("type", mType)
            .append("identifier1", mIdentifier1)
            .append("identifier2", mIdentifier2)
            .append("identifier3", mIdentifier3)
            .toString();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

    public String getIdentifier1() {
        return mIdentifier1;
    }

    public void setIdentifier1(String identifier1) {
        mIdentifier1 = identifier1;
    }

    public String getIdentifier2() {
        return mIdentifier2;
    }

    public void setIdentifier2(String identifier2) {
        mIdentifier2 = identifier2;
    }

    public String getIdentifier3() {
        return mIdentifier3;
    }

    public void setIdentifier3(String identifier3) {
        mIdentifier3 = identifier3;
    }
}