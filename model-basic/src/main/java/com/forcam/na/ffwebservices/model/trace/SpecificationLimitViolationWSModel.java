////////////////////////////////////////////////////////////////////////////////
//
// Created by RGupta on 10/7/2020.
//
// Copyright (c) 2006 - 2020 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.trace;

import java.io.Serializable;

/**
 * Represents the specification limit violation model.
 */
public class SpecificationLimitViolationWSModel implements Serializable {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------
    /** Serial version id. */
    private static final long serialVersionUID = 777439966531056325L;
    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------
    /** Violation level. */
    private String mViolationLevel;

    /** Violation priority. */
    private String mViolationPriority;

    /** Subject. */
    private String mSubject;

    /** Text. */
    private String mText;

    /** Derived item info. */
    private TraceItemInfoWSModel mViolationItemInfo;

    /** Upper limit item info. */
    private TraceItemInfoWSModel mUpperLimitItemInfo;

    /** Lower limit item info. */
    private TraceItemInfoWSModel mLowerLimitItemInfo;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

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

    public TraceItemInfoWSModel getViolationItemInfo() {
        return mViolationItemInfo;
    }

    public void setViolationItemInfo(TraceItemInfoWSModel violationItemInfo) {
        mViolationItemInfo = violationItemInfo;
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
}
