////////////////////////////////////////////////////////////////////////////////
//
// Created by RGupta on 6/17/2020.
//
// Copyright (c) 2006 - 2020 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.trace;

import java.io.Serializable;

/**
 * Represents the signal information.
 */
public class SignalWSModel implements Serializable {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------
    /** Serial version id. */
    private static final long serialVersionUID = 3515032947742160398L;
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
}
