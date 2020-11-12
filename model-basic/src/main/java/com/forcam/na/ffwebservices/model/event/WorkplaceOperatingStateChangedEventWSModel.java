////////////////////////////////////////////////////////////////////////////////
//
// Created by DZeise on 12.12.2019.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.event;

import com.forcam.na.ffwebservices.model.definition.WorkplaceState;
import com.forcam.na.ffwebservices.model.statusdefinition.OperatingStateGeneralDefinitionWSModel;

import java.io.Serializable;

/**
 * Model containing information about a workplace operating state change.
 */
public class WorkplaceOperatingStateChangedEventWSModel implements Serializable {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------

    private static final long serialVersionUID = 7013639744115709138L;

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private WorkplaceState mPreviousWorkplaceStateId;
    private WorkplaceState mCurrentWorkplaceStateId;
    private OperatingStateGeneralDefinitionWSModel mCurrentOperatingState;
    private OperatingStateGeneralDefinitionWSModel mPreviousOperatingState;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public WorkplaceState getCurrentWorkplaceStateId() {
        return mCurrentWorkplaceStateId;
    }

    public void setCurrentWorkplaceStateId(WorkplaceState currentWorkplaceStateId) {
        mCurrentWorkplaceStateId = currentWorkplaceStateId;
    }

    public WorkplaceState getPreviousWorkplaceStateId() {
        return mPreviousWorkplaceStateId;
    }

    public void setPreviousWorkplaceStateId(WorkplaceState previousWorkplaceStateId) {
        mPreviousWorkplaceStateId = previousWorkplaceStateId;
    }

    public OperatingStateGeneralDefinitionWSModel getCurrentOperatingState() {
        return mCurrentOperatingState;
    }

    public void setCurrentOperatingState(OperatingStateGeneralDefinitionWSModel currentOperatingState) {
        mCurrentOperatingState = currentOperatingState;
    }

    public OperatingStateGeneralDefinitionWSModel getPreviousOperatingState() {
        return mPreviousOperatingState;
    }

    public void setPreviousOperatingState(OperatingStateGeneralDefinitionWSModel previousOperatingState) {
        mPreviousOperatingState = previousOperatingState;
    }
}
