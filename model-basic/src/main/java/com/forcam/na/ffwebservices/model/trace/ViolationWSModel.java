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
 * This represents the violation configuration.
 */
public class ViolationWSModel implements Serializable {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------
    /** Serial version id. */
    private static final long serialVersionUID = -4832287179148852197L;
    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------
    /** Violation rule name. */
    private String mRuleName;

    /** Violation level. */
    private String mLevel;

    /** Violation priority. */
    private String mPriority;

    /** Violation range. */
    private String mRange;

    /** Violation value. */
    private String mViolationValue;

    /** Violation max value. */
    private String mViolationMaxValue;

    /** Translated violation rule subject. */
    private String mSubject;

    /** Translated violation rule text. */
    private String mText;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public String getRuleName() {
        return mRuleName;
    }

    public void setRuleName(String ruleName) {
        mRuleName = ruleName;
    }

    public String getLevel() {
        return mLevel;
    }

    public void setLevel(String level) {
        mLevel = level;
    }

    public String getPriority() {
        return mPriority;
    }

    public void setPriority(String priority) {
        mPriority = priority;
    }

    public String getRange() {
        return mRange;
    }

    public void setRange(String range) {
        mRange = range;
    }

    public String getViolationValue() {
        return mViolationValue;
    }

    public void setViolationValue(String violationValue) {
        mViolationValue = violationValue;
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
}
