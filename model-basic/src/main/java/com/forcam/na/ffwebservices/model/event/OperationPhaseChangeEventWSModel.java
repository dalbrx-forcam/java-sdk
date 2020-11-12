////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 25.01.2019.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.event;

import com.forcam.na.ffwebservices.model.definition.OperationPhase;

import java.io.Serializable;

/**
 * Model containing information about operation phase change.
 */
public class OperationPhaseChangeEventWSModel implements Serializable {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------

    private static final long serialVersionUID = -7053636696348252077L;

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private OperationPhase mCurrentOperationPhaseId;

    private OperationPhase mPreviousOperationPhaseId;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public OperationPhase getCurrentOperationPhaseId() {
        return mCurrentOperationPhaseId;
    }

    public void setCurrentOperationPhaseId(OperationPhase currentOperationPhaseId) {
        mCurrentOperationPhaseId = currentOperationPhaseId;
    }

    public OperationPhase getPreviousOperationPhaseId() {
        return mPreviousOperationPhaseId;
    }

    public void setPreviousOperationPhaseId(OperationPhase previousOperationPhaseId) {
        mPreviousOperationPhaseId = previousOperationPhaseId;
    }

}
