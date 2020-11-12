////////////////////////////////////////////////////////////////////////////////
//
// Created by RGupta on 10/7/2020.
//
// Copyright (c) 2006 - 2020 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.trace;

import java.io.Serializable;

/**
 * Describe the violation webservice model for calculated values.
 */
public class ProcessIndexViolationWSModel implements Serializable {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------
    /** Serial version id.*/
    private static final long serialVersionUID = 4684552144460633413L;
    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------
    /** Calculation method.*/
    private String mCalculationMethod;

    /** Violation level.*/
    private String mViolationLevel;

    /** Violation priority.*/
    private String mViolationPriority;

    /** Calculated value.*/
    private String mCalculatedValue;

    /** Violation min value.*/
    private String mViolationErrorValue;

    /** Violation max value.*/
    private String mViolationWarnValue;

    /** Subject.*/
    private String mSubject;

    /** Text.*/
    private String mText;

    /** Target process mean.*/
    private String mTargetProcessMean;

    /** Upper limit item info.*/
    private TraceItemInfoWSModel mUpperLimitItemInfo;

    /** Lower limit item info.*/
    private TraceItemInfoWSModel mLowerLimitItemInfo;

    /** Derived item info.*/
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

    public String getViolationErrorValue() {
        return mViolationErrorValue;
    }

    public void setViolationErrorValue(String violationErrorValue) {
        mViolationErrorValue = violationErrorValue;
    }

    public String getViolationWarnValue() {
        return mViolationWarnValue;
    }

    public void setViolationWarnValue(String violationWarnValue) {
        mViolationWarnValue = violationWarnValue;
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

    public String getTargetProcessMean() {
        return mTargetProcessMean;
    }

    public void setTargetProcessMean(String targetProcessMean) {
        mTargetProcessMean = targetProcessMean;
    }

    public TraceItemInfoWSModel getUpperLimitItemInfo() {
        return mUpperLimitItemInfo;
    }

    public void setUpperLimitItemInfo(TraceItemInfoWSModel upperLimitItemInfo) {
        mUpperLimitItemInfo = upperLimitItemInfo;
    }

    public TraceItemInfoWSModel getLowerLimitItemInfo() {
        return mLowerLimitItemInfo;
    }

    public void setLowerLimitItemInfo(TraceItemInfoWSModel lowerLimitItemInfo) {
        mLowerLimitItemInfo = lowerLimitItemInfo;
    }

    public TraceItemInfoWSModel getDerivedItemInfo() {
        return mDerivedItemInfo;
    }

    public void setDerivedItemInfo(TraceItemInfoWSModel derivedItemInfo) {
        mDerivedItemInfo = derivedItemInfo;
    }
}
