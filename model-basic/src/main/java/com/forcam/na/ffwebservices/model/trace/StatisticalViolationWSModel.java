////////////////////////////////////////////////////////////////////////////////
//
// Created by RGupta on 10/7/2020.
//
// Copyright (c) 2006 - 2020 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.trace;

import java.io.Serializable;

/**
 * The describe the violation info for statistical.
 */
public class StatisticalViolationWSModel implements Serializable {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------
    /** Serial version id. */
    private static final long serialVersionUID = -4589765177875667930L;
    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------
    /** Calculation method. */
    private String mCalculationMethod;

    /** Violation level. */
    private String mViolationLevel;

    /** Violation priority. */
    private String mViolationPriority;

    /** Calculated value. */
    private String mCalculatedValue;

    /** Violation min value. */
    private String mViolationMinValue;

    /** Violation max value. */
    private String mViolationMaxValue;

    /** Subject. */
    private String mSubject;

    /** Text. */
    private String mText;

    /** Derived item info. */
    private TraceItemInfoWSModel mDerivedItemInfo;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public String getCalculationMethod() {
        return mCalculationMethod;
    }

    public void setCalculationMethod(String calculationMethod) {
        mCalculationMethod = calculationMethod;
    }

    public String getViolationLevel() {
        return mViolationLevel;
    }

    public void setViolationLevel(String violationLevel) {
        mViolationLevel = violationLevel;
    }

    public String getViolationPriority() {
        return mViolationPriority;
    }

    public void setViolationPriority(String violationPriority) {
        mViolationPriority = violationPriority;
    }

    public String getCalculatedValue() {
        return mCalculatedValue;
    }

    public void setCalculatedValue(String calculatedValue) {
        mCalculatedValue = calculatedValue;
    }

    public String getViolationMinValue() {
        return mViolationMinValue;
    }

    public void setViolationMinValue(String violationMinValue) {
        mViolationMinValue = violationMinValue;
    }

    public String getViolationMaxValue() {
        return mViolationMaxValue;
    }

    public void setViolationMaxValue(String violationMaxValue) {
        mViolationMaxValue = violationMaxValue;
    }

    public String getSubject() {
        return mSubject;
    }

    public void setSubject(String subject) {
        mSubject = subject;
    }

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        mText = text;
    }

    public TraceItemInfoWSModel getDerivedItemInfo() {
        return mDerivedItemInfo;
    }

    public void setDerivedItemInfo(TraceItemInfoWSModel derivedItemInfo) {
        mDerivedItemInfo = derivedItemInfo;
    }
}
