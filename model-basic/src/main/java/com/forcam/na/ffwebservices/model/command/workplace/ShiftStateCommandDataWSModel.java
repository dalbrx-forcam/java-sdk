////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 12.12.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.command.workplace;

import com.forcam.na.ffwebservices.model.command.AbstractCommandDataWSModel;
import io.swagger.annotations.ApiModel;

import java.util.Date;

/**
 * Workplace shift state commmand webservice model.
 */
@ApiModel(value = "workplaceShiftStateCommand", parent = AbstractCommandDataWSModel.class)
public class ShiftStateCommandDataWSModel extends AbstractCommandDataWSModel {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------

    public static final String NAME = "WORKPLACE_SHIFT_STATE";

    private static final long serialVersionUID = -6599822345081426624L;

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Persistenz-Id der zugeordneten Arbeitsplatzes */
    private String mWorkplaceId;

    /** Persistenz-Id der zugehörigen Schicht */
    private String mShiftId;

    /** Persistenz-Id der zugeordneten Status */
    private String mShiftStateId;

    /** Persistenz-Id des Typs (F,S,N) der Schicht */
    private String mShiftTypeId;

    /** zugeordnetes Datum des Schicht-Ereignisses festgelegt als UTC */
    private Date mAssociatedDate;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     */
    public ShiftStateCommandDataWSModel() {
        super(NAME);
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public String getWorkplaceId() {
        return mWorkplaceId;
    }

    public void setWorkplaceId(String workplaceId) {
        mWorkplaceId = workplaceId;
    }

    public String getShiftId() {
        return mShiftId;
    }

    public void setShiftId(String shiftId) {
        mShiftId = shiftId;
    }

    public String getShiftTypeId() {
        return mShiftTypeId;
    }

    public void setShiftTypeId(String shiftTypeId) {
        mShiftTypeId = shiftTypeId;
    }

    public Date getAssociatedDate() {
        return mAssociatedDate;
    }

    public void setAssociatedDate(Date associatedDate) {
        mAssociatedDate = associatedDate;
    }

    public String getShiftStateId() {
        return mShiftStateId;
    }

    public void setShiftStateId(String shiftStateId) {
        mShiftStateId = shiftStateId;
    }
}
