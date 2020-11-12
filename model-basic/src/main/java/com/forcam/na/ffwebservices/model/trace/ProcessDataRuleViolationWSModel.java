////////////////////////////////////////////////////////////////////////////////
//
// Created by RGupta on 6/8/2020.
//
// Copyright (c) 2006 - 2020 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.trace;

import java.io.Serializable;

/**
 * Describe the process data violation rule model.
 */
public class ProcessDataRuleViolationWSModel implements Serializable {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------
    /** Serial version id. */
    private static final long serialVersionUID = 6296744318010737917L;
    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Violation rule info. */
    private ViolationWSModel mViolationRuleInfo;

    /** Signal information. */
    private SignalWSModel mSignalInfo;

    /** Unit information. */
    private UnitWSModel mUnitInfo;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public ViolationWSModel getViolationRuleInfo() {
        return mViolationRuleInfo;
    }

    public void setViolationRuleInfo(ViolationWSModel violationRuleInfo) {
        mViolationRuleInfo = violationRuleInfo;
    }

    public SignalWSModel getSignalInfo() {
        return mSignalInfo;
    }

    public void setSignalInfo(SignalWSModel signalInfo) {
        mSignalInfo = signalInfo;
    }

    public UnitWSModel getUnitInfo() {
        return mUnitInfo;
    }

    public void setUnitInfo(UnitWSModel unitInfo) {
        mUnitInfo = unitInfo;
    }
}
