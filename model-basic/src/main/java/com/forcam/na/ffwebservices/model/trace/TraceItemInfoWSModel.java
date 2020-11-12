////////////////////////////////////////////////////////////////////////////////
//
// Created by RGupta on 10/7/2020.
//
// Copyright (c) 2006 - 2020 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.trace;

import java.io.Serializable;

/**
 * This describe the trace item information.
 */
public class TraceItemInfoWSModel implements Serializable {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------
    /** Serial version id. */
    private static final long serialVersionUID = 797907116457502780L;
    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------
    /** Controller name. */
    private String mController;

    /** Signal group. */
    private String mSignalGroup;

    /** Signal name. */
    private String mSignalName;

    /** Delivered signal value. */
    private String mDeliveredSignalValue;

    /** Base signal value. */
    private String mBaseSignalValue;

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

    public String getController() {
        return mController;
    }

    public void setController(String controller) {
        mController = controller;
    }

    public String getSignalGroup() {
        return mSignalGroup;
    }

    public void setSignalGroup(String signalGroup) {
        mSignalGroup = signalGroup;
    }

    public String getSignalName() {
        return mSignalName;
    }

    public void setSignalName(String signalName) {
        mSignalName = signalName;
    }

    public String getDeliveredSignalValue() {
        return mDeliveredSignalValue;
    }

    public void setDeliveredSignalValue(String deliveredSignalValue) {
        mDeliveredSignalValue = deliveredSignalValue;
    }

    public String getBaseSignalValue() {
        return mBaseSignalValue;
    }

    public void setBaseSignalValue(String baseSignalValue) {
        mBaseSignalValue = baseSignalValue;
    }

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
