////////////////////////////////////////////////////////////////////////////////
//
// Created by RGupta on 6/17/2020.
//
// Copyright (c) 2006 - 2020 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.trace;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * Defines the unit structure.
 */
public class UnitWSModel implements Serializable {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------
    /** Serial version is. */
    private static final long serialVersionUID = 1520329774526976160L;
    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Translated base unit symbol. */
    private String mBaseUnitSymbol;

    /** Base unit mnemonic. */
    private String mBaseUnitMnemonic;

    /** Physical unit mnemonic. */
    private String mPhysicalUnitMnemonic;

    /** Delivered unit symbol. */
    private String mDeliveredUnitSymbol;

    /** Delivered unit mnemonic. */
    private String mDeliveredUnitMnemonic;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public String getBaseUnitSymbol() {
        return mBaseUnitSymbol;
    }

    public void setBaseUnitSymbol(String baseUnitSymbol) {
        mBaseUnitSymbol = baseUnitSymbol;
    }

    public String getBaseUnitMnemonic() {
        return mBaseUnitMnemonic;
    }

    public void setBaseUnitMnemonic(String baseUnitMnemonic) {
        mBaseUnitMnemonic = baseUnitMnemonic;
    }

    public String getPhysicalUnitMnemonic() {
        return mPhysicalUnitMnemonic;
    }

    public void setPhysicalUnitMnemonic(String physicalUnitMnemonic) {
        mPhysicalUnitMnemonic = physicalUnitMnemonic;
    }

    public String getDeliveredUnitSymbol() {
        return mDeliveredUnitSymbol;
    }

    public void setDeliveredUnitSymbol(String deliveredUnitSymbol) {
        mDeliveredUnitSymbol = deliveredUnitSymbol;
    }

    public String getDeliveredUnitMnemonic() {
        return mDeliveredUnitMnemonic;
    }

    public void setDeliveredUnitMnemonic(String deliveredUnitMnemonic) {
        mDeliveredUnitMnemonic = deliveredUnitMnemonic;
    }
}
