////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 20.12.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.erpcontext.request;

import com.forcam.na.ffwebservices.client.api.pagination.request.CollectionRequest;
import com.forcam.na.ffwebservices.model.erpcontext.ERPContextType;
import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Contains values that determine what shall be embedded.
 */
public class GetErpContextsRequest extends CollectionRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The first identifier. For SAP it is the client. */
    private String mIdentifier1;

    /** The second identifier. For SAP it is the company code. */
    private String mIdentifier2;

    /** The third identifier. For SAP it is the plant or personnel area. */
    private String mIdentifier3;

    /** The ERP system. */
    private String mSystem;

    /** The ERP context type. */
    private ERPContextType mType;

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return ToStringUtility.newToStringBuilder(this).appendSuper(super.toString()).append("identifier1", mIdentifier1).append(
            "identifier2",
            mIdentifier2).append("identifier3", mIdentifier3).append("system", mSystem).append("type", mType).toString();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

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

    public String getSystem() {
        return mSystem;
    }

    public void setSystem(String system) {
        mSystem = system;
    }

    /**
     * Provides the ERP context type.
     *
     * @return The ERP context type.
     */
    public ERPContextType getType() {
        return mType;
    }

    /**
     * Sets the ERP context type.
     *
     * @param type The ERP context type.
     */
    public void setType(ERPContextType type) {
        mType = type;
    }
}