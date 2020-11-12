////////////////////////////////////////////////////////////////////////////////
//
// Created by RGupta on 6/18/2020.
//
// Copyright (c) 2006 - 2020 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.trace;

import java.io.Serializable;

/**
 * Represents the warehouse ERP key structure.
 */
public class WarehouseERPWSModel implements Serializable {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------
    /** Serial version id. */
    private static final long serialVersionUID = 4633584492626993070L;

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------
    /** ERP System identifier. */
    private String mERPKeySystemNumber;

    /** ERP Client. */
    private String mERPKeyIdentifier1;

    /** ERP Company code. */
    private String mERPKeyIdentifier2;

    /** ERP Plant. */
    private String mERPKeyIdentifier3;

    /** ERP key id. */
    private String mERPKeyId;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public String getERPKeyId() {
        return mERPKeyId;
    }

    public void setERPKeyId(String erpKeyId) {
        mERPKeyId = erpKeyId;
    }

    public String getERPKeySystemNumber() {
        return mERPKeySystemNumber;
    }

    public void setERPKeySystemNumber(String erpKeySystemNumber) {
        mERPKeySystemNumber = erpKeySystemNumber;
    }

    public String getERPKeyIdentifier1() {
        return mERPKeyIdentifier1;
    }

    public void setERPKeyIdentifier1(String erpKeyIdentifier1) {
        mERPKeyIdentifier1 = erpKeyIdentifier1;
    }

    public String getERPKeyIdentifier2() {
        return mERPKeyIdentifier2;
    }

    public void setERPKeyIdentifier2(String erpKeyIdentifier2) {
        mERPKeyIdentifier2 = erpKeyIdentifier2;
    }

    public String getERPKeyIdentifier3() {
        return mERPKeyIdentifier3;
    }

    public void setERPKeyIdentifier3(String erpKeyIdentifier3) {
        mERPKeyIdentifier3 = erpKeyIdentifier3;
    }
}
