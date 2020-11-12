////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 20.09.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.operation.operationplanning.request;

/**
 * Request parameter for getting all operations forecast results.
 */
public class GetOperationsForecastResultsRequest extends GetOperationsPlanningResultsRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** If this flag is set, the original forecast is used instead of the online forecast for operations that are being processed (default value: “false”). */
    private boolean mUseOriginalValues;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public boolean isUseOriginalValues() {
        return mUseOriginalValues;
    }

    public void setUseOriginalValues(boolean useOriginalValues) {
        mUseOriginalValues = useOriginalValues;
    }
}