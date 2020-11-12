////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 11.12.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.command.machine;

import io.swagger.annotations.ApiModel;

/**
 * Model for machine strokes.
 */
@ApiModel("machineStrokes")
public class MachineStrokesRequestBody {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The machine strokes */
    private int mStrokes;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public int getStrokes() {
        return mStrokes;
    }

    public void setStrokes(int strokes) {
        mStrokes = strokes;
    }

}
